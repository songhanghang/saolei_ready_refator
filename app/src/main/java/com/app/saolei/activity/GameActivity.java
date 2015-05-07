package com.app.saolei.activity;

import GameView.GameView;
import GameView.GameViewMang;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class GameActivity extends Activity {
  public static GameActivity activity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GameView gameView = new GameView(this);
    setContentView(gameView);
    activity = this;
  }

  @Override
  protected void onDestroy() {
    // TODO Auto-generated method stub
    super.onDestroy();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.game, menu);
    return true;
  }

  public void gotoInput() {
    Intent intent = new Intent(this, InputActivity.class);
    startActivity(intent);
  }
}
