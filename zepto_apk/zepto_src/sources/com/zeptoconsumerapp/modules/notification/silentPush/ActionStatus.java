package com.zeptoconsumerapp.modules.notification.silentPush;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class ActionStatus {

    /* renamed from: a, reason: collision with root package name */
    public static final ActionStatus f47691a;

    /* renamed from: b, reason: collision with root package name */
    public static final ActionStatus f47692b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ActionStatus[] f47693c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47694d;

    static {
        ActionStatus actionStatus = new ActionStatus("EXECUTED", 0);
        f47691a = actionStatus;
        ActionStatus actionStatus2 = new ActionStatus("SKIPPED_THROTTLED", 1);
        f47692b = actionStatus2;
        ActionStatus[] actionStatusArr = {actionStatus, actionStatus2};
        f47693c = actionStatusArr;
        f47694d = EnumEntriesKt.a(actionStatusArr);
    }

    public static ActionStatus valueOf(String str) {
        return (ActionStatus) Enum.valueOf(ActionStatus.class, str);
    }

    public static ActionStatus[] values() {
        return (ActionStatus[]) f47693c.clone();
    }
}
