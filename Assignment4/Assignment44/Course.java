class Course { // score 2
  String name;
  int numberOfStudent;
  Student [] students;

  public Course(String title) {
    this.name = title;
    this.numberOfStudent = 0;
    this.students = new Student [10];
  }

  public Student[] getStudents() {
    return this.students;
  }

  public boolean isFull() {
    return numberOfStudent > 10;
  }

  public int getNumberOfStudent() {
    return this.numberOfStudent;
  }

  public String getTitle() {
    return this.name;
  }

  public void registerStudent(Student student){ // you have to check if the same student is registering multiple types
    if (this.numberOfStudent < 9) {
      this.students[numberOfStudent] = student;
      this.numberOfStudent ++;
    }

  }
 }
