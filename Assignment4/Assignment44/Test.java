class Test {
  public static void main(String[] args) {
      Student qiao = new Student("Qiaoqiao", "11111");
      Student harsha = new Student("Harsha", "22222");
      System.out.println(qiao.getName());
      System.out.println(harsha.getId());


      Course java = new Course("Java");
      java.registerStudent(qiao);
      java.registerStudent(harsha);

      System.out.println(java.getTitle());
      System.out.println(java.getStudents());
      System.out.println(java.getNumberOfStudent());
      System.out.println(java.isFull());
  }
}
