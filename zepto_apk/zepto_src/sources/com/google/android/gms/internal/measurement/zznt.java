package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
final class zznt {

    /* renamed from: c, reason: collision with root package name */
    public static final zznt f37161c = new zznt();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f37163b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final zznc f37162a = new zznc();

    public final zznw a(Class cls) {
        Charset charset = zzmo.f37112a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f37163b;
        zznw zznwVarI = (zznw) concurrentHashMap.get(cls);
        if (zznwVarI == null) {
            zznc zzncVar = this.f37162a;
            zzncVar.getClass();
            zzoj zzojVar = zzny.f37172a;
            zzme.class.isAssignableFrom(cls);
            zzni zzniVarZzc = zzncVar.f37136a.zzc(cls);
            if (zzniVarZzc.zza()) {
                zzoj zzojVar2 = zzny.f37172a;
                zzls zzlsVar = zzlt.f37091a;
                zznwVarI = zznp.i(zzojVar2, zzniVarZzc.zzb());
            } else {
                int i2 = zznr.f37160a;
                int i3 = zzmy.f37129a;
                zzoj zzojVar3 = zzny.f37172a;
                zzls zzlsVar2 = zzniVarZzc.zzc() + (-1) != 1 ? zzlt.f37091a : null;
                int i4 = zznh.f37142a;
                zznwVarI = zzno.u(zzniVarZzc, zzojVar3, zzlsVar2);
            }
            zznw zznwVar = (zznw) concurrentHashMap.putIfAbsent(cls, zznwVarI);
            if (zznwVar != null) {
                return zznwVar;
            }
        }
        return zznwVarI;
    }
}
