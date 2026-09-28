package com.google.android.gms.internal.atv_ads_framework;

import com.google.android.gms.internal.atv_ads_framework.zzdf;
import com.google.android.gms.internal.atv_ads_framework.zzdh;

/* loaded from: classes4.dex */
public class zzdf<MessageType extends zzdh<MessageType, BuilderType>, BuilderType extends zzdf<MessageType, BuilderType>> extends zzbz<MessageType, BuilderType> {

    /* renamed from: a, reason: collision with root package name */
    public final zzdh f36120a;

    /* renamed from: b, reason: collision with root package name */
    public zzdh f36121b;

    public zzdf(zzdh zzdhVar) {
        this.f36120a = zzdhVar;
        if (zzdhVar.b()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f36121b = (zzdh) zzdhVar.d(4);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbz
    /* renamed from: a */
    public final zzdf clone() {
        zzdf zzdfVar = (zzdf) this.f36120a.d(5);
        zzdfVar.f36121b = c();
        return zzdfVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        if (r1 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.atv_ads_framework.zzdh b() {
        /*
            r3 = this;
            com.google.android.gms.internal.atv_ads_framework.zzdh r0 = r3.c()
            r1 = 1
            java.lang.Object r2 = r0.d(r1)
            java.lang.Byte r2 = (java.lang.Byte) r2
            byte r2 = r2.byteValue()
            if (r2 != r1) goto L12
            goto L28
        L12:
            if (r2 == 0) goto L29
            com.google.android.gms.internal.atv_ads_framework.zzew r1 = com.google.android.gms.internal.atv_ads_framework.zzew.f36171c
            java.lang.Class r2 = r0.getClass()
            com.google.android.gms.internal.atv_ads_framework.zzey r1 = r1.a(r2)
            boolean r1 = r1.g(r0)
            r2 = 2
            r0.d(r2)
            if (r1 == 0) goto L29
        L28:
            return r0
        L29:
            com.google.android.gms.internal.atv_ads_framework.zzfo r0 = new com.google.android.gms.internal.atv_ads_framework.zzfo
            java.lang.String r1 = "Message was missing required fields.  (Lite runtime could not determine which fields were missing)."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzdf.b():com.google.android.gms.internal.atv_ads_framework.zzdh");
    }

    public final zzdh c() {
        if (!this.f36121b.b()) {
            return this.f36121b;
        }
        zzdh zzdhVar = this.f36121b;
        zzdhVar.getClass();
        zzew.f36171c.a(zzdhVar.getClass()).a(zzdhVar);
        zzdhVar.h();
        return this.f36121b;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbz
    public final Object clone() {
        zzdf zzdfVar = (zzdf) this.f36120a.d(5);
        zzdfVar.f36121b = c();
        return zzdfVar;
    }

    public final void d() {
        if (this.f36121b.b()) {
            return;
        }
        zzdh zzdhVar = (zzdh) this.f36120a.d(4);
        zzew.f36171c.a(zzdhVar.getClass()).e(zzdhVar, this.f36121b);
        this.f36121b = zzdhVar;
    }
}
