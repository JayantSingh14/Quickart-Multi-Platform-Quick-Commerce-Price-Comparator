package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdq extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f36865e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36866f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdq(zzfb zzfbVar, long j2) {
        super(zzfbVar, true);
        this.f36865e = j2;
        Objects.requireNonNull(zzfbVar);
        this.f36866f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36866f.f36950g)).setSessionTimeoutDuration(this.f36865e);
    }
}
