package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public final class zzho extends zzgt {

    /* renamed from: e, reason: collision with root package name */
    public RandomAccessFile f34043e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f34044f;

    /* renamed from: g, reason: collision with root package name */
    public long f34045g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f34046h;

    public zzho() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws IOException {
        Uri uri = zzhfVar.f33691a;
        this.f34044f = uri;
        d(zzhfVar);
        try {
            String path = uri.getPath();
            if (path == null) {
                throw null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.f34043e = randomAccessFile;
            try {
                long j2 = zzhfVar.f33693c;
                randomAccessFile.seek(j2);
                long length = zzhfVar.f33694d;
                if (length == -1) {
                    length = this.f34043e.length() - j2;
                }
                this.f34045g = length;
                if (length < 0) {
                    throw new zzhn(null, null, 2008);
                }
                this.f34046h = true;
                e(zzhfVar);
                return this.f34045g;
            } catch (IOException e2) {
                throw new zzhn(2000, e2);
            }
        } catch (FileNotFoundException e3) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new zzhn(((e3.getCause() instanceof ErrnoException) && ((ErrnoException) e3.getCause()).errno == OsConstants.EACCES) ? 2006 : 2005, e3);
            }
            String path2 = uri.getPath();
            String query = uri.getQuery();
            String fragment = uri.getFragment();
            StringBuilder sbV = androidx.fragment.app.e.v("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=", path2, ",query=", query, ",fragment=");
            sbV.append(fragment);
            throw new zzhn(sbV.toString(), e3, 1004);
        } catch (SecurityException e4) {
            throw new zzhn(2006, e4);
        } catch (RuntimeException e5) {
            throw new zzhn(2000, e5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f34045g;
        if (j2 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f34043e;
            String str = zzfj.f31254a;
            int i4 = randomAccessFile.read(bArr, i2, (int) Math.min(j2, i3));
            if (i4 > 0) {
                this.f34045g -= i4;
                f(i4);
            }
            return i4;
        } catch (IOException e2) {
            throw new zzhn(2000, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f34044f;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        this.f34044f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f34043e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.f34043e = null;
                if (this.f34046h) {
                    this.f34046h = false;
                    g();
                }
            } catch (IOException e2) {
                throw new zzhn(2000, e2);
            }
        } catch (Throwable th) {
            this.f34043e = null;
            if (this.f34046h) {
                this.f34046h = false;
                g();
            }
            throw th;
        }
    }
}
