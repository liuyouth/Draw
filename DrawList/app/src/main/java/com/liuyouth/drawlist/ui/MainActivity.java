package com.liuyouth.drawlist.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.liuyouth.drawlist.R;
import com.liuyouth.drawlist.model.DrawXY;
import com.liuyouth.drawlist.model.DrawXYStyle;
import com.liuyouth.drawlist.utils.ConvertUtils;
import com.liuyouth.drawlist.utils.DrawStyleUtils;
import com.liuyouth.drawlist.utils.DrawView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.draw)
    LinearLayout draw;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    Context c;

    ArrayList<String> mDatas;
    DrawView view;
    ArrayList<DrawXYStyle> listdata = new ArrayList<>(); //储存闪亮点的list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        c = this;
        init();
        initData();
    }

    private void initData() {
        mDatas = new ArrayList<>(Arrays.asList("ss",
                "wss", "ssw"));
        mDatas.add("ss");
        mDatas.add("wss");
        mDatas.add("sws");
        mDatas.add("ssw");
        mDatas.add("ssend");
        mDatas.add("wss");
        mDatas.add("sws");
        mDatas.add("ssw");
        mDatas.add("ssend");
        mDatas.add("wss");
        mDatas.add("sws");
        mDatas.add("ssw");
        mDatas.add("ssend");
        mDatas.add("wss");
        mDatas.add("sws");
        mDatas.add("ssw");
        mDatas.add("ssend");
        mDatas.add("wss");
        mDatas.add("sws");
        mDatas.add("ssw");
        mDatas.add("ssend");
        list.setLayoutManager(new LinearLayoutManager(c, OrientationHelper.VERTICAL, false));
        list.setAdapter(new HomeAdapter(mDatas));

        //TimerRun();
        final DrawStyleUtils s = new DrawStyleUtils();
        final DrawStyleUtils ds = new DrawStyleUtils();
        final Handler handler = new Handler();

        Runnable task = new Runnable() {
            public void run() {
                // 删除消失的闪光点
                for (int i = 0; i < listdata.size(); i++) {
                    if (!listdata.get(i).isShow())
                        listdata.remove(i);
                }

                DrawXY d = s.red2();
                DrawXY dss = ds.redAndBlue();
                int count = list.getChildCount();
                for (int i = 0; i < count; i++) {
                    RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) list.getChildViewHolder(list.getChildAt(i));
                    System.out.println(dss.getX()+"x2:"+dss.getX2());
                    if ("ssw" == viewHolder.itemView.getTag()) {
                        listdata.add(new DrawXYStyle(ConvertUtils.dp2px(d.getX() + 8), list.getChildAt(i).getTop() + ConvertUtils.dp2px(d.getY()), R.mipmap.hongg));
                        listdata.add(new DrawXYStyle(ConvertUtils.dp2px(d.getX2() + 8), list.getChildAt(i).getTop() + ConvertUtils.dp2px(d.getY2()), R.mipmap.hongg));
                    }
                    if ("sws" == viewHolder.itemView.getTag()) {
                        listdata.add(new DrawXYStyle(ConvertUtils.dp2px(dss.getX() + 8), list.getChildAt(i).getTop() + ConvertUtils.dp2px(dss.getY()), R.mipmap.hongg));
                        listdata.add(new DrawXYStyle(ConvertUtils.dp2px(dss.getX2() + 8), list.getChildAt(i).getTop() + ConvertUtils.dp2px(dss.getY2()), R.mipmap.languangsgd));
                    }
                }

                postY(listdata);

                handler.postDelayed(this, 25);//设置延迟时间，此处是5秒
            }
        };
        handler.postDelayed(task, 80);//延迟调用
    }


    private void init() {
        view = new DrawView(this);
        view.setMinimumHeight(draw.getHeight());
        view.setMinimumWidth(draw.getWidth());
        draw.addView(view);
    }

    private void postY(ArrayList<DrawXYStyle> list) {
        view.setDrawStyle(list);
        view.postInvalidate();
        draw.postInvalidate();
    }
}
