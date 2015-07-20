package com.ljaymori.photogallary.main.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.MainActivity;
import com.ljaymori.photogallary.main.MediaItemData;
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
        mAdapter.addAll((ArrayList< MediaItemData>) getArguments().getSerializable(MainActivity.KEY_VIDEO));

        recyclerView.setAdapter(mAdapter);

        return v;
    }

}
