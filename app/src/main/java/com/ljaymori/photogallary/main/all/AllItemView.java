package com.ljaymori.photogallary.main.all;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.MediaItemData;
import com.nostra13.universalimageloader.core.ImageLoader;

public class AllItemView extends RecyclerView.ViewHolder {

    private ImageView ivThumbnail;
    private ImageView ivPlay;

    public AllItemView(View itemView) {
        super(itemView);
        ivThumbnail = (ImageView) itemView.findViewById(R.id.image_item_all);
        ivPlay = (ImageView) itemView.findViewById(R.id.image_play_all);
    }

    public void setAllItemView(MediaItemData md) {
        if(md.isVideo()) {
            ivPlay.setVisibility(View.VISIBLE);
//            Bitmap thumbnail = ThumbnailUtils.createVideoThumbnail(md.getFilePath(), MediaStore.Images.Thumbnails.MICRO_KIND);
//            ivThumbnail.setImageDrawable(new BitmapDrawable(GallaryApplication.getContext().getResources(), thumbnail));

        } else {
            ivPlay.setVisibility(View.GONE);

        }
        ImageLoader.getInstance().displayImage("file://" + md.getFilePath(), ivThumbnail);
    }
}
