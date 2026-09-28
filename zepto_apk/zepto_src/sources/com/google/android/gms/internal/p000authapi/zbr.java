package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public abstract class zbr extends zbb implements zbs {
    public zbr() {
        super("com.google.android.gms.auth.api.identity.internal.ISaveAccountLinkingTokenCallback");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) zbc.a(parcel, Status.CREATOR);
        SaveAccountLinkingTokenResult saveAccountLinkingTokenResult = (SaveAccountLinkingTokenResult) zbc.a(parcel, SaveAccountLinkingTokenResult.CREATOR);
        zbc.b(parcel);
        boolean zIsSuccess = status.isSuccess();
        TaskCompletionSource taskCompletionSource = ((zbad) this).f36258a;
        if (zIsSuccess) {
            taskCompletionSource.b(saveAccountLinkingTokenResult);
            return true;
        }
        taskCompletionSource.a(ApiExceptionUtil.fromStatus(status));
        return true;
    }
}
