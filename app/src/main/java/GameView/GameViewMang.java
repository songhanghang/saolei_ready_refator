package GameView;

import java.util.Random;

import com.app.saolei.activity.GameActivity;
import com.app.saolei.activity.SelectActivity;
import com.app.saolei.activity.SetActivity;

import Block.BLockMang;
import SoundPoll.Sound;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class GameViewMang {
  public Context context;
  public int GameState = 0;
  public static final int Game_ready = 0;
  public static final int Game_run = 1;
  public static final int Game_biaoji = 2;
  public static final int Game_win = 3;
  public static final int Game_lose = 4;
  public static int time;
  public int donghua = 0;
  public BLockMang bLockMang;
  public int index_i = 0, index_j = 0;
  public int biaoji = 0;
  public int i_1 = -1;
  int j_1 = -1;
  public int lei_baioji_number;
  public long starttime;
  public TimeLeiNumView timeView;

  public GameViewMang(Context context) {
    // TODO Auto-generated constructor stub
    this.context = context;
    timeView = new TimeLeiNumView(context);
  }

  public void onpiant(Canvas canvas) {
    // TODO Auto-generated method stub

    switch (GameState) {
      case Game_ready:
        // ����
        // bLockMang.blocks[donghua/bLockMang.Size][donghua%bLockMang.Size].drow(canvas);
        // donghua++;
        // if(donghua==bLockMang.Size*bLockMang.Size){
        // }

        break;
      case Game_run:

        canvas.drawColor(Color.BLACK);
        bLockMang.drawaall(canvas);
        timeView.drawtime(time, canvas);
        timeView.drawleinum(lei_baioji_number, canvas);
        break;
      case Game_biaoji:
        canvas.drawColor(Color.BLACK);
        bLockMang.drawaall(canvas);
        timeView.drawtime(time, canvas);
        timeView.drawleinum(lei_baioji_number, canvas);
        break;
      case Game_win:
        canvas.drawColor(Color.BLACK);
        bLockMang.drawaall(canvas);
        Paint paint = new Paint();
        paint.setTextSize(40);
        paint.setColor(Color.WHITE);
        canvas.drawText("��ϲ���أ�", 140, 140, paint);
        timeView.drawtime(time, canvas);
        timeView.drawleinum(lei_baioji_number, canvas);
        break;
      case Game_lose:
        canvas.drawColor(Color.BLACK);
        bLockMang.drawaall(canvas);
        timeView.drawtime(time, canvas);
        timeView.drawleinum(lei_baioji_number, canvas);
        break;
      default:
        break;
    }

  }

  public void onupdate() {
    // TODO Auto-generated method stub
    switch (GameState) {
      case Game_ready:
        starttime = System.currentTimeMillis();
        time = 0;

        SharedPreferences preferences = context.getSharedPreferences(
            "Seting", Context.MODE_PRIVATE);
        int index = preferences.getInt("INDEX", 0);
        bLockMang = new BLockMang(context, SelectActivity.Game_NanDu, index);
        int[] array = new int[bLockMang.Size * bLockMang.Size];
        Random random = new Random();
        int a = 0;
        for (int i = 0; i < bLockMang.Size * bLockMang.Size; i++) {
          array[i] = a;
          a++;
        }
        for (int i = 0; i < bLockMang.Size * bLockMang.Size / 8; i++) {
          int tp = random.nextInt(bLockMang.Size * bLockMang.Size);
          int temp = array[i];
          array[i] = array[tp];
          array[tp] = temp;
        }
        for (int i = 0; i < bLockMang.Size * bLockMang.Size / 8; i++) {
          bLockMang.blocks[array[i] / bLockMang.Size][array[i]
              % bLockMang.Size].ishave = true;
        }
        lei_baioji_number = bLockMang.Size * bLockMang.Size / 8;
        GameState = Game_run;
        break;
      case Game_run:
        long endtime = System.currentTimeMillis();
        if (endtime - starttime >= 1000) {
          time++;
          starttime = endtime;

        }
        break;
      case Game_biaoji:
        long biaojitime = System.currentTimeMillis();
        if (biaojitime - starttime >= 1000) {
          time++;
          starttime = biaojitime;
        }
        break;
      case Game_win:

        break;
      case Game_lose:

        break;

      default:
        break;
    }
  }

  public void ACTION_UP(MotionEvent event) {
    // TODO Auto-generated method stub
    // int action=MotionEvent
    int x = (int) event.getX();
    int y = (int) event.getY();
    switch (GameState) {
      case Game_ready:

        break;
      case Game_run:
        if (bLockMang.block_Biaoji.isclick(x, y)) {
          GameState = Game_biaoji;
          for (int i = 0; i < bLockMang.Size; i++) {
            for (int j = 0; j < bLockMang.Size; j++) {
              if (bLockMang.blocks[i][j].number == -1) {
                bLockMang.blocks[i][j].number = 9;
              }
            }
          }
          bLockMang.isqizhi = false;
        }
        for (int i = 0; i < bLockMang.blocks.length; i++) {
          for (int j = 0; j < bLockMang.blocks[i].length; j++) {
            if (bLockMang.blocks[i][j].isclick(x, y)) {
              if (bLockMang.blocks[i][j].number == 10)
                continue;
              if (bLockMang.blocks[i][j].ishave == true) {
                // ��ը��Ч
                bLockMang.smile_number = 3;
                Sound.paly(Sound.explode);
                bLockMang.blocks[i][j].number = 14;
                for (int g = 0; g < bLockMang.Size; g++) {
                  for (int h = 0; h < bLockMang.Size; h++) {
                    if (g == i && h == j)
                      continue;
                    if (bLockMang.blocks[g][h].ishave == true) {
                      bLockMang.blocks[g][h].number = 13;

                    }
                    if (bLockMang.blocks[g][h].ishave == false
                        && bLockMang.blocks[g][h].number == 10) {
                      // ��û���ף���ǳ��׵ĸ���ʾ��ʾ����
                      bLockMang.blocks[g][h].number = 12;
                    }
                  }
                }
                GameState = Game_lose;
              } else {
                bLockMang.smile_number = 0;
                digui(i, j);
              }
            }
          }
        }
        int win = 0;
        for (int i = 0; i < bLockMang.Size; i++) {
          for (int j = 0; j < bLockMang.Size; j++) {
            if (bLockMang.blocks[i][j].isopen) {
              win++;
            }
          }
        }
        if (win == bLockMang.Size * bLockMang.Size
            - bLockMang.Size * bLockMang.Size / 8) {
          GameState = Game_win;
          // ��ʤ
          bLockMang.smile_number = 2;
          Sound.paly(Sound.winneer);
        }
        if (bLockMang.block_smile.isclick(x, y)) {
          GameState = Game_ready;
          bLockMang.smile_number = 0;
        }
        break;
      case Game_biaoji:
        if (bLockMang.block_smile.isclick(x, y)) {
          GameState = Game_ready;
          bLockMang.smile_number = 0;
        }
        for (int i = 0; i < bLockMang.Size; i++) {
          for (int j = 0; j < bLockMang.Size; j++) {
            if (bLockMang.blocks[i][j].isclick(x, y)
                && (bLockMang.blocks[i][j].number == 9
                || bLockMang.blocks[i][j].number == 10 || bLockMang.blocks[i][j].number == 11)) {
              // �ж��Ƿ�������ͬһ�������������״̬�������һ��״̬
              if (biaoji > 2) {
                biaoji = 0;
              }
              if (i == i_1 && j == j_1) {
                if (biaoji == 0) {
                  bLockMang.blocks[i][j].number = 10;
                  Sound.paly(Sound.flag);
                  lei_baioji_number--;
                } else if (biaoji == 1) {
                  bLockMang.blocks[i][j].number = 11;
                  Sound.paly(Sound.question);
                  lei_baioji_number++;
                } else {
                  bLockMang.blocks[i][j].number = 9;
                }
              } else {
                if (bLockMang.blocks[i][j].number != 10 && bLockMang.blocks[i][j].number != 11) {
                  biaoji = 0;
                  Sound.paly(Sound.flag);
                  bLockMang.blocks[i][j].number = 10;
                  lei_baioji_number--;
                } else if (bLockMang.blocks[i][j].number == 10) {
                  bLockMang.blocks[i][j].number = 11;
                  Sound.paly(Sound.question);
                  lei_baioji_number++;
                  biaoji = 1;
                } else {
                  bLockMang.blocks[i][j].number = 9;
                  biaoji = 2;
                }
              }
              biaoji++;
              i_1 = i;
              j_1 = j;
            }
          }
        }
        if (bLockMang.block_Biaoji.isclick(x, y)) {
          GameState = Game_run;
          for (int i = 0; i < bLockMang.Size; i++) {
            for (int j = 0; j < bLockMang.Size; j++) {
              if (bLockMang.blocks[i][j].number == 9) {
                bLockMang.blocks[i][j].number = -1;
              }
            }
          }
          // �ж��Ƿ�������ͼƬ
          bLockMang.isqizhi = true;
        }
        break;
      case Game_win:

        GameActivity.activity.gotoInput();
        break;

      case Game_lose:
        // bLockMang.smile_number=3;
        if (bLockMang.block_smile.isclick(x, y)) {
          GameState = Game_ready;
          bLockMang.smile_number = 0;
        }
        break;

      default:
        break;
    }

  }

  public void ACTION_DOWN(MotionEvent event) {
    // TODO Auto-generated method stub
    switch (GameState) {
      case Game_ready:
        break;
      case Game_run:
        bLockMang.smile_number = 1;
        break;
      case Game_biaoji:
        break;
      case Game_win:

        break;
      case Game_lose:
        // bLockMang.smile_number=3;
        break;

      default:
        break;
    }
  }

  private void digui(int m, int n) {
    // TODO Auto-generated method stub
    int num = 0;
    for (int i = m - 1; i < m + 2; i++) {
      if (i < 0 || i > bLockMang.Size - 1) {
        continue;
      }
      for (int j = n - 1; j < n + 2; j++) {
        if (j < 0 || j > bLockMang.Size - 1 || (i == m && j == n)) {
          continue;
        }
        if (bLockMang.blocks[i][j].ishave == true) {
          num++;
        }
      }
    }
    switch (num) {
      case 0:
        // �����ݹ���Ч�����ܣ�û����
        Sound.paly(Sound.isflag);
        bLockMang.blocks[m][n].number = 0;
        bLockMang.blocks[m][n].isopen = true;
        for (int i = m - 1; i < m + 2; i++) {
          if (i < 0 || i > bLockMang.Size - 1) {
            continue;
          }
          for (int j = n - 1; j < n + 2; j++) {
            if (j < 0 || j > bLockMang.Size - 1
                || bLockMang.blocks[i][j].number != -1
                || (i == m && j == n))
              continue;
            bLockMang.blocks[i][j].number = 0;
            bLockMang.blocks[i][j].isopen = true;
            digui(i, j);
          }
        }

        break;
      default:
        bLockMang.blocks[m][n].number = num;
        bLockMang.blocks[m][n].isopen = true;
        break;
    }
  }

}