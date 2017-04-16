package com.ken.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 
 * @author jthou
 * @createdate 2015-9-2 上午11:33:41
 * @Description: 用于ScrollView嵌套的GridView 
 */
public class InnerGridView extends GridView {

	public InnerGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InnerGridView(Context context) {
		super(context);
	}

	public InnerGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}