package com.ljaymori.photogallary.main.video;

import android.os.Bundle;
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
        ArrayList<VideoItemData> list = new ArrayList<VideoItemData>();

        for (int i = 0; i < 20; i++) {
            VideoItemData vd = new VideoItemData();

            vd.setFileName("video name - " + i);
            vd.setFileType("mp4");
            vd.setFileSize(i);

            list.add(vd);
        }

        return list;
    }
}
