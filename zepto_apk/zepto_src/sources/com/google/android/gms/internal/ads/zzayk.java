package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

/* loaded from: classes4.dex */
public final class zzayk {

    /* renamed from: c, reason: collision with root package name */
    public static final ConditionVariable f24489c = new ConditionVariable();

    /* renamed from: d, reason: collision with root package name */
    public static volatile zzfwb f24490d = null;

    /* renamed from: e, reason: collision with root package name */
    public static volatile Random f24491e = null;

    /* renamed from: a, reason: collision with root package name */
    public final zzazt f24492a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Boolean f24493b;

    public zzayk(zzazt zzaztVar) {
        this.f24492a = zzaztVar;
        zzaztVar.f24559b.execute(new zzayj(this));
    }

    public final void a(int i2, int i3, long j2, String str, Exception exc) {
        try {
            f24489c.block();
            if (!this.f24493b.booleanValue() || f24490d == null) {
                return;
            }
            zzauy zzauyVarC = zzavc.C();
            String packageName = this.f24492a.f24558a.getPackageName();
            zzauyVarC.j();
            ((zzavc) zzauyVarC.f34638b).D(packageName);
            zzauyVarC.j();
            ((zzavc) zzauyVarC.f34638b).E(j2);
            if (str != null) {
                zzauyVarC.j();
                ((zzavc) zzauyVarC.f34638b).H(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                String string = stringWriter.toString();
                zzauyVarC.j();
                ((zzavc) zzauyVarC.f34638b).F(string);
                String name = exc.getClass().getName();
                zzauyVarC.j();
                ((zzavc) zzauyVarC.f34638b).G(name);
            }
            zzfwb zzfwbVar = f24490d;
            byte[] bArrG = ((zzavc) zzauyVarC.l()).g();
            zzfwbVar.getClass();
            zzfwa zzfwaVar = new zzfwa(zzfwbVar, bArrG);
            zzfwaVar.f31967c = i2;
            if (i3 != -1) {
                zzfwaVar.f31966b = i3;
            }
            zzfwaVar.a();
        } catch (Exception unused) {
        }
    }
}
