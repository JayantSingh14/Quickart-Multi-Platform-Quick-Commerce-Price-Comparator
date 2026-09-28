package androidx.palette.graphics;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/* loaded from: classes3.dex */
final class ColorCutQuantizer {

    /* renamed from: f, reason: collision with root package name */
    public static final Comparator f11015f = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f11016a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f11017b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11018c;

    /* renamed from: d, reason: collision with root package name */
    public final Palette.Filter[] f11019d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f11020e = new float[3];

    /* renamed from: androidx.palette.graphics.ColorCutQuantizer$1, reason: invalid class name */
    public static class AnonymousClass1 implements Comparator<Vbox> {
        @Override // java.util.Comparator
        public final int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.b() - vbox.b();
        }
    }

    public class Vbox {

        /* renamed from: a, reason: collision with root package name */
        public final int f11021a;

        /* renamed from: b, reason: collision with root package name */
        public int f11022b;

        /* renamed from: c, reason: collision with root package name */
        public int f11023c;

        /* renamed from: d, reason: collision with root package name */
        public int f11024d;

        /* renamed from: e, reason: collision with root package name */
        public int f11025e;

        /* renamed from: f, reason: collision with root package name */
        public int f11026f;

        /* renamed from: g, reason: collision with root package name */
        public int f11027g;

        /* renamed from: h, reason: collision with root package name */
        public int f11028h;

        /* renamed from: i, reason: collision with root package name */
        public int f11029i;

        public Vbox(int i2, int i3) {
            this.f11021a = i2;
            this.f11022b = i3;
            a();
        }

        public final void a() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f11016a;
            int[] iArr2 = colorCutQuantizer.f11017b;
            int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = 0;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MAX_VALUE;
            for (int i9 = this.f11021a; i9 <= this.f11022b; i9++) {
                int i10 = iArr[i9];
                i6 += iArr2[i10];
                int i11 = (i10 >> 10) & 31;
                int i12 = (i10 >> 5) & 31;
                int i13 = i10 & 31;
                if (i11 > i3) {
                    i3 = i11;
                }
                if (i11 < i2) {
                    i2 = i11;
                }
                if (i12 > i4) {
                    i4 = i12;
                }
                if (i12 < i7) {
                    i7 = i12;
                }
                if (i13 > i5) {
                    i5 = i13;
                }
                if (i13 < i8) {
                    i8 = i13;
                }
            }
            this.f11024d = i2;
            this.f11025e = i3;
            this.f11026f = i7;
            this.f11027g = i4;
            this.f11028h = i8;
            this.f11029i = i5;
            this.f11023c = i6;
        }

        public final int b() {
            return ((this.f11029i - this.f11028h) + 1) * ((this.f11027g - this.f11026f) + 1) * ((this.f11025e - this.f11024d) + 1);
        }
    }

    public ColorCutQuantizer(int[] iArr, int i2, Palette.Filter[] filterArr) {
        Vbox vbox;
        int i3;
        int i4 = 1;
        this.f11019d = filterArr;
        int[] iArr2 = new int[32768];
        this.f11017b = iArr2;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            int iB = b(Color.blue(i6), 8, 5) | (b(Color.red(i6), 8, 5) << 10) | (b(Color.green(i6), 8, 5) << 5);
            iArr[i5] = iB;
            iArr2[iB] = iArr2[iB] + 1;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < 32768; i8++) {
            if (iArr2[i8] > 0) {
                int iRgb = Color.rgb(b((i8 >> 10) & 31, 5, 8), b((i8 >> 5) & 31, 5, 8), b(i8 & 31, 5, 8));
                float[] fArr = this.f11020e;
                ThreadLocal threadLocal = ColorUtils.f2804a;
                ColorUtils.b(fArr, Color.red(iRgb), Color.green(iRgb), Color.blue(iRgb));
                Palette.Filter[] filterArr2 = this.f11019d;
                if (filterArr2 != null && filterArr2.length > 0) {
                    int length = filterArr2.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length) {
                            break;
                        }
                        if (!filterArr2[i9].a(iRgb, fArr)) {
                            iArr2[i8] = 0;
                            break;
                        }
                        i9++;
                    }
                }
            }
            if (iArr2[i8] > 0) {
                i7++;
            }
        }
        int[] iArr3 = new int[i7];
        this.f11016a = iArr3;
        int i10 = 0;
        for (int i11 = 0; i11 < 32768; i11++) {
            if (iArr2[i11] > 0) {
                iArr3[i10] = i11;
                i10++;
            }
        }
        if (i7 <= i2) {
            this.f11018c = new ArrayList();
            for (int i12 = 0; i12 < i7; i12++) {
                int i13 = iArr3[i12];
                this.f11018c.add(new Palette.Swatch(Color.rgb(b((i13 >> 10) & 31, 5, 8), b((i13 >> 5) & 31, 5, 8), b(i13 & 31, 5, 8)), iArr2[i13]));
            }
            return;
        }
        PriorityQueue priorityQueue = new PriorityQueue(i2, f11015f);
        priorityQueue.offer(new Vbox(0, this.f11016a.length - 1));
        while (priorityQueue.size() < i2 && (vbox = (Vbox) priorityQueue.poll()) != null) {
            int i14 = vbox.f11022b;
            int iMin = vbox.f11021a;
            if ((i14 + 1) - iMin <= i4) {
                break;
            }
            if ((i14 + 1) - iMin <= i4) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int i15 = vbox.f11025e - vbox.f11024d;
            int i16 = vbox.f11027g - vbox.f11026f;
            int i17 = vbox.f11029i - vbox.f11028h;
            int i18 = (i15 < i16 || i15 < i17) ? (i16 < i15 || i16 < i17) ? -1 : -2 : -3;
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr4 = colorCutQuantizer.f11016a;
            a(iArr4, i18, iMin, i14);
            Arrays.sort(iArr4, iMin, vbox.f11022b + i4);
            a(iArr4, i18, iMin, vbox.f11022b);
            int i19 = vbox.f11023c / 2;
            int i20 = 0;
            int i21 = iMin;
            while (true) {
                int i22 = vbox.f11022b;
                if (i21 > i22) {
                    i3 = i4;
                    break;
                }
                i3 = i4;
                i20 += colorCutQuantizer.f11017b[iArr4[i21]];
                if (i20 >= i19) {
                    iMin = Math.min(i22 - 1, i21);
                    break;
                } else {
                    i21++;
                    i4 = i3;
                }
            }
            Vbox vbox2 = colorCutQuantizer.new Vbox(iMin + 1, vbox.f11022b);
            vbox.f11022b = iMin;
            vbox.a();
            priorityQueue.offer(vbox2);
            priorityQueue.offer(vbox);
            i4 = i3;
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            Vbox vbox3 = (Vbox) it.next();
            ColorCutQuantizer colorCutQuantizer2 = ColorCutQuantizer.this;
            int[] iArr5 = colorCutQuantizer2.f11016a;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            for (int i27 = vbox3.f11021a; i27 <= vbox3.f11022b; i27++) {
                int i28 = iArr5[i27];
                int i29 = colorCutQuantizer2.f11017b[i28];
                i24 += i29;
                i23 = (((i28 >> 10) & 31) * i29) + i23;
                i25 = (((i28 >> 5) & 31) * i29) + i25;
                i26 += i29 * (i28 & 31);
            }
            float f2 = i24;
            Palette.Swatch swatch = new Palette.Swatch(Color.rgb(b(Math.round(i23 / f2), 5, 8), b(Math.round(i25 / f2), 5, 8), b(Math.round(i26 / f2), 5, 8)), i24);
            float[] fArrB = swatch.b();
            Palette.Filter[] filterArr3 = this.f11019d;
            if (filterArr3 != null && filterArr3.length > 0) {
                for (Palette.Filter filter : filterArr3) {
                    if (!filter.a(swatch.f11045d, fArrB)) {
                        break;
                    }
                }
            }
            arrayList.add(swatch);
        }
        this.f11018c = arrayList;
    }

    public static void a(int[] iArr, int i2, int i3, int i4) {
        if (i2 == -2) {
            while (i3 <= i4) {
                int i5 = iArr[i3];
                iArr[i3] = (i5 & 31) | (((i5 >> 5) & 31) << 10) | (((i5 >> 10) & 31) << 5);
                i3++;
            }
            return;
        }
        if (i2 != -1) {
            return;
        }
        while (i3 <= i4) {
            int i6 = iArr[i3];
            iArr[i3] = ((i6 >> 10) & 31) | ((i6 & 31) << 10) | (((i6 >> 5) & 31) << 5);
            i3++;
        }
    }

    public static int b(int i2, int i3, int i4) {
        return (i4 > i3 ? i2 << (i4 - i3) : i2 >> (i3 - i4)) & ((1 << i4) - 1);
    }
}
