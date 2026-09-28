package com.google.android.play.core.appupdate.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzt extends zzn {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f41696b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzw f41697c;

    public zzt(zzw zzwVar, IBinder iBinder) {
        this.f41697c = zzwVar;
        this.f41696b = iBinder;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() throws RemoteException {
        zzf zzdVar;
        zzw zzwVar = this.f41697c;
        int i2 = zze.f41679a;
        IBinder iBinder = this.f41696b;
        if (iBinder == null) {
            zzdVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
            zzdVar = iInterfaceQueryLocalInterface instanceof zzf ? (zzf) iInterfaceQueryLocalInterface : new zzd(iBinder);
        }
        zzx zzxVar = zzwVar.f41699a;
        zzxVar.f41712m = zzdVar;
        zzxVar.f41701b.c("linkToDeath", new Object[0]);
        try {
            zzxVar.f41712m.asBinder().linkToDeath(zzxVar.f41709j, 0);
        } catch (RemoteException e2) {
            zzxVar.f41701b.b(e2, "linkToDeath failed", new Object[0]);
        }
        zzxVar.f41706g = false;
        Iterator it = zzxVar.f41703d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        zzxVar.f41703d.clear();
    }
}
