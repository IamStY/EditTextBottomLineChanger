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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    SimpleEditText et_first;
    SimpleEditText et_second;
    Button button;
     int underLineColor1;
    int underLineColor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et_first = (SimpleEditText)this.findViewById(R.id.et_first);
        et_second = (SimpleEditText)this.findViewById(R.id.et_second);
        button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        underLineColor1 = getColorHex(et_first.getText().toString());
        underLineColor2 = getColorHex(et_second.getText().toString());
        if (underLineColor1 != -1 && underLineColor2 != -1) {

            et_first.setFocusedEditTextLineColor(underLineColor1);
            et_first.setUnfocusedEditTextLineColor(underLineColor2);
            et_first.setFocusedBackgroundColor(Color.DKGRAY);
            et_first.setUnfocusedBackgroundColor(Color.GRAY);

            et_second.setFocusedEditTextLineColor(underLineColor1);
            et_second.setUnfocusedEditTextLineColor(underLineColor2);
            et_first.notifyUiChanges();
            et_second.notifyUiChanges();
        } else {
            Toast.makeText(getApplicationContext(), "please check your hex color format", Toast.LENGTH_SHORT).show();
        }

    }
    public int getColorHex(String UserColor){

       try {
            int colorID =Color.parseColor(UserColor);
            Log.i("colorID",colorID+"");
            return colorID;
        }catch (Exception e){
            Log.i("colorID","-1");
            return  -1;
        }
    }
}
