package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfaw implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30780a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f30781b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f30782c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f30783d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f30784e;

    /* renamed from: f, reason: collision with root package name */
    public final zzccs f30785f;

    public zzfaw(zzccs zzccsVar, Context context, ScheduledExecutorService scheduledExecutorService, zzgyw zzgywVar, int i2, boolean z, boolean z2) {
        this.f30785f = zzccsVar;
        this.f30780a = context;
        this.f30781b = scheduledExecutorService;
        this.f30782c = zzgywVar;
        this.f30783d = z;
        this.f30784e = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        zzccs zzccsVar = this.f30785f;
        zzcdt zzcdtVar = new zzcdt();
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        Context context = this.f30780a;
        int iIsGooglePlayServicesAvailable = googleApiAvailabilityLight.isGooglePlayServicesAvailable(context, 12451000);
        if (iIsGooglePlayServicesAvailable == 0 || iIsGooglePlayServicesAvailable == 2) {
            ((zzcdn) zzcdo.f25982a).execute(new zzccr(zzccsVar, context, zzcdtVar));
        }
        zzgye zzgyeVarS = zzgye.s(zzcdtVar);
        zzgpr zzgprVar = new zzgpr() { // from class: com.google.android.gms.internal.ads.zzfav
            /* JADX WARN: Removed duplicated region for block: B:26:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.google.android.gms.internal.ads.zzgpr
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object apply(java.lang.Object r9) {
                /*
                    r8 = this;
                    com.google.android.gms.internal.ads.zzfaw r0 = r8.f30779a
                    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r9 = (com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) r9
                    r0.getClass()
                    com.google.android.gms.internal.ads.zzfzf r1 = new com.google.android.gms.internal.ads.zzfzf
                    r1.<init>()
                    boolean r2 = r0.f30783d
                    if (r2 != 0) goto L23
                    com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.L3
                    com.google.android.gms.ads.internal.client.zzbd r3 = com.google.android.gms.ads.internal.client.zzbd.f21150e
                    com.google.android.gms.internal.ads.zzbgi r3 = r3.f21153c
                    java.lang.Object r2 = r3.a(r2)
                    java.lang.Boolean r2 = (java.lang.Boolean) r2
                    boolean r2 = r2.booleanValue()
                    if (r2 != 0) goto L36
                    goto L7b
                L23:
                    com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.M3
                    com.google.android.gms.ads.internal.client.zzbd r3 = com.google.android.gms.ads.internal.client.zzbd.f21150e
                    com.google.android.gms.internal.ads.zzbgi r3 = r3.f21153c
                    java.lang.Object r2 = r3.a(r2)
                    java.lang.Boolean r2 = (java.lang.Boolean) r2
                    boolean r2 = r2.booleanValue()
                    if (r2 != 0) goto L36
                    goto L7b
                L36:
                    android.content.Context r1 = r0.f30780a     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    com.google.android.gms.internal.ads.zzfzj r2 = com.google.android.gms.internal.ads.zzfzj.f(r1)     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    java.util.Objects.requireNonNull(r9)     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    java.lang.String r3 = r9.f21070a     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    java.util.Objects.requireNonNull(r3)     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    java.lang.String r4 = r1.getPackageName()     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.R3     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    com.google.android.gms.ads.internal.client.zzbd r5 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    com.google.android.gms.internal.ads.zzbgi r5 = r5.f21153c     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    java.lang.Object r1 = r5.a(r1)     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    long r5 = r1.longValue()     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    boolean r7 = r0.f30784e     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    r2.getClass()     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    java.lang.Class<com.google.android.gms.internal.ads.zzfzj> r1 = com.google.android.gms.internal.ads.zzfzj.class
                    monitor-enter(r1)     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                    com.google.android.gms.internal.ads.zzfzf r0 = r2.a(r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L67
                    monitor-exit(r1)     // Catch: java.lang.Throwable -> L67
                    r1 = r0
                    goto L7b
                L67:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch: java.lang.Throwable -> L67
                    throw r0     // Catch: java.lang.IllegalArgumentException -> L6a java.io.IOException -> L6c
                L6a:
                    r0 = move-exception
                    goto L6d
                L6c:
                    r0 = move-exception
                L6d:
                    java.lang.String r1 = "AdIdInfoSignalSource.getPaidV1"
                    com.google.android.gms.ads.internal.zzt r2 = com.google.android.gms.ads.internal.zzt.C
                    com.google.android.gms.internal.ads.zzcda r2 = r2.f21684h
                    r2.d(r1, r0)
                    com.google.android.gms.internal.ads.zzfzf r1 = new com.google.android.gms.internal.ads.zzfzf
                    r1.<init>()
                L7b:
                    com.google.android.gms.internal.ads.zzfax r0 = new com.google.android.gms.internal.ads.zzfax
                    r2 = 0
                    r0.<init>(r9, r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfav.apply(java.lang.Object):java.lang.Object");
            }
        };
        zzgyw zzgywVar = this.f30782c;
        return (zzgye) zzgym.e((zzgye) zzgym.g((zzgye) zzgym.i(zzgyeVarS, zzgprVar, zzgywVar), ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.r1)).longValue(), TimeUnit.MILLISECONDS, this.f30781b), Throwable.class, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzfau
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                zzfaw zzfawVar = this.f30778a;
                zzfawVar.getClass();
                com.google.android.gms.ads.internal.util.client.zzf zzfVar2 = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
                ContentResolver contentResolver = zzfawVar.f30780a.getContentResolver();
                return new zzfax(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzfzf());
            }
        }, zzgywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 40;
    }
}
