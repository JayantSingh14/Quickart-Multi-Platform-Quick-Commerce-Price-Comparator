package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.io.InputStream;

@UnstableApi
/* loaded from: classes3.dex */
public final class DataSourceInputStream extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final DataSource f5846a;

    /* renamed from: b, reason: collision with root package name */
    public final DataSpec f5847b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5849d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5850e = false;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f5848c = new byte[1];

    public DataSourceInputStream(DataSource dataSource, DataSpec dataSpec) {
        this.f5846a = dataSource;
        this.f5847b = dataSpec;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f5850e) {
            return;
        }
        this.f5846a.close();
        this.f5850e = true;
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f5848c;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        Assertions.g(!this.f5850e);
        boolean z = this.f5849d;
        DataSource dataSource = this.f5846a;
        if (!z) {
            dataSource.j(this.f5847b);
            this.f5849d = true;
        }
        int i4 = dataSource.read(bArr, i2, i3);
        if (i4 == -1) {
            return -1;
        }
        return i4;
    }
}
