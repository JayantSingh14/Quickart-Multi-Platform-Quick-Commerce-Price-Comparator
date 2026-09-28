package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PathParser;

@RestrictTo
/* loaded from: classes3.dex */
public class AnimatorInflaterCompat {

    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {

        /* renamed from: a, reason: collision with root package name */
        public PathParser.PathDataNode[] f12235a;

        @Override // android.animation.TypeEvaluator
        public final PathParser.PathDataNode[] evaluate(float f2, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            PathParser.PathDataNode[] pathDataNodeArr3 = pathDataNodeArr;
            PathParser.PathDataNode[] pathDataNodeArr4 = pathDataNodeArr2;
            if (!PathParser.a(pathDataNodeArr3, pathDataNodeArr4)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!PathParser.a(this.f12235a, pathDataNodeArr3)) {
                this.f12235a = PathParser.e(pathDataNodeArr3);
            }
            for (int i2 = 0; i2 < pathDataNodeArr3.length; i2++) {
                PathParser.PathDataNode pathDataNode = this.f12235a[i2];
                PathParser.PathDataNode pathDataNode2 = pathDataNodeArr3[i2];
                PathParser.PathDataNode pathDataNode3 = pathDataNodeArr4[i2];
                pathDataNode.getClass();
                pathDataNode.f2813a = pathDataNode2.f2813a;
                int i3 = 0;
                while (true) {
                    float[] fArr = pathDataNode2.f2814b;
                    if (i3 < fArr.length) {
                        pathDataNode.f2814b[i3] = (pathDataNode3.f2814b[i3] * f2) + ((1.0f - f2) * fArr[i3]);
                        i3++;
                    }
                }
            }
            return this.f12235a;
        }
    }
}
