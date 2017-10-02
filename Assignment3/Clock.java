class Clock {
  String time;

/* this time cannot be return. It should use this.time.
What is more, since it return time in String data ype, it should use
String rather than void.
  void getTime() {
    return time;
  }
*/

  String getTime() {
    return this.time;
  }

  void setTime(String t) {
    time = t;
  }

  Clock(String time) {
    this.time = time;
  }

  public static void main(String[] args) {
    Clock clock = new Clock("9:00");
    System.out.println(clock.getTime());
    clock.setTime("10:00");
    System.out.println(clock.getTime());
  }
}
