package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* loaded from: classes4.dex */
final class zzmb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39389a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39390b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzr f39391c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f39392d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39393e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zznk f39394f;

    public zzmb(zznk zznkVar, String str, String str2, zzr zzrVar, boolean z, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f39389a = str;
        this.f39390b = str2;
        this.f39391c = zzrVar;
        this.f39392d = z;
        this.f39393e = zzcuVar;
        this.f39394f = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e2;
        String str = this.f39389a;
        com.google.android.gms.internal.measurement.zzcu zzcuVar = this.f39393e;
        zznk zznkVar = this.f39394f;
        Bundle bundle2 = new Bundle();
        try {
            zzga zzgaVar = zznkVar.f39485d;
            String str2 = this.f39390b;
            zzib zzibVar = zznkVar.f39180a;
            if (zzgaVar == null) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.c("Failed to get user properties; not connected to service", str, str2);
                zzpo zzpoVar = zzibVar.f39092i;
                zzib.j(zzpoVar);
                zzpoVar.S(zzcuVar, bundle2);
                return;
            }
            zzr zzrVar = this.f39391c;
            Preconditions.checkNotNull(zzrVar);
            List<zzpk> listFb = zzgaVar.fb(str, str2, this.f39392d, zzrVar);
            bundle = new Bundle();
            if (listFb != null) {
                for (zzpk zzpkVar : listFb) {
                    String str3 = zzpkVar.f39630e;
                    String str4 = zzpkVar.f39627b;
                    if (str3 != null) {
                        bundle.putString(str4, str3);
                    } else {
                        Long l2 = zzpkVar.f39629d;
                        if (l2 != null) {
                            bundle.putLong(str4, l2.longValue());
                        } else {
                            Double d2 = zzpkVar.f39632g;
                            if (d2 != null) {
                                bundle.putDouble(str4, d2.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    zznkVar.t();
                    zzpo zzpoVar2 = zzibVar.f39092i;
                    zzib.j(zzpoVar2);
                    zzpoVar2.S(zzcuVar, bundle);
                } catch (RemoteException e3) {
                    e2 = e3;
                    zzgt zzgtVar2 = zznkVar.f39180a.f39089f;
                    zzib.l(zzgtVar2);
                    zzgtVar2.f38958f.c("Failed to get user properties; remote exception", str, e2);
                    zzpo zzpoVar3 = zznkVar.f39180a.f39092i;
                    zzib.j(zzpoVar3);
                    zzpoVar3.S(zzcuVar, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                zzpo zzpoVar4 = zznkVar.f39180a.f39092i;
                zzib.j(zzpoVar4);
                zzpoVar4.S(zzcuVar, bundle2);
                throw th;
            }
        } catch (RemoteException e4) {
            bundle = bundle2;
            e2 = e4;
        } catch (Throwable th2) {
            th = th2;
            zzpo zzpoVar42 = zznkVar.f39180a.f39092i;
            zzib.j(zzpoVar42);
            zzpoVar42.S(zzcuVar, bundle2);
            throw th;
        }
    }
}
