package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.UnstableApi;
import java.util.NoSuchElementException;

@UnstableApi
/* loaded from: classes3.dex */
public interface MediaChunkIterator {

    /* renamed from: a, reason: collision with root package name */
    public static final MediaChunkIterator f7891a = new AnonymousClass1();

    /* renamed from: androidx.media3.exoplayer.source.chunk.MediaChunkIterator$1, reason: invalid class name */
    public class AnonymousClass1 implements MediaChunkIterator {
        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final long a() {
            throw new NoSuchElementException();
        }

        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final long b() {
            throw new NoSuchElementException();
        }

        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
