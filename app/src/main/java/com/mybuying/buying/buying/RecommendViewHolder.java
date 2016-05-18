package com.mybuying.buying.buying;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mybuying.buying.data.RecommendCategory;

/**
 * Created by Tacademy on 2016-05-18.
 */
public class RecommendViewHolder extends RecyclerView.ViewHolder{
    TextView nameView;
    RecommendCategory category;
    public interface OnItemClickListener {
        public void onItemClick(View view, RecommendCategory category);
    }

    OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public RecommendViewHolder(View itemView) {
        super(itemView);
        nameView = (TextView)itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(v, category);
                }
            }
        });
    }

    public void setCategory(RecommendCategory category) {
        this.category = category;
        nameView.setText(category.getCategoryName());
    }
}