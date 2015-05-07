package com.app.saolei.activity;

import MediaMusic.MusicMang;
import SoundPoll.Sound;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.drm.DrmStore.Action;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuActivity extends Activity {
  public ImageView image_newgame;
  public ImageView image_Y_newgame;
  public ImageView image_score;
  public ImageView image_Y_score;
  public ImageView image_setting;
  public ImageView image_Y_setting;
  public ImageView image_help;
  public ImageView image_Y_help;
  public ImageView face;
  public AnimationDrawable drawable;

  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    MusicMang.start();
    super.onResume();

  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    MusicMang.pasue();
  }

  @Override
  protected void onDestroy() {
    // TODO Auto-generated method stub
    super.onDestroy();
    MusicMang.close();
    Sound.Relive();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    //������������
    Sound.load(this);
    MusicMang.setUrl(this);
    SharedPreferences preferences = getSharedPreferences("Seting", Context.MODE_PRIVATE);
    SetActivity.isopmusic = preferences.getBoolean("ISOPMUSIC", true);
    SetActivity.isopsound = preferences.getBoolean("ISOPSOUND", false);
    image_newgame = (ImageView) findViewById(R.id.image_newgame);
    image_Y_newgame = (ImageView) findViewById(R.id.image_Y_game);
    image_score = (ImageView) findViewById(R.id.image_score);
    image_Y_score = (ImageView) findViewById(R.id.image_Y_score);
    image_setting = (ImageView) findViewById(R.id.image_set);
    image_Y_setting = (ImageView) findViewById(R.id.image_Y_setting);
    image_help = (ImageView) findViewById(R.id.image_help);
    image_Y_help = (ImageView) findViewById(R.id.image_Y_help);
    image_newgame.setOnTouchListener(listener);
    image_score.setOnTouchListener(listener);
    image_setting.setOnTouchListener(listener);
    image_help.setOnTouchListener(listener);

    //�����ҵ�id���õ�������start
    face = (ImageView) findViewById(R.id.image_face);
    drawable = (AnimationDrawable) face.getDrawable();
    drawable.start();
  }

  View.OnTouchListener listener = new View.OnTouchListener() {

    Intent intent = new Intent();

    @Override
    public boolean onTouch(View v, MotionEvent event) {
      // TODO Auto-generated method stub
      //����button����

      switch (v.getId()) {
        case R.id.image_newgame:
          zhuangtai(event, image_Y_newgame);
          intent.setClass(MenuActivity.this, SelectActivity.class);
          break;
        case R.id.image_score:
          zhuangtai(event, image_Y_score);
          intent.setClass(MenuActivity.this, RankActivity.class);
          break;
        case R.id.image_set:
          zhuangtai(event, image_Y_setting);
          intent.setClass(MenuActivity.this, SetActivity.class);
          break;
        case R.id.image_help:
          zhuangtai(event, image_Y_help);
          intent.setClass(MenuActivity.this, HelpActivity.class);
          break;
        default:
          break;
      }
      return true;
    }

    public void zhuangtai(MotionEvent event, ImageView view) {
      int action = event.getAction();
      switch (action) {
        case MotionEvent.ACTION_DOWN:
          Sound.paly(Sound.button);
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
    getMenuInflater().inflate(R.menu.menu, menu);
    return true;
  }

}
