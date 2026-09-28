package com.facebook.react.uimanager.style;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class Overflow {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f19917a;

    /* renamed from: b, reason: collision with root package name */
    public static final Overflow f19918b;

    /* renamed from: c, reason: collision with root package name */
    public static final Overflow f19919c;

    /* renamed from: d, reason: collision with root package name */
    public static final Overflow f19920d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ Overflow[] f19921e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19922f;

    @Metadata
    public static final class Companion {
    }

    static {
        Overflow overflow = new Overflow("VISIBLE", 0);
        f19918b = overflow;
        Overflow overflow2 = new Overflow("HIDDEN", 1);
        f19919c = overflow2;
        Overflow overflow3 = new Overflow("SCROLL", 2);
        f19920d = overflow3;
        Overflow[] overflowArr = {overflow, overflow2, overflow3};
        f19921e = overflowArr;
        f19922f = EnumEntriesKt.a(overflowArr);
        f19917a = new Companion();
    }

    public static final Overflow a(String overflow) {
        f19917a.getClass();
        Intrinsics.checkNotNullParameter(overflow, "overflow");
        String lowerCase = overflow.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode == -1217487446) {
            if (lowerCase.equals("hidden")) {
                return f19919c;
            }
            return null;
        }
        if (iHashCode == -907680051) {
            if (lowerCase.equals("scroll")) {
                return f19920d;
            }
            return null;
        }
        if (iHashCode == 466743410 && lowerCase.equals("visible")) {
            return f19918b;
        }
        return null;
    }

    public static Overflow valueOf(String str) {
        return (Overflow) Enum.valueOf(Overflow.class, str);
    }

    public static Overflow[] values() {
        return (Overflow[]) f19921e.clone();
    }
}
