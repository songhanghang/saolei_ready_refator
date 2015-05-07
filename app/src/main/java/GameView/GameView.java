package GameView;

import com.app.saolei.activity.R;

import Block.BLockMang;
import Block.Block;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback,
    Runnable {
  public GameViewMang gViewMang;
  private boolean isrun;
  public SurfaceHolder holder;

  public GameView(Context context) {
    super(context);
    holder = getHolder();
    holder.addCallback(this);
    gViewMang = new GameViewMang(context);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width,
                             int height) {
    // TODO Auto-generated method stub

  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    // TODO Auto-generated method stub
    isrun = true;
    new Thread(this).start();
  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    // TODO Auto-generated method stub
    isrun = false;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    while (isrun) {
      Canvas canvas = holder.lockCanvas();
      if (canvas != null) {
        try {
//					canvas.drawColor(Color.BLACK);
          Thread.sleep(40);
          onpiant(canvas);
          onupdate();
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (canvas != null) {
        holder.unlockCanvasAndPost(canvas);
      }
    }
  }

  public void onpiant(Canvas canvas) {
    gViewMang.onpiant(canvas);
  }

  public void onupdate() {
    gViewMang.onupdate();
  }

  long stime = 0;
  boolean isDonw = false;

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    // TODO Auto-generated method stub
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        gViewMang.ACTION_DOWN(event);
        return true;
      case MotionEvent.ACTION_UP:
        gViewMang.ACTION_UP(event);
        break;
      default:
        break;
    }

    return super.onTouchEvent(event);
  }


}
