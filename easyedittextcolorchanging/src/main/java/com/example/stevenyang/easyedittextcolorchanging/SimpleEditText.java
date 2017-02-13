package com.example.stevenyang.easyedittextcolorchanging;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by User on 2017/2/10.
 */

public class SimpleEditText extends EditText {
    LayerDrawable layerFocused;
    LayerDrawable layerUnfocused;

    //default height between text and stroke in pixel
    private int DEFAULT_HEIGHT_BETWEEN_TEXT_AND_LINE = 25;
    //defualt stroke size in pixel
    private int DEFAULT_STROKE_SIZE = 1;

    private int unfocusedEditTextLineColor;
    private int focusedEditTextLineColor;
    private int focusedBackgroundColor;
    private  int unfocusedBackgroundColor;

    ShapeDrawable focusedBackground;
    ShapeDrawable focusedBottomStripe;
    ShapeDrawable unfocusedBackground;
    ShapeDrawable unfocusedBottomStripe;

    final int DEFAULT_FOCUS_LINE_COLOR = Color.BLACK;
    final int DEFAULT_UNFOCUS_LINE_COLOR = Color.GRAY;


    public void setUnfocusedStrokeSize(int strokeSize){
        unfocusedBottomStripe.setPadding(0, 0, 0, strokeSize);
    }
    public void setFocusedStrokeSize(int strokeSize){
        focusedBottomStripe.setPadding(0, 0, 0, strokeSize);
    }


    public void setFocusedTextPaddingBottom(int heightBetweenTextAndStroke) {
        focusedBackground.setPadding(0, 0, 0, heightBetweenTextAndStroke);
    }
    public void setUnfocusedTextPaddingBottom(int heightBetweenTextAndStroke){
        unfocusedBackground.setPadding(0, 0, 0, heightBetweenTextAndStroke);
    }

    public void setUnfocusedEditTextLineColor(int unfocusedEditTextLineColor) {
        this.unfocusedEditTextLineColor = unfocusedEditTextLineColor;
          unfocusedBottomStripe.getPaint().setColor(unfocusedEditTextLineColor);
    }

    public void setFocusedEditTextLineColor(int focusedEditTextLineColor) {
        this.focusedEditTextLineColor = focusedEditTextLineColor;
        focusedBottomStripe.getPaint().setColor(focusedEditTextLineColor);
    }

    public void setUnfocusedBackgroundColor(int unfocusedBackgroundColor) {
        this.unfocusedBackgroundColor = unfocusedBackgroundColor;
        focusedBackground.getPaint().setColor(unfocusedBackgroundColor);
    }

    public void setFocusedBackgroundColor(int focusedBackgroundColor) {
        this.focusedBackgroundColor = focusedBackgroundColor;
        focusedBackground.getPaint().setColor(focusedBackgroundColor);
    }

    public SimpleEditText(Context context) {
        super(context);
        init();
      }

    public SimpleEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public SimpleEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SimpleEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }
    private void beginningLineSetting() {
        focusedEditTextLineColor = DEFAULT_FOCUS_LINE_COLOR;
        unfocusedEditTextLineColor = DEFAULT_UNFOCUS_LINE_COLOR;
        focusedBackgroundColor = getContext().getResources().getColor(R.color.default_androud_bk);
        unfocusedBackgroundColor = getContext().getResources().getColor(R.color.default_androud_bk);
    }

    public void notifyUiChanges(){

        layerFocusedSettings(focusedBottomStripe,focusedBackground);
        layerUnfocusedSetting(unfocusedBottomStripe,unfocusedBackground);
        if(isFocused())
            this.setBackground(layerFocused);
        else
            this.setBackground(layerUnfocused);


    }

    private void layerUnfocusedSetting(ShapeDrawable unfocusedBottomStripe, ShapeDrawable unfocusedBackground) {
        Drawable[] focusedDrawable = {unfocusedBottomStripe, unfocusedBackground};
        layerUnfocused = new LayerDrawable(focusedDrawable);
        layerUnfocused.setLayerInset(1, 0, 0, 0, 10);
    }

    private void layerFocusedSettings(ShapeDrawable focusedBottomStripe,ShapeDrawable focusedBackground){
        Drawable[] focusedDrawable = {focusedBottomStripe, focusedBackground};
        layerFocused = new LayerDrawable(focusedDrawable);
        layerFocused.setLayerInset(1, 0, 0, 0, 10);

    }


    private void init() {
        beginningLineSetting();
        //---------------------
        focusedBackground = new ShapeDrawable();
        focusedBackground.getPaint().setColor(focusedBackgroundColor);
        focusedBackground.setPadding(0, 0, 0, DEFAULT_HEIGHT_BETWEEN_TEXT_AND_LINE);
        focusedBottomStripe = new ShapeDrawable();
        focusedBottomStripe.getPaint().setColor(focusedEditTextLineColor);
        focusedBottomStripe.setPadding(0, 0, 0, DEFAULT_STROKE_SIZE);
        //---------------------------------------
        unfocusedBackground = new ShapeDrawable();
        unfocusedBackground.getPaint().setColor(unfocusedBackgroundColor);
        unfocusedBackground.setPadding(0, 0, 0, DEFAULT_HEIGHT_BETWEEN_TEXT_AND_LINE);
        unfocusedBottomStripe = new ShapeDrawable();
        unfocusedBottomStripe.getPaint().setColor(unfocusedEditTextLineColor);
        unfocusedBottomStripe.setPadding(0, 0, 0, DEFAULT_STROKE_SIZE);
        //---------------------------------------
        notifyUiChanges();

    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(focused){
            this.setBackground(layerFocused);
        }else{
            this.setBackground(layerUnfocused);
        }
    }
}
