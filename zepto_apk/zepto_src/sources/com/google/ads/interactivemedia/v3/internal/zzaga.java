package com.google.ads.interactivemedia.v3.internal;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class zzaga {
    public static final zzaga zza;
    public static final zzaga zzb;
    public static final zzaga zzc;
    public static final zzaga zzd;
    public static final zzaga zze;
    public static final zzaga zzf;
    public static final zzaga zzg;
    public static final zzaga zzh;
    public static final zzaga zzi;
    public static final zzaga zzj;
    public static final zzaga zzk;
    public static final zzaga zzl;
    public static final zzaga zzm;
    public static final zzaga zzn;
    public static final zzaga zzo;
    public static final zzaga zzp;
    public static final zzaga zzq;
    public static final zzaga zzr;
    private static final /* synthetic */ zzaga[] zzs;
    private final zzagb zzt;

    static {
        zzaga zzagaVar = new zzaga("DOUBLE", 0, zzagb.DOUBLE, 1);
        zza = zzagaVar;
        zzaga zzagaVar2 = new zzaga("FLOAT", 1, zzagb.FLOAT, 5);
        zzb = zzagaVar2;
        zzagb zzagbVar = zzagb.LONG;
        zzaga zzagaVar3 = new zzaga("INT64", 2, zzagbVar, 0);
        zzc = zzagaVar3;
        zzaga zzagaVar4 = new zzaga("UINT64", 3, zzagbVar, 0);
        zzd = zzagaVar4;
        zzagb zzagbVar2 = zzagb.INT;
        zzaga zzagaVar5 = new zzaga("INT32", 4, zzagbVar2, 0);
        zze = zzagaVar5;
        zzaga zzagaVar6 = new zzaga("FIXED64", 5, zzagbVar, 1);
        zzf = zzagaVar6;
        zzaga zzagaVar7 = new zzaga("FIXED32", 6, zzagbVar2, 5);
        zzg = zzagaVar7;
        zzaga zzagaVar8 = new zzaga("BOOL", 7, zzagb.BOOLEAN, 0);
        zzh = zzagaVar8;
        zzaga zzagaVar9 = new zzaga("STRING", 8, zzagb.STRING, 2);
        zzi = zzagaVar9;
        zzagb zzagbVar3 = zzagb.MESSAGE;
        zzaga zzagaVar10 = new zzaga("GROUP", 9, zzagbVar3, 3);
        zzj = zzagaVar10;
        zzaga zzagaVar11 = new zzaga(MerchantConstants.MESSAGE, 10, zzagbVar3, 2);
        zzk = zzagaVar11;
        zzaga zzagaVar12 = new zzaga("BYTES", 11, zzagb.BYTE_STRING, 2);
        zzl = zzagaVar12;
        zzaga zzagaVar13 = new zzaga("UINT32", 12, zzagbVar2, 0);
        zzm = zzagaVar13;
        zzaga zzagaVar14 = new zzaga("ENUM", 13, zzagb.ENUM, 0);
        zzn = zzagaVar14;
        zzaga zzagaVar15 = new zzaga("SFIXED32", 14, zzagbVar2, 5);
        zzo = zzagaVar15;
        zzaga zzagaVar16 = new zzaga("SFIXED64", 15, zzagbVar, 1);
        zzp = zzagaVar16;
        zzaga zzagaVar17 = new zzaga("SINT32", 16, zzagbVar2, 0);
        zzq = zzagaVar17;
        zzaga zzagaVar18 = new zzaga("SINT64", 17, zzagbVar, 0);
        zzr = zzagaVar18;
        zzs = new zzaga[]{zzagaVar, zzagaVar2, zzagaVar3, zzagaVar4, zzagaVar5, zzagaVar6, zzagaVar7, zzagaVar8, zzagaVar9, zzagaVar10, zzagaVar11, zzagaVar12, zzagaVar13, zzagaVar14, zzagaVar15, zzagaVar16, zzagaVar17, zzagaVar18};
    }

    private zzaga(String str, int i2, zzagb zzagbVar, int i3) {
        this.zzt = zzagbVar;
    }

    public static zzaga[] values() {
        return (zzaga[]) zzs.clone();
    }

    public final zzagb zza() {
        return this.zzt;
    }
}
