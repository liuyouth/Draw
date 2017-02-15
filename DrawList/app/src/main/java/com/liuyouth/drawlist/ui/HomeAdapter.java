package com.liuyouth.drawlist.ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuyouth.drawlist.R;

import java.util.ArrayList;

/**
 * Created by liubo on 2017/2/15.
 */

public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.ItemViewHolder> {
        private static ArrayList<String> list;

        public ArrayList<String> getList() {
            return list;
        }

        private static Context mContext;

        public HomeAdapter (ArrayList<String> nList) {
            list = nList;
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
            mContext = parent.getContext();
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(final ItemViewHolder holder, final int position) {
            holder.itemView.setTag(list.get(position));
            holder.textView.setText(list.get(position));
            holder.mIcon.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.icon));

        }



        @Override
        public int getItemCount() {
            return list.size();
        }



        public static class ItemViewHolder extends RecyclerView.ViewHolder {

            public final TextView textView;
            public final ImageView mIcon;


            public ItemViewHolder(View itemView) {
                super(itemView);
                mIcon = (ImageView) itemView.findViewById(R.id.mIcon);
                textView = (TextView) itemView.findViewById(R.id.mType);
            }

        }

}
