package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzmr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39429a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznk f39430b;

    public zzmr(zznk zznkVar, zzr zzrVar) {
        this.f39429a = zzrVar;
        Objects.requireNonNull(zznkVar);
        this.f39430b = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.f39430b;
        zzga zzgaVar = zznkVar.f39485d;
        zzib zzibVar = zznkVar.f39180a;
        if (zzgaVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Failed to send consent settings to service");
            return;
        }
        try {
            zzr zzrVar = this.f39429a;
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.Nb(zzrVar);
            zznkVar.t();
        } catch (RemoteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to send consent settings to the service");
        }
    }
}
