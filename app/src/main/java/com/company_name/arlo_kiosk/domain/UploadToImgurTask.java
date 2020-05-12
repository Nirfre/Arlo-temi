package com.company_name.arlo_kiosk.domain;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.File;

public class UploadToImgurTask extends AsyncTask<String, Void, Boolean> {

    private String uploadedImageUrl;

    @SuppressLint("StaticFieldLeak")
    private Activity context;
//    private ProgressDialog progressDialog;

    public UploadToImgurTask(Activity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        progressDialog = new ProgressDialog(context);
//        progressDialog.setTitle("Loading...");
//        progressDialog.setMessage("Please wait!");
//        progressDialog.setMax(100);
//        progressDialog.setCancelable(false);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        final String upload_to = "https://api.imgur.com/3/upload";
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpPost httpPost = new HttpPost(upload_to);

        try {
            HttpEntity entity = MultipartEntityBuilder.create()
                    .addPart("image", new FileBody(new File(params[0])))
                    .build();

            String accessToken = "22ea91760c15f69d70c7782fff42cc35eef0cedf";
            httpPost.setHeader("Authorization", "Bearer " + accessToken);
            httpPost.setEntity(entity);

            final HttpResponse response = httpClient.execute(httpPost,
                    localContext);

            final String response_string = EntityUtils.toString(response
                    .getEntity());

            final JSONObject json = new JSONObject(response_string);

            Log.d("tag", json.toString());

            JSONObject data = json.optJSONObject("data");
            uploadedImageUrl = data.optString("link");
            Log.d("tag", "uploaded image url : " + uploadedImageUrl);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
//        progressDialog.dismiss();
        if (aBoolean) { // after sucessful uploading, show the image in web browser
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    context.finish();
                }
            }, 1500);
        } else {
            Toast.makeText(context, "Failed to Upload", Toast.LENGTH_LONG).show();
            context.finish();
        }
    }
}