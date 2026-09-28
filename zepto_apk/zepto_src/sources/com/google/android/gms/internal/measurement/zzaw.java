package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzaw {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f36777a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final zzbi f36778b = new zzbi();

    public zzaw() {
        a(new zzau());
        a(new zzax());
        zzay zzayVar = new zzay();
        ArrayList arrayList = zzayVar.f36776a;
        arrayList.add(zzbk.APPLY);
        arrayList.add(zzbk.BLOCK);
        arrayList.add(zzbk.BREAK);
        arrayList.add(zzbk.CASE);
        arrayList.add(zzbk.DEFAULT);
        arrayList.add(zzbk.CONTINUE);
        arrayList.add(zzbk.DEFINE_FUNCTION);
        arrayList.add(zzbk.FN);
        arrayList.add(zzbk.IF);
        arrayList.add(zzbk.QUOTE);
        arrayList.add(zzbk.RETURN);
        arrayList.add(zzbk.SWITCH);
        arrayList.add(zzbk.TERNARY);
        a(zzayVar);
        zzbb zzbbVar = new zzbb();
        ArrayList arrayList2 = zzbbVar.f36776a;
        arrayList2.add(zzbk.AND);
        arrayList2.add(zzbk.NOT);
        arrayList2.add(zzbk.OR);
        a(zzbbVar);
        zzbg zzbgVar = new zzbg();
        ArrayList arrayList3 = zzbgVar.f36776a;
        arrayList3.add(zzbk.FOR_IN);
        arrayList3.add(zzbk.FOR_IN_CONST);
        arrayList3.add(zzbk.FOR_IN_LET);
        arrayList3.add(zzbk.FOR_LET);
        arrayList3.add(zzbk.FOR_OF);
        arrayList3.add(zzbk.FOR_OF_CONST);
        arrayList3.add(zzbk.FOR_OF_LET);
        arrayList3.add(zzbk.WHILE);
        a(zzbgVar);
        zzbh zzbhVar = new zzbh();
        ArrayList arrayList4 = zzbhVar.f36776a;
        arrayList4.add(zzbk.ADD);
        arrayList4.add(zzbk.DIVIDE);
        arrayList4.add(zzbk.MODULUS);
        arrayList4.add(zzbk.MULTIPLY);
        arrayList4.add(zzbk.NEGATE);
        arrayList4.add(zzbk.POST_DECREMENT);
        arrayList4.add(zzbk.POST_INCREMENT);
        arrayList4.add(zzbk.PRE_DECREMENT);
        arrayList4.add(zzbk.PRE_INCREMENT);
        arrayList4.add(zzbk.SUBTRACT);
        a(zzbhVar);
        zzbj zzbjVar = new zzbj();
        ArrayList arrayList5 = zzbjVar.f36776a;
        arrayList5.add(zzbk.ASSIGN);
        arrayList5.add(zzbk.CONST);
        arrayList5.add(zzbk.CREATE_ARRAY);
        arrayList5.add(zzbk.CREATE_OBJECT);
        arrayList5.add(zzbk.EXPRESSION_LIST);
        arrayList5.add(zzbk.GET);
        arrayList5.add(zzbk.GET_INDEX);
        arrayList5.add(zzbk.GET_PROPERTY);
        arrayList5.add(zzbk.NULL);
        arrayList5.add(zzbk.SET_PROPERTY);
        arrayList5.add(zzbk.TYPEOF);
        arrayList5.add(zzbk.UNDEFINED);
        arrayList5.add(zzbk.VAR);
        a(zzbjVar);
    }

    public final void a(zzav zzavVar) {
        Iterator it = zzavVar.f36776a.iterator();
        while (it.hasNext()) {
            this.f36777a.put(Integer.valueOf(((zzbk) it.next()).f36800a).toString(), zzavVar);
        }
    }

    public final zzao b(zzg zzgVar, zzao zzaoVar) {
        zzh.k(zzgVar);
        if (!(zzaoVar instanceof zzap)) {
            return zzaoVar;
        }
        zzap zzapVar = (zzap) zzaoVar;
        ArrayList arrayList = zzapVar.f36770b;
        HashMap map = this.f36777a;
        String str = zzapVar.f36769a;
        return (map.containsKey(str) ? (zzav) map.get(str) : this.f36778b).a(str, zzgVar, arrayList);
    }
}
