package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzfvy {

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f31956h = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f31957a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfvz f31958b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfuf f31959c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfua f31960d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31961e;

    /* renamed from: f, reason: collision with root package name */
    public zzfvn f31962f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f31963g = new Object();

    public zzfvy(Context context, zzfvz zzfvzVar, zzfuf zzfufVar, zzfua zzfuaVar, boolean z) {
        this.f31957a = context;
        this.f31958b = zzfvzVar;
        this.f31959c = zzfufVar;
        this.f31960d = zzfuaVar;
        this.f31961e = z;
    }

    public final boolean a(zzfvo zzfvoVar) throws IllegalAccessException, InstantiationException, zzfvx, IllegalArgumentException, InvocationTargetException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfvn zzfvnVar = new zzfvn(c(zzfvoVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.f31957a, "msa-r", zzfvoVar.a(), null, new Bundle(), 2), zzfvoVar, this.f31958b, this.f31959c, this.f31961e);
                if (!zzfvnVar.e()) {
                    throw new zzfvx(4000, "init failed");
                }
                int iG = zzfvnVar.g();
                if (iG != 0) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iG).length() + 4);
                    sb.append("ci: ");
                    sb.append(iG);
                    throw new zzfvx(4001, sb.toString());
                }
                synchronized (this.f31963g) {
                    zzfvn zzfvnVar2 = this.f31962f;
                    if (zzfvnVar2 != null) {
                        try {
                            zzfvnVar2.f();
                        } catch (zzfvx e2) {
                            this.f31959c.c(e2.f31955a, -1L, e2);
                        }
                        this.f31962f = zzfvnVar;
                    } else {
                        this.f31962f = zzfvnVar;
                    }
                }
                this.f31959c.b(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e3) {
                throw new zzfvx(2004, e3);
            }
        } catch (zzfvx e4) {
            this.f31959c.c(e4.f31955a, System.currentTimeMillis() - jCurrentTimeMillis, e4);
            return false;
        } catch (Exception e5) {
            this.f31959c.c(4010, System.currentTimeMillis() - jCurrentTimeMillis, e5);
            return false;
        }
    }

    public final zzfui b() {
        zzfvn zzfvnVar;
        synchronized (this.f31963g) {
            zzfvnVar = this.f31962f;
        }
        return zzfvnVar;
    }

    public final synchronized Class c(zzfvo zzfvoVar) {
        try {
            zzbby zzbbyVar = zzfvoVar.f31932a;
            if (zzbbyVar == null) {
                throw new zzfvx(4010, "mc");
            }
            String strC = zzbbyVar.C();
            HashMap map = f31956h;
            Class cls = (Class) map.get(strC);
            if (cls != null) {
                return cls;
            }
            try {
                if (!this.f31960d.a(zzfvoVar.f31933b)) {
                    throw new zzfvx(2026, "VM did not pass signature verification");
                }
                try {
                    File file = zzfvoVar.f31934c;
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    Class<?> clsLoadClass = new DexClassLoader(zzfvoVar.f31933b.getAbsolutePath(), file.getAbsolutePath(), null, this.f31957a.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    map.put(strC, clsLoadClass);
                    return clsLoadClass;
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    throw new zzfvx(2008, e);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    throw new zzfvx(2008, e);
                } catch (SecurityException e4) {
                    e = e4;
                    throw new zzfvx(2008, e);
                }
            } catch (GeneralSecurityException e5) {
                throw new zzfvx(2026, e5);
            }
        } finally {
        }
    }
}
