package com.google.android.gms.internal.pal;

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
public final class zzacs {

    /* renamed from: b, reason: collision with root package name */
    public static final zzacs f37396b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzacs f37397c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzacs[] f37398d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ zzacs[] f37399e;

    /* renamed from: a, reason: collision with root package name */
    public final int f37400a;

    /* JADX INFO: Fake field, exist only in values array */
    zzacs EF0;

    static {
        zzadj zzadjVar = zzadj.DOUBLE;
        zzacs zzacsVar = new zzacs("DOUBLE", 0, 0, 1, zzadjVar);
        zzadj zzadjVar2 = zzadj.FLOAT;
        zzacs zzacsVar2 = new zzacs("FLOAT", 1, 1, 1, zzadjVar2);
        zzadj zzadjVar3 = zzadj.LONG;
        zzacs zzacsVar3 = new zzacs("INT64", 2, 2, 1, zzadjVar3);
        zzacs zzacsVar4 = new zzacs("UINT64", 3, 3, 1, zzadjVar3);
        zzadj zzadjVar4 = zzadj.INT;
        zzacs zzacsVar5 = new zzacs("INT32", 4, 4, 1, zzadjVar4);
        zzacs zzacsVar6 = new zzacs("FIXED64", 5, 5, 1, zzadjVar3);
        zzacs zzacsVar7 = new zzacs("FIXED32", 6, 6, 1, zzadjVar4);
        zzadj zzadjVar5 = zzadj.BOOLEAN;
        zzacs zzacsVar8 = new zzacs("BOOL", 7, 7, 1, zzadjVar5);
        zzadj zzadjVar6 = zzadj.STRING;
        zzacs zzacsVar9 = new zzacs("STRING", 8, 8, 1, zzadjVar6);
        zzadj zzadjVar7 = zzadj.MESSAGE;
        zzacs zzacsVar10 = new zzacs(MerchantConstants.MESSAGE, 9, 9, 1, zzadjVar7);
        zzadj zzadjVar8 = zzadj.BYTE_STRING;
        zzacs zzacsVar11 = new zzacs("BYTES", 10, 10, 1, zzadjVar8);
        zzacs zzacsVar12 = new zzacs("UINT32", 11, 11, 1, zzadjVar4);
        zzadj zzadjVar9 = zzadj.ENUM;
        zzacs zzacsVar13 = new zzacs("ENUM", 12, 12, 1, zzadjVar9);
        zzacs zzacsVar14 = new zzacs("SFIXED32", 13, 13, 1, zzadjVar4);
        zzacs zzacsVar15 = new zzacs("SFIXED64", 14, 14, 1, zzadjVar3);
        zzacs zzacsVar16 = new zzacs("SINT32", 15, 15, 1, zzadjVar4);
        zzacs zzacsVar17 = new zzacs("SINT64", 16, 16, 1, zzadjVar3);
        zzacs zzacsVar18 = new zzacs("GROUP", 17, 17, 1, zzadjVar7);
        zzacs zzacsVar19 = new zzacs("DOUBLE_LIST", 18, 18, 2, zzadjVar);
        zzacs zzacsVar20 = new zzacs("FLOAT_LIST", 19, 19, 2, zzadjVar2);
        zzacs zzacsVar21 = new zzacs("INT64_LIST", 20, 20, 2, zzadjVar3);
        zzacs zzacsVar22 = new zzacs("UINT64_LIST", 21, 21, 2, zzadjVar3);
        zzacs zzacsVar23 = new zzacs("INT32_LIST", 22, 22, 2, zzadjVar4);
        zzacs zzacsVar24 = new zzacs("FIXED64_LIST", 23, 23, 2, zzadjVar3);
        zzacs zzacsVar25 = new zzacs("FIXED32_LIST", 24, 24, 2, zzadjVar4);
        zzacs zzacsVar26 = new zzacs("BOOL_LIST", 25, 25, 2, zzadjVar5);
        zzacs zzacsVar27 = new zzacs("STRING_LIST", 26, 26, 2, zzadjVar6);
        zzacs zzacsVar28 = new zzacs("MESSAGE_LIST", 27, 27, 2, zzadjVar7);
        zzacs zzacsVar29 = new zzacs("BYTES_LIST", 28, 28, 2, zzadjVar8);
        zzacs zzacsVar30 = new zzacs("UINT32_LIST", 29, 29, 2, zzadjVar4);
        zzacs zzacsVar31 = new zzacs("ENUM_LIST", 30, 30, 2, zzadjVar9);
        zzacs zzacsVar32 = new zzacs("SFIXED32_LIST", 31, 31, 2, zzadjVar4);
        zzacs zzacsVar33 = new zzacs("SFIXED64_LIST", 32, 32, 2, zzadjVar3);
        zzacs zzacsVar34 = new zzacs("SINT32_LIST", 33, 33, 2, zzadjVar4);
        zzacs zzacsVar35 = new zzacs("SINT64_LIST", 34, 34, 2, zzadjVar3);
        zzacs zzacsVar36 = new zzacs("DOUBLE_LIST_PACKED", 35, 35, 3, zzadjVar);
        f37396b = zzacsVar36;
        zzacs zzacsVar37 = new zzacs("FLOAT_LIST_PACKED", 36, 36, 3, zzadjVar2);
        zzacs zzacsVar38 = new zzacs("INT64_LIST_PACKED", 37, 37, 3, zzadjVar3);
        zzacs zzacsVar39 = new zzacs("UINT64_LIST_PACKED", 38, 38, 3, zzadjVar3);
        zzacs zzacsVar40 = new zzacs("INT32_LIST_PACKED", 39, 39, 3, zzadjVar4);
        zzacs zzacsVar41 = new zzacs("FIXED64_LIST_PACKED", 40, 40, 3, zzadjVar3);
        zzacs zzacsVar42 = new zzacs("FIXED32_LIST_PACKED", 41, 41, 3, zzadjVar4);
        zzacs zzacsVar43 = new zzacs("BOOL_LIST_PACKED", 42, 42, 3, zzadjVar5);
        zzacs zzacsVar44 = new zzacs("UINT32_LIST_PACKED", 43, 43, 3, zzadjVar4);
        zzacs zzacsVar45 = new zzacs("ENUM_LIST_PACKED", 44, 44, 3, zzadjVar9);
        zzacs zzacsVar46 = new zzacs("SFIXED32_LIST_PACKED", 45, 45, 3, zzadjVar4);
        zzacs zzacsVar47 = new zzacs("SFIXED64_LIST_PACKED", 46, 46, 3, zzadjVar3);
        zzacs zzacsVar48 = new zzacs("SINT32_LIST_PACKED", 47, 47, 3, zzadjVar4);
        zzacs zzacsVar49 = new zzacs("SINT64_LIST_PACKED", 48, 48, 3, zzadjVar3);
        f37397c = zzacsVar49;
        f37399e = new zzacs[]{zzacsVar, zzacsVar2, zzacsVar3, zzacsVar4, zzacsVar5, zzacsVar6, zzacsVar7, zzacsVar8, zzacsVar9, zzacsVar10, zzacsVar11, zzacsVar12, zzacsVar13, zzacsVar14, zzacsVar15, zzacsVar16, zzacsVar17, zzacsVar18, zzacsVar19, zzacsVar20, zzacsVar21, zzacsVar22, zzacsVar23, zzacsVar24, zzacsVar25, zzacsVar26, zzacsVar27, zzacsVar28, zzacsVar29, zzacsVar30, zzacsVar31, zzacsVar32, zzacsVar33, zzacsVar34, zzacsVar35, zzacsVar36, zzacsVar37, zzacsVar38, zzacsVar39, zzacsVar40, zzacsVar41, zzacsVar42, zzacsVar43, zzacsVar44, zzacsVar45, zzacsVar46, zzacsVar47, zzacsVar48, zzacsVar49, new zzacs("GROUP_LIST", 49, 49, 2, zzadjVar7), new zzacs("MAP", 50, 50, 4, zzadj.VOID)};
        zzacs[] zzacsVarArrValues = values();
        f37398d = new zzacs[zzacsVarArrValues.length];
        for (zzacs zzacsVar50 : zzacsVarArrValues) {
            f37398d[zzacsVar50.f37400a] = zzacsVar50;
        }
    }

    public zzacs(String str, int i2, int i3, int i4, zzadj zzadjVar) {
        this.f37400a = i3;
        zzadj zzadjVar2 = zzadj.VOID;
        int i5 = i4 - 1;
        if (i5 == 1 || i5 == 3) {
            zzadjVar.getClass();
        }
        if (i4 == 1) {
            zzadjVar.ordinal();
        }
    }

    public static zzacs[] values() {
        return (zzacs[]) f37399e.clone();
    }
}
