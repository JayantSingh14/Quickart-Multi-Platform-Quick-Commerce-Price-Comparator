package com.google.android.gms.internal.atv_ads_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzdc {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f36111c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final zzfb f36112a = new zzfb(16);

    /* renamed from: b, reason: collision with root package name */
    public boolean f36113b;

    static {
        new zzdc(0);
    }

    public zzdc() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(com.google.android.gms.internal.atv_ads_framework.zzdb r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.atv_ads_framework.zzge r0 = r2.zzb()
            java.nio.charset.Charset r1 = com.google.android.gms.internal.atv_ads_framework.zzdp.f36125a
            r3.getClass()
            com.google.android.gms.internal.atv_ads_framework.zzge[] r1 = com.google.android.gms.internal.atv_ads_framework.zzge.f36219b
            com.google.android.gms.internal.atv_ads_framework.zzgf r1 = com.google.android.gms.internal.atv_ads_framework.zzgf.INT
            com.google.android.gms.internal.atv_ads_framework.zzgf r0 = r0.f36220a
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
            boolean r0 = r3 instanceof com.google.android.gms.internal.atv_ads_framework.zzeo
            if (r0 != 0) goto L1f
            boolean r0 = r3 instanceof com.google.android.gms.internal.atv_ads_framework.zzdt
            if (r0 == 0) goto L46
        L1f:
            return
        L20:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L28
            boolean r0 = r3 instanceof com.google.android.gms.internal.atv_ads_framework.zzdj
            if (r0 == 0) goto L46
        L28:
            return
        L29:
            boolean r0 = r3 instanceof com.google.android.gms.internal.atv_ads_framework.zzcn
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
            com.google.android.gms.internal.atv_ads_framework.zzge r2 = r2.zzb()
            com.google.android.gms.internal.atv_ads_framework.zzgf r2 = r2.f36220a
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzdc.c(com.google.android.gms.internal.atv_ads_framework.zzdb, java.lang.Object):void");
    }

    public final void a() {
        if (this.f36113b) {
            return;
        }
        int i2 = 0;
        while (true) {
            zzfb zzfbVar = this.f36112a;
            if (i2 >= zzfbVar.f36196b.size()) {
                zzfbVar.a();
                this.f36113b = true;
                return;
            }
            Map.Entry entry = (Map.Entry) zzfbVar.f36196b.get(i2);
            if (entry.getValue() instanceof zzdh) {
                zzdh zzdhVar = (zzdh) entry.getValue();
                zzdhVar.getClass();
                zzew.f36171c.a(zzdhVar.getClass()).a(zzdhVar);
                zzdhVar.h();
            }
            i2++;
        }
    }

    public final void b(zzdb zzdbVar, Object obj) {
        if (!zzdbVar.zzc()) {
            c(zzdbVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                c(zzdbVar, arrayList.get(i2));
            }
            obj = arrayList;
        }
        boolean z = obj instanceof zzdt;
        this.f36112a.put(zzdbVar, obj);
    }

    public final Object clone() {
        zzfb zzfbVar;
        zzdc zzdcVar = new zzdc();
        int i2 = 0;
        while (true) {
            zzfbVar = this.f36112a;
            if (i2 >= zzfbVar.f36196b.size()) {
                break;
            }
            Map.Entry entry = (Map.Entry) zzfbVar.f36196b.get(i2);
            zzdcVar.b((zzdb) entry.getKey(), entry.getValue());
            i2++;
        }
        for (Map.Entry entry2 : zzfbVar.f36197c.isEmpty() ? zzfe.f36185b : zzfbVar.f36197c.entrySet()) {
            zzdcVar.b((zzdb) entry2.getKey(), entry2.getValue());
        }
        return zzdcVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdc) {
            return this.f36112a.equals(((zzdc) obj).f36112a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f36112a.hashCode();
    }

    public zzdc(int i2) {
        a();
        a();
    }
}
