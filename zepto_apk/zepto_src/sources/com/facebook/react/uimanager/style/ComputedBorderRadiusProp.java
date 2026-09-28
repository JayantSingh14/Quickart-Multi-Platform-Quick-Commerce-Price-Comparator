package com.facebook.react.uimanager.style;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ComputedBorderRadiusProp {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComputedBorderRadiusProp[] f19877a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19878b;

    static {
        ComputedBorderRadiusProp[] computedBorderRadiusPropArr = {new ComputedBorderRadiusProp("COMPUTED_BORDER_TOP_LEFT_RADIUS", 0), new ComputedBorderRadiusProp("COMPUTED_BORDER_TOP_RIGHT_RADIUS", 1), new ComputedBorderRadiusProp("COMPUTED_BORDER_BOTTOM_RIGHT_RADIUS", 2), new ComputedBorderRadiusProp("COMPUTED_BORDER_BOTTOM_LEFT_RADIUS", 3)};
        f19877a = computedBorderRadiusPropArr;
        f19878b = EnumEntriesKt.a(computedBorderRadiusPropArr);
    }

    public static ComputedBorderRadiusProp valueOf(String str) {
        return (ComputedBorderRadiusProp) Enum.valueOf(ComputedBorderRadiusProp.class, str);
    }

    public static ComputedBorderRadiusProp[] values() {
        return (ComputedBorderRadiusProp[]) f19877a.clone();
    }
}
