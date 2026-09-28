package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzh {
    public static void a(String str, List list, int i2) {
        if (list.size() == i2) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires " + i2 + " parameters found " + list.size());
    }

    public static void b(String str, List list, int i2) {
        if (list.size() >= i2) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at least " + i2 + " parameters found " + list.size());
    }

    public static void c(int i2, String str, ArrayList arrayList) {
        if (arrayList.size() <= i2) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at most " + i2 + " parameters found " + arrayList.size());
    }

    public static boolean d(zzao zzaoVar) {
        if (zzaoVar == null) {
            return false;
        }
        Double dZzd = zzaoVar.zzd();
        return !dZzd.isNaN() && dZzd.doubleValue() >= 0.0d && dZzd.equals(Double.valueOf(Math.floor(dZzd.doubleValue())));
    }

    public static zzbk e(String str) throws NumberFormatException {
        zzbk zzbkVar = null;
        if (str != null && !str.isEmpty()) {
            zzbkVar = (zzbk) zzbk.U0.get(Integer.valueOf(Integer.parseInt(str)));
        }
        if (zzbkVar != null) {
            return zzbkVar;
        }
        throw new IllegalArgumentException(b.C("Unsupported commandId ", str));
    }

    public static boolean f(zzao zzaoVar, zzao zzaoVar2) {
        if (!zzaoVar.getClass().equals(zzaoVar2.getClass())) {
            return false;
        }
        if ((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) {
            return true;
        }
        if (!(zzaoVar instanceof zzah)) {
            return zzaoVar instanceof zzas ? zzaoVar.zzc().equals(zzaoVar2.zzc()) : zzaoVar instanceof zzaf ? zzaoVar.zze().equals(zzaoVar2.zze()) : zzaoVar == zzaoVar2;
        }
        if (Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue())) {
            return false;
        }
        return zzaoVar.zzd().equals(zzaoVar2.zzd());
    }

    public static int g(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2) || d2 == 0.0d) {
            return 0;
        }
        return (int) (((d2 > 0.0d ? 1 : -1) * Math.floor(Math.abs(d2))) % 4.294967296E9d);
    }

    public static double h(double d2) {
        if (Double.isNaN(d2)) {
            return 0.0d;
        }
        if (Double.isInfinite(d2) || d2 == 0.0d || d2 == 0.0d) {
            return d2;
        }
        return (d2 > 0.0d ? 1 : -1) * Math.floor(Math.abs(d2));
    }

    public static Object i(zzao zzaoVar) {
        if (zzao.p0.equals(zzaoVar)) {
            return null;
        }
        if (zzao.o0.equals(zzaoVar)) {
            return "";
        }
        if (zzaoVar instanceof zzal) {
            return j((zzal) zzaoVar);
        }
        if (!(zzaoVar instanceof zzae)) {
            return !zzaoVar.zzd().isNaN() ? zzaoVar.zzd() : zzaoVar.zzc();
        }
        ArrayList arrayList = new ArrayList();
        zzae zzaeVar = (zzae) zzaoVar;
        zzaeVar.getClass();
        zzad zzadVar = new zzad(zzaeVar);
        while (zzadVar.hasNext()) {
            Object objI = i((zzao) zzadVar.next());
            if (objI != null) {
                arrayList.add(objI);
            }
        }
        return arrayList;
    }

    public static HashMap j(zzal zzalVar) {
        HashMap map = new HashMap();
        Iterator it = new ArrayList(zzalVar.f36765a.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object objI = i(zzalVar.b(str));
            if (objI != null) {
                map.put(str, objI);
            }
        }
        return map;
    }

    public static void k(zzg zzgVar) {
        int iG = g(zzgVar.g("runtime.counter").zzd().doubleValue() + 1.0d);
        if (iG > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        zzgVar.e("runtime.counter", new zzah(Double.valueOf(iG)));
    }
}
