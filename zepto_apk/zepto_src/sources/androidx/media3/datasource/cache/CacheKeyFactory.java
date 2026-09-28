package androidx.media3.datasource.cache;

import androidx.media3.common.b;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;

@UnstableApi
/* loaded from: classes3.dex */
public interface CacheKeyFactory {
    public static final b d0 = new b(9);

    String a(DataSpec dataSpec);
}
