package com.ljaymori.photogallary.main.picture;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.TabParentFragment;

import java.util.ArrayList;

public class PictureFragment extends TabParentFragment {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private PictureItemAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_picture, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_picture);

        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        mAdapter = new PictureItemAdapter(getActivity());
        mAdapter.addAll(initData());

        recyclerView.setAdapter(mAdapter);

        return v;
    }

    private ArrayList<PictureItemData> initData() {
        ArrayList<PictureItemData> list = new ArrayList<PictureItemData>();

        for (int i = 0; i < 50; i++) {
            PictureItemData pd = new PictureItemData();

            list.add(pd);
        }

        return list;
    }
}
