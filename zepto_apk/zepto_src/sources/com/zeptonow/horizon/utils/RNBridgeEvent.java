package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class RNBridgeEvent {

    /* renamed from: a, reason: collision with root package name */
    public static final RNBridgeEvent f48275a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ RNBridgeEvent[] f48276b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f48277c;

    static {
        RNBridgeEvent rNBridgeEvent = new RNBridgeEvent("Log", 0);
        f48275a = rNBridgeEvent;
        RNBridgeEvent[] rNBridgeEventArr = {rNBridgeEvent};
        f48276b = rNBridgeEventArr;
        f48277c = EnumEntriesKt.a(rNBridgeEventArr);
    }

    public static RNBridgeEvent valueOf(String str) {
        return (RNBridgeEvent) Enum.valueOf(RNBridgeEvent.class, str);
    }

    public static RNBridgeEvent[] values() {
        return (RNBridgeEvent[]) f48276b.clone();
    }
}
