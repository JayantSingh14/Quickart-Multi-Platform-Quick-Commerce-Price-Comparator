package com.google.android.gms.internal.auth;

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
public final class zzho {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzho[] f36431b;

    /* renamed from: a, reason: collision with root package name */
    public final zzhp f36432a;

    /* JADX INFO: Fake field, exist only in values array */
    zzho EF1;

    /* JADX INFO: Fake field, exist only in values array */
    zzho EF2;

    /* JADX INFO: Fake field, exist only in values array */
    zzho EF3;

    static {
        zzho zzhoVar = new zzho("DOUBLE", 0, zzhp.DOUBLE);
        zzho zzhoVar2 = new zzho("FLOAT", 1, zzhp.FLOAT);
        zzhp zzhpVar = zzhp.LONG;
        zzho zzhoVar3 = new zzho("INT64", 2, zzhpVar);
        zzho zzhoVar4 = new zzho("UINT64", 3, zzhpVar);
        zzhp zzhpVar2 = zzhp.INT;
        zzho zzhoVar5 = new zzho("INT32", 4, zzhpVar2);
        zzho zzhoVar6 = new zzho("FIXED64", 5, zzhpVar);
        zzho zzhoVar7 = new zzho("FIXED32", 6, zzhpVar2);
        zzho zzhoVar8 = new zzho("BOOL", 7, zzhp.BOOLEAN);
        zzho zzhoVar9 = new zzho("STRING", 8, zzhp.STRING);
        zzhp zzhpVar3 = zzhp.MESSAGE;
        f36431b = new zzho[]{zzhoVar, zzhoVar2, zzhoVar3, zzhoVar4, zzhoVar5, zzhoVar6, zzhoVar7, zzhoVar8, zzhoVar9, new zzho("GROUP", 9, zzhpVar3), new zzho(MerchantConstants.MESSAGE, 10, zzhpVar3), new zzho("BYTES", 11, zzhp.BYTE_STRING), new zzho("UINT32", 12, zzhpVar2), new zzho("ENUM", 13, zzhp.ENUM), new zzho("SFIXED32", 14, zzhpVar2), new zzho("SFIXED64", 15, zzhpVar), new zzho("SINT32", 16, zzhpVar2), new zzho("SINT64", 17, zzhpVar)};
    }

    public zzho(String str, int i2, zzhp zzhpVar) {
        this.f36432a = zzhpVar;
    }

    public static zzho[] values() {
        return (zzho[]) f36431b.clone();
    }
}
