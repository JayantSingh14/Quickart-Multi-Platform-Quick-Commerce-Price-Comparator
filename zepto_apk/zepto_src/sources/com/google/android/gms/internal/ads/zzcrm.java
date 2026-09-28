package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.DeviceProperties;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzcrm implements zzdak, zzdby, zzdbe, com.google.android.gms.ads.internal.client.zza, zzdba, zzdii, zzddf {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26963a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f26964b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f26965c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f26966d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfic f26967e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfhr f26968f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfpe f26969g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfix f26970h;

    /* renamed from: i, reason: collision with root package name */
    public final zzayq f26971i;

    /* renamed from: j, reason: collision with root package name */
    public final zzbhr f26972j;

    /* renamed from: k, reason: collision with root package name */
    public final WeakReference f26973k;

    /* renamed from: l, reason: collision with root package name */
    public final WeakReference f26974l;

    /* renamed from: m, reason: collision with root package name */
    public final zzczl f26975m;
    public final zzdcz n;
    public final zzcze o;
    public final Set p;
    public boolean q;
    public final AtomicBoolean r = new AtomicBoolean();
    public zzcdb s = null;

    public zzcrm(Context context, zzgyw zzgywVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzfic zzficVar, zzfhr zzfhrVar, zzfpe zzfpeVar, zzfix zzfixVar, View view, zzcir zzcirVar, zzayq zzayqVar, zzbhr zzbhrVar, zzczl zzczlVar, zzdcz zzdczVar, zzcze zzczeVar, Set set) {
        this.f26963a = context;
        this.f26964b = zzgywVar;
        this.f26965c = executor;
        this.f26966d = scheduledExecutorService;
        this.f26967e = zzficVar;
        this.f26968f = zzfhrVar;
        this.f26969g = zzfpeVar;
        this.f26970h = zzfixVar;
        this.f26971i = zzayqVar;
        this.f26973k = new WeakReference(view);
        this.f26974l = new WeakReference(zzcirVar);
        this.f26972j = zzbhrVar;
        this.f26975m = zzczlVar;
        this.n = zzdczVar;
        this.o = zzczeVar;
        this.p = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(zzbzj zzbzjVar, String str, String str2) {
        zzfid zzfidVar;
        zzfhr zzfhrVar = this.f26968f;
        List list = zzfhrVar.f31156h;
        zzfpe zzfpeVar = this.f26969g;
        zzfpeVar.getClass();
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = zzfpeVar.f31544h.currentTimeMillis();
        try {
            String str3 = zzbzjVar.f25777a;
            String string = Integer.toString(zzbzjVar.f25778b);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.i4)).booleanValue();
            zzgpy zzgqfVar = zzgph.f33051a;
            if (zBooleanValue) {
                zzfie zzfieVar = zzfpeVar.f31543g;
                if (zzfieVar != null && (zzfidVar = zzfieVar.f31197a) != null) {
                    zzgqfVar = new zzgqf(zzfidVar);
                }
            } else {
                zzfid zzfidVar2 = zzfpeVar.f31542f;
                if (zzfidVar2 != null) {
                    zzgqfVar = new zzgqf(zzfidVar2);
                }
            }
            String str4 = (String) zzgqfVar.b(zzfpd.f31536a).a();
            String str5 = (String) zzgqfVar.b(zzfpc.f31535a).a();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzcby.a(zzfpe.c(zzfpe.c(zzfpe.c(zzfpe.c(zzfpe.c(zzfpe.c((String) it.next(), "@gw_rwd_userid@", Uri.encode(str4)), "@gw_rwd_custom_data@", Uri.encode(str5)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(str3)), "@gw_rwd_amt@", string), "@gw_sdkver@", zzfpeVar.f31538b), zzfpeVar.f31541e, zzfhrVar.W, zzfhrVar.w0));
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to determine award type and amount.", e2);
        }
        this.f26970h.a(arrayList, null);
    }

    public final List a() {
        boolean zIsBstar;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.zc)).booleanValue();
        zzfhr zzfhrVar = this.f26968f;
        if (zBooleanValue) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            Context context = this.f26963a;
            try {
                zIsBstar = DeviceProperties.isBstar(context);
            } catch (NoSuchMethodError unused) {
                zIsBstar = false;
            }
            if (zIsBstar) {
                Object systemService = context.getSystemService("display");
                Integer numValueOf = systemService instanceof DisplayManager ? Integer.valueOf(((DisplayManager) systemService).getDisplays().length) : null;
                if (numValueOf != null) {
                    int iMin = Math.min(numValueOf.intValue(), 20);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = zzfhrVar.f31152d.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Uri.parse((String) it.next()).buildUpon().appendQueryParameter("dspct", Integer.toString(iMin)).toString());
                    }
                    return arrayList;
                }
            }
        }
        return zzfhrVar.f31152d;
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() {
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void c(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Q1)).booleanValue()) {
            int i2 = zzeVar.f21161a;
            ArrayList arrayList = new ArrayList();
            zzfhr zzfhrVar = this.f26968f;
            for (String str : zzfhrVar.o) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 2);
                sb.append("2.");
                sb.append(i2);
                arrayList.add(zzfpe.c(str, "@gw_mpe@", sb.toString()));
            }
            this.f26970h.a(this.f26969g.a(this.f26967e, zzfhrVar, arrayList), null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        if (this.r.compareAndSet(false, true)) {
            zzbgb zzbgbVar = zzbgk.q4;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            int iIntValue = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (iIntValue > 0) {
                j(iIntValue, ((Integer) zzbgiVar.a(zzbgk.r4)).intValue());
            } else if (!((Boolean) zzbgiVar.a(zzbgk.p4)).booleanValue()) {
                m();
            } else {
                this.f26965c.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcrh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        final zzcrm zzcrmVar = this.f26954a;
                        zzcrmVar.getClass();
                        zzcrmVar.f26964b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcrk
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcrmVar.m();
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() {
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.O0)).booleanValue();
        zzfic zzficVar = this.f26967e;
        if ((zBooleanValue && zzficVar.f31194b.f31190b.f31173h) || !((Boolean) zzbij.f25169d.c()).booleanValue()) {
            zzfhr zzfhrVar = this.f26968f;
            this.f26970h.b(true == com.google.android.gms.ads.internal.zzt.C.f21684h.i(this.f26963a) ? 2 : 1, this.f26969g.a(zzficVar, zzfhrVar, zzfhrVar.f31151c));
        } else {
            zzbhr zzbhrVar = this.f26972j;
            zzbhrVar.getClass();
            zzgye zzgyeVar = (zzgye) zzgym.e(zzgye.s((zzgye) zzgym.g(zzgye.s(zzgyq.f33377b), ((Long) zzbij.f25168c.c()).longValue(), TimeUnit.MILLISECONDS, zzbhrVar.f25093c)), Throwable.class, zzcrl.f26962a, zzcdo.f25988g);
            zzgyeVar.q(new zzgyk(zzgyeVar, new zzcrf(this)), this.f26964b);
        }
    }

    public final void j(final int i2, final int i3) {
        View view;
        if (i2 <= 0 || !((view = (View) this.f26973k.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            m();
        } else {
            this.f26966d.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcri
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    final zzcrm zzcrmVar = this.f26955a;
                    zzcrmVar.getClass();
                    final int i4 = i2;
                    final int i5 = i3;
                    zzcrmVar.f26964b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcrj
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzcrmVar.j(i4 - 1, i5);
                        }
                    });
                }
            }, i3, TimeUnit.MILLISECONDS);
        }
    }

    public final void m() {
        int i2;
        zzcdb zzcdbVar;
        zzfhr zzfhrVar = this.f26968f;
        List list = zzfhrVar.f31152d;
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbgb zzbgbVar = zzbgk.Se;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && this.s == null) {
            zzcdf zzcdfVar = com.google.android.gms.ads.internal.zzt.C.f21684h.f25933c;
            Set set = this.p;
            String str = this.f26967e.f31193a.f31185a.f31219g;
            zzcdc zzcdcVar = zzcdfVar.f25965d;
            synchronized (zzcdcVar.f25953g) {
                try {
                    int i3 = zzcdcVar.f25959m;
                    zzcdcVar.f25959m = i3 + 1;
                    if (set.isEmpty()) {
                        zzcdbVar = new zzcdb(i3, -1, -1);
                    } else {
                        TreeSet treeSet = new TreeSet(set);
                        StringBuilder sb = new StringBuilder();
                        Iterator it = treeSet.iterator();
                        if (it.hasNext()) {
                            CharSequence charSequence = (CharSequence) it.next();
                            while (true) {
                                sb.append(charSequence);
                                if (!it.hasNext()) {
                                    break;
                                }
                                sb.append((CharSequence) ",");
                                charSequence = (CharSequence) it.next();
                            }
                        }
                        String string = sb.toString();
                        HashMap map = zzcdcVar.n;
                        Integer num = (Integer) map.get(string);
                        int iIntValue = 0;
                        int iIntValue2 = num == null ? 0 : num.intValue();
                        map.put(string, Integer.valueOf(iIntValue2 + 1));
                        if (str == null) {
                            zzcdbVar = new zzcdb(i3, iIntValue2, -1);
                        } else {
                            StringBuilder sb2 = new StringBuilder(str.length() + 1 + String.valueOf(string).length());
                            sb2.append(str);
                            sb2.append(CLConstants.SALT_DELIMETER);
                            sb2.append(string);
                            String string2 = sb2.toString();
                            HashMap map2 = zzcdcVar.o;
                            Integer num2 = (Integer) map2.get(string2);
                            if (num2 != null) {
                                iIntValue = num2.intValue();
                            }
                            map2.put(string2, Integer.valueOf(iIntValue + 1));
                            zzcdbVar = new zzcdb(i3, iIntValue2, iIntValue);
                        }
                    }
                } finally {
                }
            }
            this.s = zzcdbVar;
        }
        String strJ = ((Boolean) zzbdVar.f21153c.a(zzbgk.h4)).booleanValue() ? this.f26971i.f24512b.j(this.f26963a, (View) this.f26973k.get(), null) : null;
        if ((((Boolean) zzbdVar.f21153c.a(zzbgk.O0)).booleanValue() && this.f26967e.f31194b.f31190b.f31173h) || !((Boolean) zzbij.f25173h.c()).booleanValue()) {
            this.f26970h.a(this.f26969g.b(this.f26967e, zzfhrVar, false, strJ, null, a(), this.o, this.s), this.n);
            return;
        }
        if (((Boolean) zzbij.f25172g.c()).booleanValue() && ((i2 = zzfhrVar.f31150b) == 1 || i2 == 2 || i2 == 5)) {
        }
        zzgye zzgyeVar = (zzgye) zzgym.g(zzgye.s(zzgyq.f33377b), ((Long) zzbdVar.f21153c.a(zzbgk.r1)).longValue(), TimeUnit.MILLISECONDS, this.f26966d);
        zzgyeVar.q(new zzgyk(zzgyeVar, new zzcrg(this, strJ)), this.f26964b);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() {
        zzfhr zzfhrVar = this.f26968f;
        this.f26970h.a(this.f26969g.a(this.f26967e, zzfhrVar, zzfhrVar.f31155g), null);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() {
        zzfhr zzfhrVar = this.f26968f;
        this.f26970h.a(this.f26969g.a(this.f26967e, zzfhrVar, zzfhrVar.f31157i), null);
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final synchronized void zzg() {
        zzczl zzczlVar;
        long j2;
        try {
            if (this.q) {
                ArrayList arrayList = new ArrayList(a());
                zzfhr zzfhrVar = this.f26968f;
                arrayList.addAll(zzfhrVar.f31154f);
                this.f26970h.a(this.f26969g.b(this.f26967e, zzfhrVar, true, null, null, arrayList, null, null), null);
            } else {
                zzfix zzfixVar = this.f26970h;
                zzfpe zzfpeVar = this.f26969g;
                zzfic zzficVar = this.f26967e;
                zzfhr zzfhrVar2 = this.f26968f;
                zzfixVar.a(zzfpeVar.a(zzficVar, zzfhrVar2, zzfhrVar2.f31161m), null);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.m4)).booleanValue() && (zzczlVar = this.f26975m) != null) {
                    List list = zzczlVar.f27479b.f31161m;
                    String strD = zzczlVar.f27480c.d();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(zzfpe.c((String) it.next(), "@gw_adnetstatus@", strD));
                    }
                    zzemr zzemrVar = zzczlVar.f27480c;
                    synchronized (zzemrVar) {
                        j2 = zzemrVar.f29808h;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(zzfpe.c((String) it2.next(), "@gw_ttr@", Long.toString(j2, 10)));
                    }
                    zzfixVar.a(zzfpeVar.a(zzczlVar.f27478a, zzczlVar.f27479b, arrayList3), null);
                }
                zzfixVar.a(zzfpeVar.a(zzficVar, zzfhrVar2, zzfhrVar2.f31154f), null);
            }
            this.q = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.AbstractCollection, java.util.List] */
    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzi() {
        zzfhr zzfhrVar = this.f26968f;
        this.f26970h.a(this.f26969g.a(this.f26967e, zzfhrVar, zzfhrVar.u0), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.AbstractCollection, java.util.List] */
    @Override // com.google.android.gms.internal.ads.zzddf
    public final void zzk() {
        zzfhr zzfhrVar = this.f26968f;
        if (zzfhrVar.f31153e == 4) {
            this.f26970h.a(this.f26969g.a(this.f26967e, zzfhrVar, zzfhrVar.A0), null);
        }
    }
}
