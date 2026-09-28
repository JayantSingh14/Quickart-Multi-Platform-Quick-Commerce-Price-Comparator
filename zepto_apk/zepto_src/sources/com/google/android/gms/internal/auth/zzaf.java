package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zzaf extends zzah {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzag f36281a;

    public zzaf(zzag zzagVar) {
        this.f36281a = zzagVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzc(boolean z) {
        this.f36281a.setResult((zzag) new zzak(z ? Status.RESULT_SUCCESS : zzal.f36287a));
    }
}
