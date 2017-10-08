class Paper extends Tool {
  public Paper(int s) {
    this.strength = s;
    this.type = 'p';
  }

  public boolean fight(Tool tool) {
    if (tool.type == 's') {
      return tool.strength * 2 < this.strength;
    } else if (tool.type == 'r') {
      return this.strength * 2 > tool.strength;
    } else {
      return this.strength > tool.strength;
    }
  }
}
