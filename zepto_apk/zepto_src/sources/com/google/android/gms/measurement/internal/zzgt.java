package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzgt extends zzje {

    /* renamed from: c, reason: collision with root package name */
    public char f38955c;

    /* renamed from: d, reason: collision with root package name */
    public long f38956d;

    /* renamed from: e, reason: collision with root package name */
    public String f38957e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgr f38958f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgr f38959g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgr f38960h;

    /* renamed from: i, reason: collision with root package name */
    public final zzgr f38961i;

    /* renamed from: j, reason: collision with root package name */
    public final zzgr f38962j;

    /* renamed from: k, reason: collision with root package name */
    public final zzgr f38963k;

    /* renamed from: l, reason: collision with root package name */
    public final zzgr f38964l;

    /* renamed from: m, reason: collision with root package name */
    public final zzgr f38965m;
    public final zzgr n;

    public zzgt(zzib zzibVar) {
        super(zzibVar);
        this.f38955c = (char) 0;
        this.f38956d = -1L;
        this.f38958f = new zzgr(this, 6, false, false);
        this.f38959g = new zzgr(this, 6, true, false);
        this.f38960h = new zzgr(this, 6, false, true);
        this.f38961i = new zzgr(this, 5, false, false);
        this.f38962j = new zzgr(this, 5, true, false);
        this.f38963k = new zzgr(this, 5, false, true);
        this.f38964l = new zzgr(this, 4, false, false);
        this.f38965m = new zzgr(this, 3, false, false);
        this.n = new zzgr(this, 2, false, false);
    }

    public static Object o(String str) {
        if (str == null) {
            return null;
        }
        return new zzgs(str);
    }

    public static String r(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String strS = s(obj, z);
        String strS2 = s(obj2, z);
        String strS3 = s(obj3, z);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strS)) {
            sb.append(str2);
            sb.append(strS);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strS2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strS2);
        }
        if (!TextUtils.isEmpty(strS3)) {
            sb.append(str3);
            sb.append(strS3);
        }
        return sb.toString();
    }

    public static String s(Object obj, boolean z) {
        int iLastIndexOf;
        String className;
        int iLastIndexOf2;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l2 = (Long) obj;
            if (Math.abs(l2.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l2.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            int length = String.valueOf(jRound).length();
            String str = cCharAt == '-' ? "-" : "";
            StringBuilder sb = new StringBuilder(e.C(str.length() + length + 3, String.valueOf(jRound2).length(), str));
            e.A(sb, str, jRound, "...");
            sb.append(str);
            sb.append(jRound2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof zzgs ? ((zzgs) obj).f38954a : z ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String canonicalName = zzib.class.getCanonicalName();
        String strSubstring = (TextUtils.isEmpty(canonicalName) || (iLastIndexOf = canonicalName.lastIndexOf(46)) == -1) ? "" : canonicalName.substring(0, iLastIndexOf);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (((TextUtils.isEmpty(className) || (iLastIndexOf2 = className.lastIndexOf(46)) == -1) ? "" : className.substring(0, iLastIndexOf2)).equals(strSubstring)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
            }
            i2++;
        }
        return sb2.toString();
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    public final boolean h() {
        return false;
    }

    public final zzgr k() {
        return this.f38958f;
    }

    public final zzgr l() {
        return this.f38961i;
    }

    public final zzgr m() {
        return this.f38965m;
    }

    public final zzgr n() {
        return this.n;
    }

    public final void p(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(q(), i2)) {
            Log.println(i2, q(), r(false, str, obj, obj2, obj3));
        }
        if (z2 || i2 < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzhy zzhyVar = this.f39180a.f39090g;
        if (zzhyVar == null) {
            Log.println(6, q(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!zzhyVar.f39181b) {
                Log.println(6, q(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i2 >= 9) {
                i2 = 8;
            }
            zzhyVar.p(new zzgq(this, i2, str, obj, obj2, obj3));
        }
    }

    public final String q() {
        String str;
        synchronized (this) {
            try {
                if (this.f38957e == null) {
                    this.f39180a.f39087d.f39180a.getClass();
                    this.f38957e = "FA";
                }
                Preconditions.checkNotNull(this.f38957e);
                str = this.f38957e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
