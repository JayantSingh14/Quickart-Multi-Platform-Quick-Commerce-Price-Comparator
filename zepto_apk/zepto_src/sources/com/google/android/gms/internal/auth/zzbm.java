package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzbm extends zzbd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36303a;

    public zzbm(TaskCompletionSource taskCompletionSource) {
        this.f36303a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void x1(ProxyResponse proxyResponse) {
        TaskUtil.setResultOrApiException(new Status(proxyResponse.f22145a), proxyResponse, this.f36303a);
    }
}
