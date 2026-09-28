package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzef extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36897e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzco f36898f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzfb f36899g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzef(zzfb zzfbVar, String str, zzco zzcoVar) {
        super(zzfbVar, true);
        this.f36897e = str;
        this.f36898f = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.f36899g = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36899g.f36950g)).getMaxUserProperties(this.f36897e, this.f36898f);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void b() {
        this.f36898f.b0(null);
    }
}
