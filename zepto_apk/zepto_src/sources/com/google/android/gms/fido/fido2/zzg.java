package com.google.android.gms.fido.fido2;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzg extends com.google.android.gms.internal.fido.zzq {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f22468a;

    public zzg(TaskCompletionSource taskCompletionSource) {
        this.f22468a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzr
    public final void R(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.f22468a);
    }
}
