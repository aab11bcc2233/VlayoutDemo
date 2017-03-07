package com.example.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.myapplication.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by tianpeng on 2017/3/7.
 */

public class HomeCommodityAdapter extends DelegateAdapter.Adapter<HomeCommodityAdapter.ViewHolder> {

    private List<String> data;

    public HomeCommodityAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LinearLayoutHelper helper = new LinearLayoutHelper();
        return helper;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_commodity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.commodityName.setText(data.get(position) + " : " + position);
    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.commodity_img)
        ImageView commodityImg;
        @InjectView(R.id.commodity_name)
        TextView commodityName;
        @InjectView(R.id.commodity_current_price)
        TextView commodityCurrentPrice;
        @InjectView(R.id.commodity_original_price)
        TextView commodityOriginalPrice;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
