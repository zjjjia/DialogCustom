package com.example.dialogcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data.add("自动");
        data.add("日光");
        data.add("阴天");
        data.add("钨丝");
        data.add("荧光灯");

        WheelView wheelView = findViewById(R.id.wheel_view);
        wheelView.setItems(data);

        PickerSelectorDialog dialog = new PickerSelectorDialog(this);
        dialog.setSelectData(data);
        dialog.show();

        dialog.setPickerSelectorListener(new PickerSelectorDialog.PickerSelectorListener() {
            @Override
            public void currentSelectItemPosition(int currentPosition) {
                Log.d(TAG, "currentSelectItemPosition: " + currentPosition);
            }
        });
    }
}
