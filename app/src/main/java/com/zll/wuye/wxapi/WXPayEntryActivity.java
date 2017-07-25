package com.zll.wuye.wxapi;

import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.zll.wuye.R;
import com.zll.wuye.activity.MainActivity;
import com.zll.wuye.fragment.homepage.PaymentSuccess;
import com.zll.wuye.fragment.homepage.payment.Constants;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler{
	
	private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivityMicroMsg.SDKSample.WXPayEntryActivity";
	
    private IWXAPI api;
	private Button bt;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);
    	api = WXAPIFactory.createWXAPI(this, Constants.APP_ID);
        api.handleIntent(getIntent(), this);
		bt = (Button) findViewById(R.id.weixin_fanhui);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					Intent intent = new Intent(WXPayEntryActivity.this, MainActivity.class);
					intent.putExtra("alipay","alipay");
					startActivity(intent);
			}
		});
    }

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
        api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	public void onResp(BaseResp resp) {
		Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);

		if(resp.errCode==0){
			Toast.makeText(WXPayEntryActivity.this,"支付成功",Toast.LENGTH_SHORT).show();
		}else if(resp.errCode==-1){
			Toast.makeText(WXPayEntryActivity.this,"支付失败",Toast.LENGTH_SHORT).show();
			finish();
		}else if(resp.errCode==-2){
			Toast.makeText(WXPayEntryActivity.this,"取消",Toast.LENGTH_SHORT).show();
			finish();
		}
	}
}