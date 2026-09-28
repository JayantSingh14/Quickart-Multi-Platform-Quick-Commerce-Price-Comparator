package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class zzal extends zzjd {

    /* renamed from: b, reason: collision with root package name */
    public Boolean f38688b;

    /* renamed from: c, reason: collision with root package name */
    public String f38689c;

    /* renamed from: d, reason: collision with root package name */
    public zzak f38690d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f38691e;

    public final boolean h(String str) {
        return "1".equals(this.f38690d.a(str, "gaia_collection_enabled"));
    }

    public final boolean i(String str) {
        return "1".equals(this.f38690d.a(str, "measurement.event_sampling_enabled"));
    }

    public final boolean j() {
        if (this.f38688b == null) {
            Boolean boolS = s("app_measurement_lite");
            this.f38688b = boolS;
            if (boolS == null) {
                this.f38688b = Boolean.FALSE;
            }
        }
        return this.f38688b.booleanValue() || !this.f39180a.f39085b;
    }

    public final String k(String str) {
        zzib zzibVar = this.f39180a;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str2);
            return str2;
        } catch (ClassNotFoundException e2) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(e2, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e3) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e3, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e4) {
            zzgt zzgtVar3 = zzibVar.f39089f;
            zzib.l(zzgtVar3);
            zzgtVar3.f38958f.b(e4, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e5) {
            zzgt zzgtVar4 = zzibVar.f39089f;
            zzib.l(zzgtVar4);
            zzgtVar4.f38958f.b(e5, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final void l() {
        this.f39180a.getClass();
    }

    public final String m(String str, zzfw zzfwVar) {
        return TextUtils.isEmpty(str) ? (String) zzfwVar.a(null) : (String) zzfwVar.a(this.f38690d.a(str, zzfwVar.f38897a));
    }

    public final long n(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) zzfwVar.a(null)).longValue();
        }
        String strA = this.f38690d.a(str, zzfwVar.f38897a);
        if (TextUtils.isEmpty(strA)) {
            return ((Long) zzfwVar.a(null)).longValue();
        }
        try {
            return ((Long) zzfwVar.a(Long.valueOf(Long.parseLong(strA)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzfwVar.a(null)).longValue();
        }
    }

    public final int o(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) zzfwVar.a(null)).intValue();
        }
        String strA = this.f38690d.a(str, zzfwVar.f38897a);
        if (TextUtils.isEmpty(strA)) {
            return ((Integer) zzfwVar.a(null)).intValue();
        }
        try {
            return ((Integer) zzfwVar.a(Integer.valueOf(Integer.parseInt(strA)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzfwVar.a(null)).intValue();
        }
    }

    public final double p(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) zzfwVar.a(null)).doubleValue();
        }
        String strA = this.f38690d.a(str, zzfwVar.f38897a);
        if (TextUtils.isEmpty(strA)) {
            return ((Double) zzfwVar.a(null)).doubleValue();
        }
        try {
            return ((Double) zzfwVar.a(Double.valueOf(Double.parseDouble(strA)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzfwVar.a(null)).doubleValue();
        }
    }

    public final boolean q(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) zzfwVar.a(null)).booleanValue();
        }
        String strA = this.f38690d.a(str, zzfwVar.f38897a);
        return TextUtils.isEmpty(strA) ? ((Boolean) zzfwVar.a(null)).booleanValue() : ((Boolean) zzfwVar.a(Boolean.valueOf("1".equals(strA)))).booleanValue();
    }

    public final Bundle r() {
        zzib zzibVar = this.f39180a;
        try {
            Context context = zzibVar.f39084a;
            Context context2 = zzibVar.f39084a;
            PackageManager packageManager = context.getPackageManager();
            zzgt zzgtVar = zzibVar.f39089f;
            if (packageManager == null) {
                zzib.l(zzgtVar);
                zzgtVar.f38958f.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(context2).getApplicationInfo(context2.getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final Boolean s(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleR = r();
        if (bundleR != null) {
            if (bundleR.containsKey(str)) {
                return Boolean.valueOf(bundleR.getBoolean(str));
            }
            return null;
        }
        zzgt zzgtVar = this.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38958f.a("Failed to load metadata: Metadata bundle is null");
        return null;
    }

    public final boolean t() {
        this.f39180a.getClass();
        Boolean boolS = s("firebase_analytics_collection_deactivated");
        return boolS != null && boolS.booleanValue();
    }

    public final boolean u() {
        Boolean boolS = s("google_analytics_automatic_screen_reporting_enabled");
        return boolS == null || boolS.booleanValue();
    }

    public final zzjh v(String str, boolean z) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        Bundle bundleR = r();
        zzib zzibVar = this.f39180a;
        if (bundleR == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleR.get(str);
        }
        zzjh zzjhVar = zzjh.UNINITIALIZED;
        if (obj == null) {
            return zzjhVar;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzjh.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzjh.DENIED;
        }
        if (z && "eu_consent_policy".equals(obj)) {
            return zzjh.POLICY;
        }
        zzgt zzgtVar2 = zzibVar.f39089f;
        zzib.l(zzgtVar2);
        zzgtVar2.f38961i.b(str, "Invalid manifest metadata for");
        return zzjhVar;
    }
}
