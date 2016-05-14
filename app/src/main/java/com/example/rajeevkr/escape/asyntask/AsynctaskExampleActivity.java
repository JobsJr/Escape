package com.example.rajeevkr.escape.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.example.rajeevkr.escape.R;

/**
 * Created by rajeevkr on 5/14/16.
 */
public class AsynctaskExampleActivity extends FragmentActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, AsynctaskExampleActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);


        Button startTask = (Button) findViewById(R.id.btn_start_task);
        startTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateTask().execute();

            }
        });
    }

    class UpdateTask extends AsyncTask<Void, Integer, Void> {
        ProgressDialog mProgressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(AsynctaskExampleActivity.this);
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setTitle("Loading data!");
            mProgressDialog.setMax(100);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(3 * 1000);
                    publishProgress(i * 10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mProgressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mProgressDialog.cancel();
        }
    }
}
