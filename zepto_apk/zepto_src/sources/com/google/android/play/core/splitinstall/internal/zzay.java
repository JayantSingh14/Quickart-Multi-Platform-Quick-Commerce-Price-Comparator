package com.google.android.play.core.splitinstall.internal;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class zzay implements zzan {
    public static void c(ClassLoader classLoader, HashSet hashSet, zzax zzaxVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (hashSet.isEmpty()) {
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            hashSet2.add(((File) it.next()).getParentFile());
        }
        Object objA = new zzbj(classLoader, zzbk.e(classLoader, "pathList"), Object.class).a();
        zzbj zzbjVar = new zzbj(objA, zzbk.e(objA, "nativeLibraryDirectories"), List.class);
        synchronized (com.google.android.play.core.splitinstall.zzn.class) {
            ArrayList arrayList = new ArrayList((Collection) zzbjVar.a());
            hashSet2.removeAll(arrayList);
            arrayList.addAll(hashSet2);
            zzbjVar.b(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Object[] objArrA = zzaxVar.a(objA, new ArrayList(hashSet2), arrayList2);
        if (arrayList2.isEmpty()) {
            synchronized (com.google.android.play.core.splitinstall.zzn.class) {
                zzbk.a(Object.class, "nativeLibraryPathElements", objA).d(Arrays.asList(objArrA));
            }
            return;
        }
        zzbh zzbhVar = new zzbh("Error in makePathElements");
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(zzbhVar, (IOException) arrayList2.get(i2));
            } catch (Exception unused) {
            }
        }
        throw zzbhVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzat.d(classLoader, file, file2, z, new zzav(), "zip", new zzaq());
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final void b(ClassLoader classLoader, HashSet hashSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        c(classLoader, hashSet, new zzaw());
    }
}
