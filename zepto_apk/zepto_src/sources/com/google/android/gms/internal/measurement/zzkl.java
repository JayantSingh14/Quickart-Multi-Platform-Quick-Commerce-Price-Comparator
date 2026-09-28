package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zzkl {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f37031f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static volatile zzjn f37032g;

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicInteger f37033h;

    /* renamed from: a, reason: collision with root package name */
    public final zzkf f37034a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37035b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f37036c;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f37037d = -1;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f37038e;

    static {
        new AtomicReference();
        f37033h = new AtomicInteger();
    }

    public /* synthetic */ zzkl(zzkf zzkfVar, String str, Object obj) {
        if (zzkfVar.f37025a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f37034a = zzkfVar;
        this.f37035b = str;
        this.f37036c = obj;
    }

    public static void b(final Context context) {
        Context context2;
        if (f37032g != null || context == null) {
            return;
        }
        Object obj = f37031f;
        synchronized (obj) {
            try {
                if (f37032g == null) {
                    synchronized (obj) {
                        zzjn zzjnVar = f37032g;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzjnVar == null || zzjnVar.f37000a != context) {
                            if (zzjnVar != null) {
                                zzjq.c();
                                zzkn.a();
                                synchronized (zzjx.class) {
                                    try {
                                        zzjx zzjxVar = zzjx.f37016d;
                                        if (zzjxVar != null && (context2 = zzjxVar.f37017a) != null && zzjxVar.f37018b != null && zzjxVar.f37019c) {
                                            context2.getContentResolver().unregisterContentObserver(zzjx.f37016d.f37018b);
                                        }
                                        zzjx.f37016d = null;
                                    } finally {
                                    }
                                }
                            }
                            f37032g = new zzjn(context, Suppliers.a(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzkk
                                /* JADX WARN: Finally extract failed */
                                /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[Catch: all -> 0x0028, TryCatch #3 {all -> 0x0028, all -> 0x006e, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x001f, B:20:0x003c, B:75:0x0189, B:15:0x002b, B:17:0x0033, B:22:0x0043, B:24:0x0049, B:25:0x004d, B:74:0x0184, B:76:0x018c, B:77:0x018f, B:78:0x0190, B:26:0x0052, B:28:0x0056, B:29:0x0063, B:31:0x0069, B:37:0x0082, B:39:0x0088, B:40:0x0094, B:61:0x0167, B:62:0x016a, B:70:0x0179, B:69:0x0176, B:71:0x017a, B:72:0x017f, B:73:0x0180, B:34:0x0071, B:36:0x0077), top: B:89:0x000d }] */
                                @Override // com.google.common.base.Supplier
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct add '--show-bad-code' argument
                                */
                                public final java.lang.Object get() {
                                    /*
                                        Method dump skipped, instructions count: 405
                                        To view this dump add '--comments-level debug' option
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkk.get():java.lang.Object");
                                }
                            }));
                            f37033h.incrementAndGet();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
    }

    public abstract Object a(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[PHI: r2
      0x005d: PHI (r2v1 com.google.common.base.Optional) = 
      (r2v0 com.google.common.base.Optional)
      (r2v0 com.google.common.base.Optional)
      (r2v4 com.google.common.base.Optional)
      (r2v4 com.google.common.base.Optional)
     binds: [B:8:0x0016, B:10:0x001a, B:12:0x0029, B:18:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001c, B:13:0x002b, B:15:0x0039, B:19:0x004d, B:26:0x0063, B:28:0x006e, B:30:0x0076, B:33:0x0086, B:35:0x0094, B:47:0x00b9, B:50:0x00c1, B:51:0x00c4, B:52:0x00c8, B:39:0x009d, B:41:0x00a1, B:43:0x00af, B:45:0x00b5, B:53:0x00cd, B:54:0x00cf, B:16:0x0046, B:55:0x00d0), top: B:61:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001c, B:13:0x002b, B:15:0x0039, B:19:0x004d, B:26:0x0063, B:28:0x006e, B:30:0x0076, B:33:0x0086, B:35:0x0094, B:47:0x00b9, B:50:0x00c1, B:51:0x00c4, B:52:0x00c8, B:39:0x009d, B:41:0x00a1, B:43:0x00af, B:45:0x00b5, B:53:0x00cd, B:54:0x00cf, B:16:0x0046, B:55:0x00d0), top: B:61:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = com.google.android.gms.internal.measurement.zzkl.f37033h
            int r0 = r0.get()
            int r1 = r9.f37037d
            if (r1 >= r0) goto Ld4
            monitor-enter(r9)
            int r1 = r9.f37037d     // Catch: java.lang.Throwable -> L5a
            if (r1 >= r0) goto Ld0
            com.google.android.gms.internal.measurement.zzjn r1 = com.google.android.gms.internal.measurement.zzkl.f37032g     // Catch: java.lang.Throwable -> L5a
            com.google.common.base.Optional r2 = com.google.common.base.Optional.a()     // Catch: java.lang.Throwable -> L5a
            r3 = 0
            if (r1 == 0) goto L5d
            com.google.common.base.Supplier r4 = r1.f37001b     // Catch: java.lang.Throwable -> L5a
            if (r4 == 0) goto L5d
            r4.getClass()     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r2 = r4.get()     // Catch: java.lang.Throwable -> L5a
            com.google.common.base.Optional r2 = (com.google.common.base.Optional) r2     // Catch: java.lang.Throwable -> L5a
            boolean r4 = r2.c()     // Catch: java.lang.Throwable -> L5a
            if (r4 == 0) goto L5d
            java.lang.Object r4 = r2.b()     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.measurement.zzjs r4 = (com.google.android.gms.internal.measurement.zzjs) r4     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.measurement.zzkf r5 = r9.f37034a     // Catch: java.lang.Throwable -> L5a
            android.net.Uri r5 = r5.f37025a     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = r9.f37035b     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L46
            androidx.collection.SimpleArrayMap r4 = r4.f37013a     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L5a
            androidx.collection.SimpleArrayMap r4 = (androidx.collection.SimpleArrayMap) r4     // Catch: java.lang.Throwable -> L5a
            goto L4a
        L46:
            r4.getClass()     // Catch: java.lang.Throwable -> L5a
            r4 = r3
        L4a:
            if (r4 != 0) goto L4d
            goto L5d
        L4d:
            java.lang.String r5 = ""
            java.lang.String r5 = r5.concat(r6)     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
            r0 = move-exception
            goto Ld2
        L5d:
            r4 = r3
        L5e:
            if (r1 == 0) goto L62
            r5 = 1
            goto L63
        L62:
            r5 = 0
        L63:
            java.lang.String r6 = "Must call PhenotypeFlagInitializer.maybeInit() first"
            com.google.common.base.Preconditions.m(r6, r5)     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.measurement.zzkf r5 = r9.f37034a     // Catch: java.lang.Throwable -> L5a
            android.net.Uri r6 = r5.f37025a     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto Lcd
            android.content.Context r7 = r1.f37000a     // Catch: java.lang.Throwable -> L5a
            boolean r7 = com.google.android.gms.internal.measurement.zzjz.a(r7, r6)     // Catch: java.lang.Throwable -> L5a
            if (r7 == 0) goto L83
            android.content.Context r7 = r1.f37000a     // Catch: java.lang.Throwable -> L5a
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.measurement.zzki r8 = com.google.android.gms.internal.measurement.zzki.f37029a     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.measurement.zzjq r6 = com.google.android.gms.internal.measurement.zzjq.a(r7, r6, r8)     // Catch: java.lang.Throwable -> L5a
            goto L84
        L83:
            r6 = r3
        L84:
            if (r6 == 0) goto L99
            java.lang.String r7 = r9.f37035b     // Catch: java.lang.Throwable -> L5a
            java.util.Map r6 = r6.b()     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L99
            java.lang.Object r6 = r9.a(r6)     // Catch: java.lang.Throwable -> L5a
            goto L9a
        L99:
            r6 = r3
        L9a:
            if (r6 == 0) goto L9d
            goto Lb9
        L9d:
            boolean r5 = r5.f37027c     // Catch: java.lang.Throwable -> L5a
            if (r5 != 0) goto Lb3
            android.content.Context r1 = r1.f37000a     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.measurement.zzjx r1 = com.google.android.gms.internal.measurement.zzjx.a(r1)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = r9.f37035b     // Catch: java.lang.Throwable -> L5a
            java.lang.String r1 = r1.b(r5)     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto Lb3
            java.lang.Object r3 = r9.a(r1)     // Catch: java.lang.Throwable -> L5a
        Lb3:
            if (r3 != 0) goto Lb8
            java.lang.Object r6 = r9.f37036c     // Catch: java.lang.Throwable -> L5a
            goto Lb9
        Lb8:
            r6 = r3
        Lb9:
            boolean r1 = r2.c()     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto Lc8
            if (r4 != 0) goto Lc4
            java.lang.Object r6 = r9.f37036c     // Catch: java.lang.Throwable -> L5a
            goto Lc8
        Lc4:
            java.lang.Object r6 = r9.a(r4)     // Catch: java.lang.Throwable -> L5a
        Lc8:
            r9.f37038e = r6     // Catch: java.lang.Throwable -> L5a
            r9.f37037d = r0     // Catch: java.lang.Throwable -> L5a
            goto Ld0
        Lcd:
            android.content.Context r0 = r1.f37000a     // Catch: java.lang.Throwable -> L5a
            throw r3     // Catch: java.lang.Throwable -> L5a
        Ld0:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L5a
            goto Ld4
        Ld2:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L5a
            throw r0
        Ld4:
            java.lang.Object r0 = r9.f37038e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkl.c():java.lang.Object");
    }
}
