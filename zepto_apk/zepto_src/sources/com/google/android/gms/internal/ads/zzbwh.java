package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbwh extends NativeAd.Image {

    /* renamed from: b, reason: collision with root package name */
    public final zzbjy f25652b;

    public zzbwh(zzbjy zzbjyVar) {
        this.f25652b = zzbjyVar;
        try {
            IObjectWrapper iObjectWrapperZzb = zzbjyVar.zzb();
            if (iObjectWrapperZzb != null) {
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
        try {
            this.f25652b.zzc();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        try {
            this.f25652b.zzd();
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
        try {
            this.f25652b.zze();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
        }
        try {
            this.f25652b.zzf();
        } catch (RemoteException e6) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e6);
        }
        Map mapZzg = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.D4)).booleanValue()) {
            try {
                mapZzg = this.f25652b.zzg();
            } catch (RemoteException unused) {
            }
        }
        this.f21720a = mapZzg;
    }
}
