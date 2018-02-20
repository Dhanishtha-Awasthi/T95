package com.example.dhanishthaawasthi.t95;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by DhanishthaAwasthi on 2/18/2018.
 */

public class BackgroundWorker2 extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    String TAG = BackgroundWorker.class.getSimpleName();

    BackgroundWorker2(Context ctx) {
        context = ctx;
    }


    public BackgroundWorker2() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
        String login_url = "http://10.12.37.191/complain.php";


        if (type.equals("login")) {

            String user_name = params[1];
            String password = params[2];
            try {
                URL url = new URL(login_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder
                        .encode("complaint", "UTF-8")
                        + "=" + URLEncoder.encode(user_name, "UTF-8")
                        + "&" + URLEncoder.encode("worker", "UTF-8")
                        + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                String result = "";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute (String resultLoginStatus)
    {
        alertDialog.setMessage(resultLoginStatus);
        alertDialog.show();

    }

    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }

}
