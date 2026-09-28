package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {

    /* renamed from: b, reason: collision with root package name */
    public final int f6113b;

    /* renamed from: d, reason: collision with root package name */
    public RendererConfiguration f6115d;

    /* renamed from: e, reason: collision with root package name */
    public int f6116e;

    /* renamed from: f, reason: collision with root package name */
    public PlayerId f6117f;

    /* renamed from: g, reason: collision with root package name */
    public SystemClock f6118g;

    /* renamed from: h, reason: collision with root package name */
    public int f6119h;

    /* renamed from: i, reason: collision with root package name */
    public SampleStream f6120i;

    /* renamed from: j, reason: collision with root package name */
    public Format[] f6121j;

    /* renamed from: k, reason: collision with root package name */
    public long f6122k;

    /* renamed from: l, reason: collision with root package name */
    public long f6123l;
    public boolean n;
    public boolean o;
    public RendererCapabilities.Listener q;

    /* renamed from: a, reason: collision with root package name */
    public final Object f6112a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final FormatHolder f6114c = new FormatHolder();

    /* renamed from: m, reason: collision with root package name */
    public long f6124m = Long.MIN_VALUE;
    public Timeline p = Timeline.f5466a;

    public BaseRenderer(int i2) {
        this.f6113b = i2;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void A(long j2) {
        this.n = false;
        this.f6123l = j2;
        this.f6124m = j2;
        I(j2, false);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public MediaClock B() {
        return null;
    }

    public final ExoPlaybackException C(Throwable th, Format format, boolean z, int i2) {
        int iB;
        if (format == null || this.o) {
            iB = 4;
        } else {
            this.o = true;
            try {
                iB = b(format) & 7;
            } catch (ExoPlaybackException unused) {
            } finally {
                this.o = false;
            }
        }
        return new ExoPlaybackException(1, th, i2, getName(), this.f6116e, format, format == null ? 4 : iB, z);
    }

    public final boolean E() {
        if (k()) {
            return this.n;
        }
        SampleStream sampleStream = this.f6120i;
        sampleStream.getClass();
        return sampleStream.a();
    }

    public void G() {
    }

    public void H(boolean z, boolean z2) {
    }

    public void I(long j2, boolean z) {
    }

    public void J() {
    }

    public void K() {
    }

    public void L() {
    }

    public void M() {
    }

    public final int O(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        SampleStream sampleStream = this.f6120i;
        sampleStream.getClass();
        int iN = sampleStream.n(formatHolder, decoderInputBuffer, i2);
        if (iN == -4) {
            if (decoderInputBuffer.g(4)) {
                this.f6124m = Long.MIN_VALUE;
                return this.n ? -4 : -3;
            }
            long j2 = decoderInputBuffer.f6073f + this.f6122k;
            decoderInputBuffer.f6073f = j2;
            this.f6124m = Math.max(this.f6124m, j2);
            return iN;
        }
        if (iN == -5) {
            Format format = formatHolder.f6254b;
            format.getClass();
            long j3 = format.r;
            if (j3 != Long.MAX_VALUE) {
                Format.Builder builderA = format.a();
                builderA.q = j3 + this.f6122k;
                formatHolder.f6254b = new Format(builderA);
            }
        }
        return iN;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean c() {
        return k();
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final void d() {
        synchronized (this.f6112a) {
            this.q = null;
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void disable() {
        Assertions.g(this.f6119h == 1);
        this.f6114c.a();
        this.f6119h = 0;
        this.f6120i = null;
        this.f6121j = null;
        this.n = false;
        G();
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final int g() {
        return this.f6113b;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final int getState() {
        return this.f6119h;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final SampleStream j() {
        return this.f6120i;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean k() {
        return this.f6124m == Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void l() {
        this.n = true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void m(int i2, PlayerId playerId, SystemClock systemClock) {
        this.f6116e = i2;
        this.f6117f = playerId;
        this.f6118g = systemClock;
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Target
    public void o(int i2, Object obj) {
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void p(Format[] formatArr, SampleStream sampleStream, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(!this.n);
        this.f6120i = sampleStream;
        if (this.f6124m == Long.MIN_VALUE) {
            this.f6124m = j2;
        }
        this.f6121j = formatArr;
        this.f6122k = j3;
        N(formatArr, j2, j3);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void q() {
        SampleStream sampleStream = this.f6120i;
        sampleStream.getClass();
        sampleStream.c();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean r() {
        return this.n;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void release() {
        Assertions.g(this.f6119h == 0);
        J();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void reset() {
        Assertions.g(this.f6119h == 0);
        this.f6114c.a();
        K();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void s(Timeline timeline) {
        if (Util.a(this.p, timeline)) {
            return;
        }
        this.p = timeline;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void start() {
        Assertions.g(this.f6119h == 1);
        this.f6119h = 2;
        L();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void stop() {
        Assertions.g(this.f6119h == 2);
        this.f6119h = 1;
        M();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void t(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, boolean z, boolean z2, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(this.f6119h == 0);
        this.f6115d = rendererConfiguration;
        this.f6119h = 1;
        H(z, z2);
        p(formatArr, sampleStream, j2, j3, mediaPeriodId);
        this.n = false;
        this.f6123l = j2;
        this.f6124m = j2;
        I(j2, z);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final RendererCapabilities u() {
        return this;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final void v(RendererCapabilities.Listener listener) {
        synchronized (this.f6112a) {
            this.q = listener;
        }
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int y() {
        return 0;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final long z() {
        return this.f6124m;
    }

    public void N(Format[] formatArr, long j2, long j3) {
    }
}
