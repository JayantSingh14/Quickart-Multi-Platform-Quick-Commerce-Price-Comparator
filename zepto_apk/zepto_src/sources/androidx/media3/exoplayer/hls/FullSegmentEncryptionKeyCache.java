package androidx.media3.exoplayer.hls;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class FullSegmentEncryptionKeyCache {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f6977a = new AnonymousClass1(5, 1.0f, false);

    /* renamed from: androidx.media3.exoplayer.hls.FullSegmentEncryptionKeyCache$1, reason: invalid class name */
    class AnonymousClass1 extends LinkedHashMap<Uri, byte[]> {
        @Override // java.util.LinkedHashMap
        public final boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
            return size() > 4;
        }
    }
}
