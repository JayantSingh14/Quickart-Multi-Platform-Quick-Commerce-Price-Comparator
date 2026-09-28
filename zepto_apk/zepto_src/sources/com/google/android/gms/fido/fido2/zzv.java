package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class zzv extends com.google.android.gms.internal.fido.zzf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f22477a;

    public zzv(TaskCompletionSource taskCompletionSource) {
        this.f22477a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzg
    public final void M0(Status status) {
        this.f22477a.c(new ApiException(status));
    }

    @Override // com.google.android.gms.internal.fido.zzg
    public final void y2(ArrayList arrayList) {
        this.f22477a.b(arrayList);
    }
}
