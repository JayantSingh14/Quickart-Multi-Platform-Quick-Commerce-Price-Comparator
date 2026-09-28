package com.zeptonow.horizon.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class EventType {

    /* renamed from: a, reason: collision with root package name */
    public static final EventType f48076a;

    /* renamed from: b, reason: collision with root package name */
    public static final EventType f48077b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EventType[] f48078c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f48079d;

    @Metadata
    public static final class Companion {
    }

    static {
        EventType eventType = new EventType("EVENTS_V1", 0);
        f48076a = eventType;
        EventType eventType2 = new EventType("EVENTS_V2", 1);
        f48077b = eventType2;
        EventType[] eventTypeArr = {eventType, eventType2};
        f48078c = eventTypeArr;
        f48079d = EnumEntriesKt.a(eventTypeArr);
    }

    public static EventType valueOf(String str) {
        return (EventType) Enum.valueOf(EventType.class, str);
    }

    public static EventType[] values() {
        return (EventType[]) f48078c.clone();
    }
}
