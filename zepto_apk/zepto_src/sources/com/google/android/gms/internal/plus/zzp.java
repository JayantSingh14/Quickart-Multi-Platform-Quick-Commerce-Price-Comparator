package com.google.android.gms.internal.plus;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;

/* loaded from: classes4.dex */
abstract class zzp extends Plus.zza<People.LoadPeopleResult> {
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzq(status);
    }
}
