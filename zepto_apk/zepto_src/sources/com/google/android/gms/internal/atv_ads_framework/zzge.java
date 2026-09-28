package com.google.android.gms.internal.atv_ads_framework;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF3' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class zzge {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzge[] f36219b;

    /* renamed from: a, reason: collision with root package name */
    public final zzgf f36220a;

    /* JADX INFO: Fake field, exist only in values array */
    zzge EF1;

    /* JADX INFO: Fake field, exist only in values array */
    zzge EF2;

    /* JADX INFO: Fake field, exist only in values array */
    zzge EF3;

    static {
        zzge zzgeVar = new zzge("DOUBLE", 0, zzgf.DOUBLE);
        zzge zzgeVar2 = new zzge("FLOAT", 1, zzgf.FLOAT);
        zzgf zzgfVar = zzgf.LONG;
        zzge zzgeVar3 = new zzge("INT64", 2, zzgfVar);
        zzge zzgeVar4 = new zzge("UINT64", 3, zzgfVar);
        zzgf zzgfVar2 = zzgf.INT;
        zzge zzgeVar5 = new zzge("INT32", 4, zzgfVar2);
        zzge zzgeVar6 = new zzge("FIXED64", 5, zzgfVar);
        zzge zzgeVar7 = new zzge("FIXED32", 6, zzgfVar2);
        zzge zzgeVar8 = new zzge("BOOL", 7, zzgf.BOOLEAN);
        zzge zzgeVar9 = new zzge("STRING", 8, zzgf.STRING);
        zzgf zzgfVar3 = zzgf.MESSAGE;
        f36219b = new zzge[]{zzgeVar, zzgeVar2, zzgeVar3, zzgeVar4, zzgeVar5, zzgeVar6, zzgeVar7, zzgeVar8, zzgeVar9, new zzge("GROUP", 9, zzgfVar3), new zzge(MerchantConstants.MESSAGE, 10, zzgfVar3), new zzge("BYTES", 11, zzgf.BYTE_STRING), new zzge("UINT32", 12, zzgfVar2), new zzge("ENUM", 13, zzgf.ENUM), new zzge("SFIXED32", 14, zzgfVar2), new zzge("SFIXED64", 15, zzgfVar), new zzge("SINT32", 16, zzgfVar2), new zzge("SINT64", 17, zzgfVar)};
    }

    public zzge(String str, int i2, zzgf zzgfVar) {
        this.f36220a = zzgfVar;
    }

    public static zzge[] values() {
        return (zzge[]) f36219b.clone();
    }
}
