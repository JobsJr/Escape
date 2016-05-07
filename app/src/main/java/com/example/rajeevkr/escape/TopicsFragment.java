package com.example.rajeevkr.escape;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rajeevkr.escape.adapters.TopicsAdapter;
import com.example.rajeevkr.escape.ui.DividerItemDecoration;

/**
 * Created by rajeevkr on 5/2/16.
 */
public class TopicsFragment extends Fragment {
    public static final String TAG = "TopicsFragment";
    private LinearLayoutManager mLayoutManager;
    private TopicsAdapter myAdapter;

    public static TopicsFragment add(Context context, FragmentManager fm) {
        FragmentTransaction ft = fm.beginTransaction();
        TopicsFragment topicsFragment = new TopicsFragment();
        ft.setCustomAnimations(R.anim.slide_in_right_animation, R.anim.slide_in_left_animation);
        ft.replace(R.id.fragment_under_test, topicsFragment, TAG);
        ft.commit();
        return topicsFragment;
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        logCurrentMethod("onCreateView");
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.topics_rv);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        myAdapter = new TopicsAdapter();
        myAdapter.setData(getActivity().getResources().getStringArray(R.array.topics));
        recyclerView.setAdapter(myAdapter);

        return view;
    }


    private void logCurrentMethod(String methodName) {
        Log.d("Rajeev", "Fragment: " + methodName);

    }


}
