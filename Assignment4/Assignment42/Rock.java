class Rock extends Tool {
  public Rock(int s) {
    this.strength = s;
    this.type = 'r';
  }

  public boolean fight(Tool tool) {
    if (tool.type == 'p') {
      return tool.strength * 2  < this.strength;
    } else if (tool.type == 's') {
      return this.strength * 2 > tool.strength;
    } else {
      return this.strength > tool.strength;
    }
  }
}
