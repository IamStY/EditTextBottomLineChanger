package com.example.stevenyang.easyedittextbottomlinecolorexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stevenyang.easyedittextcolorchanging.SimpleEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SimpleEditText et_first;
    SimpleEditText et_second;
    Button button;
    int underLineColor1;
    int underLineColor2;
    EditText ed_strokeFocusedSize,ed_strokeUnfocusedSize , ed_focus_padding,ed_unfocus_padding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et_first = (SimpleEditText)this.findViewById(R.id.et_first);
        et_second = (SimpleEditText)this.findViewById(R.id.et_second);
        ed_strokeFocusedSize = (EditText)this.findViewById(R.id.ed_strokeFocusedSize);
        ed_strokeUnfocusedSize = (EditText)this.findViewById(R.id.ed_strokeunfocusedSize);
        ed_focus_padding = (EditText)this.findViewById(R.id.ed_focus_padding);
        ed_unfocus_padding = (EditText)this.findViewById(R.id.ed_unfocused_padding);
        button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==button) {
            underLineColor1 = getColorHex(et_first.getText().toString());
            underLineColor2 = getColorHex(et_second.getText().toString());
            if (underLineColor1 != -1 && underLineColor2 != -1) {

                et_first.setFocusedEditTextLineColor(underLineColor1);
                et_first.setUnfocusedEditTextLineColor(underLineColor2);
                et_second.setFocusedEditTextLineColor(underLineColor1);
                et_second.setUnfocusedEditTextLineColor(underLineColor2);

                et_first.setFocusedStrokeSize(Integer.valueOf(ed_strokeFocusedSize.getText().toString()));
                et_first.setUnfocusedStrokeSize(Integer.valueOf(ed_strokeUnfocusedSize.getText().toString()));
                et_second.setFocusedStrokeSize(Integer.valueOf(ed_strokeFocusedSize.getText().toString()));
                et_second.setUnfocusedStrokeSize(Integer.valueOf(ed_strokeUnfocusedSize.getText().toString()));

                et_first.setFocusedTextPaddingBottom(Integer.valueOf(ed_focus_padding.getText().toString()));
                et_first.setUnfocusedTextPaddingBottom(Integer.valueOf(ed_unfocus_padding.getText().toString()));
                et_second.setFocusedTextPaddingBottom(Integer.valueOf(ed_focus_padding.getText().toString()));
                et_second.setUnfocusedTextPaddingBottom(Integer.valueOf(ed_unfocus_padding.getText().toString()));

                et_first.notifyUiChanges();
                et_second.notifyUiChanges();
            } else {
                Toast.makeText(getApplicationContext(), "please check your hex color format", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public int getColorHex(String UserColor) {

        try {
            int colorID = Color.parseColor(UserColor);
            Log.i("colorID", colorID + "");
            return colorID;
        } catch (Exception e) {
            Log.i("colorID", "-1");
            return -1;
        }
    }
}
