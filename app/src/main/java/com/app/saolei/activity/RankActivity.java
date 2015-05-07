package com.app.saolei.activity;

import java.util.ArrayList;
import java.util.List;

import DB.SqlMang;
import MediaMusic.MusicMang;
import Uers.Uers;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RankActivity extends Activity {
  public ListView listView_Us;
  public SqlMang mang;
  public ImageView button_hard;
  public ImageView button_hard_blg;
  public ImageView button_easy;
  public ImageView button_easy_blg;
  public ImageView button_mediu;
  public ImageView button_mediu_blg;
  public Myadapter adapter;

  public ArrayList<Uers> arrayList;
  // �л�������״̬
  public int index = 0;

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
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rank);
    mang = new SqlMang(this);
    listView_Us = (ListView) findViewById(R.id.Listview_Us);
    button_hard = (ImageView) findViewById(R.id.image_hard);
    button_hard_blg = (ImageView) findViewById(R.id.image_hard_blg);
    button_easy = (ImageView) findViewById(R.id.image_esay);
    button_easy_blg = (ImageView) findViewById(R.id.image_esay_blg);
    button_mediu = (ImageView) findViewById(R.id.image_zhengchang);
    button_mediu_blg = (ImageView) findViewById(R.id.image_zhengchang_blg);
    button_easy.setOnTouchListener(listener);
    button_mediu.setOnTouchListener(listener);
    button_hard.setOnTouchListener(listener);
    arrayList = mang.selcet(index);
    adapter = new Myadapter();
    listView_Us.setAdapter(adapter);
  }

  View.OnTouchListener listener = new View.OnTouchListener() {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
      // TODO Auto-generated method stub
      switch (v.getId()) {
        case R.id.image_esay:
          index = 0;
          arrayList = mang.selcet(index);
          adapter.notifyDataSetChanged();
          button_easy_blg.setVisibility(View.INVISIBLE);
          button_mediu_blg.setVisibility(View.VISIBLE);
          button_hard_blg.setVisibility(View.VISIBLE);
          break;
        case R.id.image_hard:
          index = 2;
          arrayList = mang.selcet(index);
          adapter.notifyDataSetChanged();
          button_easy_blg.setVisibility(View.VISIBLE);
          button_mediu_blg.setVisibility(View.VISIBLE);
          button_hard_blg.setVisibility(View.INVISIBLE);
          break;
        case R.id.image_zhengchang:
          index = 1;
          arrayList = mang.selcet(index);
          adapter.notifyDataSetChanged();
          button_easy_blg.setVisibility(View.VISIBLE);
          button_mediu_blg.setVisibility(View.INVISIBLE);
          button_hard_blg.setVisibility(View.VISIBLE);
          break;

        default:
          break;
      }
      return false;
    }

  };

  class Myadapter extends BaseAdapter {
    @Override
    public int getCount() {
      // TODO Auto-generated method stub
      return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
      // TODO Auto-generated method stub
      return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
      // TODO Auto-generated method stub
      return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      // TODO Auto-generated method stub
      if (convertView == null) {
        convertView = getLayoutInflater().inflate(R.layout.listsun,
            null);
      }
      TextView text1 = (TextView) convertView
          .findViewById(R.id.textView_list_easy);
      TextView text2 = (TextView) convertView
          .findViewById(R.id.textView_name);
      TextView text3 = (TextView) convertView
          .findViewById(R.id.textView_time);
      text1.setText("" + (position + 1));
      text2.setText(arrayList.get(position).getName());
      text3.setText("" + arrayList.get(position).getTime());
      return convertView;
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.rank, menu);
    return true;
  }

}
