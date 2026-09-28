package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class ResolvingDataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5928a;

    public static final class Factory implements DataSource.Factory {
        @Override // androidx.media3.datasource.DataSource.Factory
        public final DataSource a() {
            throw null;
        }
    }

    public interface Resolver {
    }

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
        transferListener.getClass();
        throw null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        throw null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        if (this.f5928a) {
            this.f5928a = false;
            throw null;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) {
        throw null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        throw null;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        throw null;
    }
}
