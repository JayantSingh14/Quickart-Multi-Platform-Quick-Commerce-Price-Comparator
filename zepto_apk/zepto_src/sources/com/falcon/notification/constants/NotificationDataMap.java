package com.falcon.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class NotificationDataMap {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationDataMap[] f20460a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20461b;

    static {
        NotificationDataMap[] notificationDataMapArr = {new NotificationDataMap("ORDER_PLACE_TIME", 0)};
        f20460a = notificationDataMapArr;
        f20461b = EnumEntriesKt.a(notificationDataMapArr);
    }

    public static NotificationDataMap valueOf(String str) {
        return (NotificationDataMap) Enum.valueOf(NotificationDataMap.class, str);
    }

    public static NotificationDataMap[] values() {
        return (NotificationDataMap[]) f20460a.clone();
    }
}
