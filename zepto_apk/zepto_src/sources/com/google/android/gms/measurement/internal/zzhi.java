package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes4.dex */
public final class zzhi implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final String f39035a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzhj f39036b;

    public zzhi(zzhj zzhjVar, String str) {
        this.f39036b = zzhjVar;
        this.f39035a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzhj zzhjVar = this.f39036b;
        if (iBinder == null) {
            zzgt zzgtVar = zzhjVar.f39037a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i2 = com.google.android.gms.internal.measurement.zzbp.f36804a;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            com.google.android.gms.internal.measurement.zzbq zzboVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.measurement.zzbq ? (com.google.android.gms.internal.measurement.zzbq) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.measurement.zzbo(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (zzboVar == null) {
                zzgt zzgtVar2 = zzhjVar.f39037a.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38961i.a("Install Referrer Service implementation was not found");
                return;
            }
            zzib zzibVar = zzhjVar.f39037a;
            zzgt zzgtVar3 = zzibVar.f39089f;
            zzib.l(zzgtVar3);
            zzgtVar3.n.a("Install Referrer Service connected");
            zzhy zzhyVar = zzibVar.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.p(new zzhh(this, zzboVar, this));
        } catch (RuntimeException e2) {
            zzgt zzgtVar4 = zzhjVar.f39037a.f39089f;
            zzib.l(zzgtVar4);
            zzgtVar4.f38961i.b(e2, "Exception occurred while calling Install Referrer API");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzgt zzgtVar = this.f39036b.f39037a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.n.a("Install Referrer Service disconnected");
    }
}
