package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.Method;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzgfs extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final Context f32481f;

    public zzgfs(zzavs zzavsVar, zzgev zzgevVar, Context context, zzgnc zzgncVar) {
        super("hzhbIB+AgGdYPFXbtYQQJVQ0myyvLQ035lSh6fryM+LYz5yD6wiuaRPJPr0GACLg", "8nQjwnciPBNothZ+NkFCxpR7DmL40cEAF/v8iM4vgFc=", zzavsVar, zzgevVar, zzgncVar.a(WKSRecord.Service.NNTP));
        this.f32481f = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        Object[] objArr = (Object[]) method.invoke("", this.f32481f);
        objArr.getClass();
        synchronized (zzavsVar) {
            long jLongValue = ((Long) objArr[0]).longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).J0(jLongValue);
            long jLongValue2 = ((Long) objArr[1]).longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).b0(jLongValue2);
        }
    }
}
