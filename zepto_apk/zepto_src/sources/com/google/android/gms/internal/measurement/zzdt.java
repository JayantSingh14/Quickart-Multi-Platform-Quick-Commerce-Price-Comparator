package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdt extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36872e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36873f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdt(zzfb zzfbVar, String str) {
        super(zzfbVar, true);
        this.f36872e = str;
        Objects.requireNonNull(zzfbVar);
        this.f36873f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36873f.f36950g)).endAdUnitExposure(this.f36872e, this.f36918b);
    }
}
