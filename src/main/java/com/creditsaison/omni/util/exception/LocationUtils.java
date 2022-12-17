package com.creditsaison.omni.util.exception;

import com.creditsaison.omni.pojos.Location;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class LocationUtils {

    public static GeoJsonPoint getGeoJsonPoint(Location location){
        return new GeoJsonPoint(location.getLongitude(), location.getLatitude());
    }
}
