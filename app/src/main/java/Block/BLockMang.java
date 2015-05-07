package Block;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.app.saolei.activity.LogoActivity;
import com.app.saolei.activity.R;
import com.app.saolei.activity.R.drawable;

public class BLockMang {
  public int hang;
  public int lie;
  public int which_coler;
  public int nandu;
  public static Bitmap[] bitmaps;
  public Block[][] blocks;
  public Block block_beijing;
  public Block block_Biaoji;
  public Block block_Biaoji_qizhi;
  public Block block_smile;
  public static Bitmap lefttime, righttime;
  public static int Size = 0;
  public int ids[];
  public Context context;
  public boolean isqizhi = true;
  public Paint paint = new Paint();
  public Bitmap smile;
  public Bitmap[] smile_state = new Bitmap[4];
  public int[] smile_id = {R.drawable.newgame_10_smile,
      R.drawable.newgame_11_surprise, R.drawable.newgame_12_cool,
      R.drawable.newgame_13_cry};
  public int smile_number = 0;

  public BLockMang(Context context, int hang, int lie, int which) {
    this.context = context;
    this.hang = hang;
    this.lie = lie;
    this.which_coler = which;
    switch (which) {
      case 0:
        blocks = new Block[hang][lie];
        for (int i = 0; i < hang; i++) {
          for (int j = 0; j < lie; j++) {

          }
        }
        break;
      case 1:

        break;
      case 2:

        break;
      case 3:

        break;

      default:
        break;
    }
  }

  public BLockMang(Context context, int nandu, int which) {
    this.context = context;
    this.nandu = nandu;
    this.which_coler = which;

    switch (which) {
      case 0:
        ids = new int[]{R.drawable.metal_00, R.drawable.metal_01,
            R.drawable.metal_02, R.drawable.metal_03,
            R.drawable.metal_04, R.drawable.metal_05,
            R.drawable.metal_06, R.drawable.metal_07,
            R.drawable.metal_08, R.drawable.metal_09,
            R.drawable.metal_10_flag_yes, R.drawable.metal_11,
            R.drawable.metal_12, R.drawable.metal_13,
            R.drawable.metal_14, R.drawable.metal_15_flag_no,
            R.drawable.metal_16, R.drawable.metal_17_bg,};

        break;
      case 1:
        ids = new int[]{R.drawable.beach_00, R.drawable.beach_01,
            R.drawable.beach_02, R.drawable.beach_03,
            R.drawable.beach_04, R.drawable.beach_05,
            R.drawable.beach_06, R.drawable.beach_07,
            R.drawable.beach_08, R.drawable.beach_09,
            R.drawable.beach_10_flag_yes, R.drawable.beach_11,
            R.drawable.beach_12, R.drawable.beach_13,
            R.drawable.beach_14, R.drawable.beach_15_flag_no,
            R.drawable.beach_16, R.drawable.beach_17_bg,};
        break;
      case 2:
        ids = new int[]{R.drawable.grass_00, R.drawable.grass_01,
            R.drawable.grass_02, R.drawable.grass_03,
            R.drawable.grass_04, R.drawable.grass_05,
            R.drawable.grass_06, R.drawable.grass_07,
            R.drawable.grass_08, R.drawable.grass_09,
            R.drawable.grass_10_flag_yes, R.drawable.grass_11,
            R.drawable.grass_12, R.drawable.grass_13,
            R.drawable.grass_14, R.drawable.grass_15_flag_no,
            R.drawable.grass_16, R.drawable.grass_17_bg,};
        break;
      case 3:
        ids = new int[]{R.drawable.snow_00, R.drawable.snow_01,
            R.drawable.snow_02, R.drawable.snow_03, R.drawable.snow_04,
            R.drawable.snow_05, R.drawable.snow_06, R.drawable.snow_07,
            R.drawable.snow_08, R.drawable.snow_09,
            R.drawable.snow_10_flag_yes, R.drawable.snow_11,
            R.drawable.snow_12, R.drawable.snow_13, R.drawable.snow_14,
            R.drawable.snow_15_flag_no, R.drawable.snow_16,
            R.drawable.snow_17_bg,};
        break;

      default:
        break;
    }
    switch (nandu) {
      case 0:
        Size = 10;
        fengzhuang();
        break;

      case 1:
        Size = 16;
        fengzhuang();
        break;
      case 2:
        Size = 20;
        fengzhuang();
        break;

      default:
        break;
    }

  }

