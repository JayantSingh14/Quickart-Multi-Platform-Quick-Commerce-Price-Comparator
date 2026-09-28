package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzbe implements RemoteCall {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzbe f36632a = new zzbe();

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        new LastLocationRequest.Builder();
        ((zzda) obj).g(new LastLocationRequest(Long.MAX_VALUE, 0, false, null, null), (TaskCompletionSource) obj2);
    }
}
