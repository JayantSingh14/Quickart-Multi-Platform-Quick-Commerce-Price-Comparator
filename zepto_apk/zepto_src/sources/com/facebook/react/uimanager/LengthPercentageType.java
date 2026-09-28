package com.facebook.react.uimanager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class LengthPercentageType {

    /* renamed from: a, reason: collision with root package name */
    public static final LengthPercentageType f19394a;

    /* renamed from: b, reason: collision with root package name */
    public static final LengthPercentageType f19395b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ LengthPercentageType[] f19396c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19397d;

    static {
        LengthPercentageType lengthPercentageType = new LengthPercentageType("POINT", 0);
        f19394a = lengthPercentageType;
        LengthPercentageType lengthPercentageType2 = new LengthPercentageType("PERCENT", 1);
        f19395b = lengthPercentageType2;
        LengthPercentageType[] lengthPercentageTypeArr = {lengthPercentageType, lengthPercentageType2};
        f19396c = lengthPercentageTypeArr;
        f19397d = EnumEntriesKt.a(lengthPercentageTypeArr);
    }

    public static LengthPercentageType valueOf(String str) {
        return (LengthPercentageType) Enum.valueOf(LengthPercentageType.class, str);
    }

    public static LengthPercentageType[] values() {
        return (LengthPercentageType[]) f19396c.clone();
    }
}
