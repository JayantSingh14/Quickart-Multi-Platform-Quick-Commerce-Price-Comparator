package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.model.people.PersonBuffer;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzi implements People.LoadPeopleResult {

    /* renamed from: a, reason: collision with root package name */
    public final Status f39696a;

    /* renamed from: b, reason: collision with root package name */
    public final PersonBuffer f39697b;

    public zzi(DataHolder dataHolder, Status status) {
        this.f39696a = status;
        this.f39697b = dataHolder != null ? new PersonBuffer(dataHolder) : null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f39696a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        PersonBuffer personBuffer = this.f39697b;
        if (personBuffer != null) {
            personBuffer.release();
        }
    }
}
