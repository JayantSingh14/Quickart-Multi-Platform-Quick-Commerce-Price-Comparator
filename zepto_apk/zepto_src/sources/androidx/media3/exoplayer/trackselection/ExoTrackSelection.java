package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public interface ExoTrackSelection extends TrackSelection {

    public static final class Definition {

        /* renamed from: a, reason: collision with root package name */
        public final TrackGroup f8025a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f8026b;

        public Definition(TrackGroup trackGroup, int[] iArr) {
            if (iArr.length == 0) {
                Log.e("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f8025a = trackGroup;
            this.f8026b = iArr;
        }
    }

    public interface Factory {
    }

    default long a() {
        return -2147483647L;
    }

    boolean b(int i2, long j2);

    int d();

    void disable();

    void enable();

    void g(long j2, long j3, long j4, List list, MediaChunkIterator[] mediaChunkIteratorArr);

    boolean h(int i2, long j2);

    void i(float f2);

    Object j();

    default void k() {
    }

    default boolean n(long j2, Chunk chunk, List list) {
        return false;
    }

    default void o(boolean z) {
    }

    int p(long j2, List list);

    int q();

    Format r();

    int s();

    default void t() {
    }
}
