package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzxz {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f38138b = Logger.getLogger(zzxz.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f38139c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f38140d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzxz f38141e;

    /* renamed from: f, reason: collision with root package name */
    public static final zzxz f38142f;

    /* renamed from: g, reason: collision with root package name */
    public static final zzxz f38143g;

    /* renamed from: h, reason: collision with root package name */
    public static final zzxz f38144h;

    /* renamed from: i, reason: collision with root package name */
    public static final zzxz f38145i;

    /* renamed from: a, reason: collision with root package name */
    public final zzyh f38146a;

    static {
        if (zznb.a()) {
            f38139c = b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt");
            f38140d = false;
        } else if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            f38139c = b("GmsCore_OpenSSL", "AndroidOpenSSL");
            f38140d = true;
        } else {
            f38139c = new ArrayList();
            f38140d = true;
        }
        f38141e = new zzxz(new zzya());
        f38142f = new zzxz(new zzye());
        new zzyg();
        new zzyf();
        f38143g = new zzxz(new zzyb());
        f38144h = new zzxz(new zzyd());
        f38145i = new zzxz(new zzyc());
    }

    public zzxz(zzyh zzyhVar) {
        this.f38146a = zzyhVar;
    }

    public static ArrayList b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                f38138b.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", android.support.v4.media.b.D("Provider ", str, " not available"));
            }
        }
        return arrayList;
    }

    public final Object a(String str) throws GeneralSecurityException {
        Iterator it = f38139c.iterator();
        Exception exc = null;
        while (true) {
            boolean zHasNext = it.hasNext();
            zzyh zzyhVar = this.f38146a;
            if (!zHasNext) {
                if (f38140d) {
                    return zzyhVar.a(str, null);
                }
                throw new GeneralSecurityException("No good Provider found.", exc);
            }
            try {
                return zzyhVar.a(str, (Provider) it.next());
            } catch (Exception e2) {
                if (exc == null) {
                    exc = e2;
                }
            }
        }
    }
}
