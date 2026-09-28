package com.zeptoconsumerapp.modules.event.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class NotificationEventType {

    /* renamed from: b, reason: collision with root package name */
    public static final NotificationEventType f47651b;

    /* renamed from: c, reason: collision with root package name */
    public static final NotificationEventType f47652c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ NotificationEventType[] f47653d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47654e;

    /* renamed from: a, reason: collision with root package name */
    public final String f47655a;

    static {
        NotificationEventType notificationEventType = new NotificationEventType("COMMUNICATION_STATUS_UPDATES", 0, "comms_status_updates");
        NotificationEventType notificationEventType2 = new NotificationEventType("SET_STORAGE", 1, "set_storage");
        f47651b = notificationEventType2;
        NotificationEventType notificationEventType3 = new NotificationEventType("GET_STORAGE", 2, "get_storage");
        f47652c = notificationEventType3;
        NotificationEventType[] notificationEventTypeArr = {notificationEventType, notificationEventType2, notificationEventType3};
        f47653d = notificationEventTypeArr;
        f47654e = EnumEntriesKt.a(notificationEventTypeArr);
    }

    public NotificationEventType(String str, int i2, String str2) {
        this.f47655a = str2;
    }

    public static NotificationEventType valueOf(String str) {
        return (NotificationEventType) Enum.valueOf(NotificationEventType.class, str);
    }

    public static NotificationEventType[] values() {
        return (NotificationEventType[]) f47653d.clone();
    }

    public final String a() {
        return this.f47655a;
    }
}
