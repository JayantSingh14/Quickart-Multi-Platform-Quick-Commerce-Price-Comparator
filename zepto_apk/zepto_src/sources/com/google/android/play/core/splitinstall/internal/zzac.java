package com.google.android.play.core.splitinstall.internal;

/* loaded from: classes4.dex */
final class zzac extends zzv {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzae f41938b;

    public zzac(zzae zzaeVar) {
        this.f41938b = zzaeVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzv
    public final void a() {
        zzaf zzafVar = this.f41938b.f41939a;
        zzafVar.f41941b.d("unlinkToDeath", new Object[0]);
        zzafVar.f41952m.asBinder().unlinkToDeath(zzafVar.f41949j, 0);
        zzafVar.f41952m = null;
        zzafVar.f41946g = false;
    }
}
