package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzchm extends zzgt {

    /* renamed from: e, reason: collision with root package name */
    public final Context f26269e;

    /* renamed from: f, reason: collision with root package name */
    public final zzhb f26270f;

    /* renamed from: g, reason: collision with root package name */
    public final zzchk f26271g;

    /* renamed from: h, reason: collision with root package name */
    public final String f26272h;

    /* renamed from: i, reason: collision with root package name */
    public final int f26273i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f26274j;

    /* renamed from: k, reason: collision with root package name */
    public InputStream f26275k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26276l;

    /* renamed from: m, reason: collision with root package name */
    public Uri f26277m;
    public volatile zzbev n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public long s;
    public ListenableFuture t;
    public final AtomicLong u;

    public zzchm(Context context, zzhb zzhbVar, String str, int i2, zzhz zzhzVar, zzchk zzchkVar) {
        super(false);
        this.f26269e = context;
        this.f26270f = zzhbVar;
        this.f26271g = zzchkVar;
        this.f26272h = str;
        this.f26273i = i2;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = 0L;
        this.u = new AtomicLong(-1L);
        this.t = null;
        this.f26274j = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue();
        c(zzhzVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021a  */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.ads.internal.zzt] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v28, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    @Override // com.google.android.gms.internal.ads.zzhb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(com.google.android.gms.internal.ads.zzhf r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchm.a(com.google.android.gms.internal.ads.zzhf):long");
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws IOException {
        if (!this.f26276l) {
            throw new IOException("Attempt to read closed GcacheDataSource.");
        }
        InputStream inputStream = this.f26275k;
        int iB = inputStream != null ? inputStream.read(bArr, i2, i3) : this.f26270f.b(i2, bArr, i3);
        if (this.f26274j && this.f26275k == null) {
            return iB;
        }
        f(iB);
        return iB;
    }

    public final boolean h() {
        if (!this.f26274j) {
            return false;
        }
        zzbgb zzbgbVar = zzbgk.b5;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() || this.q) {
            return ((Boolean) zzbdVar.f21153c.a(zzbgk.c5)).booleanValue() && !this.r;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f26277m;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() throws IOException {
        if (!this.f26276l) {
            throw new IOException("Attempt to close an already closed GcacheDataSource.");
        }
        this.f26276l = false;
        this.f26277m = null;
        boolean z = (this.f26274j && this.f26275k == null) ? false : true;
        InputStream inputStream = this.f26275k;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.f26275k = null;
        } else {
            this.f26270f.zzd();
        }
        if (z) {
            g();
        }
    }
}
