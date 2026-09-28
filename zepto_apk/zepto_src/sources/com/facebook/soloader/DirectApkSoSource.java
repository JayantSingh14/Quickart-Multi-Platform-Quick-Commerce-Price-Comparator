package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.SysUtil;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes.dex */
public class DirectApkSoSource extends SoSource implements RecoverableSoSource {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f20248a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f20249b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f20250c;

    public DirectApkSoSource(Context context) {
        HashSet hashSet = new HashSet();
        String strI = i(context.getApplicationInfo().sourceDir);
        if (strI != null) {
            hashSet.add(strI);
        }
        if (context.getApplicationInfo().splitSourceDirs != null) {
            for (String str : context.getApplicationInfo().splitSourceDirs) {
                String strI2 = i(str);
                if (strI2 != null) {
                    hashSet.add(strI2);
                }
            }
        }
        this.f20250c = hashSet;
    }

    public static String i(String str) {
        String[] supportedAbis = SysUtil.MarshmallowSysdeps.getSupportedAbis();
        if (str == null || str.isEmpty()) {
            Log.w("SoLoader", "Cannot compute fallback path, apk path is ".concat(str == null ? "null" : "empty"));
            return null;
        }
        if (supportedAbis == null || supportedAbis.length == 0) {
            Log.w("SoLoader", "Cannot compute fallback path, supportedAbis is ".concat(supportedAbis == null ? "null" : "empty"));
            return null;
        }
        StringBuilder sbX = b.x(str, "!/lib/");
        sbX.append(supportedAbis[0]);
        return sbX.toString();
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public final SoSource b(Context context) {
        DirectApkSoSource directApkSoSource = new DirectApkSoSource(context);
        try {
            directApkSoSource.j();
            return directApkSoSource;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.facebook.soloader.SoSource
    public final String c() {
        return "DirectApkSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public final int d(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.f20286b == null) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
        Iterator it = this.f20250c.iterator();
        while (true) {
            if (!it.hasNext()) {
                return 0;
            }
            String str2 = (String) it.next();
            Set set = (Set) this.f20248a.get(str2);
            if (TextUtils.isEmpty(str2) || set == null || !set.contains(str)) {
                LogUtil.c("SoLoader", str + " not found on " + str2);
            } else {
                Set setH = h(str2, str);
                if (setH == null) {
                    String strSubstring = str2.substring(0, str2.indexOf(33));
                    ZipFile zipFile = new ZipFile(strSubstring);
                    try {
                        String str3 = str2.substring(str2.indexOf(33) + 2) + File.separator + str;
                        ZipEntry entry = zipFile.getEntry(str3);
                        if (entry == null) {
                            Log.e("SoLoader", str3 + " not found in " + strSubstring);
                        } else {
                            ElfZipFileChannel elfZipFileChannel = new ElfZipFileChannel(zipFile, entry);
                            try {
                                for (String str4 : NativeDeps.b(str, elfZipFileChannel)) {
                                    if (!str4.startsWith("/")) {
                                        f(str2, str, str4);
                                    }
                                }
                                elfZipFileChannel.close();
                            } finally {
                            }
                        }
                        zipFile.close();
                        setH = h(str2, str);
                    } catch (Throwable th) {
                        try {
                            zipFile.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (setH != null) {
                    Iterator it2 = setH.iterator();
                    while (it2.hasNext()) {
                        SoLoader.l((String) it2.next(), i2, threadPolicy);
                    }
                }
                try {
                    i2 |= 4;
                    SoLoader.f20286b.a(i2, str2 + File.separator + str);
                    LogUtil.a(str + " found on " + str2);
                    return 1;
                } catch (UnsatisfiedLinkError e2) {
                    Log.w("SoLoader", str + " not found on " + str2 + " flag: " + i2, e2);
                }
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    public final void e(int i2) throws IOException {
        j();
    }

    public final void f(String str, String str2, String str3) {
        synchronized (this.f20249b) {
            try {
                String str4 = str + str2;
                if (!this.f20249b.containsKey(str4)) {
                    this.f20249b.put(str4, new HashSet());
                }
                ((Set) this.f20249b.get(str4)).add(str3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(String str, String str2) {
        synchronized (this.f20248a) {
            try {
                if (!this.f20248a.containsKey(str)) {
                    this.f20248a.put(str, new HashSet());
                }
                ((Set) this.f20248a.get(str)).add(str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Set h(String str, String str2) {
        Set set;
        synchronized (this.f20249b) {
            set = (Set) this.f20249b.get(str + str2);
        }
        return set;
    }

    public final void j() throws IOException {
        int iIndexOf;
        int i2;
        Iterator it = this.f20250c.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String strSubstring = (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(33)) < 0 || (i2 = iIndexOf + 2) >= str.length()) ? null : str.substring(i2);
            if (!TextUtils.isEmpty(strSubstring)) {
                ZipFile zipFile = new ZipFile(str.substring(0, str.indexOf(33)));
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement != null && zipEntryNextElement.getMethod() == 0 && zipEntryNextElement.getName().startsWith(strSubstring) && zipEntryNextElement.getName().endsWith(".so")) {
                            g(str, zipEntryNextElement.getName().substring(strSubstring.length() + 1));
                        }
                    }
                    zipFile.close();
                } catch (Throwable th) {
                    try {
                        zipFile.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    public final String toString() {
        return "DirectApkSoSource[root = " + this.f20250c.toString() + ']';
    }
}
