package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public final class CameraMotionRenderer extends BaseRenderer {
    public final DecoderInputBuffer r;
    public final ParsableByteArray s;
    public long t;
    public CameraMotionListener u;
    public long v;

    public CameraMotionRenderer() {
        super(6);
        this.r = new DecoderInputBuffer(1);
        this.s = new ParsableByteArray();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void G() {
        CameraMotionListener cameraMotionListener = this.u;
        if (cameraMotionListener != null) {
            cameraMotionListener.d();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void I(long j2, boolean z) {
        this.v = Long.MIN_VALUE;
        CameraMotionListener cameraMotionListener = this.u;
        if (cameraMotionListener != null) {
            cameraMotionListener.d();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void N(Format[] formatArr, long j2, long j3) {
        this.t = j3;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean a() {
        return true;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int b(Format format) {
        return "application/x-camera-motion".equals(format.f5225m) ? RendererCapabilities.h(4, 0, 0, 0) : RendererCapabilities.h(0, 0, 0, 0);
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final String getName() {
        return "CameraMotionRenderer";
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void i(long j2, long j3) {
        float[] fArr;
        while (!k() && this.v < 100000 + j2) {
            DecoderInputBuffer decoderInputBuffer = this.r;
            decoderInputBuffer.h();
            FormatHolder formatHolder = this.f6114c;
            formatHolder.a();
            if (O(formatHolder, decoderInputBuffer, 0) != -4 || decoderInputBuffer.g(4)) {
                return;
            }
            long j4 = decoderInputBuffer.f6073f;
            this.v = j4;
            boolean z = j4 < this.f6123l;
            if (this.u != null && !z) {
                decoderInputBuffer.n();
                ByteBuffer byteBuffer = decoderInputBuffer.f6071d;
                int i2 = Util.f5744a;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    byte[] bArrArray = byteBuffer.array();
                    int iLimit = byteBuffer.limit();
                    ParsableByteArray parsableByteArray = this.s;
                    parsableByteArray.H(iLimit, bArrArray);
                    parsableByteArray.J(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i3 = 0; i3 < 3; i3++) {
                        fArr2[i3] = Float.intBitsToFloat(parsableByteArray.l());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.u.b(this.v - this.t, fArr);
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void o(int i2, Object obj) {
        if (i2 == 8) {
            this.u = (CameraMotionListener) obj;
        }
    }
}
