package org.example;

import java.util.List;

public class RouteModel {
    private List<Feature> features;
    private Properties properties;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

class Feature {
    private String type;
    private Properties properties;
    private Geometry geometry;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}

class Properties {
    private String mode;
    private List<Waypoint> waypoints;
    private String units;
    private double distance;
    private String distance_units;
    private double time;
    private List<Leg> legs;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDistance_units() {
        return distance_units;
    }

    public void setDistance_units(String distance_units) {
        this.distance_units = distance_units;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }
}

class Waypoint {
    private double lat;
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}

class Leg {
    private double distance;
    private double time;
    private List<Step> steps;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}

class Step {
    private int from_index;
    private int to_index;
    private double distance;
    private double time;
    private Instruction instruction;

    public int getFrom_index() {
        return from_index;
    }

    public void setFrom_index(int from_index) {
        this.from_index = from_index;
    }

    public int getTo_index() {
        return to_index;
    }

    public void setTo_index(int to_index) {
        this.to_index = to_index;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
}

class Instruction {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class Geometry {
    private String type;
    private List<List<List<Double>>> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<List<Double>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<List<Double>>> coordinates) {
        this.coordinates = coordinates;
    }
}