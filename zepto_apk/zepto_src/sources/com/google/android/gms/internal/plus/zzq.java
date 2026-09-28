package com.google.android.gms.internal.plus;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;

/* loaded from: classes4.dex */
final class zzq implements People.LoadPeopleResult {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Status f38194a;

    public zzq(Status status) {
        this.f38194a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f38194a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}
