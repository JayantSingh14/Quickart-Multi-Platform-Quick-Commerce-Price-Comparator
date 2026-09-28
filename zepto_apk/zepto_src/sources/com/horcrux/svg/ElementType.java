package com.horcrux.svg;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class ElementType {

    /* renamed from: a, reason: collision with root package name */
    public static final ElementType f45651a;

    /* renamed from: b, reason: collision with root package name */
    public static final ElementType f45652b;

    /* renamed from: c, reason: collision with root package name */
    public static final ElementType f45653c;

    /* renamed from: d, reason: collision with root package name */
    public static final ElementType f45654d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ ElementType[] f45655e;

    static {
        ElementType elementType = new ElementType("kCGPathElementAddCurveToPoint", 0);
        f45651a = elementType;
        ElementType elementType2 = new ElementType("kCGPathElementAddQuadCurveToPoint", 1);
        ElementType elementType3 = new ElementType("kCGPathElementMoveToPoint", 2);
        f45652b = elementType3;
        ElementType elementType4 = new ElementType("kCGPathElementAddLineToPoint", 3);
        f45653c = elementType4;
        ElementType elementType5 = new ElementType("kCGPathElementCloseSubpath", 4);
        f45654d = elementType5;
        f45655e = new ElementType[]{elementType, elementType2, elementType3, elementType4, elementType5};
    }

    public static ElementType valueOf(String str) {
        return (ElementType) Enum.valueOf(ElementType.class, str);
    }

    public static ElementType[] values() {
        return (ElementType[]) f45655e.clone();
    }
}
