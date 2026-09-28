package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
final class zzgge extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final DisplayMetrics f32535f;

    /* renamed from: g, reason: collision with root package name */
    public final View f32536g;

    public zzgge(zzavs zzavsVar, zzgev zzgevVar, DisplayMetrics displayMetrics, View view, zzgnc zzgncVar) {
        super("tq9z0bsqyfYem1dUfogYnUtJjgIFA+joGg8QA4Yjc06GGolRKpj33I2byFl1ahrM", "t+27szabmNhDv89ZHseqqkrSfYo80HKd8ZuzbFtUHyo=", zzavsVar, zzgevVar, zzgncVar.a(124));
        this.f32535f = displayMetrics;
        this.f32536g = view;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        View view = this.f32536g;
        if (view == null) {
            return;
        }
        Object objInvoke = method.invoke("", this.f32535f, view);
        objInvoke.getClass();
        Long[] lArr = (Long[]) objInvoke;
        zzawn zzawnVarC = zzawo.C();
        long jLongValue = lArr[2].longValue();
        zzawnVarC.j();
        ((zzawo) zzawnVarC.f34638b).E(jLongValue);
        long jLongValue2 = lArr[1].longValue();
        zzawnVarC.j();
        ((zzawo) zzawnVarC.f34638b).F(jLongValue2);
        long jLongValue3 = lArr[0].longValue();
        zzawnVarC.j();
        ((zzawo) zzawnVarC.f34638b).G(jLongValue3);
        long jLongValue4 = lArr[3].longValue();
        zzawnVarC.j();
        ((zzawo) zzawnVarC.f34638b).D(jLongValue4);
        long jLongValue5 = lArr[4].longValue();
        zzawnVarC.j();
        ((zzawo) zzawnVarC.f34638b).H(jLongValue5);
        zzawo zzawoVar = (zzawo) zzawnVarC.l();
        zzavsVar.j();
        ((zzawp) zzavsVar.f34638b).Y(zzawoVar);
    }
}
