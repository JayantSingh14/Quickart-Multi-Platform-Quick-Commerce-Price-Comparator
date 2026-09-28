package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdy extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzco f36881e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36882f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdy(zzfb zzfbVar, zzco zzcoVar) {
        super(zzfbVar, true);
        this.f36881e = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.f36882f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36882f.f36950g)).generateEventId(this.f36881e);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void b() {
        this.f36881e.b0(null);
    }
}
