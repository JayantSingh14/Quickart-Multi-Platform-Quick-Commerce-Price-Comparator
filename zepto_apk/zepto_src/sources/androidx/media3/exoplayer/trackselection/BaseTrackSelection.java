package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BaseTrackSelection implements ExoTrackSelection {

    /* renamed from: a, reason: collision with root package name */
    public final TrackGroup f7968a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7969b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f7970c;

    /* renamed from: d, reason: collision with root package name */
    public final Format[] f7971d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f7972e;

    /* renamed from: f, reason: collision with root package name */
    public int f7973f;

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr) {
        int i2 = 0;
        Assertions.g(iArr.length > 0);
        trackGroup.getClass();
        this.f7968a = trackGroup;
        int length = iArr.length;
        this.f7969b = length;
        this.f7971d = new Format[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f7971d[i3] = trackGroup.f5504d[iArr[i3]];
        }
        Arrays.sort(this.f7971d, new b(6));
        this.f7970c = new int[this.f7969b];
        while (true) {
            int i4 = this.f7969b;
            if (i2 >= i4) {
                this.f7972e = new long[i4];
                return;
            } else {
                this.f7970c[i2] = trackGroup.c(this.f7971d[i2]);
                i2++;
            }
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final boolean b(int i2, long j2) {
        return this.f7972e[i2] > j2;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final int c(Format format) {
        for (int i2 = 0; i2 < this.f7969b; i2++) {
            if (this.f7971d[i2] == format) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void disable() {
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final Format e(int i2) {
        return this.f7971d[i2];
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void enable() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
            if (this.f7968a.equals(baseTrackSelection.f7968a) && Arrays.equals(this.f7970c, baseTrackSelection.f7970c)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final int f(int i2) {
        return this.f7970c[i2];
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final boolean h(int i2, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zB = b(i2, jElapsedRealtime);
        int i3 = 0;
        while (i3 < this.f7969b && !zB) {
            zB = (i3 == i2 || b(i3, jElapsedRealtime)) ? false : true;
            i3++;
        }
        if (!zB) {
            return false;
        }
        long[] jArr = this.f7972e;
        long j3 = jArr[i2];
        int i4 = Util.f5744a;
        long j4 = jElapsedRealtime + j2;
        if (((j2 ^ j4) & (jElapsedRealtime ^ j4)) < 0) {
            j4 = Long.MAX_VALUE;
        }
        jArr[i2] = Math.max(j3, j4);
        return true;
    }

    public final int hashCode() {
        if (this.f7973f == 0) {
            this.f7973f = Arrays.hashCode(this.f7970c) + (System.identityHashCode(this.f7968a) * 31);
        }
        return this.f7973f;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void i(float f2) {
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final int l(int i2) {
        for (int i3 = 0; i3 < this.f7969b; i3++) {
            if (this.f7970c[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final int length() {
        return this.f7970c.length;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final TrackGroup m() {
        return this.f7968a;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public int p(long j2, List list) {
        return list.size();
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int q() {
        return this.f7970c[d()];
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final Format r() {
        return this.f7971d[d()];
    }
}
