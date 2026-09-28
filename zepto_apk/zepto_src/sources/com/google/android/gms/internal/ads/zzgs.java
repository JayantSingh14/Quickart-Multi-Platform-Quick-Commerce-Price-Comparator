package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class zzgs extends zzgt {

    /* renamed from: e, reason: collision with root package name */
    public final AssetManager f33135e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f33136f;

    /* renamed from: g, reason: collision with root package name */
    public InputStream f33137g;

    /* renamed from: h, reason: collision with root package name */
    public long f33138h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f33139i;

    public zzgs(Context context) {
        super(false);
        this.f33135e = context.getAssets();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws IOException {
        try {
            Uri uri = zzhfVar.f33691a;
            this.f33136f = uri;
            String path = uri.getPath();
            if (path == null) {
                throw null;
            }
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            d(zzhfVar);
            InputStream inputStreamOpen = this.f33135e.open(path, 1);
            this.f33137g = inputStreamOpen;
            long j2 = zzhfVar.f33693c;
            if (inputStreamOpen.skip(j2) < j2) {
                throw new zzgr(2008, null);
            }
            long j3 = zzhfVar.f33694d;
            if (j3 != -1) {
                this.f33138h = j3;
            } else {
                long jAvailable = this.f33137g.available();
                this.f33138h = jAvailable;
                if (jAvailable == TTL.MAX_VALUE) {
                    this.f33138h = -1L;
                }
            }
            this.f33139i = true;
            e(zzhfVar);
            return this.f33138h;
        } catch (zzgr e2) {
            throw e2;
        } catch (IOException e3) {
            throw new zzgr(true != (e3 instanceof FileNotFoundException) ? 2000 : 2005, e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f33138h;
        if (j2 != 0) {
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, i3);
                } catch (IOException e2) {
                    throw new zzgr(2000, e2);
                }
            }
            InputStream inputStream = this.f33137g;
            String str = zzfj.f31254a;
            int i4 = inputStream.read(bArr, i2, i3);
            if (i4 != -1) {
                long j3 = this.f33138h;
                if (j3 != -1) {
                    this.f33138h = j3 - i4;
                }
                f(i4);
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f33136f;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        this.f33136f = null;
        try {
            try {
                InputStream inputStream = this.f33137g;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f33137g = null;
                if (this.f33139i) {
                    this.f33139i = false;
                    g();
                }
            } catch (IOException e2) {
                throw new zzgr(2000, e2);
            }
        } catch (Throwable th) {
            this.f33137g = null;
            if (this.f33139i) {
                this.f33139i = false;
                g();
            }
            throw th;
        }
    }
}
