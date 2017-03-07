package com.example.myapplication.adapter;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.myapplication.R;

/**
 * Created by haier on 2017/3/6.
 */

public class HomeBannerAdapter extends DelegateAdapter.Adapter<HomeBannerAdapter.ViewHolder> {

    private RecyclerView.RecycledViewPool viewPool;

    public HomeBannerAdapter(RecyclerView.RecycledViewPool viewPool) {
        this.viewPool = viewPool;
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        ((ViewPager) holder.itemView).setAdapter(null);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LinearLayoutHelper helper = new LinearLayoutHelper();
//        helper.setBgColor(Color.parseColor("#f4a345"));
        return helper;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 1) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_banner, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_banner_item, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.itemView instanceof ViewPager) {
            ViewPager viewPager = ((ViewPager) holder.itemView);
            viewPager.setAdapter(new PagerAdapter(this, viewPool));
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
