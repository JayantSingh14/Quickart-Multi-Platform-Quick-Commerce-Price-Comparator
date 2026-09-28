package com.agontuk.RNFusedLocation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class LocationAccuracy {

    /* renamed from: a, reason: collision with root package name */
    public static final LocationAccuracy f14043a;

    /* renamed from: b, reason: collision with root package name */
    public static final LocationAccuracy f14044b;

    /* renamed from: c, reason: collision with root package name */
    public static final LocationAccuracy f14045c;

    /* renamed from: d, reason: collision with root package name */
    public static final LocationAccuracy f14046d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ LocationAccuracy[] f14047e;

    static {
        LocationAccuracy locationAccuracy = new LocationAccuracy("high", 0);
        f14043a = locationAccuracy;
        LocationAccuracy locationAccuracy2 = new LocationAccuracy("balanced", 1);
        f14044b = locationAccuracy2;
        LocationAccuracy locationAccuracy3 = new LocationAccuracy("low", 2);
        f14045c = locationAccuracy3;
        LocationAccuracy locationAccuracy4 = new LocationAccuracy("passive", 3);
        f14046d = locationAccuracy4;
        f14047e = new LocationAccuracy[]{locationAccuracy, locationAccuracy2, locationAccuracy3, locationAccuracy4};
    }

    public static LocationAccuracy valueOf(String str) {
        return (LocationAccuracy) Enum.valueOf(LocationAccuracy.class, str);
    }

    public static LocationAccuracy[] values() {
        return (LocationAccuracy[]) f14047e.clone();
    }
}
