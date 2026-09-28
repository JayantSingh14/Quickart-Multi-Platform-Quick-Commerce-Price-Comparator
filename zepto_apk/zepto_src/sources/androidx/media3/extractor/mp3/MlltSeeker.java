package androidx.media3.extractor.mp3;

import android.util.Pair;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

/* loaded from: classes3.dex */
final class MlltSeeker implements Seeker {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f8939a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f8940b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8941c;

    public MlltSeeker(long j2, long[] jArr, long[] jArr2) {
        this.f8939a = jArr;
        this.f8940b = jArr2;
        this.f8941c = j2 == -9223372036854775807L ? Util.T(jArr2[jArr2.length - 1]) : j2;
    }

    public static Pair a(long j2, long[] jArr, long[] jArr2) {
        int iF = Util.f(jArr, j2, true);
        long j3 = jArr[iF];
        long j4 = jArr2[iF];
        int i2 = iF + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j3), Long.valueOf(j4));
        }
        return Pair.create(Long.valueOf(j2), Long.valueOf(((long) ((jArr[i2] == j3 ? 0.0d : (j2 - j3) / (r6 - j3)) * (jArr2[i2] - j4))) + j4));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long b(long j2) {
        return Util.T(((Long) a(j2, this.f8939a, this.f8940b).second).longValue());
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        Pair pairA = a(Util.j0(Util.l(j2, 0L, this.f8941c)), this.f8940b, this.f8939a);
        SeekPoint seekPoint = new SeekPoint(Util.T(((Long) pairA.first).longValue()), ((Long) pairA.second).longValue());
        return new SeekMap.SeekPoints(seekPoint, seekPoint);
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long f() {
        return -1L;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return true;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final int k() {
        return -2147483647;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f8941c;
    }
}
