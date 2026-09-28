package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class zzclf implements zzayl {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26502a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfzz f26503b;

    public zzclf(Context context, VersionInfoParcel versionInfoParcel) {
        int i2;
        zzfzz zzfzzVar;
        this.f26502a = context;
        zzbgb zzbgbVar = zzbgk.m3;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        int iIntValue = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
        if (iIntValue != 1) {
            i2 = 3;
            if (iIntValue != 2 && iIntValue == 3) {
                i2 = 4;
            }
        } else {
            i2 = 2;
        }
        zzgau zzgauVarG = zzgav.G();
        float fFloatValue = ((Float) zzbdVar.f21153c.a(zzbgk.t3)).floatValue();
        zzgauVarG.j();
        ((zzgav) zzgauVarG.f34638b).I(fFloatValue);
        zzgav zzgavVar = (zzgav) zzgauVarG.l();
        zzgaw zzgawVarJ = zzgax.J();
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgk.u3)).booleanValue();
        zzgawVarJ.j();
        ((zzgax) zzgawVarJ.f34638b).L(zBooleanValue);
        long jLongValue = ((Long) zzbdVar.f21153c.a(zzbgk.w3)).longValue();
        zzgawVarJ.j();
        ((zzgax) zzgawVarJ.f34638b).M(jLongValue);
        zzgax zzgaxVar = (zzgax) zzgawVarJ.l();
        zzgac zzgacVarA0 = zzgad.a0();
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).G(i2);
        String str = versionInfoParcel.f21400a;
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).c0(str);
        boolean zBooleanValue2 = ((Boolean) zzbdVar.f21153c.a(zzbgk.Q2)).booleanValue();
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).b0(zBooleanValue2);
        boolean z = ((Integer) zzbdVar.f21153c.a(zzbgk.j3)).intValue() == -1;
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).E(z);
        long jIntValue = ((Integer) zzbdVar.f21153c.a(zzbgk.l3)).intValue();
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).D(jIntValue);
        long jLongValue2 = ((Long) zzbdVar.f21153c.a(zzbgk.v3)).longValue();
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).f0(jLongValue2);
        long jIntValue2 = ((Integer) zzbdVar.f21153c.a(zzbgk.k3)).intValue();
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).e0(jIntValue2);
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).d0(zzgavVar);
        zzgacVarA0.j();
        ((zzgad) zzgacVarA0.f34638b).C(zzgaxVar);
        zzgad zzgadVar = (zzgad) zzgacVarA0.l();
        zzgyw zzgywVar = zzcdo.f25982a;
        synchronized (zzfzz.f32139b) {
            try {
                if (zzfzz.f32140c == null) {
                    zzfzz.f32140c = new zzfzz(context, zzgadVar, zzgywVar);
                }
                zzfzzVar = zzfzz.f32140c;
            } finally {
            }
        }
        this.f26503b = zzfzzVar;
        zzgcd zzgcdVar = zzfzzVar.f32141a.f32121a;
        synchronized (zzgcdVar) {
            try {
                if (zzgcdVar.f32249e != null) {
                    return;
                }
                Set set = (Set) zzgcdVar.f32246b.zzb();
                ArrayList arrayList = new ArrayList(set.size());
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(((zzgcb) it.next()).zza());
                }
                zzgnc zzgncVar = (zzgnc) zzgcdVar.f32248d.zzb();
                ListenableFuture listenableFutureI = zzgym.i(zzgym.j(arrayList), zzgcc.f32244a, zzgcdVar.f32247c);
                zzgncVar.e(2, listenableFutureI);
                zzgcdVar.f32249e = listenableFutureI;
                Iterator it2 = ((Set) zzgcdVar.f32245a.zzb()).iterator();
                while (it2.hasNext()) {
                    ((zzgcb) it2.next()).zza();
                }
                if (zzgcdVar.f32249e != null) {
                } else {
                    throw null;
                }
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void b(int i2, int i3, int i4) {
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        Context context = this.f26502a;
        long j2 = i4;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, j2, 0, com.google.android.gms.ads.internal.util.client.zzf.b(i2, context), com.google.android.gms.ads.internal.util.client.zzf.q(context.getResources().getDisplayMetrics(), i3), 0);
        zzfzz zzfzzVar = this.f26503b;
        zzfzzVar.c(motionEventObtain);
        motionEventObtain.recycle();
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, j2, 2, com.google.android.gms.ads.internal.util.client.zzf.q(context.getResources().getDisplayMetrics(), i2), com.google.android.gms.ads.internal.util.client.zzf.q(context.getResources().getDisplayMetrics(), i3), 0);
        zzfzzVar.c(motionEventObtain2);
        motionEventObtain2.recycle();
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, j2, 1, com.google.android.gms.ads.internal.util.client.zzf.q(context.getResources().getDisplayMetrics(), i2), com.google.android.gms.ads.internal.util.client.zzf.q(context.getResources().getDisplayMetrics(), i3), 0);
        zzfzzVar.c(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String c(Context context) {
        return this.f26503b.a(context);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String d(Context context) {
        return this.f26503b.a(context);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String e(Context context, String str, View view) {
        return this.f26503b.b(context, str, view);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void f(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        this.f26503b.c(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String g(Context context, String str, View view, Activity activity) {
        return this.f26503b.b(context, str, view);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void h(StackTraceElement[] stackTraceElementArr) {
        zzfzz zzfzzVar = this.f26503b;
        List listAsList = Arrays.asList(stackTraceElementArr);
        zzgmo zzgmoVar = zzfzzVar.f32141a.f32123c.f32885b;
        synchronized (zzgmoVar) {
            ArrayList arrayList = zzgmoVar.f32926a;
            arrayList.clear();
            arrayList.addAll(listAsList);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void i(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String j(final Context context, final View view, final Activity activity) {
        String string;
        ListenableFuture listenableFuture;
        final zzfzx zzfzxVar = this.f26503b.f32141a;
        zzgbj zzgbjVar = zzfzxVar.f32125e;
        zzgnc zzgncVar = zzfzxVar.f32124d;
        zzgna zzgnaVarA = zzgncVar.a(4);
        try {
            try {
                try {
                    zzgnaVarA.a();
                    zzgcd zzgcdVar = zzfzxVar.f32121a;
                    synchronized (zzgcdVar) {
                        listenableFuture = zzgcdVar.f32249e;
                        if (listenableFuture == null) {
                            throw null;
                        }
                    }
                    string = (String) ((zzgxf) zzgym.h(listenableFuture, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfzu
                        @Override // com.google.android.gms.internal.ads.zzgxu
                        public final ListenableFuture zza(Object obj) {
                            return ((zzgct) zzfzxVar.f32122b.f32307f.get()).b(context, view, activity);
                        }
                    }, zzgyb.f33369a)).get(zzfzxVar.f32126f, TimeUnit.MILLISECONDS);
                } catch (ExecutionException e2) {
                    e = e2;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    zzgnaVarA.b(e);
                    string = Integer.toString(3);
                } catch (Throwable th) {
                    zzgnaVarA.b(th);
                    throw th;
                }
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                zzgnaVarA.b(e3);
                string = "";
            } catch (TimeoutException unused) {
                zzgncVar.b(57);
                string = Integer.toString(17);
            }
            zzgnaVarA.c();
            zzgbjVar.zzb();
            return string;
        } catch (Throwable th2) {
            zzgnaVarA.c();
            zzgbjVar.zzb();
            throw th2;
        }
    }
}
