package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import java.io.InterruptedIOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class CacheWriter {

    /* renamed from: a, reason: collision with root package name */
    public long f5989a;

    /* renamed from: b, reason: collision with root package name */
    public long f5990b;

    /* renamed from: c, reason: collision with root package name */
    public long f5991c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f5992d;

    public interface ProgressListener {
        void a(long j2, long j3, long j4);
    }

    public final void a() throws InterruptedIOException {
        if (!this.f5992d) {
            throw null;
        }
        throw new InterruptedIOException();
    }
}
