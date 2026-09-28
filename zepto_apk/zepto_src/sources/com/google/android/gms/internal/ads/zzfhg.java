package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfhg implements OnAdMetadataChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzdq f31112a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhi f31113b;

    public zzfhg(zzfhi zzfhiVar, com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.f31112a = zzdqVar;
        Objects.requireNonNull(zzfhiVar);
        this.f31113b = zzfhiVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void j() {
        if (this.f31113b.f31123j != null) {
            try {
                this.f31112a.zze();
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
    }
}
