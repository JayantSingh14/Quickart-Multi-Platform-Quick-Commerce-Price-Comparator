package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {

    /* renamed from: g, reason: collision with root package name */
    public final BandwidthMeter f7959g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7960h;

    /* renamed from: i, reason: collision with root package name */
    public final long f7961i;

    /* renamed from: j, reason: collision with root package name */
    public final long f7962j;

    /* renamed from: k, reason: collision with root package name */
    public final int f7963k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7964l;

    /* renamed from: m, reason: collision with root package name */
    public final float f7965m;
    public final float n;
    public final ImmutableList o;
    public final SystemClock p;
    public float q;
    public int r;
    public int s;
    public long t;
    public MediaChunk u;
    public long v;

    public static final class AdaptationCheckpoint {

        /* renamed from: a, reason: collision with root package name */
        public final long f7966a;

        /* renamed from: b, reason: collision with root package name */
        public final long f7967b;

        public AdaptationCheckpoint(long j2, long j3) {
            this.f7966a = j2;
            this.f7967b = j3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            return this.f7966a == adaptationCheckpoint.f7966a && this.f7967b == adaptationCheckpoint.f7967b;
        }

        public final int hashCode() {
            return (((int) this.f7966a) * 31) + ((int) this.f7967b);
        }
    }

    public static class Factory implements ExoTrackSelection.Factory {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, long j2, long j3, long j4, ImmutableList immutableList) {
        super(trackGroup, iArr);
        SystemClock systemClock = Clock.f5662a;
        if (j4 < j2) {
            Log.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j4 = j2;
        }
        this.f7959g = bandwidthMeter;
        this.f7960h = j2 * 1000;
        this.f7961i = j3 * 1000;
        this.f7962j = j4 * 1000;
        this.f7963k = 1279;
        this.f7964l = 719;
        this.f7965m = 0.7f;
        this.n = 0.75f;
        this.o = ImmutableList.o(immutableList);
        this.p = systemClock;
        this.q = 1.0f;
        this.s = 0;
        this.t = -9223372036854775807L;
        this.v = -2147483647L;
    }

    public static void u(ArrayList arrayList, long[] jArr) {
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += j3;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ImmutableList.Builder builder = (ImmutableList.Builder) arrayList.get(i2);
            if (builder != null) {
                builder.h(new AdaptationCheckpoint(j2, jArr[i2]));
            }
        }
    }

    public static long w(List list) {
        if (!list.isEmpty()) {
            MediaChunk mediaChunk = (MediaChunk) Iterables.c(list);
            long j2 = mediaChunk.f7861g;
            if (j2 != -9223372036854775807L) {
                long j3 = mediaChunk.f7862h;
                if (j3 != -9223372036854775807L) {
                    return j3 - j2;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final long a() {
        return this.v;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int d() {
        return this.r;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final void disable() {
        this.u = null;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final void enable() {
        this.t = -9223372036854775807L;
        this.u = null;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final void g(long j2, long j3, long j4, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long jW;
        this.p.getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int i2 = this.r;
        if (i2 >= mediaChunkIteratorArr.length || !mediaChunkIteratorArr[i2].next()) {
            int length = mediaChunkIteratorArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    jW = w(list);
                    break;
                }
                MediaChunkIterator mediaChunkIterator = mediaChunkIteratorArr[i3];
                if (mediaChunkIterator.next()) {
                    jW = mediaChunkIterator.b() - mediaChunkIterator.a();
                    break;
                }
                i3++;
            }
        } else {
            MediaChunkIterator mediaChunkIterator2 = mediaChunkIteratorArr[this.r];
            jW = mediaChunkIterator2.b() - mediaChunkIterator2.a();
        }
        int i4 = this.s;
        if (i4 == 0) {
            this.s = 1;
            this.r = v(jElapsedRealtime, jW);
            return;
        }
        int i5 = this.r;
        int iC = list.isEmpty() ? -1 : c(((MediaChunk) Iterables.c(list)).f7858d);
        if (iC != -1) {
            i4 = ((MediaChunk) Iterables.c(list)).f7859e;
            i5 = iC;
        }
        int iV = v(jElapsedRealtime, jW);
        if (iV != i5 && !b(i5, jElapsedRealtime)) {
            Format[] formatArr = this.f7971d;
            Format format = formatArr[i5];
            Format format2 = formatArr[iV];
            long jMin = this.f7960h;
            if (j4 != -9223372036854775807L) {
                jMin = Math.min((long) ((jW != -9223372036854775807L ? j4 - jW : j4) * this.n), jMin);
            }
            int i6 = format2.f5221i;
            int i7 = format.f5221i;
            if ((i6 > i7 && j3 < jMin) || (i6 < i7 && j3 >= this.f7961i)) {
                iV = i5;
            }
        }
        if (iV != i5) {
            i4 = 3;
        }
        this.s = i4;
        this.r = iV;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final void i(float f2) {
        this.q = f2;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final Object j() {
        return null;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int p(long j2, List list) {
        int i2;
        int i3;
        this.p.getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j3 = this.t;
        if (j3 != -9223372036854775807L && jElapsedRealtime - j3 < 1000 && (list.isEmpty() || ((MediaChunk) Iterables.c(list)).equals(this.u))) {
            return list.size();
        }
        this.t = jElapsedRealtime;
        this.u = list.isEmpty() ? null : (MediaChunk) Iterables.c(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jD = Util.D(((MediaChunk) list.get(size - 1)).f7861g - j2, this.q);
        long j4 = this.f7962j;
        if (jD >= j4) {
            Format format = this.f7971d[v(jElapsedRealtime, w(list))];
            for (int i4 = 0; i4 < size; i4++) {
                MediaChunk mediaChunk = (MediaChunk) list.get(i4);
                Format format2 = mediaChunk.f7858d;
                if (Util.D(mediaChunk.f7861g - j2, this.q) >= j4 && format2.f5221i < format.f5221i && (i2 = format2.t) != -1 && i2 <= this.f7964l && (i3 = format2.s) != -1 && i3 <= this.f7963k && i2 < format.t) {
                    return i4;
                }
            }
        }
        return size;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int s() {
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int v(long j2, long j3) {
        long jMax;
        BandwidthMeter bandwidthMeter = this.f7959g;
        long jF = bandwidthMeter.f();
        this.v = jF;
        long j4 = (long) (jF * this.f7965m);
        long jB = bandwidthMeter.b();
        if (jB == -9223372036854775807L || j3 == -9223372036854775807L) {
            jMax = (long) (j4 / this.q);
        } else {
            float f2 = j3;
            jMax = (long) ((j4 * Math.max((f2 / this.q) - jB, 0.0f)) / f2);
        }
        ImmutableList immutableList = this.o;
        if (!immutableList.isEmpty()) {
            int i2 = 1;
            while (i2 < immutableList.size() - 1 && ((AdaptationCheckpoint) immutableList.get(i2)).f7966a < jMax) {
                i2++;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) immutableList.get(i2 - 1);
            AdaptationCheckpoint adaptationCheckpoint2 = (AdaptationCheckpoint) immutableList.get(i2);
            long j5 = adaptationCheckpoint.f7966a;
            float f3 = (jMax - j5) / (adaptationCheckpoint2.f7966a - j5);
            long j6 = adaptationCheckpoint2.f7967b;
            jMax = ((long) (f3 * (j6 - r0))) + adaptationCheckpoint.f7967b;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f7969b; i4++) {
            if (j2 == Long.MIN_VALUE || !b(i4, j2)) {
                if (this.f7971d[i4].f5221i <= jMax) {
                    return i4;
                }
                i3 = i4;
            }
        }
        return i3;
    }
}
