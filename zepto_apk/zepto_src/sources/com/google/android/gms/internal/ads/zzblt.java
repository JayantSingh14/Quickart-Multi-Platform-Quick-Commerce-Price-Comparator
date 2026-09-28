package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzblt extends UnifiedNativeAd {

    /* renamed from: a, reason: collision with root package name */
    public final zzbls f25299a;

    /* renamed from: c, reason: collision with root package name */
    public final zzbjz f25301c;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f25300b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final VideoController f25302d = new VideoController();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f25303e = new ArrayList();

    public zzblt(zzbls zzblsVar) {
        zzbjy zzbjwVar;
        IBinder iBinder;
        this.f25299a = zzblsVar;
        zzbjz zzbjzVar = null;
        try {
            List listZzf = zzblsVar.zzf();
            if (listZzf != null) {
                for (Object obj : listZzf) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzbjwVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzbjwVar = iInterfaceQueryLocalInterface instanceof zzbjy ? (zzbjy) iInterfaceQueryLocalInterface : new zzbjw(iBinder);
                    }
                    if (zzbjwVar != null) {
                        this.f25300b.add(new zzbjz(zzbjwVar));
                    }
                }
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
        try {
            List listI = this.f25299a.I();
            if (listI != null) {
                for (Object obj2 : listI) {
                    com.google.android.gms.ads.internal.client.zzdj zzdjVarXb = obj2 instanceof IBinder ? com.google.android.gms.ads.internal.client.zzdi.Xb((IBinder) obj2) : null;
                    if (zzdjVarXb != null) {
                        this.f25303e.add(new com.google.android.gms.ads.internal.client.zzdk(zzdjVarXb));
                    }
                }
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        try {
            zzbjy zzbjyVarZzh = this.f25299a.zzh();
            if (zzbjyVarZzh != null) {
                zzbjzVar = new zzbjz(zzbjyVarZzh);
            }
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
        this.f25301c = zzbjzVar;
        try {
            if (this.f25299a.zzq() != null) {
                new zzbjs(this.f25299a.zzq());
            }
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
        }
    }
}
