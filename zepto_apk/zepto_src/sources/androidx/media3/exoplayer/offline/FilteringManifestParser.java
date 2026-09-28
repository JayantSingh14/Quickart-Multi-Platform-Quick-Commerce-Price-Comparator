package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class FilteringManifestParser<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ParsingLoadable.Parser f7384a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7385b;

    public FilteringManifestParser(ParsingLoadable.Parser parser, List list) {
        this.f7384a = parser;
        this.f7385b = list;
    }

    @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
    public final Object a(Uri uri, DataSourceInputStream dataSourceInputStream) {
        FilterableManifest filterableManifest = (FilterableManifest) this.f7384a.a(uri, dataSourceInputStream);
        List list = this.f7385b;
        return (list == null || list.isEmpty()) ? filterableManifest : (FilterableManifest) filterableManifest.a(list);
    }
}
