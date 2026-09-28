package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class PlaceholderDataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public static final PlaceholderDataSource f5921a = new PlaceholderDataSource();

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return null;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }
}
