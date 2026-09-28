package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhh implements zzhb {

    /* renamed from: a, reason: collision with root package name */
    public final Context f33782a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f33783b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final zzhm f33784c;

    /* renamed from: d, reason: collision with root package name */
    public zzho f33785d;

    /* renamed from: e, reason: collision with root package name */
    public zzgs f33786e;

    /* renamed from: f, reason: collision with root package name */
    public zzgy f33787f;

    /* renamed from: g, reason: collision with root package name */
    public zzhb f33788g;

    /* renamed from: h, reason: collision with root package name */
    public zzib f33789h;

    /* renamed from: i, reason: collision with root package name */
    public zzgz f33790i;

    /* renamed from: j, reason: collision with root package name */
    public zzhx f33791j;

    /* renamed from: k, reason: collision with root package name */
    public zzhb f33792k;

    public zzhh(Context context, zzhm zzhmVar) {
        this.f33782a = context.getApplicationContext();
        this.f33784c = zzhmVar;
    }

    public static final void e(zzhb zzhbVar, zzhz zzhzVar) {
        if (zzhbVar != null) {
            zzhbVar.c(zzhzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) {
        zzgqa.f(this.f33792k == null);
        Uri uri = zzhfVar.f33691a;
        String scheme = uri.getScheme();
        String str = zzfj.f31254a;
        String scheme2 = uri.getScheme();
        boolean zIsEmpty = TextUtils.isEmpty(scheme2);
        Context context = this.f33782a;
        if (zIsEmpty || Objects.equals(scheme2, UtilsKt.SCHEME_FILE)) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f33785d == null) {
                    zzho zzhoVar = new zzho();
                    this.f33785d = zzhoVar;
                    d(zzhoVar);
                }
                this.f33792k = this.f33785d;
            } else {
                if (this.f33786e == null) {
                    zzgs zzgsVar = new zzgs(context);
                    this.f33786e = zzgsVar;
                    d(zzgsVar);
                }
                this.f33792k = this.f33786e;
            }
        } else if ("asset".equals(scheme)) {
            if (this.f33786e == null) {
                zzgs zzgsVar2 = new zzgs(context);
                this.f33786e = zzgsVar2;
                d(zzgsVar2);
            }
            this.f33792k = this.f33786e;
        } else if ("content".equals(scheme)) {
            if (this.f33787f == null) {
                zzgy zzgyVar = new zzgy(context);
                this.f33787f = zzgyVar;
                d(zzgyVar);
            }
            this.f33792k = this.f33787f;
        } else {
            boolean zEquals = "rtmp".equals(scheme);
            zzhm zzhmVar = this.f33784c;
            if (zEquals) {
                if (this.f33788g == null) {
                    try {
                        zzhb zzhbVar = (zzhb) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                        this.f33788g = zzhbVar;
                        d(zzhbVar);
                    } catch (ClassNotFoundException unused) {
                        zzee.c("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (Exception e2) {
                        throw new RuntimeException("Error instantiating RTMP extension", e2);
                    }
                    if (this.f33788g == null) {
                        this.f33788g = zzhmVar;
                    }
                }
                this.f33792k = this.f33788g;
            } else if ("udp".equals(scheme)) {
                if (this.f33789h == null) {
                    zzib zzibVar = new zzib(0);
                    this.f33789h = zzibVar;
                    d(zzibVar);
                }
                this.f33792k = this.f33789h;
            } else if ("data".equals(scheme)) {
                if (this.f33790i == null) {
                    zzgz zzgzVar = new zzgz();
                    this.f33790i = zzgzVar;
                    d(zzgzVar);
                }
                this.f33792k = this.f33790i;
            } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.f33791j == null) {
                    zzhx zzhxVar = new zzhx(context);
                    this.f33791j = zzhxVar;
                    d(zzhxVar);
                }
                this.f33792k = this.f33791j;
            } else {
                this.f33792k = zzhmVar;
            }
        }
        return this.f33792k.a(zzhfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) {
        zzhb zzhbVar = this.f33792k;
        zzhbVar.getClass();
        return zzhbVar.b(i2, bArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void c(zzhz zzhzVar) {
        zzhzVar.getClass();
        this.f33784c.c(zzhzVar);
        this.f33783b.add(zzhzVar);
        e(this.f33785d, zzhzVar);
        e(this.f33786e, zzhzVar);
        e(this.f33787f, zzhzVar);
        e(this.f33788g, zzhzVar);
        e(this.f33789h, zzhzVar);
        e(this.f33790i, zzhzVar);
        e(this.f33791j, zzhzVar);
    }

    public final void d(zzhb zzhbVar) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f33783b;
            if (i2 >= arrayList.size()) {
                return;
            }
            zzhbVar.c((zzhz) arrayList.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        zzhb zzhbVar = this.f33792k;
        if (zzhbVar == null) {
            return null;
        }
        return zzhbVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        zzhb zzhbVar = this.f33792k;
        if (zzhbVar != null) {
            try {
                zzhbVar.zzd();
            } finally {
                this.f33792k = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhu
    public final Map zzj() {
        zzhb zzhbVar = this.f33792k;
        return zzhbVar == null ? Collections.EMPTY_MAP : zzhbVar.zzj();
    }
}
