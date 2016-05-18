package com.mybuying.buying.buying;

/**
 * Created by Tacademy on 2016-05-18.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mybuying.buying.data.RecommendCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-05-18.
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendViewHolder> {

    List<RecommendCategory> items = new ArrayList<RecommendCategory>();

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void add(RecommendCategory category) {
        items.add(category);
        notifyDataSetChanged();
    }

    public void addAll(List<RecommendCategory> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }
    RecommendViewHolder.OnItemClickListener mListener;
    public void setOnItemClickListener(RecommendViewHolder.OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public RecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, null);
        return new RecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecommendViewHolder holder, int position) {
        holder.setCategory(items.get(position));
        holder.setOnItemClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
