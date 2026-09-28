package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzql;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.airborne.ota.Constants;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class zzli extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public zzkx f39315c;

    /* renamed from: d, reason: collision with root package name */
    public zzjo f39316d;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet f39317e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39318f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f39319g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f39320h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39321i;

    /* renamed from: j, reason: collision with root package name */
    public int f39322j;

    /* renamed from: k, reason: collision with root package name */
    public zzjw f39323k;

    /* renamed from: l, reason: collision with root package name */
    public zzjt f39324l;

    /* renamed from: m, reason: collision with root package name */
    public PriorityQueue f39325m;
    public boolean n;
    public zzjk o;
    public final AtomicLong p;
    public long q;
    public final zzx r;
    public boolean s;
    public zzkf t;
    public SharedPreferences.OnSharedPreferenceChangeListener u;
    public zzka v;
    public final zzkm w;

    public zzli(zzib zzibVar) {
        super(zzibVar);
        this.f39317e = new CopyOnWriteArraySet();
        this.f39320h = new Object();
        this.f39321i = false;
        this.f39322j = 1;
        this.s = true;
        this.w = new zzkm(this);
        this.f39319g = new AtomicReference();
        this.o = zzjk.f39198c;
        this.q = -1L;
        this.p = new AtomicLong(0L);
        this.r = new zzx(zzibVar);
    }

    public final String A() {
        zzma zzmaVar = this.f39180a.f39095l;
        zzib.k(zzmaVar);
        zzlt zzltVar = zzmaVar.f39379c;
        if (zzltVar != null) {
            return zzltVar.f39352a;
        }
        return null;
    }

    public final String B() {
        zzma zzmaVar = this.f39180a.f39095l;
        zzib.k(zzmaVar);
        zzlt zzltVar = zzmaVar.f39379c;
        if (zzltVar != null) {
            return zzltVar.f39353b;
        }
        return null;
    }

    public final void C(zzjk zzjkVar, long j2, boolean z) {
        g();
        h();
        zzib zzibVar = this.f39180a;
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        zzjk zzjkVarN = zzhgVar.n();
        long j3 = this.q;
        int i2 = zzjkVar.f39200b;
        zzgt zzgtVar = zzibVar.f39089f;
        if (j2 <= j3 && zzjk.l(zzjkVarN.f39200b, i2)) {
            zzib.l(zzgtVar);
            zzgtVar.f38964l.b(zzjkVar, "Dropped out-of-date consent setting, proposed settings");
            return;
        }
        zzhg zzhgVar2 = zzibVar.f39088e;
        zzib.j(zzhgVar2);
        zzhgVar2.g();
        if (!zzjk.l(i2, zzhgVar2.k().getInt("consent_source", 100))) {
            zzib.l(zzgtVar);
            zzgtVar.f38964l.b(Integer.valueOf(i2), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = zzhgVar2.k().edit();
        editorEdit.putString("consent_settings", zzjkVar.g());
        editorEdit.putInt("consent_source", i2);
        editorEdit.apply();
        zzib.l(zzgtVar);
        zzgtVar.n.b(zzjkVar, "Setting storage consent(FE)");
        this.q = j2;
        if (zzibVar.o().q()) {
            final zznk zznkVarO = zzibVar.o();
            zznkVarO.g();
            zznkVarO.h();
            zznkVarO.u(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznj
                @Override // java.lang.Runnable
                public final void run() {
                    zznk zznkVar = zznkVarO;
                    zzga zzgaVar = zznkVar.f39485d;
                    zzib zzibVar2 = zznkVar.f39180a;
                    if (zzgaVar == null) {
                        zzgt zzgtVar2 = zzibVar2.f39089f;
                        zzib.l(zzgtVar2);
                        zzgtVar2.f38958f.a("Failed to send storage consent settings to service");
                        return;
                    }
                    try {
                        zzr zzrVarW = zznkVar.w(false);
                        Preconditions.checkNotNull(zzrVarW);
                        zzgaVar.p3(zzrVarW);
                        zznkVar.t();
                    } catch (RemoteException e2) {
                        zzgt zzgtVar3 = zzibVar2.f39089f;
                        zzib.l(zzgtVar3);
                        zzgtVar3.f38958f.b(e2, "Failed to send storage consent settings to the service");
                    }
                }
            });
        } else {
            zznk zznkVarO2 = zzibVar.o();
            zznkVarO2.g();
            zznkVarO2.h();
            if (zznkVarO2.p()) {
                zznkVarO2.u(new zzmr(zznkVarO2, zznkVarO2.w(false)));
            }
        }
        if (z) {
            zzibVar.o().k(new AtomicReference());
        }
    }

    public final void D(Boolean bool, boolean z) {
        g();
        h();
        zzib zzibVar = this.f39180a;
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38965m.b(bool, "Setting app measurement enabled (FE)");
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        zzhgVar.g();
        SharedPreferences.Editor editorEdit = zzhgVar.k().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
        if (z) {
            zzhgVar.g();
            SharedPreferences.Editor editorEdit2 = zzhgVar.k().edit();
            if (bool != null) {
                editorEdit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit2.remove("measurement_enabled_from_api");
            }
            editorEdit2.apply();
        }
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        if (zzibVar.z || !(bool == null || bool.booleanValue())) {
            E();
        }
    }

    public final void E() {
        g();
        zzib zzibVar = this.f39180a;
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        String strA = zzhgVar.f39032m.a();
        if (strA != null) {
            boolean zEquals = "unset".equals(strA);
            Clock clock = zzibVar.f39094k;
            if (zEquals) {
                s(clock.currentTimeMillis(), null, Constants.APP_DIR, "_npa");
            } else {
                s(clock.currentTimeMillis(), Long.valueOf(true != "true".equals(strA) ? 0L : 1L), Constants.APP_DIR, "_npa");
            }
        }
        boolean zA = zzibVar.a();
        zzgt zzgtVar = zzibVar.f39089f;
        if (!zA || !this.s) {
            zzib.l(zzgtVar);
            zzgtVar.f38965m.a("Updating Scion state (FE)");
            zznk zznkVarO = zzibVar.o();
            zznkVarO.g();
            zznkVarO.h();
            zznkVarO.u(new zzmq(zznkVarO, zznkVarO.w(true)));
            return;
        }
        zzib.l(zzgtVar);
        zzgtVar.f38965m.a("Recording app launch after enabling measurement for the first time (FE)");
        u();
        zzob zzobVar = zzibVar.f39091h;
        zzib.k(zzobVar);
        zzobVar.f39534e.a();
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzjy(this));
    }

    public final void F() {
        zzib zzibVar = this.f39180a;
        if (!(zzibVar.f39084a.getApplicationContext() instanceof Application) || this.f39315c == null) {
            return;
        }
        ((Application) zzibVar.f39084a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f39315c);
    }

    public final void G(Bundle bundle, int i2, long j2) throws Throwable {
        Boolean bool;
        String string;
        zzjh zzjhVar;
        h();
        zzjk zzjkVar = zzjk.f39198c;
        zzjj[] zzjjVarArr = zzji.STORAGE.f39191a;
        int length = zzjjVarArr.length;
        int i3 = 0;
        while (true) {
            bool = null;
            if (i3 >= length) {
                string = null;
                break;
            }
            String str = zzjjVarArr[i3].f39197a;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if ((string.equals("granted") ? Boolean.TRUE : string.equals("denied") ? Boolean.FALSE : null) == null) {
                    break;
                }
            }
            i3++;
        }
        zzib zzibVar = this.f39180a;
        if (string != null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38963k.b(string, "Ignoring invalid consent setting");
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38963k.a("Valid consent values are 'granted', 'denied'");
        }
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        boolean zM = zzhyVar.m();
        zzjk zzjkVarB = zzjk.b(i2, bundle);
        Iterator it = zzjkVarB.f39199a.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            zzjhVar = zzjh.UNINITIALIZED;
            if (!zHasNext) {
                break;
            } else if (((zzjh) it.next()) != zzjhVar) {
                I(zzjkVarB, zM);
                break;
            }
        }
        zzaz zzazVarC = zzaz.c(i2, bundle);
        Iterator it2 = zzazVarC.f38744e.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (((zzjh) it2.next()) != zzjhVar) {
                H(zzazVarC, zM);
                break;
            }
        }
        if (bundle != null) {
            int iOrdinal = zzjk.d(bundle.getString("ad_personalization")).ordinal();
            if (iOrdinal == 2) {
                bool = Boolean.FALSE;
            } else if (iOrdinal == 3) {
                bool = Boolean.TRUE;
            }
        }
        if (bool != null) {
            String str2 = i2 == -30 ? "tcf" : Constants.APP_DIR;
            if (zM) {
                s(j2, bool.toString(), str2, "allow_personalized_ads");
            } else {
                r(str2, "allow_personalized_ads", bool.toString(), false, j2);
            }
        }
    }

    public final void H(zzaz zzazVar, boolean z) {
        zzks zzksVar = new zzks(this, zzazVar);
        if (z) {
            g();
            zzksVar.run();
        } else {
            zzhy zzhyVar = this.f39180a.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.p(zzksVar);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:70:0x010a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final void I(com.google.android.gms.measurement.internal.zzjk r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.I(com.google.android.gms.measurement.internal.zzjk, boolean):void");
    }

    public final void J() {
        zzql.a();
        zzib zzibVar = this.f39180a;
        if (zzibVar.f39087d.q(null, zzfx.Q0)) {
            zzhy zzhyVar = zzibVar.f39090g;
            zzib.l(zzhyVar);
            boolean zM = zzhyVar.m();
            zzgt zzgtVar = zzibVar.f39089f;
            if (zM) {
                zzib.l(zzgtVar);
                zzgtVar.f38958f.a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzae.a()) {
                zzib.l(zzgtVar);
                zzgtVar.f38958f.a("Cannot get trigger URIs from main thread");
                return;
            }
            h();
            zzib.l(zzgtVar);
            zzgtVar.n.a("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzib.l(zzhyVar);
            zzhyVar.q(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkz
                @Override // java.lang.Runnable
                public final void run() throws JSONException, NumberFormatException {
                    zzli zzliVar = this.f39299a;
                    zzhg zzhgVar = zzliVar.f39180a.f39088e;
                    zzib.j(zzhgVar);
                    final Bundle bundleA = zzhgVar.n.a();
                    final zznk zznkVarO = zzliVar.f39180a.o();
                    zznkVarO.g();
                    zznkVarO.h();
                    final zzr zzrVarW = zznkVarO.w(false);
                    final AtomicReference atomicReference2 = atomicReference;
                    zznkVarO.u(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzng
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzga zzgaVar;
                            zznk zznkVar = zznkVarO;
                            AtomicReference atomicReference3 = atomicReference2;
                            zzr zzrVar = zzrVarW;
                            Bundle bundle = bundleA;
                            synchronized (atomicReference3) {
                                try {
                                    zzgaVar = zznkVar.f39485d;
                                } catch (RemoteException e2) {
                                    zzgt zzgtVar2 = zznkVar.f39180a.f39089f;
                                    zzib.l(zzgtVar2);
                                    zzgtVar2.f38958f.b(e2, "Failed to request trigger URIs; remote exception");
                                    atomicReference3.notifyAll();
                                }
                                if (zzgaVar == null) {
                                    zzgt zzgtVar3 = zznkVar.f39180a.f39089f;
                                    zzib.l(zzgtVar3);
                                    zzgtVar3.f38958f.a("Failed to request trigger URIs; not connected to service");
                                } else {
                                    Preconditions.checkNotNull(zzrVar);
                                    zzgaVar.B8(zzrVar, bundle, new zzmd(zznkVar, atomicReference3));
                                    zznkVar.t();
                                }
                            }
                        }
                    });
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzib.l(zzgtVar);
                zzgtVar.f38960h.a("Timed out waiting for get trigger URIs");
            } else {
                zzib.l(zzhyVar);
                zzhyVar.p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException, NumberFormatException {
                        zzli zzliVar = this.f39303a;
                        zzliVar.g();
                        if (Build.VERSION.SDK_INT < 30) {
                            return;
                        }
                        zzhg zzhgVar = zzliVar.f39180a.f39088e;
                        zzib.j(zzhgVar);
                        SparseArray sparseArrayM = zzhgVar.m();
                        for (zzog zzogVar : list) {
                            int i2 = zzogVar.f39546c;
                            if (!sparseArrayM.contains(i2) || ((Long) sparseArrayM.get(i2)).longValue() < zzogVar.f39545b) {
                                zzliVar.K().add(zzogVar);
                            }
                        }
                        zzliVar.L();
                    }
                });
            }
        }
    }

    public final PriorityQueue K() {
        if (this.f39325m == null) {
            this.f39325m = new PriorityQueue(Comparator.comparing(zzlb.f39305a, zzlc.f39306a));
        }
        return this.f39325m;
    }

    public final void L() {
        zzog zzogVar;
        g();
        this.n = false;
        if (K().isEmpty() || this.f39321i || (zzogVar = (zzog) K().poll()) == null) {
            return;
        }
        zzib zzibVar = this.f39180a;
        zzpo zzpoVar = zzibVar.f39092i;
        zzib.j(zzpoVar);
        if (zzpoVar.f39643f == null) {
            zzpoVar.f39643f = MeasurementManagerFutures.a(zzpoVar.f39180a.f39084a);
        }
        MeasurementManagerFutures measurementManagerFutures = zzpoVar.f39643f;
        if (measurementManagerFutures != null) {
            this.f39321i = true;
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgr zzgrVar = zzgtVar.n;
            String str = zzogVar.f39544a;
            zzgrVar.b(str, "Registering trigger URI");
            ListenableFuture listenableFutureD = measurementManagerFutures.d(Uri.parse(str));
            if (listenableFutureD != null) {
                Futures.a(listenableFutureD, new zzjv(this, zzogVar), new zzju(this));
            } else {
                this.f39321i = false;
                K().add(zzogVar);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean j() {
        return false;
    }

    public final void k(zzjk zzjkVar) {
        g();
        boolean z = (zzjkVar.i(zzjj.ANALYTICS_STORAGE) && zzjkVar.i(zzjj.AD_STORAGE)) || this.f39180a.o().p();
        zzib zzibVar = this.f39180a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        if (z != zzibVar.z) {
            zzhy zzhyVar2 = zzibVar.f39090g;
            zzib.l(zzhyVar2);
            zzhyVar2.g();
            zzibVar.z = z;
            zzhg zzhgVar = this.f39180a.f39088e;
            zzib.j(zzhgVar);
            zzhgVar.g();
            Boolean boolValueOf = zzhgVar.k().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzhgVar.k().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                D(Boolean.valueOf(z), false);
            }
        }
    }

    public final void l(String str, String str2, Bundle bundle) {
        m(str, str2, bundle, true, true, this.f39180a.f39094k.currentTimeMillis());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r4 > 500) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
    
        if (r6 > 500) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(java.lang.String r13, java.lang.String r14, android.os.Bundle r15, boolean r16, boolean r17, long r18) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.m(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n() throws Throwable {
        zzib zzibVar;
        String str;
        zzoc zzocVar;
        zzoc zzocVar2;
        zzli zzliVar;
        com.google.android.gms.internal.measurement.zzkp zzkpVar;
        int i2;
        ImmutableMap immutableMapB;
        com.google.android.gms.internal.measurement.zzkp zzkpVar2;
        g();
        zzib zzibVar2 = this.f39180a;
        zzgt zzgtVar = zzibVar2.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38965m.a("Handle tcf update.");
        zzhg zzhgVar = zzibVar2.f39088e;
        zzib.j(zzhgVar);
        SharedPreferences sharedPreferencesL = zzhgVar.l();
        HashMap map = new HashMap();
        zzfw zzfwVar = zzfx.Z0;
        int i3 = 2;
        if (((Boolean) zzfwVar.a(null)).booleanValue()) {
            ImmutableList immutableList = zzoe.f39541a;
            com.google.android.gms.internal.measurement.zzko zzkoVar = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            zzod zzodVar = zzod.f39538a;
            zzibVar = zzibVar2;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(zzkoVar, zzodVar);
            com.google.android.gms.internal.measurement.zzko zzkoVar2 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            zzod zzodVar2 = zzod.f39539b;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(zzkoVar2, zzodVar2);
            com.google.android.gms.internal.measurement.zzko zzkoVar3 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry3 = new AbstractMap.SimpleImmutableEntry(zzkoVar3, zzodVar);
            com.google.android.gms.internal.measurement.zzko zzkoVar4 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry4 = new AbstractMap.SimpleImmutableEntry(zzkoVar4, zzodVar);
            com.google.android.gms.internal.measurement.zzko zzkoVar5 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
            List listAsList = Arrays.asList(simpleImmutableEntry, simpleImmutableEntry2, simpleImmutableEntry3, simpleImmutableEntry4, new AbstractMap.SimpleImmutableEntry(zzkoVar5, zzodVar2), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, zzodVar2), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, zzodVar2));
            ImmutableMap.Builder builder = new ImmutableMap.Builder(listAsList instanceof Collection ? listAsList.size() : 4);
            builder.d(listAsList);
            ImmutableMap immutableMapA = builder.a(true);
            ImmutableSet immutableSetT = ImmutableSet.t("CH");
            char[] cArr = new char[5];
            boolean zContains = sharedPreferencesL.contains("IABTCF_TCString");
            int iB = zzoe.b(sharedPreferencesL, "IABTCF_CmpSdkID");
            int iB2 = zzoe.b(sharedPreferencesL, "IABTCF_PolicyVersion");
            int iB3 = zzoe.b(sharedPreferencesL, "IABTCF_gdprApplies");
            int iB4 = zzoe.b(sharedPreferencesL, "IABTCF_PurposeOneTreatment");
            int iB5 = zzoe.b(sharedPreferencesL, "IABTCF_EnableAdvertiserConsentMode");
            String strA = zzoe.a(sharedPreferencesL, "IABTCF_PublisherCC");
            ImmutableMap.Builder builder2 = new ImmutableMap.Builder();
            UnmodifiableIterator it = immutableMapA.keySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED;
                i2 = iB2;
                if (!zHasNext) {
                    break;
                }
                com.google.android.gms.internal.measurement.zzko zzkoVar6 = (com.google.android.gms.internal.measurement.zzko) it.next();
                boolean z = zContains;
                int iZza = zzkoVar6.zza();
                String str2 = strA;
                int i4 = iB4;
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(iZza);
                String strA2 = zzoe.a(sharedPreferencesL, sb.toString());
                if (TextUtils.isEmpty(strA2) || strA2.length() < 755) {
                    zzkpVar2 = zzkpVar;
                } else {
                    int iDigit = Character.digit(strA2.charAt(754), 10);
                    zzkpVar2 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    if (iDigit >= 0 && iDigit <= com.google.android.gms.internal.measurement.zzkp.values().length && iDigit != 0) {
                        if (iDigit == 1) {
                            zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                        } else if (iDigit == i3) {
                            zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                        }
                        zzkpVar2 = zzkpVar;
                    }
                }
                builder2.c(zzkoVar6, zzkpVar2);
                zContains = z;
                iB2 = i2;
                strA = str2;
                iB4 = i4;
                i3 = 2;
            }
            String str3 = strA;
            boolean z2 = zContains;
            int i5 = iB4;
            ImmutableMap immutableMapA2 = builder2.a(true);
            String strA3 = zzoe.a(sharedPreferencesL, "IABTCF_PurposeConsents");
            String strA4 = zzoe.a(sharedPreferencesL, "IABTCF_VendorConsents");
            boolean z3 = !TextUtils.isEmpty(strA4) && strA4.length() >= 755 && strA4.charAt(754) == '1';
            String strA5 = zzoe.a(sharedPreferencesL, "IABTCF_PurposeLegitimateInterests");
            String strA6 = zzoe.a(sharedPreferencesL, "IABTCF_VendorLegitimateInterests");
            boolean z4 = !TextUtils.isEmpty(strA6) && strA6.length() >= 755 && strA6.charAt(754) == '1';
            cArr[0] = '2';
            if (!((Boolean) zzfx.a1.a(null)).booleanValue() || z2) {
                com.google.android.gms.internal.measurement.zzkp zzkpVar3 = (com.google.android.gms.internal.measurement.zzkp) immutableMapA2.get(zzkoVar);
                com.google.android.gms.internal.measurement.zzkp zzkpVar4 = (com.google.android.gms.internal.measurement.zzkp) immutableMapA2.get(zzkoVar3);
                com.google.android.gms.internal.measurement.zzkp zzkpVar5 = (com.google.android.gms.internal.measurement.zzkp) immutableMapA2.get(zzkoVar4);
                com.google.android.gms.internal.measurement.zzkp zzkpVar6 = (com.google.android.gms.internal.measurement.zzkp) immutableMapA2.get(zzkoVar5);
                ImmutableMap.Builder builder3 = new ImmutableMap.Builder();
                builder3.c("Version", "2");
                boolean z5 = z3;
                builder3.c("VendorConsent", true != z3 ? "0" : "1");
                boolean z6 = z4;
                builder3.c("VendorLegitimateInterest", true != z4 ? "0" : "1");
                builder3.c("gdprApplies", iB3 != 1 ? "0" : "1");
                builder3.c("EnableAdvertiserConsentMode", iB5 != 1 ? "0" : "1");
                builder3.c("PolicyVersion", String.valueOf(i2));
                builder3.c("CmpSdkID", String.valueOf(iB));
                builder3.c("PurposeOneTreatment", i5 != 1 ? "0" : "1");
                builder3.c("PublisherCC", str3);
                builder3.c("PublisherRestrictions1", String.valueOf(zzkpVar3 != null ? zzkpVar3.zza() : zzkpVar.zza()));
                builder3.c("PublisherRestrictions3", String.valueOf(zzkpVar4 != null ? zzkpVar4.zza() : zzkpVar.zza()));
                builder3.c("PublisherRestrictions4", String.valueOf(zzkpVar5 != null ? zzkpVar5.zza() : zzkpVar.zza()));
                builder3.c("PublisherRestrictions7", String.valueOf(zzkpVar6 != null ? zzkpVar6.zza() : zzkpVar.zza()));
                builder3.d(ImmutableMap.l(zzoe.e(zzkoVar, strA3, strA5), zzoe.e(zzkoVar3, strA3, strA5), zzoe.e(zzkoVar4, strA3, strA5), zzoe.e(zzkoVar5, strA3, strA5)).entrySet());
                immutableMapB = builder3.e(ImmutableMap.m(true != zzoe.c(zzkoVar, immutableMapA, immutableMapA2, immutableSetT, cArr, iB5, iB3, i5, str3, strA3, strA5, z5, z6) ? "0" : "1", true != zzoe.c(zzkoVar3, immutableMapA, immutableMapA2, immutableSetT, cArr, iB5, iB3, i5, str3, strA3, strA5, z5, z6) ? "0" : "1", true != zzoe.c(zzkoVar4, immutableMapA, immutableMapA2, immutableSetT, cArr, iB5, iB3, i5, str3, strA3, strA5, z5, z6) ? "0" : "1", true != zzoe.c(zzkoVar5, immutableMapA, immutableMapA2, immutableSetT, cArr, iB5, iB3, i5, str3, strA3, strA5, z5, z6) ? "0" : "1", new String(cArr))).b();
            } else {
                immutableMapB = ImmutableMap.j();
            }
            zzocVar = new zzoc(immutableMapB);
            str = "";
        } else {
            zzibVar = zzibVar2;
            String strA7 = zzoe.a(sharedPreferencesL, "IABTCF_VendorConsents");
            str = "";
            if (!str.equals(strA7) && strA7.length() > 754) {
                map.put("GoogleConsent", String.valueOf(strA7.charAt(754)));
            }
            int iB6 = zzoe.b(sharedPreferencesL, "IABTCF_gdprApplies");
            if (iB6 != -1) {
                map.put("gdprApplies", String.valueOf(iB6));
            }
            int iB7 = zzoe.b(sharedPreferencesL, "IABTCF_EnableAdvertiserConsentMode");
            if (iB7 != -1) {
                map.put("EnableAdvertiserConsentMode", String.valueOf(iB7));
            }
            int iB8 = zzoe.b(sharedPreferencesL, "IABTCF_PolicyVersion");
            if (iB8 != -1) {
                map.put("PolicyVersion", String.valueOf(iB8));
            }
            String strA8 = zzoe.a(sharedPreferencesL, "IABTCF_PurposeConsents");
            if (!str.equals(strA8)) {
                map.put("PurposeConsents", strA8);
            }
            int iB9 = zzoe.b(sharedPreferencesL, "IABTCF_CmpSdkID");
            if (iB9 != -1) {
                map.put("CmpSdkID", String.valueOf(iB9));
            }
            zzocVar = new zzoc(map);
        }
        zzib zzibVar3 = zzibVar;
        zzgt zzgtVar2 = zzibVar3.f39089f;
        zzib.l(zzgtVar2);
        zzgr zzgrVar = zzgtVar2.n;
        zzgrVar.b(zzocVar, "Tcf preferences read");
        boolean zQ = zzibVar3.f39087d.q(null, zzfwVar);
        Clock clock = zzibVar3.f39094k;
        if (!zQ) {
            if (zzhgVar.o(zzocVar)) {
                Bundle bundleB = zzocVar.b();
                zzib.l(zzgtVar2);
                zzgrVar.b(bundleB, "Consent generated from Tcf");
                if (bundleB != Bundle.EMPTY) {
                    G(bundleB, -30, clock.currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", zzocVar.c());
                o("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        zzhgVar.g();
        String string = zzhgVar.k().getString("stored_tcf_param", str);
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            zzocVar2 = new zzoc(map2);
        } else {
            for (String str4 : string.split(";")) {
                String[] strArrSplit = str4.split("=");
                if (strArrSplit.length >= 2 && zzoe.f39541a.contains(strArrSplit[0])) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            zzocVar2 = new zzoc(map2);
        }
        if (zzhgVar.o(zzocVar)) {
            Bundle bundleB2 = zzocVar.b();
            zzib.l(zzgtVar2);
            zzgrVar.b(bundleB2, "Consent generated from Tcf");
            if (bundleB2 != Bundle.EMPTY) {
                zzliVar = this;
                zzliVar.G(bundleB2, -30, clock.currentTimeMillis());
            } else {
                zzliVar = this;
            }
            Bundle bundle2 = new Bundle();
            HashMap map3 = zzocVar2.f39537a;
            String str5 = (map3.isEmpty() || ((String) map3.get("Version")) != null) ? "0" : "1";
            Bundle bundleB3 = zzocVar.b();
            Bundle bundleB4 = zzocVar2.b();
            bundle2.putString("_tcfm", str5.concat((bundleB3.size() == bundleB4.size() && Objects.equals(bundleB3.getString("ad_storage"), bundleB4.getString("ad_storage")) && Objects.equals(bundleB3.getString("ad_personalization"), bundleB4.getString("ad_personalization")) && Objects.equals(bundleB3.getString("ad_user_data"), bundleB4.getString("ad_user_data"))) ? "0" : "1"));
            String str6 = (String) zzocVar.f39537a.get("PurposeDiagnostics");
            if (TextUtils.isEmpty(str6)) {
                str6 = "200000";
            }
            bundle2.putString("_tcfd2", str6);
            bundle2.putString("_tcfd", zzocVar.c());
            zzliVar.o("auto", "_tcf", bundle2);
        }
    }

    public final void o(String str, String str2, Bundle bundle) {
        g();
        p(this.f39180a.f39094k.currentTimeMillis(), bundle, str, str2);
    }

    public final void p(long j2, Bundle bundle, String str, String str2) {
        g();
        boolean z = true;
        if (this.f39316d != null && !zzpo.D(str2)) {
            z = false;
        }
        q(str, str2, j2, bundle, true, z, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(java.lang.String r26, java.lang.String r27, long r28, android.os.Bundle r30, boolean r31, boolean r32, boolean r33) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1175
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.q(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.lang.String r12, java.lang.String r13, java.lang.Object r14, boolean r15, long r16) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.r(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(long r14, java.lang.Object r16, java.lang.String r17, java.lang.String r18) {
        /*
            r13 = this;
            r0 = r16
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r17)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)
            r13.g()
            r13.h()
            java.lang.String r1 = "allow_personalized_ads"
            r2 = r18
            boolean r1 = r1.equals(r2)
            r3 = 1
            com.google.android.gms.measurement.internal.zzib r4 = r13.f39180a
            if (r1 == 0) goto L74
            boolean r1 = r0 instanceof java.lang.String
            java.lang.String r5 = "_npa"
            if (r1 == 0) goto L53
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L53
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r0 = r1.toLowerCase(r0)
            java.lang.String r1 = "false"
            boolean r0 = r1.equals(r0)
            r6 = 1
            if (r3 == r0) goto L3d
            r8 = 0
            goto L3e
        L3d:
            r8 = r6
        L3e:
            java.lang.Long r0 = java.lang.Long.valueOf(r8)
            com.google.android.gms.measurement.internal.zzhg r2 = r4.f39088e
            com.google.android.gms.measurement.internal.zzib.j(r2)
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L4d
            java.lang.String r1 = "true"
        L4d:
            com.google.android.gms.measurement.internal.zzhf r2 = r2.f39032m
            r2.b(r1)
            goto L63
        L53:
            if (r0 != 0) goto L62
            com.google.android.gms.measurement.internal.zzhg r1 = r4.f39088e
            com.google.android.gms.measurement.internal.zzib.j(r1)
            com.google.android.gms.measurement.internal.zzhf r1 = r1.f39032m
            java.lang.String r2 = "unset"
            r1.b(r2)
            goto L63
        L62:
            r5 = r2
        L63:
            com.google.android.gms.measurement.internal.zzgt r1 = r4.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r1)
            java.lang.String r2 = "non_personalized_ads(_npa)"
            com.google.android.gms.measurement.internal.zzgr r1 = r1.n
            java.lang.String r6 = "Setting user property(FE)"
            r1.c(r6, r2, r0)
            r11 = r5
        L72:
            r10 = r0
            goto L76
        L74:
            r11 = r2
            goto L72
        L76:
            boolean r0 = r4.a()
            if (r0 != 0) goto L89
            com.google.android.gms.measurement.internal.zzgt r14 = r4.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r14)
            java.lang.String r15 = "User property not set since app measurement is disabled"
            com.google.android.gms.measurement.internal.zzgr r14 = r14.n
            r14.a(r15)
            return
        L89:
            boolean r0 = r4.h()
            if (r0 != 0) goto L90
            return
        L90:
            com.google.android.gms.measurement.internal.zzpk r7 = new com.google.android.gms.measurement.internal.zzpk
            r8 = r14
            r12 = r17
            r7.<init>(r8, r10, r11, r12)
            com.google.android.gms.measurement.internal.zznk r14 = r4.o()
            r14.g()
            r14.h()
            r14.s()
            com.google.android.gms.measurement.internal.zzib r15 = r14.f39180a
            com.google.android.gms.measurement.internal.zzgk r15 = r15.n()
            r15.getClass()
            android.os.Parcel r0 = android.os.Parcel.obtain()
            com.google.android.gms.measurement.internal.zzpl.a(r7, r0)
            byte[] r1 = r0.marshall()
            r0.recycle()
            int r0 = r1.length
            r2 = 131072(0x20000, float:1.83671E-40)
            if (r0 <= r2) goto Ld1
            com.google.android.gms.measurement.internal.zzib r15 = r15.f39180a
            com.google.android.gms.measurement.internal.zzgt r15 = r15.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r15)
            java.lang.String r0 = "User property too long for local database. Sending directly to service"
            com.google.android.gms.measurement.internal.zzgr r15 = r15.f38959g
            r15.a(r0)
            r15 = 0
            goto Ld5
        Ld1:
            boolean r15 = r15.n(r3, r1)
        Ld5:
            com.google.android.gms.measurement.internal.zzr r0 = r14.w(r3)
            com.google.android.gms.measurement.internal.zzmf r1 = new com.google.android.gms.measurement.internal.zzmf
            r1.<init>(r14, r0, r15, r7)
            r14.u(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.s(long, java.lang.Object, java.lang.String, java.lang.String):void");
    }

    public final Map t(String str, String str2, boolean z) {
        zzib zzibVar = this.f39180a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        boolean zM = zzhyVar.m();
        zzgt zzgtVar = zzibVar.f39089f;
        if (zM) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if (zzae.a()) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        zzhy zzhyVar2 = zzibVar.f39090g;
        zzib.l(zzhyVar2);
        zzhyVar2.q(atomicReference, 5000L, "get user properties", new zzkk(this, atomicReference, str, str2, z));
        List<zzpk> list = (List) atomicReference.get();
        if (list == null) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(Boolean.valueOf(z), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.EMPTY_MAP;
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzpk zzpkVar : list) {
            Object objB = zzpkVar.b();
            if (objB != null) {
                arrayMap.put(zzpkVar.f39627b, objB);
            }
        }
        return arrayMap;
    }

    public final void u() {
        g();
        h();
        zzib zzibVar = this.f39180a;
        if (zzibVar.h()) {
            zzal zzalVar = zzibVar.f39087d;
            zzalVar.f39180a.getClass();
            Boolean boolS = zzalVar.s("google_analytics_deferred_deep_link_enabled");
            if (boolS != null && boolS.booleanValue()) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38965m.a("Deferred Deep Link feature enabled.");
                zzhy zzhyVar = zzibVar.f39090g;
                zzib.l(zzhyVar);
                zzhyVar.p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlg
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzli zzliVar = this.f39312a;
                        zzliVar.g();
                        zzib zzibVar2 = zzliVar.f39180a;
                        zzhg zzhgVar = zzibVar2.f39088e;
                        zzib.j(zzhgVar);
                        boolean zA = zzhgVar.t.a();
                        zzgt zzgtVar2 = zzibVar2.f39089f;
                        if (zA) {
                            zzib.l(zzgtVar2);
                            zzgtVar2.f38965m.a("Deferred Deep Link already retrieved. Not fetching again.");
                            return;
                        }
                        zzhg zzhgVar2 = zzibVar2.f39088e;
                        zzib.j(zzhgVar2);
                        zzhd zzhdVar = zzhgVar2.u;
                        long jA = zzhdVar.a();
                        zzhdVar.b(1 + jA);
                        if (jA >= 5) {
                            zzib.l(zzgtVar2);
                            zzgtVar2.f38961i.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                            zzhgVar2.t.b(true);
                        } else {
                            if (zzliVar.t == null) {
                                zzliVar.t = new zzkf(zzliVar, zzibVar2);
                            }
                            zzliVar.t.b(0L);
                        }
                    }
                });
            }
            zznk zznkVarO = zzibVar.o();
            zznkVarO.g();
            zznkVarO.h();
            zzr zzrVarW = zznkVarO.w(true);
            zznkVarO.s();
            zzib zzibVar2 = zznkVarO.f39180a;
            zzibVar2.f39087d.q(null, zzfx.c1);
            zzibVar2.n().n(3, new byte[0]);
            zznkVarO.u(new zzmj(zznkVarO, zzrVarW));
            this.s = false;
            zzhg zzhgVar = zzibVar.f39088e;
            zzib.j(zzhgVar);
            zzhgVar.g();
            String string = zzhgVar.k().getString("previous_os_version", null);
            zzhgVar.f39180a.p().i();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = zzhgVar.k().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            zzibVar.p().i();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            o("auto", "_ou", bundle);
        }
    }

    public final void v(String str) {
        Preconditions.checkNotEmpty(str);
        this.f39180a.getClass();
    }

    public final void w(Bundle bundle) {
        x(bundle, this.f39180a.f39094k.currentTimeMillis());
    }

    public final void x(Bundle bundle, long j2) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        boolean zIsEmpty = TextUtils.isEmpty(bundle2.getString("app_id"));
        zzib zzibVar = this.f39180a;
        if (!zIsEmpty) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjg.b(bundle2, "app_id", String.class, null);
        zzjg.b(bundle2, "origin", String.class, null);
        zzjg.b(bundle2, CLConstants.FIELD_PAY_INFO_NAME, String.class, null);
        zzjg.b(bundle2, CLConstants.FIELD_PAY_INFO_VALUE, Object.class, null);
        zzjg.b(bundle2, "trigger_event_name", String.class, null);
        zzjg.b(bundle2, "trigger_timeout", Long.class, 0L);
        zzjg.b(bundle2, "timed_out_event_name", String.class, null);
        zzjg.b(bundle2, "timed_out_event_params", Bundle.class, null);
        zzjg.b(bundle2, "triggered_event_name", String.class, null);
        zzjg.b(bundle2, "triggered_event_params", Bundle.class, null);
        zzjg.b(bundle2, "time_to_live", Long.class, 0L);
        zzjg.b(bundle2, "expired_event_name", String.class, null);
        zzjg.b(bundle2, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString(CLConstants.FIELD_PAY_INFO_NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get(CLConstants.FIELD_PAY_INFO_VALUE));
        bundle2.putLong("creation_timestamp", j2);
        String string = bundle2.getString(CLConstants.FIELD_PAY_INFO_NAME);
        Object obj = bundle2.get(CLConstants.FIELD_PAY_INFO_VALUE);
        zzpo zzpoVar = zzibVar.f39092i;
        zzib.j(zzpoVar);
        int iK0 = zzpoVar.k0(string);
        zzgm zzgmVar = zzibVar.f39093j;
        zzgt zzgtVar2 = zzibVar.f39089f;
        if (iK0 != 0) {
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(zzgmVar.c(string), "Invalid conditional user property name");
            return;
        }
        zzpo zzpoVar2 = zzibVar.f39092i;
        zzib.j(zzpoVar2);
        if (zzpoVar2.t(obj, string) != 0) {
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Invalid conditional user property value", zzgmVar.c(string), obj);
            return;
        }
        Object objU = zzpoVar2.u(obj, string);
        if (objU == null) {
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Unable to normalize conditional user property value", zzgmVar.c(string), obj);
            return;
        }
        zzjg.a(bundle2, objU);
        long j3 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j3 > 15552000000L || j3 < 1)) {
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Invalid conditional user property timeout", zzgmVar.c(string), Long.valueOf(j3));
            return;
        }
        long j4 = bundle2.getLong("time_to_live");
        if (j4 <= 15552000000L && j4 >= 1) {
            zzhy zzhyVar = zzibVar.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.p(new zzkh(this, bundle2));
        } else {
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Invalid conditional user property time to live", zzgmVar.c(string), Long.valueOf(j4));
        }
    }

    public final void y(String str, String str2, Bundle bundle) {
        zzib zzibVar = this.f39180a;
        long jCurrentTimeMillis = zzibVar.f39094k.currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(CLConstants.FIELD_PAY_INFO_NAME, str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzki(this, bundle2));
    }

    public final ArrayList z(String str, String str2) {
        zzib zzibVar = this.f39180a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        boolean zM = zzhyVar.m();
        zzgt zzgtVar = zzibVar.f39089f;
        if (zM) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (zzae.a()) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        zzhy zzhyVar2 = zzibVar.f39090g;
        zzib.l(zzhyVar2);
        zzhyVar2.q(atomicReference, 5000L, "get conditional user properties", new zzkj(this, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzpo.U(list);
        }
        zzib.l(zzgtVar);
        zzgtVar.f38958f.b(null, "Timed out waiting for get conditional user properties");
        return new ArrayList();
    }
}
