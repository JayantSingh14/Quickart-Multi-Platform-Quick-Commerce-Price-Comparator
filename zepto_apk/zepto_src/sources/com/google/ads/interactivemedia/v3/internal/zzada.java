package com.google.ads.interactivemedia.v3.internal;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class zzada {
    public static final zzada zza;
    public static final zzada zzb;
    public static final zzada zzc;
    public static final zzada zzd;
    public static final zzada zze;
    public static final zzada zzf;
    public static final zzada zzg;
    public static final zzada zzh;
    public static final zzada zzi;
    public static final zzada zzj;
    private static final /* synthetic */ zzada[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzada zzadaVar = new zzada("VOID", 0, Void.class, Void.class, null);
        zza = zzadaVar;
        Class cls = Integer.TYPE;
        zzada zzadaVar2 = new zzada("INT", 1, cls, Integer.class, 0);
        zzb = zzadaVar2;
        zzada zzadaVar3 = new zzada("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzadaVar3;
        zzada zzadaVar4 = new zzada("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzadaVar4;
        zzada zzadaVar5 = new zzada("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzadaVar5;
        zzada zzadaVar6 = new zzada("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzadaVar6;
        zzada zzadaVar7 = new zzada("STRING", 6, String.class, String.class, "");
        zzg = zzadaVar7;
        zzada zzadaVar8 = new zzada("BYTE_STRING", 7, zzabn.class, zzabn.class, zzabn.zzb);
        zzh = zzadaVar8;
        zzada zzadaVar9 = new zzada("ENUM", 8, cls, Integer.class, null);
        zzi = zzadaVar9;
        zzada zzadaVar10 = new zzada(MerchantConstants.MESSAGE, 9, Object.class, Object.class, null);
        zzj = zzadaVar10;
        zzk = new zzada[]{zzadaVar, zzadaVar2, zzadaVar3, zzadaVar4, zzadaVar5, zzadaVar6, zzadaVar7, zzadaVar8, zzadaVar9, zzadaVar10};
    }

    private zzada(String str, int i2, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzada[] values() {
        return (zzada[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
