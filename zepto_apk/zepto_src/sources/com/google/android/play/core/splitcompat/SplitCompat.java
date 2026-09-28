package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.splitinstall.internal.zzah;
import com.google.android.play.core.splitinstall.internal.zzak;
import com.google.android.play.core.splitinstall.internal.zzam;
import com.google.android.play.core.splitinstall.internal.zzan;
import com.google.android.play.core.splitinstall.internal.zzao;
import com.google.android.play.core.splitinstall.internal.zzbh;
import com.google.android.play.core.splitinstall.internal.zzu;
import com.google.android.play.core.splitinstall.zzbe;
import com.google.android.play.core.splitinstall.zzx;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class SplitCompat {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReference f41899e = new AtomicReference(null);

    /* renamed from: a, reason: collision with root package name */
    public final zze f41900a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbe f41901b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f41902c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public final zza f41903d;

    public SplitCompat(Context context) {
        try {
            zze zzeVar = new zze(context);
            this.f41900a = zzeVar;
            this.f41903d = new zza(zzeVar);
            this.f41901b = new zzbe(context);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new zzbh(e2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(2:55|15)|50|24|(2:27|25)|59|32|(1:34)|35) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        android.util.Log.e("SplitCompat", "Error installing additional splits", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
    
        if (r0 != null) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051 A[Catch: all -> 0x0079, Exception -> 0x007b, LOOP:0: B:25:0x004b->B:27:0x0051, LOOP_END, TryCatch #0 {Exception -> 0x007b, blocks: (B:24:0x0042, B:25:0x004b, B:27:0x0051, B:32:0x007d), top: B:50:0x0042, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[Catch: all -> 0x0035, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:14:0x002a, B:15:0x002e, B:34:0x0082, B:43:0x0095, B:44:0x0098, B:23:0x003b, B:24:0x0042, B:25:0x004b, B:27:0x0051, B:32:0x007d, B:37:0x0087), top: B:52:0x002a, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r8) {
        /*
            java.util.concurrent.atomic.AtomicReference r0 = com.google.android.play.core.splitcompat.SplitCompat.f41899e
            java.lang.Object r0 = r0.get()
            com.google.android.play.core.splitcompat.SplitCompat r0 = (com.google.android.play.core.splitcompat.SplitCompat) r0
            if (r0 != 0) goto L1c
            android.content.Context r0 = r8.getApplicationContext()
            r1 = 0
            if (r0 == 0) goto L18
            android.content.Context r0 = r8.getApplicationContext()
            d(r0, r1)
        L18:
            d(r8, r1)
            return
        L1c:
            com.google.android.play.core.splitcompat.zza r1 = r0.f41903d
            java.util.HashSet r2 = r0.f41902c
            monitor-enter(r2)
            java.util.HashSet r3 = new java.util.HashSet     // Catch: java.lang.Throwable -> L9b
            java.util.HashSet r0 = r0.f41902c     // Catch: java.lang.Throwable -> L9b
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9b
            monitor-enter(r1)
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.getThreadPolicy()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            android.os.StrictMode.allowThreadDiskWrites()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            goto L42
        L35:
            r8 = move-exception
            goto L99
        L37:
            r2 = move-exception
            goto L3b
        L39:
            r2 = move-exception
            r0 = 0
        L3b:
            java.lang.String r4 = "SplitCompat"
            java.lang.String r5 = "Unable to set up strict mode."
            android.util.Log.i(r4, r5, r2)     // Catch: java.lang.Throwable -> L35
        L42:
            java.util.HashSet r2 = new java.util.HashSet     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            r2.<init>()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
        L4b:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            if (r4 == 0) goto L7d
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            com.google.android.play.core.splitcompat.zze r5 = r1.f41904a     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.io.File r5 = r5.g()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.lang.String r7 = "verified-splits"
            r6.<init>(r5, r7)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            com.google.android.play.core.splitcompat.zze.e(r6)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.lang.String r5 = ".apk"
            java.lang.String r4 = r4.concat(r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            java.io.File r4 = com.google.android.play.core.splitcompat.zze.d(r6, r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            r2.add(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            goto L4b
        L79:
            r8 = move-exception
            goto L92
        L7b:
            r8 = move-exception
            goto L87
        L7d:
            r1.a(r8, r2)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7b
            if (r0 == 0) goto L85
        L82:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L35
        L85:
            monitor-exit(r1)
            goto L91
        L87:
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = "Error installing additional splits"
            android.util.Log.e(r2, r3, r8)     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L85
            goto L82
        L91:
            return
        L92:
            if (r0 != 0) goto L95
            goto L98
        L95:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L35
        L98:
            throw r8     // Catch: java.lang.Throwable -> L35
        L99:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L35
            throw r8
        L9b:
            r8 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9b
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.a(android.content.Context):void");
    }

    public static boolean d(final Context context, boolean z) {
        boolean z2;
        AtomicReference atomicReference = f41899e;
        SplitCompat splitCompat = new SplitCompat(context);
        while (true) {
            if (!atomicReference.compareAndSet(null, splitCompat)) {
                if (atomicReference.get() != null && atomicReference.get() != null) {
                    z2 = false;
                    break;
                }
            } else {
                z2 = true;
                break;
            }
        }
        SplitCompat splitCompat2 = (SplitCompat) atomicReference.get();
        if (z2) {
            com.google.android.play.core.splitinstall.zzo zzoVar = com.google.android.play.core.splitinstall.zzo.f42127a;
            ThreadPoolExecutor threadPoolExecutorA = zzd.a();
            zze zzeVar = splitCompat2.f41900a;
            new zzah();
            zzam zzamVar = new zzam(context, zzeVar);
            new zzs();
            com.google.android.play.core.splitinstall.zzo.f42128b.set(new zzak(context, threadPoolExecutorA, zzamVar, splitCompat2.f41900a));
            zzp zzpVar = new zzp(splitCompat2);
            AtomicReference atomicReference2 = com.google.android.play.core.splitinstall.zzr.f42130a;
            while (!atomicReference2.compareAndSet(null, zzpVar) && (atomicReference2.get() == null || atomicReference2.get() == null)) {
            }
            zzd.a().execute(new Runnable() { // from class: com.google.android.play.core.splitcompat.zzo
                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = context;
                    AtomicReference atomicReference3 = SplitCompat.f41899e;
                    try {
                        zzx zzxVarC = zzx.c(context2);
                        synchronized (zzxVarC) {
                            zzxVarC.f41996f = true;
                            zzxVarC.b();
                        }
                    } catch (SecurityException unused) {
                        Log.e("SplitCompat", "Failed to set broadcast receiver to always on.");
                    }
                }
            });
        }
        try {
            splitCompat2.c(context, z);
            return true;
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error installing additional splits", e2);
            return false;
        }
    }

    public final void b(HashSet hashSet) throws IOException {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zze zzeVar = this.f41900a;
            zzeVar.getClass();
            File file = new File(zzeVar.g(), "verified-splits");
            zze.e(file);
            zze.c(zze.d(file, String.valueOf(str).concat(".apk")));
        }
        zzbe zzbeVar = this.f41901b;
        zzbeVar.getClass();
        synchronized (zzbe.class) {
            zzbeVar.f42108a.getSharedPreferences("playcore_split_install_internal", 0).edit().putStringSet("modules_to_uninstall_if_emulated", new HashSet()).apply();
        }
    }

    public final synchronized void c(Context context, boolean z) {
        ZipFile zipFile;
        try {
            if (z) {
                this.f41900a.b();
            } else {
                zzd.a().execute(new zzq(this));
            }
            String packageName = context.getPackageName();
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(packageName, 0).splitNames;
                List<String> arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
                HashSet hashSetA = this.f41900a.a();
                Set setA = this.f41901b.a();
                HashSet hashSet = new HashSet();
                Iterator it = hashSetA.iterator();
                while (it.hasNext()) {
                    String strB = ((zzt) it.next()).b();
                    if (arrayList.contains(strB) || setA.contains(com.google.android.play.core.splitinstall.zzs.b(strB))) {
                        hashSet.add(strB);
                        it.remove();
                    }
                }
                if (z) {
                    b(hashSet);
                } else if (!hashSet.isEmpty()) {
                    zzd.a().execute(new zzr(this, hashSet));
                }
                HashSet hashSet2 = new HashSet();
                Iterator it2 = hashSetA.iterator();
                while (it2.hasNext()) {
                    String strB2 = ((zzt) it2.next()).b();
                    if (!com.google.android.play.core.splitinstall.zzs.d(strB2)) {
                        hashSet2.add(strB2);
                    }
                }
                for (String str : arrayList) {
                    if (!com.google.android.play.core.splitinstall.zzs.d(str)) {
                        hashSet2.add(str);
                    }
                }
                HashSet hashSet3 = new HashSet(hashSetA.size());
                Iterator it3 = hashSetA.iterator();
                while (it3.hasNext()) {
                    zzt zztVar = (zzt) it3.next();
                    String strB3 = zztVar.b();
                    zzu zzuVar = com.google.android.play.core.splitinstall.zzs.f42131c;
                    if (strB3.startsWith("config.") || hashSet2.contains(com.google.android.play.core.splitinstall.zzs.b(zztVar.b()))) {
                        hashSet3.add(zztVar);
                    }
                }
                zzn zznVar = new zzn(this.f41900a);
                zzan zzanVarA = zzao.a();
                ClassLoader classLoader = context.getClassLoader();
                ZipFile zipFile2 = null;
                if (z) {
                    zzanVarA.b(classLoader, zznVar.a());
                } else {
                    Iterator it4 = hashSet3.iterator();
                    while (it4.hasNext()) {
                        zzt zztVar2 = (zzt) it4.next();
                        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                        HashSet hashSet4 = new HashSet();
                        zzn.b(zztVar2, new zzh(zznVar, zztVar2, hashSet4, atomicBoolean));
                        if (!atomicBoolean.get()) {
                            hashSet4 = null;
                        }
                        if (hashSet4 == null) {
                            it4.remove();
                        } else {
                            zzanVarA.b(classLoader, hashSet4);
                        }
                    }
                }
                HashSet hashSet5 = new HashSet();
                Iterator it5 = hashSet3.iterator();
                while (it5.hasNext()) {
                    zzt zztVar3 = (zzt) it5.next();
                    try {
                        zipFile = new ZipFile(zztVar3.a());
                    } catch (IOException e2) {
                        e = e2;
                    }
                    try {
                        ZipEntry entry = zipFile.getEntry("classes.dex");
                        zipFile.close();
                        if (entry != null) {
                            zze zzeVar = this.f41900a;
                            String strB4 = zztVar3.b();
                            zzeVar.getClass();
                            File file = new File(zzeVar.g(), "dex");
                            zze.e(file);
                            File fileD = zze.d(file, strB4);
                            zze.e(fileD);
                            if (!zzanVarA.a(classLoader, fileD, zztVar3.a(), z)) {
                                Log.w("SplitCompat", "split was not installed ".concat(zztVar3.a().toString()));
                            }
                        }
                        hashSet5.add(zztVar3.a());
                    } catch (IOException e3) {
                        e = e3;
                        zipFile2 = zipFile;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException e4) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(e, e4);
                                } catch (Exception unused) {
                                }
                            }
                        }
                        throw e;
                    }
                }
                this.f41903d.a(context, hashSet5);
                HashSet hashSet6 = new HashSet();
                Iterator it6 = hashSet3.iterator();
                while (it6.hasNext()) {
                    zzt zztVar4 = (zzt) it6.next();
                    if (hashSet5.contains(zztVar4.a())) {
                        Log.d("SplitCompat", "Split '" + zztVar4.b() + "' installation emulated");
                        hashSet6.add(zztVar4.b());
                    } else {
                        Log.d("SplitCompat", "Split '" + zztVar4.b() + "' installation not emulated.");
                    }
                }
                synchronized (this.f41902c) {
                    this.f41902c.addAll(hashSet6);
                }
            } catch (PackageManager.NameNotFoundException e5) {
                throw new IOException("Cannot load data for application '" + packageName + "'", e5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
