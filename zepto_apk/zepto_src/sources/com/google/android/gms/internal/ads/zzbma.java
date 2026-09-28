package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbma extends zzbli {
    @Override // com.google.android.gms.internal.ads.zzblj
    public final void Y1(com.google.android.gms.ads.internal.client.zzbx zzbxVar, IObjectWrapper iObjectWrapper) {
        if (zzbxVar == null || iObjectWrapper == null) {
            return;
        }
        AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.z0(iObjectWrapper));
        try {
            if (zzbxVar.j() instanceof com.google.android.gms.ads.internal.client.zzg) {
                com.google.android.gms.ads.internal.client.zzg zzgVar = (com.google.android.gms.ads.internal.client.zzg) zzbxVar.j();
                adManagerAdView.setAdListener(zzgVar != null ? zzgVar.f21246a : null);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
        try {
            if (zzbxVar.h() instanceof zzbcz) {
                zzbcz zzbczVar = (zzbcz) zzbxVar.h();
                adManagerAdView.setAppEventListener(zzbczVar != null ? zzbczVar.f24736b : null);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new zzblz(this, adManagerAdView, zzbxVar));
    }
}
