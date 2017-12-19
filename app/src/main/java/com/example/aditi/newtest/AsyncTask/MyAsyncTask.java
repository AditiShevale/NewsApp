package com.example.aditi.newtest.AsyncTask;

import android.os.AsyncTask;

import com.example.aditi.newtest.Networkutils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by aditi on 19/12/17.
 */


public class MyAsyncTask extends AsyncTask<URL, Void, String> {

    private AsyncListner mAsyncListner;


    @Override
    protected String doInBackground(URL... urls) {


        try {
           String json = Networkutils.getResponseFromHttpUrl(urls[0]);
            return json;
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mAsyncListner.returnRecipe(s);


    }
}
