package com.google.android.gms.internal.pal;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

/* loaded from: classes4.dex */
public final class zzcp {

    /* renamed from: c, reason: collision with root package name */
    public static final ConditionVariable f37578c = new ConditionVariable();

    /* renamed from: d, reason: collision with root package name */
    public static volatile zzhp f37579d = null;

    /* renamed from: e, reason: collision with root package name */
    public static volatile Random f37580e = null;

    /* renamed from: a, reason: collision with root package name */
    public final zzdu f37581a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Boolean f37582b;

    public zzcp(zzdu zzduVar) {
        this.f37581a = zzduVar;
        zzduVar.f37635b.execute(new zzco(this));
    }

    public final void a(int i2, int i3, long j2, String str, Exception exc) {
        try {
            f37578c.block();
            if (!this.f37582b.booleanValue() || f37579d == null) {
                return;
            }
            zzb zzbVarP = zzf.p();
            String packageName = this.f37581a.f37634a.getPackageName();
            if (zzbVarP.f37406c) {
                zzbVarP.k();
                zzbVarP.f37406c = false;
            }
            zzf.u((zzf) zzbVarP.f37405b, packageName);
            if (zzbVarP.f37406c) {
                zzbVarP.k();
                zzbVarP.f37406c = false;
            }
            zzf.q((zzf) zzbVarP.f37405b, j2);
            if (str != null) {
                if (zzbVarP.f37406c) {
                    zzbVarP.k();
                    zzbVarP.f37406c = false;
                }
                zzf.t((zzf) zzbVarP.f37405b, str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                String string = stringWriter.toString();
                if (zzbVarP.f37406c) {
                    zzbVarP.k();
                    zzbVarP.f37406c = false;
                }
                zzf.r((zzf) zzbVarP.f37405b, string);
                String name = exc.getClass().getName();
                if (zzbVarP.f37406c) {
                    zzbVarP.k();
                    zzbVarP.f37406c = false;
                }
                zzf.s((zzf) zzbVarP.f37405b, name);
            }
            zzhp zzhpVar = f37579d;
            byte[] bArrF = ((zzf) zzbVarP.h()).F();
            zzhpVar.getClass();
            zzho zzhoVar = new zzho(zzhpVar, bArrF);
            zzhoVar.f37801c = i2;
            if (i3 != -1) {
                zzhoVar.f37800b = i3;
            }
            zzhoVar.a();
        } catch (Exception unused) {
        }
    }
}
