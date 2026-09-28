package com.facebook.fresco.ui.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class VisibilityState {

    /* renamed from: a, reason: collision with root package name */
    public static final VisibilityState f17486a;

    /* renamed from: b, reason: collision with root package name */
    public static final VisibilityState f17487b;

    /* renamed from: c, reason: collision with root package name */
    public static final VisibilityState f17488c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ VisibilityState[] f17489d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f17490e;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    static {
        VisibilityState visibilityState = new VisibilityState("UNKNOWN", 0);
        f17486a = visibilityState;
        VisibilityState visibilityState2 = new VisibilityState("VISIBLE", 1);
        f17487b = visibilityState2;
        VisibilityState visibilityState3 = new VisibilityState("INVISIBLE", 2);
        f17488c = visibilityState3;
        VisibilityState[] visibilityStateArr = {visibilityState, visibilityState2, visibilityState3};
        f17489d = visibilityStateArr;
        f17490e = EnumEntriesKt.a(visibilityStateArr);
        values();
    }

    public static VisibilityState valueOf(String str) {
        return (VisibilityState) Enum.valueOf(VisibilityState.class, str);
    }

    public static VisibilityState[] values() {
        return (VisibilityState[]) f17489d.clone();
    }
}
