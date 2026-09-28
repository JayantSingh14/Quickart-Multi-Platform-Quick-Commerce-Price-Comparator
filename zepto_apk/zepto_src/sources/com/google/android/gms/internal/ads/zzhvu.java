package com.google.android.gms.internal.ads;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class zzhvu {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhvu f34400a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhvu f34401b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhvu f34402c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ zzhvu[] f34403d;

    static {
        zzhvu zzhvuVar = new zzhvu("NIST_P256", 0);
        f34400a = zzhvuVar;
        zzhvu zzhvuVar2 = new zzhvu("NIST_P384", 1);
        f34401b = zzhvuVar2;
        zzhvu zzhvuVar3 = new zzhvu("NIST_P521", 2);
        f34402c = zzhvuVar3;
        f34403d = new zzhvu[]{zzhvuVar, zzhvuVar2, zzhvuVar3};
    }

    public static zzhvu[] values() {
        return (zzhvu[]) f34403d.clone();
    }
}
