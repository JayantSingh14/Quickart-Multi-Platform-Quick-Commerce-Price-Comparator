package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzcge implements zzhb {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26152a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhm f26153b;

    /* renamed from: c, reason: collision with root package name */
    public final String f26154c;

    /* renamed from: d, reason: collision with root package name */
    public final int f26155d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f26156e;

    /* renamed from: f, reason: collision with root package name */
    public InputStream f26157f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f26158g;

    /* renamed from: h, reason: collision with root package name */
    public Uri f26159h;

    /* renamed from: i, reason: collision with root package name */
    public volatile zzbev f26160i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f26161j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f26162k = false;

    /* renamed from: l, reason: collision with root package name */
    public zzhf f26163l;

    public zzcge(Context context, zzhm zzhmVar, String str, int i2) {
        this.f26152a = context;
        this.f26153b = zzhmVar;
        this.f26154c = str;
        this.f26155d = i2;
        new AtomicLong(-1L);
        this.f26156e = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws IOException {
        if (this.f26158g) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.f26158g = true;
        Uri uri = zzhfVar.f33691a;
        this.f26159h = uri;
        this.f26163l = zzhfVar;
        this.f26160i = zzbev.b(uri);
        zzbgb zzbgbVar = zzbgk.Y4;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        zzbes zzbesVarB = null;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            if (this.f26160i != null) {
                this.f26160i.f24864h = zzhfVar.f33693c;
                zzbev zzbevVar = this.f26160i;
                String str = this.f26154c;
                zzbevVar.f24865i = str != null ? str : "";
                this.f26160i.f24866j = this.f26155d;
                zzbesVarB = com.google.android.gms.ads.internal.zzt.C.f21686j.b(this.f26160i);
            }
            if (zzbesVarB != null && zzbesVarB.zza()) {
                this.f26161j = zzbesVarB.s();
                this.f26162k = zzbesVarB.r();
                if (!d()) {
                    this.f26157f = zzbesVarB.b();
                    return -1L;
                }
            }
        } else if (this.f26160i != null) {
            this.f26160i.f24864h = zzhfVar.f33693c;
            zzbev zzbevVar2 = this.f26160i;
            String str2 = this.f26154c;
            zzbevVar2.f24865i = str2 != null ? str2 : "";
            this.f26160i.f24866j = this.f26155d;
            long jLongValue = (this.f26160i.f24863g ? (Long) zzbdVar.f21153c.a(zzbgk.a5) : (Long) zzbdVar.f21153c.a(zzbgk.Z4)).longValue();
            com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
            Future futureA = zzbfg.a(this.f26152a, this.f26160i);
            try {
                try {
                    zzbfh zzbfhVar = (zzbfh) ((zzcdt) futureA).f25992a.get(jLongValue, TimeUnit.MILLISECONDS);
                    zzbfhVar.getClass();
                    this.f26161j = zzbfhVar.f24886c;
                    this.f26162k = zzbfhVar.f24888e;
                    if (!d()) {
                        this.f26157f = zzbfhVar.f24884a;
                    }
                } catch (InterruptedException unused) {
                    ((zzbez) futureA).cancel(false);
                    Thread.currentThread().interrupt();
                } catch (ExecutionException | TimeoutException unused2) {
                    ((zzbez) futureA).cancel(false);
                }
            } catch (Throwable unused3) {
            }
            com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
            throw null;
        }
        if (this.f26160i != null) {
            zzhe zzheVar = new zzhe(zzhfVar);
            zzheVar.f33634a = Uri.parse(this.f26160i.f24857a);
            this.f26163l = zzheVar.a();
        }
        return this.f26153b.a(this.f26163l);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws IOException {
        if (!this.f26158g) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.f26157f;
        return inputStream != null ? inputStream.read(bArr, i2, i3) : this.f26153b.b(i2, bArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void c(zzhz zzhzVar) {
    }

    public final boolean d() {
        if (!this.f26156e) {
            return false;
        }
        zzbgb zzbgbVar = zzbgk.b5;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() || this.f26161j) {
            return ((Boolean) zzbdVar.f21153c.a(zzbgk.c5)).booleanValue() && !this.f26162k;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f26159h;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() throws IOException {
        if (!this.f26158g) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.f26158g = false;
        this.f26159h = null;
        InputStream inputStream = this.f26157f;
        if (inputStream == null) {
            this.f26153b.zzd();
        } else {
            IOUtils.closeQuietly(inputStream);
            this.f26157f = null;
        }
    }
}
