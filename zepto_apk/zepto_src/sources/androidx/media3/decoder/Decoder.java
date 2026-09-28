package androidx.media3.decoder;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;

@UnstableApi
/* loaded from: classes3.dex */
public interface Decoder<I, O, E extends DecoderException> {
    Object a();

    void b(Object obj);

    void d(long j2);

    Object e();

    void flush();

    String getName();

    void release();
}
