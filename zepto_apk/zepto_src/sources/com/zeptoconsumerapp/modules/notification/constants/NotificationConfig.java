package com.zeptoconsumerapp.modules.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class NotificationConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationConfig[] f47662a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47663b;

    static {
        NotificationConfig[] notificationConfigArr = {new NotificationConfig("INTENT_FLAG", 0), new NotificationConfig("NOTIFICATION_DATA", 1), new NotificationConfig("DEFAULT_CHANNEL_ID", 2), new NotificationConfig("DEFAULT_CHANNEL_DESC", 3), new NotificationConfig("TEMPLATE_TYPE", 4), new NotificationConfig("HTML_TITLE", 5), new NotificationConfig("HTML_BODY", 6), new NotificationConfig("BG_IMAGE", 7), new NotificationConfig("URL", 8), new NotificationConfig("LARGE_ICON", 9), new NotificationConfig("COMMUNICATION_ID", 10), new NotificationConfig("TIMER", 11), new NotificationConfig("CONTENT_BODY", 12), new NotificationConfig("CONTENT_TITLE", 13), new NotificationConfig("LAUNCHED_FROM_NOTIFICATION_SERVICE", 14), new NotificationConfig("TENANT", 15), new NotificationConfig("ZEPTOCAFE", 16), new NotificationConfig("TITLE_COLOR", 17), new NotificationConfig("MESSAGE_COLOR", 18), new NotificationConfig("APPSTATE", 19), new NotificationConfig("ENABLE_MIXPANEL_EVENT", 20), new NotificationConfig("NOTIFICATION_ID", 21), new NotificationConfig("IS_ONGOING", 22), new NotificationConfig("END_TIME", 23), new NotificationConfig("CREATION_TIME", 24), new NotificationConfig("SEPARATOR_KEY", 25), new NotificationConfig("DEFAULT_SEPARATOR", 26), new NotificationConfig("ONGOING_NOTIFICATION_ID", 27), new NotificationConfig("REPEAT_DELAY", 28), new NotificationConfig("REPEAT_TIMES", 29), new NotificationConfig("MAX_REPEAT_TIMES", 30), new NotificationConfig("MIN_REPEAT_DELAY", 31), new NotificationConfig("IS_REPEATED_FLAG", 32), new NotificationConfig("COMMUNICATION_ID_KEY", 33), new NotificationConfig("UNKNOWN_VALUE", 34), new NotificationConfig("TRUE_VALUE", 35)};
        f47662a = notificationConfigArr;
        f47663b = EnumEntriesKt.a(notificationConfigArr);
    }

    public static NotificationConfig valueOf(String str) {
        return (NotificationConfig) Enum.valueOf(NotificationConfig.class, str);
    }

    public static NotificationConfig[] values() {
        return (NotificationConfig[]) f47662a.clone();
    }
}
