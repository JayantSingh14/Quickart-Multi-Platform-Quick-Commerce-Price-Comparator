package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbwf extends NativeAd.AdChoicesInfo {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f25651a = new ArrayList();

    public zzbwf(zzbjr zzbjrVar) {
        try {
            zzbjrVar.zzb();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
        try {
            for (Object obj : zzbjrVar.zzc()) {
                zzbjy zzbjyVarXb = obj instanceof IBinder ? zzbjx.Xb((IBinder) obj) : null;
                if (zzbjyVarXb != null) {
                    this.f25651a.add(new zzbwh(zzbjyVarXb));
                }
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }
}
