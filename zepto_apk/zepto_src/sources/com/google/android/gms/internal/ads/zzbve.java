package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbve implements MediationAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbum f25583a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbtf f25584b;

    public zzbve(zzbvl zzbvlVar, zzbum zzbumVar, zzbtf zzbtfVar) {
        this.f25583a = zzbumVar;
        this.f25584b = zzbtfVar;
        Objects.requireNonNull(zzbvlVar);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void a(AdError adError) {
        try {
            this.f25583a.a(adError.a());
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }
}
