package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zbj extends zba {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zbk f22215a;

    public zbj(zbk zbkVar) {
        this.f22215a = zbkVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void k9(Status status) {
        this.f22215a.setResult((zbk) status);
    }
}
