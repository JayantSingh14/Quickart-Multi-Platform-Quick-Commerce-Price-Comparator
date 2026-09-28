package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;

/* loaded from: classes3.dex */
final class IndexSeeker implements Seeker {

    /* renamed from: a, reason: collision with root package name */
    public long f8938a;

    public final boolean a(long j2) {
        throw null;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long b(long j2) {
        Util.c(null, j2);
        throw null;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        Util.c(null, j2);
        throw null;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long f() {
        return 0L;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return true;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final int k() {
        return 0;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f8938a;
    }
}
