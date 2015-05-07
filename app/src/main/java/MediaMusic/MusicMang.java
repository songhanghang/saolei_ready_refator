package MediaMusic;

import com.app.saolei.activity.R;
import com.app.saolei.activity.SetActivity;
import android.content.Context;
import android.media.MediaPlayer;

public class MusicMang {
  public static MediaPlayer mediaPlayer;
  public static boolean isputin = false;

  public static void setUrl(Context context) {
    if (isputin == false) {
      isputin = true;
      mediaPlayer = MediaPlayer.create(context, R.raw.media_bkmusic);
      mediaPlayer.setLooping(true);
    }
  }

  public static void start() {
    if (!mediaPlayer.isPlaying() && SetActivity.isopmusic) {
      mediaPlayer.start();
    }
  }

  public static void pasue() {
    if (mediaPlayer.isPlaying() && isputin) {
      mediaPlayer.pause();
    }
  }

  public static void close() {
    isputin = false;
    mediaPlayer.reset();
    mediaPlayer.release();
  }
}
