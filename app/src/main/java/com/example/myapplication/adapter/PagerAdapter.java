package com.example.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.vlayout.RecyclablePagerAdapter;

/**
 * Created by tianpeng on 2017/3/6.
 */

public class PagerAdapter extends RecyclablePagerAdapter<HomeBannerAdapter.ViewHolder> {


    public PagerAdapter(RecyclerView.Adapter<HomeBannerAdapter.ViewHolder> adapter, RecyclerView.RecycledViewPool pool) {
        super(adapter, pool);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public void onBindViewHolder(HomeBannerAdapter.ViewHolder viewHolder, int position) {
        if (viewHolder.itemView instanceof TextView) {
            ((TextView) viewHolder.itemView).setText("banner : " + position);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
