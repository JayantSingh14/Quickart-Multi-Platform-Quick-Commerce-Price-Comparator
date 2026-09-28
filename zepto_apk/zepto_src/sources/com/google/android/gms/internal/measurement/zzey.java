package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzey extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f36933e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzco f36934f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzfa f36935g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzey(zzfa zzfaVar, Activity activity, zzco zzcoVar) {
        super(zzfaVar.f36942a, true);
        this.f36933e = activity;
        this.f36934f = zzcoVar;
        this.f36935g = zzfaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36935g.f36942a.f36950g)).onActivitySaveInstanceStateByScionActivityInfo(zzdf.b(this.f36933e), this.f36934f, this.f36918b);
    }
}
