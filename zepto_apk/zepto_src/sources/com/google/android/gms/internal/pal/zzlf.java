package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzlf {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f37911a = Logger.getLogger(zzlf.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f37912b = new AtomicReference(new zzki());

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f37913c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f37914d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap f37915e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap f37916f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap f37917g = new ConcurrentHashMap();

    public static zzju a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        ConcurrentHashMap concurrentHashMap = f37915e;
        Locale locale = Locale.US;
        zzju zzjuVar = (zzju) concurrentHashMap.get(str.toLowerCase(locale));
        if (zzjuVar != null) {
            return zzjuVar;
        }
        String strD = android.support.v4.media.b.D("no catalogue found for ", str, ". ");
        if (str.toLowerCase(locale).startsWith("tinkaead")) {
            strD = strD.concat("Maybe call AeadConfig.register().");
        }
        if (str.toLowerCase(locale).startsWith("tinkdeterministicaead")) {
            strD = String.valueOf(strD).concat("Maybe call DeterministicAeadConfig.register().");
        } else if (str.toLowerCase(locale).startsWith("tinkstreamingaead")) {
            strD = String.valueOf(strD).concat("Maybe call StreamingAeadConfig.register().");
        } else if (str.toLowerCase(locale).startsWith("tinkhybriddecrypt") || str.toLowerCase(locale).startsWith("tinkhybridencrypt")) {
            strD = String.valueOf(strD).concat("Maybe call HybridConfig.register().");
        } else if (str.toLowerCase(locale).startsWith("tinkmac")) {
            strD = String.valueOf(strD).concat("Maybe call MacConfig.register().");
        } else if (str.toLowerCase(locale).startsWith("tinkpublickeysign") || str.toLowerCase(locale).startsWith("tinkpublickeyverify")) {
            strD = String.valueOf(strD).concat("Maybe call SignatureConfig.register().");
        } else if (str.toLowerCase(locale).startsWith("tink")) {
            strD = String.valueOf(strD).concat("Maybe call TinkConfig.register().");
        }
        throw new GeneralSecurityException(strD);
    }

    public static synchronized zzaef b(zzvt zzvtVar) {
        zzkb zzkbVarZzb;
        zzkbVarZzb = ((zzki) f37912b.get()).d(zzvtVar.s()).zzb();
        if (!((Boolean) f37914d.get(zzvtVar.s())).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzvtVar.s())));
        }
        return zzkbVarZzb.d(zzvtVar.r());
    }

    public static synchronized void c(zzpr zzprVar, zzpa zzpaVar) {
        try {
            AtomicReference atomicReference = f37912b;
            zzki zzkiVar = new zzki((zzki) atomicReference.get());
            zzkiVar.b(zzprVar, zzpaVar);
            String strD = zzprVar.d();
            String strD2 = zzpaVar.d();
            g(strD, zzprVar.a().c(), true);
            g(strD2, Collections.EMPTY_MAP, false);
            if (!((zzki) atomicReference.get()).f37886a.containsKey(strD)) {
                f37913c.put(strD, new zzle());
                h(zzprVar.d(), zzprVar.a().c());
            }
            ConcurrentHashMap concurrentHashMap = f37914d;
            concurrentHashMap.put(strD, Boolean.TRUE);
            concurrentHashMap.put(strD2, Boolean.FALSE);
            atomicReference.set(zzkiVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void d(zzkb zzkbVar, boolean z) {
        if (zzkbVar == null) {
            throw new IllegalArgumentException("key manager must be non-null.");
        }
        AtomicReference atomicReference = f37912b;
        zzki zzkiVar = new zzki((zzki) atomicReference.get());
        synchronized (zzkiVar) {
            if (!zzna.a(1)) {
                throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
            }
            zzkiVar.e(new zzke(zzkbVar), false);
        }
        if (!zzna.a(1)) {
            throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
        }
        String strZzf = zzkbVar.zzf();
        g(strZzf, Collections.EMPTY_MAP, z);
        f37914d.put(strZzf, Boolean.valueOf(z));
        atomicReference.set(zzkiVar);
    }

    public static synchronized void e(zzpa zzpaVar) {
        try {
            AtomicReference atomicReference = f37912b;
            zzki zzkiVar = new zzki((zzki) atomicReference.get());
            zzkiVar.c(zzpaVar);
            String strD = zzpaVar.d();
            g(strD, zzpaVar.a().c(), true);
            if (!((zzki) atomicReference.get()).f37886a.containsKey(strD)) {
                f37913c.put(strD, new zzle());
                h(strD, zzpaVar.a().c());
            }
            f37914d.put(strD, Boolean.TRUE);
            atomicReference.set(zzkiVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void f(zzlc zzlcVar) {
        try {
            if (zzlcVar == null) {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            Class clsZzb = zzlcVar.zzb();
            ConcurrentHashMap concurrentHashMap = f37916f;
            if (concurrentHashMap.containsKey(clsZzb)) {
                zzlc zzlcVar2 = (zzlc) concurrentHashMap.get(clsZzb);
                if (!zzlcVar.getClass().getName().equals(zzlcVar2.getClass().getName())) {
                    f37911a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", "Attempted overwrite of a registered PrimitiveWrapper for type ".concat(clsZzb.toString()));
                    throw new GeneralSecurityException("PrimitiveWrapper for primitive (" + clsZzb.getName() + ") is already registered to be " + zzlcVar2.getClass().getName() + ", cannot be re-registered with " + zzlcVar.getClass().getName());
                }
            }
            concurrentHashMap.put(clsZzb, zzlcVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void g(String str, Map map, boolean z) {
        if (z) {
            try {
                ConcurrentHashMap concurrentHashMap = f37914d;
                if (concurrentHashMap.containsKey(str) && !((Boolean) concurrentHashMap.get(str)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
                }
                if (((zzki) f37912b.get()).f37886a.containsKey(str)) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!f37917g.containsKey(entry.getKey())) {
                            throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                        }
                    }
                } else {
                    for (Map.Entry entry2 : map.entrySet()) {
                        if (f37917g.containsKey(entry2.getKey())) {
                            throw new GeneralSecurityException("Attempted overwrite of a registered key template ".concat(String.valueOf((String) entry2.getKey())));
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void h(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            ConcurrentHashMap concurrentHashMap = f37917g;
            String str2 = (String) entry.getKey();
            byte[] bArrF = ((zzoy) entry.getValue()).f37988a.F();
            int i2 = ((zzoy) entry.getValue()).f37989b;
            zzvs zzvsVarP = zzvt.p();
            if (zzvsVarP.f37406c) {
                zzvsVarP.k();
                zzvsVarP.f37406c = false;
            }
            zzvt.t((zzvt) zzvsVarP.f37405b, str);
            zzaby zzabyVarQ = zzaby.q(0, bArrF, bArrF.length);
            if (zzvsVarP.f37406c) {
                zzvsVarP.k();
                zzvsVarP.f37406c = false;
            }
            ((zzvt) zzvsVarP.f37405b).zzf = zzabyVarQ;
            int i3 = i2 - 1;
            int i4 = i3 != 0 ? i3 != 1 ? 5 : 4 : 3;
            if (zzvsVarP.f37406c) {
                zzvsVarP.k();
                zzvsVarP.f37406c = false;
            }
            ((zzvt) zzvsVarP.f37405b).zzg = zzwu.a(i4);
            concurrentHashMap.put(str2, new zzkk((zzvt) zzvsVarP.h()));
        }
    }
}
