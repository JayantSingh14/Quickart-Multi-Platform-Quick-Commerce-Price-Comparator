package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzen extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzes f36910e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36911f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzen(zzfb zzfbVar, zzes zzesVar) {
        super(zzfbVar, true);
        this.f36910e = zzesVar;
        Objects.requireNonNull(zzfbVar);
        this.f36911f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36911f.f36950g)).registerOnMeasurementEventListener(this.f36910e);
    }
}
