package com.examplemyapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ListView;

/**
 * Created by 007 on 2015/11/7.
 */
public class IndexableListView extends ListView{
    private boolean mIsFastScrollEnbled = false;
    private IndexScroller mScroller = null;
    private GestureDetector mGestureDetector = null;
    public IndexableListView(Context context) {
        super(context);
    }

    public IndexableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public boolean ismIsFastScrollEnbled(){
        return mIsFastScrollEnbled;
    }
    public void setFastScrollEnbled(boolean  enbled){
        mIsFastScrollEnbled = enbled;
        if (mIsFastScrollEnbled){
            if (mScroller == null){
                mScroller = new IndexScroller(getContext(),this);

            }
        }else if (mScroller != null){
            mScroller.hide();
            mScroller = null;
        }
    }
public void draw(Canvas canvas){
    super.draw(canvas);
    if (mScroller != null){
        mScroller.draw(canvas);
    }
}
    public booleanonTouchEvent(MotionEvent ev){
        if (mScroller!= null&&mScroller.onTouchEvent(ev)){
            return true;
        }
        if (mGestureDetector == null){
            mGestureDetector = new GestureDetector((getContext(), new GestureDetector.OnGestureListener() {
                @Override
                public boolean onDown(MotionEvent e) {
                    .new ScaleGestureDetector.SimpleOnScaleGestureListener(){
                        public boolean onFling(MotionEvent e1,MotionEvente2)
                    }
                }

                @Override
                public void onShowPress(MotionEvent e) {

                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return false;
                }

                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent e) {

                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    return false;
                }
            }))
        }
    }
}
