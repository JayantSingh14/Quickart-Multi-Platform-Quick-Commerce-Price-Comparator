package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* loaded from: classes4.dex */
final class zzfhn implements OnAdMetadataChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzcb f31134a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfho f31135b;

    public zzfhn(zzfho zzfhoVar, com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        this.f31134a = zzcbVar;
        this.f31135b = zzfhoVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void j() {
        if (this.f31135b.f31139d != null) {
            try {
                this.f31134a.zze();
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
    }
}
