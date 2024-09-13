import java.awt.Color;

public abstract class VisionType {
    protected int[][] RGB;
    
    // Constructor to set the RGB values for the vision type
    public VisionType(int[][] RGB) {
        this.RGB = RGB;
    }

    // Method to get the RGB values
    public int[][] getRGB() {
        return this.RGB;
    }

    // Abstract method to modify the color of the zero button based on the vision type
    public abstract Color modifyZeroColor(int r, int g, int b);
}
