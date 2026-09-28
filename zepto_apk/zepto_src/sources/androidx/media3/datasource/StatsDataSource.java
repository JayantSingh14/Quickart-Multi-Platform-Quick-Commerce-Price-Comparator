package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import java.util.Collections;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class StatsDataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public final DataSource f5929a;

    /* renamed from: b, reason: collision with root package name */
    public long f5930b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f5931c;

    /* renamed from: d, reason: collision with root package name */
    public Map f5932d;

    public StatsDataSource(DataSource dataSource) {
        dataSource.getClass();
        this.f5929a = dataSource;
        this.f5931c = Uri.EMPTY;
        this.f5932d = Collections.EMPTY_MAP;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
        transferListener.getClass();
        this.f5929a.a(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        return this.f5929a.c();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.f5929a.close();
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) {
        this.f5931c = dataSpec.f5851a;
        this.f5932d = Collections.EMPTY_MAP;
        DataSource dataSource = this.f5929a;
        long j2 = dataSource.j(dataSpec);
        Uri uriK = dataSource.k();
        uriK.getClass();
        this.f5931c = uriK;
        this.f5932d = dataSource.c();
        return j2;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f5929a.k();
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        int i4 = this.f5929a.read(bArr, i2, i3);
        if (i4 != -1) {
            this.f5930b += i4;
        }
        return i4;
    }
}
