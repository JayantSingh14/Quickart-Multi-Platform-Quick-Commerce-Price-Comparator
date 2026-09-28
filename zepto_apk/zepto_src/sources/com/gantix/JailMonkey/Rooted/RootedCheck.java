package com.gantix.JailMonkey.Rooted;

import com.facebook.react.bridge.ReactApplicationContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;

/* loaded from: classes.dex */
public class RootedCheck {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20489a;

    /* renamed from: b, reason: collision with root package name */
    public final RootBeerResults f20490b;

    public static class RootBeerResults {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f20491a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20492b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f20493c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f20494d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f20495e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f20496f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f20497g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f20498h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f20499i;

        /* JADX WARN: Removed duplicated region for block: B:81:0x01f2  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01f9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public RootBeerResults(com.facebook.react.bridge.ReactApplicationContext r20) {
            /*
                Method dump skipped, instructions count: 559
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.gantix.JailMonkey.Rooted.RootedCheck.RootBeerResults.<init>(com.facebook.react.bridge.ReactApplicationContext):void");
        }
    }

    public RootedCheck(ReactApplicationContext reactApplicationContext) {
        new GreaterThan23();
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= 9) {
                Process processExec = null;
                try {
                    processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
                    if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null) {
                        processExec.destroy();
                    }
                } catch (Throwable unused) {
                    if (processExec != null) {
                    }
                }
                processExec.destroy();
            } else if (new File(strArr[i2]).exists()) {
                break;
            } else {
                i2++;
            }
        }
        z = true;
        this.f20489a = z;
        this.f20490b = new RootBeerResults(reactApplicationContext);
    }

    public final HashMap a() {
        HashMap map = new HashMap();
        map.put("jailMonkey", Boolean.valueOf(this.f20489a));
        RootBeerResults rootBeerResults = this.f20490b;
        rootBeerResults.getClass();
        HashMap map2 = new HashMap();
        map2.put("detectRootManagementApps", Boolean.valueOf(rootBeerResults.f20491a));
        map2.put("detectPotentiallyDangerousApps", Boolean.valueOf(rootBeerResults.f20492b));
        map2.put("checkForSuBinary", Boolean.valueOf(rootBeerResults.f20493c));
        map2.put("checkForDangerousProps", Boolean.valueOf(rootBeerResults.f20494d));
        map2.put("checkForRWPaths", Boolean.valueOf(rootBeerResults.f20495e));
        map2.put("detectTestKeys", Boolean.valueOf(rootBeerResults.f20496f));
        map2.put("checkSuExists", Boolean.valueOf(rootBeerResults.f20497g));
        map2.put("checkForRootNative", Boolean.valueOf(rootBeerResults.f20498h));
        map2.put("checkForMagiskBinary", Boolean.valueOf(rootBeerResults.f20499i));
        map.put("rootBeer", map2);
        return map;
    }

    public final boolean b() {
        if (this.f20489a) {
            return true;
        }
        RootBeerResults rootBeerResults = this.f20490b;
        return rootBeerResults.f20491a || rootBeerResults.f20492b || rootBeerResults.f20493c || rootBeerResults.f20494d || rootBeerResults.f20495e || rootBeerResults.f20496f || rootBeerResults.f20497g || rootBeerResults.f20498h || rootBeerResults.f20499i;
    }
}
