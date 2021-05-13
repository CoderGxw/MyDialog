package com.sqjz.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import static com.sqjz.dialog.Constants.URL_ERROR_CODE;

/**
 * 网络异常弹框
 * @author guoxw
 * @date 2021/5/13
 **/
public class NetworkUnConnectDialog extends Dialog implements View.OnClickListener{
    private static final String TAG = "NetworkUnConnectDialog";
    private final Context context;
    private Button mErrorBt;
    private TextView mErrorDescTv;
    private TextView mErrorCodeTv;
    private String mErrorDesc;
    private String mCode;
    private boolean mFullScreen =false;

    public NetworkUnConnectDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public NetworkUnConnectDialog(@NonNull Context context,boolean fullScreen) {
        super(context);
        this.context=context;
        this.mFullScreen =fullScreen;
    }
    public NetworkUnConnectDialog(@NonNull Context context,String code, String errorDesc) {
        super(context);
        this.mErrorDesc=errorDesc;
        this.context=context;
        this.mCode=code;
    }

    public NetworkUnConnectDialog(@NonNull Context context,String code, String errorDesc,boolean fullScreen) {
        super(context);
        this.mErrorDesc=errorDesc;
        this.context=context;
        this.mCode=code;
        this.mFullScreen =fullScreen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        bindView();
    }

    @SuppressLint("ResourceType")
    private void initWindow() {
        Window dialogWindow = getWindow();
        if (mFullScreen){
            NavigationUtils.dynamicHideNavigationBar(dialogWindow);
        }
        dialogWindow.setGravity(Gravity.CENTER);
        setContentView(R.layout.dialog_network_un_connect);
        setCanceledOnTouchOutside(false);
    }

    private void bindView() {
        mErrorBt =(Button)findViewById(R.id.dialog_network_un_connect_bt);
        mErrorBt.setOnClickListener(this);
        mErrorDescTv =(TextView)findViewById(R.id.dialog_network_un_connect_error_desc_tv);
        mErrorCodeTv =(TextView)findViewById(R.id.dialog_network_un_connect_error_code_tv);
        if (null!=mErrorDesc){
            mErrorDescTv.setText(mErrorDesc);
        }
        if (null!=mCode){
            mErrorCodeTv.setText("code:"+mCode);
        }else{
            mErrorCodeTv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.dialog_network_un_connect_bt) {
            this.cancel();
            //TODO 暴露一个点击接口
        }
    }
}
