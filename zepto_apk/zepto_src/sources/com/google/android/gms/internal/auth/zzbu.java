package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zzbu implements ProxyApi.ProxyResult {

    /* renamed from: a, reason: collision with root package name */
    public final Status f36307a;

    public zzbu(Status status) {
        this.f36307a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f36307a;
    }

    public zzbu() {
        this.f36307a = Status.RESULT_SUCCESS;
    }
}
