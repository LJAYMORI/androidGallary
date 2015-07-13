package com.ljaymori.photogallary.main.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljaymori.photogallary.R;

import java.util.ArrayList;

public class VideoItemAdapter extends RecyclerView.Adapter<VideoItemView> {

    private Context mContext;
    private ArrayList<VideoItemData> items = new ArrayList<VideoItemData>();

    public VideoItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addAll(ArrayList<VideoItemData> list) {
        items.addAll(list);
    }

    @Override
    public VideoItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false);

        return new VideoItemView(v);
    }

    @Override
    public void onBindViewHolder(VideoItemView holder, int position) {
        holder.setVideoItemView(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
