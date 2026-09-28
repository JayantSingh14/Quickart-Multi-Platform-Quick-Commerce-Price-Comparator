package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
final class zzicm {

    /* renamed from: c, reason: collision with root package name */
    public static final zzicm f34722c = new zzicm();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f34724b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final zzibt f34723a = new zzibt();

    public final zzicu a(Class cls) {
        Charset charset = zzibe.f34660a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f34724b;
        zzicu zzicgVar = (zzicu) concurrentHashMap.get(cls);
        if (zzicgVar == null) {
            zzibt zzibtVar = this.f34723a;
            zzibtVar.getClass();
            zzidh zzidhVar = zzicw.f34743a;
            if (!zziar.class.isAssignableFrom(cls)) {
                int i2 = zzhyy.f34536a;
            }
            zzibz zzibzVarZzc = zzibtVar.f34695a.zzc(cls);
            if (zzibzVarZzc.zza()) {
                int i3 = zzhyy.f34536a;
                zzidh zzidhVar2 = zzicw.f34743a;
                zziad zziadVar = zziae.f34623a;
                zzicgVar = new zzicg(zzidhVar2, zzibzVarZzc.zzb());
            } else {
                int i4 = zzhyy.f34536a;
                int i5 = zzicj.f34721a;
                int i6 = zzibp.f34688a;
                zzidh zzidhVar3 = zzicw.f34743a;
                zziad zziadVar2 = zzibzVarZzc.zzc() + (-1) != 1 ? zziae.f34623a : null;
                int i7 = zziby.f34702a;
                zzicgVar = zzicf.y(zzibzVarZzc, zzidhVar3, zziadVar2);
            }
            zzicu zzicuVar = (zzicu) concurrentHashMap.putIfAbsent(cls, zzicgVar);
            if (zzicuVar != null) {
                return zzicuVar;
            }
        }
        return zzicgVar;
    }
}
