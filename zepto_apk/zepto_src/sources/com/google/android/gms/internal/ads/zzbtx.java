package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbtx implements MediationAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbtf f25553a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbua f25554b;

    public zzbtx(zzbua zzbuaVar, zzbtf zzbtfVar) {
        this.f25553a = zzbtfVar;
        Objects.requireNonNull(zzbuaVar);
        this.f25554b = zzbuaVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void a(AdError adError) {
        int i2 = adError.f20981a;
        try {
            String canonicalName = this.f25554b.f25559a.getClass().getCanonicalName();
            String str = adError.f20982b;
            String str2 = adError.f20983c;
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41 + String.valueOf(i2).length() + 17 + String.valueOf(str).length() + 16 + String.valueOf(str2).length());
            sb.append(canonicalName);
            sb.append("failed to load mediation ad: ErrorCode = ");
            sb.append(i2);
            sb.append(". ErrorMessage = ");
            sb.append(str);
            sb.append(". ErrorDomain = ");
            sb.append(str2);
            com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
            zzbtf zzbtfVar = this.f25553a;
            zzbtfVar.H1(adError.a());
            zzbtfVar.Qb(i2, str);
            zzbtfVar.zzg(i2);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }
}
