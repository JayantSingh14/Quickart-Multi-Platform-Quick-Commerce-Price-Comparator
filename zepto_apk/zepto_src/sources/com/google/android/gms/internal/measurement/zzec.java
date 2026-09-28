package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzec extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36893e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Exception f36894f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzfb f36895g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzec(zzfb zzfbVar, String str, Exception exc) {
        super(zzfbVar, false);
        this.f36893e = str;
        this.f36894f = exc;
        Objects.requireNonNull(zzfbVar);
        this.f36895g = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36895g.f36950g)).logHealthData(5, this.f36893e, new ObjectWrapper(this.f36894f), new ObjectWrapper(null), new ObjectWrapper(null));
    }
}
