package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public interface ExtractorsFactory {
    default Extractor[] d(Uri uri, Map map) {
        return g();
    }

    Extractor[] g();
}
