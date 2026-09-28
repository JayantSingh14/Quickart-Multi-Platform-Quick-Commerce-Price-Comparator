package androidx.media3.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class RawResourceDataSource extends BaseDataSource {

    /* renamed from: e, reason: collision with root package name */
    public final Context f5922e;

    /* renamed from: f, reason: collision with root package name */
    public DataSpec f5923f;

    /* renamed from: g, reason: collision with root package name */
    public AssetFileDescriptor f5924g;

    /* renamed from: h, reason: collision with root package name */
    public FileInputStream f5925h;

    /* renamed from: i, reason: collision with root package name */
    public long f5926i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5927j;

    public static class RawResourceDataSourceException extends DataSourceException {
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f5922e = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i2) {
        return Uri.parse("rawresource:///" + i2);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.f5923f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f5925h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f5925h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f5924g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new RawResourceDataSourceException(null, e2, 2000);
                    }
                } finally {
                    this.f5924g = null;
                    if (this.f5927j) {
                        this.f5927j = false;
                        m();
                    }
                }
            } catch (IOException e3) {
                throw new RawResourceDataSourceException(null, e3, 2000);
            }
        } catch (Throwable th) {
            this.f5925h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f5924g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f5924g = null;
                    if (this.f5927j) {
                        this.f5927j = false;
                        m();
                    }
                    throw th;
                } catch (IOException e4) {
                    throw new RawResourceDataSourceException(null, e4, 2000);
                }
            } finally {
                this.f5924g = null;
                if (this.f5927j) {
                    this.f5927j = false;
                    m();
                }
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws DataSourceException, Resources.NotFoundException, PackageManager.NameNotFoundException, NumberFormatException {
        Resources resourcesForApplication;
        int identifier;
        int i2;
        Resources resources;
        this.f5923f = dataSpec;
        n(dataSpec);
        Uri uriNormalizeScheme = dataSpec.f5851a.normalizeScheme();
        boolean zEquals = TextUtils.equals("rawresource", uriNormalizeScheme.getScheme());
        Context context = this.f5922e;
        if (zEquals) {
            resources = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new RawResourceDataSourceException("rawresource:// URI must have exactly one path element, found " + pathSegments.size(), null, 2000);
            }
            try {
                i2 = Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new RawResourceDataSourceException("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String path = uriNormalizeScheme.getPath();
            path.getClass();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new RawResourceDataSourceException("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e2, 2005);
                }
            }
            if (path.matches("\\d+")) {
                try {
                    identifier = Integer.parseInt(path);
                } catch (NumberFormatException unused2) {
                    throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
                }
            } else {
                identifier = resourcesForApplication.getIdentifier(android.support.v4.media.b.l(packageName, ":", path), "raw", null);
                if (identifier == 0) {
                    throw new RawResourceDataSourceException("Resource not found.", null, 2005);
                }
            }
            i2 = identifier;
            resources = resourcesForApplication;
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(i2);
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new RawResourceDataSourceException(android.support.v4.media.a.l(uriNormalizeScheme, "Resource is compressed: "), null, 2000);
            }
            this.f5924g = assetFileDescriptorOpenRawResourceFd;
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(this.f5924g.getFileDescriptor());
            this.f5925h = fileInputStream;
            long j2 = dataSpec.f5856f;
            try {
                if (length != -1 && j2 > length) {
                    throw new RawResourceDataSourceException(null, null, 2008);
                }
                long startOffset = this.f5924g.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j2) - startOffset;
                if (jSkip != j2) {
                    throw new RawResourceDataSourceException(null, null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    if (channel.size() == 0) {
                        this.f5926i = -1L;
                    } else {
                        long size = channel.size() - channel.position();
                        this.f5926i = size;
                        if (size < 0) {
                            throw new RawResourceDataSourceException(null, null, 2008);
                        }
                    }
                } else {
                    long j3 = length - jSkip;
                    this.f5926i = j3;
                    if (j3 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
                long j4 = dataSpec.f5857g;
                if (j4 != -1) {
                    long j5 = this.f5926i;
                    this.f5926i = j5 == -1 ? j4 : Math.min(j5, j4);
                }
                this.f5927j = true;
                o(dataSpec);
                return j4 != -1 ? j4 : this.f5926i;
            } catch (RawResourceDataSourceException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new RawResourceDataSourceException(null, e4, 2000);
            }
        } catch (Resources.NotFoundException e5) {
            throw new RawResourceDataSourceException(null, e5, 2005);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        DataSpec dataSpec = this.f5923f;
        if (dataSpec != null) {
            return dataSpec.f5851a;
        }
        return null;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f5926i;
        if (j2 != 0) {
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, i3);
                } catch (IOException e2) {
                    throw new RawResourceDataSourceException(null, e2, 2000);
                }
            }
            FileInputStream fileInputStream = this.f5925h;
            int i4 = Util.f5744a;
            int i5 = fileInputStream.read(bArr, i2, i3);
            if (i5 != -1) {
                long j3 = this.f5926i;
                if (j3 != -1) {
                    this.f5926i = j3 - i5;
                }
                l(i5);
                return i5;
            }
            if (this.f5926i != -1) {
                throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
        }
        return -1;
    }
}
