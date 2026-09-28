package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zzak implements Result {

    /* renamed from: a, reason: collision with root package name */
    public final Status f36286a;

    public zzak(Status status) {
        this.f36286a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f36286a;
    }
}
