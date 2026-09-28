package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class aa extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f42152b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ad f42153c;

    public aa(ad adVar, IBinder iBinder) {
        this.f42152b = iBinder;
        this.f42153c = adVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() throws RemoteException {
        ae aeVar = this.f42153c.f42155a;
        aeVar.n = (IInterface) aeVar.f42164i.a(this.f42152b);
        s sVar = aeVar.f42157b;
        sVar.b("linkToDeath", new Object[0]);
        try {
            aeVar.n.asBinder().linkToDeath(aeVar.f42166k, 0);
        } catch (RemoteException e2) {
            sVar.a(e2, "linkToDeath failed", new Object[0]);
        }
        aeVar.f42162g = false;
        Iterator it = aeVar.f42159d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        aeVar.f42159d.clear();
    }
}
