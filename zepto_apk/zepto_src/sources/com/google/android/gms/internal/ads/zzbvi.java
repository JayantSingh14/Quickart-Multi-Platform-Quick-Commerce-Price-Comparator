package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbvi implements MediationAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbuj f25591a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbtf f25592b;

    public zzbvi(zzbvl zzbvlVar, zzbuj zzbujVar, zzbtf zzbtfVar) {
        this.f25591a = zzbujVar;
        this.f25592b = zzbtfVar;
        Objects.requireNonNull(zzbvlVar);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void a(AdError adError) {
        try {
            this.f25591a.a(adError.a());
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }
}
