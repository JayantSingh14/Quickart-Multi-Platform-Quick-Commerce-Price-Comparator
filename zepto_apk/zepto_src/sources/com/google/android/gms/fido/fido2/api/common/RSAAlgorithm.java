package com.google.android.gms.fido.fido2.api.common;

/* loaded from: classes4.dex */
public enum RSAAlgorithm implements Algorithm {
    /* JADX INFO: Fake field, exist only in values array */
    RS256(-257),
    /* JADX INFO: Fake field, exist only in values array */
    RS384(-258),
    /* JADX INFO: Fake field, exist only in values array */
    RS512(-259),
    /* JADX INFO: Fake field, exist only in values array */
    LEGACY_RS1(-262),
    /* JADX INFO: Fake field, exist only in values array */
    PS256(-37),
    /* JADX INFO: Fake field, exist only in values array */
    PS384(-38),
    /* JADX INFO: Fake field, exist only in values array */
    PS512(-39),
    RS1(-65535);


    /* renamed from: a, reason: collision with root package name */
    public final int f22438a;

    RSAAlgorithm(int i2) {
        this.f22438a = i2;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.Algorithm
    public final int a() {
        return this.f22438a;
    }
}
