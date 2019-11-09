package com.example.dialogcustom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.util.ArrayList;

/**
 * @author : Jiabo
 * @date : 2019/11/8
 * @decription :
 */
public class PickerSelectorDialog extends Dialog {

    private static final String TAG = "PickerSelectorDialog";

    private Button mConfirmBtn;
    private WheelView mWheelView;
    private PickerSelectorListener mPickerSelectorListener;
    private ArrayList<String> mList = new ArrayList<>();

    public PickerSelectorDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.widget_picker_selector_dialog);

        initVew();
        initData();
    }

    private void initVew() {
        mConfirmBtn = findViewById(R.id.btn_confirm);


        mWheelView = findViewById(R.id.wheel_view);

        initEvent();
    }

    private void initData() {
        mWheelView.setItems(mList);
    }

    public void setSelectData(ArrayList<String> list) {
        if (list != null) {
            mList = list;
        }
    }

    private void initEvent() {
        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + mWheelView.getSeletedIndex());
                mPickerSelectorListener.currentSelectItemPosition(mWheelView.getSeletedIndex());
                dismiss();
            }
        });
    }

    public void setPickerSelectorListener(PickerSelectorListener listener) {
        mPickerSelectorListener = listener;
    }

    public interface PickerSelectorListener {
        void currentSelectItemPosition(int currentPosition);
    }
}
