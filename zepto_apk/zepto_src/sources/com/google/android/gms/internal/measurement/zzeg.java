package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeg extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzco f36900e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36901f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeg(zzfb zzfbVar, zzco zzcoVar) {
        super(zzfbVar, true);
        this.f36900e = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.f36901f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36901f.f36950g)).getAppInstanceId(this.f36900e);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void b() {
        this.f36900e.b0(null);
    }
}
