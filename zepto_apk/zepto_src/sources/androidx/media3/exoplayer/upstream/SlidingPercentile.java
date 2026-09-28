package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.SlidingPercentile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@UnstableApi
/* loaded from: classes.dex */
public class SlidingPercentile {

    /* renamed from: h, reason: collision with root package name */
    public static final c f8189h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f8190i;

    /* renamed from: a, reason: collision with root package name */
    public final int f8191a;

    /* renamed from: e, reason: collision with root package name */
    public int f8195e;

    /* renamed from: f, reason: collision with root package name */
    public int f8196f;

    /* renamed from: g, reason: collision with root package name */
    public int f8197g;

    /* renamed from: c, reason: collision with root package name */
    public final Sample[] f8193c = new Sample[5];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f8192b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public int f8194d = -1;

    public static class Sample {

        /* renamed from: a, reason: collision with root package name */
        public int f8198a;

        /* renamed from: b, reason: collision with root package name */
        public int f8199b;

        /* renamed from: c, reason: collision with root package name */
        public float f8200c;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.exoplayer.upstream.c] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.media3.exoplayer.upstream.c] */
    static {
        final int i2 = 0;
        f8189h = new Comparator() { // from class: androidx.media3.exoplayer.upstream.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                SlidingPercentile.Sample sample = (SlidingPercentile.Sample) obj;
                SlidingPercentile.Sample sample2 = (SlidingPercentile.Sample) obj2;
                switch (i2) {
                    case 0:
                        return sample.f8198a - sample2.f8198a;
                    default:
                        return Float.compare(sample.f8200c, sample2.f8200c);
                }
            }
        };
        final int i3 = 1;
        f8190i = new Comparator() { // from class: androidx.media3.exoplayer.upstream.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                SlidingPercentile.Sample sample = (SlidingPercentile.Sample) obj;
                SlidingPercentile.Sample sample2 = (SlidingPercentile.Sample) obj2;
                switch (i3) {
                    case 0:
                        return sample.f8198a - sample2.f8198a;
                    default:
                        return Float.compare(sample.f8200c, sample2.f8200c);
                }
            }
        };
    }

    public SlidingPercentile(int i2) {
        this.f8191a = i2;
    }

    public final void a(float f2, int i2) {
        Sample sample;
        int i3 = this.f8194d;
        ArrayList arrayList = this.f8192b;
        if (i3 != 1) {
            Collections.sort(arrayList, f8189h);
            this.f8194d = 1;
        }
        int i4 = this.f8197g;
        Sample[] sampleArr = this.f8193c;
        if (i4 > 0) {
            int i5 = i4 - 1;
            this.f8197g = i5;
            sample = sampleArr[i5];
        } else {
            sample = new Sample();
        }
        int i6 = this.f8195e;
        this.f8195e = i6 + 1;
        sample.f8198a = i6;
        sample.f8199b = i2;
        sample.f8200c = f2;
        arrayList.add(sample);
        this.f8196f += i2;
        while (true) {
            int i7 = this.f8196f;
            int i8 = this.f8191a;
            if (i7 <= i8) {
                return;
            }
            int i9 = i7 - i8;
            Sample sample2 = (Sample) arrayList.get(0);
            int i10 = sample2.f8199b;
            if (i10 <= i9) {
                this.f8196f -= i10;
                arrayList.remove(0);
                int i11 = this.f8197g;
                if (i11 < 5) {
                    this.f8197g = i11 + 1;
                    sampleArr[i11] = sample2;
                }
            } else {
                sample2.f8199b = i10 - i9;
                this.f8196f -= i9;
            }
        }
    }

    public final float b() {
        int i2 = this.f8194d;
        ArrayList arrayList = this.f8192b;
        if (i2 != 0) {
            Collections.sort(arrayList, f8190i);
            this.f8194d = 0;
        }
        float f2 = 0.5f * this.f8196f;
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Sample sample = (Sample) arrayList.get(i4);
            i3 += sample.f8199b;
            if (i3 >= f2) {
                return sample.f8200c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((Sample) android.support.v4.media.b.c(1, arrayList)).f8200c;
    }
}
