package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String apiKey = "vkPKHymUPVKZs21uKH91bh9MfxGsDytU";
    private String baseUrl = "http://dataservice.accuweather.com/locations/v1/cities/search?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }
    public void search(View view){
        EditText city = findViewById(R.id.city);
        String cityStr = city.getText().toString();
        //curl -X GET "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=vkPKHymUPVKZs21uKH91bh9MfxGsDytU&q=madrid&language=en-us"
        String url = baseUrl + "apikey=" + apiKey + "&q=" + cityStr;
        List<String> links = new ArrayList<>();
        links.add(url);

        GetDetails getDetails = new GetDetails() {
            @Override
            protected void onProgressUpdate(Integer... values) {
                ProgressBar pb = findViewById(R.id.progress);
                pb.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(List<String> keys) {
                LinearLayout ll = findViewById(R.id.linearLayout);
                for (String key : keys) {
                    TextView tv =findViewById(R.id.key);
                    if(tv.getParent() != null) {
                        ((ViewGroup)tv.getParent()).removeView(tv); // <- fix
                    }
                    tv.setText(key);
                    ll.addView(tv);
                }
            }
        };
        ProgressBar pb=findViewById(R.id.progress);
        pb.setIndeterminate(false);
        pb.setMax(links.size());

        getDetails.execute(links);
    }

    public void getWeather(View view){
        TextView tv=findViewById(R.id.key);
        String key=tv.getText().toString();
        String url="http://dataservice.accuweather.com/forecasts/v1/daily/1day/"+key;

        GetWeather getWeather = new GetWeather() {
            @Override
            protected void onProgressUpdate(Integer... values) {
                ProgressBar pb = findViewById(R.id.progress);
                pb.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(List<String> temperatures) {
                LinearLayout ll = findViewById(R.id.linearLayout);

                    TextView tv =findViewById(R.id.key);
                    if(tv.getParent() != null) {
                        ((ViewGroup)tv.getParent()).removeView(tv); // <- fix
                    }
                    tv.setText("aaaa");
                    //tv.setText(temperatures.get(0)+" "+temperatures.get(1));
                    ll.addView(tv);

            }
        };
        ProgressBar pb=findViewById(R.id.progress);
        pb.setIndeterminate(false);
        pb.setMax(1);

        getWeather.execute(url);
    }
}