package com.facebook.react.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class LifecycleState {

    /* renamed from: a, reason: collision with root package name */
    public static final LifecycleState f18691a;

    /* renamed from: b, reason: collision with root package name */
    public static final LifecycleState f18692b;

    /* renamed from: c, reason: collision with root package name */
    public static final LifecycleState f18693c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ LifecycleState[] f18694d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18695e;

    static {
        LifecycleState lifecycleState = new LifecycleState("BEFORE_CREATE", 0);
        f18691a = lifecycleState;
        LifecycleState lifecycleState2 = new LifecycleState("BEFORE_RESUME", 1);
        f18692b = lifecycleState2;
        LifecycleState lifecycleState3 = new LifecycleState("RESUMED", 2);
        f18693c = lifecycleState3;
        LifecycleState[] lifecycleStateArr = {lifecycleState, lifecycleState2, lifecycleState3};
        f18694d = lifecycleStateArr;
        f18695e = EnumEntriesKt.a(lifecycleStateArr);
    }

    public static LifecycleState valueOf(String str) {
        return (LifecycleState) Enum.valueOf(LifecycleState.class, str);
    }

    public static LifecycleState[] values() {
        return (LifecycleState[]) f18694d.clone();
    }
}
