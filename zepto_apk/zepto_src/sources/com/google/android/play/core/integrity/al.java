package com.google.android.play.core.integrity;

/* loaded from: classes4.dex */
public final class al implements com.google.android.play.integrity.internal.ay {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.az f41781a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.ax f41782b;

    /* renamed from: c, reason: collision with root package name */
    public final au f41783c;

    public al(com.google.android.play.integrity.internal.az azVar, com.google.android.play.integrity.internal.ax axVar, au auVar) {
        this.f41781a = azVar;
        this.f41782b = axVar;
        this.f41783c = auVar;
    }

    @Override // com.google.android.play.integrity.internal.bd
    public final Object a() {
        com.google.android.play.integrity.internal.az azVar = this.f41781a;
        com.google.android.play.integrity.internal.s sVar = (com.google.android.play.integrity.internal.s) this.f41782b.a();
        au auVar = this.f41783c;
        return new aj(azVar.f42188a, sVar, new at(auVar.f41790a, auVar.f41791b), new i());
    }
}
