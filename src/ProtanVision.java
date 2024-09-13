import java.awt.Color;

public class ProtanVision extends VisionType {
    public ProtanVision() {
        super(new int[][]{{142, 51, 196}, {191, 43, 46}, {90, 163, 33}, {235, 219, 49}, {156, 103, 151}});
    }

    @Override
    public Color modifyZeroColor(int r, int g, int b) {
        return new Color(r, g - 40, b);
    }
}
