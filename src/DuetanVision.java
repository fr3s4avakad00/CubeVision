import java.awt.Color;

public class DuetanVision extends VisionType {
    public DuetanVision() {
        super(new int[][]{{142, 41, 196}, {191, 33, 46}, {90, 163, 33}, {235, 219, 49}, {156, 103, 151}});
    }

    @Override
    public Color modifyZeroColor(int r, int g, int b) {
        return new Color(r - 40, g, b);
    }
}
