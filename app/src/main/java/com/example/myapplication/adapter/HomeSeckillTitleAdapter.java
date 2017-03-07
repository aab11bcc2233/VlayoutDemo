package com.example.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.myapplication.R;

/**
 * Created by haier on 2017/3/7.
 */

public class HomeSeckillTitleAdapter extends DelegateAdapter.Adapter<HomeSeckillTitleAdapter.ViewHolder> {
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LinearLayoutHelper helper = new LinearLayoutHelper();
        return helper;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_seckill_title, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((TextView) holder.itemView).setText("秒杀标题 : " + position);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
