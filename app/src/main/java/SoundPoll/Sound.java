package SoundPoll;

import com.app.saolei.activity.R;
import com.app.saolei.activity.SetActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Sound {

  public static int[] ids = {R.raw.sound00_explode,
      R.raw.sound01_flag, R.raw.sound02_winner, R.raw.sound03_question,
      R.raw.sound04_isflag, R.raw.sound5_button};
  public static SoundPool pool = new SoundPool(7, AudioManager.STREAM_MUSIC,
      0);
  public static final int button = 6;
  public static final int isflag = 5;
  public static final int question = 4;
  public static final int winneer = 3;
  public static final int flag = 2;
  public static final int explode = 1;

  public static void load(Context context) {
    for (int i = 0; i < ids.length; i++) {
      //����ֵΪint��
      pool.load(context, ids[i], 1);
    }
  }

  public static void paly(int key) {
    if (SetActivity.isopsound) {
      pool.play(key, 1.0F, 1.0F, 0, 0, 1.0F);
    }
  }

  public static void Relive() {
    pool.release();
  }

}
