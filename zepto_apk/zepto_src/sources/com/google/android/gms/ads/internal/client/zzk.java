package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbxv;
import com.google.android.gms.internal.ads.zzbxx;

/* loaded from: classes4.dex */
public final class zzk extends RemoteCreator {

    /* renamed from: a, reason: collision with root package name */
    public zzbxx f21253a;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzbx a(Context context, zzr zzrVar, String str, zzbsz zzbszVar, int i2) {
        zzbgk.a(context);
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ob)).booleanValue()) {
            try {
                IBinder iBinderV2 = ((zzby) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", zzj.f21252a)).V2(new ObjectWrapper(context), zzrVar, str, zzbszVar, i2);
                if (iBinderV2 != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinderV2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    return iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(iBinderV2);
                }
            } catch (RemoteException e2) {
                e = e2;
                Exception exc = e;
                zzbxx zzbxxVarC = zzbxv.c(context);
                this.f21253a = zzbxxVarC;
                zzbxxVarC.a("AdManagerCreator.newAdManagerByDynamiteLoader", exc);
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", exc);
                return null;
            } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
                e = e3;
                Exception exc2 = e;
                zzbxx zzbxxVarC2 = zzbxv.c(context);
                this.f21253a = zzbxxVarC2;
                zzbxxVarC2.a("AdManagerCreator.newAdManagerByDynamiteLoader", exc2);
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", exc2);
                return null;
            } catch (NullPointerException e4) {
                e = e4;
                Exception exc22 = e;
                zzbxx zzbxxVarC22 = zzbxv.c(context);
                this.f21253a = zzbxxVarC22;
                zzbxxVarC22.a("AdManagerCreator.newAdManagerByDynamiteLoader", exc22);
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", exc22);
                return null;
            }
        } else {
            try {
                IBinder iBinderV22 = ((zzby) getRemoteCreatorInstance(context)).V2(new ObjectWrapper(context), zzrVar, str, zzbszVar, i2);
                if (iBinderV22 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = iBinderV22.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    return iInterfaceQueryLocalInterface2 instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface2 : new zzbv(iBinderV22);
                }
            } catch (RemoteException e5) {
                e = e5;
                com.google.android.gms.ads.internal.util.client.zzo.b("Could not create remote AdManager.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e6) {
                e = e6;
                com.google.android.gms.ads.internal.util.client.zzo.b("Could not create remote AdManager.", e);
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzby ? (zzby) iInterfaceQueryLocalInterface : new zzby(iBinder);
    }
}
