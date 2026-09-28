package com.google.android.play.core.integrity;

/* loaded from: classes4.dex */
public final class au implements com.google.android.play.integrity.internal.ay {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.az f41790a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.ay f41791b;

    public au(com.google.android.play.integrity.internal.az azVar, com.google.android.play.integrity.internal.ay ayVar) {
        this.f41790a = azVar;
        this.f41791b = ayVar;
    }

    @Override // com.google.android.play.integrity.internal.bd
    public final Object a() {
        return new at(this.f41790a, this.f41791b);
    }
}
