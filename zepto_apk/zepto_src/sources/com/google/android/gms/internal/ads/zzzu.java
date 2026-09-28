package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzzu extends zzaaa implements zzmj {

    /* renamed from: k, reason: collision with root package name */
    public static final zzgux f35988k = new zzgsm();

    /* renamed from: c, reason: collision with root package name */
    public final Object f35989c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f35990d;

    /* renamed from: e, reason: collision with root package name */
    public zzzf f35991e;

    /* renamed from: f, reason: collision with root package name */
    public Thread f35992f;

    /* renamed from: g, reason: collision with root package name */
    public zzzj f35993g;

    /* renamed from: h, reason: collision with root package name */
    public zzd f35994h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f35995i;

    /* renamed from: j, reason: collision with root package name */
    public final zzyn f35996j;

    public zzzu(Context context) {
        zzyn zzynVar = new zzyn();
        zzzf zzzfVar = zzzf.F;
        this.f35989c = new Object();
        this.f35990d = context != null ? context.getApplicationContext() : null;
        this.f35996j = zzynVar;
        if (zzzfVar != null) {
            this.f35991e = zzzfVar;
        } else {
            zzze zzzeVar = new zzze(zzzfVar);
            zzzeVar.a(zzzfVar);
            this.f35991e = new zzzf(zzzeVar);
        }
        this.f35994h = zzd.f27533b;
        if (this.f35991e.A && context == null) {
            zzee.c("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static int i(zzv zzvVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzvVar.f35682d)) {
            return 4;
        }
        String strH = h(str);
        String strH2 = h(zzvVar.f35682d);
        if (strH2 == null || strH == null) {
            return (z && strH2 == null) ? 1 : 0;
        }
        if (strH2.startsWith(strH) || strH.startsWith(strH2)) {
            return 3;
        }
        String str2 = zzfj.f31254a;
        return strH2.split("-", 2)[0].equals(strH.split("-", 2)[0]) ? 2 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int j(com.google.android.gms.internal.ads.zzv r5, com.google.android.gms.internal.ads.zzgtd r6) {
        /*
            r0 = 0
            r1 = r0
        L2:
            r2 = r6
            com.google.android.gms.internal.ads.zzguy r2 = (com.google.android.gms.internal.ads.zzguy) r2
            int r2 = r2.f33234d
            if (r1 >= r2) goto L2e
            r2 = r0
        La:
            com.google.android.gms.internal.ads.zzgtd r3 = r5.f35681c
            int r4 = r3.size()
            if (r2 >= r4) goto L2b
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.ads.zzx r3 = (com.google.android.gms.internal.ads.zzx) r3
            java.lang.String r3 = r3.f35803b
            r4 = r6
            com.google.android.gms.internal.ads.zzguy r4 = (com.google.android.gms.internal.ads.zzguy) r4
            java.lang.Object r4 = r4.get(r1)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L28
            return r1
        L28:
            int r2 = r2 + 1
            goto La
        L2b:
            int r1 = r1 + 1
            goto L2
        L2e:
            r5 = 2147483647(0x7fffffff, float:NaN)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzu.j(com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzgtd):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.google.android.gms.internal.ads.zzgtd] */
    public static final Pair l(int i2, zzzz zzzzVar, int[][][] iArr, zzzl zzzlVar, Comparator comparator) {
        int i3;
        ?? arrayList;
        zzzz zzzzVar2 = zzzzVar;
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        while (i4 < 2) {
            if (i2 == zzzzVar2.f36000a[i4]) {
                zzyh zzyhVar = zzzzVar2.f36001b[i4];
                for (int i5 = 0; i5 < zzyhVar.f35905a; i5++) {
                    zzbg zzbgVarA = zzyhVar.a(i5);
                    List listA = zzzlVar.a(i4, zzbgVarA, iArr[i4][i5]);
                    int i6 = zzbgVarA.f24983a;
                    boolean[] zArr = new boolean[i6];
                    int i7 = 0;
                    while (i7 < i6) {
                        int i8 = i7 + 1;
                        zzguy zzguyVar = (zzguy) listA;
                        zzzm zzzmVar = (zzzm) zzguyVar.get(i7);
                        int iZza = zzzmVar.zza();
                        if (zArr[i7] || iZza == 0) {
                            i3 = i4;
                        } else {
                            if (iZza == 1) {
                                arrayList = zzgtd.n(zzzmVar);
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(zzzmVar);
                                int i9 = i8;
                                while (i9 < i6) {
                                    zzzm zzzmVar2 = (zzzm) zzguyVar.get(i9);
                                    int i10 = i4;
                                    if (zzzmVar2.zza() == 2 && zzzmVar.a(zzzmVar2)) {
                                        arrayList.add(zzzmVar2);
                                        zArr[i9] = true;
                                    }
                                    i9++;
                                    i4 = i10;
                                }
                            }
                            i3 = i4;
                            arrayList2.add(arrayList);
                        }
                        i7 = i8;
                        i4 = i3;
                    }
                }
            }
            i4++;
            zzzzVar2 = zzzzVar;
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList2, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            iArr2[i11] = ((zzzm) list.get(i11)).f35972c;
        }
        zzzm zzzmVar3 = (zzzm) list.get(0);
        return Pair.create(new zzzv(zzzmVar3.f35971b, iArr2), Integer.valueOf(zzzmVar3.f35970a));
    }

    @Override // com.google.android.gms.internal.ads.zzaad
    public final void a() {
        zzzj zzzjVar;
        Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener;
        Handler handler;
        synchronized (this.f35989c) {
            try {
                Thread thread = this.f35992f;
                if (thread != null) {
                    zzgqa.g("DefaultTrackSelector is accessed on the wrong thread.", thread == Thread.currentThread());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzzjVar = this.f35993g) != null) {
            Spatializer spatializer = zzzjVar.f35957a;
            if (spatializer != null && (spatializer$OnSpatializerStateChangedListener = zzzjVar.f35960d) != null && (handler = zzzjVar.f35959c) != null) {
                spatializer.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
                handler.removeCallbacksAndMessages(null);
            }
            this.f35993g = null;
        }
        super.a();
    }

    @Override // com.google.android.gms.internal.ads.zzaad
    public final void c(zzd zzdVar) {
        if (this.f35994h.equals(zzdVar)) {
            return;
        }
        this.f35994h = zzdVar;
        k();
    }

    @Override // com.google.android.gms.internal.ads.zzaad
    public final zzmj d() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0106  */
    @Override // com.google.android.gms.internal.ads.zzaaa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair g(com.google.android.gms.internal.ads.zzzz r27, int[][][] r28, final int[] r29) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzu.g(com.google.android.gms.internal.ads.zzzz, int[][][], int[]):android.util.Pair");
    }

    public final void k() {
        boolean z;
        zzaac zzaacVar;
        zzzj zzzjVar;
        synchronized (this.f35989c) {
            try {
                z = false;
                if (this.f35991e.A && Build.VERSION.SDK_INT >= 32 && (zzzjVar = this.f35993g) != null && zzzjVar.f35958b) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z || (zzaacVar = this.f22576a) == null) {
            return;
        }
        ((zzlc) zzaacVar).f35075h.zzh(10);
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zza() {
        synchronized (this.f35989c) {
            this.f35991e.getClass();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaad
    public final void b() {
    }
}
