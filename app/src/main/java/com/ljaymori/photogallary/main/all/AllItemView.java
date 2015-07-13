package com.ljaymori.photogallary.main.all;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ljaymori.photogallary.R;

public class AllItemView extends RecyclerView.ViewHolder {

    private ImageView ivThumbnail;
    private ImageView ivPlay;

    public AllItemView(View itemView) {
        super(itemView);
        ivThumbnail = (ImageView) itemView.findViewById(R.id.image_item_all);
        ivPlay = (ImageView) itemView.findViewById(R.id.image_play_all);
    }

    public void setAllItemView(AllItemData ad) {
//        ImageLoader.getInstance().displayImage(ad.getFilePath(), ivThumbnail);
        setPlayImage(ad.isVideo());
    }

    private void setPlayImage(boolean check) {
        if(check) {
            ivPlay.setVisibility(View.VISIBLE);
        } else {
            ivPlay.setVisibility(View.GONE);
        }
    }
}
