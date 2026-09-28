package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderException;

@UnstableApi
/* loaded from: classes3.dex */
public class MediaCodecDecoderException extends DecoderException {

    /* renamed from: a, reason: collision with root package name */
    public final int f7319a;

    public MediaCodecDecoderException(IllegalStateException illegalStateException, MediaCodecInfo mediaCodecInfo) {
        StringBuilder sb = new StringBuilder("Decoder failed: ");
        String diagnosticInfo = null;
        sb.append(mediaCodecInfo == null ? null : mediaCodecInfo.f7320a);
        super(sb.toString(), illegalStateException);
        int i2 = Util.f5744a;
        if (i2 >= 21 && (illegalStateException instanceof MediaCodec.CodecException)) {
            diagnosticInfo = ((MediaCodec.CodecException) illegalStateException).getDiagnosticInfo();
        }
        this.f7319a = i2 >= 23 ? illegalStateException instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) illegalStateException).getErrorCode() : 0 : Util.x(diagnosticInfo);
    }
}
