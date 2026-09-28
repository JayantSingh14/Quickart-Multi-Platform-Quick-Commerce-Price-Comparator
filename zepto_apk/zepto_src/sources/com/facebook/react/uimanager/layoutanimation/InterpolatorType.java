package com.facebook.react.uimanager.layoutanimation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class InterpolatorType {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f19801a;

    /* renamed from: b, reason: collision with root package name */
    public static final InterpolatorType f19802b;

    /* renamed from: c, reason: collision with root package name */
    public static final InterpolatorType f19803c;

    /* renamed from: d, reason: collision with root package name */
    public static final InterpolatorType f19804d;

    /* renamed from: e, reason: collision with root package name */
    public static final InterpolatorType f19805e;

    /* renamed from: f, reason: collision with root package name */
    public static final InterpolatorType f19806f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ InterpolatorType[] f19807g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19808h;

    @Metadata
    public static final class Companion {
    }

    static {
        InterpolatorType interpolatorType = new InterpolatorType("LINEAR", 0);
        f19802b = interpolatorType;
        InterpolatorType interpolatorType2 = new InterpolatorType("EASE_IN", 1);
        f19803c = interpolatorType2;
        InterpolatorType interpolatorType3 = new InterpolatorType("EASE_OUT", 2);
        f19804d = interpolatorType3;
        InterpolatorType interpolatorType4 = new InterpolatorType("EASE_IN_EASE_OUT", 3);
        f19805e = interpolatorType4;
        InterpolatorType interpolatorType5 = new InterpolatorType("SPRING", 4);
        f19806f = interpolatorType5;
        InterpolatorType[] interpolatorTypeArr = {interpolatorType, interpolatorType2, interpolatorType3, interpolatorType4, interpolatorType5};
        f19807g = interpolatorTypeArr;
        f19808h = EnumEntriesKt.a(interpolatorTypeArr);
        f19801a = new Companion();
    }

    public static InterpolatorType valueOf(String str) {
        return (InterpolatorType) Enum.valueOf(InterpolatorType.class, str);
    }

    public static InterpolatorType[] values() {
        return (InterpolatorType[]) f19807g.clone();
    }
}
