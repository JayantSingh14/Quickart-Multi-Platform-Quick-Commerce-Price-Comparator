package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zbf extends zba {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zbg f22213a;

    public zbf(zbg zbgVar) {
        this.f22213a = zbgVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void i4(GoogleSignInAccount googleSignInAccount, Status status) {
        if (googleSignInAccount != null) {
            zbn zbnVarA = zbn.a(null);
            synchronized (zbnVarA) {
                zbnVarA.f22218a.c(googleSignInAccount, null);
            }
        }
        this.f22213a.setResult((zbg) new GoogleSignInResult(googleSignInAccount, status));
    }
}
