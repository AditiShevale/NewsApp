package com.example.aditi.newtest;

import android.app.MediaRouteButton;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aditi.newtest.AsyncTask.AsyncListner;
import com.example.aditi.newtest.AsyncTask.MyAsyncTask;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements AsyncListner {

    private Button mSearchButton;
    private TextView mDisplaytv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchButton =findViewById(R.id.se);

        mDisplaytv =findViewById(R.id.displaytv);
        new MyAsyncTask().execute(Networkutils.buildUrl());
        //Networkutils.buildUrl();
//        makegithubsearchQuery();
        Toast.makeText(this, "Welcome to the party !!", Toast.LENGTH_SHORT).show();



    }

    @Override
    public void returnRecipe(String json) {

        mDisplaytv.setText(json.toString());

    }


    public class GitHubQueryTask extends AsyncTask<URL, Void, String>{

        @Override
        protected String doInBackground(URL... params) {

            Log.i("tagu", String.valueOf(params[0]));

            try {
             String  githubsearchresults = Networkutils.getResponseFromHttpUrl(params[0]);
                return githubsearchresults;
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
        @Override
        protected void onPostExecute(String githubSearchResults) {
            Log.i("yy21",githubSearchResults);
        mDisplaytv .setText(githubSearchResults);

        }
        }
    }

