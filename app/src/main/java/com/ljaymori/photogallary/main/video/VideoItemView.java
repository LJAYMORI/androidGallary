package com.ljaymori.photogallary.main.video;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljaymori.photogallary.R;

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

    public void setVideoItemView(VideoItemData vd) {
//        ImageLoader.getInstance().displayImage(vd.getFilePath(), ivThumbnail);
        tvName.setText(vd.getFileName());
        tvType.setText(vd.getFileType());
        tvSize.setText(vd.getFileSize()+"");
    }
}
