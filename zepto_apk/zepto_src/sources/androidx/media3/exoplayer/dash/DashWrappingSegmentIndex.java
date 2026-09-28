package androidx.media3.exoplayer.dash;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.extractor.ChunkIndex;

@UnstableApi
/* loaded from: classes3.dex */
public final class DashWrappingSegmentIndex implements DashSegmentIndex {

    /* renamed from: a, reason: collision with root package name */
    public final ChunkIndex f6728a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6729b;

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex, long j2) {
        this.f6728a = chunkIndex;
        this.f6729b = j2;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long b(long j2) {
        return this.f6728a.f8507e[(int) j2] - this.f6729b;
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long c(long j2, long j3) {
        return this.f6728a.f8506d[(int) j2];
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
        return new RangedUri(this.f6728a.f8505c[(int) j2], r1.f8504b[r7], null);
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long g(long j2, long j3) {
        return Util.f(this.f6728a.f8507e, j2 + this.f6729b, true);
    }

    @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
    public final long h(long j2) {
        return this.f6728a.f8503a;
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
        return this.f6728a.f8503a;
    }
}
