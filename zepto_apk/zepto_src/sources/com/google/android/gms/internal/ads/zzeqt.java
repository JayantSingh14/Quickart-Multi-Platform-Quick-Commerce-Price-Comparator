package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes4.dex */
public final class zzeqt implements com.google.android.gms.ads.internal.client.zza, zzdir {

    /* renamed from: a, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzbh f30116a;

    @Override // com.google.android.gms.internal.ads.zzdir
    public final synchronized void S() {
        com.google.android.gms.ads.internal.client.zzbh zzbhVar = this.f30116a;
        if (zzbhVar != null) {
            try {
                zzbhVar.zzb();
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Remote Exception at onPhysicalClick.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final synchronized void a0() {
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void h() {
        com.google.android.gms.ads.internal.client.zzbh zzbhVar = this.f30116a;
        if (zzbhVar != null) {
            try {
                zzbhVar.zzb();
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Remote Exception at onAdClicked.", e2);
            }
        }
    }
}
