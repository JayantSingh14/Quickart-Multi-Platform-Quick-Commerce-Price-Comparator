package com.agontuk.RNFusedLocation;

/* loaded from: classes.dex */
public enum LocationError {
    PERMISSION_DENIED(1),
    POSITION_UNAVAILABLE(2),
    TIMEOUT(3),
    /* JADX INFO: Fake field, exist only in values array */
    PLAY_SERVICE_NOT_AVAILABLE(4),
    SETTINGS_NOT_SATISFIED(5),
    INTERNAL_ERROR(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f14054a;

    LocationError(int i2) {
        this.f14054a = i2;
    }
}
