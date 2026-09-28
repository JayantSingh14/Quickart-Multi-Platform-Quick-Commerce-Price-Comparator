package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.util.Log;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.internal.zzbs;
import com.google.android.play.core.splitinstall.internal.zzbw;
import com.google.android.play.core.splitinstall.internal.zzbx;
import com.google.android.play.core.splitinstall.internal.zzby;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class FakeSplitInstallManager implements SplitInstallManager {
    public static final long o = TimeUnit.SECONDS.toMillis(1);
    public static final /* synthetic */ int p = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f42010a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f42011b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.play.core.splitinstall.zzs f42012c;

    /* renamed from: d, reason: collision with root package name */
    public final zzby f42013d;

    /* renamed from: e, reason: collision with root package name */
    public final zzbs f42014e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.play.core.splitinstall.internal.zzt f42015f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.play.core.splitinstall.internal.zzt f42016g;

    /* renamed from: h, reason: collision with root package name */
    public final ThreadPoolExecutor f42017h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.play.core.splitinstall.zzo f42018i;

    /* renamed from: j, reason: collision with root package name */
    public final File f42019j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicReference f42020k;

    /* renamed from: l, reason: collision with root package name */
    public final Set f42021l;

    /* renamed from: m, reason: collision with root package name */
    public final Set f42022m;
    public final AtomicBoolean n;

    public FakeSplitInstallManager(Context context, File file, com.google.android.play.core.splitinstall.zzs zzsVar, zzby zzbyVar) {
        ThreadPoolExecutor threadPoolExecutorA = com.google.android.play.core.splitcompat.zzd.a();
        zzbs zzbsVar = new zzbs(context);
        this.f42010a = new Handler(Looper.getMainLooper());
        this.f42020k = new AtomicReference();
        this.f42021l = Collections.synchronizedSet(new HashSet());
        this.f42022m = Collections.synchronizedSet(new HashSet());
        this.n = new AtomicBoolean(false);
        this.f42011b = context;
        this.f42019j = file;
        this.f42012c = zzsVar;
        this.f42013d = zzbyVar;
        this.f42017h = threadPoolExecutorA;
        this.f42014e = zzbsVar;
        this.f42016g = new com.google.android.play.core.splitinstall.internal.zzt();
        this.f42015f = new com.google.android.play.core.splitinstall.internal.zzt();
        this.f42018i = com.google.android.play.core.splitinstall.zzo.f42127a;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task a(SplitInstallRequest splitInstallRequest) {
        int iIndexOf;
        String strM;
        ArrayList arrayList;
        Integer numA;
        int i2;
        File[] fileArr;
        Iterator it;
        final SplitInstallRequest splitInstallRequest2 = splitInstallRequest;
        int i3 = 2;
        try {
            SplitInstallSessionState splitInstallSessionStateG = g(new zzr() { // from class: com.google.android.play.core.splitinstall.testing.zzk
                @Override // com.google.android.play.core.splitinstall.testing.zzr
                public final SplitInstallSessionState a(final SplitInstallSessionState splitInstallSessionState) {
                    final SplitInstallRequest splitInstallRequest3 = splitInstallRequest2;
                    Callable callable = new Callable() { // from class: com.google.android.play.core.splitinstall.testing.zzn
                        @Override // java.util.concurrent.Callable
                        public final Object call() throws SplitInstallException {
                            int iH;
                            int i4 = FakeSplitInstallManager.p;
                            SplitInstallSessionState splitInstallSessionState2 = splitInstallSessionState;
                            if (splitInstallSessionState2 == null || (iH = splitInstallSessionState2.h()) == 0 || iH == 5 || iH == 6 || iH == 7) {
                                return SplitInstallSessionState.b(splitInstallSessionState2 != null ? 1 + splitInstallSessionState2.g() : 1, 1, 0, 0L, 0L, splitInstallRequest3.f41931a, new ArrayList());
                            }
                            throw new SplitInstallException(-1);
                        }
                    };
                    int i4 = zzbx.f41971a;
                    try {
                        return (SplitInstallSessionState) callable.call();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new zzbx("TunnelExceptions should always be unwrapped to deal with the checked exception underneath, this message should never be seen if TunnelException is used properly.", e3);
                    }
                }
            });
            if (splitInstallSessionStateG == null) {
                return e(-100);
            }
            int iG = splitInstallSessionStateG.g();
            final ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = splitInstallRequest2.f41932b;
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((Locale) it2.next()).getLanguage());
            }
            HashSet hashSet = new HashSet();
            final ArrayList arrayList4 = new ArrayList();
            File[] fileArrListFiles = this.f42019j.listFiles(zzl.f42050a);
            if (fileArrListFiles == null) {
                Log.w("FakeSplitInstallManager", "Specified splits directory does not exist.");
                return e(-5);
            }
            int i4 = 0;
            long length = 0;
            while (true) {
                int length2 = fileArrListFiles.length;
                ArrayList arrayList5 = arrayList3;
                arrayList = splitInstallRequest2.f41931a;
                if (i4 >= length2) {
                    break;
                }
                File file = fileArrListFiles[i4];
                String strA = zzbw.a(file);
                String str = strA.split("\\.config\\.", i3)[0];
                hashSet.add(strA);
                if (arrayList.contains(str)) {
                    String str2 = strA.split("\\.config\\.", i3)[0];
                    LocaleList locales = this.f42014e.f41969a.getResources().getConfiguration().getLocales();
                    ArrayList arrayList6 = new ArrayList(locales.size());
                    i2 = iG;
                    int i5 = 0;
                    while (true) {
                        fileArr = fileArrListFiles;
                        if (i5 >= locales.size()) {
                            break;
                        }
                        Locale locale = locales.get(i5);
                        arrayList6.add(String.valueOf(locale.getLanguage()).concat(locale.getCountry().isEmpty() ? "" : Attributes.PREDEFINED_ATTRIBUTE_PREFIX.concat(String.valueOf(locale.getCountry()))));
                        i5++;
                        fileArrListFiles = fileArr;
                    }
                    HashSet hashSet2 = new HashSet(arrayList6);
                    HashMap mapA = f().a(Arrays.asList(str2));
                    HashSet hashSet3 = new HashSet();
                    Iterator it3 = mapA.values().iterator();
                    while (it3.hasNext()) {
                        hashSet3.addAll((Set) it3.next());
                    }
                    HashSet hashSet4 = new HashSet();
                    Iterator it4 = hashSet2.iterator();
                    while (it4.hasNext()) {
                        String str3 = (String) it4.next();
                        if (str3.contains(Attributes.PREDEFINED_ATTRIBUTE_PREFIX)) {
                            it = it4;
                            str3 = str3.split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX, -1)[0];
                        } else {
                            it = it4;
                        }
                        hashSet4.add(str3);
                        it4 = it;
                    }
                    hashSet4.addAll(this.f42022m);
                    hashSet4.addAll(arrayList2);
                    HashSet hashSet5 = new HashSet();
                    for (Map.Entry entry : mapA.entrySet()) {
                        if (hashSet4.contains(entry.getKey())) {
                            hashSet5.addAll((Collection) entry.getValue());
                        }
                    }
                    if (!hashSet3.contains(strA) || hashSet5.contains(strA)) {
                        length = file.length() + length;
                        arrayList4.add(file);
                        break;
                    }
                    i4++;
                    splitInstallRequest2 = splitInstallRequest;
                    arrayList3 = arrayList5;
                    iG = i2;
                    fileArrListFiles = fileArr;
                    i3 = 2;
                } else {
                    i2 = iG;
                    fileArr = fileArrListFiles;
                }
                ArrayList arrayList7 = new ArrayList(this.f42021l);
                arrayList7.addAll(Arrays.asList("", "base"));
                HashMap mapA2 = f().a(arrayList7);
                Iterator it5 = arrayList5.iterator();
                while (it5.hasNext()) {
                    Locale locale2 = (Locale) it5.next();
                    if (mapA2.containsKey(locale2.getLanguage()) && ((Set) mapA2.get(locale2.getLanguage())).contains(strA)) {
                        length = file.length() + length;
                        arrayList4.add(file);
                        break;
                        break;
                    }
                }
                i4++;
                splitInstallRequest2 = splitInstallRequest;
                arrayList3 = arrayList5;
                iG = i2;
                fileArrListFiles = fileArr;
                i3 = 2;
            }
            int i6 = iG;
            Log.i("FakeSplitInstallManager", "availableSplits " + hashSet.toString() + " want " + String.valueOf(arrayList));
            int size = arrayList.size();
            zzby zzbyVar = this.f42013d;
            if (size != 1 || (numA = (Integer) ((zzv) zzbyVar.zza()).b().get(arrayList.get(0))) == null) {
                numA = ((zzv) zzbyVar.zza()).a();
            }
            if (numA != null) {
                return e(numA.intValue());
            }
            if (!hashSet.containsAll(new HashSet(arrayList))) {
                return e(-2);
            }
            Long lValueOf = Long.valueOf(length);
            Integer numValueOf = Integer.valueOf(i6);
            h(1, 0, numValueOf, 0L, lValueOf, arrayList, arrayList2);
            this.f42017h.execute(new Runnable() { // from class: com.google.android.play.core.splitinstall.testing.zzm
                @Override // java.lang.Runnable
                public final void run() {
                    final FakeSplitInstallManager fakeSplitInstallManager = this.f42051a;
                    fakeSplitInstallManager.getClass();
                    final ArrayList arrayList8 = new ArrayList();
                    final ArrayList arrayList9 = new ArrayList();
                    Iterator it6 = arrayList4.iterator();
                    while (it6.hasNext()) {
                        File file2 = (File) it6.next();
                        String strA2 = zzbw.a(file2);
                        Uri uriFromFile = Uri.fromFile(file2);
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(uriFromFile, fakeSplitInstallManager.f42011b.getContentResolver().getType(uriFromFile));
                        intent.addFlags(1);
                        intent.putExtra("module_name", strA2.split("\\.config\\.", 2)[0]);
                        intent.putExtra("split_id", strA2);
                        arrayList8.add(intent);
                        arrayList9.add(zzbw.a(file2).split("\\.config\\.", 2)[0]);
                    }
                    SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) fakeSplitInstallManager.f42020k.get();
                    if (splitInstallSessionState == null) {
                        return;
                    }
                    final long jI = splitInstallSessionState.i();
                    final ArrayList arrayList10 = arrayList2;
                    fakeSplitInstallManager.f42017h.execute(new Runnable() { // from class: com.google.android.play.core.splitinstall.testing.zzi
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i7 = 0;
                            long jMin = 0;
                            while (true) {
                                final FakeSplitInstallManager fakeSplitInstallManager2 = fakeSplitInstallManager;
                                final long j2 = jI;
                                if (i7 >= 3) {
                                    ThreadPoolExecutor threadPoolExecutor = fakeSplitInstallManager2.f42017h;
                                    final ArrayList arrayList11 = arrayList8;
                                    final ArrayList arrayList12 = arrayList9;
                                    final ArrayList arrayList13 = arrayList10;
                                    threadPoolExecutor.execute(new Runnable() { // from class: com.google.android.play.core.splitinstall.testing.zzd
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            FakeSplitInstallManager fakeSplitInstallManager3 = fakeSplitInstallManager2;
                                            if (fakeSplitInstallManager3.n.get()) {
                                                fakeSplitInstallManager3.h(6, -6, null, null, null, null, null);
                                                return;
                                            }
                                            com.google.android.play.core.splitinstall.zzo zzoVar = fakeSplitInstallManager3.f42018i;
                                            com.google.android.play.core.splitinstall.zzh zzhVarA = zzoVar.a();
                                            ArrayList arrayList14 = arrayList12;
                                            ArrayList arrayList15 = arrayList13;
                                            long j3 = j2;
                                            if (zzhVarA != null) {
                                                ArrayList arrayList16 = arrayList11;
                                                zzoVar.a().a(arrayList16, new zzq(fakeSplitInstallManager3, arrayList14, arrayList15, j3, false, arrayList16));
                                            } else {
                                                fakeSplitInstallManager3.f42021l.addAll(arrayList14);
                                                fakeSplitInstallManager3.f42022m.addAll(arrayList15);
                                                Long lValueOf2 = Long.valueOf(j3);
                                                fakeSplitInstallManager3.h(5, 0, null, lValueOf2, lValueOf2, null, null);
                                            }
                                        }
                                    });
                                    return;
                                }
                                fakeSplitInstallManager2.getClass();
                                jMin = Math.min(j2, (j2 / 3) + jMin);
                                fakeSplitInstallManager2.h(2, 0, null, Long.valueOf(jMin), Long.valueOf(j2), null, null);
                                SystemClock.sleep(FakeSplitInstallManager.o);
                                SplitInstallSessionState splitInstallSessionState2 = (SplitInstallSessionState) fakeSplitInstallManager2.f42020k.get();
                                if (splitInstallSessionState2.h() == 9 || splitInstallSessionState2.h() == 7 || splitInstallSessionState2.h() == 6) {
                                    return;
                                } else {
                                    i7++;
                                }
                            }
                        }
                    });
                }
            });
            return Tasks.e(numValueOf);
        } catch (zzbx e2) {
            Class[] clsArr = {SplitInstallException.class};
            for (int i7 = 0; i7 <= 0; i7++) {
                Class cls = clsArr[i7];
                if (RuntimeException.class.isAssignableFrom(cls)) {
                    Object[] objArr = new Object[2];
                    objArr[0] = "getCause";
                    objArr[1] = cls;
                    int i8 = 0;
                    for (int i9 = 2; i8 < i9; i9 = 2) {
                        Object obj = objArr[i8];
                        if (obj == null) {
                            strM = "null";
                        } else {
                            try {
                                strM = obj.toString();
                            } catch (Exception e3) {
                                String strL = b.l(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
                                Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strL), (Throwable) e3);
                                strM = b.m("<", strL, " threw ", e3.getClass().getName(), ">");
                            }
                        }
                        objArr[i8] = strM;
                        i8++;
                    }
                    StringBuilder sb = new StringBuilder(118);
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < 2 && (iIndexOf = "The cause of a TunnelException can never be a RuntimeException, but %s argument was %s".indexOf("%s", i11)) != -1) {
                        sb.append((CharSequence) "The cause of a TunnelException can never be a RuntimeException, but %s argument was %s", i11, iIndexOf);
                        sb.append(objArr[i10]);
                        i11 = iIndexOf + 2;
                        i10++;
                    }
                    sb.append((CharSequence) "The cause of a TunnelException can never be a RuntimeException, but %s argument was %s", i11, 86);
                    if (i10 < 2) {
                        sb.append(" [");
                        sb.append(objArr[i10]);
                        for (int i12 = i10 + 1; i12 < 2; i12++) {
                            sb.append(", ");
                            sb.append(objArr[i12]);
                        }
                        sb.append(']');
                    }
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (SplitInstallException.class.isInstance(e2.getCause())) {
                return e(((SplitInstallException) ((Exception) SplitInstallException.class.cast(e2.getCause()))).a());
            }
            Exception cause = e2.getCause();
            ClassCastException classCastException = new ClassCastException("getCause(" + SplitInstallException.class + ") doesn't match underlying exception");
            classCastException.initCause(cause);
            throw classCastException;
        }
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set b() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f42012c.c());
        hashSet.addAll(this.f42021l);
        return hashSet;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void c(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        com.google.android.play.core.splitinstall.internal.zzt zztVar = this.f42016g;
        synchronized (zztVar) {
            zztVar.f41997a.remove(splitInstallStateUpdatedListener);
        }
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void d(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        com.google.android.play.core.splitinstall.internal.zzt zztVar = this.f42016g;
        synchronized (zztVar) {
            zztVar.f41997a.add(splitInstallStateUpdatedListener);
        }
    }

    public final Task e(final int i2) {
        g(new zzr() { // from class: com.google.android.play.core.splitinstall.testing.zzp
            @Override // com.google.android.play.core.splitinstall.testing.zzr
            public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
                int i3 = FakeSplitInstallManager.p;
                if (splitInstallSessionState == null) {
                    return null;
                }
                return SplitInstallSessionState.b(splitInstallSessionState.g(), 6, i2, splitInstallSessionState.a(), splitInstallSessionState.i(), splitInstallSessionState.e(), splitInstallSessionState.d());
            }
        });
        return Tasks.d(new SplitInstallException(i2));
    }

    public final com.google.android.play.core.splitinstall.zzk f() throws Resources.NotFoundException {
        Context context = this.f42011b;
        try {
            com.google.android.play.core.splitinstall.zzk zzkVarA = this.f42012c.a(context.getPackageManager().getPackageInfo(context.getPackageName(), 128).applicationInfo.metaData);
            if (zzkVarA != null) {
                return zzkVarA;
            }
            throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalStateException("App is not found in PackageManager", e2);
        }
    }

    public final synchronized SplitInstallSessionState g(zzr zzrVar) {
        SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) this.f42020k.get();
        SplitInstallSessionState splitInstallSessionStateA = zzrVar.a(splitInstallSessionState);
        AtomicReference atomicReference = this.f42020k;
        while (!atomicReference.compareAndSet(splitInstallSessionState, splitInstallSessionStateA)) {
            if (atomicReference.get() != splitInstallSessionState && atomicReference.get() != splitInstallSessionState) {
                return null;
            }
        }
        return splitInstallSessionStateA;
    }

    public final boolean h(final int i2, final int i3, final Integer num, final Long l2, final Long l3, final ArrayList arrayList, final ArrayList arrayList2) {
        final SplitInstallSessionState splitInstallSessionStateG = g(new zzr() { // from class: com.google.android.play.core.splitinstall.testing.zzg
            @Override // com.google.android.play.core.splitinstall.testing.zzr
            public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
                int i4 = FakeSplitInstallManager.p;
                if (splitInstallSessionState == null) {
                    splitInstallSessionState = SplitInstallSessionState.b(0, 0, 0, 0L, 0L, new ArrayList(), new ArrayList());
                }
                Integer num2 = num;
                int iG = num2 == null ? splitInstallSessionState.g() : num2.intValue();
                Long l4 = l2;
                long jA = l4 == null ? splitInstallSessionState.a() : l4.longValue();
                Long l5 = l3;
                long jI = l5 == null ? splitInstallSessionState.i() : l5.longValue();
                ArrayList arrayListE = arrayList;
                if (arrayListE == null) {
                    arrayListE = splitInstallSessionState.e();
                }
                ArrayList arrayList3 = arrayListE;
                ArrayList arrayListD = arrayList2;
                if (arrayListD == null) {
                    arrayListD = splitInstallSessionState.d();
                }
                return SplitInstallSessionState.b(iG, i2, i3, jA, jI, arrayList3, arrayListD);
            }
        });
        if (splitInstallSessionStateG == null) {
            return false;
        }
        this.f42010a.post(new Runnable() { // from class: com.google.android.play.core.splitinstall.testing.zzf
            @Override // java.lang.Runnable
            public final void run() {
                FakeSplitInstallManager fakeSplitInstallManager = this.f42035a;
                com.google.android.play.core.splitinstall.internal.zzt zztVar = fakeSplitInstallManager.f42015f;
                SplitInstallSessionState splitInstallSessionState = splitInstallSessionStateG;
                zztVar.a(splitInstallSessionState);
                fakeSplitInstallManager.f42016g.a(splitInstallSessionState);
            }
        });
        return true;
    }
}
