package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzdn extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Boolean f36860e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36861f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdn(zzfb zzfbVar, Boolean bool) {
        super(zzfbVar, true);
        this.f36860e = bool;
        Objects.requireNonNull(zzfbVar);
        this.f36861f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36861f.f36950g)).setMeasurementEnabled(this.f36860e.booleanValue(), this.f36917a);
    }
}
