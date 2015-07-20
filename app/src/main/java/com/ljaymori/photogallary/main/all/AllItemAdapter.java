package com.ljaymori.photogallary.main.all;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.MediaItemData;

import java.util.ArrayList;

public class AllItemAdapter extends RecyclerView.Adapter<AllItemView> {

    private ArrayList<MediaItemData> items = new ArrayList<MediaItemData>();
    private Context mContext;

    public AllItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addAll(ArrayList<MediaItemData> list) {
        items.addAll(list);
    }

    @Override
    public AllItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_all, parent, false);

        return new AllItemView(v);
    }

    @Override
    public void onBindViewHolder(AllItemView holder, int position) {
        holder.setAllItemView(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
