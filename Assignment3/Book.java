public class Book { // score 1
  int size;
  int price;
  String name;

  public Book(int size) {
    this.size = size;
  }

  public Book(int size, int price, String name) {
    super();
    this.size = size;
    this.price = price;
    this.name = name;
  }

/*
This constructor conflit with Book(int size) at line 6.
Because they have same data type argument)
  public Book(int price) {
    this.price = price;
  }
*/

/* This class method have no return type.
Since it is a class method, it would be better to write it as below.
public setName(String name) {
  return name;
}
*/
  public void setName(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    Book book = new Book(10, 10, "python");
    book.setName("java");
    System.out.println(book.name);
  }
}
