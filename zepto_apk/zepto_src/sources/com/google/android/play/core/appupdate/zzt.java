package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
final class zzt {

    /* renamed from: a, reason: collision with root package name */
    public final Context f41744a;

    public zzt(Context context) {
        this.f41744a = context;
    }

    public static long a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        long jA = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                jA += a(file2);
            }
        }
        return jA;
    }
}
