package com.ljaymori.photogallary.main.all;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.TabParentFragment;

import java.util.ArrayList;

public class AllFragment extends TabParentFragment {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private AllItemAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_all);

        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        mAdapter = new AllItemAdapter(getActivity());
        mAdapter.addAll(initData());

        recyclerView.setAdapter(mAdapter);

        return v;
    }

    private ArrayList<AllItemData> initData() {
        ArrayList<AllItemData> list = new ArrayList<AllItemData>();

        for (int i = 0; i < 50; i++) {
            AllItemData ad = new AllItemData();
            ad.setIsVideo( (i % 5 == 0) ? true : false );

            list.add(ad);
        }

        return list;
    }

}
