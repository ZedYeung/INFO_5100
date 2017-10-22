public static void parse(File file) {
  RandomAccessFile input = null;
  String line = null;

  try {
      input = new RandomAccessFile(file, "r");
      while ((line = input.readLine()) != null) {
          System.out.println(line);
      }
      return;
  } catch (Exception e) {
    e.printStackTrace();
  } finally {
        if (input != null) {
          input.close();
        }
    }
}
