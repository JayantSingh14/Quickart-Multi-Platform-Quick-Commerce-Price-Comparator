package com.google.android.gms.internal.atv_ads_framework;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
final class zzew {

    /* renamed from: c, reason: collision with root package name */
    public static final zzew f36171c = new zzew();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f36173b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final zzeg f36172a = new zzeg();

    public final zzey a(Class cls) {
        zzey zzeyVarL;
        Class cls2;
        Charset charset = zzdp.f36125a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f36173b;
        zzey zzeyVar = (zzey) concurrentHashMap.get(cls);
        if (zzeyVar != null) {
            return zzeyVar;
        }
        zzeg zzegVar = this.f36172a;
        zzegVar.getClass();
        Class cls3 = zzfa.f36181a;
        if (!zzdh.class.isAssignableFrom(cls) && (cls2 = zzfa.f36181a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        zzel zzelVarZzb = zzegVar.f36150a.zzb(cls);
        if (zzelVarZzb.zzb()) {
            if (zzdh.class.isAssignableFrom(cls)) {
                zzeyVarL = new zzes(zzfa.f36183c, zzda.f36109a, zzelVarZzb.zza());
            } else {
                zzfp zzfpVar = zzfa.f36182b;
                zzcy zzcyVar = zzda.f36110b;
                if (zzcyVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                zzeyVarL = new zzes(zzfpVar, zzcyVar, zzelVarZzb.zza());
            }
        } else if (zzdh.class.isAssignableFrom(cls)) {
            if (zzelVarZzb.zzc() == 1) {
                int i2 = zzeu.f36170a;
                zzea zzeaVar = zzec.f36145b;
                zzfr zzfrVar = zzfa.f36183c;
                zzcz zzczVar = zzda.f36109a;
                int i3 = zzek.f36152a;
                zzeyVarL = zzer.l(zzelVarZzb, zzeaVar, zzfrVar, zzczVar);
            } else {
                int i4 = zzeu.f36170a;
                zzea zzeaVar2 = zzec.f36145b;
                zzfr zzfrVar2 = zzfa.f36183c;
                int i5 = zzek.f36152a;
                zzeyVarL = zzer.l(zzelVarZzb, zzeaVar2, zzfrVar2, null);
            }
        } else if (zzelVarZzb.zzc() == 1) {
            int i6 = zzeu.f36170a;
            zzdy zzdyVar = zzec.f36144a;
            zzfp zzfpVar2 = zzfa.f36182b;
            zzcy zzcyVar2 = zzda.f36110b;
            if (zzcyVar2 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            int i7 = zzek.f36152a;
            zzeyVarL = zzer.l(zzelVarZzb, zzdyVar, zzfpVar2, zzcyVar2);
        } else {
            int i8 = zzeu.f36170a;
            zzdy zzdyVar2 = zzec.f36144a;
            zzfp zzfpVar3 = zzfa.f36182b;
            int i9 = zzek.f36152a;
            zzeyVarL = zzer.l(zzelVarZzb, zzdyVar2, zzfpVar3, null);
        }
        zzey zzeyVar2 = (zzey) concurrentHashMap.putIfAbsent(cls, zzeyVarL);
        return zzeyVar2 == null ? zzeyVarL : zzeyVar2;
    }
}
