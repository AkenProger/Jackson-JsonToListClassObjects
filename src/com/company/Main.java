package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://jsonplaceholder.typicode.com/posts";
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        httpURLConnection.setRequestMethod("GET");

        int resultStatusCode = httpURLConnection.getResponseCode();
        System.out.println("Запрос отправлен на адрес: " + url);
        System.out.println("Код ответа:" + resultStatusCode);

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()))) {
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

           Gson gson = new GsonBuilder()
                    .setPrettyPrinting().create();

            String classToJson = String.valueOf(result);
               //toList
            List<BlogPostDetails>  blogPostDetailsList;
            blogPostDetailsList = gson.fromJson(classToJson, new TypeToken<List<BlogPostDetails>>(){}.getType());
            System.out.println("List ->"+blogPostDetailsList);

            //toArrayClass
            BlogPostDetails[] blogPostDetails = gson.fromJson(classToJson, new TypeToken<BlogPostDetails[]>(){}.getType());


            for (BlogPostDetails blogPostDetails1: blogPostDetails) {
                System.out.println(" ID = "+blogPostDetails1.getId());
                System.out.println(" TITLE = "+blogPostDetails1.getTitle());
                System.out.println(" BODY "+blogPostDetails1.getBody());

            }

        }
    }

}