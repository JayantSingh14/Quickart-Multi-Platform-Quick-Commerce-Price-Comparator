package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.Loader;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class Chunk implements Loader.Loadable {

    /* renamed from: a, reason: collision with root package name */
    public final long f7855a = LoadEventInfo.f7578d.getAndIncrement();

    /* renamed from: b, reason: collision with root package name */
    public final DataSpec f7856b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7857c;

    /* renamed from: d, reason: collision with root package name */
    public final Format f7858d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7859e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f7860f;

    /* renamed from: g, reason: collision with root package name */
    public final long f7861g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7862h;

    /* renamed from: i, reason: collision with root package name */
    public final StatsDataSource f7863i;

    public Chunk(DataSource dataSource, DataSpec dataSpec, int i2, Format format, int i3, Object obj, long j2, long j3) {
        this.f7863i = new StatsDataSource(dataSource);
        this.f7856b = dataSpec;
        this.f7857c = i2;
        this.f7858d = format;
        this.f7859e = i3;
        this.f7860f = obj;
        this.f7861g = j2;
        this.f7862h = j3;
    }
}
