package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdj extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36846e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f36847f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Bundle f36848g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzfb f36849h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdj(zzfb zzfbVar, String str, String str2, Bundle bundle) {
        super(zzfbVar, true);
        this.f36846e = str;
        this.f36847f = str2;
        this.f36848g = bundle;
        Objects.requireNonNull(zzfbVar);
        this.f36849h = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36849h.f36950g)).clearConditionalUserProperty(this.f36846e, this.f36847f, this.f36848g);
    }
}
