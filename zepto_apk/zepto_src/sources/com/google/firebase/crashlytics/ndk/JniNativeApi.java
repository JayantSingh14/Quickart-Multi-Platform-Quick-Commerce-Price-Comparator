package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
class JniNativeApi implements NativeApi {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f44471b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f44472c = new c();

    /* renamed from: a, reason: collision with root package name */
    public final Context f44473a;

    static {
        boolean z;
        try {
            System.loadLibrary("crashlytics");
            z = true;
        } catch (UnsatisfiedLinkError e2) {
            Logger.f43705a.c("libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n" + e2.getLocalizedMessage(), null);
            z = false;
        }
        f44471b = z;
    }

    public JniNativeApi(Context context) {
        this.f44473a = context;
    }

    public static void a(ArrayList arrayList, PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            Collections.addAll(arrayList, strArr);
        }
        File file = new File(applicationInfo.dataDir, android.support.v4.media.b.D("files/splitcompat/", Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode), "/verified-splits"));
        boolean zExists = file.exists();
        Logger logger = Logger.f43705a;
        if (!zExists) {
            logger.b("No dynamic features found at " + file.getAbsolutePath(), null);
            return;
        }
        File[] fileArrListFiles = file.listFiles(f44472c);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        logger.b("Found " + fileArrListFiles.length + " APKs in " + file.getAbsolutePath(), null);
        for (File file2 : fileArrListFiles) {
            logger.b("Adding " + file2.getName() + " to classpath.", null);
            arrayList.add(file2.getAbsolutePath());
        }
    }

    private native boolean nativeInit(String[] strArr, Object obj);

    public final boolean b(AssetManager assetManager, String str) throws PackageManager.NameNotFoundException {
        String str2 = Build.CPU_ABI;
        Context context = this.f44473a;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 9216);
            ArrayList arrayList = new ArrayList(10);
            arrayList.add(packageInfo.applicationInfo.sourceDir);
            a(arrayList, packageInfo);
            String[] strArr = packageInfo.applicationInfo.sharedLibraryFiles;
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            ArrayList arrayList2 = new ArrayList(10);
            File parentFile = new File(packageInfo.applicationInfo.nativeLibraryDir).getParentFile();
            if (parentFile != null) {
                arrayList2.add(new File(parentFile, str2).getPath());
                if (str2.startsWith("arm64")) {
                    arrayList2.add(new File(parentFile, "arm64").getPath());
                } else if (str2.startsWith("arm")) {
                    arrayList2.add(new File(parentFile, "arm").getPath());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (str3.endsWith(".apk")) {
                    arrayList2.add(str3 + "!/lib/" + str2);
                }
            }
            arrayList2.add(System.getProperty("java.library.path"));
            arrayList2.add(packageInfo.applicationInfo.nativeLibraryDir);
            String str4 = File.pathSeparator;
            String[] strArr2 = {TextUtils.join(str4, arrayList), TextUtils.join(str4, arrayList2)};
            return f44471b && nativeInit(new String[]{strArr2[0], strArr2[1], str}, assetManager);
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.f43705a.c("Unable to compose package paths", e2);
            throw new RuntimeException(e2);
        }
    }
}
