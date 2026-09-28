package com.falcon.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class NotificationCategory {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationCategory[] f20456a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20457b;

    static {
        NotificationCategory[] notificationCategoryArr = {new NotificationCategory("PROMO_CASH_ONGOING", 0)};
        f20456a = notificationCategoryArr;
        f20457b = EnumEntriesKt.a(notificationCategoryArr);
    }

    public static NotificationCategory valueOf(String str) {
        return (NotificationCategory) Enum.valueOf(NotificationCategory.class, str);
    }

    public static NotificationCategory[] values() {
        return (NotificationCategory[]) f20456a.clone();
    }
}
