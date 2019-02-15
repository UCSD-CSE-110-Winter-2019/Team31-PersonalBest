package com.example.team31_personalbest;

import android.app.Activity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class FitnessServiceFactory {

    private static final String TAG = "[FitnessServiceFactory]";

    private static Map<String, BluePrint> blueprints = new HashMap<>();

    public static void put(String key, BluePrint bluePrint) {
        blueprints.put(key, bluePrint);
    }

    public static FitnessService create(String key, Activity walkRun) {
        Log.i(TAG, String.format("creating FitnessService with key %s", key));
        System.out.println(key);
        if (blueprints.get(key) == null) {
            System.out.println("Blueprint getkey is null!");
        }
        return blueprints.get(key).create(walkRun);
    }

    public interface BluePrint {
        FitnessService create(Activity walkRun);
    }
}
