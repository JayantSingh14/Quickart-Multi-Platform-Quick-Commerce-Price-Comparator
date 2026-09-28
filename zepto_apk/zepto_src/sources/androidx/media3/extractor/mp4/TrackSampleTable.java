package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* loaded from: classes3.dex */
final class TrackSampleTable {

    /* renamed from: a, reason: collision with root package name */
    public final Track f9094a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9095b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f9096c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f9097d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9098e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f9099f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f9100g;

    /* renamed from: h, reason: collision with root package name */
    public final long f9101h;

    public TrackSampleTable(Track track, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        Assertions.a(iArr.length == jArr2.length);
        Assertions.a(jArr.length == jArr2.length);
        Assertions.a(iArr2.length == jArr2.length);
        this.f9094a = track;
        this.f9096c = jArr;
        this.f9097d = iArr;
        this.f9098e = i2;
        this.f9099f = jArr2;
        this.f9100g = iArr2;
        this.f9101h = j2;
        this.f9095b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j2) {
        long[] jArr = this.f9099f;
        for (int iB = Util.b(jArr, j2, true); iB < jArr.length; iB++) {
            if ((this.f9100g[iB] & 1) != 0) {
                return iB;
            }
        }
        return -1;
    }
}
