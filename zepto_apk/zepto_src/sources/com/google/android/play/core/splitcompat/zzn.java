package com.google.android.play.core.splitcompat;

import android.os.Build;
import android.util.Log;
import androidx.fragment.app.e;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class zzn {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f41924b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* renamed from: a, reason: collision with root package name */
    public final zze f41925a;

    public zzn(zze zzeVar) {
        this.f41925a = zzeVar;
    }

    public static void b(zzt zztVar, zzk zzkVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(zztVar.a());
        } catch (IOException e2) {
            e = e2;
            zipFile = null;
        }
        try {
            String strB = zztVar.b();
            HashMap map = new HashMap();
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                Matcher matcher = f41924b.matcher(zipEntryNextElement.getName());
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    Log.d("SplitCompat", "NativeLibraryExtractor: split '" + strB + "' has native library '" + strGroup2 + "' for ABI '" + strGroup + "'");
                    Set hashSet = (Set) map.get(strGroup);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map.put(strGroup, hashSet);
                    }
                    hashSet.add(new zzm(zipEntryNextElement, strGroup2));
                }
            }
            HashMap map2 = new HashMap();
            for (String str : Build.SUPPORTED_ABIS) {
                if (map.containsKey(str)) {
                    Log.d("SplitCompat", "NativeLibraryExtractor: there are native libraries for supported ABI " + str + "; will use this ABI");
                    for (zzm zzmVar : (Set) map.get(str)) {
                        boolean zContainsKey = map2.containsKey(zzmVar.f41922a);
                        String str2 = zzmVar.f41922a;
                        if (zContainsKey) {
                            Log.d("SplitCompat", "NativeLibraryExtractor: skipping library " + str2 + " for ABI " + str + "; already present for a better ABI");
                        } else {
                            map2.put(str2, zzmVar);
                            Log.d("SplitCompat", "NativeLibraryExtractor: using library " + str2 + " for ABI " + str);
                        }
                    }
                } else {
                    Log.d("SplitCompat", "NativeLibraryExtractor: there are no native libraries for supported ABI " + str);
                }
            }
            zzkVar.a(zipFile, new HashSet(map2.values()));
            zipFile.close();
        } catch (IOException e3) {
            e = e3;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e4) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(e, e4);
                }
            }
            throw e;
        }
    }

    public final HashSet a() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        zze zzeVar = this.f41925a;
        HashSet hashSetA = zzeVar.a();
        ArrayList arrayList = new ArrayList();
        File file = new File(zzeVar.g(), "native-libraries");
        zze.e(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Iterator it2 = hashSetA.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    Log.i("SplitCompat", "NativeLibraryExtractor: extracted split '" + str + "' has no corresponding split; deleting");
                    File file3 = new File(zzeVar.g(), "native-libraries");
                    zze.e(file3);
                    File fileD = zze.d(file3, str);
                    zze.e(fileD);
                    zze.c(fileD);
                    break;
                }
                if (((zzt) it2.next()).b().equals(str)) {
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it3 = hashSetA.iterator();
        while (it3.hasNext()) {
            zzt zztVar = (zzt) it3.next();
            HashSet hashSet2 = new HashSet();
            b(zztVar, new zzi(this, hashSet2, zztVar));
            String strB = zztVar.b();
            HashSet hashSet3 = new HashSet();
            File file4 = new File(zzeVar.g(), "native-libraries");
            zze.e(file4);
            File fileD2 = zze.d(file4, strB);
            zze.e(fileD2);
            File[] fileArrListFiles2 = fileD2.listFiles();
            if (fileArrListFiles2 != null) {
                for (File file5 : fileArrListFiles2) {
                    if (file5.isFile()) {
                        hashSet3.add(file5);
                    }
                }
            }
            Iterator it4 = hashSet3.iterator();
            while (it4.hasNext()) {
                File file6 = (File) it4.next();
                if (!hashSet2.contains(file6)) {
                    String absolutePath = file6.getAbsolutePath();
                    String strB2 = zztVar.b();
                    String absolutePath2 = zztVar.a().getAbsolutePath();
                    StringBuilder sbV = e.v("NativeLibraryExtractor: file '", absolutePath, "' found in split '", strB2, "' that is not in the split file '");
                    sbV.append(absolutePath2);
                    sbV.append("'; removing");
                    Log.i("SplitCompat", sbV.toString());
                    File parentFile = file6.getParentFile().getParentFile();
                    File file7 = new File(zzeVar.g(), "native-libraries");
                    zze.e(file7);
                    if (!parentFile.equals(file7)) {
                        throw new IllegalStateException("File to remove is not a native library");
                    }
                    zze.c(file6);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    public final void c(zzt zztVar, HashSet hashSet, zzl zzlVar) throws IOException {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            zzm zzmVar = (zzm) it.next();
            String strB = zztVar.b();
            String str = zzmVar.f41922a;
            zze zzeVar = this.f41925a;
            zzeVar.getClass();
            File file = new File(zzeVar.g(), "native-libraries");
            zze.e(file);
            File fileD = zze.d(file, strB);
            zze.e(fileD);
            File fileD2 = zze.d(fileD, str);
            boolean z = false;
            if (fileD2.exists() && fileD2.length() == zzmVar.f41923b.getSize() && !fileD2.canWrite()) {
                z = true;
            }
            zzlVar.a(zzmVar, fileD2, z);
        }
    }
}
