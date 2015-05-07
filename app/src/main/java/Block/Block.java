package Block;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

public class Block {

  public int x, y;
  public Bitmap bitmap;
  public Rect rect;
  public boolean ishave = false, isopen = false;
  public Paint paint = new Paint();
  public int number = -1;

  public Block(int x, int y, Bitmap bitmap) {
    this.x = x;
    this.y = y;
    this.bitmap = bitmap;
    this.rect = new Rect(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());
  }

  public void drow(Canvas canvas) {
    switch (number) {
      case -1:
        canvas.drawBitmap(bitmap, x, y, paint);
        break;
      case 0:
        canvas.drawBitmap(BLockMang.bitmaps[9], x, y, paint);
        break;
      case 1:
        canvas.drawBitmap(BLockMang.bitmaps[1], x, y, paint);
        break;
      case 2:
        canvas.drawBitmap(BLockMang.bitmaps[2], x, y, paint);
        break;
      case 3:
        canvas.drawBitmap(BLockMang.bitmaps[3], x, y, paint);
        break;
      case 4:
        canvas.drawBitmap(BLockMang.bitmaps[4], x, y, paint);
        break;
      case 5:
        canvas.drawBitmap(BLockMang.bitmaps[5], x, y, paint);
        break;
      case 6:
        canvas.drawBitmap(BLockMang.bitmaps[6], x, y, paint);
        break;
      case 7:
        canvas.drawBitmap(BLockMang.bitmaps[7], x, y, paint);
        break;
      case 8:
        canvas.drawBitmap(BLockMang.bitmaps[8], x, y, paint);
        break;
      case 9:
        canvas.drawBitmap(BLockMang.bitmaps[0], x, y, paint);
        canvas.drawBitmap(BLockMang.bitmaps[15], x, y, paint);
        break;
      case 10:
        canvas.drawBitmap(BLockMang.bitmaps[0], x, y, paint);
        canvas.drawBitmap(BLockMang.bitmaps[10], x, y, paint);
        break;

      case 11:
        canvas.drawBitmap(BLockMang.bitmaps[0], x, y, paint);
        canvas.drawBitmap(BLockMang.bitmaps[11], x, y, paint);
        break;
      case 12:
        canvas.drawBitmap(BLockMang.bitmaps[14], x, y, paint);
        break;
      case 13:
        canvas.drawBitmap(BLockMang.bitmaps[12], x, y, paint);
        break;
      case 14:
        canvas.drawBitmap(BLockMang.bitmaps[13], x, y, paint);
        break;
      default:
        break;
    }

  }

  public boolean isclick(int x, int y) {
    if (rect.contains(x, y)) {
      return true;
    }
    return false;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Bitmap getBitmap() {
    return bitmap;
  }

  public void setBitmap(Bitmap bitmap) {
    this.bitmap = bitmap;
  }

  public Rect getRect() {
    return rect;
  }

  public void setRect(Rect rect) {
    this.rect = rect;
  }

  public Paint getPaint() {
    return paint;
  }

  public void setPaint(Paint paint) {
    this.paint = paint;
  }
}
