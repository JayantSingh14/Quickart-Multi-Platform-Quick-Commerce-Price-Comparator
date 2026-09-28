package com.facebook.react.uimanager.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class TouchEventType {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f19778b;

    /* renamed from: c, reason: collision with root package name */
    public static final TouchEventType f19779c;

    /* renamed from: d, reason: collision with root package name */
    public static final TouchEventType f19780d;

    /* renamed from: e, reason: collision with root package name */
    public static final TouchEventType f19781e;

    /* renamed from: f, reason: collision with root package name */
    public static final TouchEventType f19782f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ TouchEventType[] f19783g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19784h;

    /* renamed from: a, reason: collision with root package name */
    public final String f19785a;

    @Metadata
    public static final class Companion {
    }

    static {
        TouchEventType touchEventType = new TouchEventType("START", 0, "topTouchStart");
        f19779c = touchEventType;
        TouchEventType touchEventType2 = new TouchEventType("END", 1, "topTouchEnd");
        f19780d = touchEventType2;
        TouchEventType touchEventType3 = new TouchEventType("MOVE", 2, "topTouchMove");
        f19781e = touchEventType3;
        TouchEventType touchEventType4 = new TouchEventType("CANCEL", 3, "topTouchCancel");
        f19782f = touchEventType4;
        TouchEventType[] touchEventTypeArr = {touchEventType, touchEventType2, touchEventType3, touchEventType4};
        f19783g = touchEventTypeArr;
        f19784h = EnumEntriesKt.a(touchEventTypeArr);
        f19778b = new Companion();
    }

    public TouchEventType(String str, int i2, String str2) {
        this.f19785a = str2;
    }

    public static TouchEventType valueOf(String str) {
        return (TouchEventType) Enum.valueOf(TouchEventType.class, str);
    }

    public static TouchEventType[] values() {
        return (TouchEventType[]) f19783g.clone();
    }
}
