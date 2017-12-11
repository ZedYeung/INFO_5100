class MyIndexOutOfBoundException extends Exception { // score 2
  int lowerBound;
  int upperBound;
  int index;
  String message;

  public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    this.index = index;
    this.message = String.format("Error Message: Index: %s, but Lower bound: %s, Upper bound: %s",
      index, lowerBound, upperBound);
  }

  public String getMessage() {
    return this.message;
  }

  public static void main(String[] args) throws MyIndexOutOfBoundException {
    MyIndexOutOfBoundException e = new MyIndexOutOfBoundException(0, 5, 10);
    System.out.println(e.getMessage());
  }
}
