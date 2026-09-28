package com.google.android.gms.internal.auth;

import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzab extends GoogleApi implements zzg {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f36279a;

    static {
        new Api("GoogleAuthService.API", new zzv(), new Api.ClientKey());
        f36279a = new Logger("Auth", "GoogleAuthServiceClient");
    }

    public static /* bridge */ /* synthetic */ void b(Status status, Parcelable parcelable, TaskCompletionSource taskCompletionSource) {
        if (TaskUtil.trySetResultOrApiException(status, parcelable, taskCompletionSource)) {
            return;
        }
        f36279a.w("The task is already complete.", new Object[0]);
    }
}
