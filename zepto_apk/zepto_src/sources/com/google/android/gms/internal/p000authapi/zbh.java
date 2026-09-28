package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public abstract class zbh extends zbb implements zbi {
    public zbh() {
        super("com.google.android.gms.auth.api.identity.internal.IAuthorizationCallback");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) zbc.a(parcel, Status.CREATOR);
        AuthorizationResult authorizationResult = (AuthorizationResult) zbc.a(parcel, AuthorizationResult.CREATOR);
        zbc.b(parcel);
        boolean zIsSuccess = status.isSuccess();
        TaskCompletionSource taskCompletionSource = ((zby) this).f36275a;
        if (zIsSuccess) {
            taskCompletionSource.b(authorizationResult);
            return true;
        }
        taskCompletionSource.a(ApiExceptionUtil.fromStatus(status));
        return true;
    }
}
