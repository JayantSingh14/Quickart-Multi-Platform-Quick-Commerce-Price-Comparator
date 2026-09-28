package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzev extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f36927e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfa f36928f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzev(zzfa zzfaVar, Activity activity) {
        super(zzfaVar.f36942a, true);
        this.f36927e = activity;
        this.f36928f = zzfaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36928f.f36942a.f36950g)).onActivityResumedByScionActivityInfo(zzdf.b(this.f36927e), this.f36918b);
    }
}
