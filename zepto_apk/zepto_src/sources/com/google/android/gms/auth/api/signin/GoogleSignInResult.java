package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

@Deprecated
/* loaded from: classes4.dex */
public class GoogleSignInResult implements Result {

    /* renamed from: a, reason: collision with root package name */
    public final Status f22187a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f22188b;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f22188b = googleSignInAccount;
        this.f22187a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22187a;
    }
}
