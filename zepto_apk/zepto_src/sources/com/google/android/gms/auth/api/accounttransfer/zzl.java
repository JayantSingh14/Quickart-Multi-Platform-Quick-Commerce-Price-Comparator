package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.auth.zzap;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
abstract class zzl extends TaskApiCall {

    /* renamed from: a, reason: collision with root package name */
    public TaskCompletionSource f22033a;

    public abstract void a(zzau zzauVar);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f22033a = taskCompletionSource;
        a((zzau) ((zzap) anyClient).getService());
    }
}
