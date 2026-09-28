package com.swmansion.gesturehandler.core;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class PointerEventsConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final PointerEventsConfig f46753a;

    /* renamed from: b, reason: collision with root package name */
    public static final PointerEventsConfig f46754b;

    /* renamed from: c, reason: collision with root package name */
    public static final PointerEventsConfig f46755c;

    /* renamed from: d, reason: collision with root package name */
    public static final PointerEventsConfig f46756d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ PointerEventsConfig[] f46757e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f46758f;

    static {
        PointerEventsConfig pointerEventsConfig = new PointerEventsConfig("NONE", 0);
        f46753a = pointerEventsConfig;
        PointerEventsConfig pointerEventsConfig2 = new PointerEventsConfig("BOX_NONE", 1);
        f46754b = pointerEventsConfig2;
        PointerEventsConfig pointerEventsConfig3 = new PointerEventsConfig("BOX_ONLY", 2);
        f46755c = pointerEventsConfig3;
        PointerEventsConfig pointerEventsConfig4 = new PointerEventsConfig(RegionUtil.REGION_STRING_AUTO, 3);
        f46756d = pointerEventsConfig4;
        PointerEventsConfig[] pointerEventsConfigArr = {pointerEventsConfig, pointerEventsConfig2, pointerEventsConfig3, pointerEventsConfig4};
        f46757e = pointerEventsConfigArr;
        f46758f = EnumEntriesKt.a(pointerEventsConfigArr);
    }

    public static PointerEventsConfig valueOf(String str) {
        return (PointerEventsConfig) Enum.valueOf(PointerEventsConfig.class, str);
    }

    public static PointerEventsConfig[] values() {
        return (PointerEventsConfig[]) f46757e.clone();
    }
}
