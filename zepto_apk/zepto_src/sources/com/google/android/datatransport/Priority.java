package com.google.android.datatransport;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Priority {

    /* renamed from: a, reason: collision with root package name */
    public static final Priority f20514a;

    /* renamed from: b, reason: collision with root package name */
    public static final Priority f20515b;

    /* renamed from: c, reason: collision with root package name */
    public static final Priority f20516c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ Priority[] f20517d;

    static {
        Priority priority = new Priority("DEFAULT", 0);
        f20514a = priority;
        Priority priority2 = new Priority("VERY_LOW", 1);
        f20515b = priority2;
        Priority priority3 = new Priority("HIGHEST", 2);
        f20516c = priority3;
        f20517d = new Priority[]{priority, priority2, priority3};
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) f20517d.clone();
    }
}
