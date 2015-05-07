package com.app.saolei.activity;

import MediaMusic.MusicMang;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HelpActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_help);
  }

  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
    MusicMang.start();
  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    MusicMang.pasue();
    super.onPause();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.help, menu);
    return true;
  }

}
