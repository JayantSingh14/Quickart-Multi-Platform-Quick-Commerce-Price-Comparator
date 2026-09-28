package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
final class zzmk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39412a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznk f39413b;

    public zzmk(zznk zznkVar, zzr zzrVar) {
        this.f39412a = zzrVar;
        this.f39413b = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.f39413b;
        zzga zzgaVar = zznkVar.f39485d;
        zzib zzibVar = zznkVar.f39180a;
        if (zzgaVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.a("Failed to send app backgrounded");
            return;
        }
        try {
            zzr zzrVar = this.f39412a;
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.Wa(zzrVar);
            zznkVar.t();
        } catch (RemoteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to send app backgrounded to the service");
        }
    }
}
