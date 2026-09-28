package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BaseMediaChunk extends MediaChunk {

    /* renamed from: k, reason: collision with root package name */
    public final long f7828k;

    /* renamed from: l, reason: collision with root package name */
    public final long f7829l;

    /* renamed from: m, reason: collision with root package name */
    public BaseMediaChunkOutput f7830m;
    public int[] n;

    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, long j2, long j3, long j4, long j5, long j6) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j6);
        this.f7828k = j4;
        this.f7829l = j5;
    }

    public final int e(int i2) {
        int[] iArr = this.n;
        Assertions.h(iArr);
        return iArr[i2];
    }
}
