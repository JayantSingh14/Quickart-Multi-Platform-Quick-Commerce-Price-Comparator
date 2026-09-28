package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzhx extends zzgt {

    /* renamed from: e, reason: collision with root package name */
    public final Context f34453e;

    /* renamed from: f, reason: collision with root package name */
    public zzhf f34454f;

    /* renamed from: g, reason: collision with root package name */
    public AssetFileDescriptor f34455g;

    /* renamed from: h, reason: collision with root package name */
    public FileInputStream f34456h;

    /* renamed from: i, reason: collision with root package name */
    public long f34457i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f34458j;

    public zzhx(Context context) {
        super(false);
        this.f34453e = context.getApplicationContext();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws zzhc, Resources.NotFoundException, PackageManager.NameNotFoundException, NumberFormatException {
        Resources resourcesForApplication;
        int identifier;
        Resources resources;
        long size;
        this.f34454f = zzhfVar;
        d(zzhfVar);
        Uri uriNormalizeScheme = zzhfVar.f33691a.normalizeScheme();
        boolean zEquals = TextUtils.equals("rawresource", uriNormalizeScheme.getScheme());
        Context context = this.f34453e;
        if (zEquals) {
            resources = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                int size2 = pathSegments.size();
                throw new zzhw(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(size2).length() + 61), size2, "rawresource:// URI must have exactly one path element, found "), null, 2000);
            }
            try {
                identifier = Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new zzhw("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                String scheme = uriNormalizeScheme.getScheme();
                throw new zzhw(android.support.v4.media.b.s(new StringBuilder(String.valueOf(scheme).length() + 62), "Unsupported URI scheme (", scheme, "). Only android.resource is supported."), null, 1004);
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
                    throw new zzhw("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e2, 2005);
                }
            }
            if (path.matches("\\d+")) {
                try {
                    identifier = Integer.parseInt(path);
                } catch (NumberFormatException unused2) {
                    throw new zzhw("Resource identifier must be an integer.", null, 1004);
                }
            } else {
                identifier = resourcesForApplication.getIdentifier(android.support.v4.media.b.s(new StringBuilder(packageName.length() + 1 + path.length()), packageName, ":", path), "raw", null);
                if (identifier == 0) {
                    throw new zzhw("Resource not found.", null, 2005);
                }
            }
            resources = resourcesForApplication;
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(identifier);
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new zzhw("Resource is compressed: ".concat(String.valueOf(uriNormalizeScheme)), null, 2000);
            }
            this.f34455g = assetFileDescriptorOpenRawResourceFd;
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(this.f34455g.getFileDescriptor());
            this.f34456h = fileInputStream;
            long j2 = zzhfVar.f33693c;
            try {
                if (length != -1 && j2 > length) {
                    throw new zzhw(null, null, 2008);
                }
                long startOffset = this.f34455g.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j2) - startOffset;
                if (jSkip != j2) {
                    throw new zzhw(null, null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    if (channel.size() == 0) {
                        this.f34457i = -1L;
                        size = -1;
                    } else {
                        size = channel.size() - channel.position();
                        this.f34457i = size;
                        if (size < 0) {
                            throw new zzhw(null, null, 2008);
                        }
                    }
                } else {
                    size = length - jSkip;
                    this.f34457i = size;
                    if (size < 0) {
                        throw new zzhc();
                    }
                }
                long j3 = zzhfVar.f33694d;
                if (j3 != -1) {
                    this.f34457i = size == -1 ? j3 : Math.min(size, j3);
                }
                this.f34458j = true;
                e(zzhfVar);
                return j3 != -1 ? j3 : this.f34457i;
            } catch (zzhw e3) {
                throw e3;
            } catch (IOException e4) {
                throw new zzhw(null, e4, 2000);
            }
        } catch (Resources.NotFoundException e5) {
            throw new zzhw(null, e5, 2005);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f34457i;
        if (j2 != 0) {
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, i3);
                } catch (IOException e2) {
                    throw new zzhw(null, e2, 2000);
                }
            }
            FileInputStream fileInputStream = this.f34456h;
            String str = zzfj.f31254a;
            int i4 = fileInputStream.read(bArr, i2, i3);
            if (i4 != -1) {
                long j3 = this.f34457i;
                if (j3 != -1) {
                    this.f34457i = j3 - i4;
                }
                f(i4);
                return i4;
            }
            if (this.f34457i != -1) {
                throw new zzhw("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        zzhf zzhfVar = this.f34454f;
        if (zzhfVar != null) {
            return zzhfVar.f33691a;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        this.f34454f = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream = this.f34456h;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    this.f34456h = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f34455g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        this.f34455g = null;
                        if (this.f34458j) {
                            this.f34458j = false;
                            g();
                        }
                    } catch (IOException e2) {
                        throw new zzhw(null, e2, 2000);
                    }
                } catch (Throwable th) {
                    this.f34456h = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.f34455g;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.f34455g = null;
                        if (this.f34458j) {
                            this.f34458j = false;
                            g();
                        }
                        throw th;
                    } catch (IOException e3) {
                        throw new zzhw(null, e3, 2000);
                    }
                }
            } catch (Throwable th2) {
                this.f34455g = null;
                if (this.f34458j) {
                    this.f34458j = false;
                    g();
                }
                throw th2;
            }
        } catch (IOException e4) {
            throw new zzhw(null, e4, 2000);
        }
    }
}
