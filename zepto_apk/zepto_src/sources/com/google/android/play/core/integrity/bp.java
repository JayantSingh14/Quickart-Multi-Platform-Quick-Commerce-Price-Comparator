package com.google.android.play.core.integrity;

/* loaded from: classes4.dex */
public final class bp implements com.google.android.play.integrity.internal.ay {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.az f41823a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.ax f41824b;

    /* renamed from: c, reason: collision with root package name */
    public final au f41825c;

    public bp(com.google.android.play.integrity.internal.az azVar, com.google.android.play.integrity.internal.ax axVar, au auVar) {
        this.f41823a = azVar;
        this.f41824b = axVar;
        this.f41825c = auVar;
    }

    @Override // com.google.android.play.integrity.internal.bd
    public final Object a() {
        com.google.android.play.integrity.internal.az azVar = this.f41823a;
        com.google.android.play.integrity.internal.s sVar = (com.google.android.play.integrity.internal.s) this.f41824b.a();
        au auVar = this.f41825c;
        return new bn(azVar.f42188a, sVar, new at(auVar.f41790a, auVar.f41791b), new j());
    }
}
