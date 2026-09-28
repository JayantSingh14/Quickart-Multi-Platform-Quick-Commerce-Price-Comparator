package com.google.android.gms.internal.measurement;

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
/* loaded from: classes.dex */
public final class zzlw {

    /* renamed from: b, reason: collision with root package name */
    public static final zzlw f37096b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzlw f37097c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzlw[] f37098d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ zzlw[] f37099e;

    /* renamed from: a, reason: collision with root package name */
    public final int f37100a;

    /* JADX INFO: Fake field, exist only in values array */
    zzlw EF0;

    static {
        zzmr zzmrVar = zzmr.f37118e;
        zzlw zzlwVar = new zzlw("DOUBLE", 0, 0, 1, zzmrVar);
        zzmr zzmrVar2 = zzmr.f37117d;
        zzlw zzlwVar2 = new zzlw("FLOAT", 1, 1, 1, zzmrVar2);
        zzmr zzmrVar3 = zzmr.f37116c;
        zzlw zzlwVar3 = new zzlw("INT64", 2, 2, 1, zzmrVar3);
        zzlw zzlwVar4 = new zzlw("UINT64", 3, 3, 1, zzmrVar3);
        zzmr zzmrVar4 = zzmr.f37115b;
        zzlw zzlwVar5 = new zzlw("INT32", 4, 4, 1, zzmrVar4);
        zzlw zzlwVar6 = new zzlw("FIXED64", 5, 5, 1, zzmrVar3);
        zzlw zzlwVar7 = new zzlw("FIXED32", 6, 6, 1, zzmrVar4);
        zzmr zzmrVar5 = zzmr.f37119f;
        zzlw zzlwVar8 = new zzlw("BOOL", 7, 7, 1, zzmrVar5);
        zzmr zzmrVar6 = zzmr.f37120g;
        zzlw zzlwVar9 = new zzlw("STRING", 8, 8, 1, zzmrVar6);
        zzmr zzmrVar7 = zzmr.f37123j;
        zzlw zzlwVar10 = new zzlw(MerchantConstants.MESSAGE, 9, 9, 1, zzmrVar7);
        zzmr zzmrVar8 = zzmr.f37121h;
        zzlw zzlwVar11 = new zzlw("BYTES", 10, 10, 1, zzmrVar8);
        zzlw zzlwVar12 = new zzlw("UINT32", 11, 11, 1, zzmrVar4);
        zzmr zzmrVar9 = zzmr.f37122i;
        zzlw zzlwVar13 = new zzlw("ENUM", 12, 12, 1, zzmrVar9);
        zzlw zzlwVar14 = new zzlw("SFIXED32", 13, 13, 1, zzmrVar4);
        zzlw zzlwVar15 = new zzlw("SFIXED64", 14, 14, 1, zzmrVar3);
        zzlw zzlwVar16 = new zzlw("SINT32", 15, 15, 1, zzmrVar4);
        zzlw zzlwVar17 = new zzlw("SINT64", 16, 16, 1, zzmrVar3);
        zzlw zzlwVar18 = new zzlw("GROUP", 17, 17, 1, zzmrVar7);
        zzlw zzlwVar19 = new zzlw("DOUBLE_LIST", 18, 18, 2, zzmrVar);
        zzlw zzlwVar20 = new zzlw("FLOAT_LIST", 19, 19, 2, zzmrVar2);
        zzlw zzlwVar21 = new zzlw("INT64_LIST", 20, 20, 2, zzmrVar3);
        zzlw zzlwVar22 = new zzlw("UINT64_LIST", 21, 21, 2, zzmrVar3);
        zzlw zzlwVar23 = new zzlw("INT32_LIST", 22, 22, 2, zzmrVar4);
        zzlw zzlwVar24 = new zzlw("FIXED64_LIST", 23, 23, 2, zzmrVar3);
        zzlw zzlwVar25 = new zzlw("FIXED32_LIST", 24, 24, 2, zzmrVar4);
        zzlw zzlwVar26 = new zzlw("BOOL_LIST", 25, 25, 2, zzmrVar5);
        zzlw zzlwVar27 = new zzlw("STRING_LIST", 26, 26, 2, zzmrVar6);
        zzlw zzlwVar28 = new zzlw("MESSAGE_LIST", 27, 27, 2, zzmrVar7);
        zzlw zzlwVar29 = new zzlw("BYTES_LIST", 28, 28, 2, zzmrVar8);
        zzlw zzlwVar30 = new zzlw("UINT32_LIST", 29, 29, 2, zzmrVar4);
        zzlw zzlwVar31 = new zzlw("ENUM_LIST", 30, 30, 2, zzmrVar9);
        zzlw zzlwVar32 = new zzlw("SFIXED32_LIST", 31, 31, 2, zzmrVar4);
        zzlw zzlwVar33 = new zzlw("SFIXED64_LIST", 32, 32, 2, zzmrVar3);
        zzlw zzlwVar34 = new zzlw("SINT32_LIST", 33, 33, 2, zzmrVar4);
        zzlw zzlwVar35 = new zzlw("SINT64_LIST", 34, 34, 2, zzmrVar3);
        zzlw zzlwVar36 = new zzlw("DOUBLE_LIST_PACKED", 35, 35, 3, zzmrVar);
        f37096b = zzlwVar36;
        zzlw zzlwVar37 = new zzlw("FLOAT_LIST_PACKED", 36, 36, 3, zzmrVar2);
        zzlw zzlwVar38 = new zzlw("INT64_LIST_PACKED", 37, 37, 3, zzmrVar3);
        zzlw zzlwVar39 = new zzlw("UINT64_LIST_PACKED", 38, 38, 3, zzmrVar3);
        zzlw zzlwVar40 = new zzlw("INT32_LIST_PACKED", 39, 39, 3, zzmrVar4);
        zzlw zzlwVar41 = new zzlw("FIXED64_LIST_PACKED", 40, 40, 3, zzmrVar3);
        zzlw zzlwVar42 = new zzlw("FIXED32_LIST_PACKED", 41, 41, 3, zzmrVar4);
        zzlw zzlwVar43 = new zzlw("BOOL_LIST_PACKED", 42, 42, 3, zzmrVar5);
        zzlw zzlwVar44 = new zzlw("UINT32_LIST_PACKED", 43, 43, 3, zzmrVar4);
        zzlw zzlwVar45 = new zzlw("ENUM_LIST_PACKED", 44, 44, 3, zzmrVar9);
        zzlw zzlwVar46 = new zzlw("SFIXED32_LIST_PACKED", 45, 45, 3, zzmrVar4);
        zzlw zzlwVar47 = new zzlw("SFIXED64_LIST_PACKED", 46, 46, 3, zzmrVar3);
        zzlw zzlwVar48 = new zzlw("SINT32_LIST_PACKED", 47, 47, 3, zzmrVar4);
        zzlw zzlwVar49 = new zzlw("SINT64_LIST_PACKED", 48, 48, 3, zzmrVar3);
        f37097c = zzlwVar49;
        f37099e = new zzlw[]{zzlwVar, zzlwVar2, zzlwVar3, zzlwVar4, zzlwVar5, zzlwVar6, zzlwVar7, zzlwVar8, zzlwVar9, zzlwVar10, zzlwVar11, zzlwVar12, zzlwVar13, zzlwVar14, zzlwVar15, zzlwVar16, zzlwVar17, zzlwVar18, zzlwVar19, zzlwVar20, zzlwVar21, zzlwVar22, zzlwVar23, zzlwVar24, zzlwVar25, zzlwVar26, zzlwVar27, zzlwVar28, zzlwVar29, zzlwVar30, zzlwVar31, zzlwVar32, zzlwVar33, zzlwVar34, zzlwVar35, zzlwVar36, zzlwVar37, zzlwVar38, zzlwVar39, zzlwVar40, zzlwVar41, zzlwVar42, zzlwVar43, zzlwVar44, zzlwVar45, zzlwVar46, zzlwVar47, zzlwVar48, zzlwVar49, new zzlw("GROUP_LIST", 49, 49, 2, zzmrVar7), new zzlw("MAP", 50, 50, 4, zzmr.f37114a)};
        zzlw[] zzlwVarArrValues = values();
        f37098d = new zzlw[zzlwVarArrValues.length];
        for (zzlw zzlwVar50 : zzlwVarArrValues) {
            f37098d[zzlwVar50.f37100a] = zzlwVar50;
        }
    }

    public zzlw(String str, int i2, int i3, int i4, zzmr zzmrVar) {
        this.f37100a = i3;
        int i5 = i4 - 1;
        if (i5 == 1 || i5 == 3) {
            zzmrVar.getClass();
        }
        if (i4 == 1) {
            zzmr zzmrVar2 = zzmr.f37114a;
            zzmrVar.ordinal();
        }
    }

    public static zzlw[] values() {
        return (zzlw[]) f37099e.clone();
    }
}
