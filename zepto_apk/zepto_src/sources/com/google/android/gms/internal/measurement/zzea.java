package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzea extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzco f36886e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36887f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzea(zzfb zzfbVar, zzco zzcoVar) {
        super(zzfbVar, true);
        this.f36886e = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.f36887f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36887f.f36950g)).getCurrentScreenClass(this.f36886e);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void b() {
        this.f36886e.b0(null);
    }
}
