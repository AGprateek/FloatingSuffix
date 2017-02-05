package org.prdev.suffix;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * Created by Prateek on 26-01-2017.
 */

public class SuffixEditText extends EditText {

    private String mSuffix;
    private boolean isFloating;
    private SuffixTouchedListener mListener;
    private RectF mSuffixRect;

    public SuffixEditText(Context context) {
        super(context);
    }

    public SuffixEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * Set the text for suffix
     * @param  text content of suffix
     *
     * */
    public void setSuffixText(String text){
        this.mSuffix = text;
    }

    /**
     * Set whether suffix should be floating.
     * @param floating
     * */
    public void setFloating(boolean floating){
        this.isFloating = floating;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return super.onTouchEvent(event);
    }

    public void setSuffixListener(SuffixTouchedListener listener){
        this.mListener = listener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(getText().length() > 0)
        createSuffix(canvas);
    }

    private Rect line0bounds = new Rect();

    private void createSuffix(Canvas canvas){

        TextPaint mTextPaint = new TextPaint(getPaint());
        mTextPaint.setColor(getCurrentTextColor());
        mTextPaint.setFakeBoldText(true);
        mTextPaint.setAntiAlias(true);
        int width = (int)mTextPaint.measureText(mSuffix) + 40;

        Layout layout = getLayout();
        layout.getLineBounds(getLineCount()-1, line0bounds);
        int start = layout.getLineBottom(getLineCount()-1);
        int end = (int)layout.getLineWidth(getLineCount()-1);
        int textY = getLineCount() > 1 ? (int) (layout.getLineBottom(getLineCount() - 1) + getLineSpacingExtra()) :getPaddingTop()+getTop()+15;
       int  height = line0bounds.height();

        int textX = end + getPaddingLeft()+15;

        mSuffixRect = new RectF(textX ,textY,textX+width,height );

        canvas.drawText(mSuffix,textX,textY,mTextPaint);

    }
}
