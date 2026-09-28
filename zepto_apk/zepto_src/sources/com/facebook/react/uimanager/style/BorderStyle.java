package com.facebook.react.uimanager.style;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class BorderStyle {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f19856a;

    /* renamed from: b, reason: collision with root package name */
    public static final BorderStyle f19857b;

    /* renamed from: c, reason: collision with root package name */
    public static final BorderStyle f19858c;

    /* renamed from: d, reason: collision with root package name */
    public static final BorderStyle f19859d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ BorderStyle[] f19860e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19861f;

    @Metadata
    public static final class Companion {
        public static BorderStyle a(String borderStyle) {
            Intrinsics.checkNotNullParameter(borderStyle, "borderStyle");
            String lowerCase = borderStyle.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode == -1338941519) {
                if (lowerCase.equals("dashed")) {
                    return BorderStyle.f19858c;
                }
                return null;
            }
            if (iHashCode == -1325970902) {
                if (lowerCase.equals("dotted")) {
                    return BorderStyle.f19859d;
                }
                return null;
            }
            if (iHashCode == 109618859 && lowerCase.equals("solid")) {
                return BorderStyle.f19857b;
            }
            return null;
        }
    }

    static {
        BorderStyle borderStyle = new BorderStyle("SOLID", 0);
        f19857b = borderStyle;
        BorderStyle borderStyle2 = new BorderStyle("DASHED", 1);
        f19858c = borderStyle2;
        BorderStyle borderStyle3 = new BorderStyle("DOTTED", 2);
        f19859d = borderStyle3;
        BorderStyle[] borderStyleArr = {borderStyle, borderStyle2, borderStyle3};
        f19860e = borderStyleArr;
        f19861f = EnumEntriesKt.a(borderStyleArr);
        f19856a = new Companion();
    }

    public static final BorderStyle a(String str) {
        f19856a.getClass();
        return Companion.a(str);
    }

    public static BorderStyle valueOf(String str) {
        return (BorderStyle) Enum.valueOf(BorderStyle.class, str);
    }

    public static BorderStyle[] values() {
        return (BorderStyle[]) f19860e.clone();
    }
}
