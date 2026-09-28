package com.google.firebase.crashlytics.internal.settings;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class SettingsCacheBehavior {

    /* renamed from: a, reason: collision with root package name */
    public static final SettingsCacheBehavior f44431a;

    /* renamed from: b, reason: collision with root package name */
    public static final SettingsCacheBehavior f44432b;

    /* renamed from: c, reason: collision with root package name */
    public static final SettingsCacheBehavior f44433c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ SettingsCacheBehavior[] f44434d;

    static {
        SettingsCacheBehavior settingsCacheBehavior = new SettingsCacheBehavior("USE_CACHE", 0);
        f44431a = settingsCacheBehavior;
        SettingsCacheBehavior settingsCacheBehavior2 = new SettingsCacheBehavior("SKIP_CACHE_LOOKUP", 1);
        f44432b = settingsCacheBehavior2;
        SettingsCacheBehavior settingsCacheBehavior3 = new SettingsCacheBehavior("IGNORE_CACHE_EXPIRATION", 2);
        f44433c = settingsCacheBehavior3;
        f44434d = new SettingsCacheBehavior[]{settingsCacheBehavior, settingsCacheBehavior2, settingsCacheBehavior3};
    }

    public static SettingsCacheBehavior valueOf(String str) {
        return (SettingsCacheBehavior) Enum.valueOf(SettingsCacheBehavior.class, str);
    }

    public static SettingsCacheBehavior[] values() {
        return (SettingsCacheBehavior[]) f44434d.clone();
    }
}
