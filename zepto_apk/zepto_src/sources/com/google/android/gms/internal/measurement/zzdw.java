package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdw extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzco f36877e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36878f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdw(zzfb zzfbVar, zzco zzcoVar) {
        super(zzfbVar, true);
        this.f36877e = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.f36878f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36878f.f36950g)).getGmpAppId(this.f36877e);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void b() {
        this.f36877e.b0(null);
    }
}
