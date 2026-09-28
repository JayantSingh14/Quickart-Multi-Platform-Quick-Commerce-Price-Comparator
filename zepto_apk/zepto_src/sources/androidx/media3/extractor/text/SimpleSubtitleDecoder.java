package androidx.media3.extractor.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {
    public final String o;

    public SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.o = str;
        int i2 = this.f6085g;
        DecoderInputBuffer[] decoderInputBufferArr = this.f6083e;
        Assertions.g(i2 == decoderInputBufferArr.length);
        for (DecoderInputBuffer decoderInputBuffer : decoderInputBufferArr) {
            decoderInputBuffer.l(1024);
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleDecoder
    public final void c(long j2) {
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderInputBuffer g() {
        return new SubtitleInputBuffer();
    }

    @Override // androidx.media3.decoder.Decoder
    public final String getName() {
        return this.o;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderOutputBuffer h() {
        return new SubtitleOutputBuffer() { // from class: androidx.media3.extractor.text.SimpleSubtitleDecoder.1
            @Override // androidx.media3.decoder.DecoderOutputBuffer
            public final void i() {
                SimpleSubtitleDecoder.this.m(this);
            }
        };
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderException i(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderException j(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z) {
        SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) decoderInputBuffer;
        SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) decoderOutputBuffer;
        try {
            ByteBuffer byteBuffer = subtitleInputBuffer.f6071d;
            byteBuffer.getClass();
            Subtitle subtitleN = n(byteBuffer.array(), byteBuffer.limit(), z);
            long j2 = subtitleInputBuffer.f6073f;
            long j3 = subtitleInputBuffer.f9176i;
            subtitleOutputBuffer.f6076b = j2;
            subtitleOutputBuffer.f9177e = subtitleN;
            if (j3 != Long.MAX_VALUE) {
                j2 = j3;
            }
            subtitleOutputBuffer.f9178f = j2;
            subtitleOutputBuffer.f6078d = false;
            return null;
        } catch (SubtitleDecoderException e2) {
            return e2;
        }
    }

    public abstract Subtitle n(byte[] bArr, int i2, boolean z);
}
