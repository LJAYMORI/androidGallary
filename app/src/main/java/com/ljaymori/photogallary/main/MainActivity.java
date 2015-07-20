package com.ljaymori.photogallary.main;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ljaymori.photogallary.R;
import com.ljaymori.photogallary.main.all.AllFragment;
import com.ljaymori.photogallary.main.picture.PictureFragment;
import com.ljaymori.photogallary.main.video.VideoFragment;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public static final int PAGE_POSITION_ALL = 0;
    public static final int PAGE_POSITION_PICTURE = 1;
    public static final int PAGE_POSITION_VIDEO = 2;

    public static final String KEY_ALL = "all";
    public static final String KEY_PICTURE = "picture";
    public static final String KEY_VIDEO = "video";

    private ArrayList<MediaItemData> allList = new ArrayList<MediaItemData>();
    private ArrayList<MediaItemData> imageList = new ArrayList<MediaItemData>();
    private ArrayList<MediaItemData> videoList = new ArrayList<MediaItemData>();

    private View actionbarView;
    private TextView tvTabAll;
    private TextView tvTabPicture;
    private TextView tvTabVideo;

    private AllFragment allFragment;
    private PictureFragment pictureFragment;

    private ViewPager viewPager;
    private MainPagerAdapter pagerAdapter;
    private VideoFragment videoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init Action Bar
        initActionBar();

        // init Fragments
        initFragments();

    }

    private void initActionBar() {
        getSupportActionBar().setTitle("");

        actionbarView = LayoutInflater.from(this).inflate(R.layout.actionbar_main, null);

        tvTabAll = (TextView) actionbarView.findViewById(R.id.text_all_actionbar);
        tvTabPicture = (TextView) actionbarView.findViewById(R.id.text_picture_actionbar);
        tvTabVideo = (TextView) actionbarView.findViewById(R.id.text_video_actionbar);

        tvTabAll.setOnClickListener(this);
        tvTabPicture.setOnClickListener(this);
        tvTabVideo.setOnClickListener(this);

        getSupportActionBar().setCustomView(actionbarView);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
    }

    private void initFragments() {
        new MediaLoadAsync().execute();
    }

    private void initPager() {
        viewPager = (ViewPager) findViewById(R.id.pager_main);

        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        pagerAdapter.setInitPages(initPages());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case PAGE_POSITION_ALL: {
                        tvTabAll.setTextColor(getResources().getColor(R.color.actionbar_letter_focus));
                        tvTabPicture.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        tvTabVideo.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        break;
                    }
                    case PAGE_POSITION_PICTURE: {
                        tvTabAll.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        tvTabPicture.setTextColor(getResources().getColor(R.color.actionbar_letter_focus));
                        tvTabVideo.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        break;
                    }
                    case PAGE_POSITION_VIDEO: {
                        tvTabAll.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        tvTabPicture.setTextColor(getResources().getColor(R.color.actionbar_letter_unfocus));
                        tvTabVideo.setTextColor(getResources().getColor(R.color.actionbar_letter_focus));
                        break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private ArrayList<TabParentFragment> initPages() {
        ArrayList<TabParentFragment> list = new ArrayList<TabParentFragment>();

        list.add(allFragment);
        list.add(pictureFragment);
        list.add(videoFragment);

        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_all_actionbar: {
                viewPager.setCurrentItem(PAGE_POSITION_ALL, true);
                break;
            }
            case R.id.text_picture_actionbar: {
                viewPager.setCurrentItem(PAGE_POSITION_PICTURE, true);
                break;
            }
            case R.id.text_video_actionbar: {
                viewPager.setCurrentItem(PAGE_POSITION_VIDEO, true);
                break;
            }

        }
    }

    // http://stackoverflow.com/questions/18172074/get-images-thumbnail-file-paths
    private void test() {
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name, colmun_index_tuhmbnail;
        ArrayList<String> listOfAllImages = new ArrayList<String>();
        String absolutePathOfImage;
//        String absoluteThumbnalPathOfImage;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        cursor = getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
//        column_index_folder_name = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
//        colmun_index_tuhmbnail = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails.DATA);
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);
//            absoluteThumbnalPathOfImage = cursor.getString(colmun_index_tuhmbnail);

            Log.i("imagePath", absolutePathOfImage);
//            Log.i("thumbnailPath", absoluteThumbnalPathOfImage);
//            listOfAllImages.add(absolutePathOfImage);
        }
    }

    class MediaLoadAsync extends AsyncTask<Void, Void, ArrayList<MediaItemData>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<MediaItemData> doInBackground(Void... params) {
            ArrayList<MediaItemData> list = new ArrayList<MediaItemData>();

            Uri imageUri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

            String[] imageProjection = {
                    MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media.DATE_TAKEN
            };

            Cursor imageCursor = getContentResolver().query(imageUri, imageProjection, null,
                    null, null);

            int image_column_index_data = imageCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            int image_column_index_taken_date = imageCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN);

            while (imageCursor.moveToNext()) {
                String path = imageCursor.getString(image_column_index_data);
                String date = imageCursor.getString(image_column_index_taken_date);

                MediaItemData md = new MediaItemData();
                md.setIsVideo(false);
                md.setFilePath(path);
                md.setTakenDate(date);
//            Log.i("path", absolutePathOfImage);

                list.add(md);
            }


            Uri videoUri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

            String[] videoProjection = {
                    MediaStore.Video.Media.DATA,
                    MediaStore.Video.Media.DISPLAY_NAME,
                    MediaStore.Video.Media.SIZE,
                    MediaStore.Video.Media.MIME_TYPE,
                    MediaStore.Video.Media.DATE_TAKEN
            };

            Cursor videoCursor = getContentResolver().query(videoUri, videoProjection, null,
                    null, null);

            int video_column_index_data = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            int video_column_index_name = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME);
            int video_column_index_size = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE);
            int video_column_index_type = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE);
            int video_column_index_taken_date = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_TAKEN);

            while (videoCursor.moveToNext()) {
                String path = videoCursor.getString(video_column_index_data);
                String date = videoCursor.getString(video_column_index_taken_date);
                String name = videoCursor.getString(video_column_index_name);
                String type = videoCursor.getString(video_column_index_type);
                float size = videoCursor.getFloat(video_column_index_size);

                MediaItemData md = new MediaItemData();
                md.setIsVideo(true);
                md.setFilePath(path);
                md.setTakenDate(date);
                md.setFileName(name);
                md.setFileType(type);
                md.setFileSize(size / 1024 / 1024);

                list.add(md);
            }

            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<MediaItemData> mediaItemDatas) {
            super.onPostExecute(mediaItemDatas);

            Log.i("list size", mediaItemDatas.size()+"");

            allList.addAll(mediaItemDatas);
            for (MediaItemData md : mediaItemDatas) {
                if (md.isVideo()) {
                    videoList.add(md);
                } else {
                    imageList.add(md);
                }
            }

            allFragment = new AllFragment();
            Bundle allBundle = new Bundle();
            allBundle.putSerializable(KEY_ALL, allList);
            allFragment.setArguments(allBundle);

            pictureFragment = new PictureFragment();
            Bundle pictureBundle = new Bundle();
            pictureBundle.putSerializable(KEY_PICTURE, imageList);
            pictureFragment.setArguments(pictureBundle);

            videoFragment = new VideoFragment();
            Bundle videoBundle = new Bundle();
            videoBundle.putSerializable(KEY_VIDEO, videoList);
            videoFragment.setArguments(videoBundle);

            // init Pager
            initPager();

        }

    }

}
