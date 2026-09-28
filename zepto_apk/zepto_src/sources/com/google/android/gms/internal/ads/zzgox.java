package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgox implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgpd f33032a;

    public /* synthetic */ zzgox(zzgpd zzgpdVar) {
        Objects.requireNonNull(zzgpdVar);
        this.f33032a = zzgpdVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        zzgpd zzgpdVar = this.f33032a;
        zzgpdVar.f33041c.a("LmdServiceConnectionManager.onServiceConnected(%s)", componentName);
        zzgpdVar.a(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgow
            @Override // java.lang.Runnable
            public final void run() throws RemoteException {
                zzgnh zzgnfVar;
                zzgnh zzgnhVar;
                IBinder iBinder2 = iBinder;
                int i2 = zzgng.f32972a;
                if (iBinder2 == null) {
                    zzgnfVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.play.core.lmd.protocol.ILmdOverlayService");
                    zzgnfVar = iInterfaceQueryLocalInterface instanceof zzgnh ? (zzgnh) iInterfaceQueryLocalInterface : new zzgnf(iBinder2, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
                }
                zzgox zzgoxVar = this.f33030a;
                zzgpd zzgpdVar2 = zzgoxVar.f33032a;
                zzgpdVar2.f33048j = zzgnfVar;
                zzgpdVar2.f33041c.a("linkToDeath", new Object[0]);
                try {
                    zzgnhVar = zzgpdVar2.f33048j;
                } catch (RemoteException e2) {
                    zzgoxVar.f33032a.f33041c.d(e2, "linkToDeath failed", new Object[0]);
                }
                if (zzgnhVar == null) {
                    throw null;
                }
                zzgnhVar.asBinder().linkToDeath(zzgpdVar2.f33046h, 0);
                zzgpd zzgpdVar3 = zzgoxVar.f33032a;
                zzgpdVar3.f33044f = false;
                synchronized (zzgpdVar3.f33043e) {
                    try {
                        Iterator it = zzgpdVar3.f33043e.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        zzgpdVar3.f33043e.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzgpd zzgpdVar = this.f33032a;
        zzgpdVar.f33041c.a("LmdServiceConnectionManager.onServiceDisconnected(%s)", componentName);
        zzgpdVar.a(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgov
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzgpd zzgpdVar2 = this.f33029a.f33032a;
                zzgpdVar2.f33041c.a("unlinkToDeath", new Object[0]);
                zzgnh zzgnhVar = zzgpdVar2.f33048j;
                zzgnhVar.getClass();
                zzgnhVar.asBinder().unlinkToDeath(zzgpdVar2.f33046h, 0);
                zzgpdVar2.f33048j = null;
                zzgpdVar2.f33044f = false;
            }
        });
    }
}
