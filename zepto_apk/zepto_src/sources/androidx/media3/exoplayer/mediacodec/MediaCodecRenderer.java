package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.OggOpusAudioPacketizer;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.FrameworkCryptoConfig;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Flags;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    public static final byte[] n1 = {0, 0, 1, 103, 66, -64, Flags.CD, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final ArrayDeque A;
    public DecoderInitializationException A0;
    public final OggOpusAudioPacketizer B;
    public MediaCodecInfo B0;
    public Format C;
    public int C0;
    public Format D;
    public boolean D0;
    public DrmSession E;
    public boolean E0;
    public DrmSession F;
    public boolean F0;
    public Renderer.WakeupListener G;
    public boolean G0;
    public MediaCrypto H;
    public boolean H0;
    public final long I;
    public boolean I0;
    public float J;
    public boolean J0;
    public float K;
    public boolean K0;
    public MediaCodecAdapter L;
    public boolean L0;
    public Format M;
    public long M0;
    public int N0;
    public int O0;
    public ByteBuffer P0;
    public MediaFormat Q;
    public boolean Q0;
    public boolean R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;
    public int W0;
    public boolean X;
    public int X0;
    public float Y;
    public int Y0;
    public ArrayDeque Z;
    public boolean Z0;
    public boolean a1;
    public boolean b1;
    public long c1;
    public long d1;
    public boolean e1;
    public boolean f1;
    public boolean g1;
    public boolean h1;
    public ExoPlaybackException i1;
    public DecoderCounters j1;
    public OutputStreamInfo k1;
    public long l1;
    public boolean m1;
    public final MediaCodecAdapter.Factory r;
    public final d s;
    public final boolean t;
    public final float u;
    public final DecoderInputBuffer v;
    public final DecoderInputBuffer w;
    public final DecoderInputBuffer x;
    public final BatchBuffer y;
    public final MediaCodec.BufferInfo z;

    @RequiresApi
    public static final class Api21 {
        @DoNotInline
        public static boolean a(MediaCodecAdapter mediaCodecAdapter, MediaCodecRendererCodecAdapterListener mediaCodecRendererCodecAdapterListener) {
            return mediaCodecAdapter.d(mediaCodecRendererCodecAdapterListener);
        }
    }

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static void a(MediaCodecAdapter.Configuration configuration, PlayerId playerId) {
            LogSessionId logSessionIdA = playerId.a();
            LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            configuration.f7315b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    public final class MediaCodecRendererCodecAdapterListener implements MediaCodecAdapter.OnBufferAvailableListener {
        public MediaCodecRendererCodecAdapterListener() {
        }
    }

    public static final class OutputStreamInfo {

        /* renamed from: e, reason: collision with root package name */
        public static final OutputStreamInfo f7334e = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);

        /* renamed from: a, reason: collision with root package name */
        public final long f7335a;

        /* renamed from: b, reason: collision with root package name */
        public final long f7336b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7337c;

        /* renamed from: d, reason: collision with root package name */
        public final TimedValueQueue f7338d = new TimedValueQueue();

        public OutputStreamInfo(long j2, long j3, long j4) {
            this.f7335a = j2;
            this.f7336b = j3;
            this.f7337c = j4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecRenderer(int i2, MediaCodecAdapter.Factory factory, boolean z, float f2) {
        super(i2);
        d dVar = MediaCodecSelector.f7339a;
        this.r = factory;
        this.s = dVar;
        this.t = z;
        this.u = f2;
        this.v = new DecoderInputBuffer(0);
        this.w = new DecoderInputBuffer(0);
        this.x = new DecoderInputBuffer(2);
        BatchBuffer batchBuffer = new BatchBuffer();
        this.y = batchBuffer;
        this.z = new MediaCodec.BufferInfo();
        this.J = 1.0f;
        this.K = 1.0f;
        this.I = -9223372036854775807L;
        this.A = new ArrayDeque();
        this.k1 = OutputStreamInfo.f7334e;
        batchBuffer.l(0);
        batchBuffer.f6071d.order(ByteOrder.nativeOrder());
        this.B = new OggOpusAudioPacketizer();
        this.Y = -1.0f;
        this.C0 = 0;
        this.W0 = 0;
        this.N0 = -1;
        this.O0 = -1;
        this.M0 = -9223372036854775807L;
        this.c1 = -9223372036854775807L;
        this.d1 = -9223372036854775807L;
        this.l1 = -9223372036854775807L;
        this.X0 = 0;
        this.Y0 = 0;
        this.j1 = new DecoderCounters();
    }

    public void A0() {
        this.N0 = -1;
        this.w.f6071d = null;
        this.O0 = -1;
        this.P0 = null;
        this.M0 = -9223372036854775807L;
        this.a1 = false;
        this.Z0 = false;
        this.J0 = false;
        this.K0 = false;
        this.Q0 = false;
        this.R0 = false;
        this.c1 = -9223372036854775807L;
        this.d1 = -9223372036854775807L;
        this.l1 = -9223372036854775807L;
        this.X0 = 0;
        this.Y0 = 0;
        this.W0 = this.V0 ? 1 : 0;
    }

    public final void B0() {
        A0();
        this.i1 = null;
        this.Z = null;
        this.B0 = null;
        this.M = null;
        this.Q = null;
        this.X = false;
        this.b1 = false;
        this.Y = -1.0f;
        this.C0 = 0;
        this.D0 = false;
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.H0 = false;
        this.I0 = false;
        this.L0 = false;
        this.V0 = false;
        this.W0 = 0;
    }

    public final void C0(DrmSession drmSession) {
        DrmSession.c(this.E, drmSession);
        this.E = drmSession;
    }

    public final void D0(OutputStreamInfo outputStreamInfo) {
        this.k1 = outputStreamInfo;
        long j2 = outputStreamInfo.f7337c;
        if (j2 != -9223372036854775807L) {
            this.m1 = true;
            q0(j2);
        }
    }

    public boolean E0(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public boolean F0(Format format) {
        return false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void G() throws MediaCryptoException {
        this.C = null;
        D0(OutputStreamInfo.f7334e);
        this.A.clear();
        X();
    }

    public abstract int G0(d dVar, Format format);

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void H(boolean z, boolean z2) {
        this.j1 = new DecoderCounters();
    }

    public final boolean H0(Format format) {
        if (Util.f5744a >= 23 && this.L != null && this.Y0 != 3 && this.f6119h != 0) {
            float f2 = this.K;
            format.getClass();
            Format[] formatArr = this.f6121j;
            formatArr.getClass();
            float fB0 = b0(f2, formatArr);
            float f3 = this.Y;
            if (f3 != fB0) {
                if (fB0 == -1.0f) {
                    if (this.Z0) {
                        this.X0 = 1;
                        this.Y0 = 3;
                        return false;
                    }
                    y0();
                    j0();
                    return false;
                }
                if (f3 != -1.0f || fB0 > this.u) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fB0);
                    MediaCodecAdapter mediaCodecAdapter = this.L;
                    mediaCodecAdapter.getClass();
                    mediaCodecAdapter.b(bundle);
                    this.Y = fB0;
                }
            }
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void I(long j2, boolean z) {
        this.e1 = false;
        this.f1 = false;
        this.h1 = false;
        if (this.S0) {
            this.y.h();
            this.x.h();
            this.T0 = false;
            OggOpusAudioPacketizer oggOpusAudioPacketizer = this.B;
            oggOpusAudioPacketizer.getClass();
            oggOpusAudioPacketizer.f6620a = AudioProcessor.f5572a;
            oggOpusAudioPacketizer.f6622c = 0;
            oggOpusAudioPacketizer.f6621b = 2;
        } else if (X()) {
            j0();
        }
        if (this.k1.f7338d.h() > 0) {
            this.g1 = true;
        }
        this.k1.f7338d.b();
        this.A.clear();
    }

    public final void I0() throws MediaCryptoException, ExoPlaybackException {
        DrmSession drmSession = this.F;
        drmSession.getClass();
        CryptoConfig cryptoConfigD = drmSession.d();
        if (cryptoConfigD instanceof FrameworkCryptoConfig) {
            try {
                MediaCrypto mediaCrypto = this.H;
                mediaCrypto.getClass();
                mediaCrypto.setMediaDrmSession(((FrameworkCryptoConfig) cryptoConfigD).f6937b);
            } catch (MediaCryptoException e2) {
                throw C(e2, this.C, false, 6006);
            }
        }
        C0(this.F);
        this.X0 = 0;
        this.Y0 = 0;
    }

    public final void J0(long j2) {
        Format format = (Format) this.k1.f7338d.f(j2);
        if (format == null && this.m1 && this.Q != null) {
            format = (Format) this.k1.f7338d.e();
        }
        if (format != null) {
            this.D = format;
        } else if (!this.X || this.D == null) {
            return;
        }
        Format format2 = this.D;
        format2.getClass();
        p0(format2, this.Q);
        this.X = false;
        this.m1 = false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void K() {
        try {
            S();
            y0();
        } finally {
            DrmSession.c(this.F, null);
            this.F = null;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void L() {
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void M() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r4 >= r0) goto L14;
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(androidx.media3.common.Format[] r13, long r14, long r16) {
        /*
            r12 = this;
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r13 = r12.k1
            long r0 = r13.f7337c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L1e
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r4 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r14
            r9 = r16
            r4.<init>(r5, r7, r9)
            r12.D0(r4)
            return
        L1e:
            java.util.ArrayDeque r13 = r12.A
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L52
            long r0 = r12.c1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L36
            long r4 = r12.l1
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L52
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L52
        L36:
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r5 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.D0(r5)
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r13 = r12.k1
            long r13 = r13.f7337c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L51
            r12.s0()
        L51:
            return
        L52:
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r5 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            long r6 = r12.c1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r13.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.N(androidx.media3.common.Format[], long, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0312  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean P(long r26, long r28) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 830
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.P(long, long):boolean");
    }

    public DecoderReuseEvaluation Q(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return new DecoderReuseEvaluation(mediaCodecInfo.f7320a, format, format2, 0, 1);
    }

    public MediaCodecDecoderException R(IllegalStateException illegalStateException, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(illegalStateException, mediaCodecInfo);
    }

    public final void S() {
        this.U0 = false;
        this.y.h();
        this.x.h();
        this.T0 = false;
        this.S0 = false;
        OggOpusAudioPacketizer oggOpusAudioPacketizer = this.B;
        oggOpusAudioPacketizer.getClass();
        oggOpusAudioPacketizer.f6620a = AudioProcessor.f5572a;
        oggOpusAudioPacketizer.f6622c = 0;
        oggOpusAudioPacketizer.f6621b = 2;
    }

    public final boolean T() throws MediaCryptoException, ExoPlaybackException {
        if (!this.Z0) {
            I0();
            return true;
        }
        this.X0 = 1;
        if (this.E0 || this.G0) {
            this.Y0 = 3;
            return false;
        }
        this.Y0 = 2;
        return true;
    }

    public final boolean U(long j2, long j3) throws MediaCryptoException, ExoPlaybackException {
        boolean z;
        boolean z2;
        MediaCodec.BufferInfo bufferInfo;
        boolean zW0;
        ByteBuffer byteBuffer;
        int i2;
        int i3;
        long j4;
        boolean z3;
        boolean z4;
        Format format;
        int iL;
        MediaCodecAdapter mediaCodecAdapter = this.L;
        mediaCodecAdapter.getClass();
        boolean z5 = this.O0 >= 0;
        MediaCodec.BufferInfo bufferInfo2 = this.z;
        if (!z5) {
            if (this.H0 && this.a1) {
                try {
                    iL = mediaCodecAdapter.l(bufferInfo2);
                } catch (IllegalStateException unused) {
                    v0();
                    if (this.f1) {
                        y0();
                    }
                }
            } else {
                iL = mediaCodecAdapter.l(bufferInfo2);
            }
            if (iL < 0) {
                if (iL != -2) {
                    if (this.L0 && (this.e1 || this.X0 == 2)) {
                        v0();
                        return false;
                    }
                    return false;
                }
                this.b1 = true;
                MediaCodecAdapter mediaCodecAdapter2 = this.L;
                mediaCodecAdapter2.getClass();
                MediaFormat mediaFormatF = mediaCodecAdapter2.f();
                if (this.C0 != 0 && mediaFormatF.getInteger(Snapshot.WIDTH) == 32 && mediaFormatF.getInteger(Snapshot.HEIGHT) == 32) {
                    this.K0 = true;
                    return true;
                }
                this.Q = mediaFormatF;
                this.X = true;
                return true;
            }
            if (this.K0) {
                this.K0 = false;
                mediaCodecAdapter.m(iL, false);
                return true;
            }
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                v0();
                return false;
            }
            this.O0 = iL;
            ByteBuffer byteBufferN = mediaCodecAdapter.n(iL);
            this.P0 = byteBufferN;
            if (byteBufferN != null) {
                byteBufferN.position(bufferInfo2.offset);
                this.P0.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.I0 && bufferInfo2.presentationTimeUs == 0 && (bufferInfo2.flags & 4) != 0 && this.c1 != -9223372036854775807L) {
                bufferInfo2.presentationTimeUs = this.d1;
            }
            long j5 = bufferInfo2.presentationTimeUs;
            this.Q0 = j5 < this.f6123l;
            long j6 = this.d1;
            this.R0 = j6 != -9223372036854775807L && j6 <= j5;
            J0(j5);
        }
        if (this.H0 && this.a1) {
            try {
                byteBuffer = this.P0;
                i2 = this.O0;
                i3 = bufferInfo2.flags;
                j4 = bufferInfo2.presentationTimeUs;
                z3 = this.Q0;
                z4 = this.R0;
                format = this.D;
                format.getClass();
                z = true;
                z2 = false;
                bufferInfo = bufferInfo2;
            } catch (IllegalStateException unused2) {
                z2 = false;
            }
            try {
                zW0 = w0(j2, j3, mediaCodecAdapter, byteBuffer, i2, i3, 1, j4, z3, z4, format);
            } catch (IllegalStateException unused3) {
                v0();
                if (!this.f1) {
                    return z2;
                }
                y0();
                return z2;
            }
        } else {
            z = true;
            z2 = false;
            bufferInfo = bufferInfo2;
            ByteBuffer byteBuffer2 = this.P0;
            int i4 = this.O0;
            int i5 = bufferInfo.flags;
            long j7 = bufferInfo.presentationTimeUs;
            boolean z6 = this.Q0;
            boolean z7 = this.R0;
            Format format2 = this.D;
            format2.getClass();
            zW0 = w0(j2, j3, mediaCodecAdapter, byteBuffer2, i4, i5, 1, j7, z6, z7, format2);
        }
        if (!zW0) {
            return z2;
        }
        r0(bufferInfo.presentationTimeUs);
        boolean z8 = (bufferInfo.flags & 4) != 0 ? z : z2;
        this.O0 = -1;
        this.P0 = null;
        if (!z8) {
            return z;
        }
        v0();
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean V() throws android.media.MediaCryptoException, androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.V():boolean");
    }

    public final void W() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.L;
            Assertions.h(mediaCodecAdapter);
            mediaCodecAdapter.flush();
        } finally {
            A0();
        }
    }

    public final boolean X() throws MediaCryptoException {
        if (this.L == null) {
            return false;
        }
        int i2 = this.Y0;
        if (i2 == 3 || this.E0 || ((this.F0 && !this.b1) || (this.G0 && this.a1))) {
            y0();
            return true;
        }
        if (i2 == 2) {
            int i3 = Util.f5744a;
            Assertions.g(i3 >= 23);
            if (i3 >= 23) {
                try {
                    I0();
                } catch (ExoPlaybackException e2) {
                    Log.i("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e2);
                    y0();
                    return true;
                }
            }
        }
        W();
        return false;
    }

    public final List Y(boolean z) {
        Format format = this.C;
        format.getClass();
        d dVar = this.s;
        ArrayList arrayListC0 = c0(dVar, format, z);
        if (!arrayListC0.isEmpty() || !z) {
            return arrayListC0;
        }
        ArrayList arrayListC02 = c0(dVar, format, false);
        if (!arrayListC02.isEmpty()) {
            Log.h("MediaCodecRenderer", "Drm session requires secure decoder for " + format.f5225m + ", but no secure decoder available. Trying to proceed with " + arrayListC02 + CLConstants.DOT_SALT_DELIMETER);
        }
        return arrayListC02;
    }

    public int Z(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean a() {
        if (this.C == null) {
            return false;
        }
        if (E() || this.O0 >= 0) {
            return true;
        }
        if (this.M0 == -9223372036854775807L) {
            return false;
        }
        this.f6118g.getClass();
        return SystemClock.elapsedRealtime() < this.M0;
    }

    public boolean a0() {
        return false;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int b(Format format) throws ExoPlaybackException {
        try {
            return G0(this.s, format);
        } catch (MediaCodecUtil.DecoderQueryException e2) {
            throw C(e2, format, false, 4002);
        }
    }

    public float b0(float f2, Format[] formatArr) {
        return -1.0f;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public boolean c() {
        return this.f1;
    }

    public abstract ArrayList c0(d dVar, Format format, boolean z);

    public abstract MediaCodecAdapter.Configuration d0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f2);

    public final long e0() {
        return this.k1.f7337c;
    }

    public final long f0() {
        return this.k1.f7336b;
    }

    public void g0(DecoderInputBuffer decoderInputBuffer) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h0(androidx.media3.exoplayer.mediacodec.MediaCodecInfo r18, android.media.MediaCrypto r19) {
        /*
            Method dump skipped, instructions count: 637
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.h0(androidx.media3.exoplayer.mediacodec.MediaCodecInfo, android.media.MediaCrypto):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0075 A[LOOP:1: B:29:0x0050->B:39:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0096 A[LOOP:2: B:40:0x0076->B:50:0x0096, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0076 A[EDGE_INSN: B:87:0x0076->B:91:? BREAK  A[LOOP:1: B:29:0x0050->B:39:0x0075], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0097 A[EDGE_INSN: B:89:0x0097->B:51:0x0097 BREAK  A[LOOP:2: B:40:0x0076->B:50:0x0096], SYNTHETIC] */
    @Override // androidx.media3.exoplayer.Renderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(long r12, long r14) throws android.media.MediaCryptoException, androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.i(long, long):void");
    }

    public final boolean i0(long j2, long j3) {
        if (j3 >= j2) {
            return false;
        }
        Format format = this.D;
        return format == null || !Objects.equals(format.f5225m, "audio/opus") || j2 - j3 > 80000;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2 A[Catch: DecoderInitializationException -> 0x00bc, TryCatch #1 {DecoderInitializationException -> 0x00bc, blocks: (B:56:0x00ae, B:58:0x00b2, B:64:0x00bf), top: B:76:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0() {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.j0():void");
    }

    public final void k0(MediaCrypto mediaCrypto, boolean z) throws DecoderInitializationException {
        String diagnosticInfo;
        Format format = this.C;
        format.getClass();
        if (this.Z == null) {
            try {
                List listY = Y(z);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.Z = arrayDeque;
                if (this.t) {
                    arrayDeque.addAll(listY);
                } else {
                    ArrayList arrayList = (ArrayList) listY;
                    if (!arrayList.isEmpty()) {
                        this.Z.add((MediaCodecInfo) arrayList.get(0));
                    }
                }
                this.A0 = null;
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw new DecoderInitializationException(format, e2, z, -49998);
            }
        }
        if (this.Z.isEmpty()) {
            throw new DecoderInitializationException(format, null, z, -49999);
        }
        ArrayDeque arrayDeque2 = this.Z;
        arrayDeque2.getClass();
        while (this.L == null) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) arrayDeque2.peekFirst();
            mediaCodecInfo.getClass();
            if (!E0(mediaCodecInfo)) {
                return;
            }
            try {
                h0(mediaCodecInfo, mediaCrypto);
            } catch (Exception e3) {
                Log.i("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfo, e3);
                arrayDeque2.removeFirst();
                String str = "Decoder init failed: " + mediaCodecInfo.f7320a + ", " + format;
                if (Util.f5744a >= 21) {
                    diagnosticInfo = e3 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) e3).getDiagnosticInfo() : null;
                } else {
                    diagnosticInfo = null;
                }
                DecoderInitializationException decoderInitializationException = new DecoderInitializationException(str, e3, format.f5225m, z, mediaCodecInfo, diagnosticInfo);
                l0(decoderInitializationException);
                DecoderInitializationException decoderInitializationException2 = this.A0;
                if (decoderInitializationException2 == null) {
                    this.A0 = decoderInitializationException;
                } else {
                    this.A0 = new DecoderInitializationException(decoderInitializationException2.getMessage(), decoderInitializationException2.getCause(), decoderInitializationException2.f7329a, decoderInitializationException2.f7330b, decoderInitializationException2.f7331c, decoderInitializationException2.f7332d);
                }
                if (arrayDeque2.isEmpty()) {
                    throw this.A0;
                }
            }
        }
        this.Z = null;
    }

    public void l0(Exception exc) {
    }

    public void n0(String str) {
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void o(int i2, Object obj) {
        if (i2 == 11) {
            this.G = (Renderer.WakeupListener) obj;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c1, code lost:
    
        if (r4.g(r3) != false) goto L124;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.media3.exoplayer.DecoderReuseEvaluation o0(androidx.media3.exoplayer.FormatHolder r13) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.o0(androidx.media3.exoplayer.FormatHolder):androidx.media3.exoplayer.DecoderReuseEvaluation");
    }

    public void p0(Format format, MediaFormat mediaFormat) {
    }

    public void q0(long j2) {
    }

    public void r0(long j2) {
        this.l1 = j2;
        while (true) {
            ArrayDeque arrayDeque = this.A;
            if (arrayDeque.isEmpty() || j2 < ((OutputStreamInfo) arrayDeque.peek()).f7335a) {
                return;
            }
            OutputStreamInfo outputStreamInfo = (OutputStreamInfo) arrayDeque.poll();
            outputStreamInfo.getClass();
            D0(outputStreamInfo);
            s0();
        }
    }

    public void s0() {
    }

    public void t0(DecoderInputBuffer decoderInputBuffer) {
    }

    public void u0(Format format) {
    }

    public final void v0() throws MediaCryptoException, ExoPlaybackException {
        int i2 = this.Y0;
        if (i2 == 1) {
            W();
            return;
        }
        if (i2 == 2) {
            W();
            I0();
        } else if (i2 != 3) {
            this.f1 = true;
            z0();
        } else {
            y0();
            j0();
        }
    }

    public abstract boolean w0(long j2, long j3, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z, boolean z2, Format format);

    @Override // androidx.media3.exoplayer.Renderer
    public void x(float f2, float f3) {
        this.J = f2;
        this.K = f3;
        H0(this.M);
    }

    public final boolean x0(int i2) throws MediaCryptoException, ExoPlaybackException {
        FormatHolder formatHolder = this.f6114c;
        formatHolder.a();
        DecoderInputBuffer decoderInputBuffer = this.v;
        decoderInputBuffer.h();
        int iO = O(formatHolder, decoderInputBuffer, i2 | 4);
        if (iO == -5) {
            o0(formatHolder);
            return true;
        }
        if (iO != -4 || !decoderInputBuffer.g(4)) {
            return false;
        }
        this.e1 = true;
        v0();
        return false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.RendererCapabilities
    public final int y() {
        return 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y0() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.L;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.j1.f6126b++;
                MediaCodecInfo mediaCodecInfo = this.B0;
                mediaCodecInfo.getClass();
                n0(mediaCodecInfo.f7320a);
            }
            this.L = null;
            try {
                MediaCrypto mediaCrypto = this.H;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.L = null;
            try {
                MediaCrypto mediaCrypto2 = this.H;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    public void z0() {
    }

    public static class DecoderInitializationException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final String f7329a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7330b;

        /* renamed from: c, reason: collision with root package name */
        public final MediaCodecInfo f7331c;

        /* renamed from: d, reason: collision with root package name */
        public final String f7332d;

        public DecoderInitializationException(Format format, MediaCodecUtil.DecoderQueryException decoderQueryException, boolean z, int i2) {
            this("Decoder init failed: [" + i2 + "], " + format, decoderQueryException, format.f5225m, z, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i2 < 0 ? "neg_" : "") + Math.abs(i2));
        }

        public DecoderInitializationException(String str, Throwable th, String str2, boolean z, MediaCodecInfo mediaCodecInfo, String str3) {
            super(str, th);
            this.f7329a = str2;
            this.f7330b = z;
            this.f7331c = mediaCodecInfo;
            this.f7332d = str3;
        }
    }

    public void m0(long j2, long j3, String str) {
    }
}
