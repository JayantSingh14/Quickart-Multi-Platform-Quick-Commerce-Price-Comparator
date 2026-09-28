package androidx.media3.exoplayer.image;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.exoplayer.image.ImageDecoder;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public final class BitmapFactoryImageDecoder extends SimpleDecoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> implements ImageDecoder {
    public final p o;

    @VisibleForTesting
    public interface BitmapDecoder {
    }

    public static final class Factory implements ImageDecoder.Factory {

        /* renamed from: b, reason: collision with root package name */
        public final p f7257b = new p(6);

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
        
            if (r2 >= 26) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
        
            if (r2 >= 34) goto L45;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int a(androidx.media3.common.Format r7) {
            /*
                r6 = this;
                r0 = 4
                r1 = 1
                java.lang.String r2 = r7.f5225m
                r3 = 0
                if (r2 == 0) goto L84
                boolean r2 = androidx.media3.common.MimeTypes.m(r2)
                if (r2 != 0) goto Lf
                goto L84
            Lf:
                int r2 = androidx.media3.common.util.Util.f5744a
                java.lang.String r7 = r7.f5225m
                r7.getClass()
                int r2 = androidx.media3.common.util.Util.f5744a
                r4 = -1
                int r5 = r7.hashCode()
                switch(r5) {
                    case -1487656890: goto L63;
                    case -1487464693: goto L58;
                    case -1487464690: goto L4d;
                    case -1487394660: goto L42;
                    case -1487018032: goto L37;
                    case -879272239: goto L2c;
                    case -879258763: goto L21;
                    default: goto L20;
                }
            L20:
                goto L6d
            L21:
                java.lang.String r5 = "image/png"
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L2a
                goto L6d
            L2a:
                r4 = 6
                goto L6d
            L2c:
                java.lang.String r5 = "image/bmp"
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L35
                goto L6d
            L35:
                r4 = 5
                goto L6d
            L37:
                java.lang.String r5 = "image/webp"
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L40
                goto L6d
            L40:
                r4 = r0
                goto L6d
            L42:
                java.lang.String r5 = "image/jpeg"
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L4b
                goto L6d
            L4b:
                r4 = 3
                goto L6d
            L4d:
                java.lang.String r5 = "image/heif"
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L56
                goto L6d
            L56:
                r4 = 2
                goto L6d
            L58:
                java.lang.String r5 = "image/heic"
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L61
                goto L6d
            L61:
                r4 = r1
                goto L6d
            L63:
                java.lang.String r5 = "image/avif"
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L6c
                goto L6d
            L6c:
                r4 = r3
            L6d:
                switch(r4) {
                    case 0: goto L76;
                    case 1: goto L71;
                    case 2: goto L71;
                    case 3: goto L7a;
                    case 4: goto L7a;
                    case 5: goto L7a;
                    case 6: goto L7a;
                    default: goto L70;
                }
            L70:
                goto L7f
            L71:
                r7 = 26
                if (r2 < r7) goto L7f
                goto L7a
            L76:
                r7 = 34
                if (r2 < r7) goto L7f
            L7a:
                int r7 = androidx.media3.exoplayer.RendererCapabilities.h(r0, r3, r3, r3)
                return r7
            L7f:
                int r7 = androidx.media3.exoplayer.RendererCapabilities.h(r1, r3, r3, r3)
                return r7
            L84:
                int r7 = androidx.media3.exoplayer.RendererCapabilities.h(r3, r3, r3, r3)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.image.BitmapFactoryImageDecoder.Factory.a(androidx.media3.common.Format):int");
        }
    }

    public BitmapFactoryImageDecoder(p pVar) {
        super(new DecoderInputBuffer[1], new ImageOutputBuffer[1]);
        this.o = pVar;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderInputBuffer g() {
        return new DecoderInputBuffer(1);
    }

    @Override // androidx.media3.decoder.Decoder
    public final String getName() {
        return "BitmapFactoryImageDecoder";
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderOutputBuffer h() {
        return new ImageOutputBuffer() { // from class: androidx.media3.exoplayer.image.BitmapFactoryImageDecoder.1
            @Override // androidx.media3.decoder.DecoderOutputBuffer
            public final void i() {
                BitmapFactoryImageDecoder.this.m(this);
            }
        };
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderException i(Throwable th) {
        return new ImageDecoderException("Unexpected decode error", th);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderException j(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z) {
        ImageOutputBuffer imageOutputBuffer = (ImageOutputBuffer) decoderOutputBuffer;
        try {
            ByteBuffer byteBuffer = decoderInputBuffer.f6071d;
            byteBuffer.getClass();
            Assertions.g(byteBuffer.hasArray());
            Assertions.a(byteBuffer.arrayOffset() == 0);
            imageOutputBuffer.f7260e = this.o.i(byteBuffer.remaining(), byteBuffer.array());
            imageOutputBuffer.f6076b = decoderInputBuffer.f6073f;
            return null;
        } catch (ImageDecoderException e2) {
            return e2;
        }
    }
}
