package com.app.saolei.activity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.security.PublicKey;

import DB.SqlMang;
import GameView.GameViewMang;
import Uers.Uers;
import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends Activity {
  public Button button_ok;
  public EditText editText;
  public Uers uers;
  public SqlMang sqlMang;
  public String string;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_input);
    try {
      FileInputStream inputStream = this.openFileInput("FileText");
      byte[] bs = new byte[20];
      int len = inputStream.read(bs);
      string = new String(bs, 0, len);
      inputStream.close();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    editText = (EditText) findViewById(R.id.editText_input);
    editText.setText(string);
    sqlMang = new SqlMang(this);
    button_ok = (Button) findViewById(R.id.button_ok);
    button_ok.setOnClickListener(clickListener);

  }

  View.OnClickListener clickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      String name = editText.getText().toString();
      try {
        FileOutputStream outputStream = InputActivity.this.openFileOutput("FileText", MODE_PRIVATE);
        outputStream.write(name.getBytes());
        outputStream.flush();
        outputStream.close();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      uers = new Uers(name, SelectActivity.Game_NanDu, GameViewMang.time);
      sqlMang.insert(SelectActivity.Game_NanDu, uers);
      System.out.println(SelectActivity.Game_NanDu);
      Intent intent = new Intent(InputActivity.this, RankActivity.class);
      startActivity(intent);
    }
  };

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.input, menu);
    return true;
  }

}
