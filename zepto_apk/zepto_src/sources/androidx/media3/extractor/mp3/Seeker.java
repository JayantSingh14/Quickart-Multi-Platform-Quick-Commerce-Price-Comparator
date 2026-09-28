package androidx.media3.extractor.mp3;

import androidx.media3.extractor.SeekMap;

/* loaded from: classes3.dex */
interface Seeker extends SeekMap {

    public static class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        public UnseekableSeeker() {
            super(-9223372036854775807L);
        }

        @Override // androidx.media3.extractor.mp3.Seeker
        public final long b(long j2) {
            return 0L;
        }

        @Override // androidx.media3.extractor.mp3.Seeker
        public final long f() {
            return -1L;
        }

        @Override // androidx.media3.extractor.mp3.Seeker
        public final int k() {
            return -2147483647;
        }
    }

    long b(long j2);

    long f();

    int k();
}
