package com.page;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.page.cycleviewpager.CycleViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zicong on 2015/7/1.
 */
public class MainActivity extends Activity{

    private int[] mImgIds = new int[]{R.mipmap.dy_pic4,R.mipmap.dy_pic1, R.mipmap.dy_pic2, R.mipmap.dy_pic3, R.mipmap.dy_pic4,R.mipmap.dy_pic1};
    private String[] titles = new String[]{"这是第一页","这是第二页","这是第三页","这是第四页"};
    private List<View> mImageViews = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        // Toast.
        CycleViewPager cycleViewPager = (CycleViewPager) getFragmentManager()
                .findFragmentById(R.id.cycleViewPager);

        // 设置循环，在调用setData方法前调用
        cycleViewPager.setCycle(true);
        cycleViewPager.setWheel(true);
        cycleViewPager.setTime(3*1000);
        //cycleViewPager.setIndicatorCenter();

        // 在加载数据前设置是否循环
        cycleViewPager.setData(mImageViews,titles);
        cycleViewPager.getViewPager().setPageTransformer(true, new DepthPageTransformer());

    }

    private void initData() {
        int i = 0;
        for (int imgId : mImgIds) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgId);
            imageView.setTag(i);
            mImageViews.add(imageView);
            i++;
        }
    }
}
