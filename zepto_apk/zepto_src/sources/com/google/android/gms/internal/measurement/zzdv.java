package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdv extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f36875e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfb f36876f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdv(zzfb zzfbVar, Runnable runnable) {
        super(zzfbVar, true);
        this.f36875e = runnable;
        Objects.requireNonNull(zzfbVar);
        this.f36876f = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36876f.f36950g)).retrieveAndUploadBatches(new zzdu(this, this.f36875e));
    }
}
