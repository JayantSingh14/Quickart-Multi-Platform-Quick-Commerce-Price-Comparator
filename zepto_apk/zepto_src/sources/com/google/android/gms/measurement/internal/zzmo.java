package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final class zzmo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbg f39422a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39423b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39424c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zznk f39425d;

    public zzmo(zznk zznkVar, zzbg zzbgVar, String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f39422a = zzbgVar;
        this.f39423b = str;
        this.f39424c = zzcuVar;
        this.f39425d = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzga zzgaVar;
        com.google.android.gms.internal.measurement.zzcu zzcuVar = this.f39424c;
        zznk zznkVar = this.f39425d;
        byte[] bArrV4 = null;
        try {
            try {
                zzgaVar = zznkVar.f39485d;
            } catch (RemoteException e2) {
                zzgt zzgtVar = zznkVar.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.b(e2, "Failed to send event to the service to bundle");
            }
            if (zzgaVar != null) {
                bArrV4 = zzgaVar.v4(this.f39422a, this.f39423b);
                zznkVar.t();
                return;
            }
            zzib zzibVar = zznkVar.f39180a;
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.a("Discarding data. Failed to send event to service to bundle");
            zzpo zzpoVar = zzibVar.f39092i;
            zzib.j(zzpoVar);
            zzpoVar.Q(zzcuVar, null);
        } finally {
            zzpo zzpoVar2 = zznkVar.f39180a.f39092i;
            zzib.j(zzpoVar2);
            zzpoVar2.Q(zzcuVar, null);
        }
    }
}
