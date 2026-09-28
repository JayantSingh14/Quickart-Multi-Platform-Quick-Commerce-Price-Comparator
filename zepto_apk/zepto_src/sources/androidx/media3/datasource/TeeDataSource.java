package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.CacheDataSink;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class TeeDataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public final DataSource f5933a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheDataSink f5934b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5935c;

    /* renamed from: d, reason: collision with root package name */
    public long f5936d;

    public TeeDataSource(DataSource dataSource, CacheDataSink cacheDataSink) {
        this.f5933a = dataSource;
        cacheDataSink.getClass();
        this.f5934b = cacheDataSink;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
        transferListener.getClass();
        this.f5933a.a(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        return this.f5933a.c();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() throws CacheDataSink.CacheDataSinkException {
        CacheDataSink cacheDataSink = this.f5934b;
        try {
            this.f5933a.close();
        } finally {
            if (this.f5935c) {
                this.f5935c = false;
                cacheDataSink.a();
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws CacheDataSink.CacheDataSinkException {
        long j2 = this.f5933a.j(dataSpec);
        this.f5936d = j2;
        if (j2 == 0) {
            return 0L;
        }
        if (dataSpec.f5857g == -1 && j2 != -1) {
            dataSpec = dataSpec.e(0L, j2);
        }
        this.f5935c = true;
        CacheDataSink cacheDataSink = this.f5934b;
        cacheDataSink.getClass();
        dataSpec.f5858h.getClass();
        if (dataSpec.f5857g == -1 && dataSpec.c(2)) {
            cacheDataSink.f5954d = null;
        } else {
            cacheDataSink.f5954d = dataSpec;
            cacheDataSink.f5955e = dataSpec.c(4) ? cacheDataSink.f5952b : Long.MAX_VALUE;
            cacheDataSink.f5959i = 0L;
            try {
                cacheDataSink.c(dataSpec);
            } catch (IOException e2) {
                throw new CacheDataSink.CacheDataSinkException(e2);
            }
        }
        return this.f5936d;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f5933a.k();
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f5936d == 0) {
            return -1;
        }
        int i4 = this.f5933a.read(bArr, i2, i3);
        if (i4 > 0) {
            CacheDataSink cacheDataSink = this.f5934b;
            DataSpec dataSpec = cacheDataSink.f5954d;
            if (dataSpec != null) {
                int i5 = 0;
                while (i5 < i4) {
                    try {
                        if (cacheDataSink.f5958h == cacheDataSink.f5955e) {
                            cacheDataSink.b();
                            cacheDataSink.c(dataSpec);
                        }
                        int iMin = (int) Math.min(i4 - i5, cacheDataSink.f5955e - cacheDataSink.f5958h);
                        OutputStream outputStream = cacheDataSink.f5957g;
                        int i6 = Util.f5744a;
                        outputStream.write(bArr, i2 + i5, iMin);
                        i5 += iMin;
                        long j2 = iMin;
                        cacheDataSink.f5958h += j2;
                        cacheDataSink.f5959i += j2;
                    } catch (IOException e2) {
                        throw new CacheDataSink.CacheDataSinkException(e2);
                    }
                }
            }
            long j3 = this.f5936d;
            if (j3 != -1) {
                this.f5936d = j3 - i4;
            }
        }
        return i4;
    }
}
