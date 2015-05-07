package GameView;

import Block.BLockMang;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.app.saolei.activity.LogoActivity;
import com.app.saolei.activity.R;

public class TimeLeiNumView {
  public int ids[] = {R.drawable.time_0, R.drawable.time_1,
      R.drawable.time_2, R.drawable.time_3, R.drawable.time_4,
      R.drawable.time_5, R.drawable.time_6, R.drawable.time_7,
      R.drawable.time_8, R.drawable.time_9, R.drawable.time_10};
  public Bitmap[] bitmaps = new Bitmap[ids.length];
  public Paint paint;

  public TimeLeiNumView(Context context) {
    for (int i = 0; i < ids.length; i++) {
      bitmaps[i] = BitmapFactory.decodeResource(context.getResources(), ids[i]);
    }
  }

  public void drawtime(int time, Canvas canvas) {
    int x = LogoActivity.Wide;
    int ga = bitmaps[1].getWidth();
    if (time < 10) {
      canvas.drawBitmap(bitmaps[time], x - 2 * ga, ga / 2 + 3, paint);
    }
    if (time >= 10 && time < 100) {
      canvas.drawBitmap(bitmaps[time / 10], x - 3 * ga - 5, ga / 2 + 3, paint);
      canvas.drawBitmap(bitmaps[time % 10], x - 2 * ga, ga / 2 + 3, paint);
    }
    if (time >= 100 && time < 1000) {
      canvas.drawBitmap(bitmaps[time / 100], x - 4 * ga - 10, ga / 2 + 3, paint);
      canvas.drawBitmap(bitmaps[time % 100 / 10], x - 3 * ga - 5, ga / 2 + 3, paint);
      canvas.drawBitmap(bitmaps[time % 100 % 10], x - 2 * ga, ga / 2 + 3, paint);
    }
    if (time >= 1000 && time < 10000) {
      canvas.drawBitmap(bitmaps[time / 1000], x - 5 * ga - 15, ga / 2 + 3, paint);
      canvas.drawBitmap(bitmaps[time % 1000 / 100], x - 4 * ga - 10, ga / 2 + 3, paint);
      canvas.drawBitmap(bitmaps[time % 100 % 100 / 10], x - 3 * ga - 5, ga / 2 + 3, paint);
      canvas.drawBitmap(bitmaps[time % 100 % 100 % 10], x - 2 * ga, ga / 2 + 3, paint);
    }
  }

  public void drawleinum(int lei_baioji_number, Canvas canvas) {
    int x = LogoActivity.Wide;
    int ga = bitmaps[1].getWidth();
    if (lei_baioji_number < 10 && lei_baioji_number >= 0) {
      canvas.drawBitmap(bitmaps[lei_baioji_number], 4 * ga + 10, ga / 2 + 3, paint);
    }
    if (lei_baioji_number >= 10 && lei_baioji_number < 100) {
      canvas.drawBitmap(bitmaps[lei_baioji_number / 10], 3 * ga + 5, ga / 2 + 3, paint);
      canvas.drawBitmap(bitmaps[lei_baioji_number % 10], 4 * ga + 10, ga / 2 + 3, paint);
    }
    if (lei_baioji_number < 0) {
      lei_baioji_number = -lei_baioji_number;
      if (lei_baioji_number < 10 && lei_baioji_number >= 0) {
        canvas.drawBitmap(bitmaps[10], 3 * ga + 5, ga / 2 + 3, paint);
        canvas.drawBitmap(bitmaps[lei_baioji_number], 4 * ga + 10, ga / 2 + 3, paint);
      }
      if (lei_baioji_number >= 10 && lei_baioji_number < 100) {
        canvas.drawBitmap(bitmaps[10], 2 * ga, ga / 2 + 3, paint);
        canvas.drawBitmap(bitmaps[lei_baioji_number / 10], 3 * ga + 5, ga / 2 + 3, paint);
        canvas.drawBitmap(bitmaps[lei_baioji_number % 10], 4 * ga + 10, ga / 2 + 3, paint);
      }
      if (lei_baioji_number >= 100 && lei_baioji_number < 1000) {

        canvas.drawBitmap(bitmaps[10], ga - 5, ga / 2 + 3, paint);
        canvas.drawBitmap(bitmaps[lei_baioji_number / 100], 2 * ga, ga / 2 + 3, paint);
        canvas.drawBitmap(bitmaps[lei_baioji_number % 100 / 10], 3 * ga + 5, ga / 2 + 3, paint);
        canvas.drawBitmap(bitmaps[lei_baioji_number % 100 % 10], 4 * ga + 10, ga / 2 + 3, paint);
      }
    }

  }
}
