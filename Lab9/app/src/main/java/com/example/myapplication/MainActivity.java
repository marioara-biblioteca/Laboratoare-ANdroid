package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.myapplication.mta.MTA;
import com.example.myapplication.mta.MTAAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<MTA>mtaimages=new ArrayList<>();
        Map<String,String> urlList=new HashMap<>();
        urlList.put("logo","https://mta.ro/wp-content/uploads/2019/02/logo_alb-300x108.png");
        urlList.put("stema","https://mta.ro/wp-content/uploads/2019/09/logo-inter-atm-site.png");
        urlList.put("cerc","https://mta.ro/wp-content/uploads/2019/08/cerc.png");
        HttpURLConnection con = null;
        for (Map.Entry<String, String> set :
                urlList.entrySet()) {
            try{
                URL url=new URL(set.getValue());
                con= (HttpURLConnection) url.openConnection();
                if(con.getResponseCode()==HttpURLConnection.HTTP_OK){
                    InputStream is = con.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                   mtaimages.add(new MTA(bitmap,set.getKey()));
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(con!=null){
                    con.disconnect();
                }
            }

        }

       ListView lv=findViewById(R.id.lisView);
       MTAAdapter mtaAdapter=new MTAAdapter(this,mtaimages);
       lv.setAdapter(mtaAdapter);
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent=new Intent(MainActivity.this,MainActivity2.class);
               String link=urlList.get(mtaimages.get(i).getTitle());
                intent.putExtra("link",link);
               startActivity(intent);
           }
       });

    }
}