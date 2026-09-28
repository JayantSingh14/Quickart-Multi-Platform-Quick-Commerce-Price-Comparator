package com.zeptoconsumerapp.modules.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class NotificationTemplateType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationTemplateType[] f47673a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47674b;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    static {
        NotificationTemplateType[] notificationTemplateTypeArr = {new NotificationTemplateType("NORMAL", 0), new NotificationTemplateType("BASIC_TEMPLATE", 1), new NotificationTemplateType("IMAGE_TEMPLATE", 2), new NotificationTemplateType("TIMER_TEMPLATE", 3)};
        f47673a = notificationTemplateTypeArr;
        f47674b = EnumEntriesKt.a(notificationTemplateTypeArr);
    }

    public static NotificationTemplateType valueOf(String str) {
        return (NotificationTemplateType) Enum.valueOf(NotificationTemplateType.class, str);
    }

    public static NotificationTemplateType[] values() {
        return (NotificationTemplateType[]) f47673a.clone();
    }
}
