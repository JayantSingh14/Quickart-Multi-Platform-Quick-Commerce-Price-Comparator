package com.zeptoconsumerapp.modules.notification.silentPush;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class ActionType {

    /* renamed from: b, reason: collision with root package name */
    public static final ActionType f47695b;

    /* renamed from: c, reason: collision with root package name */
    public static final ActionType f47696c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f47697d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47698e;

    /* renamed from: a, reason: collision with root package name */
    public final String f47699a;

    static {
        ActionType actionType = new ActionType("REFRESH_CONFIG", 0, "REFRESH_CONFIG");
        f47695b = actionType;
        ActionType actionType2 = new ActionType("CHECK_PHOENIX_UPDATE", 1, "CHECK_PHOENIX_UPDATE");
        f47696c = actionType2;
        ActionType[] actionTypeArr = {actionType, actionType2};
        f47697d = actionTypeArr;
        f47698e = EnumEntriesKt.a(actionTypeArr);
    }

    public ActionType(String str, int i2, String str2) {
        this.f47699a = str2;
    }

    public static ActionType valueOf(String str) {
        return (ActionType) Enum.valueOf(ActionType.class, str);
    }

    public static ActionType[] values() {
        return (ActionType[]) f47697d.clone();
    }
}
