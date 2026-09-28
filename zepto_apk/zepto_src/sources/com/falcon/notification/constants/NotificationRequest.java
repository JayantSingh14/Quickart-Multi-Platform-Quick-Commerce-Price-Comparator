package com.falcon.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class NotificationRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationRequest[] f20467a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20468b;

    static {
        NotificationRequest[] notificationRequestArr = {new NotificationRequest("LAUNCH_REQUEST", 0)};
        f20467a = notificationRequestArr;
        f20468b = EnumEntriesKt.a(notificationRequestArr);
    }

    public static NotificationRequest valueOf(String str) {
        return (NotificationRequest) Enum.valueOf(NotificationRequest.class, str);
    }

    public static NotificationRequest[] values() {
        return (NotificationRequest[]) f20467a.clone();
    }
}
