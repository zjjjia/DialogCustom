package com.example.customdialog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zyyoona7.wheel.WheelView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PickerSelectorDialog.PickerSelectorListener {

    private static final String TAG = "MainActivity";

    private MyDialog myDialog;
    private Button button;
    private WheelView mWheelView;

    private ArrayList<String> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        data.add("自动");
        data.add("日光");
        data.add("阴天");
        data.add("钨丝");
        data.add("荧光灯");


        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PickerSelectorDialog dialog = new PickerSelectorDialog(MainActivity.this);
                dialog.setSelectData(data);
                dialog.show();
            }
        });



        //customDialog();
        /*mWheelView = findViewById(R.id.wheel_view);
        mWheelView.setData(data);*/

    }

    @Override
    public void currentSelectItemPosition(int currentPosition) {
        Log.d(TAG, "currentSelectItemPosition: " + currentPosition);
    }

    private void customDialog() {
        myDialog=new MyDialog(MainActivity.this,R.style.MyDialog);
        myDialog.setTitle("警告！");
        myDialog.setMessage("警告：您的手机3秒钟内自爆");
        myDialog.setYesOnclickListener("确定", new MyDialog.onYesOnclickListener() {
            @Override
            public void onYesOnclick() {
                Toast.makeText(getApplicationContext(),"拜拜，我们来生见",Toast.LENGTH_LONG).show();
                myDialog.dismiss();
            }
        });
        myDialog.setNoOnclickListener("取消", new MyDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                Toast.makeText(getApplicationContext(),"明智的选择",Toast.LENGTH_LONG).show();
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
}
