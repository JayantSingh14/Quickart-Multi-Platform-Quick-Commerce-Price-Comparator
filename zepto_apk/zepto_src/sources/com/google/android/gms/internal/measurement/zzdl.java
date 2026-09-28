package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdl extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36854e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36855f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdl(zzfb zzfbVar, String str) {
        super(zzfbVar, true);
        this.f36854e = str;
        Objects.requireNonNull(zzfbVar);
        this.f36855f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36855f.f36950g)).setUserId(this.f36854e, this.f36917a);
    }
}
