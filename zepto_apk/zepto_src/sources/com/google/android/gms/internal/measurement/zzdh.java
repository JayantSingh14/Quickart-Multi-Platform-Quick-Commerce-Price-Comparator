package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdh extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36839e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f36840f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f36841g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f36842h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ zzfb f36843i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdh(zzfb zzfbVar, String str, String str2, String str3, boolean z) {
        super(zzfbVar, true);
        this.f36839e = str;
        this.f36840f = str2;
        this.f36841g = str3;
        this.f36842h = z;
        Objects.requireNonNull(zzfbVar);
        this.f36843i = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36843i.f36950g)).setUserProperty(this.f36839e, this.f36840f, new ObjectWrapper(this.f36841g), this.f36842h, this.f36917a);
    }
}
