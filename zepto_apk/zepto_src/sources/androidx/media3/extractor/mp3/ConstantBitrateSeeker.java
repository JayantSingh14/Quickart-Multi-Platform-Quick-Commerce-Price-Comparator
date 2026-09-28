package androidx.media3.extractor.mp3;

import androidx.media3.extractor.ConstantBitrateSeekMap;

/* loaded from: classes3.dex */
final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {

    /* renamed from: h, reason: collision with root package name */
    public final int f8936h;

    /* renamed from: i, reason: collision with root package name */
    public final long f8937i;

    public ConstantBitrateSeeker(long j2, long j3, int i2, int i3, boolean z) {
        super(j2, j3, i2, i3, z);
        long j4 = j2;
        this.f8936h = i2;
        this.f8937i = j4 == -1 ? -1L : j4;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long b(long j2) {
        return (Math.max(0L, j2 - this.f8510b) * 8000000) / this.f8513e;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long f() {
        return this.f8937i;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final int k() {
        return this.f8936h;
    }
}
