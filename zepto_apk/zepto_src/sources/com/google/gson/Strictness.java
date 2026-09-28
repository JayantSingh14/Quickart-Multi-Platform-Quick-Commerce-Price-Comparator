package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Strictness {

    /* renamed from: a, reason: collision with root package name */
    public static final Strictness f45265a;

    /* renamed from: b, reason: collision with root package name */
    public static final Strictness f45266b;

    /* renamed from: c, reason: collision with root package name */
    public static final Strictness f45267c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ Strictness[] f45268d;

    static {
        Strictness strictness = new Strictness("LENIENT", 0);
        f45265a = strictness;
        Strictness strictness2 = new Strictness("LEGACY_STRICT", 1);
        f45266b = strictness2;
        Strictness strictness3 = new Strictness("STRICT", 2);
        f45267c = strictness3;
        f45268d = new Strictness[]{strictness, strictness2, strictness3};
    }

    public static Strictness valueOf(String str) {
        return (Strictness) Enum.valueOf(Strictness.class, str);
    }

    public static Strictness[] values() {
        return (Strictness[]) f45268d.clone();
    }
}
