package androidx.media3.extractor.avi;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;

/* loaded from: classes3.dex */
final class ChunkReader {

    /* renamed from: a, reason: collision with root package name */
    public final TrackOutput f8677a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8678b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8679c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8680d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8681e;

    /* renamed from: f, reason: collision with root package name */
    public int f8682f;

    /* renamed from: g, reason: collision with root package name */
    public int f8683g;

    /* renamed from: h, reason: collision with root package name */
    public int f8684h;

    /* renamed from: i, reason: collision with root package name */
    public int f8685i;

    /* renamed from: j, reason: collision with root package name */
    public int f8686j;

    /* renamed from: k, reason: collision with root package name */
    public long[] f8687k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f8688l;

    public ChunkReader(int i2, int i3, long j2, int i4, TrackOutput trackOutput) {
        boolean z = true;
        if (i3 != 1 && i3 != 2) {
            z = false;
        }
        Assertions.a(z);
        this.f8680d = j2;
        this.f8681e = i4;
        this.f8677a = trackOutput;
        int i5 = (((i2 % 10) + 48) << 8) | ((i2 / 10) + 48);
        this.f8678b = (i3 == 2 ? 1667497984 : 1651965952) | i5;
        this.f8679c = i3 == 2 ? i5 | 1650720768 : -1;
        this.f8687k = new long[512];
        this.f8688l = new int[512];
    }

    public final SeekPoint a(int i2) {
        return new SeekPoint(((this.f8680d * 1) / this.f8681e) * this.f8688l[i2], this.f8687k[i2]);
    }

    public final SeekMap.SeekPoints b(long j2) {
        int i2 = (int) (j2 / ((this.f8680d * 1) / this.f8681e));
        int iE = Util.e(this.f8688l, i2, true, true);
        if (this.f8688l[iE] == i2) {
            SeekPoint seekPointA = a(iE);
            return new SeekMap.SeekPoints(seekPointA, seekPointA);
        }
        SeekPoint seekPointA2 = a(iE);
        int i3 = iE + 1;
        return i3 < this.f8687k.length ? new SeekMap.SeekPoints(seekPointA2, a(i3)) : new SeekMap.SeekPoints(seekPointA2, seekPointA2);
    }
}
