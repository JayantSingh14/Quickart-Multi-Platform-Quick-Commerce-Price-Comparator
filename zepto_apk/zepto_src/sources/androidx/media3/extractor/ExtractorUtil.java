package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class ExtractorUtil {
    public static void a(String str, boolean z) throws ParserException {
        if (!z) {
            throw ParserException.a(null, str);
        }
    }
}
