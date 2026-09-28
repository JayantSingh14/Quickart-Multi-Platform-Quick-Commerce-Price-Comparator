package com.facebook.imagepipeline.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class Priority {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f17781a;

    /* renamed from: b, reason: collision with root package name */
    public static final Priority f17782b;

    /* renamed from: c, reason: collision with root package name */
    public static final Priority f17783c;

    /* renamed from: d, reason: collision with root package name */
    public static final Priority f17784d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ Priority[] f17785e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f17786f;

    @Metadata
    public static final class Companion {
    }

    static {
        Priority priority = new Priority("LOW", 0);
        f17782b = priority;
        Priority priority2 = new Priority("MEDIUM", 1);
        f17783c = priority2;
        Priority priority3 = new Priority("HIGH", 2);
        f17784d = priority3;
        Priority[] priorityArr = {priority, priority2, priority3};
        f17785e = priorityArr;
        f17786f = EnumEntriesKt.a(priorityArr);
        f17781a = new Companion();
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) f17785e.clone();
    }
}
