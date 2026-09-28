package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zzad extends zzah {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzae f36280a;

    public zzad(zzae zzaeVar) {
        this.f36280a = zzaeVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void X5(Account account) {
        this.f36280a.setResult((zzae) new zzai(account != null ? Status.RESULT_SUCCESS : zzal.f36287a, account));
    }
}
