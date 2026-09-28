package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfnr implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f31488j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static final Object f31489k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final Object f31490l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public static Boolean f31491m;

    /* renamed from: a, reason: collision with root package name */
    public final Context f31492a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f31493b;

    /* renamed from: e, reason: collision with root package name */
    public int f31496e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdur f31497f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractCollection f31498g;

    /* renamed from: h, reason: collision with root package name */
    public final zzcld f31499h;

    /* renamed from: c, reason: collision with root package name */
    public final zzfnv f31494c = zzfny.D();

    /* renamed from: d, reason: collision with root package name */
    public String f31495d = "";

    /* renamed from: i, reason: collision with root package name */
    public boolean f31500i = false;

    public zzfnr(Context context, VersionInfoParcel versionInfoParcel, zzdur zzdurVar, zzbzi zzbziVar, zzcld zzcldVar) {
        this.f31492a = context;
        this.f31493b = versionInfoParcel;
        this.f31497f = zzdurVar;
        this.f31499h = zzcldVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Q9)).booleanValue()) {
            this.f31498g = com.google.android.gms.ads.internal.util.zzs.J();
        } else {
            zzgvs zzgvsVar = zzgtd.f33183b;
            this.f31498g = zzguy.f33232e;
        }
    }

    public static boolean a() {
        boolean zBooleanValue;
        synchronized (f31488j) {
            try {
                if (f31491m == null) {
                    if (((Boolean) zzbid.f25132b.c()).booleanValue()) {
                        f31491m = Boolean.valueOf(Math.random() < ((Double) zzbid.f25131a.c()).doubleValue());
                    } else {
                        f31491m = Boolean.FALSE;
                    }
                }
                zBooleanValue = f31491m.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public final void b(final zzfnh zzfnhVar) {
        ((zzgxi) zzcdo.f25982a).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfnq
            @Override // java.lang.Runnable
            public final void run() {
                zzbvn zzbvnVar;
                zzfnr zzfnrVar = this.f31486a;
                zzfnh zzfnhVar2 = zzfnhVar;
                zzfnrVar.getClass();
                synchronized (zzfnr.f31490l) {
                    try {
                        if (!zzfnrVar.f31500i) {
                            zzfnrVar.f31500i = true;
                            if (zzfnr.a()) {
                                try {
                                    com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                                    zzfnrVar.f31495d = com.google.android.gms.ads.internal.util.zzs.Q(zzfnrVar.f31492a);
                                } catch (RemoteException | RuntimeException e2) {
                                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("CuiMonitor.gettingAppIdFromManifest", e2);
                                }
                                zzfnrVar.f31496e = GoogleApiAvailabilityLight.getInstance().getApkVersion(zzfnrVar.f31492a);
                                zzbgb zzbgbVar = zzbgk.L9;
                                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                                int iIntValue = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
                                if (((Boolean) zzbdVar.f21153c.a(zzbgk.Yc)).booleanValue()) {
                                    long j2 = iIntValue;
                                    ((ScheduledThreadPoolExecutor) zzcdo.f25985d).scheduleWithFixedDelay(zzfnrVar, j2, j2, TimeUnit.MILLISECONDS);
                                } else {
                                    long j3 = iIntValue;
                                    ((ScheduledThreadPoolExecutor) zzcdo.f25985d).scheduleAtFixedRate(zzfnrVar, j3, j3, TimeUnit.MILLISECONDS);
                                }
                                zzbgb zzbgbVar2 = zzbgk.R9;
                                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar2)).booleanValue()) {
                                    zzcld zzcldVar = zzfnrVar.f31499h;
                                    zzcldVar.getClass();
                                    if (((Boolean) zzbdVar.f21153c.a(zzbgbVar2)).booleanValue() && !zzcldVar.f26499e.getAndSet(true)) {
                                        zzcldVar.a();
                                    }
                                }
                            }
                        }
                    } finally {
                    }
                }
                if (zzfnr.a() && zzfnhVar2 != null) {
                    synchronized (zzfnr.f31489k) {
                        try {
                            zzfnv zzfnvVar = zzfnrVar.f31494c;
                            int iC = ((zzfny) zzfnvVar.f34638b).C();
                            zzbgb zzbgbVar3 = zzbgk.M9;
                            com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                            if (iC >= ((Integer) zzbdVar2.f21153c.a(zzbgbVar3)).intValue()) {
                                return;
                            }
                            zzfns zzfnsVarE = zzfnu.E();
                            int i2 = zzfnhVar2.f31467m;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).a0(i2);
                            boolean z = zzfnhVar2.f31456b;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).F(z);
                            long j4 = zzfnhVar2.f31455a;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).G(j4);
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).b0();
                            String str = zzfnrVar.f31493b.f21400a;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).I(str);
                            String str2 = zzfnrVar.f31495d;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).J(str2);
                            String str3 = Build.VERSION.RELEASE;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).K(str3);
                            int i3 = Build.VERSION.SDK_INT;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).L(i3);
                            int i4 = zzfnhVar2.o;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).C(i4);
                            int i5 = zzfnhVar2.f31457c;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).N(i5);
                            long j5 = zzfnrVar.f31496e;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).O(j5);
                            int i6 = zzfnhVar2.n;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).D(i6);
                            String str4 = zzfnhVar2.f31458d;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).P(str4);
                            String str5 = zzfnhVar2.f31459e;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).Q(str5);
                            String str6 = zzfnhVar2.f31460f;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).R(str6);
                            zzduq zzduqVarB = zzfnrVar.f31497f.b(zzfnhVar2.f31460f);
                            String string = (zzduqVarB == null || (zzbvnVar = zzduqVarB.f28603b) == null) ? "" : zzbvnVar.toString();
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).S(string);
                            String str7 = zzfnhVar2.f31461g;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).T(str7);
                            zzfnt zzfntVar = zzfnhVar2.f31462h;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).X(zzfntVar);
                            String str8 = zzfnhVar2.f31465k;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).W(str8);
                            String str9 = zzfnhVar2.f31463i;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).U(str9);
                            String str10 = zzfnhVar2.f31464j;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).V(str10);
                            long j6 = zzfnhVar2.f31466l;
                            zzfnsVarE.j();
                            ((zzfnu) zzfnsVarE.f34638b).H(j6);
                            if (((Boolean) zzbdVar2.f21153c.a(zzbgk.Q9)).booleanValue()) {
                                AbstractCollection abstractCollection = zzfnrVar.f31498g;
                                zzfnsVarE.j();
                                ((zzfnu) zzfnsVarE.f34638b).M(abstractCollection);
                            }
                            if (((Boolean) zzbdVar2.f21153c.a(zzbgk.R9)).booleanValue()) {
                                zzcld zzcldVar2 = zzfnrVar.f31499h;
                                zzief zziefVar = zzcldVar2.f26496b;
                                String str11 = zzcldVar2.f26495a;
                                if (zziefVar != null) {
                                    zzfnsVarE.j();
                                    ((zzfnu) zzfnsVarE.f34638b).Y(zziefVar);
                                }
                                if (str11 != null) {
                                    zzfnsVarE.j();
                                    ((zzfnu) zzfnsVarE.f34638b).Z(str11);
                                }
                            }
                            zzfnw zzfnwVarC = zzfnx.C();
                            zzfnwVarC.j();
                            ((zzfnx) zzfnwVarC.f34638b).D((zzfnu) zzfnsVarE.l());
                            zzfnvVar.j();
                            ((zzfny) zzfnvVar.f34638b).E((zzfnx) zzfnwVarC.l());
                        } finally {
                        }
                    }
                }
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrG;
        if (a()) {
            Object obj = f31489k;
            synchronized (obj) {
                try {
                    if (((zzfny) this.f31494c.f34638b).C() == 0) {
                        return;
                    }
                    try {
                        synchronized (obj) {
                            zzfnv zzfnvVar = this.f31494c;
                            bArrG = ((zzfny) zzfnvVar.l()).g();
                            zzfnvVar.j();
                            ((zzfny) zzfnvVar.f34638b).F();
                        }
                        zzefy zzefyVar = new zzefy((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.K9), 60000, new HashMap(), bArrG, "application/x-protobuf");
                        Context context = this.f31492a;
                        String str = this.f31493b.f21400a;
                        Binder.getCallingUid();
                        new zzega(context, str, null).zza(zzefyVar);
                    } catch (Exception e2) {
                        if ((e2 instanceof zzebr) && ((zzebr) e2).f29026a == 3) {
                            return;
                        }
                        com.google.android.gms.ads.internal.zzt.C.f21684h.e("CuiMonitor.sendCuiPing", e2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
