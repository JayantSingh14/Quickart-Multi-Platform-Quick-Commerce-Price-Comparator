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
/* loaded from: classes4.dex */
public final class zzos {

    /* renamed from: c, reason: collision with root package name */
    public static final zzos f37202c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzos f37203d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ zzos[] f37204e;

    /* renamed from: a, reason: collision with root package name */
    public final zzot f37205a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37206b;

    /* JADX INFO: Fake field, exist only in values array */
    zzos EF1;

    /* JADX INFO: Fake field, exist only in values array */
    zzos EF2;

    /* JADX INFO: Fake field, exist only in values array */
    zzos EF0;

    static {
        zzos zzosVar = new zzos("DOUBLE", 0, zzot.f37210d, 1);
        zzos zzosVar2 = new zzos("FLOAT", 1, zzot.f37209c, 5);
        zzot zzotVar = zzot.f37208b;
        zzos zzosVar3 = new zzos("INT64", 2, zzotVar, 0);
        zzos zzosVar4 = new zzos("UINT64", 3, zzotVar, 0);
        zzot zzotVar2 = zzot.f37207a;
        zzos zzosVar5 = new zzos("INT32", 4, zzotVar2, 0);
        zzos zzosVar6 = new zzos("FIXED64", 5, zzotVar, 1);
        zzos zzosVar7 = new zzos("FIXED32", 6, zzotVar2, 5);
        zzos zzosVar8 = new zzos("BOOL", 7, zzot.f37211e, 0);
        zzos zzosVar9 = new zzos("STRING", 8, zzot.f37212f, 2);
        f37202c = zzosVar9;
        zzot zzotVar3 = zzot.f37215i;
        zzos zzosVar10 = new zzos("GROUP", 9, zzotVar3, 3);
        f37203d = zzosVar10;
        f37204e = new zzos[]{zzosVar, zzosVar2, zzosVar3, zzosVar4, zzosVar5, zzosVar6, zzosVar7, zzosVar8, zzosVar9, zzosVar10, new zzos(MerchantConstants.MESSAGE, 10, zzotVar3, 2), new zzos("BYTES", 11, zzot.f37213g, 2), new zzos("UINT32", 12, zzotVar2, 0), new zzos("ENUM", 13, zzot.f37214h, 0), new zzos("SFIXED32", 14, zzotVar2, 5), new zzos("SFIXED64", 15, zzotVar, 1), new zzos("SINT32", 16, zzotVar2, 0), new zzos("SINT64", 17, zzotVar, 0)};
    }

    public zzos(String str, int i2, zzot zzotVar, int i3) {
        this.f37205a = zzotVar;
        this.f37206b = i3;
    }

    public static zzos[] values() {
        return (zzos[]) f37204e.clone();
    }

    public final zzot a() {
        return this.f37205a;
    }

    public final int b() {
        return this.f37206b;
    }
}
