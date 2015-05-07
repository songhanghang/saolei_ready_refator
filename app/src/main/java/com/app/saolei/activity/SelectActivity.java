package com.app.saolei.activity;

import java.security.PublicKey;

import MediaMusic.MusicMang;
import SoundPoll.Sound;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class SelectActivity extends Activity {
  public ImageView easy;
  public ImageView easy_yinying;
  public ImageView medium;
  public ImageView medium_yinying;
  public ImageView hard;
  public ImageView hard_yinying;
  public ImageView custom;
  public ImageView custom_yinying;
  public static int Game_NanDu = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_select);
    easy = (ImageView) findViewById(R.id.easy);
    easy_yinying = (ImageView) findViewById(R.id.easy_yinying);
    medium = (ImageView) findViewById(R.id.medum);
    medium_yinying = (ImageView) findViewById(R.id.medum_yinying);
    hard = (ImageView) findViewById(R.id.hard);
    hard_yinying = (ImageView) findViewById(R.id.hard_yinyang);
//		custom = (ImageView) findViewById(R.id.custom);
//		custom_yinying = (ImageView) findViewById(R.id.custom_yinying);
    easy.setOnTouchListener(clickListener);
    medium.setOnTouchListener(clickListener);
    hard.setOnTouchListener(clickListener);
//		custom.setOnTouchListener(clickListener);
  }

  View.OnTouchListener clickListener = new OnTouchListener() {
    public int action;
    public Intent intent = new Intent();

    @Override
    public boolean onTouch(View v, MotionEvent event) {
      // TODO Auto-generated method stub
      action = event.getAction();

      intent.setClass(SelectActivity.this, GameActivity.class);
      switch (v.getId()) {
        case R.id.easy:
          zhuangtai(easy_yinying);
          Game_NanDu = 0;
          break;
        case R.id.medum:
          zhuangtai(medium_yinying);
          Game_NanDu = 1;
          break;
        case R.id.hard:
          zhuangtai(hard_yinying);
          Game_NanDu = 2;
          break;
        //�Զ���
//			case R.id.custom:
//				zhuangtai(custom_yinying);
//				Game_NanDu = 3;
//				break;

        default:
          break;
      }
      return true;
    }

    public void zhuangtai(ImageView view) {
      switch (action) {
        case MotionEvent.ACTION_DOWN:
          if (SetActivity.isopsound) {
            Sound.paly(Sound.button);
          }
          view.setVisibility(View.VISIBLE);
          break;
        case MotionEvent.ACTION_UP:
          view.setVisibility(View.INVISIBLE);
          startActivity(intent);
          break;
        default:
          break;
      }
    }
  };

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.select, menu);
    return true;
  }

  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    MusicMang.start();
    super.onResume();
  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    MusicMang.pasue();
    super.onPause();
  }
}
