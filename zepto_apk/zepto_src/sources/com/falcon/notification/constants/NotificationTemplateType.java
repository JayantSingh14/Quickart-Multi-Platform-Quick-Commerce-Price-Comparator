package com.falcon.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class NotificationTemplateType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationTemplateType[] f20469a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20470b;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    static {
        NotificationTemplateType[] notificationTemplateTypeArr = {new NotificationTemplateType("NORMAL", 0), new NotificationTemplateType("BASIC_TEMPLATE", 1), new NotificationTemplateType("IMAGE_TEMPLATE", 2), new NotificationTemplateType("TIMER_TEMPLATE", 3)};
        f20469a = notificationTemplateTypeArr;
        f20470b = EnumEntriesKt.a(notificationTemplateTypeArr);
    }

    public static NotificationTemplateType valueOf(String str) {
        return (NotificationTemplateType) Enum.valueOf(NotificationTemplateType.class, str);
    }

    public static NotificationTemplateType[] values() {
        return (NotificationTemplateType[]) f20469a.clone();
    }
}
