package com.mybuying.buying.buying;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mybuying.buying.R;
import com.mybuying.buying.data.RecommendCategory;

import java.io.IOException;
import java.util.List;

public class RecommendActivity extends AppCompatActivity {

    RecyclerView listView;

    RecommendAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        mAdapter = new RecommendAdapter();
        mAdapter.setOnItemClickListener(new RecommendViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecommendCategory category) {
                Toast.makeText(getContext(), "code : " + category.getCategoryCode(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), TStoreAppListActivity.class);
                intent.putExtra(TStoreAppListActivity.EXTRA_CATEGORY_CODE, category.getCategoryCode());
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recommend, container, false);
        listView = (RecyclerView) view.findViewById(R.id.rv_list);
        listView.setAdapter(mAdapter);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }

    private void setData() {
        NetworkManager.getInstance().getTStoreCategory(getContext(), new NetworkManager.OnResultListener<List<TStoreCategory>>() {
            @Override
            public void onSuccess(Request request, List<TStoreCategory> result) {
                mAdapter.clear();
                mAdapter.addAll(result);
            }

            @Override
            public void onFail(Request request, IOException exception) {
                Toast.makeText(getContext(), "exception : " + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}