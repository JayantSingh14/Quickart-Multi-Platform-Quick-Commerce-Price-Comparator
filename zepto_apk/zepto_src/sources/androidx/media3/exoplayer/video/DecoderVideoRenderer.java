package androidx.media3.exoplayer.video;

import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.drm.DrmSession;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class DecoderVideoRenderer extends BaseRenderer {
    public DrmSession A;
    public DrmSession B;
    public int C;
    public boolean D;
    public int E;
    public long F;
    public boolean G;
    public VideoSize H;
    public int I;
    public DecoderCounters J;
    public Format r;
    public Decoder s;
    public DecoderInputBuffer t;
    public VideoDecoderOutputBuffer u;
    public int v;
    public Object w;
    public Surface x;
    public VideoDecoderOutputBufferRenderer y;
    public VideoFrameMetadataListener z;

    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        throw null;
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G() {
        /*
            r3 = this;
            r0 = 0
            r3.r = r0
            r3.H = r0
            int r1 = r3.E
            r2 = 0
            int r1 = java.lang.Math.min(r1, r2)
            r3.E = r1
            androidx.media3.exoplayer.drm.DrmSession r1 = r3.B     // Catch: java.lang.Throwable -> L19
            androidx.media3.exoplayer.drm.DrmSession.c(r1, r0)     // Catch: java.lang.Throwable -> L19
            r3.B = r0     // Catch: java.lang.Throwable -> L19
            r3.T()     // Catch: java.lang.Throwable -> L19
            throw r0
        L19:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.DecoderVideoRenderer.G():void");
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void H(boolean z, boolean z2) {
        this.J = new DecoderCounters();
        throw null;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void I(long j2, boolean z) throws ExoPlaybackException {
        this.G = false;
        this.E = Math.min(this.E, 1);
        this.F = -9223372036854775807L;
        Decoder decoder = this.s;
        if (decoder == null) {
            throw null;
        }
        if (this.C != 0) {
            T();
            S();
            throw null;
        }
        this.t = null;
        if (this.u != null) {
            throw null;
        }
        decoder.flush();
        decoder.d(this.f6123l);
        this.D = false;
        throw null;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void L() {
        this.I = 0;
        SystemClock.elapsedRealtime();
        SystemClock.elapsedRealtime();
        int i2 = Util.f5744a;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void M() {
        if (this.I <= 0) {
            return;
        }
        SystemClock.elapsedRealtime();
        throw null;
    }

    public abstract Decoder P();

    public final void Q(long j2) throws ExoPlaybackException {
        if (this.u == null) {
            Decoder decoder = this.s;
            decoder.getClass();
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) decoder.a();
            this.u = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return;
            }
            this.J.f6130f += videoDecoderOutputBuffer.f6077c;
        }
        if (this.u.g(4)) {
            if (this.C != 2) {
                this.u.getClass();
                throw null;
            }
            T();
            S();
            return;
        }
        if (this.F == -9223372036854775807L) {
            this.F = j2;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.u;
        videoDecoderOutputBuffer2.getClass();
        long j3 = videoDecoderOutputBuffer2.f6076b - j2;
        if (this.v != -1) {
            throw null;
        }
        if (j3 >= -30000) {
            return;
        }
        this.J.f6130f++;
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean R() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r12 = this;
            androidx.media3.decoder.Decoder r0 = r12.s
            r1 = 0
            if (r0 == 0) goto Lc6
            int r2 = r12.C
            r3 = 2
            if (r2 == r3) goto Lc6
            boolean r2 = r12.G
            if (r2 == 0) goto L10
            goto Lc6
        L10:
            androidx.media3.decoder.DecoderInputBuffer r2 = r12.t
            if (r2 != 0) goto L20
            java.lang.Object r0 = r0.e()
            androidx.media3.decoder.DecoderInputBuffer r0 = (androidx.media3.decoder.DecoderInputBuffer) r0
            r12.t = r0
            if (r0 != 0) goto L20
            goto Lc6
        L20:
            androidx.media3.decoder.DecoderInputBuffer r0 = r12.t
            r0.getClass()
            int r2 = r12.C
            r4 = 1
            r5 = 0
            r6 = 4
            if (r2 != r4) goto L3b
            r0.f6056a = r6
            androidx.media3.decoder.Decoder r2 = r12.s
            r2.getClass()
            r2.b(r0)
            r12.t = r5
            r12.C = r3
            return r1
        L3b:
            androidx.media3.exoplayer.FormatHolder r2 = r12.f6114c
            r2.a()
            int r3 = r12.O(r2, r0, r1)
            r7 = -5
            if (r3 == r7) goto L6e
            r2 = -4
            if (r3 == r2) goto L55
            r0 = -3
            if (r3 != r0) goto L4f
            goto Lc6
        L4f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L55:
            boolean r2 = r0.g(r6)
            if (r2 == 0) goto L68
            r12.G = r4
            androidx.media3.decoder.Decoder r2 = r12.s
            r2.getClass()
            r2.b(r0)
            r12.t = r5
            return r1
        L68:
            androidx.media3.common.Format r0 = r12.r
            r0.getClass()
            throw r5
        L6e:
            androidx.media3.common.Format r9 = r2.f6254b
            r9.getClass()
            androidx.media3.exoplayer.drm.DrmSession r0 = r2.f6253a
            androidx.media3.exoplayer.drm.DrmSession r1 = r12.B
            androidx.media3.exoplayer.drm.DrmSession.c(r1, r0)
            r12.B = r0
            androidx.media3.common.Format r8 = r12.r
            r12.r = r9
            androidx.media3.decoder.Decoder r1 = r12.s
            if (r1 == 0) goto Lbd
            androidx.media3.exoplayer.drm.DrmSession r2 = r12.A
            if (r0 == r2) goto L98
            androidx.media3.exoplayer.DecoderReuseEvaluation r6 = new androidx.media3.exoplayer.DecoderReuseEvaluation
            java.lang.String r7 = r1.getName()
            r8.getClass()
            r10 = 0
            r11 = 128(0x80, float:1.794E-43)
            r6.<init>(r7, r8, r9, r10, r11)
            goto La6
        L98:
            java.lang.String r7 = r1.getName()
            r8.getClass()
            androidx.media3.exoplayer.DecoderReuseEvaluation r6 = new androidx.media3.exoplayer.DecoderReuseEvaluation
            r10 = 0
            r11 = 1
            r6.<init>(r7, r8, r9, r10, r11)
        La6:
            int r0 = r6.f6140d
            if (r0 != 0) goto Lb7
            boolean r0 = r12.D
            if (r0 == 0) goto Lb1
            r12.C = r4
            goto Lb7
        Lb1:
            r12.T()
            r12.S()
        Lb7:
            androidx.media3.common.Format r0 = r12.r
            r0.getClass()
            throw r5
        Lbd:
            r12.S()
            androidx.media3.common.Format r0 = r12.r
            r0.getClass()
            throw r5
        Lc6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.DecoderVideoRenderer.R():boolean");
    }

    public final void S() throws ExoPlaybackException {
        if (this.s != null) {
            return;
        }
        DrmSession drmSession = this.B;
        DrmSession.c(this.A, drmSession);
        this.A = drmSession;
        if (drmSession != null && drmSession.d() == null && this.A.getError() == null) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.r.getClass();
            Decoder decoderP = P();
            this.s = decoderP;
            decoderP.d(this.f6123l);
            U();
            SystemClock.elapsedRealtime();
            this.s.getClass();
            throw null;
        } catch (DecoderException e2) {
            Log.e("DecoderVideoRenderer", "Video codec error", e2);
            throw null;
        } catch (OutOfMemoryError e3) {
            throw C(e3, this.r, false, 4001);
        }
    }

    public final void T() {
        this.t = null;
        this.u = null;
        this.C = 0;
        this.D = false;
        Decoder decoder = this.s;
        if (decoder == null) {
            DrmSession.c(this.A, null);
            this.A = null;
        } else {
            this.J.f6126b++;
            decoder.release();
            this.s.getClass();
            throw null;
        }
    }

    public abstract void U();

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean a() {
        if (this.r == null) {
            return false;
        }
        if (E() || this.u != null) {
            return this.E == 3 || this.v == -1;
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final boolean c() {
        return false;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void f() {
        if (this.E == 0) {
            this.E = 1;
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void i(long j2, long j3) throws ExoPlaybackException {
        if (this.r == null) {
            this.f6114c.a();
            throw null;
        }
        S();
        if (this.s != null) {
            try {
                Trace.beginSection("drainAndFeed");
                Q(j2);
                R();
                Trace.endSection();
                synchronized (this.J) {
                }
            } catch (DecoderException e2) {
                Log.e("DecoderVideoRenderer", "Video codec error", e2);
                throw null;
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void o(int i2, Object obj) {
        if (i2 != 1) {
            if (i2 == 7) {
                this.z = (VideoFrameMetadataListener) obj;
                return;
            }
            return;
        }
        if (obj instanceof Surface) {
            this.x = (Surface) obj;
            this.y = null;
            this.v = 1;
        } else if (obj instanceof VideoDecoderOutputBufferRenderer) {
            this.x = null;
            this.y = (VideoDecoderOutputBufferRenderer) obj;
            this.v = 0;
        } else {
            this.x = null;
            this.y = null;
            this.v = -1;
            obj = null;
        }
        Object obj2 = this.w;
        if (obj2 == obj) {
            if (obj != null) {
                if (this.H != null) {
                    throw null;
                }
                if (this.E == 3 && obj2 != null) {
                    throw null;
                }
                return;
            }
            return;
        }
        this.w = obj;
        if (obj == null) {
            this.H = null;
            this.E = Math.min(this.E, 1);
            return;
        }
        if (this.s != null) {
            U();
        }
        if (this.H != null) {
            throw null;
        }
        this.E = Math.min(this.E, 1);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void N(Format[] formatArr, long j2, long j3) {
    }
}
