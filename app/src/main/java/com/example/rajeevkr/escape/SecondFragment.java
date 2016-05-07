package com.example.rajeevkr.escape;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rajeevkr on 5/2/16.
 */
public class SecondFragment
        extends Fragment {
    public static final String TAG="SecondFragment";
    public static SecondFragment add(Context context, FragmentManager fm) {
        FragmentTransaction ft = fm.beginTransaction();
        SecondFragment secondFragment = new SecondFragment();
        ft.setCustomAnimations(R.anim.slide_in_left_animation, R.anim.slide_in_right_animation);
        ft.replace(R.id.fragment_under_test, secondFragment);
        ft.addToBackStack(null);
        ft.commit();

        return secondFragment;
    }

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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sec, container, false);
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
        Log.d("Rajeev", "Fragment: " + methodName);

    }

}
