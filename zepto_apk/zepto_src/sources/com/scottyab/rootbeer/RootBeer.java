package com.scottyab.rootbeer;

import android.content.pm.PackageManager;
import android.support.v4.media.b;
import com.facebook.react.bridge.ReactApplicationContext;
import com.scottyab.rootbeer.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class RootBeer {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f46705a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f46706b = true;

    public RootBeer(ReactApplicationContext reactApplicationContext) {
        this.f46705a = reactApplicationContext;
    }

    public static boolean a(String str) {
        boolean z = false;
        for (String str2 : Const.a()) {
            String strK = b.k(str2, str);
            if (new File(str2, str).exists()) {
                QLog.c(strK + " binary detected!");
                z = true;
            }
        }
        return z;
    }

    public final boolean b(ArrayList arrayList) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.f46705a.getPackageManager();
        Iterator it = arrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                packageManager.getPackageInfo(str, 0);
                QLog.a(str + " ROOT management app detected!");
                z = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z;
    }
}
