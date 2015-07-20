package com.ljaymori.photogallary.main.video;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.MediaItemData;
import com.nostra13.universalimageloader.core.ImageLoader;

public class VideoItemView extends RecyclerView.ViewHolder {

    private ImageView ivThumbnail;
    private TextView tvName;
    private TextView tvType;
    private TextView tvSize;

    public VideoItemView(View itemView) {
        super(itemView);
        
        ivThumbnail = (ImageView) itemView.findViewById(R.id.image_item_video);
        tvName = (TextView) itemView.findViewById(R.id.text_filename_item_video);
        tvType = (TextView) itemView.findViewById(R.id.text_filetype_item_video);
        tvSize = (TextView) itemView.findViewById(R.id.text_filesize_item_video);
    }

    public void setVideoItemView(MediaItemData md) {
//        Bitmap thumbnail = ThumbnailUtils.createVideoThumbnail(md.getFilePath(), MediaStore.Images.Thumbnails.MICRO_KIND);
//        ivThumbnail.setImageDrawable(new BitmapDrawable(GallaryApplication.getContext().getResources(), thumbnail));
//        thumbnail.recycle();
        ImageLoader.getInstance().displayImage("file://" + md.getFilePath(), ivThumbnail);

        tvName.setText(md.getFileName());
        tvType.setText(md.getFileType());
        tvSize.setText(String.format("%.2fMB", md.getFileSize()));
    }

}
