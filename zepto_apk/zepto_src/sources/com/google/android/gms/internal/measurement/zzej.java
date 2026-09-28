package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzej extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f36904e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36905f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzej(zzfb zzfbVar, boolean z) {
        super(zzfbVar, true);
        this.f36904e = z;
        Objects.requireNonNull(zzfbVar);
        this.f36905f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36905f.f36950g)).setDataCollectionEnabled(this.f36904e);
    }
}
