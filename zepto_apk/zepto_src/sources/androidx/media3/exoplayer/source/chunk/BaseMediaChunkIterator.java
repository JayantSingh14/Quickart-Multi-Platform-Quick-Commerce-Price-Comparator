package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.UnstableApi;
import java.util.NoSuchElementException;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {

    /* renamed from: b, reason: collision with root package name */
    public final long f7831b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7832c;

    /* renamed from: d, reason: collision with root package name */
    public long f7833d;

    public BaseMediaChunkIterator(long j2, long j3) {
        this.f7831b = j2;
        this.f7832c = j3;
        this.f7833d = j2 - 1;
    }

    public final void c() {
        long j2 = this.f7833d;
        if (j2 < this.f7831b || j2 > this.f7832c) {
            throw new NoSuchElementException();
        }
    }

    @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
    public final boolean next() {
        long j2 = this.f7833d + 1;
        this.f7833d = j2;
        return !(j2 > this.f7832c);
    }
}
