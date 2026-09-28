package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbjs extends NativeAd.AdChoicesInfo {

    /* renamed from: a, reason: collision with root package name */
    public final zzbjr f25260a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f25261b = new ArrayList();

    public zzbjs(zzbjr zzbjrVar) {
        IBinder iBinder;
        this.f25260a = zzbjrVar;
        try {
            zzbjrVar.zzb();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
        try {
            for (Object obj : zzbjrVar.zzc()) {
                zzbjy zzbjwVar = null;
                if ((obj instanceof IBinder) && (iBinder = (IBinder) obj) != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzbjwVar = iInterfaceQueryLocalInterface instanceof zzbjy ? (zzbjy) iInterfaceQueryLocalInterface : new zzbjw(iBinder);
                }
                if (zzbjwVar != null) {
                    this.f25261b.add(new zzbjz(zzbjwVar));
                }
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }
}
