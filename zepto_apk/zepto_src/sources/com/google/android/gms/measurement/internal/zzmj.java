package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzmj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39410a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznk f39411b;

    public zzmj(zznk zznkVar, zzr zzrVar) {
        this.f39410a = zzrVar;
        this.f39411b = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zznk zznkVar = this.f39411b;
        zzga zzgaVar = zznkVar.f39485d;
        zzib zzibVar = zznkVar.f39180a;
        if (zzgaVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzr zzrVar = this.f39410a;
            Preconditions.checkNotNull(zzrVar);
            zzal zzalVar = zzibVar.f39087d;
            zzfw zzfwVar = zzfx.c1;
            if (zzalVar.q(null, zzfwVar)) {
                zznkVar.y(zzgaVar, null, zzrVar);
            }
            zzgaVar.ya(zzrVar);
            zzibVar.n().l();
            zzibVar.f39087d.q(null, zzfwVar);
            zznkVar.y(zzgaVar, null, zzrVar);
            zznkVar.t();
        } catch (RemoteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to send app launch to the service");
        }
    }
}
