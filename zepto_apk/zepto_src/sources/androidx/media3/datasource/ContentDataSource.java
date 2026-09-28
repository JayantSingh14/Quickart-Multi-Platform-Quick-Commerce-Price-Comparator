package androidx.media3.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

@UnstableApi
/* loaded from: classes3.dex */
public final class ContentDataSource extends BaseDataSource {

    /* renamed from: e, reason: collision with root package name */
    public final ContentResolver f5831e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f5832f;

    /* renamed from: g, reason: collision with root package name */
    public AssetFileDescriptor f5833g;

    /* renamed from: h, reason: collision with root package name */
    public FileInputStream f5834h;

    /* renamed from: i, reason: collision with root package name */
    public long f5835i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5836j;

    public static class ContentDataSourceException extends DataSourceException {
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f5831e = context.getContentResolver();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.f5832f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f5834h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f5834h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f5833g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new ContentDataSourceException(2000, e2);
                    }
                } finally {
                    this.f5833g = null;
                    if (this.f5836j) {
                        this.f5836j = false;
                        m();
                    }
                }
            } catch (IOException e3) {
                throw new ContentDataSourceException(2000, e3);
            }
        } catch (Throwable th) {
            this.f5834h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f5833g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f5833g = null;
                    if (this.f5836j) {
                        this.f5836j = false;
                        m();
                    }
                    throw th;
                } catch (IOException e4) {
                    throw new ContentDataSourceException(2000, e4);
                }
            } finally {
                this.f5833g = null;
                if (this.f5836j) {
                    this.f5836j = false;
                    m();
                }
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws IOException {
        int i2;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            try {
                Uri uriNormalizeScheme = dataSpec.f5851a.normalizeScheme();
                this.f5832f = uriNormalizeScheme;
                n(dataSpec);
                boolean zEquals = "content".equals(uriNormalizeScheme.getScheme());
                ContentResolver contentResolver = this.f5831e;
                if (zEquals) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
                } else {
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriNormalizeScheme, "r");
                }
                this.f5833g = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    i2 = 2000;
                    try {
                        throw new ContentDataSourceException(2000, new IOException("Could not open file descriptor for: " + uriNormalizeScheme));
                    } catch (IOException e2) {
                        e = e2;
                        if (e instanceof FileNotFoundException) {
                            i2 = 2005;
                        }
                        throw new ContentDataSourceException(i2, e);
                    }
                }
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                this.f5834h = fileInputStream;
                long j2 = dataSpec.f5856f;
                if (length != -1 && j2 > length) {
                    throw new ContentDataSourceException(2008, null);
                }
                long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j2) - startOffset;
                if (jSkip != j2) {
                    throw new ContentDataSourceException(2008, null);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.f5835i = -1L;
                    } else {
                        long jPosition = size - channel.position();
                        this.f5835i = jPosition;
                        if (jPosition < 0) {
                            throw new ContentDataSourceException(2008, null);
                        }
                    }
                } else {
                    long j3 = length - jSkip;
                    this.f5835i = j3;
                    if (j3 < 0) {
                        throw new ContentDataSourceException(2008, null);
                    }
                }
                long j4 = dataSpec.f5857g;
                if (j4 != -1) {
                    long j5 = this.f5835i;
                    this.f5835i = j5 == -1 ? j4 : Math.min(j5, j4);
                }
                this.f5836j = true;
                o(dataSpec);
                return j4 != -1 ? j4 : this.f5835i;
            } catch (ContentDataSourceException e3) {
                throw e3;
            }
        } catch (IOException e4) {
            e = e4;
            i2 = 2000;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f5832f;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f5835i;
        if (j2 != 0) {
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, i3);
                } catch (IOException e2) {
                    throw new ContentDataSourceException(2000, e2);
                }
            }
            FileInputStream fileInputStream = this.f5834h;
            int i4 = Util.f5744a;
            int i5 = fileInputStream.read(bArr, i2, i3);
            if (i5 != -1) {
                long j3 = this.f5835i;
                if (j3 != -1) {
                    this.f5835i = j3 - i5;
                }
                l(i5);
                return i5;
            }
        }
        return -1;
    }
}
