package com.google.android.play.core.splitinstall.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzab extends zzv {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f41936b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzae f41937c;

    public zzab(zzae zzaeVar, IBinder iBinder) {
        this.f41937c = zzaeVar;
        this.f41936b = iBinder;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzv
    public final void a() throws RemoteException {
        zzbo zzbmVar;
        zzae zzaeVar = this.f41937c;
        int i2 = zzbn.f41968a;
        IBinder iBinder = this.f41936b;
        if (iBinder == null) {
            zzbmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
            zzbmVar = iInterfaceQueryLocalInterface instanceof zzbo ? (zzbo) iInterfaceQueryLocalInterface : new zzbm(iBinder);
        }
        zzaf zzafVar = zzaeVar.f41939a;
        zzafVar.f41952m = zzbmVar;
        zzafVar.f41941b.d("linkToDeath", new Object[0]);
        try {
            zzafVar.f41952m.asBinder().linkToDeath(zzafVar.f41949j, 0);
        } catch (RemoteException e2) {
            zzafVar.f41941b.c(e2, "linkToDeath failed", new Object[0]);
        }
        zzafVar.f41946g = false;
        Iterator it = zzafVar.f41943d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        zzafVar.f41943d.clear();
    }
}
