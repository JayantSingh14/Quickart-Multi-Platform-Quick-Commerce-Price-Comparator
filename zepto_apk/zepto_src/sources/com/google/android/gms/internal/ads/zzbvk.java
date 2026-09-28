package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbvk implements MediationAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbuv f25594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbtf f25595b;

    public zzbvk(zzbvl zzbvlVar, zzbuv zzbuvVar, zzbtf zzbtfVar) {
        this.f25594a = zzbuvVar;
        this.f25595b = zzbtfVar;
        Objects.requireNonNull(zzbvlVar);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void a(AdError adError) {
        try {
            this.f25594a.a(adError.a());
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }
}
