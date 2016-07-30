/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.spark;

import com.spring.model.MyMessage;
import static spark.Spark.*;

/**
 *
 * @author aleksandar
 */
public class SparkApplication implements spark.servlet.SparkApplication {

    @Override
    public void init() {
        
        before((request, response) -> {
            System.out.println("before 1 request: " + request.uri());
        });
        
        before((request, response) -> {
            System.out.println("before 2 request: " + request.uri());
        });
        
        before((request, response) -> {
            System.out.println("before 3 request: " + request.uri());
        });

        get("/hello", (req, res) -> "Hello World from Spark");
        
        get("/mesage", "application/json", (request, response) -> {
            return new MyMessage(1, "Hello World");
        }, new JsonTransformer());
        
        // matches "GET /hello/foo" and "GET /hello/bar"
        // request.params(":name") is 'foo' or 'bar'
        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
        
        after((request, response) -> {
            response.header("foo", "set by after filter");
        });
     
        after((request, response) -> {
            response.header("Content-Encoding", "gzip");
        });
    }
    
}
