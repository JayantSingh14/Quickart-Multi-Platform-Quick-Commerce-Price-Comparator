package androidx.media3.exoplayer.image;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;

@UnstableApi
/* loaded from: classes3.dex */
public interface ImageDecoder extends Decoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> {

    public interface Factory {

        /* renamed from: a, reason: collision with root package name */
        public static final BitmapFactoryImageDecoder.Factory f7258a = new BitmapFactoryImageDecoder.Factory();
    }

    @Override // androidx.media3.decoder.Decoder
    ImageOutputBuffer a();

    @Override // androidx.media3.decoder.Decoder
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    void b(DecoderInputBuffer decoderInputBuffer);
}
