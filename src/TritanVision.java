import java.awt.Color;

public class TritanVision extends VisionType {
    public TritanVision() {
        super(new int[][]{{144, 238, 144}, {41, 41, 179}, {41, 163, 33}, {235, 219, 49}, {156, 103, 151}});
    }

    @Override
    public Color modifyZeroColor(int r, int g, int b) {
        int[][] colorModifications = {{70, -31, -b},{136, 0, 0},{20, -40, -20},{-50, -50, 30},{0, -40, 0},{-100, -40, 0}};
        
        for (int i = 0; i < colorModifications.length; i++) {
            if (getRGB()[i][0] == r && getRGB()[i][1] == g && getRGB()[i][2] == b) {
                int[] mod = colorModifications[i];
                int newR = r + mod[0];
                int newG = g + mod[1];
                int newB = b + mod[2];

                // Clamp RGB values between 0 and 255 to avoid IllegalArgumentException
                newR = Math.max(0, Math.min(255, newR));
                newG = Math.max(0, Math.min(255, newG));
                newB = Math.max(0, Math.min(255, newB));

                return new Color(newR, newG, newB);
            }
        }
        return null; // Fallback case
    }
}
