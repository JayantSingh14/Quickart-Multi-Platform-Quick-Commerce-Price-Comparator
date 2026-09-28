package com.google.android.gms.internal.ads;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class zzhxo {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhxo f34472a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhxo f34473b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ zzhxo[] f34474c;

    static {
        zzhxo zzhxoVar = new zzhxo("LENIENT", 0);
        f34472a = zzhxoVar;
        zzhxo zzhxoVar2 = new zzhxo("LEGACY_STRICT", 1);
        f34473b = zzhxoVar2;
        f34474c = new zzhxo[]{zzhxoVar, zzhxoVar2, new zzhxo("STRICT", 2)};
    }

    public static zzhxo[] values() {
        return (zzhxo[]) f34474c.clone();
    }
}
