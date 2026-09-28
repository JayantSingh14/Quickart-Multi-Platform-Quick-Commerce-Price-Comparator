package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzacg {
    private static final zzacg zzb = new zzacg(true);
    final zzafg zza = new zzaew(16);
    private boolean zzc;
    private boolean zzd;

    private zzacg() {
    }

    public static int zza(zzaga zzagaVar, int i2, Object obj) {
        zzabw.zzw(i2 << 3);
        if (zzaga.zzj == null) {
            byte[] bArr = zzacx.zzd;
            if (((zzadz) obj) instanceof zzaaw) {
                throw null;
            }
        }
        zzagb zzagbVar = zzagb.INT;
        throw null;
    }

    public static int zzb(zzacf zzacfVar, Object obj) {
        zzaga zzagaVarZzd = zzacfVar.zzd();
        int iZza = zzacfVar.zza();
        if (!zzacfVar.zzg()) {
            return zza(zzagaVarZzd, iZza, obj);
        }
        List list = (List) obj;
        int iZza2 = 0;
        if (!zzacfVar.zzf()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iZza2 += zza(zzagaVarZzd, iZza, it.next());
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        if (!it2.hasNext()) {
            return zzabw.zzw(0) + zzabw.zzw(iZza << 3);
        }
        it2.next();
        zzaga zzagaVar = zzaga.zza;
        zzagb zzagbVar = zzagb.INT;
        throw null;
    }

    public static zzacg zzd() {
        return zzb;
    }

    private static Object zzk(Object obj) {
        if (obj instanceof zzaee) {
            return ((zzaee) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzl(Map.Entry entry) {
        zzacf zzacfVar = (zzacf) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzade;
        if (zzacfVar.zzg()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZze = zze(zzacfVar);
            if (objZze == null) {
                objZze = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZze).add(zzk(it.next()));
            }
            this.zza.put(zzacfVar, objZze);
            return;
        }
        if (zzacfVar.zze() != zzagb.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zzacfVar, zzk(value));
            return;
        }
        Object objZze2 = zze(zzacfVar);
        if (objZze2 != null) {
            if (z) {
                throw null;
            }
            this.zza.put(zzacfVar, objZze2 instanceof zzaee ? zzacfVar.zzc((zzaee) objZze2, (zzaee) value) : zzacfVar.zzb(((zzadz) objZze2).zzaQ(), (zzadz) value).zzan());
        } else {
            this.zza.put(zzacfVar, zzk(value));
            if (z) {
                this.zzd = true;
            }
        }
    }

    private static boolean zzm(Map.Entry entry) {
        zzacf zzacfVar = (zzacf) entry.getKey();
        if (zzacfVar.zze() != zzagb.MESSAGE) {
            return true;
        }
        if (!zzacfVar.zzg()) {
            return zzn(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!zzn(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzn(Object obj) {
        if (obj instanceof zzaea) {
            return ((zzaea) obj).zzaT();
        }
        if (obj instanceof zzade) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int i2;
        int iZzw;
        int iW;
        zzacf zzacfVar = (zzacf) entry.getKey();
        Object value = entry.getValue();
        if (zzacfVar.zze() != zzagb.MESSAGE || zzacfVar.zzg() || zzacfVar.zzf()) {
            return zzb(zzacfVar, value);
        }
        if (value instanceof zzade) {
            int iZza = ((zzacf) entry.getKey()).zza();
            int iZzw2 = zzabw.zzw(8);
            i2 = iZzw2 + iZzw2;
            iZzw = zzabw.zzw(iZza) + zzabw.zzw(16);
            int iZzw3 = zzabw.zzw(24);
            int iZza2 = ((zzade) value).zza();
            iW = android.support.v4.media.a.w(iZza2, iZza2, iZzw3);
        } else {
            int iZza3 = ((zzacf) entry.getKey()).zza();
            int iZzw4 = zzabw.zzw(8);
            i2 = iZzw4 + iZzw4;
            iZzw = zzabw.zzw(iZza3) + zzabw.zzw(16);
            int iZzw5 = zzabw.zzw(24);
            int iZzax = ((zzadz) value).zzax();
            iW = android.support.v4.media.a.w(iZzax, iZzax, iZzw5);
        }
        return i2 + iZzw + iW;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzp(com.google.ads.interactivemedia.v3.internal.zzacf r2, java.lang.Object r3) {
        /*
            com.google.ads.interactivemedia.v3.internal.zzaga r0 = r2.zzd()
            byte[] r1 = com.google.ads.interactivemedia.v3.internal.zzacx.zzd
            r3.getClass()
            com.google.ads.interactivemedia.v3.internal.zzaga r1 = com.google.ads.interactivemedia.v3.internal.zzaga.zza
            com.google.ads.interactivemedia.v3.internal.zzagb r1 = com.google.ads.interactivemedia.v3.internal.zzagb.INT
            com.google.ads.interactivemedia.v3.internal.zzagb r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r3 instanceof com.google.ads.interactivemedia.v3.internal.zzadz
            if (r0 != 0) goto L21
            boolean r0 = r3 instanceof com.google.ads.interactivemedia.v3.internal.zzade
            if (r0 == 0) goto L48
        L21:
            return
        L22:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L2a
            boolean r0 = r3 instanceof com.google.ads.interactivemedia.v3.internal.zzacs
            if (r0 == 0) goto L48
        L2a:
            return
        L2b:
            boolean r0 = r3 instanceof com.google.ads.interactivemedia.v3.internal.zzabn
            if (r0 != 0) goto L33
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L48
        L33:
            return
        L34:
            boolean r0 = r3 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r3 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r3 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r3 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r3 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.ads.interactivemedia.v3.internal.zzaga r2 = r2.zzd()
            com.google.ads.interactivemedia.v3.internal.zzagb r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzacg.zzp(com.google.ads.interactivemedia.v3.internal.zzacf, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzacg zzacgVar = new zzacg();
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            Map.Entry entryZzg = this.zza.zzg(i2);
            zzacgVar.zzi((zzacf) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzacgVar.zzi((zzacf) entry.getKey(), entry.getValue());
        }
        zzacgVar.zzd = this.zzd;
        return zzacgVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzacg) {
            return this.zza.equals(((zzacg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int iZzo = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            iZzo += zzo(this.zza.zzg(i2));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            iZzo += zzo((Map.Entry) it.next());
        }
        return iZzo;
    }

    public final Object zze(zzacf zzacfVar) {
        Object obj = this.zza.get(zzacfVar);
        if (obj instanceof zzade) {
            throw null;
        }
        return obj;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzadd(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            Map.Entry entryZzg = this.zza.zzg(i2);
            if (entryZzg.getValue() instanceof zzacq) {
                ((zzacq) entryZzg.getValue()).zzaJ();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzacg zzacgVar) {
        for (int i2 = 0; i2 < zzacgVar.zza.zzb(); i2++) {
            zzl(zzacgVar.zza.zzg(i2));
        }
        Iterator it = zzacgVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzl((Map.Entry) it.next());
        }
    }

    public final void zzi(zzacf zzacfVar, Object obj) {
        if (!zzacfVar.zzg()) {
            zzp(zzacfVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                zzp(zzacfVar, arrayList.get(i2));
            }
            obj = arrayList;
        }
        if (obj instanceof zzade) {
            this.zzd = true;
        }
        this.zza.put(zzacfVar, obj);
    }

    public final boolean zzj() {
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            if (!zzm(this.zza.zzg(i2))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzm((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzacg(boolean z) {
        zzg();
        zzg();
    }
}
