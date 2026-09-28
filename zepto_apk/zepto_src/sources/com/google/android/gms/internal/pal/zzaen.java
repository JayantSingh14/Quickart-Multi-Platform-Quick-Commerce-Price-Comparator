package com.google.android.gms.internal.pal;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
final class zzaen {

    /* renamed from: c, reason: collision with root package name */
    public static final zzaen f37457c = new zzaen();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f37459b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final zzadx f37458a = new zzadx();

    public final zzaer a(Class cls) {
        zzaer zzaerVarB;
        Class cls2;
        Charset charset = zzadg.f37410a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f37459b;
        zzaer zzaerVar = (zzaer) concurrentHashMap.get(cls);
        if (zzaerVar != null) {
            return zzaerVar;
        }
        zzadx zzadxVar = this.f37458a;
        zzadxVar.getClass();
        Class cls3 = zzaet.f37467a;
        if (!zzacz.class.isAssignableFrom(cls) && (cls2 = zzaet.f37467a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        zzaec zzaecVarZzb = zzadxVar.f37434a.zzb(cls);
        if (zzaecVarZzb.zzb()) {
            if (zzacz.class.isAssignableFrom(cls)) {
                zzaerVarB = new zzaej(zzaet.f37470d, zzacp.f37391a, zzaecVarZzb.zza());
            } else {
                zzafi zzafiVar = zzaet.f37468b;
                zzacn zzacnVar = zzacp.f37392b;
                if (zzacnVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                zzaerVarB = new zzaej(zzafiVar, zzacnVar, zzaecVarZzb.zza());
            }
        } else if (zzacz.class.isAssignableFrom(cls)) {
            if (zzaecVarZzb.zzc() == 1) {
                int i2 = zzael.f37456a;
                zzaerVarB = zzaei.B(zzaecVarZzb, zzadt.f37429b, zzaet.f37470d, zzacp.f37391a, zzaeb.f37438b);
            } else {
                int i3 = zzael.f37456a;
                zzaerVarB = zzaei.B(zzaecVarZzb, zzadt.f37429b, zzaet.f37470d, null, zzaeb.f37438b);
            }
        } else if (zzaecVarZzb.zzc() == 1) {
            int i4 = zzael.f37456a;
            zzadp zzadpVar = zzadt.f37428a;
            zzafi zzafiVar2 = zzaet.f37468b;
            zzacn zzacnVar2 = zzacp.f37392b;
            if (zzacnVar2 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            zzaerVarB = zzaei.B(zzaecVarZzb, zzadpVar, zzafiVar2, zzacnVar2, zzaeb.f37437a);
        } else {
            int i5 = zzael.f37456a;
            zzaerVarB = zzaei.B(zzaecVarZzb, zzadt.f37428a, zzaet.f37469c, null, zzaeb.f37437a);
        }
        zzaer zzaerVar2 = (zzaer) concurrentHashMap.putIfAbsent(cls, zzaerVarB);
        return zzaerVar2 == null ? zzaerVarB : zzaerVar2;
    }
}
