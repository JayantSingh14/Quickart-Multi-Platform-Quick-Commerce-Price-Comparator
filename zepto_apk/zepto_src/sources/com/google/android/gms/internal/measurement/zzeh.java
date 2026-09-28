package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeh extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzco f36902e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36903f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeh(zzfb zzfbVar, zzco zzcoVar) {
        super(zzfbVar, true);
        this.f36902e = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.f36903f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36903f.f36950g)).getSessionId(this.f36902e);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void b() {
        this.f36902e.b0(null);
    }
}
