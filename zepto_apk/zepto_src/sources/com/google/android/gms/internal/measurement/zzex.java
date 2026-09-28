package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzex extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f36931e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfa f36932f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzex(zzfa zzfaVar, Activity activity) {
        super(zzfaVar.f36942a, true);
        this.f36931e = activity;
        this.f36932f = zzfaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36932f.f36942a.f36950g)).onActivityStoppedByScionActivityInfo(zzdf.b(this.f36931e), this.f36918b);
    }
}
