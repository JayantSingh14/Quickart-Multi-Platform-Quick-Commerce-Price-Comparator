package com.amazon.apay.hardened.constant;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14981a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f14982b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f14983c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f14984d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f14985e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ a[] f14986f;

    static {
        a aVar = new a("GET_AUTHORIZATION_INTENT", 0);
        f14981a = aVar;
        a aVar2 = new a("AUTHORIZE", 1);
        f14982b = aVar2;
        a aVar3 = new a("CHARGE", 2);
        f14983c = aVar3;
        a aVar4 = new a("GET_CHARGE_INTENT", 3);
        f14984d = aVar4;
        a aVar5 = new a("SIGN_OUT", 4);
        f14985e = aVar5;
        f14986f = new a[]{aVar, aVar2, aVar3, aVar4, aVar5};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f14986f.clone();
    }
}
