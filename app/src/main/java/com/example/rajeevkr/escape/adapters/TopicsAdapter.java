package com.example.rajeevkr.escape.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rajeevkr.escape.R;

/**
 * Created by rajeevkr on 5/2/16.
 */
public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.MyViewHolder> {
    private String[] myData;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topics, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (holder != null) {
            holder.topicTv.setText(myData[position]);
        }

    }

    @Override
    public int getItemCount() {
        return myData.length;
    }

    public void setData(String[] data) {
        myData = data;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView topicTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            topicTv = (TextView) itemView.findViewById(R.id.topic_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
