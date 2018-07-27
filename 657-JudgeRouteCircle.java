class Solution {
    public boolean judgeCircle(String moves) {
        int UD = 0, RL = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') UD += 1;
            else if (move == 'D') UD -= 1;
            else if (move == 'R') RL += 1;
            else if (move == 'L') RL -= 1;
        }
        return UD == 0 && RL == 0;
    }
}
