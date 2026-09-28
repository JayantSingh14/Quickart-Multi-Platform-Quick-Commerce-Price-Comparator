package com.zeptoconsumerapp.modules.notification.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class AppState {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppState[] f47658a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47659b;

    static {
        AppState[] appStateArr = {new AppState("FOREGROUND", 0), new AppState("BACKGROUND", 1), new AppState("KILLED", 2)};
        f47658a = appStateArr;
        f47659b = EnumEntriesKt.a(appStateArr);
    }

    public static AppState valueOf(String str) {
        return (AppState) Enum.valueOf(AppState.class, str);
    }

    public static AppState[] values() {
        return (AppState[]) f47658a.clone();
    }
}
