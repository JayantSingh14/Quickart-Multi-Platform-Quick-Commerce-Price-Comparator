package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zbh extends zba {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zbi f22214a;

    public zbh(zbi zbiVar) {
        this.f22214a = zbiVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void J9(Status status) {
        this.f22214a.setResult((zbi) status);
    }
}
