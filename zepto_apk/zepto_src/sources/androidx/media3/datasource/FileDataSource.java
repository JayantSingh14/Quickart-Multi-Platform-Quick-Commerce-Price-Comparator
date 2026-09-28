package androidx.media3.datasource;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.e;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

@UnstableApi
/* loaded from: classes3.dex */
public final class FileDataSource extends BaseDataSource {

    /* renamed from: e, reason: collision with root package name */
    public RandomAccessFile f5895e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f5896f;

    /* renamed from: g, reason: collision with root package name */
    public long f5897g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5898h;

    @RequiresApi
    public static final class Api21 {
        /* JADX INFO: Access modifiers changed from: private */
        @DoNotInline
        public static boolean b(@Nullable Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public static final class Factory implements DataSource.Factory {
        @Override // androidx.media3.datasource.DataSource.Factory
        public final DataSource a() {
            return new FileDataSource();
        }
    }

    public static class FileDataSourceException extends DataSourceException {
    }

    public FileDataSource() {
        super(false);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.f5896f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f5895e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e2) {
                throw new FileDataSourceException(2000, e2);
            }
        } finally {
            this.f5895e = null;
            if (this.f5898h) {
                this.f5898h = false;
                m();
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws IOException {
        Uri uri = dataSpec.f5851a;
        long j2 = dataSpec.f5856f;
        this.f5896f = uri;
        n(dataSpec);
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.f5895e = randomAccessFile;
            try {
                randomAccessFile.seek(j2);
                long length = dataSpec.f5857g;
                if (length == -1) {
                    length = this.f5895e.length() - j2;
                }
                this.f5897g = length;
                if (length < 0) {
                    throw new FileDataSourceException(null, null, 2008);
                }
                this.f5898h = true;
                o(dataSpec);
                return this.f5897g;
            } catch (IOException e2) {
                throw new FileDataSourceException(2000, e2);
            }
        } catch (FileNotFoundException e3) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException((Util.f5744a < 21 || !Api21.b(e3.getCause())) ? 2005 : 2006, e3);
            }
            String path2 = uri.getPath();
            String query = uri.getQuery();
            String fragment = uri.getFragment();
            StringBuilder sbV = e.v("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=", path2, ",query=", query, ",fragment=");
            sbV.append(fragment);
            throw new FileDataSourceException(sbV.toString(), e3, 1004);
        } catch (SecurityException e4) {
            throw new FileDataSourceException(2006, e4);
        } catch (RuntimeException e5) {
            throw new FileDataSourceException(2000, e5);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f5896f;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f5897g;
        if (j2 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f5895e;
            int i4 = Util.f5744a;
            int i5 = randomAccessFile.read(bArr, i2, (int) Math.min(j2, i3));
            if (i5 > 0) {
                this.f5897g -= i5;
                l(i5);
            }
            return i5;
        } catch (IOException e2) {
            throw new FileDataSourceException(2000, e2);
        }
    }
}
