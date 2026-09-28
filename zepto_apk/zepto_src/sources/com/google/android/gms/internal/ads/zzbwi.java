package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzbwi extends NativeAd {

    /* renamed from: a, reason: collision with root package name */
    public final zzbls f25653a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f25654b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f25655c = new ArrayList();

    public zzbwi(zzbls zzblsVar) {
        new AtomicLong();
        this.f25653a = zzblsVar;
        try {
            List listZzf = zzblsVar.zzf();
            if (listZzf != null) {
                for (Object obj : listZzf) {
                    zzbjy zzbjyVarXb = obj instanceof IBinder ? zzbjx.Xb((IBinder) obj) : null;
                    if (zzbjyVarXb != null) {
                        this.f25654b.add(new zzbwh(zzbjyVarXb));
                    }
                }
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
        try {
            List listI = this.f25653a.I();
            if (listI != null) {
                for (Object obj2 : listI) {
                    com.google.android.gms.ads.internal.client.zzdj zzdjVarXb = obj2 instanceof IBinder ? com.google.android.gms.ads.internal.client.zzdi.Xb((IBinder) obj2) : null;
                    if (zzdjVarXb != null) {
                        this.f25655c.add(new com.google.android.gms.ads.internal.client.zzdk(zzdjVarXb));
                    }
                }
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        try {
            zzbjy zzbjyVarZzh = this.f25653a.zzh();
            if (zzbjyVarZzh != null) {
                new zzbwh(zzbjyVarZzh);
            }
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
        try {
            if (this.f25653a.zzq() != null) {
                new zzbwf(this.f25653a.zzq());
            }
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String a() {
        try {
            return this.f25653a.zzg();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String b() {
        try {
            return this.f25653a.zze();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final ResponseInfo c() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarM;
        try {
            zzeaVarM = this.f25653a.m();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            zzeaVarM = null;
        }
        if (zzeaVarM != null) {
            return new ResponseInfo(zzeaVarM);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final /* bridge */ /* synthetic */ IObjectWrapper d() {
        try {
            return this.f25653a.c();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void recordEvent(Bundle bundle) {
        try {
            this.f25653a.H4(bundle);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to record native event", e2);
        }
    }
}
