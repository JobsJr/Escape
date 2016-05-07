package com.example.rajeevkr.escape;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TopicsFragment mTopicsFragment;
    private SecondFragment mSecondFragment;
    private boolean isReplace = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logCurrentMethod("onCreate");

        mTopicsFragment = TopicsFragment.add(this, getSupportFragmentManager());
        Button button = (Button) findViewById(R.id.btn_replace_fragment);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isReplace) {
                        mSecondFragment = SecondFragment.add(MainActivity.this, getSupportFragmentManager());
                        isReplace = true;
                    } else {
//                    mTopicsFragment = TopicsFragment.add(MainActivity.this, getSupportFragmentManager());
                        getSupportFragmentManager().popBackStack();
                        isReplace = false;
                    }
                }
            });
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        logCurrentMethod("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logCurrentMethod("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logCurrentMethod("onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        logCurrentMethod("onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logCurrentMethod("onDestroy");

    }

    private void logCurrentMethod(String methodName) {
        Log.d("Rajeev", "Activity: " + methodName);

    }

    private String getCurrentMethodName() {
        Thread current = Thread.currentThread();
        StackTraceElement[] stack = current.getStackTrace();
        String methodName = null;
        for (StackTraceElement element : stack) {
            if (!element.isNativeMethod()) {
                String className = element.getClassName();
                String fileName = element.getFileName();
                int lineNumber = element.getLineNumber();
                methodName = element.getMethodName();
            }
        }
        return methodName;
    }

}
