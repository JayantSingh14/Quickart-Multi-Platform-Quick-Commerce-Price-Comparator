package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes3.dex */
public final class zztx {
    static final zztr zza = zztr.zza;
    static final zztq zzb = zztp.IDENTITY;
    static final zzus zzc = zzur.DOUBLE;
    static final zzus zzd = zzur.LAZILY_PARSED_NUMBER;
    public static final /* synthetic */ int zzo = 0;
    final List zze;
    final zzvy zzf;
    final zztq zzg;
    final Map zzh;
    final zztr zzi;
    final List zzj;
    final List zzk;
    final zzus zzl;
    final zzus zzm;
    final List zzn;
    private final ThreadLocal zzp;
    private final ConcurrentMap zzq;
    private final zzvw zzr;
    private final zzxi zzs;

    /* JADX WARN: Illegal instructions before constructor call */
    public zztx() {
        zzvy zzvyVar = zzvy.zza;
        zztq zztqVar = zzb;
        Map map = Collections.EMPTY_MAP;
        zztr zztrVar = zza;
        List list = Collections.EMPTY_LIST;
        this(zzvyVar, zztqVar, map, false, false, false, true, zztrVar, null, false, true, 1, null, 2, 2, list, list, list, zzc, zzd, list);
    }

    public static void zzg(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static final void zzi(zzuc zzucVar, zzaas zzaasVar) throws zzud {
        zzuq zzuqVarZzn = zzaasVar.zzn();
        boolean zZzt = zzaasVar.zzt();
        boolean zZzs = zzaasVar.zzs();
        zzaasVar.zzp(true);
        zzaasVar.zzq(false);
        if (zzaasVar.zzn() != zzuq.STRICT) {
            zzaasVar.zzr(zzuq.LENIENT);
        }
        try {
            try {
                try {
                    zzzt.zzV.write(zzaasVar, zzucVar);
                } catch (IOException e2) {
                    throw new zzud(e2);
                }
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            zzaasVar.zzr(zzuqVarZzn);
            zzaasVar.zzp(zZzt);
            zzaasVar.zzq(zZzs);
        }
    }

    public final String toString() {
        return b.m("{serializeNulls:false,factories:", String.valueOf(this.zze), ",instanceCreators:", this.zzr.toString(), "}");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        r4.zzb(r6);
        r0.put(r9, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.internal.zzuu zza(com.google.ads.interactivemedia.v3.internal.zzaao r9) {
        /*
            r8 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r9, r0)
            java.util.concurrent.ConcurrentMap r0 = r8.zzq
            java.lang.Object r0 = r0.get(r9)
            com.google.ads.interactivemedia.v3.internal.zzuu r0 = (com.google.ads.interactivemedia.v3.internal.zzuu) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal r0 = r8.zzp
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L28
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal r3 = r8.zzp
            r3.set(r0)
            r3 = r2
            goto L31
        L28:
            java.lang.Object r3 = r0.get(r9)
            com.google.ads.interactivemedia.v3.internal.zzuu r3 = (com.google.ads.interactivemedia.v3.internal.zzuu) r3
            if (r3 != 0) goto L86
            r3 = r1
        L31:
            com.google.ads.interactivemedia.v3.internal.zztw r4 = new com.google.ads.interactivemedia.v3.internal.zztw     // Catch: java.lang.Throwable -> L59
            r4.<init>()     // Catch: java.lang.Throwable -> L59
            r0.put(r9, r4)     // Catch: java.lang.Throwable -> L59
            java.util.List r5 = r8.zze     // Catch: java.lang.Throwable -> L59
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L59
            r6 = 0
        L40:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Throwable -> L59
            if (r7 == 0) goto L5b
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L59
            com.google.ads.interactivemedia.v3.internal.zzuv r6 = (com.google.ads.interactivemedia.v3.internal.zzuv) r6     // Catch: java.lang.Throwable -> L59
            com.google.ads.interactivemedia.v3.internal.zzuu r6 = r6.zza(r8, r9)     // Catch: java.lang.Throwable -> L59
            if (r6 == 0) goto L40
            r4.zzb(r6)     // Catch: java.lang.Throwable -> L59
            r0.put(r9, r6)     // Catch: java.lang.Throwable -> L59
            goto L5b
        L59:
            r9 = move-exception
            goto L7d
        L5b:
            if (r3 == 0) goto L63
            java.lang.ThreadLocal r1 = r8.zzp
            r1.remove()
            r1 = r2
        L63:
            if (r6 == 0) goto L6d
            if (r1 == 0) goto L6c
            java.util.concurrent.ConcurrentMap r9 = r8.zzq
            r9.putAll(r0)
        L6c:
            return r6
        L6d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r1 = "GSON (2.10.1) cannot handle "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        L7d:
            if (r3 != 0) goto L80
            goto L85
        L80:
            java.lang.ThreadLocal r0 = r8.zzp
            r0.remove()
        L85:
            throw r9
        L86:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zztx.zza(com.google.ads.interactivemedia.v3.internal.zzaao):com.google.ads.interactivemedia.v3.internal.zzuu");
    }

    public final zzuu zzb(zzuv zzuvVar, zzaao zzaaoVar) {
        Objects.requireNonNull(zzuvVar, "skipPast must not be null");
        Objects.requireNonNull(zzaaoVar, "type must not be null");
        if (this.zzs.zzc(zzaaoVar, zzuvVar)) {
            zzuvVar = this.zzs;
        }
        boolean z = false;
        for (zzuv zzuvVar2 : this.zze) {
            if (z) {
                zzuu zzuuVarZza = zzuvVar2.zza(this, zzaaoVar);
                if (zzuuVarZza != null) {
                    return zzuuVarZza;
                }
            } else if (zzuvVar2 == zzuvVar) {
                z = true;
            }
        }
        if (z) {
            throw new IllegalArgumentException("GSON cannot serialize or deserialize ".concat(String.valueOf(zzaaoVar)));
        }
        return zza(zzaaoVar);
    }

    public final zzaas zzc(Writer writer) throws IOException {
        zzaas zzaasVar = new zzaas(writer);
        zzaasVar.zzo(this.zzi);
        zzaasVar.zzp(true);
        zzaasVar.zzr(zzuq.LEGACY_STRICT);
        zzaasVar.zzq(false);
        return zzaasVar;
    }

    public final Object zzd(zzaaq zzaaqVar, zzaao zzaaoVar) throws zzuk, zzud {
        boolean z;
        Object obj;
        zzuq zzuqVarZzt = zzaaqVar.zzt();
        if (zzaaqVar.zzt() != zzuq.STRICT) {
            zzaaqVar.zzw(zzuq.LENIENT);
        }
        try {
            try {
                try {
                    try {
                        try {
                            zzaaqVar.zzr();
                            z = false;
                        } catch (IOException e2) {
                            throw new zzuk(e2);
                        }
                    } catch (IllegalStateException e3) {
                        throw new zzuk(e3);
                    }
                } catch (AssertionError e4) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e4.getMessage(), e4);
                }
            } finally {
                zzaaqVar.zzw(zzuqVarZzt);
            }
        } catch (EOFException e5) {
            e = e5;
            z = true;
        }
        try {
            obj = zza(zzaaoVar).read(zzaaqVar);
        } catch (EOFException e6) {
            e = e6;
            if (!z) {
                throw new zzuk(e);
            }
            obj = null;
            return obj;
        }
        return obj;
    }

    public final Object zze(String str, Class cls) throws zzuk, zzud {
        Object obj;
        zzaao zzaaoVarZza = zzaao.zza(cls);
        if (str == null) {
            obj = null;
        } else {
            zzaaq zzaaqVar = new zzaaq(new StringReader(str));
            zzaaqVar.zzw(zzuq.LEGACY_STRICT);
            Object objZzd = zzd(zzaaqVar, zzaaoVarZza);
            if (objZzd != null) {
                try {
                    if (zzaaqVar.zzr() != 10) {
                        throw new zzuk("JSON document was not fully consumed.");
                    }
                } catch (zzaat e2) {
                    throw new zzuk(e2);
                } catch (IOException e3) {
                    throw new zzud(e3);
                }
            }
            obj = objZzd;
        }
        if (cls == Integer.TYPE) {
            cls = Integer.class;
        } else if (cls == Float.TYPE) {
            cls = Float.class;
        } else if (cls == Byte.TYPE) {
            cls = Byte.class;
        } else if (cls == Double.TYPE) {
            cls = Double.class;
        } else if (cls == Long.TYPE) {
            cls = Long.class;
        } else if (cls == Character.TYPE) {
            cls = Character.class;
        } else if (cls == Boolean.TYPE) {
            cls = Boolean.class;
        } else if (cls == Short.TYPE) {
            cls = Short.class;
        } else if (cls == Void.TYPE) {
            cls = Void.class;
        }
        return cls.cast(obj);
    }

    public final String zzf(Object obj) {
        if (obj == null) {
            zzue zzueVar = zzue.zza;
            StringWriter stringWriter = new StringWriter();
            try {
                zzi(zzueVar, zzc(stringWriter));
                return stringWriter.toString();
            } catch (IOException e2) {
                throw new zzud(e2);
            }
        }
        StringWriter stringWriter2 = new StringWriter();
        try {
            zzh(obj, obj.getClass(), zzc(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e3) {
            throw new zzud(e3);
        }
    }

    public final void zzh(Object obj, Type type, zzaas zzaasVar) throws zzud {
        zzuu zzuuVarZza = zza(zzaao.zzb(type));
        zzuq zzuqVarZzn = zzaasVar.zzn();
        if (zzaasVar.zzn() != zzuq.STRICT) {
            zzaasVar.zzr(zzuq.LENIENT);
        }
        boolean zZzt = zzaasVar.zzt();
        boolean zZzs = zzaasVar.zzs();
        zzaasVar.zzp(true);
        zzaasVar.zzq(false);
        try {
            try {
                zzuuVarZza.write(zzaasVar, obj);
            } catch (IOException e2) {
                throw new zzud(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            zzaasVar.zzr(zzuqVarZzn);
            zzaasVar.zzp(zZzt);
            zzaasVar.zzq(zZzs);
        }
    }

    public zztx(zzvy zzvyVar, zztq zztqVar, Map map, boolean z, boolean z2, boolean z3, boolean z4, zztr zztrVar, zzuq zzuqVar, boolean z5, boolean z6, int i2, String str, int i3, int i4, List list, List list2, List list3, zzus zzusVar, zzus zzusVar2, List list4) {
        this.zzp = new ThreadLocal();
        this.zzq = new ConcurrentHashMap();
        this.zzf = zzvyVar;
        this.zzg = zztqVar;
        this.zzh = map;
        zzvw zzvwVar = new zzvw(map, true, list4);
        this.zzr = zzvwVar;
        this.zzi = zztrVar;
        this.zzj = list;
        this.zzk = list2;
        this.zzl = zzusVar;
        this.zzm = zzusVar2;
        this.zzn = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzzt.zzW);
        arrayList.add(zzxt.zza(zzusVar));
        arrayList.add(zzvyVar);
        arrayList.addAll(list3);
        arrayList.add(zzzt.zzC);
        arrayList.add(zzzt.zzm);
        arrayList.add(zzzt.zzg);
        arrayList.add(zzzt.zzi);
        arrayList.add(zzzt.zzk);
        zzuu zzuuVar = zzzt.zzt;
        arrayList.add(zzzt.zzc(Long.TYPE, Long.class, zzuuVar));
        arrayList.add(zzzt.zzc(Double.TYPE, Double.class, new zzts(this)));
        arrayList.add(zzzt.zzc(Float.TYPE, Float.class, new zztt(this)));
        arrayList.add(zzxq.zza(zzusVar2));
        arrayList.add(zzzt.zzo);
        arrayList.add(zzzt.zzq);
        arrayList.add(zzzt.zzb(AtomicLong.class, new zztu(zzuuVar).nullSafe()));
        arrayList.add(zzzt.zzb(AtomicLongArray.class, new zztv(zzuuVar).nullSafe()));
        arrayList.add(zzzt.zzs);
        arrayList.add(zzzt.zzx);
        arrayList.add(zzzt.zzE);
        arrayList.add(zzzt.zzG);
        arrayList.add(zzzt.zzb(BigDecimal.class, zzzt.zzz));
        arrayList.add(zzzt.zzb(BigInteger.class, zzzt.zzA));
        arrayList.add(zzzt.zzb(zzwb.class, zzzt.zzB));
        arrayList.add(zzzt.zzI);
        arrayList.add(zzzt.zzK);
        arrayList.add(zzzt.zzO);
        arrayList.add(zzzt.zzQ);
        arrayList.add(zzzt.zzU);
        arrayList.add(zzzt.zzM);
        arrayList.add(zzzt.zzd);
        arrayList.add(zzxf.zza);
        arrayList.add(zzzt.zzS);
        if (zzaan.zza) {
            arrayList.add(zzaan.zze);
            arrayList.add(zzaan.zzd);
            arrayList.add(zzaan.zzf);
        }
        arrayList.add(zzwy.zza);
        arrayList.add(zzzt.zzb);
        arrayList.add(new zzxa(zzvwVar));
        arrayList.add(new zzxo(zzvwVar, false));
        zzxi zzxiVar = new zzxi(zzvwVar);
        this.zzs = zzxiVar;
        arrayList.add(zzxiVar);
        arrayList.add(zzzt.zzX);
        arrayList.add(new zzyb(zzvwVar, zztqVar, zzvyVar, zzxiVar, list4));
        this.zze = Collections.unmodifiableList(arrayList);
    }
}
