package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class WrappingMediaSource extends CompositeMediaSource<Void> {

    /* renamed from: k, reason: collision with root package name */
    public final MediaSource f7774k;

    public WrappingMediaSource(MediaSource mediaSource) {
        this.f7774k = mediaSource;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return this.f7774k.C(mediaPeriodId, allocator, j2);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaItem D() {
        return this.f7774k.D();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void J(MediaPeriod mediaPeriod) {
        this.f7774k.J(mediaPeriod);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void O(MediaItem mediaItem) {
        this.f7774k.O(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public boolean W() {
        return this.f7774k.W();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public Timeline X() {
        return this.f7774k.X();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public boolean c0(MediaItem mediaItem) {
        return this.f7774k.c0(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        super.j0(transferListener);
        u0();
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final MediaSource.MediaPeriodId m0(Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        return s0(mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final long n0(Object obj, long j2, MediaSource.MediaPeriodId mediaPeriodId) {
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final int o0(int i2, Object obj) {
        return i2;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final void p0(Object obj, BaseMediaSource baseMediaSource, Timeline timeline) {
        i0(timeline);
    }

    public MediaSource.MediaPeriodId s0(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    public final void t0() {
        q0(null, this.f7774k);
    }

    public void u0() {
        t0();
    }
}
