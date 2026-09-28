package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzcp extends zzj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36649a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.location.zzr f36650b;

    public zzcp(TaskCompletionSource taskCompletionSource, com.google.android.gms.location.zzr zzrVar) {
        this.f36649a = taskCompletionSource;
        this.f36650b = zzrVar;
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void nb(zzg zzgVar) {
        TaskUtil.setResultOrApiException(zzgVar.f36707a, this.f36649a);
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void zze() {
        this.f36650b.zzf();
    }
}
