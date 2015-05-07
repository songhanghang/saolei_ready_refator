package com.app.saolei.activity;

import MediaMusic.MusicMang;
import SoundPoll.Sound;
import android.R.bool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SetActivity extends Activity {
  public ImageView music, sound;
  public ImageView Whrite;
  public ImageView Whrite_box;
  public ImageView Yellow;
  public ImageView Yellow_box;
  public ImageView Green;
  public ImageView Green_box;
  public ImageView Blue;
  public ImageView Blue_box;
  public SharedPreferences preferences;
  public Editor editor;
  public static boolean isopmusic;
  public static boolean isopsound;
  public static int index = 0;

  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    MusicMang.start();
    super.onResume();

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    preferences = getSharedPreferences("Seting", Context.MODE_PRIVATE);
    // isopmusic = preferences.getBoolean("ISOPMUSIC", true);
    // isopsound = preferences.getBoolean("ISOPSOUND", false);
    // index = preferences.getInt("INDEX", 0);
    editor = preferences.edit();
    setContentView(R.layout.activity_set);

    music = (ImageView) findViewById(R.id.image_X);
    sound = (ImageView) findViewById(R.id.image_V);
    Whrite = (ImageView) findViewById(R.id.imageWirte);
    Whrite_box = (ImageView) findViewById(R.id.image_Wirte_box);
    Yellow = (ImageView) findViewById(R.id.imageYellow);
    Yellow_box = (ImageView) findViewById(R.id.image_Yellow_box);
    Green = (ImageView) findViewById(R.id.image_Green);
    Green_box = (ImageView) findViewById(R.id.image_Gereen_box);
    Blue = (ImageView) findViewById(R.id.imageBlue);
    Blue_box = (ImageView) findViewById(R.id.image_Blue_box);
    Whrite.setOnClickListener(clickListener);
    Yellow.setOnClickListener(clickListener);
    Green.setOnClickListener(clickListener);
    Blue.setOnClickListener(clickListener);
    music.setOnClickListener(clickListener);
    sound.setOnClickListener(clickListener);
    if (isopmusic) {
      music.setImageResource(R.drawable.msetting_audio_yes);
    } else {
      music.setImageResource(R.drawable.msetting_audio_no);
    }

    if (isopsound) {
      sound.setImageResource(R.drawable.msetting_audio_yes);
    } else {
      sound.setImageResource(R.drawable.msetting_audio_no);
    }
    switch (index) {
      case 0:
        Whrite_box.setVisibility(View.VISIBLE);
        break;
      case 1:
        Yellow_box.setVisibility(View.VISIBLE);
        break;

      case 2:
        Green_box.setVisibility(View.VISIBLE);
        break;

      case 3:
        Blue_box.setVisibility(View.VISIBLE);
        break;
      default:
        break;
    }

  }

  View.OnClickListener clickListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      Sound.paly(Sound.button);
      switch (v.getId()) {
        case R.id.imageWirte:
          index = 0;
          Whrite_box.setVisibility(View.VISIBLE);
          Yellow_box.setVisibility(View.INVISIBLE);
          Green_box.setVisibility(View.INVISIBLE);
          Blue_box.setVisibility(View.INVISIBLE);
          break;
        case R.id.imageYellow:
          index = 1;
          Whrite_box.setVisibility(View.INVISIBLE);
          Yellow_box.setVisibility(View.VISIBLE);
          Green_box.setVisibility(View.INVISIBLE);
          Blue_box.setVisibility(View.INVISIBLE);
          break;
        case R.id.image_Green:
          index = 2;
          Whrite_box.setVisibility(View.INVISIBLE);
          Yellow_box.setVisibility(View.INVISIBLE);
          Green_box.setVisibility(View.VISIBLE);
          Blue_box.setVisibility(View.INVISIBLE);
          break;
        case R.id.imageBlue:
          index = 3;
          Whrite_box.setVisibility(View.INVISIBLE);
          Yellow_box.setVisibility(View.INVISIBLE);
          Green_box.setVisibility(View.INVISIBLE);
          Blue_box.setVisibility(View.VISIBLE);
          break;
        case R.id.image_X:
          if (isopmusic) {
            music.setImageResource(R.drawable.msetting_audio_no);
            MusicMang.pasue();
            isopmusic = false;

          } else {
            music.setImageResource(R.drawable.msetting_audio_yes);
            isopmusic = true;
            MusicMang.start();

          }

          break;
        case R.id.image_V:
          if (isopsound) {
            sound.setImageResource(R.drawable.msetting_audio_no);
            isopsound = false;

          } else {
            sound.setImageResource(R.drawable.msetting_audio_yes);
            isopsound = true;

          }

          break;

        default:
          break;
      }

    }
  };

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.set, menu);
    return true;
  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    MusicMang.pasue();
    editor.putBoolean("ISOPMUSIC", isopmusic);
    editor.putBoolean("ISOPSOUND", isopsound);
    editor.putInt("INDEX", index);
    editor.commit();
  }
}
