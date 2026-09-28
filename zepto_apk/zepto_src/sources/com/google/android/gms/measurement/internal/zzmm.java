package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzmm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzlt f39415a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznk f39416b;

    public zzmm(zznk zznkVar, zzlt zzltVar) {
        this.f39415a = zzltVar;
        Objects.requireNonNull(zznkVar);
        this.f39416b = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.f39416b;
        zzga zzgaVar = zznkVar.f39485d;
        zzib zzibVar = zznkVar.f39180a;
        if (zzgaVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Failed to send current screen to service");
            return;
        }
        try {
            zzlt zzltVar = this.f39415a;
            if (zzltVar == null) {
                zzgaVar.J7(0L, null, null, zzibVar.f39084a.getPackageName());
            } else {
                zzgaVar.J7(zzltVar.f39354c, zzltVar.f39352a, zzltVar.f39353b, zzibVar.f39084a.getPackageName());
            }
            zznkVar.t();
        } catch (RemoteException e2) {
            zzgt zzgtVar2 = zznkVar.f39180a.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to send current screen to the service");
        }
    }
}
