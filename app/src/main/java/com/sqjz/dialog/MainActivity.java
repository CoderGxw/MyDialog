package com.sqjz.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainNetworkUnConnectDialogBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mainNetworkUnConnectDialogBt = (Button) findViewById(R.id.main_network_un_connect_dialog_bt);
        mainNetworkUnConnectDialogBt.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_network_un_connect_dialog_bt:
                NetworkUnConnectDialog networkUnConnectDialog= new NetworkUnConnectDialog(this);
                networkUnConnectDialog.show();
                break;
            default:break;
        }
    }
}