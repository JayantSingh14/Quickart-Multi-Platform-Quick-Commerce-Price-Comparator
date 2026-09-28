package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzek extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f36906e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36907f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzek(zzfb zzfbVar, Bundle bundle) {
        super(zzfbVar, true);
        this.f36906e = bundle;
        Objects.requireNonNull(zzfbVar);
        this.f36907f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36907f.f36950g)).setDefaultEventParameters(this.f36906e);
    }
}
