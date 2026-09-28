package com.zeptoconsumerapp.modules.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class NotificationRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationRequest[] f47671a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47672b;

    static {
        NotificationRequest[] notificationRequestArr = {new NotificationRequest("LAUNCH_REQUEST", 0)};
        f47671a = notificationRequestArr;
        f47672b = EnumEntriesKt.a(notificationRequestArr);
    }

    public static NotificationRequest valueOf(String str) {
        return (NotificationRequest) Enum.valueOf(NotificationRequest.class, str);
    }

    public static NotificationRequest[] values() {
        return (NotificationRequest[]) f47671a.clone();
    }
}
