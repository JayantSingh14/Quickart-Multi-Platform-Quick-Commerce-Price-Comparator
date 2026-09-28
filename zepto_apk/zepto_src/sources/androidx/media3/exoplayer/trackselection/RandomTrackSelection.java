package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.util.List;
import java.util.Random;

@UnstableApi
/* loaded from: classes3.dex */
public final class RandomTrackSelection extends BaseTrackSelection {

    /* renamed from: g, reason: collision with root package name */
    public int f8034g;

    public static final class Factory implements ExoTrackSelection.Factory {
        public Factory() {
            new Random();
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int d() {
        return this.f8034g;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final void g(long j2, long j3, long j4, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < this.f7969b; i2++) {
            b(i2, jElapsedRealtime);
        }
        throw null;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final Object j() {
        return null;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int s() {
        return 3;
    }
}
