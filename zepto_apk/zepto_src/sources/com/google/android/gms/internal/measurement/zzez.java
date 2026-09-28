package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzez extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f36936e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfa f36937f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzez(zzfa zzfaVar, Activity activity) {
        super(zzfaVar.f36942a, true);
        this.f36936e = activity;
        this.f36937f = zzfaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36937f.f36942a.f36950g)).onActivityDestroyedByScionActivityInfo(zzdf.b(this.f36936e), this.f36918b);
    }
}
