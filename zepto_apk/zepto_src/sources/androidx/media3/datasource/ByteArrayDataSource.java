package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class ByteArrayDataSource extends BaseDataSource {

    /* renamed from: e, reason: collision with root package name */
    public Uri f5826e;

    /* renamed from: f, reason: collision with root package name */
    public int f5827f;

    /* renamed from: g, reason: collision with root package name */
    public int f5828g;

    public interface UriResolver {
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.f5826e = null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) {
        n(dataSpec);
        this.f5826e = dataSpec.f5851a;
        throw null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f5826e;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f5828g;
        if (i4 == 0) {
            return -1;
        }
        int iMin = Math.min(i3, i4);
        Assertions.h(null);
        System.arraycopy(null, this.f5827f, bArr, i2, iMin);
        this.f5827f += iMin;
        this.f5828g -= iMin;
        l(iMin);
        return iMin;
    }
}
