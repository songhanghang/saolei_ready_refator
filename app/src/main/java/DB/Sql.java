package DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Sql extends SQLiteOpenHelper {
  public static String SLsql = "SaoLei";

  public Sql(Context context, String name) {
    super(context, name, null, 1);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub
    String sql = "create table " + SLsql + "(_id integer primary key autoincrement, name varchar(20), diff integer(1), time integer(20))";
    db.execSQL(sql);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // TODO Auto-generated method stub

  }

}
