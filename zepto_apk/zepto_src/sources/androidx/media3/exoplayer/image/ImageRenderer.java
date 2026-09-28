package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import android.os.Trace;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;
import java.util.ArrayDeque;

@UnstableApi
/* loaded from: classes3.dex */
public class ImageRenderer extends BaseRenderer {
    public int A;
    public Format B;
    public ImageDecoder C;
    public DecoderInputBuffer D;
    public ImageOutput E;
    public Bitmap F;
    public boolean G;
    public TileInfo H;
    public TileInfo I;
    public int J;
    public final BitmapFactoryImageDecoder.Factory r;
    public final DecoderInputBuffer s;
    public final ArrayDeque t;
    public boolean u;
    public boolean v;
    public OutputStreamInfo w;
    public long x;
    public long y;
    public int z;

    public static final class OutputStreamInfo {

        /* renamed from: c, reason: collision with root package name */
        public static final OutputStreamInfo f7261c = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L);

        /* renamed from: a, reason: collision with root package name */
        public final long f7262a;

        /* renamed from: b, reason: collision with root package name */
        public final long f7263b;

        public OutputStreamInfo(long j2, long j3) {
            this.f7262a = j2;
            this.f7263b = j3;
        }
    }

    public static class TileInfo {

        /* renamed from: a, reason: collision with root package name */
        public final int f7264a;

        /* renamed from: b, reason: collision with root package name */
        public final long f7265b;

        /* renamed from: c, reason: collision with root package name */
        public Bitmap f7266c;

        public TileInfo(int i2, long j2) {
            this.f7264a = i2;
            this.f7265b = j2;
        }
    }

    public ImageRenderer(BitmapFactoryImageDecoder.Factory factory) {
        super(4);
        this.r = factory;
        this.E = ImageOutput.f7259a;
        this.s = new DecoderInputBuffer(0);
        this.w = OutputStreamInfo.f7261c;
        this.t = new ArrayDeque();
        this.y = -9223372036854775807L;
        this.x = -9223372036854775807L;
        this.z = 0;
        this.A = 1;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void G() {
        this.B = null;
        this.w = OutputStreamInfo.f7261c;
        this.t.clear();
        S();
        this.E.a();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void H(boolean z, boolean z2) {
        this.A = z2 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void I(long j2, boolean z) {
        this.A = Math.min(this.A, 1);
        this.v = false;
        this.u = false;
        this.F = null;
        this.H = null;
        this.I = null;
        this.G = false;
        this.D = null;
        ImageDecoder imageDecoder = this.C;
        if (imageDecoder != null) {
            imageDecoder.flush();
        }
        this.t.clear();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void J() {
        S();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void K() {
        S();
        this.A = Math.min(this.A, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r2 >= r7) goto L15;
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(androidx.media3.common.Format[] r6, long r7, long r9) {
        /*
            r5 = this;
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r6 = r5.w
            long r6 = r6.f7263b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 == 0) goto L31
            java.util.ArrayDeque r6 = r5.t
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L26
            long r7 = r5.y
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 == 0) goto L31
            long r2 = r5.x
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 == 0) goto L26
            int r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r7 < 0) goto L26
            goto L31
        L26:
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r7 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            long r0 = r5.y
            r7.<init>(r0, r9)
            r6.add(r7)
            return
        L31:
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r6 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            r6.<init>(r0, r9)
            r5.w = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.image.ImageRenderer.N(androidx.media3.common.Format[], long, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean P(long r13) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.image.ImageRenderer.P(long):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Q(long r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.image.ImageRenderer.Q(long):boolean");
    }

    public final void R() throws ExoPlaybackException {
        Format format = this.B;
        BitmapFactoryImageDecoder.Factory factory = this.r;
        int iA = factory.a(format);
        if (iA != RendererCapabilities.h(4, 0, 0, 0) && iA != RendererCapabilities.h(3, 0, 0, 0)) {
            throw C(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.B, false, 4005);
        }
        ImageDecoder imageDecoder = this.C;
        if (imageDecoder != null) {
            imageDecoder.release();
        }
        this.C = new BitmapFactoryImageDecoder(factory.f7257b);
    }

    public final void S() {
        this.D = null;
        this.z = 0;
        this.y = -9223372036854775807L;
        ImageDecoder imageDecoder = this.C;
        if (imageDecoder != null) {
            imageDecoder.release();
            this.C = null;
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean a() {
        int i2 = this.A;
        if (i2 != 3) {
            return i2 == 0 && this.G;
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int b(Format format) {
        return this.r.a(format);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final boolean c() {
        return this.v;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final String getName() {
        return "ImageRenderer";
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void i(long j2, long j3) throws ExoPlaybackException {
        if (this.v) {
            return;
        }
        if (this.B == null) {
            FormatHolder formatHolder = this.f6114c;
            formatHolder.a();
            DecoderInputBuffer decoderInputBuffer = this.s;
            decoderInputBuffer.h();
            int iO = O(formatHolder, decoderInputBuffer, 2);
            if (iO != -5) {
                if (iO == -4) {
                    Assertions.g(decoderInputBuffer.g(4));
                    this.u = true;
                    this.v = true;
                    return;
                }
                return;
            }
            Format format = formatHolder.f6254b;
            Assertions.h(format);
            this.B = format;
            R();
        }
        try {
            Trace.beginSection("drainAndFeedDecoder");
            while (P(j2)) {
            }
            while (Q(j2)) {
            }
            Trace.endSection();
        } catch (ImageDecoderException e2) {
            throw C(e2, null, false, 4003);
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void o(int i2, Object obj) {
        if (i2 != 15) {
            return;
        }
        ImageOutput imageOutput = obj instanceof ImageOutput ? (ImageOutput) obj : null;
        if (imageOutput == null) {
            imageOutput = ImageOutput.f7259a;
        }
        this.E = imageOutput;
    }
}
