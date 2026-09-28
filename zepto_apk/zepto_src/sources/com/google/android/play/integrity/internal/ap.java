package com.google.android.play.integrity.internal;

/* loaded from: classes4.dex */
final class ap extends an {

    /* renamed from: c, reason: collision with root package name */
    public final ar f42173c;

    public ap(ar arVar, int i2) {
        super(arVar.size(), i2);
        this.f42173c = arVar;
    }

    @Override // com.google.android.play.integrity.internal.an
    public final Object a(int i2) {
        return this.f42173c.get(i2);
    }
}
