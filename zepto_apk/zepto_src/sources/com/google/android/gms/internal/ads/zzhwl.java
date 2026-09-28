package com.google.android.gms.internal.ads;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class zzhwl {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhwl f34421a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhwl f34422b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhwl f34423c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ zzhwl[] f34424d;

    /* JADX INFO: Fake field, exist only in values array */
    zzhwl EF0;

    static {
        zzhwl zzhwlVar = new zzhwl("SHA1", 0);
        zzhwl zzhwlVar2 = new zzhwl("SHA224", 1);
        zzhwl zzhwlVar3 = new zzhwl("SHA256", 2);
        f34421a = zzhwlVar3;
        zzhwl zzhwlVar4 = new zzhwl("SHA384", 3);
        f34422b = zzhwlVar4;
        zzhwl zzhwlVar5 = new zzhwl("SHA512", 4);
        f34423c = zzhwlVar5;
        f34424d = new zzhwl[]{zzhwlVar, zzhwlVar2, zzhwlVar3, zzhwlVar4, zzhwlVar5};
    }

    public static zzhwl[] values() {
        return (zzhwl[]) f34424d.clone();
    }
}
