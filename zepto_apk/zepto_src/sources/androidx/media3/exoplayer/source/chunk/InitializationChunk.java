package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DefaultExtractorInput;

@UnstableApi
/* loaded from: classes3.dex */
public final class InitializationChunk extends Chunk {

    /* renamed from: j, reason: collision with root package name */
    public final ChunkExtractor f7886j;

    /* renamed from: k, reason: collision with root package name */
    public ChunkExtractor.TrackOutputProvider f7887k;

    /* renamed from: l, reason: collision with root package name */
    public long f7888l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f7889m;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f7886j = chunkExtractor;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() {
        if (this.f7888l == 0) {
            this.f7886j.e(this.f7887k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            DataSpec dataSpecD = this.f7856b.d(this.f7888l);
            StatsDataSource statsDataSource = this.f7863i;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, dataSpecD.f5856f, statsDataSource.j(dataSpecD));
            while (!this.f7889m && this.f7886j.a(defaultExtractorInput)) {
                try {
                } finally {
                    this.f7888l = defaultExtractorInput.f8519d - this.f7856b.f5856f;
                }
            }
        } finally {
            DataSourceUtil.a(this.f7863i);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void b() {
        this.f7889m = true;
    }
}
