package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdk extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36850e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f36851f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzco f36852g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzfb f36853h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdk(zzfb zzfbVar, String str, String str2, zzco zzcoVar) {
        super(zzfbVar, true);
        this.f36850e = str;
        this.f36851f = str2;
        this.f36852g = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.f36853h = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36853h.f36950g)).getConditionalUserProperties(this.f36850e, this.f36851f, this.f36852g);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void b() {
        this.f36852g.b0(null);
    }
}
