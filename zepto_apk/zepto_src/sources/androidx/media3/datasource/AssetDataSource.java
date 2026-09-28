package androidx.media3.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.xbill.DNS.TTL;

@UnstableApi
/* loaded from: classes3.dex */
public final class AssetDataSource extends BaseDataSource {

    /* renamed from: e, reason: collision with root package name */
    public final AssetManager f5817e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f5818f;

    /* renamed from: g, reason: collision with root package name */
    public InputStream f5819g;

    /* renamed from: h, reason: collision with root package name */
    public long f5820h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5821i;

    public static final class AssetDataSourceException extends DataSourceException {
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f5817e = context.getAssets();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.f5818f = null;
        try {
            try {
                InputStream inputStream = this.f5819g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e2) {
                throw new AssetDataSourceException(2000, e2);
            }
        } finally {
            this.f5819g = null;
            if (this.f5821i) {
                this.f5821i = false;
                m();
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws IOException {
        try {
            Uri uri = dataSpec.f5851a;
            long j2 = dataSpec.f5856f;
            this.f5818f = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            n(dataSpec);
            InputStream inputStreamOpen = this.f5817e.open(path, 1);
            this.f5819g = inputStreamOpen;
            if (inputStreamOpen.skip(j2) < j2) {
                throw new AssetDataSourceException(2008, null);
            }
            long j3 = dataSpec.f5857g;
            if (j3 != -1) {
                this.f5820h = j3;
            } else {
                long jAvailable = this.f5819g.available();
                this.f5820h = jAvailable;
                if (jAvailable == TTL.MAX_VALUE) {
                    this.f5820h = -1L;
                }
            }
            this.f5821i = true;
            o(dataSpec);
            return this.f5820h;
        } catch (AssetDataSourceException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new AssetDataSourceException(e3 instanceof FileNotFoundException ? 2005 : 2000, e3);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f5818f;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f5820h;
        if (j2 != 0) {
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, i3);
                } catch (IOException e2) {
                    throw new AssetDataSourceException(2000, e2);
                }
            }
            InputStream inputStream = this.f5819g;
            int i4 = Util.f5744a;
            int i5 = inputStream.read(bArr, i2, i3);
            if (i5 != -1) {
                long j3 = this.f5820h;
                if (j3 != -1) {
                    this.f5820h = j3 - i5;
                }
                l(i5);
                return i5;
            }
        }
        return -1;
    }
}
