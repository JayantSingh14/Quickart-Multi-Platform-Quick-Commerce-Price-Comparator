package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class zzfuf {

    /* renamed from: e, reason: collision with root package name */
    public static volatile int f31872e = 1;

    /* renamed from: a, reason: collision with root package name */
    public final Context f31873a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f31874b;

    /* renamed from: c, reason: collision with root package name */
    public final Task f31875c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f31876d;

    public zzfuf(Context context, ExecutorService executorService, Task task, boolean z) {
        this.f31873a = context;
        this.f31874b = executorService;
        this.f31875c = task;
        this.f31876d = z;
    }

    public static zzfuf a(final Context context, ExecutorService executorService, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfub
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() throws zzfve {
                    taskCompletionSource.b(zzfwb.a(context, "GLAS"));
                }
            });
        } else {
            executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfud
                @Override // java.lang.Runnable
                public final void run() {
                    zzfwf zzfwfVar = new zzfwf();
                    Log.d("GASS", "Clearcut logging disabled");
                    taskCompletionSource.b(new zzfwb(zzfwfVar));
                }
            });
        }
        return new zzfuf(context, executorService, taskCompletionSource.f39750a, z);
    }

    public void b(int i2, long j2) {
        e(i2, j2, null, null, null);
    }

    public void c(int i2, long j2, Exception exc) {
        e(i2, j2, exc, null, null);
    }

    public void d(int i2, String str) {
        e(i2, 0L, null, null, str);
    }

    public final Task e(final int i2, long j2, Exception exc, String str, String str2) {
        if (!this.f31876d) {
            return this.f31875c.h(this.f31874b, zzfue.f31871a);
        }
        Context context = this.f31873a;
        final zzauy zzauyVarC = zzavc.C();
        String packageName = context.getPackageName();
        zzauyVarC.j();
        ((zzavc) zzauyVarC.f34638b).D(packageName);
        zzauyVarC.j();
        ((zzavc) zzauyVarC.f34638b).E(j2);
        int i3 = f31872e;
        zzauyVarC.j();
        ((zzavc) zzauyVarC.f34638b).J(i3);
        if (exc != null) {
            Object obj = zzgqx.f33093a;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            zzauyVarC.j();
            ((zzavc) zzauyVarC.f34638b).F(string);
            String name = exc.getClass().getName();
            zzauyVarC.j();
            ((zzavc) zzauyVarC.f34638b).G(name);
        }
        if (str2 != null) {
            zzauyVarC.j();
            ((zzavc) zzauyVarC.f34638b).H(str2);
        }
        if (str != null) {
            zzauyVarC.j();
            ((zzavc) zzauyVarC.f34638b).I(str);
        }
        return this.f31875c.h(this.f31874b, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfuc
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                if (!task.p()) {
                    return Boolean.FALSE;
                }
                zzfwb zzfwbVar = (zzfwb) task.l();
                byte[] bArrG = ((zzavc) zzauyVarC.l()).g();
                zzfwbVar.getClass();
                zzfwa zzfwaVar = new zzfwa(zzfwbVar, bArrG);
                zzfwaVar.f31967c = i2;
                zzfwaVar.a();
                return Boolean.TRUE;
            }
        });
    }
}
