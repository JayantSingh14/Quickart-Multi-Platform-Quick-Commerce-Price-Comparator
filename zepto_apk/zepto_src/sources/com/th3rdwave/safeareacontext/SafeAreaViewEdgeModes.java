package com.th3rdwave.safeareacontext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class SafeAreaViewEdgeModes {

    /* renamed from: a, reason: collision with root package name */
    public static final SafeAreaViewEdgeModes f47174a;

    /* renamed from: b, reason: collision with root package name */
    public static final SafeAreaViewEdgeModes f47175b;

    /* renamed from: c, reason: collision with root package name */
    public static final SafeAreaViewEdgeModes f47176c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ SafeAreaViewEdgeModes[] f47177d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47178e;

    static {
        SafeAreaViewEdgeModes safeAreaViewEdgeModes = new SafeAreaViewEdgeModes("OFF", 0);
        f47174a = safeAreaViewEdgeModes;
        SafeAreaViewEdgeModes safeAreaViewEdgeModes2 = new SafeAreaViewEdgeModes("ADDITIVE", 1);
        f47175b = safeAreaViewEdgeModes2;
        SafeAreaViewEdgeModes safeAreaViewEdgeModes3 = new SafeAreaViewEdgeModes("MAXIMUM", 2);
        f47176c = safeAreaViewEdgeModes3;
        SafeAreaViewEdgeModes[] safeAreaViewEdgeModesArr = {safeAreaViewEdgeModes, safeAreaViewEdgeModes2, safeAreaViewEdgeModes3};
        f47177d = safeAreaViewEdgeModesArr;
        f47178e = EnumEntriesKt.a(safeAreaViewEdgeModesArr);
    }

    public static SafeAreaViewEdgeModes valueOf(String str) {
        return (SafeAreaViewEdgeModes) Enum.valueOf(SafeAreaViewEdgeModes.class, str);
    }

    public static SafeAreaViewEdgeModes[] values() {
        return (SafeAreaViewEdgeModes[]) f47177d.clone();
    }
}
