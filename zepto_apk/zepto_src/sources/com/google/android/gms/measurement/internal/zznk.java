package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.DateUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public final class zznk extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public final zzne f39484c;

    /* renamed from: d, reason: collision with root package name */
    public zzga f39485d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Boolean f39486e;

    /* renamed from: f, reason: collision with root package name */
    public final zzml f39487f;

    /* renamed from: g, reason: collision with root package name */
    public ScheduledExecutorService f39488g;

    /* renamed from: h, reason: collision with root package name */
    public final zzof f39489h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f39490i;

    /* renamed from: j, reason: collision with root package name */
    public final zzmp f39491j;

    public zznk(zzib zzibVar) {
        super(zzibVar);
        this.f39490i = new ArrayList();
        this.f39489h = new zzof(zzibVar.f39094k);
        this.f39484c = new zzne(this);
        this.f39487f = new zzml(this, zzibVar);
        this.f39491j = new zzmp(this, zzibVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean j() {
        return false;
    }

    public final void k(AtomicReference atomicReference) {
        g();
        h();
        u(new zzmh(this, atomicReference, w(false)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.os.Bundle r8) {
        /*
            r7 = this;
            r7.g()
            r7.h()
            com.google.android.gms.measurement.internal.zzbe r4 = new com.google.android.gms.measurement.internal.zzbe
            r4.<init>(r8)
            r7.s()
            com.google.android.gms.measurement.internal.zzib r0 = r7.f39180a
            com.google.android.gms.measurement.internal.zzal r1 = r0.f39087d
            r2 = 0
            com.google.android.gms.measurement.internal.zzfw r3 = com.google.android.gms.measurement.internal.zzfx.c1
            boolean r1 = r1.q(r2, r3)
            r2 = 0
            if (r1 == 0) goto L55
            com.google.android.gms.measurement.internal.zzgk r0 = r0.n()
            com.google.android.gms.measurement.internal.zzib r1 = r0.f39180a
            com.google.android.gms.measurement.internal.zzpo r3 = r1.f39092i
            com.google.android.gms.measurement.internal.zzib.j(r3)
            byte[] r3 = com.google.android.gms.measurement.internal.zzpo.J(r4)
            com.google.android.gms.measurement.internal.zzgt r1 = r1.f39089f
            if (r3 != 0) goto L3b
            com.google.android.gms.measurement.internal.zzib.l(r1)
            java.lang.String r0 = "Null default event parameters; not writing to database"
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38959g
            r1.a(r0)
        L39:
            r0 = r2
            goto L50
        L3b:
            int r5 = r3.length
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r5 <= r6) goto L4b
            com.google.android.gms.measurement.internal.zzib.l(r1)
            java.lang.String r0 = "Default event parameters too long for local database. Sending directly to service"
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38959g
            r1.a(r0)
            goto L39
        L4b:
            r1 = 4
            boolean r0 = r0.n(r1, r3)
        L50:
            if (r0 == 0) goto L55
            r0 = 1
            r3 = r0
            goto L56
        L55:
            r3 = r2
        L56:
            com.google.android.gms.measurement.internal.zzr r2 = r7.w(r2)
            com.google.android.gms.measurement.internal.zzmn r0 = new com.google.android.gms.measurement.internal.zzmn
            r1 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r7.u(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznk.l(android.os.Bundle):void");
    }

    public final void m() {
        g();
        h();
        if (x()) {
            return;
        }
        if (n()) {
            zzne zzneVar = this.f39484c;
            zznk zznkVar = zzneVar.f39470c;
            zznkVar.g();
            Context context = zznkVar.f39180a.f39084a;
            synchronized (zzneVar) {
                try {
                    if (zzneVar.f39468a) {
                        zzgt zzgtVar = zzneVar.f39470c.f39180a.f39089f;
                        zzib.l(zzgtVar);
                        zzgtVar.n.a("Connection attempt already in progress");
                        return;
                    } else {
                        if (zzneVar.f39469b != null && (zzneVar.f39469b.isConnecting() || zzneVar.f39469b.isConnected())) {
                            zzgt zzgtVar2 = zzneVar.f39470c.f39180a.f39089f;
                            zzib.l(zzgtVar2);
                            zzgtVar2.n.a("Already awaiting connection attempt");
                            return;
                        }
                        zzneVar.f39469b = new zzgn(context, Looper.getMainLooper(), zzneVar, zzneVar);
                        zzgt zzgtVar3 = zzneVar.f39470c.f39180a.f39089f;
                        zzib.l(zzgtVar3);
                        zzgtVar3.n.a("Connecting to remote service");
                        zzneVar.f39468a = true;
                        Preconditions.checkNotNull(zzneVar.f39469b);
                        zzneVar.f39469b.checkAvailabilityAndConnect();
                        return;
                    }
                } finally {
                }
            }
        }
        zzib zzibVar = this.f39180a;
        if (zzibVar.f39087d.j()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = zzibVar.f39084a.getPackageManager().queryIntentServices(new Intent().setClassName(zzibVar.f39084a, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            zzgt zzgtVar4 = zzibVar.f39089f;
            zzib.l(zzgtVar4);
            zzgtVar4.f38958f.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(zzibVar.f39084a, "com.google.android.gms.measurement.AppMeasurementService"));
        zzne zzneVar2 = this.f39484c;
        zznk zznkVar2 = zzneVar2.f39470c;
        zznkVar2.g();
        Context context2 = zznkVar2.f39180a.f39084a;
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (zzneVar2) {
            try {
                if (zzneVar2.f39468a) {
                    zzgt zzgtVar5 = zzneVar2.f39470c.f39180a.f39089f;
                    zzib.l(zzgtVar5);
                    zzgtVar5.n.a("Connection attempt already in progress");
                } else {
                    zznk zznkVar3 = zzneVar2.f39470c;
                    zzgt zzgtVar6 = zznkVar3.f39180a.f39089f;
                    zzib.l(zzgtVar6);
                    zzgtVar6.n.a("Using local app measurement service");
                    zzneVar2.f39468a = true;
                    connectionTracker.bindService(context2, intent, zznkVar3.f39484c, WKSRecord.Service.PWDGEN);
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznk.n():boolean");
    }

    public final void o() {
        g();
        h();
        zzne zzneVar = this.f39484c;
        if (zzneVar.f39469b != null && (zzneVar.f39469b.isConnected() || zzneVar.f39469b.isConnecting())) {
            zzneVar.f39469b.disconnect();
        }
        zzneVar.f39469b = null;
        try {
            ConnectionTracker.getInstance().unbindService(this.f39180a.f39084a, zzneVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f39485d = null;
    }

    public final boolean p() {
        g();
        h();
        if (!n()) {
            return true;
        }
        zzpo zzpoVar = this.f39180a.f39092i;
        zzib.j(zzpoVar);
        return zzpoVar.L() >= ((Integer) zzfx.J0.a(null)).intValue();
    }

    public final boolean q() {
        g();
        h();
        if (!n()) {
            return true;
        }
        zzpo zzpoVar = this.f39180a.f39092i;
        zzib.j(zzpoVar);
        return zzpoVar.L() >= 241200;
    }

    public final void r(ComponentName componentName) {
        g();
        if (this.f39485d != null) {
            this.f39485d = null;
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.b(componentName, "Disconnected from device MeasurementService");
            g();
            m();
        }
    }

    public final void s() {
        this.f39180a.getClass();
    }

    public final void t() {
        g();
        zzof zzofVar = this.f39489h;
        zzofVar.f39543b = zzofVar.f39542a.elapsedRealtime();
        this.f39180a.getClass();
        this.f39487f.b(((Long) zzfx.Y.a(null)).longValue());
    }

    public final void u(Runnable runnable) {
        g();
        if (x()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.f39490i;
        long size = arrayList.size();
        zzib zzibVar = this.f39180a;
        zzibVar.getClass();
        if (size >= 1000) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.f39491j.b(DateUtils.MILLIS_PER_MINUTE);
            m();
        }
    }

    public final void v() {
        g();
        zzib zzibVar = this.f39180a;
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        ArrayList arrayList = this.f39490i;
        zzgtVar.n.b(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e2) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.b(e2, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.f39491j.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzr w(boolean r11) {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzib r0 = r10.f39180a
            r0.getClass()
            com.google.android.gms.measurement.internal.zzgh r1 = r0.q()
            r2 = 0
            if (r11 == 0) goto Lb7
            com.google.android.gms.measurement.internal.zzgt r11 = r0.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r11)
            com.google.android.gms.measurement.internal.zzib r11 = r11.f39180a
            com.google.android.gms.measurement.internal.zzhg r0 = r11.f39088e
            com.google.android.gms.measurement.internal.zzib.j(r0)
            com.google.android.gms.measurement.internal.zzhe r0 = r0.f39024e
            if (r0 != 0) goto L1e
            goto Lb7
        L1e:
            com.google.android.gms.measurement.internal.zzhg r11 = r11.f39088e
            com.google.android.gms.measurement.internal.zzib.j(r11)
            com.google.android.gms.measurement.internal.zzhe r11 = r11.f39024e
            com.google.android.gms.measurement.internal.zzhg r0 = r11.f39017e
            r0.g()
            r0.g()
            com.google.android.gms.measurement.internal.zzhg r3 = r11.f39017e
            android.content.SharedPreferences r3 = r3.k()
            java.lang.String r4 = r11.f39013a
            r5 = 0
            long r3 = r3.getLong(r4, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L44
            r11.a()
            r3 = r5
            goto L51
        L44:
            com.google.android.gms.measurement.internal.zzib r7 = r0.f39180a
            com.google.android.gms.common.util.Clock r7 = r7.f39094k
            long r7 = r7.currentTimeMillis()
            long r3 = r3 - r7
            long r3 = java.lang.Math.abs(r3)
        L51:
            long r7 = r11.f39016d
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L59
        L57:
            r11 = r2
            goto L8c
        L59:
            long r7 = r7 + r7
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L62
            r11.a()
            goto L57
        L62:
            java.lang.String r3 = r11.f39015c
            android.content.SharedPreferences r4 = r0.k()
            java.lang.String r3 = r4.getString(r3, r2)
            java.lang.String r4 = r11.f39014b
            android.content.SharedPreferences r0 = r0.k()
            long r7 = r0.getLong(r4, r5)
            r11.a()
            if (r3 == 0) goto L8a
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 > 0) goto L80
            goto L8a
        L80:
            android.util.Pair r11 = new android.util.Pair
            java.lang.Long r0 = java.lang.Long.valueOf(r7)
            r11.<init>(r3, r0)
            goto L8c
        L8a:
            android.util.Pair r11 = com.google.android.gms.measurement.internal.zzhg.z
        L8c:
            if (r11 == 0) goto Lb7
            android.util.Pair r0 = com.google.android.gms.measurement.internal.zzhg.z
            if (r11 != r0) goto L93
            goto Lb7
        L93:
            java.lang.Object r0 = r11.second
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object r11 = r11.first
            java.lang.String r11 = (java.lang.String) r11
            int r2 = r0.length()
            java.lang.String r3 = java.lang.String.valueOf(r11)
            int r2 = r2 + 1
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r2 = r2 + r3
            r4.<init>(r2)
            java.lang.String r2 = ":"
            java.lang.String r2 = android.support.v4.media.b.s(r4, r0, r2, r11)
        Lb7:
            com.google.android.gms.measurement.internal.zzr r11 = r1.k(r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznk.w(boolean):com.google.android.gms.measurement.internal.zzr");
    }

    public final boolean x() {
        g();
        h();
        return this.f39485d != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x02b4 A[Catch: all -> 0x01e0, SQLiteException -> 0x0290, SQLiteDatabaseLockedException -> 0x0295, SQLiteFullException -> 0x0299, TryCatch #39 {all -> 0x01e0, blocks: (B:95:0x01b9, B:99:0x01cf, B:101:0x01d4, B:114:0x01f4, B:115:0x01f8, B:116:0x01fb, B:119:0x0203, B:121:0x0217, B:128:0x022d, B:129:0x0236, B:130:0x0239, B:126:0x0227, B:133:0x023d, B:135:0x0251, B:142:0x0267, B:143:0x0271, B:144:0x0274, B:140:0x0261, B:147:0x0278, B:151:0x028c, B:166:0x02b4, B:167:0x02be, B:168:0x02c1, B:164:0x02ae, B:176:0x02ce, B:177:0x02d9, B:198:0x0345), top: B:363:0x01b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03ec A[Catch: all -> 0x0371, TRY_ENTER, TryCatch #48 {all -> 0x0371, blocks: (B:249:0x0418, B:239:0x03ec, B:241:0x03f2, B:242:0x03f5, B:257:0x0436, B:200:0x035c, B:202:0x0366, B:209:0x0379), top: B:370:0x0418 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0424 A[PHI: r8 r13 r23 r24 r25 r34 r35
      0x0424: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:245:0x0407, B:260:0x0448, B:253:0x0422] A[DONT_GENERATE, DONT_INLINE]
      0x0424: PHI (r13v13 android.database.sqlite.SQLiteDatabase) = 
      (r13v10 android.database.sqlite.SQLiteDatabase)
      (r13v11 android.database.sqlite.SQLiteDatabase)
      (r13v14 android.database.sqlite.SQLiteDatabase)
     binds: [B:245:0x0407, B:260:0x0448, B:253:0x0422] A[DONT_GENERATE, DONT_INLINE]
      0x0424: PHI (r23v9 java.lang.String) = (r23v6 java.lang.String), (r23v7 java.lang.String), (r23v10 java.lang.String) binds: [B:245:0x0407, B:260:0x0448, B:253:0x0422] A[DONT_GENERATE, DONT_INLINE]
      0x0424: PHI (r24v9 java.lang.String) = (r24v6 java.lang.String), (r24v7 java.lang.String), (r24v10 java.lang.String) binds: [B:245:0x0407, B:260:0x0448, B:253:0x0422] A[DONT_GENERATE, DONT_INLINE]
      0x0424: PHI (r25v11 com.google.android.gms.measurement.internal.zzib) = 
      (r25v8 com.google.android.gms.measurement.internal.zzib)
      (r25v9 com.google.android.gms.measurement.internal.zzib)
      (r25v12 com.google.android.gms.measurement.internal.zzib)
     binds: [B:245:0x0407, B:260:0x0448, B:253:0x0422] A[DONT_GENERATE, DONT_INLINE]
      0x0424: PHI (r34v9 int) = (r34v6 int), (r34v7 int), (r34v10 int) binds: [B:245:0x0407, B:260:0x0448, B:253:0x0422] A[DONT_GENERATE, DONT_INLINE]
      0x0424: PHI (r35v9 java.lang.String) = (r35v6 java.lang.String), (r35v7 java.lang.String), (r35v10 java.lang.String) binds: [B:245:0x0407, B:260:0x0448, B:253:0x0422] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x044b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x044b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x044b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(com.google.android.gms.measurement.internal.zzga r64, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r65, com.google.android.gms.measurement.internal.zzr r66) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznk.y(com.google.android.gms.measurement.internal.zzga, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzr):void");
    }

    public final void z(zzah zzahVar) {
        boolean zN;
        Preconditions.checkNotNull(zzahVar);
        g();
        h();
        zzib zzibVar = this.f39180a;
        zzibVar.getClass();
        zzgk zzgkVarN = zzibVar.n();
        zzib zzibVar2 = zzgkVarN.f39180a;
        zzib.j(zzibVar2.f39092i);
        byte[] bArrJ = zzpo.J(zzahVar);
        if (bArrJ.length > 131072) {
            zzgt zzgtVar = zzibVar2.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38959g.a("Conditional user property too long for local database. Sending directly to service");
            zN = false;
        } else {
            zN = zzgkVarN.n(2, bArrJ);
        }
        u(new zzmt(this, w(true), zN, new zzah(zzahVar)));
    }
}
