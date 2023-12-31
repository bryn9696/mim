package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RouteDistanceCalculator {
            public static void main(String[] args) throws IOException {
                // Get user input for two locations (latitude and longitude coordinates)

                double startLat = inputs.askForInput();
                double startLng = inputs.askForInput();
                double endLat = inputs.askForInput();
                double endLng = inputs.askForInput();
                // Construct the API request URL with waypoints and API key
                String apiKey = "03b5ad22508d4090a7424a1976620e4a"; // Replace with your Geoapify API key
                String apiUrl = "https://api.geoapify.com/v1/routing?";
                String waypoints = startLat + "%2C" + startLng + "%7C" + endLat + "%2C" + endLng;
                String mode = "drive"; // change the mode based on requirements

                String requestUrl = apiUrl + "waypoints=" + waypoints + "&mode=" + mode + "&apiKey=" + apiKey;
                // Send the API request
                OkHttpClient client = new OkHttpClient().newBuilder().build();
                Request request = new Request.Builder()
                        .url(requestUrl)
                        .method("GET", null)
                        .build();
                Response response = client.newCall(request).execute();

                if (response.isSuccessful()) {
                    String jsonResponse = response.body().string();
                    Gson gson = new Gson();
                    RouteModel routeModel = gson.fromJson(jsonResponse, RouteModel.class);
                    System.out.println(routeModel.getFeatures().get(0).getProperties().getDistance());
                    // Extract and display the distance from the routeModel
                    double distance = routeModel.getFeatures().get(0).getProperties().getDistance();
                    String distanceUnits = routeModel.getFeatures().get(0).getProperties().getDistance_units();

                    System.out.println("Distance between locations: " + distance + " " + distanceUnits);
                    double midwayPoint = distance/2;
                    System.out.println("MidwayPoint between locations: " + midwayPoint);
                } else {
                    System.err.println("Error: " + response.code() + " - " + response.message());
                }
            }
        }