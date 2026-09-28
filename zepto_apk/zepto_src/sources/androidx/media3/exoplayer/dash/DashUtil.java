package androidx.media3.exoplayer.dash;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.InitializationChunk;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class DashUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static DataSpec a(Representation representation, String str, RangedUri rangedUri, int i2, Map map) {
        DataSpec.Builder builder = new DataSpec.Builder();
        builder.f5860a = UriUtil.e(str, rangedUri.f6833c);
        builder.f5865f = rangedUri.f6831a;
        builder.f5866g = rangedUri.f6832b;
        String strA = representation.a();
        if (strA == null) {
            strA = UriUtil.e(((BaseUrl) representation.f6836b.get(0)).f6785a, rangedUri.f6833c).toString();
        }
        builder.f5867h = strA;
        builder.f5868i = i2;
        builder.f5864e = map;
        return builder.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(CacheDataSource cacheDataSource, Representation representation, BundledChunkExtractor bundledChunkExtractor, RangedUri rangedUri) {
        new InitializationChunk(cacheDataSource, a(representation, ((BaseUrl) representation.f6836b.get(0)).f6785a, rangedUri, 0, ImmutableMap.j()), representation.f6835a, 0, null, bundledChunkExtractor).a();
    }
}
