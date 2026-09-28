package com.zeptonow.horizon.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class EventStatus {

    /* renamed from: a, reason: collision with root package name */
    public static final EventStatus f48071a;

    /* renamed from: b, reason: collision with root package name */
    public static final EventStatus f48072b;

    /* renamed from: c, reason: collision with root package name */
    public static final EventStatus f48073c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EventStatus[] f48074d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f48075e;

    static {
        EventStatus eventStatus = new EventStatus("PENDING", 0);
        f48071a = eventStatus;
        EventStatus eventStatus2 = new EventStatus("FAILED", 1);
        f48072b = eventStatus2;
        EventStatus eventStatus3 = new EventStatus("IN_PROGRESS", 2);
        f48073c = eventStatus3;
        EventStatus[] eventStatusArr = {eventStatus, eventStatus2, eventStatus3};
        f48074d = eventStatusArr;
        f48075e = EnumEntriesKt.a(eventStatusArr);
    }

    public static EventStatus valueOf(String str) {
        return (EventStatus) Enum.valueOf(EventStatus.class, str);
    }

    public static EventStatus[] values() {
        return (EventStatus[]) f48074d.clone();
    }
}
