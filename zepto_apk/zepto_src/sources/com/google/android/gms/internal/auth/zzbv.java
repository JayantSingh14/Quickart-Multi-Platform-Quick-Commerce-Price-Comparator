package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class zzbv implements ProxyApi.SpatulaHeaderResult {

    /* renamed from: a, reason: collision with root package name */
    public final Status f36308a;

    public zzbv(Status status) {
        this.f36308a = (Status) Preconditions.checkNotNull(status);
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f36308a;
    }

    public zzbv(String str) {
        this.f36308a = Status.RESULT_SUCCESS;
    }
}
