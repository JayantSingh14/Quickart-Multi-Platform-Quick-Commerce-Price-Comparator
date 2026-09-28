package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;
import com.google.android.gms.common.api.Api;

@UnstableApi
/* loaded from: classes3.dex */
public final class SingleSampleMediaChunk extends BaseMediaChunk {
    public final int o;
    public final Format p;
    public long q;
    public boolean r;

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, int i3, Format format2) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, -9223372036854775807L, -9223372036854775807L, j4);
        this.o = i3;
        this.p = format2;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() {
        StatsDataSource statsDataSource = this.f7863i;
        BaseMediaChunkOutput baseMediaChunkOutput = this.f7830m;
        Assertions.h(baseMediaChunkOutput);
        for (SampleQueue sampleQueue : baseMediaChunkOutput.f7835b) {
            if (sampleQueue.F != 0) {
                sampleQueue.F = 0L;
                sampleQueue.z = true;
            }
        }
        TrackOutput trackOutputA = baseMediaChunkOutput.a(this.o);
        trackOutputA.b(this.p);
        try {
            long j2 = statsDataSource.j(this.f7856b.d(this.q));
            if (j2 != -1) {
                j2 += this.q;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.f7863i, this.q, j2);
            for (int iC = 0; iC != -1; iC = trackOutputA.c(defaultExtractorInput, Api.BaseClientBuilder.API_PRIORITY_OTHER, true)) {
                this.q += iC;
            }
            trackOutputA.f(this.f7861g, 1, (int) this.q, 0, null);
            DataSourceUtil.a(statsDataSource);
            this.r = true;
        } catch (Throwable th) {
            DataSourceUtil.a(statsDataSource);
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void b() {
    }

    @Override // androidx.media3.exoplayer.source.chunk.MediaChunk
    public final boolean d() {
        return this.r;
    }
}
