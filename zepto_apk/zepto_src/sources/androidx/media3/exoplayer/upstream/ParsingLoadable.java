package androidx.media3.exoplayer.upstream;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class ParsingLoadable<T> implements Loader.Loadable {

    /* renamed from: a, reason: collision with root package name */
    public final long f8183a;

    /* renamed from: b, reason: collision with root package name */
    public final DataSpec f8184b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8185c;

    /* renamed from: d, reason: collision with root package name */
    public final StatsDataSource f8186d;

    /* renamed from: e, reason: collision with root package name */
    public final Parser f8187e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f8188f;

    public interface Parser<T> {
        Object a(Uri uri, DataSourceInputStream dataSourceInputStream);
    }

    public ParsingLoadable(DataSource dataSource, Uri uri, int i2, Parser parser) {
        DataSpec.Builder builder = new DataSpec.Builder();
        builder.f5860a = uri;
        builder.f5868i = 1;
        DataSpec dataSpecA = builder.a();
        this.f8186d = new StatsDataSource(dataSource);
        this.f8184b = dataSpecA;
        this.f8185c = i2;
        this.f8187e = parser;
        this.f8183a = LoadEventInfo.f7578d.getAndIncrement();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() throws IOException {
        this.f8186d.f5930b = 0L;
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f8186d, this.f8184b);
        try {
            dataSourceInputStream.f5846a.j(dataSourceInputStream.f5847b);
            dataSourceInputStream.f5849d = true;
            Uri uriK = this.f8186d.f5929a.k();
            uriK.getClass();
            this.f8188f = this.f8187e.a(uriK, dataSourceInputStream);
        } finally {
            Util.h(dataSourceInputStream);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void b() {
    }
}
