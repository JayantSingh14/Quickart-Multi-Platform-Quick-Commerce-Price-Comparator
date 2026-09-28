package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzfho extends zzbzo {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhe f31136a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfgv f31137b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfid f31138c;

    /* renamed from: d, reason: collision with root package name */
    public zzdte f31139d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f31140e = false;

    public zzfho(zzfhe zzfheVar, zzfgv zzfgvVar, zzfid zzfidVar) {
        this.f31136a = zzfheVar;
        this.f31137b = zzfgvVar;
        this.f31138c = zzfidVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(com.google.android.gms.internal.ads.zzbgk.j6)).booleanValue() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void Xb(com.google.android.gms.internal.ads.zzbzt r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L20
            java.lang.String r0 = r5.f25780b     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.h6     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbgi r2 = r2.f21153c     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = r2.a(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L2c
            if (r0 != 0) goto L19
            goto L2c
        L19:
            boolean r0 = java.util.regex.Pattern.matches(r1, r0)     // Catch: java.lang.Throwable -> L20 java.lang.RuntimeException -> L22
            if (r0 == 0) goto L2c
            goto L44
        L20:
            r5 = move-exception
            goto L65
        L22:
            r0 = move-exception
            java.lang.String r1 = "NonagonUtil.isPatternMatched"
            com.google.android.gms.ads.internal.zzt r2 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzcda r2 = r2.f21684h     // Catch: java.lang.Throwable -> L20
            r2.d(r1, r0)     // Catch: java.lang.Throwable -> L20
        L2c:
            boolean r0 = r4.Zb()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L46
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.j6     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c     // Catch: java.lang.Throwable -> L20
            java.lang.Object r0 = r1.a(r0)     // Catch: java.lang.Throwable -> L20
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L20
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L20
            if (r0 != 0) goto L46
        L44:
            monitor-exit(r4)
            return
        L46:
            com.google.android.gms.internal.ads.zzfgx r0 = new com.google.android.gms.internal.ads.zzfgx     // Catch: java.lang.Throwable -> L20
            r0.<init>()     // Catch: java.lang.Throwable -> L20
            r1 = 0
            r4.f31139d = r1     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfhe r1 = r4.f31136a     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfij r2 = r1.f31104h     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfhx r2 = r2.o     // Catch: java.lang.Throwable -> L20
            r3 = 1
            r2.f31183a = r3     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.ads.internal.client.zzm r2 = r5.f25779a     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = r5.f25780b     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfhm r3 = new com.google.android.gms.internal.ads.zzfhm     // Catch: java.lang.Throwable -> L20
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L20
            r1.a(r2, r5, r0, r3)     // Catch: java.lang.Throwable -> L20
            monitor-exit(r4)
            return
        L65:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L20
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfho.Xb(com.google.android.gms.internal.ads.zzbzt):void");
    }

    public final synchronized void Yb(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.f31137b.f31077b.set(null);
        if (this.f31139d != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.z0(iObjectWrapper);
            }
            zzdbj zzdbjVar = this.f31139d.f27229c;
            zzdbjVar.getClass();
            zzdbjVar.v0(new zzdbh(context));
        }
    }

    public final synchronized boolean Zb() {
        zzdte zzdteVar = this.f31139d;
        if (zzdteVar != null) {
            if (!zzdteVar.r.f27277b.get()) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void ua(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.f31139d != null) {
            Context context = iObjectWrapper == null ? null : (Context) ObjectWrapper.z0(iObjectWrapper);
            zzdbj zzdbjVar = this.f31139d.f27229c;
            zzdbjVar.getClass();
            zzdbjVar.v0(new zzdbg(context));
        }
    }

    public final synchronized void zzc() {
        zzp(null);
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.f31139d != null) {
            Context context = iObjectWrapper == null ? null : (Context) ObjectWrapper.z0(iObjectWrapper);
            zzdbj zzdbjVar = this.f31139d.f27229c;
            zzdbjVar.getClass();
            zzdbjVar.v0(new zzdbi(context));
        }
    }

    public final synchronized String zzl() {
        zzdad zzdadVar;
        zzdte zzdteVar = this.f31139d;
        if (zzdteVar == null || (zzdadVar = zzdteVar.f27232f) == null) {
            return null;
        }
        return zzdadVar.f27543a;
    }

    public final synchronized void zzp(IObjectWrapper iObjectWrapper) {
        try {
            Preconditions.checkMainThread("showAd must be called on the main UI thread.");
            if (this.f31139d != null) {
                Activity activity = null;
                if (iObjectWrapper != null) {
                    Object objZ0 = ObjectWrapper.z0(iObjectWrapper);
                    if (objZ0 instanceof Activity) {
                        activity = (Activity) objZ0;
                    }
                }
                this.f31139d.c(activity, this.f31140e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
