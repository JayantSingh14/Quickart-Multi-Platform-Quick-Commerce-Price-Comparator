package com.google.android.gms.internal.pal;

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
public final class zzafy {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzafy[] f37506b;

    /* renamed from: a, reason: collision with root package name */
    public final zzafz f37507a;

    /* JADX INFO: Fake field, exist only in values array */
    zzafy EF1;

    /* JADX INFO: Fake field, exist only in values array */
    zzafy EF2;

    /* JADX INFO: Fake field, exist only in values array */
    zzafy EF3;

    static {
        zzafy zzafyVar = new zzafy("DOUBLE", 0, zzafz.DOUBLE);
        zzafy zzafyVar2 = new zzafy("FLOAT", 1, zzafz.FLOAT);
        zzafz zzafzVar = zzafz.LONG;
        zzafy zzafyVar3 = new zzafy("INT64", 2, zzafzVar);
        zzafy zzafyVar4 = new zzafy("UINT64", 3, zzafzVar);
        zzafz zzafzVar2 = zzafz.INT;
        zzafy zzafyVar5 = new zzafy("INT32", 4, zzafzVar2);
        zzafy zzafyVar6 = new zzafy("FIXED64", 5, zzafzVar);
        zzafy zzafyVar7 = new zzafy("FIXED32", 6, zzafzVar2);
        zzafy zzafyVar8 = new zzafy("BOOL", 7, zzafz.BOOLEAN);
        zzafy zzafyVar9 = new zzafy("STRING", 8, zzafz.STRING);
        zzafz zzafzVar3 = zzafz.MESSAGE;
        f37506b = new zzafy[]{zzafyVar, zzafyVar2, zzafyVar3, zzafyVar4, zzafyVar5, zzafyVar6, zzafyVar7, zzafyVar8, zzafyVar9, new zzafy("GROUP", 9, zzafzVar3), new zzafy(MerchantConstants.MESSAGE, 10, zzafzVar3), new zzafy("BYTES", 11, zzafz.BYTE_STRING), new zzafy("UINT32", 12, zzafzVar2), new zzafy("ENUM", 13, zzafz.ENUM), new zzafy("SFIXED32", 14, zzafzVar2), new zzafy("SFIXED64", 15, zzafzVar), new zzafy("SINT32", 16, zzafzVar2), new zzafy("SINT64", 17, zzafzVar)};
    }

    public zzafy(String str, int i2, zzafz zzafzVar) {
        this.f37507a = zzafzVar;
    }

    public static zzafy[] values() {
        return (zzafy[]) f37506b.clone();
    }
}
