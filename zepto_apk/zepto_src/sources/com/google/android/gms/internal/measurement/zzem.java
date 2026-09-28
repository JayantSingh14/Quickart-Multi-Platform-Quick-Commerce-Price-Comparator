package com.google.android.gms.internal.measurement;

import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzem extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Intent f36908e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36909f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzem(zzfb zzfbVar, Intent intent) {
        super(zzfbVar, true);
        this.f36908e = intent;
        Objects.requireNonNull(zzfbVar);
        this.f36909f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36909f.f36950g)).setSgtmDebugInfo(this.f36908e);
    }
}
