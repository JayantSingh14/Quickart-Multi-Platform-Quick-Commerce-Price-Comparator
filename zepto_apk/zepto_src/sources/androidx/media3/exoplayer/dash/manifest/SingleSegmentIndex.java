package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.exoplayer.dash.DashSegmentIndex;

/* loaded from: classes3.dex */
final class SingleSegmentIndex implements DashSegmentIndex {

    /* renamed from: a, reason: collision with root package name */
    public final RangedUri f6865a;

    public SingleSegmentIndex(RangedUri rangedUri) {
        this.f6865a = rangedUri;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long b(long j2) {
        return 0L;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long c(long j2, long j3) {
        return j3;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long d(long j2, long j3) {
        return 0L;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long e(long j2, long j3) {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final RangedUri f(long j2) {
        return this.f6865a;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long g(long j2, long j3) {
        return 0L;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long h(long j2) {
        return 1L;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final boolean i() {
        return true;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long j() {
        return 0L;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long k(long j2, long j3) {
        return 1L;
    }
}
