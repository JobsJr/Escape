package com.example.rajeevkr.escape;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rajeevkr on 5/2/16.
 */
public class CallbackCheckFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        logCurrentMethod("onAttach");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logCurrentMethod("onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        logCurrentMethod("onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        logCurrentMethod("onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        logCurrentMethod("onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        logCurrentMethod("onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        logCurrentMethod("onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        logCurrentMethod("onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logCurrentMethod("onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logCurrentMethod("onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        logCurrentMethod("onDetach");

    }

    private void logCurrentMethod(String methodName) {
        Log.d("Rajeev", "Fragment: "+methodName);

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


