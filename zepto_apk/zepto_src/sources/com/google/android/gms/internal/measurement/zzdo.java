package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdo extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f36862e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36863f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdo(zzfb zzfbVar, Bundle bundle) {
        super(zzfbVar, true);
        this.f36862e = bundle;
        Objects.requireNonNull(zzfbVar);
        this.f36863f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36863f.f36950g)).setConsentThirdParty(this.f36862e, this.f36917a);
    }
}
