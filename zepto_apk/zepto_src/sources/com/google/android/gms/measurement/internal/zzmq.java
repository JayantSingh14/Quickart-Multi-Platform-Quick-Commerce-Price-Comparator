package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzmq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39427a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznk f39428b;

    public zzmq(zznk zznkVar, zzr zzrVar) {
        this.f39427a = zzrVar;
        this.f39428b = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.f39428b;
        zzga zzgaVar = zznkVar.f39485d;
        zzib zzibVar = zznkVar.f39180a;
        if (zzgaVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzr zzrVar = this.f39427a;
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.h4(zzrVar);
            zznkVar.t();
        } catch (RemoteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to send measurementEnabled to the service");
        }
    }
}
