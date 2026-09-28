package com.falcon.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class NotificationConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationConfig[] f20458a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20459b;

    static {
        NotificationConfig[] notificationConfigArr = {new NotificationConfig("INTENT_FLAG", 0), new NotificationConfig("NOTIFICATION_DATA", 1), new NotificationConfig("DEFAULT_CHANNEL_ID", 2), new NotificationConfig("DEFAULT_CHANNEL_DESC", 3), new NotificationConfig("TEMPLATE_TYPE", 4), new NotificationConfig("HTML_TITLE", 5), new NotificationConfig("HTML_BODY", 6), new NotificationConfig("BG_IMAGE", 7), new NotificationConfig("URL", 8), new NotificationConfig("LARGE_ICON", 9), new NotificationConfig("COMMUNICATION_ID", 10), new NotificationConfig("TIMER", 11), new NotificationConfig("CONTENT_BODY", 12), new NotificationConfig("CONTENT_TITLE", 13), new NotificationConfig("LAUNCHED_FROM_NOTIFICATION_SERVICE", 14), new NotificationConfig("TENANT", 15), new NotificationConfig("ZEPTOCAFE", 16), new NotificationConfig("SUBTITLE", 17), new NotificationConfig("TITLE_COLOR", 18), new NotificationConfig("MESSAGE_COLOR", 19), new NotificationConfig("APPSTATE", 20), new NotificationConfig("ENABLE_THUMBNAIL", 21), new NotificationConfig("ENABLE_MIXPANEL_EVENT", 22), new NotificationConfig("NOTIFICATION_ID", 23), new NotificationConfig("IS_ONGOING", 24), new NotificationConfig("END_TIME", 25), new NotificationConfig("CREATION_TIME", 26), new NotificationConfig("SEPARATOR_KEY", 27), new NotificationConfig("DEFAULT_SEPARATOR", 28), new NotificationConfig("ONGOING_NOTIFICATION_ID", 29), new NotificationConfig("THUMBNAIL_IMG", 30), new NotificationConfig("THUMBNAIL_SIZE", 31), new NotificationConfig("REPEAT_DELAY", 32), new NotificationConfig("REPEAT_TIMES", 33), new NotificationConfig("MAX_REPEAT_TIMES", 34), new NotificationConfig("MIN_REPEAT_DELAY", 35), new NotificationConfig("IS_REPEATED_FLAG", 36), new NotificationConfig("COMMUNICATION_ID_KEY", 37), new NotificationConfig("UNKNOWN_VALUE", 38), new NotificationConfig("TRUE_VALUE", 39)};
        f20458a = notificationConfigArr;
        f20459b = EnumEntriesKt.a(notificationConfigArr);
    }

    public static NotificationConfig valueOf(String str) {
        return (NotificationConfig) Enum.valueOf(NotificationConfig.class, str);
    }

    public static NotificationConfig[] values() {
        return (NotificationConfig[]) f20458a.clone();
    }
}
