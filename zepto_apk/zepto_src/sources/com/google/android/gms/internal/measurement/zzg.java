package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzg {

    /* renamed from: a, reason: collision with root package name */
    public final zzg f36955a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaw f36956b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f36957c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f36958d = new HashMap();

    public zzg(zzg zzgVar, zzaw zzawVar) {
        this.f36955a = zzgVar;
        this.f36956b = zzawVar;
    }

    public final zzao a(zzao zzaoVar) {
        return this.f36956b.b(this, zzaoVar);
    }

    public final zzao b(zzae zzaeVar) {
        zzao zzaoVarB = zzao.o0;
        Iterator itM = zzaeVar.m();
        while (itM.hasNext()) {
            zzaoVarB = this.f36956b.b(this, zzaeVar.o(((Integer) itM.next()).intValue()));
            if (zzaoVarB instanceof zzag) {
                break;
            }
        }
        return zzaoVarB;
    }

    public final zzg c() {
        return new zzg(this, this.f36956b);
    }

    public final boolean d(String str) {
        if (this.f36957c.containsKey(str)) {
            return true;
        }
        zzg zzgVar = this.f36955a;
        if (zzgVar != null) {
            return zzgVar.d(str);
        }
        return false;
    }

    public final void e(String str, zzao zzaoVar) {
        zzg zzgVar;
        HashMap map = this.f36957c;
        if (!map.containsKey(str) && (zzgVar = this.f36955a) != null && zzgVar.d(str)) {
            zzgVar.e(str, zzaoVar);
        } else {
            if (this.f36958d.containsKey(str)) {
                return;
            }
            if (zzaoVar == null) {
                map.remove(str);
            } else {
                map.put(str, zzaoVar);
            }
        }
    }

    public final void f(String str, zzao zzaoVar) {
        if (this.f36958d.containsKey(str)) {
            return;
        }
        HashMap map = this.f36957c;
        if (zzaoVar == null) {
            map.remove(str);
        } else {
            map.put(str, zzaoVar);
        }
    }

    public final zzao g(String str) {
        HashMap map = this.f36957c;
        if (map.containsKey(str)) {
            return (zzao) map.get(str);
        }
        zzg zzgVar = this.f36955a;
        if (zzgVar != null) {
            return zzgVar.g(str);
        }
        throw new IllegalArgumentException(b.k(str, " is not defined"));
    }
}
