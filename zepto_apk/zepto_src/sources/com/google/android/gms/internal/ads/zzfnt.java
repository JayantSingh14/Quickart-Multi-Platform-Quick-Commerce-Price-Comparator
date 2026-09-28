package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public enum zzfnt implements zziav {
    SCAR_REQUEST_TYPE_ADMOB(0),
    SCAR_REQUEST_TYPE_UNSPECIFIED(-1),
    SCAR_REQUEST_TYPE_INBOUND_MEDIATION(1),
    SCAR_REQUEST_TYPE_GBID(2),
    SCAR_REQUEST_TYPE_GOLDENEYE(3),
    SCAR_REQUEST_TYPE_YAVIN(4),
    SCAR_REQUEST_TYPE_UNITY(5),
    SCAR_REQUEST_TYPE_PAW(6),
    SCAR_REQUEST_TYPE_GUILDER(7),
    SCAR_REQUEST_TYPE_GAM_S2S(8),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f31513a;

    zzfnt(int i2) {
        this.f31513a = i2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f31513a);
    }

    @Override // com.google.android.gms.internal.ads.zziav
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.f31513a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
