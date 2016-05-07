package com.example.rajeevkr.escape.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by rajeevkr on 5/8/16.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public DividerItemDecoration(Drawable mDivider) {
        this.mDivider = mDivider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, recyclerView, state);

        if (recyclerView.getChildAdapterPosition(view) == 0 ) return;

        outRect.left=3;
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int dividerLeftPos = recyclerView.getPaddingLeft();
        int dividerRightPos = recyclerView.getWidth() - recyclerView.getPaddingRight();

        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = recyclerView.getChildAt(i);

            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            int dividerTop = child.getBottom() + layoutParams.bottomMargin;
            Log.d("Rajeev", "child.getBottom():  " + child.getBottom() + "layoutParams.bottomMargin: " + layoutParams.bottomMargin);

            int dividerBottom = dividerTop + mDivider.getIntrinsicHeight();
            Log.d("Rajeev", "dividerTop:  " + dividerTop + "mDivider.getIntrinsicHeight():  " + mDivider.getIntrinsicHeight());

            mDivider.setBounds(dividerLeftPos, dividerTop, dividerRightPos, dividerBottom);
            mDivider.draw(canvas);
        }


    }
}