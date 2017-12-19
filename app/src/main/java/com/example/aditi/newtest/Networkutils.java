package com.example.aditi.newtest;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by aditi on 16/12/17.
 */

public class Networkutils {

    final static String Base_newsApi =
            "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=343119bf5d4d4c4bb17b0b7c9bc0f2a2";


    public static URL buildUrl() {
        Uri builtUri = Uri.parse(Base_newsApi).buildUpon()
                .build();


        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.i("Test21", String.valueOf(url));

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                Log.i("Test21", String.valueOf(scanner.next()));
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
