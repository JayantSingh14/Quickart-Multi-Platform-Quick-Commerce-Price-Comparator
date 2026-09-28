package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzfvn implements zzfui {

    /* renamed from: a, reason: collision with root package name */
    public final Object f31927a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfvo f31928b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfvz f31929c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfuf f31930d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31931e;

    public zzfvn(Object obj, zzfvo zzfvoVar, zzfvz zzfvzVar, zzfuf zzfufVar, boolean z) {
        this.f31927a = obj;
        this.f31928b = zzfvoVar;
        this.f31929c = zzfvzVar;
        this.f31930d = zzfufVar;
        this.f31931e = z;
    }

    public static String h(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzaxf zzaxfVarC = zzaxg.C();
        zzaxfVarC.j();
        ((zzaxg) zzaxfVarC.f34638b).G(5);
        zzhzl zzhzlVarV = zzhzl.v(0, bArr, bArr.length);
        zzaxfVarC.j();
        ((zzaxg) zzaxfVarC.f34638b).D(zzhzlVarV);
        return Base64.encodeToString(((zzaxg) zzaxfVarC.l()).g(), 11);
    }

    public final synchronized String a(Context context) {
        byte[] bArrI;
        try {
            HashMap mapZzb = this.f31929c.zzb();
            mapZzb.put("f", "q");
            mapZzb.put("ctx", context);
            mapZzb.put("aid", null);
            bArrI = i(mapZzb);
            if (this.f31931e) {
                mapZzb.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
        return h(bArrI);
    }

    public final synchronized String b(Context context, View view, Activity activity) {
        byte[] bArrI;
        try {
            HashMap mapZzc = this.f31929c.zzc();
            mapZzc.put("f", "v");
            mapZzc.put("ctx", context);
            mapZzc.put("aid", null);
            mapZzc.put("view", view);
            mapZzc.put("act", activity);
            bArrI = i(mapZzc);
            if (this.f31931e) {
                mapZzc.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
        return h(bArrI);
    }

    public final synchronized String c(Context context, String str, View view, Activity activity) {
        byte[] bArrI;
        try {
            HashMap mapZzd = this.f31929c.zzd();
            mapZzd.put("f", "c");
            mapZzd.put("ctx", context);
            mapZzd.put("cs", str);
            mapZzd.put("aid", null);
            mapZzd.put("view", view);
            mapZzd.put("act", activity);
            bArrI = i(mapZzd);
            if (this.f31931e) {
                mapZzd.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
        return h(bArrI);
    }

    public final synchronized void d(MotionEvent motionEvent) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap mapZze = this.f31929c.zze();
            mapZze.put("aid", null);
            mapZze.put("evt", motionEvent);
            Object obj = this.f31927a;
            obj.getClass().getDeclaredMethod("he", Map.class).invoke(obj, mapZze);
            this.f31930d.b(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e2) {
            throw new zzfvx(2005, e2);
        }
    }

    public final synchronized boolean e() {
        Object obj;
        try {
            obj = this.f31927a;
        } catch (Exception e2) {
            throw new zzfvx(2001, e2);
        }
        return ((Boolean) obj.getClass().getDeclaredMethod("init", null).invoke(obj, null)).booleanValue();
    }

    public final synchronized void f() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object obj = this.f31927a;
            obj.getClass().getDeclaredMethod("close", null).invoke(obj, null);
            this.f31930d.b(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e2) {
            throw new zzfvx(2003, e2);
        }
    }

    public final synchronized int g() {
        Object obj;
        try {
            obj = this.f31927a;
        } catch (Exception e2) {
            throw new zzfvx(2006, e2);
        }
        return ((Integer) obj.getClass().getDeclaredMethod("lcs", null).invoke(obj, null)).intValue();
    }

    public final synchronized byte[] i(Map map) {
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            obj = this.f31927a;
        } catch (Exception e2) {
            this.f31930d.c(2007, System.currentTimeMillis() - jCurrentTimeMillis, e2);
            return null;
        }
        return (byte[]) obj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(obj, null, map);
    }
}
