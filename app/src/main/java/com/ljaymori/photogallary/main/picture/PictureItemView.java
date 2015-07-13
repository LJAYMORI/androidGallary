package com.ljaymori.photogallary.main.picture;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ljaymori.photogallary.R;

public class PictureItemView extends RecyclerView.ViewHolder {

    private ImageView ivThumbnail;

    public PictureItemView(View itemView) {
        super(itemView);
        ivThumbnail = (ImageView) itemView.findViewById(R.id.image_item_picture);
    }

    public void setAllItemView(PictureItemData ad) {
//        ImageLoader.getInstance().displayImage(ad.getFilePath(), ivThumbnail);
    }

}
