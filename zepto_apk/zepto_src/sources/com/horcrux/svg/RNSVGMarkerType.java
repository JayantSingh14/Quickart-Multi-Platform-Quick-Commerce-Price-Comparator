package com.horcrux.svg;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class RNSVGMarkerType {

    /* renamed from: a, reason: collision with root package name */
    public static final RNSVGMarkerType f45831a;

    /* renamed from: b, reason: collision with root package name */
    public static final RNSVGMarkerType f45832b;

    /* renamed from: c, reason: collision with root package name */
    public static final RNSVGMarkerType f45833c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ RNSVGMarkerType[] f45834d;

    static {
        RNSVGMarkerType rNSVGMarkerType = new RNSVGMarkerType("kStartMarker", 0);
        f45831a = rNSVGMarkerType;
        RNSVGMarkerType rNSVGMarkerType2 = new RNSVGMarkerType("kMidMarker", 1);
        f45832b = rNSVGMarkerType2;
        RNSVGMarkerType rNSVGMarkerType3 = new RNSVGMarkerType("kEndMarker", 2);
        f45833c = rNSVGMarkerType3;
        f45834d = new RNSVGMarkerType[]{rNSVGMarkerType, rNSVGMarkerType2, rNSVGMarkerType3};
    }

    public static RNSVGMarkerType valueOf(String str) {
        return (RNSVGMarkerType) Enum.valueOf(RNSVGMarkerType.class, str);
    }

    public static RNSVGMarkerType[] values() {
        return (RNSVGMarkerType[]) f45834d.clone();
    }
}
