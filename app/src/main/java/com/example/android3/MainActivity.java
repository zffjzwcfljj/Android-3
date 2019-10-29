package com.example.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView show;
    private EditText input;
    private Button button, button2,button3;
    private CheckBox box1,box2;
    private RadioButton radio1,radio2;
    int flag1 = 0;
    String str = "喜欢喝";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box1 = (CheckBox)findViewById(R.id.box1);
        box1.setOnClickListener(this);
        box2 = (CheckBox)findViewById(R.id.box2);
        box2.setOnClickListener(this);
        show = (TextView) findViewById(R.id.show);
        input = (EditText) findViewById(R.id.input2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        final RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);

        radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if(isChecked)
                    flag1 = 1;
            }
        });

        radio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if(isChecked)
                    flag1 = 2;
            }
        });


        box1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    str = str+"可乐";
            }
        });
        box2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    str = str+"雪碧";
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.radio1:
                flag1 = 1;
                break;
            case R.id.radio2:
                flag1 = 2;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                input.setText("button按钮被单击啦啦啦！");
                break;
            case R.id.button2:
                if (flag1 == 1 )
                    show.setText("zff"+str);
                else if (flag1 == 2)
                    show.setText("zxy"+str);
                break;
            case R.id.button3:
                str = "";
                show.setText(str);
                str = "喜欢喝";
                break;

        }
    }
}