package com.ken.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 
 * @author jthou
 * @createdate 2015-8-17 上午9:55:51
 * @Description: 用于ScrollView嵌套的ListView
 */
public class InnerListView extends ListView {

	public InnerListView(Context context) {
		super(context);
	}

	public InnerListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InnerListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
	
}
