package com.google.android.gms.fido.fido2.api.common;

/* loaded from: classes4.dex */
public enum EC2Algorithm implements Algorithm {
    /* JADX INFO: Fake field, exist only in values array */
    ED256(-260),
    /* JADX INFO: Fake field, exist only in values array */
    ED512(-261),
    /* JADX INFO: Fake field, exist only in values array */
    ED25519(-8),
    /* JADX INFO: Fake field, exist only in values array */
    ES256(-7),
    /* JADX INFO: Fake field, exist only in values array */
    ES384(-35),
    /* JADX INFO: Fake field, exist only in values array */
    ES512(-36);


    /* renamed from: a, reason: collision with root package name */
    public final int f22384a;

    EC2Algorithm(int i2) {
        this.f22384a = i2;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.Algorithm
    public final int a() {
        return this.f22384a;
    }
}
