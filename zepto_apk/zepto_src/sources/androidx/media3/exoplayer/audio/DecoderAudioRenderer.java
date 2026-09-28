package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import android.os.Handler;
import android.os.Trace;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.drm.DrmSession;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock {
    public DecoderInputBuffer A;
    public SimpleDecoderOutputBuffer B;
    public DrmSession C;
    public DrmSession D;
    public int E;
    public boolean F;
    public boolean G;
    public long H;
    public boolean I;
    public boolean J;
    public boolean K;
    public long L;
    public final long[] M;
    public int Q;
    public boolean X;
    public final AudioRendererEventListener.EventDispatcher r;
    public final DefaultAudioSink s;
    public final DecoderInputBuffer t;
    public DecoderCounters u;
    public Format v;
    public int w;
    public int x;
    public boolean y;
    public Decoder z;

    @RequiresApi
    public static final class Api23 {
        @DoNotInline
        public static void a(AudioSink audioSink, @Nullable Object obj) {
            audioSink.a((AudioDeviceInfo) obj);
        }
    }

    public final class AudioSinkListener implements AudioSink.Listener {
        public AudioSinkListener() {
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void a(AudioSink.AudioTrackConfig audioTrackConfig) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = DecoderAudioRenderer.this.r;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new c(eventDispatcher, audioTrackConfig, 0));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void b() {
            DecoderAudioRenderer.this.X = true;
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void c(AudioSink.AudioTrackConfig audioTrackConfig) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = DecoderAudioRenderer.this.r;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new c(eventDispatcher, audioTrackConfig, 1));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void d(boolean z) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = DecoderAudioRenderer.this.r;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new h(eventDispatcher, z, 0));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void e(Exception exc) {
            Log.e("DecoderAudioRenderer", "Audio sink error", exc);
            AudioRendererEventListener.EventDispatcher eventDispatcher = DecoderAudioRenderer.this.r;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new d(eventDispatcher, exc, 1));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void g(long j2, long j3, int i2) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = DecoderAudioRenderer.this.r;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new g(eventDispatcher, i2, j2, j3));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void h(long j2) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = DecoderAudioRenderer.this.r;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new f(eventDispatcher, 0, j2));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void j() {
            DecoderAudioRenderer.this.I = true;
        }
    }

    public DecoderAudioRenderer() {
        DefaultAudioSink.Builder builder = new DefaultAudioSink.Builder();
        builder.f6584b = (AudioCapabilities) MoreObjects.a(null, AudioCapabilities.f6491c);
        builder.f6585c = new DefaultAudioSink.DefaultAudioProcessorChain(new AudioProcessor[0]);
        DefaultAudioSink defaultAudioSinkA = builder.a();
        super(1);
        this.r = new AudioRendererEventListener.EventDispatcher(null, null);
        this.s = defaultAudioSinkA;
        defaultAudioSinkA.s = new AudioSinkListener();
        this.t = new DecoderInputBuffer(0);
        this.E = 0;
        this.G = true;
        W(-9223372036854775807L);
        this.M = new long[10];
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final MediaClock B() {
        return this;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final void D(PlaybackParameters playbackParameters) {
        this.s.E(playbackParameters);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final PlaybackParameters F() {
        return this.s.D;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void G() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.r;
        this.v = null;
        this.G = true;
        W(-9223372036854775807L);
        this.X = false;
        try {
            DrmSession.c(this.D, null);
            this.D = null;
            V();
            this.s.y();
        } finally {
            eventDispatcher.a(this.u);
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void H(boolean z, boolean z2) throws IllegalStateException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.u = decoderCounters;
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.r;
        Handler handler = eventDispatcher.f6523a;
        if (handler != null) {
            handler.post(new b(eventDispatcher, decoderCounters, 0));
        }
        RendererConfiguration rendererConfiguration = this.f6115d;
        rendererConfiguration.getClass();
        boolean z3 = rendererConfiguration.f6358b;
        DefaultAudioSink defaultAudioSink = this.s;
        if (z3) {
            defaultAudioSink.f();
        } else {
            defaultAudioSink.d();
        }
        PlayerId playerId = this.f6117f;
        playerId.getClass();
        defaultAudioSink.r = playerId;
        SystemClock systemClock = this.f6118g;
        systemClock.getClass();
        defaultAudioSink.f6577i.J = systemClock;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void I(long j2, boolean z) throws IllegalStateException, ExoPlaybackException {
        this.s.g();
        this.H = j2;
        this.X = false;
        this.I = true;
        this.J = false;
        this.K = false;
        Decoder decoder = this.z;
        if (decoder != null) {
            if (this.E != 0) {
                V();
                T();
                return;
            }
            this.A = null;
            if (this.B != null) {
                throw null;
            }
            decoder.flush();
            decoder.d(this.f6123l);
            this.F = false;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void L() throws IllegalStateException {
        this.s.u();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void M() throws IllegalStateException {
        Y();
        this.s.t();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void N(Format[] formatArr, long j2, long j3) {
        this.y = false;
        if (this.L == -9223372036854775807L) {
            W(j3);
            return;
        }
        int i2 = this.Q;
        long[] jArr = this.M;
        if (i2 == jArr.length) {
            Log.h("DecoderAudioRenderer", "Too many stream changes, so dropping offset: " + jArr[this.Q - 1]);
        } else {
            this.Q = i2 + 1;
        }
        jArr[this.Q - 1] = j3;
    }

    public abstract Decoder P();

    public final void Q() throws ExoPlaybackException, AudioSink.ConfigurationException {
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.B;
        DefaultAudioSink defaultAudioSink = this.s;
        if (simpleDecoderOutputBuffer == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = (SimpleDecoderOutputBuffer) this.z.a();
            this.B = simpleDecoderOutputBuffer2;
            if (simpleDecoderOutputBuffer2 == null) {
                return;
            }
            int i2 = simpleDecoderOutputBuffer2.f6077c;
            if (i2 > 0) {
                this.u.f6130f += i2;
                defaultAudioSink.M = true;
            }
            if (simpleDecoderOutputBuffer2.g(134217728)) {
                defaultAudioSink.M = true;
                if (this.Q != 0) {
                    long[] jArr = this.M;
                    W(jArr[0]);
                    int i3 = this.Q - 1;
                    this.Q = i3;
                    System.arraycopy(jArr, 1, jArr, 0, i3);
                }
            }
        }
        if (this.B.g(4)) {
            if (this.E != 2) {
                this.B.getClass();
                throw null;
            }
            V();
            T();
            this.G = true;
            return;
        }
        if (this.G) {
            Format.Builder builderA = S().a();
            builderA.C = this.w;
            builderA.D = this.x;
            Format format = this.v;
            builderA.f5235j = format.f5223k;
            builderA.f5226a = format.f5213a;
            builderA.f5227b = format.f5214b;
            builderA.f5228c = ImmutableList.o(format.f5215c);
            Format format2 = this.v;
            builderA.f5229d = format2.f5216d;
            builderA.f5230e = format2.f5217e;
            builderA.f5231f = format2.f5218f;
            defaultAudioSink.c(new Format(builderA), null);
            this.G = false;
        }
        this.B.getClass();
        if (defaultAudioSink.m(null, 1, this.B.f6076b)) {
            this.u.f6129e++;
            this.B.getClass();
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean R() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r7 = this;
            androidx.media3.decoder.Decoder r0 = r7.z
            r1 = 0
            if (r0 == 0) goto L90
            int r2 = r7.E
            r3 = 2
            if (r2 == r3) goto L90
            boolean r2 = r7.J
            if (r2 == 0) goto L10
            goto L90
        L10:
            androidx.media3.decoder.DecoderInputBuffer r2 = r7.A
            if (r2 != 0) goto L1f
            java.lang.Object r0 = r0.e()
            androidx.media3.decoder.DecoderInputBuffer r0 = (androidx.media3.decoder.DecoderInputBuffer) r0
            r7.A = r0
            if (r0 != 0) goto L1f
            goto L90
        L1f:
            int r0 = r7.E
            r2 = 4
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L34
            androidx.media3.decoder.DecoderInputBuffer r0 = r7.A
            r0.f6056a = r2
            androidx.media3.decoder.Decoder r2 = r7.z
            r2.b(r0)
            r7.A = r4
            r7.E = r3
            return r1
        L34:
            androidx.media3.exoplayer.FormatHolder r0 = r7.f6114c
            r0.a()
            androidx.media3.decoder.DecoderInputBuffer r3 = r7.A
            int r3 = r7.O(r0, r3, r1)
            r6 = -5
            if (r3 == r6) goto L8c
            r0 = -4
            if (r3 == r0) goto L4f
            r0 = -3
            if (r3 != r0) goto L49
            goto L90
        L49:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L4f:
            androidx.media3.decoder.DecoderInputBuffer r0 = r7.A
            boolean r0 = r0.g(r2)
            if (r0 == 0) goto L63
            r7.J = r5
            androidx.media3.decoder.Decoder r0 = r7.z
            androidx.media3.decoder.DecoderInputBuffer r2 = r7.A
            r0.b(r2)
            r7.A = r4
            return r1
        L63:
            boolean r0 = r7.y
            if (r0 != 0) goto L70
            r7.y = r5
            androidx.media3.decoder.DecoderInputBuffer r0 = r7.A
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r0.e(r1)
        L70:
            androidx.media3.decoder.DecoderInputBuffer r0 = r7.A
            r0.n()
            androidx.media3.decoder.DecoderInputBuffer r0 = r7.A
            androidx.media3.common.Format r1 = r7.v
            r0.f6069b = r1
            androidx.media3.decoder.Decoder r1 = r7.z
            r1.b(r0)
            r7.F = r5
            androidx.media3.exoplayer.DecoderCounters r0 = r7.u
            int r1 = r0.f6127c
            int r1 = r1 + r5
            r0.f6127c = r1
            r7.A = r4
            return r5
        L8c:
            r7.U(r0)
            return r5
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DecoderAudioRenderer.R():boolean");
    }

    public abstract Format S();

    public final void T() throws ExoPlaybackException {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.r;
        if (this.z != null) {
            return;
        }
        DrmSession drmSession = this.D;
        DrmSession.c(this.C, drmSession);
        this.C = drmSession;
        if (drmSession != null && drmSession.d() == null && this.C.getError() == null) {
            return;
        }
        try {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            Trace.beginSection("createAudioDecoder");
            Decoder decoderP = P();
            this.z = decoderP;
            decoderP.d(this.f6123l);
            Trace.endSection();
            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            String name = this.z.getName();
            long j2 = jElapsedRealtime2 - jElapsedRealtime;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new e(eventDispatcher, name, jElapsedRealtime2, j2, 0));
            }
            this.u.f6125a++;
        } catch (DecoderException e2) {
            Log.e("DecoderAudioRenderer", "Audio codec error", e2);
            Handler handler2 = eventDispatcher.f6523a;
            if (handler2 != null) {
                handler2.post(new d(eventDispatcher, e2, 0));
            }
            throw C(e2, this.v, false, 4001);
        } catch (OutOfMemoryError e3) {
            throw C(e3, this.v, false, 4001);
        }
    }

    public final void U(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = formatHolder.f6254b;
        format.getClass();
        DrmSession drmSession = formatHolder.f6253a;
        DrmSession.c(this.D, drmSession);
        this.D = drmSession;
        Format format2 = this.v;
        this.v = format;
        this.w = format.D;
        this.x = format.E;
        Decoder decoder = this.z;
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.r;
        if (decoder == null) {
            T();
            Format format3 = this.v;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new androidx.media3.common.util.e(eventDispatcher, format3, null, 2));
                return;
            }
            return;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = drmSession != this.C ? new DecoderReuseEvaluation(decoder.getName(), format2, format, 0, 128) : new DecoderReuseEvaluation(decoder.getName(), format2, format, 0, 1);
        if (decoderReuseEvaluation.f6140d == 0) {
            if (this.F) {
                this.E = 1;
            } else {
                V();
                T();
                this.G = true;
            }
        }
        Format format4 = this.v;
        Handler handler2 = eventDispatcher.f6523a;
        if (handler2 != null) {
            handler2.post(new androidx.media3.common.util.e(eventDispatcher, format4, decoderReuseEvaluation, 2));
        }
    }

    public final void V() {
        this.A = null;
        this.B = null;
        this.E = 0;
        this.F = false;
        Decoder decoder = this.z;
        if (decoder != null) {
            this.u.f6126b++;
            decoder.release();
            String name = this.z.getName();
            AudioRendererEventListener.EventDispatcher eventDispatcher = this.r;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new androidx.constraintlayout.motion.widget.a(4, eventDispatcher, name));
            }
            this.z = null;
        }
        DrmSession.c(this.C, null);
        this.C = null;
    }

    public final void W(long j2) {
        this.L = j2;
        if (j2 != -9223372036854775807L) {
            this.s.getClass();
        }
    }

    public abstract int X();

    public final void Y() {
        long jH = this.s.h(c());
        if (jH != Long.MIN_VALUE) {
            if (!this.I) {
                jH = Math.max(this.H, jH);
            }
            this.H = jH;
            this.I = false;
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean a() {
        if (this.s.n()) {
            return true;
        }
        if (this.v != null) {
            return E() || this.B != null;
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int b(Format format) {
        if (!MimeTypes.l(format.f5225m)) {
            return RendererCapabilities.h(0, 0, 0, 0);
        }
        int iX = X();
        if (iX <= 2) {
            return RendererCapabilities.h(iX, 0, 0, 0);
        }
        return iX | 8 | (Util.f5744a >= 21 ? 32 : 0) | 128;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final boolean c() {
        return this.K && this.s.q();
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void i(long j2, long j3) throws IllegalStateException, ExoPlaybackException {
        if (this.K) {
            try {
                this.s.w();
                return;
            } catch (AudioSink.WriteException e2) {
                throw C(e2, e2.f6537c, e2.f6536b, 5002);
            }
        }
        if (this.v == null) {
            FormatHolder formatHolder = this.f6114c;
            formatHolder.a();
            this.t.h();
            int iO = O(formatHolder, this.t, 2);
            if (iO != -5) {
                if (iO == -4) {
                    Assertions.g(this.t.g(4));
                    this.J = true;
                    try {
                        this.K = true;
                        this.s.w();
                        return;
                    } catch (AudioSink.WriteException e3) {
                        throw C(e3, null, false, 5002);
                    }
                }
                return;
            }
            U(formatHolder);
        }
        T();
        if (this.z != null) {
            try {
                Trace.beginSection("drainAndFeed");
                Q();
                while (R()) {
                }
                Trace.endSection();
                synchronized (this.u) {
                }
            } catch (DecoderException e4) {
                Log.e("DecoderAudioRenderer", "Audio codec error", e4);
                AudioRendererEventListener.EventDispatcher eventDispatcher = this.r;
                Handler handler = eventDispatcher.f6523a;
                if (handler != null) {
                    handler.post(new d(eventDispatcher, e4, 0));
                }
                throw C(e4, this.v, false, 4003);
            } catch (AudioSink.ConfigurationException e5) {
                throw C(e5, e5.f6531a, false, 5001);
            } catch (AudioSink.InitializationException e6) {
                throw C(e6, e6.f6534c, e6.f6533b, 5001);
            } catch (AudioSink.WriteException e7) {
                throw C(e7, e7.f6537c, e7.f6536b, 5002);
            }
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final boolean n() {
        boolean z = this.X;
        this.X = false;
        return z;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void o(int i2, Object obj) throws IllegalStateException {
        DefaultAudioSink defaultAudioSink = this.s;
        if (i2 == 2) {
            defaultAudioSink.G(((Float) obj).floatValue());
            return;
        }
        if (i2 == 3) {
            defaultAudioSink.z((AudioAttributes) obj);
            return;
        }
        if (i2 == 6) {
            defaultAudioSink.C((AuxEffectInfo) obj);
            return;
        }
        if (i2 == 12) {
            if (Util.f5744a >= 23) {
                Api23.a(defaultAudioSink, obj);
            }
        } else if (i2 == 9) {
            defaultAudioSink.F(((Boolean) obj).booleanValue());
        } else {
            if (i2 != 10) {
                return;
            }
            defaultAudioSink.A(((Integer) obj).intValue());
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final long w() {
        if (this.f6119h == 2) {
            Y();
        }
        return this.H;
    }
}
