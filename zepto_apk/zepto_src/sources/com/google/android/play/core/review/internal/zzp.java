package com.google.android.play.core.review.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzp extends zzj {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f41865b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzs f41866c;

    public zzp(zzs zzsVar, IBinder iBinder) {
        this.f41866c = zzsVar;
        this.f41865b = iBinder;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void a() throws RemoteException {
        zzf zzdVar;
        zzs zzsVar = this.f41866c;
        int i2 = zze.f41856a;
        IBinder iBinder = this.f41865b;
        if (iBinder == null) {
            zzdVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
            zzdVar = iInterfaceQueryLocalInterface instanceof zzf ? (zzf) iInterfaceQueryLocalInterface : new zzd(iBinder);
        }
        zzt zztVar = zzsVar.f41868a;
        zztVar.f41881m = zzdVar;
        zztVar.f41870b.a("linkToDeath", new Object[0]);
        try {
            zztVar.f41881m.asBinder().linkToDeath(zztVar.f41878j, 0);
        } catch (RemoteException e2) {
            Object[] objArr = new Object[0];
            zzi zziVar = zztVar.f41870b;
            zziVar.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", zzi.b(zziVar.f41857a, "linkToDeath failed", objArr), e2);
            }
        }
        zztVar.f41875g = false;
        Iterator it = zztVar.f41872d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        zztVar.f41872d.clear();
    }
}
