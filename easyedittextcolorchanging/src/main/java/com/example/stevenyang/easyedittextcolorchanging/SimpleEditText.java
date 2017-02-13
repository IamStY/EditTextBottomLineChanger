package com.example.stevenyang.easyedittextcolorchanging;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by User on 2017/2/10.
 */

public class SimpleEditText extends EditText {
    LayerDrawable layerFocused;
    LayerDrawable layerUnfocused;
    private int HEIGHT_BETWEEN_TEXT_AND_LINE = 25;
    private int STROKE_SIZE = 1;
    int unfocusedEditTextLineColor ;
    int focusedEditTextLineColor;
    int focusedBackgroundColor;
    int unfocusedBackgroundColor;




    ShapeDrawable focusedBackground;
    ShapeDrawable focusedBottomStripe;
    ShapeDrawable unfocusedBackground;
    ShapeDrawable unfocusedBottomStripe;

    public int getUnfocusedEditTextLineColor() {
        return unfocusedEditTextLineColor;
    }

    public int getFocusedEditTextLineColor() {
        return focusedEditTextLineColor;
    }

    public int getFocusedBackgroundColor() {
        return focusedBackgroundColor;
    }

    public int getUnfocusedBackgroundColor() {
        return unfocusedBackgroundColor;
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
        notifyUiChanges();
    }

    public SimpleEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        notifyUiChanges();
    }

    public SimpleEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        notifyUiChanges();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SimpleEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        notifyUiChanges();
    }


    private void init() {
        focusedEditTextLineColor = Color.YELLOW;
        unfocusedEditTextLineColor = Color.BLACK;
        focusedBackgroundColor = getContext().getResources().getColor(R.color.default_androud_bk);
        unfocusedBackgroundColor = getContext().getResources().getColor(R.color.default_androud_bk);
        //---------------------
         focusedBackground = new ShapeDrawable();
        focusedBackground.getPaint().setColor(getContext().getResources().getColor(R.color.default_androud_bk));
        focusedBackground.setPadding(0, 0, 0, HEIGHT_BETWEEN_TEXT_AND_LINE);
         focusedBottomStripe = new ShapeDrawable();
        focusedBottomStripe.getPaint().setColor(focusedEditTextLineColor);
        focusedBottomStripe.setPadding(0, 0, 0, STROKE_SIZE);
        //---------------------------------------
         unfocusedBackground = new ShapeDrawable();
        unfocusedBackground.getPaint().setColor(getContext().getResources().getColor(R.color.default_androud_bk));
        unfocusedBackground.setPadding(0, 0, 0, HEIGHT_BETWEEN_TEXT_AND_LINE);
         unfocusedBottomStripe = new ShapeDrawable();
        unfocusedBottomStripe.getPaint().setColor(unfocusedEditTextLineColor);
        unfocusedBottomStripe.setPadding(0, 0, 0, STROKE_SIZE);
        //---------------------------------------
        Drawable[] focusedDrawable = {focusedBottomStripe, focusedBackground};
        layerFocused = new LayerDrawable(focusedDrawable);
        layerFocused.setLayerInset(1, 0, 0, 0, 10);


        Drawable[] unfocusedDrawable = {unfocusedBottomStripe, unfocusedBackground};
        layerUnfocused = new LayerDrawable(unfocusedDrawable);
        layerUnfocused.setLayerInset(1, 0, 0, 0, 10);
        if(isFocused())
            this.setBackground(layerFocused);
        else
            this.setBackground(layerUnfocused);

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