  public void drawaall(Canvas canvas) {
    block_beijing.drow(canvas);
    if (isqizhi) {
      block_Biaoji.drow(canvas);
    } else {
      block_Biaoji_qizhi.drow(canvas);
    }
    block_smile.drow(canvas);
    canvas.drawBitmap(lefttime, 0, 0, paint);
    canvas.drawBitmap(righttime, LogoActivity.Wide - righttime.getWidth(),
        0, paint);
    canvas.drawBitmap(smile_state[smile_number], LogoActivity.Wide / 2 - smile.getWidth() / 2, 0, paint);
    for (int i = 0; i < blocks.length; i++) {
      for (int j = 0; j < blocks[i].length; j++) {
        blocks[i][j].drow(canvas);
      }
    }
  }

  public void fengzhuang() {
    blocks = new Block[Size][Size];
    bitmaps = new Bitmap[ids.length];
    for (int i = 0; i < ids.length; i++) {
      bitmaps[i] = BitmapFactory.decodeResource(context.getResources(),
          ids[i]);
      int w = LogoActivity.Wide;
      int h = LogoActivity.Heigh;
      bitmaps[i] = Bitmap.createScaledBitmap(bitmaps[i], (w - w / 10)
          / Size, (w - w / 10) / Size, true);
    }
    for (int i = 0; i < blocks.length; i++) {
      for (int j = 0; j < blocks[i].length; j++) {
        int wide = bitmaps[0].getWidth();
        int heght = bitmaps[0].getWidth();
        blocks[i][j] = new Block(LogoActivity.Wide / 20 + j * wide, 190
            + i * heght, bitmaps[0]);
      }
    }
    Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
        ids[17]);
    bitmap = Bitmap.createScaledBitmap(bitmap, LogoActivity.Wide,
        LogoActivity.Heigh, true);
    block_beijing = new Block(0, 0, bitmap);
    Bitmap bitmap_biaoji = BitmapFactory.decodeResource(
        context.getResources(), R.drawable.newgame_03_btnmine);
    bitmap_biaoji = Bitmap.createScaledBitmap(bitmap_biaoji,
        LogoActivity.Wide / 4, LogoActivity.Heigh / 8, true);
    block_Biaoji = new Block(10, (LogoActivity.Heigh / 8) * 7,
        bitmap_biaoji);
    Bitmap bitmap_Biaoji_qizhi = BitmapFactory.decodeResource(
        context.getResources(), R.drawable.newgame_04_btnflag);
    bitmap_Biaoji_qizhi = Bitmap.createScaledBitmap(bitmap_Biaoji_qizhi,
        LogoActivity.Wide / 4, LogoActivity.Heigh / 8, true);
    block_Biaoji_qizhi = new Block(10, (LogoActivity.Heigh / 8) * 7,
        bitmap_Biaoji_qizhi);
    smile = BitmapFactory.decodeResource(context.getResources(),
        R.drawable.newgame_01_smilebg);
    block_smile = new Block(LogoActivity.Wide / 2 - smile.getWidth() / 2,
        0, smile);
    lefttime = BitmapFactory.decodeResource(context.getResources(),
        R.drawable.newgame_00_minebg);
    righttime = BitmapFactory.decodeResource(context.getResources(),
        R.drawable.newgame_02_timebg);
    for (int i = 0; i < smile_id.length; i++) {
      smile_state[i] = BitmapFactory.decodeResource(context.getResources(), smile_id[i]);
    }

  }

}
