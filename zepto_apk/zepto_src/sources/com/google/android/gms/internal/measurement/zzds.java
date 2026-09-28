package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzds extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36870e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36871f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzds(zzfb zzfbVar, String str) {
        super(zzfbVar, true);
        this.f36870e = str;
        Objects.requireNonNull(zzfbVar);
        this.f36871f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36871f.f36950g)).beginAdUnitExposure(this.f36870e, this.f36918b);
    }
}
