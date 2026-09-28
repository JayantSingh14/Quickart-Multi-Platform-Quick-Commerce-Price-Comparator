package eightbitlab.com.blurview;

/* loaded from: classes4.dex */
public class SizeScaler {

    public static class Size {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                if (Float.compare(0.0f, 0.0f) == 0) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((0 * 31) + 0) * 31) + (0.0f != 0.0f ? Float.floatToIntBits(0.0f) : 0);
        }

        public final String toString() {
            return "Size{width=0, height=0, scaleFactor=0.0}";
        }
    }
}
