package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzcn extends zzj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f36647a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36648b;

    public zzcn(Boolean bool, TaskCompletionSource taskCompletionSource) {
        this.f36647a = bool;
        this.f36648b = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void nb(zzg zzgVar) {
        TaskUtil.setResultOrApiException(zzgVar.f36707a, this.f36647a, this.f36648b);
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void zze() {
    }
}
