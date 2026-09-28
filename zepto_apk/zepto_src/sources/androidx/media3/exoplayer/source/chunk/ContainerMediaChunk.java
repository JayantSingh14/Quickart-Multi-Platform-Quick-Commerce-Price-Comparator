package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
/* loaded from: classes3.dex */
public class ContainerMediaChunk extends BaseMediaChunk {
    public final int o;
    public final long p;
    public final ChunkExtractor q;
    public long r;
    public volatile boolean s;
    public boolean t;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, long j5, long j6, int i3, long j7, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4, j5, j6);
        this.o = i3;
        this.p = j7;
        this.q = chunkExtractor;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() {
        BaseMediaChunkOutput baseMediaChunkOutput = this.f7830m;
        Assertions.h(baseMediaChunkOutput);
        if (this.r == 0) {
            long j2 = this.p;
            for (SampleQueue sampleQueue : baseMediaChunkOutput.f7835b) {
                if (sampleQueue.F != j2) {
                    sampleQueue.F = j2;
                    sampleQueue.z = true;
                }
            }
            ChunkExtractor chunkExtractor = this.q;
            long j3 = this.f7828k;
            long j4 = j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.p;
            long j5 = this.f7829l;
            chunkExtractor.e(baseMediaChunkOutput, j4, j5 != -9223372036854775807L ? j5 - this.p : -9223372036854775807L);
        }
        try {
            DataSpec dataSpecD = this.f7856b.d(this.r);
            StatsDataSource statsDataSource = this.f7863i;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, dataSpecD.f5856f, statsDataSource.j(dataSpecD));
            while (!this.s && this.q.a(defaultExtractorInput)) {
                try {
                } finally {
                    this.r = defaultExtractorInput.f8519d - this.f7856b.f5856f;
                }
            }
            Format format = this.f7858d;
            if (MimeTypes.m(format.f5224l)) {
                int i2 = format.H;
                int i3 = format.I;
                if ((i2 > 1 || i3 > 1) && i2 != -1 && i3 != -1) {
                    TrackOutput trackOutputA = baseMediaChunkOutput.a(4);
                    int i4 = i2 * i3;
                    long j6 = (this.f7862h - this.f7861g) / i4;
                    for (int i5 = 1; i5 < i4; i5++) {
                        trackOutputA.e(0, new ParsableByteArray());
                        trackOutputA.f(i5 * j6, 0, 0, 0, null);
                    }
                }
            }
            DataSourceUtil.a(this.f7863i);
            this.t = !this.s;
        } catch (Throwable th) {
            DataSourceUtil.a(this.f7863i);
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void b() {
        this.s = true;
    }

    @Override // androidx.media3.exoplayer.source.chunk.MediaChunk
    public final long c() {
        return this.f7890j + this.o;
    }

    @Override // androidx.media3.exoplayer.source.chunk.MediaChunk
    public final boolean d() {
        return this.t;
    }
}
