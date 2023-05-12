package com.example.lab10;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetDetails extends AsyncTask<List<String>,Integer,List<String>> {
    @Override
    protected List<String> doInBackground(List<String>... lists) {
        List<String> keys=new ArrayList<>();
        List<String> strings=lists[0];
        int index=0;
        for (String link:strings) {
            HttpURLConnection con = null;
            try {
                URL url = new URL(link);
                con = (HttpURLConnection) url.openConnection();
                if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream is = con.getInputStream();
                    StringBuilder response = new StringBuilder();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                    JSONParser parser = new JSONParser();
                    Object object =parser.parse(response.toString());
                    JSONArray jsonArr=( ((JSONArray) object));
//                    for (int i =0;i< jsonArr.size();i++){
//                        JSONObject jsonObject=(JSONObject)jsonArr.get(i);
//                        Object key=jsonObject.get("Key");
//                        keys.add(key.toString());
//                    }
                    keys.add(((JSONObject)jsonArr.get(0)).get("Key").toString());


                    Thread.sleep(1000);
                    publishProgress(++index);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } finally {
                if (con != null) {
                    con.disconnect();
                }
            }
        }
        return keys;
    }
}
