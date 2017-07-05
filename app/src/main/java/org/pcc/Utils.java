package org.pcc;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.pcc.startup.model.Data;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ptyagi on 7/4/17.
 */

public class Utils {
    //JSON related work
    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static Data getData(Context context) {
        String json = loadJSONFromAsset(context);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Data data = gson.fromJson(json, Data.class);

        return data;
    }
}
