package com.google.android.gms.fido.u2f;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.fido.zzt;
import com.google.android.gms.internal.fido.zzu;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzd extends zzu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f22530a;

    public zzd(TaskCompletionSource taskCompletionSource) {
        this.f22530a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzv
    public final void R(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, new zzt(), this.f22530a);
    }
}
