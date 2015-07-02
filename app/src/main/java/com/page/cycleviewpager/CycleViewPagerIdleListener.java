package com.page.cycleviewpager;

import android.view.View;

/**
 * viewpager处于空闲状态监听器
 * 
 */
public interface CycleViewPagerIdleListener {

	public void onPagerSelected(View view, int position);
}
