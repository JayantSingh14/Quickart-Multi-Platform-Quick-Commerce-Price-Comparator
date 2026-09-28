package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzcar {
    public static final zzcaf a(Context context, String str, zzbsv zzbsvVar) {
        try {
            IBinder iBinderV2 = ((zzcaj) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzcaq.f25792a)).V2(new ObjectWrapper(context), str, zzbsvVar);
            if (iBinderV2 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderV2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return iInterfaceQueryLocalInterface instanceof zzcaf ? (zzcaf) iInterfaceQueryLocalInterface : new zzcad(iBinderV2);
        } catch (RemoteException e2) {
            e = e2;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e);
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
            e = e3;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e);
            return null;
        }
    }
}
