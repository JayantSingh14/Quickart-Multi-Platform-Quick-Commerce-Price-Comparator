package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@MainThread
@VisibleForTesting
/* loaded from: classes.dex */
final class zzkx implements Application.ActivityLifecycleCallbacks, zzkv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzli f39295a;

    public zzkx(zzli zzliVar) {
        this.f39295a = zzliVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0044 A[Catch: all -> 0x0023, RuntimeException -> 0x0026, TryCatch #0 {RuntimeException -> 0x0026, blocks: (B:3:0x0002, B:5:0x0014, B:7:0x001a, B:22:0x0044, B:25:0x004b, B:27:0x005e, B:29:0x0066, B:35:0x0076, B:40:0x0083, B:15:0x0029, B:17:0x0030, B:19:0x003c), top: B:49:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.gms.internal.measurement.zzdf r9, android.os.Bundle r10) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzli r1 = r8.f39295a
            com.google.android.gms.measurement.internal.zzib r0 = r1.f39180a     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            com.google.android.gms.measurement.internal.zzgt r2 = r0.f39089f     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            com.google.android.gms.measurement.internal.zzib.l(r2)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            com.google.android.gms.measurement.internal.zzgr r2 = r2.n     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            java.lang.String r3 = "onActivityCreated"
            r2.a(r3)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            android.content.Intent r2 = r9.f36838c     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r2 == 0) goto L92
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r3 == 0) goto L29
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r4 != 0) goto L21
            goto L29
        L21:
            r5 = r3
            goto L42
        L23:
            r0 = move-exception
            goto Lb6
        L26:
            r0 = move-exception
            goto L9d
        L29:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            r4 = 0
            if (r3 == 0) goto L41
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r5 != 0) goto L41
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            goto L21
        L41:
            r5 = r4
        L42:
            if (r5 == 0) goto L92
            boolean r3 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r3 != 0) goto L4b
            goto L92
        L4b:
            com.google.android.gms.measurement.internal.zzpo r3 = r0.f39092i     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            com.google.android.gms.measurement.internal.zzib.j(r3)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            java.lang.String r3 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            java.lang.String r3 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r3 != 0) goto L73
            java.lang.String r3 = "https://www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r3 != 0) goto L73
            java.lang.String r3 = "android-app://com.google.appcrawler"
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r2 == 0) goto L6f
            goto L73
        L6f:
            java.lang.String r2 = "auto"
        L71:
            r6 = r2
            goto L76
        L73:
            java.lang.String r2 = "gs"
            goto L71
        L76:
            java.lang.String r2 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r2)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            if (r10 != 0) goto L81
            r2 = 1
        L7f:
            r4 = r2
            goto L83
        L81:
            r2 = 0
            goto L7f
        L83:
            com.google.android.gms.measurement.internal.zzhy r0 = r0.f39090g     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            com.google.android.gms.measurement.internal.zzib.l(r0)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            com.google.android.gms.measurement.internal.zzkw r2 = new com.google.android.gms.measurement.internal.zzkw     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            r0.p(r2)     // Catch: java.lang.Throwable -> L23 java.lang.RuntimeException -> L26
            goto Lab
        L92:
            com.google.android.gms.measurement.internal.zzib r0 = r1.f39180a
            com.google.android.gms.measurement.internal.zzma r0 = r0.f39095l
            com.google.android.gms.measurement.internal.zzib.k(r0)
            r0.o(r9, r10)
            return
        L9d:
            com.google.android.gms.measurement.internal.zzib r2 = r1.f39180a     // Catch: java.lang.Throwable -> L23
            com.google.android.gms.measurement.internal.zzgt r2 = r2.f39089f     // Catch: java.lang.Throwable -> L23
            com.google.android.gms.measurement.internal.zzib.l(r2)     // Catch: java.lang.Throwable -> L23
            com.google.android.gms.measurement.internal.zzgr r2 = r2.f38958f     // Catch: java.lang.Throwable -> L23
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r2.b(r0, r3)     // Catch: java.lang.Throwable -> L23
        Lab:
            com.google.android.gms.measurement.internal.zzib r0 = r1.f39180a
            com.google.android.gms.measurement.internal.zzma r0 = r0.f39095l
            com.google.android.gms.measurement.internal.zzib.k(r0)
            r0.o(r9, r10)
            return
        Lb6:
            com.google.android.gms.measurement.internal.zzib r1 = r1.f39180a
            com.google.android.gms.measurement.internal.zzma r1 = r1.f39095l
            com.google.android.gms.measurement.internal.zzib.k(r1)
            r1.o(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkx.a(com.google.android.gms.internal.measurement.zzdf, android.os.Bundle):void");
    }

    public final void b(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        zzma zzmaVar = this.f39295a.f39180a.f39095l;
        zzib.k(zzmaVar);
        synchronized (zzmaVar.f39388l) {
            try {
                if (Objects.equals(zzmaVar.f39383g, zzdfVar)) {
                    zzmaVar.f39383g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzmaVar.f39180a.f39087d.u()) {
            zzmaVar.f39382f.remove(Integer.valueOf(zzdfVar.f36836a));
        }
    }

    public final void c(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        zzib zzibVar = this.f39295a.f39180a;
        zzma zzmaVar = zzibVar.f39095l;
        zzib.k(zzmaVar);
        synchronized (zzmaVar.f39388l) {
            zzmaVar.f39387k = false;
            zzmaVar.f39384h = true;
        }
        zzib zzibVar2 = zzmaVar.f39180a;
        long jElapsedRealtime = zzibVar2.f39094k.elapsedRealtime();
        if (zzibVar2.f39087d.u()) {
            zzlt zzltVarL = zzmaVar.l(zzdfVar);
            zzmaVar.f39380d = zzmaVar.f39379c;
            zzmaVar.f39379c = null;
            zzhy zzhyVar = zzibVar2.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.p(new zzly(zzmaVar, zzltVarL, jElapsedRealtime));
        } else {
            zzmaVar.f39379c = null;
            zzhy zzhyVar2 = zzibVar2.f39090g;
            zzib.l(zzhyVar2);
            zzhyVar2.p(new zzlx(zzmaVar, jElapsedRealtime));
        }
        zzob zzobVar = zzibVar.f39091h;
        zzib.k(zzobVar);
        zzib zzibVar3 = zzobVar.f39180a;
        long jElapsedRealtime2 = zzibVar3.f39094k.elapsedRealtime();
        zzhy zzhyVar3 = zzibVar3.f39090g;
        zzib.l(zzhyVar3);
        zzhyVar3.p(new zznu(zzobVar, jElapsedRealtime2));
    }

    public final void d(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        zzib zzibVar = this.f39295a.f39180a;
        zzob zzobVar = zzibVar.f39091h;
        zzib.k(zzobVar);
        zzib zzibVar2 = zzobVar.f39180a;
        long jElapsedRealtime = zzibVar2.f39094k.elapsedRealtime();
        zzhy zzhyVar = zzibVar2.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zznt(zzobVar, jElapsedRealtime));
        zzma zzmaVar = zzibVar.f39095l;
        zzib.k(zzmaVar);
        Object obj = zzmaVar.f39388l;
        synchronized (obj) {
            zzmaVar.f39387k = true;
            if (!Objects.equals(zzdfVar, zzmaVar.f39383g)) {
                synchronized (obj) {
                    zzmaVar.f39383g = zzdfVar;
                    zzmaVar.f39384h = false;
                    zzib zzibVar3 = zzmaVar.f39180a;
                    if (zzibVar3.f39087d.u()) {
                        zzmaVar.f39385i = null;
                        zzhy zzhyVar2 = zzibVar3.f39090g;
                        zzib.l(zzhyVar2);
                        zzhyVar2.p(new zzlz(zzmaVar));
                    }
                }
            }
        }
        zzib zzibVar4 = zzmaVar.f39180a;
        if (!zzibVar4.f39087d.u()) {
            zzmaVar.f39379c = zzmaVar.f39385i;
            zzhy zzhyVar3 = zzibVar4.f39090g;
            zzib.l(zzhyVar3);
            zzhyVar3.p(new zzlw(zzmaVar));
            return;
        }
        zzmaVar.p(zzdfVar.f36837b, zzmaVar.l(zzdfVar), false);
        zzd zzdVar = zzmaVar.f39180a.n;
        zzib.i(zzdVar);
        zzib zzibVar5 = zzdVar.f39180a;
        long jElapsedRealtime2 = zzibVar5.f39094k.elapsedRealtime();
        zzhy zzhyVar4 = zzibVar5.f39090g;
        zzib.l(zzhyVar4);
        zzhyVar4.p(new zzc(zzdVar, jElapsedRealtime2));
    }

    public final void e(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        zzlt zzltVar;
        zzma zzmaVar = this.f39295a.f39180a.f39095l;
        zzib.k(zzmaVar);
        if (!zzmaVar.f39180a.f39087d.u() || bundle == null || (zzltVar = (zzlt) zzmaVar.f39382f.get(Integer.valueOf(zzdfVar.f36836a))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(CLConstants.SHARED_PREFERENCE_ITEM_ID, zzltVar.f39354c);
        bundle2.putString(CLConstants.FIELD_PAY_INFO_NAME, zzltVar.f39352a);
        bundle2.putString("referrer_name", zzltVar.f39353b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(com.google.android.gms.internal.measurement.zzdf.b(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        b(com.google.android.gms.internal.measurement.zzdf.b(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c(com.google.android.gms.internal.measurement.zzdf.b(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        d(com.google.android.gms.internal.measurement.zzdf.b(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        e(com.google.android.gms.internal.measurement.zzdf.b(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
