package com.facebook.react.uimanager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class NativeKind {

    /* renamed from: a, reason: collision with root package name */
    public static final NativeKind f19403a;

    /* renamed from: b, reason: collision with root package name */
    public static final NativeKind f19404b;

    /* renamed from: c, reason: collision with root package name */
    public static final NativeKind f19405c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ NativeKind[] f19406d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19407e;

    static {
        NativeKind nativeKind = new NativeKind("PARENT", 0);
        f19403a = nativeKind;
        NativeKind nativeKind2 = new NativeKind("LEAF", 1);
        f19404b = nativeKind2;
        NativeKind nativeKind3 = new NativeKind("NONE", 2);
        f19405c = nativeKind3;
        NativeKind[] nativeKindArr = {nativeKind, nativeKind2, nativeKind3};
        f19406d = nativeKindArr;
        f19407e = EnumEntriesKt.a(nativeKindArr);
    }

    public static NativeKind valueOf(String str) {
        return (NativeKind) Enum.valueOf(NativeKind.class, str);
    }

    public static NativeKind[] values() {
        return (NativeKind[]) f19406d.clone();
    }
}
