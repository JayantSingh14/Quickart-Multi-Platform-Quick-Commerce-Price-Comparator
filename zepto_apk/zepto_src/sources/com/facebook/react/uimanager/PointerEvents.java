package com.facebook.react.uimanager;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class PointerEvents {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f19424a;

    /* renamed from: b, reason: collision with root package name */
    public static final PointerEvents f19425b;

    /* renamed from: c, reason: collision with root package name */
    public static final PointerEvents f19426c;

    /* renamed from: d, reason: collision with root package name */
    public static final PointerEvents f19427d;

    /* renamed from: e, reason: collision with root package name */
    public static final PointerEvents f19428e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ PointerEvents[] f19429f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19430g;

    @Metadata
    public static final class Companion {
        public static PointerEvents a(String str) {
            if (str == null) {
                return PointerEvents.f19428e;
            }
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return PointerEvents.valueOf(StringsKt.K(upperCase, "-", Attributes.PREDEFINED_ATTRIBUTE_PREFIX));
        }
    }

    static {
        PointerEvents pointerEvents = new PointerEvents("NONE", 0);
        f19425b = pointerEvents;
        PointerEvents pointerEvents2 = new PointerEvents("BOX_NONE", 1);
        f19426c = pointerEvents2;
        PointerEvents pointerEvents3 = new PointerEvents("BOX_ONLY", 2);
        f19427d = pointerEvents3;
        PointerEvents pointerEvents4 = new PointerEvents(RegionUtil.REGION_STRING_AUTO, 3);
        f19428e = pointerEvents4;
        PointerEvents[] pointerEventsArr = {pointerEvents, pointerEvents2, pointerEvents3, pointerEvents4};
        f19429f = pointerEventsArr;
        f19430g = EnumEntriesKt.a(pointerEventsArr);
        f19424a = new Companion();
    }

    public static final boolean a(PointerEvents pointerEvents) {
        f19424a.getClass();
        Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
        return pointerEvents == f19428e || pointerEvents == f19427d;
    }

    public static final boolean b(PointerEvents pointerEvents) {
        f19424a.getClass();
        Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
        return pointerEvents == f19428e || pointerEvents == f19426c;
    }

    public static PointerEvents valueOf(String str) {
        return (PointerEvents) Enum.valueOf(PointerEvents.class, str);
    }

    public static PointerEvents[] values() {
        return (PointerEvents[]) f19429f.clone();
    }
}
