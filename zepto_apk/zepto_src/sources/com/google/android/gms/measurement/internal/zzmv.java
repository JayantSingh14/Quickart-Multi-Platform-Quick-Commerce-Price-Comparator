package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class zzmv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39444a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39445b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzr f39446c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39447d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zznk f39448e;

    public zzmv(zznk zznkVar, String str, String str2, zzr zzrVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f39444a = str;
        this.f39445b = str2;
        this.f39446c = zzrVar;
        this.f39447d = zzcuVar;
        this.f39448e = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzga zzgaVar;
        com.google.android.gms.internal.measurement.zzcu zzcuVar = this.f39447d;
        String str = this.f39445b;
        String str2 = this.f39444a;
        zznk zznkVar = this.f39448e;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                zzgaVar = zznkVar.f39485d;
            } catch (RemoteException e2) {
                zzgt zzgtVar = zznkVar.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.d("Failed to get conditional properties; remote exception", str2, str, e2);
            }
            if (zzgaVar != null) {
                zzr zzrVar = this.f39446c;
                Preconditions.checkNotNull(zzrVar);
                arrayList = zzpo.U(zzgaVar.pb(str2, str, zzrVar));
                zznkVar.t();
                return;
            }
            zzib zzibVar = zznkVar.f39180a;
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Failed to get conditional properties; not connected to service", str2, str);
            zzpo zzpoVar = zzibVar.f39092i;
            zzib.j(zzpoVar);
            zzpoVar.T(zzcuVar, arrayList);
        } finally {
            zzpo zzpoVar2 = zznkVar.f39180a.f39092i;
            zzib.j(zzpoVar2);
            zzpoVar2.T(zzcuVar, arrayList);
        }
    }
}
