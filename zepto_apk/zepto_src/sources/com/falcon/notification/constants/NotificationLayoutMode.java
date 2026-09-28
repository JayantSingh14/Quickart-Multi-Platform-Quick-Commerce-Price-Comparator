package com.falcon.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class NotificationLayoutMode {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f20462b;

    /* renamed from: c, reason: collision with root package name */
    public static final NotificationLayoutMode f20463c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ NotificationLayoutMode[] f20464d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20465e;

    /* renamed from: a, reason: collision with root package name */
    public final String f20466a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static NotificationLayoutMode a(String str) {
            NotificationLayoutMode notificationLayoutMode;
            NotificationLayoutMode[] notificationLayoutModeArrValues = NotificationLayoutMode.values();
            int length = notificationLayoutModeArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    notificationLayoutMode = null;
                    break;
                }
                notificationLayoutMode = notificationLayoutModeArrValues[i2];
                if (notificationLayoutMode.f20466a.equalsIgnoreCase(str)) {
                    break;
                }
                i2++;
            }
            return notificationLayoutMode == null ? NotificationLayoutMode.f20463c : notificationLayoutMode;
        }
    }

    static {
        NotificationLayoutMode notificationLayoutMode = new NotificationLayoutMode("NORMAL", 0, "NORMAL");
        f20463c = notificationLayoutMode;
        NotificationLayoutMode[] notificationLayoutModeArr = {notificationLayoutMode, new NotificationLayoutMode("TRUNCATED", 1, "TRUNCATED")};
        f20464d = notificationLayoutModeArr;
        f20465e = EnumEntriesKt.a(notificationLayoutModeArr);
        f20462b = new Companion();
    }

    public NotificationLayoutMode(String str, int i2, String str2) {
        this.f20466a = str2;
    }

    public static NotificationLayoutMode valueOf(String str) {
        return (NotificationLayoutMode) Enum.valueOf(NotificationLayoutMode.class, str);
    }

    public static NotificationLayoutMode[] values() {
        return (NotificationLayoutMode[]) f20464d.clone();
    }

    public final String a() {
        return this.f20466a;
    }
}
