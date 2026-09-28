package com.facebook.soloader;

import android.os.StrictMode;
import android.support.v4.media.b;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class DirectSplitSoSource extends SoSource {

    /* renamed from: b, reason: collision with root package name */
    public Manifest f20252b = null;

    /* renamed from: c, reason: collision with root package name */
    public HashSet f20253c = null;

    /* renamed from: a, reason: collision with root package name */
    public final String f20251a = "base";

    @Override // com.facebook.soloader.SoSource
    public final String c() {
        return "DirectSplitSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public final int d(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        String strS;
        String str2;
        HashSet hashSet = this.f20253c;
        if (hashSet == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (!hashSet.contains(str)) {
            return 0;
        }
        HashSet hashSet2 = this.f20253c;
        if (hashSet2 == null || this.f20252b == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (hashSet2.contains(str)) {
            StringBuilder sb = new StringBuilder();
            String str3 = this.f20251a;
            if (!"base".equals(str3)) {
                String[] strArr = SoLoader.f20288d.getApplicationInfo().splitSourceDirs;
                if (strArr == null) {
                    throw new IllegalStateException("No splits avaiable");
                }
                String strD = b.D("split_", str3, ".apk");
                for (String str4 : strArr) {
                    if (str4.endsWith(strD)) {
                        str2 = str4;
                    }
                }
                throw new IllegalStateException(b.D("Could not find ", str3, " split"));
            }
            str2 = SoLoader.f20288d.getApplicationInfo().sourceDir;
            sb.append(str2);
            sb.append("!/lib/");
            strS = b.s(sb, this.f20252b.f20278a, "/", str);
        } else {
            strS = null;
        }
        strS.getClass();
        System.load(strS);
        return 1;
    }

    @Override // com.facebook.soloader.SoSource
    public final void e(int i2) throws IOException {
        InputStream inputStreamOpen = SoLoader.f20288d.getAssets().open(this.f20251a + ".soloader-manifest");
        try {
            this.f20252b = Manifest.a(inputStreamOpen);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            this.f20253c = new HashSet(this.f20252b.f20279b);
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
