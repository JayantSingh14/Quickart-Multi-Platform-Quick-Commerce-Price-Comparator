package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class MediaChunk extends Chunk {

    /* renamed from: j, reason: collision with root package name */
    public final long f7890j;

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4) {
        super(dataSource, dataSpec, 1, format, i2, obj, j2, j3);
        format.getClass();
        this.f7890j = j4;
    }

    public long c() {
        long j2 = this.f7890j;
        if (j2 != -1) {
            return j2 + 1;
        }
        return -1L;
    }

    public abstract boolean d();
}
