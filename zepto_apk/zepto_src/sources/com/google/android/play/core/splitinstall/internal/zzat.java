package com.google.android.play.core.splitinstall.internal;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class zzat implements zzan {
    public static void c(ClassLoader classLoader, HashSet hashSet) {
        if (hashSet.isEmpty()) {
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            Log.d("Splitcompat", "Adding native library parent directory: ".concat(String.valueOf(file.getParentFile().getAbsolutePath())));
            hashSet2.add(file.getParentFile());
        }
        zzbi zzbiVarA = zzbk.a(File.class, "nativeLibraryDirectories", new zzbj(classLoader, zzbk.e(classLoader, "pathList"), Object.class).a());
        hashSet2.removeAll(Arrays.asList((File[]) zzbiVarA.a()));
        synchronized (com.google.android.play.core.splitinstall.zzn.class) {
            Log.d("Splitcompat", "Adding directories " + hashSet2.size());
            zzbiVarA.d(hashSet2);
        }
    }

    public static boolean d(ClassLoader classLoader, File file, File file2, boolean z, zzas zzasVar, String str, zzar zzarVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList arrayList = new ArrayList();
        Object objA = new zzbj(classLoader, zzbk.e(classLoader, "pathList"), Object.class).a();
        zzbi zzbiVarA = zzbk.a(Object.class, "dexElements", objA);
        List listAsList = Arrays.asList((Object[]) zzbiVarA.a());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listAsList) {
            arrayList2.add((File) new zzbj(obj, zzbk.e(obj, str), File.class).a());
        }
        if (!arrayList2.contains(file2)) {
            if (!z && !zzarVar.a(objA, file2, file)) {
                Log.w("SplitCompat", "Should be optimized ".concat(String.valueOf(file2.getPath())));
                return false;
            }
            zzbiVarA.c(Arrays.asList(zzasVar.a(objA, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (!arrayList.isEmpty()) {
                zzbh zzbhVar = new zzbh("DexPathList.makeDexElement failed");
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    IOException iOException = (IOException) arrayList.get(i2);
                    Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(zzbhVar, iOException);
                    } catch (Exception unused) {
                    }
                }
                zzbk.a(IOException.class, "dexElementsSuppressedExceptions", objA).c(arrayList);
                throw zzbhVar;
            }
        }
        return true;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return d(classLoader, file, file2, z, new zzap(), "zip", new zzaq());
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final void b(ClassLoader classLoader, HashSet hashSet) {
        c(classLoader, hashSet);
    }
}
