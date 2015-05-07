package LogoView;

import com.app.saolei.activity.LogoActivity;
import com.app.saolei.activity.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class LogoView extends View implements Runnable {
  /*���ͼƬ��
   * /
   */
  private Bitmap[] bitmap = new Bitmap[3];
  /*
   * ͼƬͨ��������Ϣ
   * /
   */
  private Paint paint = new Paint();
  /*
   * id��ַΪint�����/
   */
  public int[] Myid = {R.drawable.mmlogo, R.drawable.logo, R.drawable.and1};
  public int index = 0;
  /*
   * ����͸����ֵ/
   */
  public int Ash = 255;
  public int Dash = 0;

  public LogoView(Context context) {
    super(context);
    // TODO Auto-generated constructor stub
    for (int i = 0; i < 3; i++) {
      //����ͼƬ��bitmap
      bitmap[i] = BitmapFactory.decodeResource(getResources(), Myid[i]);
      //����ͼƬ�Ĵ�С
      bitmap[i] = bitmap[i].createScaledBitmap(bitmap[i],
          LogoActivity.Wide, LogoActivity.Heigh, true);
    }
    new Thread(this).start();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    // TODO Auto-generated method stub
    super.onDraw(canvas);
    paint.setAlpha(Ash);
    //����ͼƬ��view��ͼ
    canvas.drawBitmap(bitmap[index], 0, 0, paint);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      //�Ӱ����� ��������
      switch (index) {
        case 0:
          mang();
          break;
        case 1:
          mang();
          break;
        case 2:
          mang();
          break;
        default:
          break;
      }

      // ���µ���ondraw���������ˢ�¡�

      if (index == 3) {
        // index = 2;
        // Ash = 0;
        // break;
        index = 2;
        break;
      }

      // TODO Auto-generated method stub
    }
    index = 0;
    Ash = 255;
    Dash = 0;

    //��ȡ����ת
    LogoActivity.logoActivity.gomenu();

  }

  public void mang() {
    if (Dash == 0) {
      Ash = Ash + 20;
      postInvalidate();
      if (Ash >= 255) {
        index++;
        Ash = 255;
        Dash = 255;
      }

    } else {
      Ash = Ash - 20;
      //����ondrow����
      postInvalidate();
      if (Ash <= 0) {
        index++;
        Ash = 0;
        Dash = 0;
      }

    }
  }

}

