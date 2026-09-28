package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzac extends IStatusCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36244a;

    public zzac(TaskCompletionSource taskCompletionSource) {
        this.f36244a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        int statusCode = status.getStatusCode();
        TaskCompletionSource taskCompletionSource = this.f36244a;
        if (statusCode == 6) {
            taskCompletionSource.c(ApiExceptionUtil.fromStatus(status));
        } else {
            TaskUtil.setResultOrApiException(status, taskCompletionSource);
        }
    }
}
