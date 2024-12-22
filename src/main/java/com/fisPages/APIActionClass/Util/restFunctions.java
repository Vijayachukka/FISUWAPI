package com.fisPages.APIActionClass.Util;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Component
@Scope("cucumber-glue")
public class restFunctions {
    protected RequestSpecification requestSpecification;
    protected DocumentContext documentContext;
    public Response response;
    public void setRequestSpecification(RequestSpecification spec)
    {
        this.requestSpecification=spec;
    }
    public DocumentContext getDocumentContext()
    {
        return documentContext;
    }
    protected void setDocumentContext(DocumentContext context)
    {
        this.documentContext=context;
    }
    public RequestSpecification getRequestSpecification()
    {
        return requestSpecification;
    }
    public Response getResponse()
    {
        return this.response;
    }
    protected void setResponse(Response res)
    {
        this.response=res;
    }
    public void post(String url, boolean body)
    {
        this.setRequestSpecification(RestAssured.given());
        if(body)
        {
            InputStream CreateEmp = getFileAsResource("JsonData/CreateEmp.json");
            //parser.parse(new FileReader("C:/Users/Vijay/Documents/GitHub/sci-api-bdd/src/main/resources/JsonData/CreateEmp.json"));

            this.setDocumentContext(JsonPath.parse(CreateEmp));
            System.out.println(getDocumentContext().jsonString());
            this.setRequestSpecification(this.getRequestSpecification().body(getDocumentContext().jsonString()));
        }
        this.setResponse(this.getRequestSpecification().when().post(url));
        System.out.println("get response is :"+this.getResponse().asPrettyString());

    }
    public InputStream getFileAsResource(String fileName)
    {
        ClassLoader classLoader=this.getClass().getClassLoader();
        InputStream inputStream=classLoader.getResourceAsStream(fileName);
        if(inputStream== null)
        {
            throw new IllegalArgumentException("file not found "+fileName);
        }
        else
        {
            return inputStream;
        }
    }
    public void get(String url)
    {
        this.setRequestSpecification(RestAssured.given());
        this.setResponse(this.getRequestSpecification().when().get(url));
        System.out.println("get response is :"+this.getResponse().asPrettyString());

    }

}
