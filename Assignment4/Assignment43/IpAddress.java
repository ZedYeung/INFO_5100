class IpAddress {
  String dottedDecimal;
  int firstOctet;
  int secondOctet;
  int thirdOctet;
  int fourthOctet;

  public IpAddress(String dottedDecimal) {
    this.dottedDecimal = dottedDecimal;
    String [] octets = this.dottedDecimal.split("\\.");
    int [] octet = new int[octets.length];
    for (int i=0; i < octets.length; i++) {
      octet[i] = Integer.parseInt(octets[i]);
    }
    this.firstOctet = octet[0];
    this.secondOctet = octet[1];
    this.thirdOctet = octet[2];
    this.fourthOctet = octet[3];
  }
x
  public String getDottedDecimal() {
    return this.dottedDecimal;
  }

  public int getOctet(int pos) {
    if (pos == 1) {
      return this.firstOctet;
    } else if (pos == 2) {
      return this.secondOctet;
    } else if (pos ==3) {
      return this.thirdOctet;
    } else if (pos == 4) {
      return this.fourthOctet;
    } else {
      System.out.println("There only four octet.");
      return -1;
    }
  }
}
