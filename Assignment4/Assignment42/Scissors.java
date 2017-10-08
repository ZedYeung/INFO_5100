class Scissors extends Tool {
  public Scissors(int s) {
    this.strength = s;
    this.type = 's';
  }

  public boolean fight(Tool tool) {
    if (tool.type == 'r') {
      return tool.strength * 2 < this.strength;
    } else if (tool.type == 'p') {
      return this.strength * 2 > tool.strength;
    } else {
      return this.strength > tool.strength;
    }
  }
}
