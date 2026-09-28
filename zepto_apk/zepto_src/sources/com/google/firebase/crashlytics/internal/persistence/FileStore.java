package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.ProcessDetailsProvider;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class FileStore {

    /* renamed from: a, reason: collision with root package name */
    public final String f44384a;

    /* renamed from: b, reason: collision with root package name */
    public final File f44385b;

    /* renamed from: c, reason: collision with root package name */
    public final File f44386c;

    /* renamed from: d, reason: collision with root package name */
    public final File f44387d;

    /* renamed from: e, reason: collision with root package name */
    public final File f44388e;

    /* renamed from: f, reason: collision with root package name */
    public final File f44389f;

    /* renamed from: g, reason: collision with root package name */
    public final File f44390g;

    public FileStore(Context context) {
        String string;
        String strD = ProcessDetailsProvider.f43706a.c(context).d();
        this.f44384a = strD;
        File filesDir = context.getFilesDir();
        this.f44385b = filesDir;
        if (strD.isEmpty()) {
            string = ".com.google.firebase.crashlytics.files.v1";
        } else {
            StringBuilder sb = new StringBuilder(".crashlytics.v3");
            sb.append(File.separator);
            sb.append(strD.length() > 40 ? CommonUtils.i(strD) : strD.replaceAll("[^a-zA-Z0-9.]", Attributes.PREDEFINED_ATTRIBUTE_PREFIX));
            string = sb.toString();
        }
        File file = new File(filesDir, string);
        d(file);
        this.f44386c = file;
        File file2 = new File(file, "open-sessions");
        d(file2);
        this.f44387d = file2;
        File file3 = new File(file, "reports");
        d(file3);
        this.f44388e = file3;
        File file4 = new File(file, "priority-reports");
        d(file4);
        this.f44389f = file4;
        File file5 = new File(file, "native-reports");
        d(file5);
        this.f44390g = file5;
    }

    public static synchronized void d(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return;
                }
                Logger.f43705a.b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.", null);
                file.delete();
            }
            if (!file.mkdirs()) {
                Logger.f43705a.c("Could not create Crashlytics-specific directory: " + file, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean e(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                e(file2);
            }
        }
        return file.delete();
    }

    public static List f(Object[] objArr) {
        return objArr == null ? Collections.EMPTY_LIST : Arrays.asList(objArr);
    }

    public final void a(String str) {
        File file = new File(this.f44385b, str);
        if (file.exists() && e(file)) {
            Logger.f43705a.b("Deleted previous Crashlytics file system: " + file.getPath(), null);
        }
    }

    public final File b(String str) {
        File file = new File(this.f44387d, str);
        file.mkdirs();
        File file2 = new File(file, "native");
        file2.mkdirs();
        return file2;
    }

    public final File c(String str, String str2) {
        File file = new File(this.f44387d, str);
        file.mkdirs();
        return new File(file, str2);
    }
}
