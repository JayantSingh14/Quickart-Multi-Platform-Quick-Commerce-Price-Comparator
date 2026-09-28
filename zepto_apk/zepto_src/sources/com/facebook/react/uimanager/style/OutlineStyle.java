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
public final class OutlineStyle {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f19911a;

    /* renamed from: b, reason: collision with root package name */
    public static final OutlineStyle f19912b;

    /* renamed from: c, reason: collision with root package name */
    public static final OutlineStyle f19913c;

    /* renamed from: d, reason: collision with root package name */
    public static final OutlineStyle f19914d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ OutlineStyle[] f19915e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19916f;

    @Metadata
    public static final class Companion {
    }

    static {
        OutlineStyle outlineStyle = new OutlineStyle("SOLID", 0);
        f19912b = outlineStyle;
        OutlineStyle outlineStyle2 = new OutlineStyle("DASHED", 1);
        f19913c = outlineStyle2;
        OutlineStyle outlineStyle3 = new OutlineStyle("DOTTED", 2);
        f19914d = outlineStyle3;
        OutlineStyle[] outlineStyleArr = {outlineStyle, outlineStyle2, outlineStyle3};
        f19915e = outlineStyleArr;
        f19916f = EnumEntriesKt.a(outlineStyleArr);
        f19911a = new Companion();
    }

    public static final OutlineStyle a(String outlineStyle) {
        f19911a.getClass();
        Intrinsics.checkNotNullParameter(outlineStyle, "outlineStyle");
        String lowerCase = outlineStyle.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode == -1338941519) {
            if (lowerCase.equals("dashed")) {
                return f19913c;
            }
            return null;
        }
        if (iHashCode == -1325970902) {
            if (lowerCase.equals("dotted")) {
                return f19914d;
            }
            return null;
        }
        if (iHashCode == 109618859 && lowerCase.equals("solid")) {
            return f19912b;
        }
        return null;
    }

    public static OutlineStyle valueOf(String str) {
        return (OutlineStyle) Enum.valueOf(OutlineStyle.class, str);
    }

    public static OutlineStyle[] values() {
        return (OutlineStyle[]) f19915e.clone();
    }
}
