package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.myapplication.adapter.HomeBannerAdapter;
import com.example.myapplication.adapter.HomeCommodityAdapter;
import com.example.myapplication.adapter.HomeCouponAdapter;
import com.example.myapplication.adapter.HomeNewsAdapter;
import com.example.myapplication.adapter.HomeSeckillAdapter;
import com.example.myapplication.adapter.HomeSeckillTitleAdapter;
import com.example.myapplication.adapter.HomeSpecialAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mainView;
    Button buttonAdd;
    VirtualLayoutManager layoutManager;

    private DelegateAdapter delegateAdapter;
    private List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
    private RecyclerView.RecycledViewPool viewPool;

    private List<String> commodityData;
    private HomeCommodityAdapter commodityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainView = (RecyclerView) findViewById(R.id.main_view);
        buttonAdd = (Button) findViewById(R.id.add);

        layoutManager = new VirtualLayoutManager(this);
        mainView.setLayoutManager(layoutManager);

        // 设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
        viewPool = new RecyclerView.RecycledViewPool();
        mainView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        delegateAdapter = new DelegateAdapter(layoutManager);
        mainView.setAdapter(delegateAdapter);


        //banner
        adapters.add(new HomeBannerAdapter(viewPool));

        //活动
        adapters.add(new HomeCouponAdapter());

        //新闻
        adapters.add(new HomeNewsAdapter());

        //秒杀
        adapters.add(new HomeSeckillTitleAdapter());
        adapters.add(new HomeSeckillAdapter());

        //专题
        adapters.add(new HomeSpecialAdapter());


        //商品
        commodityData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            commodityData.add("商品");
        }
        commodityAdapter = new HomeCommodityAdapter(commodityData);
        adapters.add(commodityAdapter);

        delegateAdapter.setAdapters(adapters);

//        int itemCount = delegateAdapter.getItemCount();
//        L.d("itemCount : "  + itemCount);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    commodityData.add("商品 xx ");
                }

                commodityAdapter.notifyDataSetChanged();
                mainView.getAdapter().notifyDataSetChanged();
                mainView.requestLayout();
            }
        });
    }
}
