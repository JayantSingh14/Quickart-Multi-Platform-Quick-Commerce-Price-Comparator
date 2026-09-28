package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class KeyFrameArray {

    public static class CustomArray {
        public CustomArray() {
            Arrays.fill(new int[101], 999);
            Arrays.fill(new CustomAttribute[101], (Object) null);
        }
    }

    public static class CustomVar {
        public CustomVar() {
            Arrays.fill(new int[101], 999);
            Arrays.fill(new CustomVariable[101], (Object) null);
        }
    }

    public static class FloatArray {
    }
}
