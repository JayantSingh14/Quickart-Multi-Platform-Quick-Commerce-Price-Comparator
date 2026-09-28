package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdi extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f36844e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36845f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdi(zzfb zzfbVar, Bundle bundle) {
        super(zzfbVar, true);
        this.f36844e = bundle;
        Objects.requireNonNull(zzfbVar);
        this.f36845f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36845f.f36950g)).setConditionalUserProperty(this.f36844e, this.f36917a);
    }
}
