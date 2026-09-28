package com.google.android.gms.fido.fido2;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzr extends com.google.android.gms.internal.fido.zzl {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f22473a;

    public zzr(TaskCompletionSource taskCompletionSource) {
        this.f22473a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzm
    public final void R(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.f22473a);
    }
}
