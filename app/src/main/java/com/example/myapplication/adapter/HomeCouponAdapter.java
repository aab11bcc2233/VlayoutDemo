package com.example.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.myapplication.R;

/**
 * Created by haier on 2017/3/6.
 */

public class HomeCouponAdapter extends DelegateAdapter.Adapter<HomeCouponAdapter.ViewHolder> {

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        GridLayoutHelper helper = new GridLayoutHelper(4, 4);
        helper.setWeights(new float[]{25f, 25f, 25f, 25f});
        return helper;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_coupon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.itemView instanceof TextView) {
            ((TextView) holder.itemView).setText("活动 ： " + (position + 1));
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
