package com.google.android.gms.internal.pal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzacr {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f37393c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final zzaeu f37394a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f37395b;

    static {
        new zzacr(0);
    }

    public zzacr() {
        this.f37394a = new zzaeu(16);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(com.google.android.gms.internal.pal.zzacq r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.pal.zzafy r0 = r2.zzb()
            java.nio.charset.Charset r1 = com.google.android.gms.internal.pal.zzadg.f37410a
            r3.getClass()
            com.google.android.gms.internal.pal.zzafy[] r1 = com.google.android.gms.internal.pal.zzafy.f37506b
            com.google.android.gms.internal.pal.zzafz r1 = com.google.android.gms.internal.pal.zzafz.INT
            com.google.android.gms.internal.pal.zzafz r0 = r0.f37507a
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r3 instanceof com.google.android.gms.internal.pal.zzaef
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof com.google.android.gms.internal.pal.zzadk
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof com.google.android.gms.internal.pal.zzadb
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r3 instanceof com.google.android.gms.internal.pal.zzaby
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.pal.zzafy r2 = r2.zzb()
            com.google.android.gms.internal.pal.zzafz r2 = r2.f37507a
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzacr.b(com.google.android.gms.internal.pal.zzacq, java.lang.Object):void");
    }

    public final void a(zzacq zzacqVar, Object obj) {
        if (!zzacqVar.zzc()) {
            b(zzacqVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                b(zzacqVar, arrayList.get(i2));
            }
            obj = arrayList;
        }
        boolean z = obj instanceof zzadk;
        this.f37394a.put(zzacqVar, obj);
    }

    public final Object clone() {
        zzaeu zzaeuVar;
        zzacr zzacrVar = new zzacr();
        int i2 = 0;
        while (true) {
            zzaeuVar = this.f37394a;
            if (i2 >= zzaeuVar.f37483b.size()) {
                break;
            }
            Map.Entry entry = (Map.Entry) zzaeuVar.f37483b.get(i2);
            zzacrVar.a((zzacq) entry.getKey(), entry.getValue());
            i2++;
        }
        for (Map.Entry entry2 : zzaeuVar.f37484c.isEmpty() ? zzaex.f37472b : zzaeuVar.f37484c.entrySet()) {
            zzacrVar.a((zzacq) entry2.getKey(), entry2.getValue());
        }
        return zzacrVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzacr) {
            return this.f37394a.equals(((zzacr) obj).f37394a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f37394a.hashCode();
    }

    public zzacr(int i2) {
        zzaeu zzaeuVar = new zzaeu(0);
        this.f37394a = zzaeuVar;
        if (!this.f37395b) {
            zzaeuVar.a();
            this.f37395b = true;
        }
        if (this.f37395b) {
            return;
        }
        zzaeuVar.a();
        this.f37395b = true;
    }
}
