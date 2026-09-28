package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.Map;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzgfw extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final zzgba f32493f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f32494g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f32495h;

    public zzgfw(zzavs zzavsVar, zzgev zzgevVar, zzgba zzgbaVar, Context context, Map map, zzgnc zzgncVar) {
        super("jTwehpFvggflbSQgZ6TF5ZqO2MGz4ZNlyaEKeNyxM2KkBYQA70h6S0RpRF1AFrD5", "26X1QwwnBSG6Ity/sCu7ijF3yvcDEyHR/EuBkm0iUZc=", zzavsVar, zzgevVar, zzgncVar.a(WKSRecord.Service.ERPC));
        this.f32493f = zzgbaVar;
        this.f32494g = context;
        this.f32495h = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        zzgba zzgbaVar = this.f32493f;
        Integer numValueOf = Integer.valueOf(zzgbaVar.ordinal());
        Context context = this.f32494g;
        Object obj = this.f32495h.get("up");
        Boolean bool = Boolean.TRUE;
        if (obj == null) {
            obj = bool;
        }
        Object[] objArr = (Object[]) method.invoke("", numValueOf, context, obj);
        objArr.getClass();
        synchronized (zzavsVar) {
            try {
                if (zzgbaVar == zzgba.f32197a) {
                    Object obj2 = objArr[0];
                    if (obj2 == null) {
                        obj2 = obj;
                    }
                    long jLongValue = ((Long) obj2).longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).D(jLongValue);
                    Object obj3 = objArr[1];
                    long jLongValue2 = ((Long) (obj3 != null ? obj3 : -1L)).longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).E(jLongValue2);
                }
                long jLongValue3 = ((Long) objArr[2]).longValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).N0(jLongValue3);
                long jLongValue4 = ((Long) objArr[3]).longValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).d0(jLongValue4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
