package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzeq {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f36345c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final zzgl f36346a = new zzgl(16);

    /* renamed from: b, reason: collision with root package name */
    public boolean f36347b;

    static {
        new zzeq(0);
    }

    public zzeq() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(com.google.android.gms.internal.auth.zzep r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.auth.zzho r0 = r2.zzb()
            java.nio.charset.Charset r1 = com.google.android.gms.internal.auth.zzfa.f36355a
            r3.getClass()
            com.google.android.gms.internal.auth.zzho[] r1 = com.google.android.gms.internal.auth.zzho.f36431b
            com.google.android.gms.internal.auth.zzhp r1 = com.google.android.gms.internal.auth.zzhp.INT
            com.google.android.gms.internal.auth.zzhp r0 = r0.f36432a
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
            boolean r0 = r3 instanceof com.google.android.gms.internal.auth.zzfx
            if (r0 != 0) goto L1f
            boolean r0 = r3 instanceof com.google.android.gms.internal.auth.zzfc
            if (r0 == 0) goto L46
        L1f:
            return
        L20:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L28
            boolean r0 = r3 instanceof com.google.android.gms.internal.auth.zzex
            if (r0 == 0) goto L46
        L28:
            return
        L29:
            boolean r0 = r3 instanceof com.google.android.gms.internal.auth.zzef
            if (r0 != 0) goto L31
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L46
        L31:
            return
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
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.auth.zzho r2 = r2.zzb()
            com.google.android.gms.internal.auth.zzhp r2 = r2.f36432a
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzeq.c(com.google.android.gms.internal.auth.zzep, java.lang.Object):void");
    }

    public final void a() {
        if (this.f36347b) {
            return;
        }
        int i2 = 0;
        while (true) {
            zzgl zzglVar = this.f36346a;
            if (i2 >= zzglVar.f36410b.size()) {
                zzglVar.a();
                this.f36347b = true;
                return;
            }
            Map.Entry entry = (Map.Entry) zzglVar.f36410b.get(i2);
            if (entry.getValue() instanceof zzev) {
                zzev zzevVar = (zzev) entry.getValue();
                zzevVar.getClass();
                zzgf.f36386c.a(zzevVar.getClass()).a(zzevVar);
                zzevVar.c();
            }
            i2++;
        }
    }

    public final void b(zzep zzepVar, Object obj) {
        if (!zzepVar.zzc()) {
            c(zzepVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                c(zzepVar, arrayList.get(i2));
            }
            obj = arrayList;
        }
        boolean z = obj instanceof zzfc;
        this.f36346a.put(zzepVar, obj);
    }

    public final Object clone() {
        zzgl zzglVar;
        zzeq zzeqVar = new zzeq();
        int i2 = 0;
        while (true) {
            zzglVar = this.f36346a;
            if (i2 >= zzglVar.f36410b.size()) {
                break;
            }
            Map.Entry entry = (Map.Entry) zzglVar.f36410b.get(i2);
            zzeqVar.b((zzep) entry.getKey(), entry.getValue());
            i2++;
        }
        for (Map.Entry entry2 : zzglVar.f36411c.isEmpty() ? zzgo.f36399b : zzglVar.f36411c.entrySet()) {
            zzeqVar.b((zzep) entry2.getKey(), entry2.getValue());
        }
        return zzeqVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeq) {
            return this.f36346a.equals(((zzeq) obj).f36346a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f36346a.hashCode();
    }

    public zzeq(int i2) {
        a();
        a();
    }
}
