package com.example.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.myapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 秒杀
 * Created by tianpeng on 2017/3/7.
 */

public class HomeSeckillAdapter extends DelegateAdapter.Adapter<HomeSeckillAdapter.ViewHolder> {


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        GridLayoutHelper helper = new GridLayoutHelper(3);
        helper.setWeights(new float[]{33.3f, 33.3f, 33.3f});
        helper.setPadding(0, 0, 0, 0);
        return helper;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_seckill, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.seckill_img)
        ImageView seckillImg;
        @InjectView(R.id.current_price_text)
        TextView currentPriceText;
        @InjectView(R.id.original_price_text)
        TextView originalPriceText;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }

}
