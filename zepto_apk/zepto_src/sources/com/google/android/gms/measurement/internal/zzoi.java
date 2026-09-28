package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzoi extends zzay {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzoj f39547e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzoi(zzoj zzojVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zzojVar);
        this.f39547e = zzojVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zzoj zzojVar = this.f39547e;
        zzojVar.k();
        zzgt zzgtVar = zzojVar.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.n.a("Starting upload from DelayedRunnable");
        zzojVar.f39551b.q();
    }
}
