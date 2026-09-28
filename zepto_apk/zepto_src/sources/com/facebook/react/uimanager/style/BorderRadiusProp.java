package com.facebook.react.uimanager.style;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class BorderRadiusProp {

    /* renamed from: a, reason: collision with root package name */
    public static final BorderRadiusProp f19836a;

    /* renamed from: b, reason: collision with root package name */
    public static final BorderRadiusProp f19837b;

    /* renamed from: c, reason: collision with root package name */
    public static final BorderRadiusProp f19838c;

    /* renamed from: d, reason: collision with root package name */
    public static final BorderRadiusProp f19839d;

    /* renamed from: e, reason: collision with root package name */
    public static final BorderRadiusProp f19840e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ BorderRadiusProp[] f19841f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19842g;

    static {
        BorderRadiusProp borderRadiusProp = new BorderRadiusProp("BORDER_RADIUS", 0);
        f19836a = borderRadiusProp;
        BorderRadiusProp borderRadiusProp2 = new BorderRadiusProp("BORDER_TOP_LEFT_RADIUS", 1);
        f19837b = borderRadiusProp2;
        BorderRadiusProp borderRadiusProp3 = new BorderRadiusProp("BORDER_TOP_RIGHT_RADIUS", 2);
        f19838c = borderRadiusProp3;
        BorderRadiusProp borderRadiusProp4 = new BorderRadiusProp("BORDER_BOTTOM_RIGHT_RADIUS", 3);
        f19839d = borderRadiusProp4;
        BorderRadiusProp borderRadiusProp5 = new BorderRadiusProp("BORDER_BOTTOM_LEFT_RADIUS", 4);
        f19840e = borderRadiusProp5;
        BorderRadiusProp[] borderRadiusPropArr = {borderRadiusProp, borderRadiusProp2, borderRadiusProp3, borderRadiusProp4, borderRadiusProp5, new BorderRadiusProp("BORDER_TOP_START_RADIUS", 5), new BorderRadiusProp("BORDER_TOP_END_RADIUS", 6), new BorderRadiusProp("BORDER_BOTTOM_START_RADIUS", 7), new BorderRadiusProp("BORDER_BOTTOM_END_RADIUS", 8), new BorderRadiusProp("BORDER_END_END_RADIUS", 9), new BorderRadiusProp("BORDER_END_START_RADIUS", 10), new BorderRadiusProp("BORDER_START_END_RADIUS", 11), new BorderRadiusProp("BORDER_START_START_RADIUS", 12)};
        f19841f = borderRadiusPropArr;
        f19842g = EnumEntriesKt.a(borderRadiusPropArr);
    }

    public static BorderRadiusProp valueOf(String str) {
        return (BorderRadiusProp) Enum.valueOf(BorderRadiusProp.class, str);
    }

    public static BorderRadiusProp[] values() {
        return (BorderRadiusProp[]) f19841f.clone();
    }
}
