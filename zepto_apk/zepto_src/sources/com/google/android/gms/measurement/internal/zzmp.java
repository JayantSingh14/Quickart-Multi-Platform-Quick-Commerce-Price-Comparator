package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzmp extends zzay {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zznk f39426e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmp(zznk zznkVar, zzib zzibVar) {
        super(zzibVar);
        Objects.requireNonNull(zznkVar);
        this.f39426e = zznkVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zzgt zzgtVar = this.f39426e.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38961i.a("Tasks have been queued for a long time");
    }
}
