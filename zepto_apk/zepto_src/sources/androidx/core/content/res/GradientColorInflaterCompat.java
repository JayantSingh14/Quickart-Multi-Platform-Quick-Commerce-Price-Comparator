package androidx.core.content.res;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
final class GradientColorInflaterCompat {

    public static final class ColorStops {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f2762a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f2763b;

        public ColorStops(ArrayList arrayList, ArrayList arrayList2) {
            int size = arrayList.size();
            this.f2762a = new int[size];
            this.f2763b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f2762a[i2] = ((Integer) arrayList.get(i2)).intValue();
                this.f2763b[i2] = ((Float) arrayList2.get(i2)).floatValue();
            }
        }

        public ColorStops(int i2, int i3) {
            this.f2762a = new int[]{i2, i3};
            this.f2763b = new float[]{0.0f, 1.0f};
        }

        public ColorStops(int i2, int i3, int i4) {
            this.f2762a = new int[]{i2, i3, i4};
            this.f2763b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
