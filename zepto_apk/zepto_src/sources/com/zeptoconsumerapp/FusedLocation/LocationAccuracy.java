package com.zeptoconsumerapp.FusedLocation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class LocationAccuracy {

    /* renamed from: a, reason: collision with root package name */
    public static final LocationAccuracy f47450a;

    /* renamed from: b, reason: collision with root package name */
    public static final LocationAccuracy f47451b;

    /* renamed from: c, reason: collision with root package name */
    public static final LocationAccuracy f47452c;

    /* renamed from: d, reason: collision with root package name */
    public static final LocationAccuracy f47453d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ LocationAccuracy[] f47454e;

    static {
        LocationAccuracy locationAccuracy = new LocationAccuracy("high", 0);
        f47450a = locationAccuracy;
        LocationAccuracy locationAccuracy2 = new LocationAccuracy("balanced", 1);
        f47451b = locationAccuracy2;
        LocationAccuracy locationAccuracy3 = new LocationAccuracy("low", 2);
        f47452c = locationAccuracy3;
        LocationAccuracy locationAccuracy4 = new LocationAccuracy("passive", 3);
        f47453d = locationAccuracy4;
        f47454e = new LocationAccuracy[]{locationAccuracy, locationAccuracy2, locationAccuracy3, locationAccuracy4};
    }

    public static LocationAccuracy valueOf(String str) {
        return (LocationAccuracy) Enum.valueOf(LocationAccuracy.class, str);
    }

    public static LocationAccuracy[] values() {
        return (LocationAccuracy[]) f47454e.clone();
    }
}
