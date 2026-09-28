package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {

    /* renamed from: a, reason: collision with root package name */
    public int f6324a;

    /* renamed from: b, reason: collision with root package name */
    public SampleStream f6325b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6326c;

    @Override // androidx.media3.exoplayer.Renderer
    public final void A(long j2) {
        this.f6326c = false;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final MediaClock B() {
        return null;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean a() {
        return true;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int b(Format format) {
        return RendererCapabilities.h(0, 0, 0, 0);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean c() {
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void disable() {
        Assertions.g(this.f6324a == 1);
        this.f6324a = 0;
        this.f6325b = null;
        this.f6326c = false;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final int g() {
        return -2;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final int getState() {
        return this.f6324a;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final SampleStream j() {
        return this.f6325b;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean k() {
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void l() {
        this.f6326c = true;
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Target
    public final void o(int i2, Object obj) {
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void p(Format[] formatArr, SampleStream sampleStream, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(!this.f6326c);
        this.f6325b = sampleStream;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void q() {
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean r() {
        return this.f6326c;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void reset() {
        Assertions.g(this.f6324a == 0);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void s(Timeline timeline) {
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void start() {
        Assertions.g(this.f6324a == 1);
        this.f6324a = 2;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void stop() {
        Assertions.g(this.f6324a == 2);
        this.f6324a = 1;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void t(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, boolean z, boolean z2, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(this.f6324a == 0);
        this.f6324a = 1;
        p(formatArr, sampleStream, j2, j3, mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final RendererCapabilities u() {
        return this;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int y() {
        return 0;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final long z() {
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void m(int i2, PlayerId playerId, SystemClock systemClock) {
    }
}
