package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    /* JADX INFO: Fake field, exist only in values array */
    USER_SIDELOAD(2),
    /* JADX INFO: Fake field, exist only in values array */
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* renamed from: a, reason: collision with root package name */
    public final int f43815a;

    DeliveryMechanism(int i2) {
        this.f43815a = i2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f43815a);
    }
}
