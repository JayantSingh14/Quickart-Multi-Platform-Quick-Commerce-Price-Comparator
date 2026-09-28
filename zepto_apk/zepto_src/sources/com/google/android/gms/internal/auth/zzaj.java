package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zzaj implements Result {

    /* renamed from: a, reason: collision with root package name */
    public final Status f36285a;

    public zzaj(Status status) {
        this.f36285a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f36285a;
    }
}
