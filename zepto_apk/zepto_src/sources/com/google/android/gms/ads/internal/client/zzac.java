package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbww;
import com.google.android.gms.internal.ads.zzbwx;
import com.google.android.gms.internal.ads.zzbwy;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzbxv;
import com.google.android.gms.internal.ads.zzbxx;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzac extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AdActivity f21084b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzaz f21085c;

    public zzac(zzaz zzazVar, AdActivity adActivity) {
        this.f21084b = adActivity;
        Objects.requireNonNull(zzazVar);
        this.f21085c = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21084b, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        AdActivity adActivity = this.f21084b;
        zzbgk.a(adActivity);
        boolean zBooleanValue = ((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ob)).booleanValue();
        zzaz zzazVar = this.f21085c;
        if (zBooleanValue) {
            try {
                IBinder iBinderBa = ((zzbxb) com.google.android.gms.ads.internal.util.client.zzs.a(adActivity, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", zzab.f21083a)).ba(new ObjectWrapper(adActivity));
                int i2 = zzbwx.f25659a;
                if (iBinderBa == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinderBa.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
                return iInterfaceQueryLocalInterface instanceof zzbwy ? (zzbwy) iInterfaceQueryLocalInterface : new zzbww(iBinderBa);
            } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e2) {
                zzbxx zzbxxVarC = zzbxv.c(adActivity.getApplicationContext());
                zzazVar.f21137f = zzbxxVarC;
                zzbxxVarC.a("ClientApiBroker.createAdOverlay", e2);
                return null;
            }
        }
        try {
            IBinder iBinderBa2 = ((zzbxb) zzazVar.f21136e.getRemoteCreatorInstance(adActivity)).ba(new ObjectWrapper(adActivity));
            if (iBinderBa2 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface2 = iBinderBa2.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return iInterfaceQueryLocalInterface2 instanceof zzbwy ? (zzbwy) iInterfaceQueryLocalInterface2 : new zzbww(iBinderBa2);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not create remote AdOverlay.", e3);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not create remote AdOverlay.", e4);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.Z(new ObjectWrapper(this.f21084b));
    }
}
