package Uers;

public class Uers {
  public String name;
  public int time;
  public int diff;

  public Uers(String name, int diff, int time) {
    super();
    this.name = name;
    this.time = time;
    this.diff = diff;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public int getDiff() {
    return diff;
  }

  public void setDiff(int diff) {
    this.diff = diff;
  }


}
