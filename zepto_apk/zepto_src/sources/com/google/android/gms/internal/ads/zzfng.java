package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzfng implements zzfne {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31442a;
    public final int p;

    /* renamed from: b, reason: collision with root package name */
    public long f31443b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f31444c = -1;

    /* renamed from: d, reason: collision with root package name */
    public boolean f31445d = false;
    public int q = 2;
    public int r = 2;

    /* renamed from: e, reason: collision with root package name */
    public int f31446e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f31447f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f31448g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f31449h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f31450i = "";

    /* renamed from: j, reason: collision with root package name */
    public zzfnt f31451j = zzfnt.SCAR_REQUEST_TYPE_UNSPECIFIED;

    /* renamed from: k, reason: collision with root package name */
    public String f31452k = "";

    /* renamed from: l, reason: collision with root package name */
    public String f31453l = "";

    /* renamed from: m, reason: collision with root package name */
    public String f31454m = "";
    public boolean n = false;
    public boolean o = false;

    public zzfng(Context context, int i2) {
        this.f31442a = context;
        this.p = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne a(boolean z) {
        synchronized (this) {
            this.f31445d = z;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne b(String str) {
        synchronized (this) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P9)).booleanValue()) {
                this.f31454m = str;
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne c(Throwable th) {
        synchronized (this) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P9)).booleanValue()) {
                String strD = com.google.android.gms.ads.internal.util.client.zzf.d(zzbxv.f(th), MessageDigestAlgorithms.SHA_256);
                if (strD == null) {
                    strD = "";
                }
                this.f31453l = strD;
                this.f31452k = (String) ((zzgqj) zzgqp.a(new zzgpl('\n')).c(zzbxv.f(th))).iterator().next();
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne d(com.google.android.gms.ads.internal.client.zze zzeVar) {
        synchronized (this) {
            try {
                IBinder iBinder = zzeVar.f21165e;
                if (iBinder != null) {
                    zzdad zzdadVar = (zzdad) iBinder;
                    String str = zzdadVar.f27546d;
                    if (!TextUtils.isEmpty(str)) {
                        this.f31447f = str;
                    }
                    String str2 = zzdadVar.f27544b;
                    if (!TextUtils.isEmpty(str2)) {
                        this.f31448g = str2;
                    }
                }
            } finally {
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne g(zzfnt zzfntVar) {
        synchronized (this) {
            this.f31451j = zzfntVar;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne h(int i2) {
        synchronized (this) {
            this.q = i2;
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        r2.f31448g = r0;
     */
    @Override // com.google.android.gms.internal.ads.zzfne
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzfne i(com.google.android.gms.internal.ads.zzfib r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzfhu r0 = r3.f31190b     // Catch: java.lang.Throwable -> Le
            java.lang.String r0 = r0.f31167b     // Catch: java.lang.Throwable -> Le
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Le
            if (r1 != 0) goto L10
            r2.f31447f = r0     // Catch: java.lang.Throwable -> Le
            goto L10
        Le:
            r3 = move-exception
            goto L2e
        L10:
            java.util.List r3 = r3.f31189a     // Catch: java.lang.Throwable -> Le
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> Le
        L16:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L2c
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> Le
            com.google.android.gms.internal.ads.zzfhr r0 = (com.google.android.gms.internal.ads.zzfhr) r0     // Catch: java.lang.Throwable -> Le
            java.lang.String r0 = r0.b0     // Catch: java.lang.Throwable -> Le
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Le
            if (r1 != 0) goto L16
            r2.f31448g = r0     // Catch: java.lang.Throwable -> Le
        L2c:
            monitor-exit(r2)
            return r2
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Le
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfng.i(com.google.android.gms.internal.ads.zzfib):com.google.android.gms.internal.ads.zzfne");
    }

    public final synchronized void j() {
        Configuration configuration;
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzu zzuVar = zztVar.f21682f;
        Context context = this.f31442a;
        this.f31446e = zzuVar.g(context);
        Resources resources = context.getResources();
        int i2 = 2;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i2 = configuration.orientation == 2 ? 4 : 3;
        }
        this.r = i2;
        this.f31443b = zztVar.f21687k.elapsedRealtime();
        this.o = true;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne q(String str) {
        synchronized (this) {
            this.f31450i = str;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final /* bridge */ /* synthetic */ zzfne zza() {
        j();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final synchronized boolean zzb() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne zzc() {
        synchronized (this) {
            this.f31444c = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final zzfne zzi(String str) {
        synchronized (this) {
            this.f31449h = str;
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final boolean zzl() {
        return !TextUtils.isEmpty(this.f31449h);
    }

    @Override // com.google.android.gms.internal.ads.zzfne
    public final synchronized zzfnh zzm() {
        try {
            if (this.n) {
                return null;
            }
            this.n = true;
            if (!this.o) {
                j();
            }
            if (this.f31444c < 0) {
                synchronized (this) {
                    this.f31444c = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
                }
            }
            return new zzfnh(this);
        } catch (Throwable th) {
            throw th;
        }
    }
}
