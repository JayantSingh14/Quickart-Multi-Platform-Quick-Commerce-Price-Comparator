package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
final class zzmi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39407a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39408b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zznk f39409c;

    public zzmi(zznk zznkVar, zzr zzrVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f39407a = zzrVar;
        this.f39408b = zzcuVar;
        this.f39409c = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzib zzibVar;
        boolean zI;
        zzib zzibVar2;
        zzhg zzhgVar;
        zzgt zzgtVar;
        com.google.android.gms.internal.measurement.zzcu zzcuVar = this.f39408b;
        zznk zznkVar = this.f39409c;
        String strJ6 = null;
        try {
            try {
                zzibVar = zznkVar.f39180a;
                zzhg zzhgVar2 = zzibVar.f39088e;
                zzib.j(zzhgVar2);
                zI = zzhgVar2.n().i(zzjj.ANALYTICS_STORAGE);
                zzibVar2 = zznkVar.f39180a;
                zzhgVar = zzibVar.f39088e;
                zzgtVar = zzibVar.f39089f;
            } catch (RemoteException e2) {
                zzgt zzgtVar2 = zznkVar.f39180a.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.b(e2, "Failed to get app instance id");
            }
            if (zI) {
                zzga zzgaVar = zznkVar.f39485d;
                if (zzgaVar != null) {
                    zzr zzrVar = this.f39407a;
                    Preconditions.checkNotNull(zzrVar);
                    strJ6 = zzgaVar.j6(zzrVar);
                    if (strJ6 != null) {
                        zzli zzliVar = zzibVar2.f39096m;
                        zzib.k(zzliVar);
                        zzliVar.f39319g.set(strJ6);
                        zzib.j(zzhgVar);
                        zzhgVar.f39026g.b(strJ6);
                    }
                    zznkVar.t();
                    zzpo zzpoVar = zznkVar.f39180a.f39092i;
                    zzib.j(zzpoVar);
                    zzpoVar.N(strJ6, zzcuVar);
                    return;
                }
                zzib.l(zzgtVar);
                zzgtVar.f38958f.a("Failed to get app instance id");
            } else {
                zzib.l(zzgtVar);
                zzgtVar.f38963k.a("Analytics storage consent denied; will not get app instance id");
                zzli zzliVar2 = zzibVar2.f39096m;
                zzib.k(zzliVar2);
                zzliVar2.f39319g.set(null);
                zzib.j(zzhgVar);
                zzhgVar.f39026g.b(null);
            }
            zzpo zzpoVar2 = zzibVar.f39092i;
            zzib.j(zzpoVar2);
            zzpoVar2.N(null, zzcuVar);
        } catch (Throwable th) {
            zzpo zzpoVar3 = zznkVar.f39180a.f39092i;
            zzib.j(zzpoVar3);
            zzpoVar3.N(null, zzcuVar);
            throw th;
        }
    }
}
