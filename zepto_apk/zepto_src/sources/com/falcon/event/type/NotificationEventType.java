package com.falcon.event.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class NotificationEventType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationEventType[] f20445a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20446b;

    static {
        NotificationEventType[] notificationEventTypeArr = {new NotificationEventType("COMMUNICATION_STATUS_UPDATES", 0), new NotificationEventType("SET_STORAGE", 1), new NotificationEventType("GET_STORAGE", 2)};
        f20445a = notificationEventTypeArr;
        f20446b = EnumEntriesKt.a(notificationEventTypeArr);
    }

    public static NotificationEventType valueOf(String str) {
        return (NotificationEventType) Enum.valueOf(NotificationEventType.class, str);
    }

    public static NotificationEventType[] values() {
        return (NotificationEventType[]) f20445a.clone();
    }
}
