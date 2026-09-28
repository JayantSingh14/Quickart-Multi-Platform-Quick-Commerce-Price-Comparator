package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.support.v4.media.b;
import android.util.Log;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzgq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f38944a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f38945b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f38946c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f38947d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f38948e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzgt f38949f;

    public zzgq(zzgt zzgtVar, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f38944a = i2;
        this.f38945b = str;
        this.f38946c = obj;
        this.f38947d = obj2;
        this.f38948e = obj3;
        Objects.requireNonNull(zzgtVar);
        this.f38949f = zzgtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgt zzgtVar = this.f38949f;
        zzhg zzhgVar = zzgtVar.f39180a.f39088e;
        zzib.j(zzhgVar);
        if (!zzhgVar.f39181b) {
            Log.println(6, zzgtVar.q(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (zzgtVar.f38955c == 0) {
            zzal zzalVar = zzgtVar.f39180a.f39087d;
            if (zzalVar.f38691e == null) {
                synchronized (zzalVar) {
                    try {
                        if (zzalVar.f38691e == null) {
                            zzib zzibVar = zzalVar.f39180a;
                            ApplicationInfo applicationInfo = zzibVar.f39084a.getApplicationInfo();
                            String myProcessName = ProcessUtils.getMyProcessName();
                            if (applicationInfo != null) {
                                String str = applicationInfo.processName;
                                zzalVar.f38691e = Boolean.valueOf(str != null && str.equals(myProcessName));
                            }
                            if (zzalVar.f38691e == null) {
                                zzalVar.f38691e = Boolean.TRUE;
                                zzgt zzgtVar2 = zzibVar.f39089f;
                                zzib.l(zzgtVar2);
                                zzgtVar2.f38958f.a("My process not in the list of running processes");
                            }
                        }
                    } finally {
                    }
                }
            }
            if (zzalVar.f38691e.booleanValue()) {
                zzgtVar.f38955c = 'C';
            } else {
                zzgtVar.f38955c = 'c';
            }
        }
        if (zzgtVar.f38956d < 0) {
            zzgtVar.f39180a.f39087d.l();
            zzgtVar.f38956d = 130000L;
        }
        int i2 = this.f38944a;
        char c2 = zzgtVar.f38955c;
        long j2 = zzgtVar.f38956d;
        String str2 = this.f38945b;
        Object obj = this.f38946c;
        Object obj2 = this.f38947d;
        Object obj3 = this.f38948e;
        char cCharAt = "01VDIWEA?".charAt(i2);
        String strR = zzgt.r(true, str2, obj, obj2, obj3);
        StringBuilder sb = new StringBuilder(b.b(String.valueOf(cCharAt).length() + 1, String.valueOf(c2).length(), String.valueOf(j2).length(), 1) + strR.length());
        sb.append("2");
        sb.append(cCharAt);
        sb.append(c2);
        sb.append(j2);
        sb.append(":");
        sb.append(strR);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = str2.substring(0, 1024);
        }
        zzhe zzheVar = zzhgVar.f39024e;
        if (zzheVar != null) {
            zzhg zzhgVar2 = zzheVar.f39017e;
            zzhgVar2.g();
            if (zzheVar.f39017e.k().getLong(zzheVar.f39013a, 0L) == 0) {
                zzheVar.a();
            }
            if (string == null) {
                string = "";
            }
            SharedPreferences sharedPreferencesK = zzhgVar2.k();
            String str3 = zzheVar.f39014b;
            long j3 = sharedPreferencesK.getLong(str3, 0L);
            String str4 = zzheVar.f39015c;
            if (j3 <= 0) {
                SharedPreferences.Editor editorEdit = zzhgVar2.k().edit();
                editorEdit.putString(str4, string);
                editorEdit.putLong(str3, 1L);
                editorEdit.apply();
                return;
            }
            zzpo zzpoVar = zzhgVar2.f39180a.f39092i;
            zzib.j(zzpoVar);
            long jNextLong = zzpoVar.c0().nextLong() & Long.MAX_VALUE;
            long j4 = j3 + 1;
            long j5 = Long.MAX_VALUE / j4;
            SharedPreferences.Editor editorEdit2 = zzhgVar2.k().edit();
            if (jNextLong < j5) {
                editorEdit2.putString(str4, string);
            }
            editorEdit2.putLong(str3, j4);
            editorEdit2.apply();
        }
    }
}
