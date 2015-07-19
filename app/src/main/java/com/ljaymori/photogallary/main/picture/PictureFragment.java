package com.ljaymori.photogallary.main.picture;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

        ArrayList<PictureItemData> listOfAllImages = new ArrayList<PictureItemData>();

        Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DATE_TAKEN
        };

        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null,
                null, null);

        int column_index_data = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        int column_index_taken_date = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN);

        while (cursor.moveToNext()) {
            String path = cursor.getString(column_index_data);
            String date = cursor.getString(column_index_taken_date);

            PictureItemData pd = new PictureItemData();
            pd.setFilePath(path);
            pd.setTakenDate(date);
//            Log.i("path", absolutePathOfImage);

            listOfAllImages.add(pd);
        }

        return listOfAllImages;
    }
}
