package com.app.saolei.activity;


import LogoView.LogoView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;

public class LogoActivity extends Activity {
    public static int  Wide=0;
    public static int  Heigh=0;
    //����ʹ���Լ�new�Ķ����Լ�new�Ķ����û�д���������Щ���ܡ�
    public static LogoActivity logoActivity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		logoActivity = this;
	   //�õ��豸�ĳ����
		DisplayMetrics metrics=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		Wide=metrics.widthPixels;
		Heigh=metrics.heightPixels;
		LogoView view=new LogoView(this);
		setContentView(view);

		
	}	
   public void gomenu() {
   	Intent intent=new Intent(LogoActivity.this, MenuActivity.class);
   	startActivity(intent);
   	finish();
   }
}

