package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public interface ChunkSource {
    boolean b(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    void c();

    long d(long j2, SeekParameters seekParameters);

    boolean g(long j2, Chunk chunk, List list);

    void h(Chunk chunk);

    void i(LoadingInfo loadingInfo, long j2, List list, ChunkHolder chunkHolder);

    int j(long j2, List list);

    void release();
}
