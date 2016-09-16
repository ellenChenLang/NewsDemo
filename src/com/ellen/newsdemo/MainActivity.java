package com.ellen.newsdemo;

import com.ellen.newsdemo.util.GetNewsUtil;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
TextView tv1;
Context mContext;
MyHandel mh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	private void init() {
	 tv1 = (TextView) findViewById(R.id.tv1);
	 tv1.setOnClickListener(this);	
	 mContext = this;
	  mh = new MyHandel();
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.tv1){
			
			MyThread mt = new MyThread();
			mt.start();
			
		}
		
	}
	
	class MyHandel extends Handler{
		
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			tv1.setText((String)msg.obj);
		}
	}

	class MyThread extends Thread{

		@Override
		public void run() {
			String s = GetNewsUtil.getNews(mContext);
			Message msg = new Message();
			msg.obj = s;
			mh.sendMessage(msg);
			
			
		}
	}
	
}
