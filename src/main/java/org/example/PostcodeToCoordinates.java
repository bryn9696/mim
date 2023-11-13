package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class PostcodeToCoordinates {
    public static double[] coordinates() {
        // Specify the postcode for which you want to retrieve coordinates
        float postcode = inputs.askForInput(); // Replace with the desired postcode

        // Construct the API request URL
        String apiUrl = "https://api.postcodes.io/postcodes/" + postcode;

        // Send the API request
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        double[] coOrds = new double[]{};

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Gson gson = new Gson();
                PostcodeResponse postcodeResponse = gson.fromJson(jsonResponse, PostcodeResponse.class);

                if (postcodeResponse.status.equals("200")) {
                    // Coordinates can be accessed using getLongitude() and getLatitude()
                    double longitude = postcodeResponse.result.longitude;
                    double latitude = postcodeResponse.result.latitude;
                    coOrds[0] = longitude;
                    coOrds[0] = latitude;

                } else {
                    System.out.println("Error: " + postcodeResponse.status);
                }
            } else {
                System.err.println("HTTP Request Error: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return coOrds;
    }
}

class PostcodeResponse {
    String status;
    PostcodeResult result;
}

class PostcodeResult {
    double longitude;
    double latitude;
}

