package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
/* loaded from: classes3.dex */
public interface Cache {

    public static class CacheException extends IOException {
    }

    public interface Listener {
        void a(CacheSpan cacheSpan);

        void b(SimpleCache simpleCache, CacheSpan cacheSpan, CacheSpan cacheSpan2);

        void c(SimpleCache simpleCache, CacheSpan cacheSpan);
    }
}
