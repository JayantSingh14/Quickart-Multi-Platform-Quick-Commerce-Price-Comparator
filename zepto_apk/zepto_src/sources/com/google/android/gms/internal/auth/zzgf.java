package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
final class zzgf {

    /* renamed from: c, reason: collision with root package name */
    public static final zzgf f36386c = new zzgf();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f36388b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final zzfp f36387a = new zzfp();

    public final zzgi a(Class cls) {
        zzgi zzgiVarN;
        Class cls2;
        Charset charset = zzfa.f36355a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f36388b;
        zzgi zzgiVar = (zzgi) concurrentHashMap.get(cls);
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzfp zzfpVar = this.f36387a;
        zzfpVar.getClass();
        Class cls3 = zzgk.f36395a;
        if (!zzev.class.isAssignableFrom(cls) && (cls2 = zzgk.f36395a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        zzfu zzfuVarZzb = zzfpVar.f36365a.zzb(cls);
        if (zzfuVarZzb.zzb()) {
            if (zzev.class.isAssignableFrom(cls)) {
                zzgiVarN = new zzgb(zzgk.f36397c, zzeo.f36343a, zzfuVarZzb.zza());
            } else {
                zzgz zzgzVar = zzgk.f36396b;
                zzem zzemVar = zzeo.f36344b;
                if (zzemVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                zzgiVarN = new zzgb(zzgzVar, zzemVar, zzfuVarZzb.zza());
            }
        } else if (zzev.class.isAssignableFrom(cls)) {
            if (zzfuVarZzb.zzc() - 1 != 1) {
                int i2 = zzgd.f36385a;
                zzfj zzfjVar = zzfl.f36360b;
                zzhb zzhbVar = zzgk.f36397c;
                zzen zzenVar = zzeo.f36343a;
                int i3 = zzft.f36368a;
                zzgiVarN = zzga.n(zzfuVarZzb, zzfjVar, zzhbVar);
            } else {
                int i4 = zzgd.f36385a;
                zzfj zzfjVar2 = zzfl.f36360b;
                zzhb zzhbVar2 = zzgk.f36397c;
                int i5 = zzft.f36368a;
                zzgiVarN = zzga.n(zzfuVarZzb, zzfjVar2, zzhbVar2);
            }
        } else if (zzfuVarZzb.zzc() - 1 != 1) {
            int i6 = zzgd.f36385a;
            zzfh zzfhVar = zzfl.f36359a;
            zzgz zzgzVar2 = zzgk.f36396b;
            if (zzeo.f36344b == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            int i7 = zzft.f36368a;
            zzgiVarN = zzga.n(zzfuVarZzb, zzfhVar, zzgzVar2);
        } else {
            int i8 = zzgd.f36385a;
            zzfh zzfhVar2 = zzfl.f36359a;
            zzgz zzgzVar3 = zzgk.f36396b;
            int i9 = zzft.f36368a;
            zzgiVarN = zzga.n(zzfuVarZzb, zzfhVar2, zzgzVar3);
        }
        zzgi zzgiVar2 = (zzgi) concurrentHashMap.putIfAbsent(cls, zzgiVarN);
        return zzgiVar2 == null ? zzgiVarN : zzgiVar2;
    }
}
