package com.ljaymori.photogallary.main.video;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.TabParentFragment;

import java.util.ArrayList;

public class VideoFragment extends TabParentFragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private VideoItemAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_video);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new VideoItemAdapter(getActivity());
        mAdapter.addAll(initData());

        recyclerView.setAdapter(mAdapter);

        return v;
    }

    private ArrayList<VideoItemData> initData() {
        ArrayList<VideoItemData> listOfAllVideo = new ArrayList<VideoItemData>();

        Uri uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.DISPLAY_NAME,
                MediaStore.Video.Media.SIZE,
                MediaStore.Video.Media.MIME_TYPE,
                MediaStore.Video.Media.DATE_TAKEN
        };

        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null,
                null, null);

        int column_index_data = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
        int column_index_name = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME);
        int column_index_size = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE);
        int column_index_type = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE);
        int column_index_taken_date = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_TAKEN);

        while (cursor.moveToNext()) {
            String path = cursor.getString(column_index_data);
            String date = cursor.getString(column_index_taken_date);
            String name = cursor.getString(column_index_name);
            String type = cursor.getString(column_index_type);
            float size = cursor.getFloat(column_index_size);

            VideoItemData vd = new VideoItemData();
            vd.setFilePath(path);
            vd.setTakenDate(date);
            vd.setFileName(name);
            vd.setFileType(type);
            vd.setFileSize(size / 1024 / 1024);

            listOfAllVideo.add(vd);
        }

        return listOfAllVideo;
    }
}
