package com.ljaymori.photogallary.main.picture;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.MediaItemData;

import java.util.ArrayList;

public class PictureItemAdapter extends RecyclerView.Adapter<PictureItemView> {

    private ArrayList<MediaItemData> items = new ArrayList<MediaItemData>();
    private Context mContext;

    public PictureItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addAll(ArrayList<MediaItemData> list) {
        items.addAll(list);
    }

    @Override
    public PictureItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_picture, parent, false);

        return new PictureItemView(v);
    }

    @Override
    public void onBindViewHolder(PictureItemView holder, int position) {
        holder.setAllItemView(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
