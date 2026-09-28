package com.bumptech.glide;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class Priority {

    /* renamed from: a, reason: collision with root package name */
    public static final Priority f15685a;

    /* renamed from: b, reason: collision with root package name */
    public static final Priority f15686b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ Priority[] f15687c;

    /* JADX INFO: Fake field, exist only in values array */
    Priority EF0;

    static {
        Priority priority = new Priority("IMMEDIATE", 0);
        Priority priority2 = new Priority("HIGH", 1);
        Priority priority3 = new Priority("NORMAL", 2);
        f15685a = priority3;
        Priority priority4 = new Priority("LOW", 3);
        f15686b = priority4;
        f15687c = new Priority[]{priority, priority2, priority3, priority4};
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) f15687c.clone();
    }
}
