package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzml extends zzay {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zznk f39414e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzml(zznk zznkVar, zzib zzibVar) {
        super(zzibVar);
        Objects.requireNonNull(zznkVar);
        this.f39414e = zznkVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zznk zznkVar = this.f39414e;
        zznkVar.g();
        if (zznkVar.x()) {
            zzgt zzgtVar = zznkVar.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.a("Inactivity, disconnecting from the service");
            zznkVar.o();
        }
    }
}
