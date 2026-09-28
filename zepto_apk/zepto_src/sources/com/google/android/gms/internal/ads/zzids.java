package com.google.android.gms.internal.ads;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class zzids {

    /* renamed from: c, reason: collision with root package name */
    public static final zzids f34776c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzids f34777d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzids f34778e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ zzids[] f34779f;

    /* renamed from: a, reason: collision with root package name */
    public final zzidt f34780a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34781b;

    /* JADX INFO: Fake field, exist only in values array */
    zzids EF1;

    /* JADX INFO: Fake field, exist only in values array */
    zzids EF2;

    /* JADX INFO: Fake field, exist only in values array */
    zzids EF0;

    static {
        zzids zzidsVar = new zzids("DOUBLE", 0, zzidt.f34785d, 1);
        zzids zzidsVar2 = new zzids("FLOAT", 1, zzidt.f34784c, 5);
        zzidt zzidtVar = zzidt.f34783b;
        zzids zzidsVar3 = new zzids("INT64", 2, zzidtVar, 0);
        zzids zzidsVar4 = new zzids("UINT64", 3, zzidtVar, 0);
        zzidt zzidtVar2 = zzidt.f34782a;
        zzids zzidsVar5 = new zzids("INT32", 4, zzidtVar2, 0);
        zzids zzidsVar6 = new zzids("FIXED64", 5, zzidtVar, 1);
        zzids zzidsVar7 = new zzids("FIXED32", 6, zzidtVar2, 5);
        zzids zzidsVar8 = new zzids("BOOL", 7, zzidt.f34786e, 0);
        zzids zzidsVar9 = new zzids("STRING", 8, zzidt.f34787f, 2);
        f34776c = zzidsVar9;
        zzidt zzidtVar3 = zzidt.f34790i;
        zzids zzidsVar10 = new zzids("GROUP", 9, zzidtVar3, 3);
        f34777d = zzidsVar10;
        zzids zzidsVar11 = new zzids(MerchantConstants.MESSAGE, 10, zzidtVar3, 2);
        f34778e = zzidsVar11;
        f34779f = new zzids[]{zzidsVar, zzidsVar2, zzidsVar3, zzidsVar4, zzidsVar5, zzidsVar6, zzidsVar7, zzidsVar8, zzidsVar9, zzidsVar10, zzidsVar11, new zzids("BYTES", 11, zzidt.f34788g, 2), new zzids("UINT32", 12, zzidtVar2, 0), new zzids("ENUM", 13, zzidt.f34789h, 0), new zzids("SFIXED32", 14, zzidtVar2, 5), new zzids("SFIXED64", 15, zzidtVar, 1), new zzids("SINT32", 16, zzidtVar2, 0), new zzids("SINT64", 17, zzidtVar, 0)};
    }

    public zzids(String str, int i2, zzidt zzidtVar, int i3) {
        this.f34780a = zzidtVar;
        this.f34781b = i3;
    }

    public static zzids[] values() {
        return (zzids[]) f34779f.clone();
    }
}
