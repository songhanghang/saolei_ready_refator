package DB;

import java.util.ArrayList;

import Uers.Uers;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SqlMang {
  public Sql sql;

  public SqlMang(Context context) {
    super();
    // TODO Auto-generated constructor stub
    sql = new Sql(context, "FileSaolei");
  }

  public void insert(int diff, Uers uers) {
    ArrayList<Uers> arrayList;
    SQLiteDatabase db = sql.getWritableDatabase();
    String sql = "select * from " + Sql.SLsql + " where diff=" + diff
        + " order by time asc";
    Cursor cursor = db.rawQuery(sql, null);
    if (cursor.getCount() < 10) {
      db.execSQL("insert into " + Sql.SLsql
          + "(name, diff, time) values(?, ?, ?)", new Object[]{uers.getName(), uers.getDiff(), uers.getTime()});
    } else {
      if (cursor.moveToLast()) {
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        int time = cursor.getInt(cursor.getColumnIndex("time"));
        if (uers.getTime() < time) {
          db.execSQL("update " + Sql.SLsql + " set name=?, diff=?, time=? where _id=" + id + ";", new Object[]{uers.getName(), uers.getDiff(), uers.getTime()});
        }
      }
    }
    db.close();
  }

  public ArrayList<Uers> selcet(int diff) {
    ArrayList<Uers> arrayList = new ArrayList<Uers>();
    SQLiteDatabase db = sql.getWritableDatabase();
    String sql = "select * from " + Sql.SLsql + " where diff=" + diff
        + " order by time asc";
    Cursor cursor = db.rawQuery(sql, null);
    while (cursor.moveToNext()) {
      String name = cursor.getString(cursor.getColumnIndex("name"));
      int time = cursor.getInt(cursor.getColumnIndex("time"));
      Uers uers = new Uers(name, diff, time);
      arrayList.add(uers);
    }
    db.close();
    return arrayList;
  }
}
