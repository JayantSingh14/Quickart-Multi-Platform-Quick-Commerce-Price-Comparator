package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
final class zzmg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39402a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznk f39403b;

    public zzmg(zznk zznkVar, zzr zzrVar) {
        this.f39402a = zzrVar;
        this.f39403b = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.f39403b;
        zzga zzgaVar = zznkVar.f39485d;
        zzib zzibVar = zznkVar.f39180a;
        if (zzgaVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzr zzrVar = this.f39402a;
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.M7(zzrVar);
        } catch (RemoteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to reset data on the service: remote exception");
        }
        zznkVar.t();
    }
}
