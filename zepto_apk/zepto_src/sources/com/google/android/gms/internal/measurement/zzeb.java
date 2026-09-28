package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeb extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36888e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f36889f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f36890g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzco f36891h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ zzfb f36892i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeb(zzfb zzfbVar, String str, String str2, boolean z, zzco zzcoVar) {
        super(zzfbVar, true);
        this.f36888e = str;
        this.f36889f = str2;
        this.f36890g = z;
        this.f36891h = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.f36892i = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36892i.f36950g)).getUserProperties(this.f36888e, this.f36889f, this.f36890g, this.f36891h);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void b() {
        this.f36891h.b0(null);
    }
}
