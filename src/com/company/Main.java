package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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
        String url = "https://cat-fact.herokuapp.com/facts";
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

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonToList = String.valueOf(result);

            List<BlogAddOperations> blogAddOperations;
            blogAddOperations = objectMapper.readValue(jsonToList, new TypeReference<List<BlogAddOperations>>() {
            });
            for (BlogAddOperations blogAddOperations1: blogAddOperations) {
                System.out.println(blogAddOperations1+"\n");
            }








        }
    }

}