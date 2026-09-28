package com.facebook.react.uimanager.layoutanimation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class AnimatedPropertyType {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f19793a;

    /* renamed from: b, reason: collision with root package name */
    public static final AnimatedPropertyType f19794b;

    /* renamed from: c, reason: collision with root package name */
    public static final AnimatedPropertyType f19795c;

    /* renamed from: d, reason: collision with root package name */
    public static final AnimatedPropertyType f19796d;

    /* renamed from: e, reason: collision with root package name */
    public static final AnimatedPropertyType f19797e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AnimatedPropertyType[] f19798f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19799g;

    @Metadata
    public static final class Companion {
    }

    static {
        AnimatedPropertyType animatedPropertyType = new AnimatedPropertyType("OPACITY", 0);
        f19794b = animatedPropertyType;
        AnimatedPropertyType animatedPropertyType2 = new AnimatedPropertyType("SCALE_X", 1);
        f19795c = animatedPropertyType2;
        AnimatedPropertyType animatedPropertyType3 = new AnimatedPropertyType("SCALE_Y", 2);
        f19796d = animatedPropertyType3;
        AnimatedPropertyType animatedPropertyType4 = new AnimatedPropertyType("SCALE_XY", 3);
        f19797e = animatedPropertyType4;
        AnimatedPropertyType[] animatedPropertyTypeArr = {animatedPropertyType, animatedPropertyType2, animatedPropertyType3, animatedPropertyType4};
        f19798f = animatedPropertyTypeArr;
        f19799g = EnumEntriesKt.a(animatedPropertyTypeArr);
        f19793a = new Companion();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final AnimatedPropertyType a(String name) {
        f19793a.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        switch (name.hashCode()) {
            case -1267206133:
                if (name.equals("opacity")) {
                    return f19794b;
                }
                break;
            case -908189618:
                if (name.equals("scaleX")) {
                    return f19795c;
                }
                break;
            case -908189617:
                if (name.equals("scaleY")) {
                    return f19796d;
                }
                break;
            case 1910893003:
                if (name.equals("scaleXY")) {
                    return f19797e;
                }
                break;
        }
        throw new IllegalArgumentException("Unsupported animated property: ".concat(name));
    }

    public static AnimatedPropertyType valueOf(String str) {
        return (AnimatedPropertyType) Enum.valueOf(AnimatedPropertyType.class, str);
    }

    public static AnimatedPropertyType[] values() {
        return (AnimatedPropertyType[]) f19798f.clone();
    }
}
