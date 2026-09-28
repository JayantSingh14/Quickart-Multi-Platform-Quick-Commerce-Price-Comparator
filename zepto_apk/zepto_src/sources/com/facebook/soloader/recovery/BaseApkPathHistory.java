package com.facebook.soloader.recovery;

import android.util.Log;
import java.io.File;
import javax.annotation.concurrent.ThreadSafe;
import org.apache.commons.lang3.StringUtils;

@ThreadSafe
/* loaded from: classes.dex */
public class BaseApkPathHistory {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f20310a = new String[5];

    /* renamed from: b, reason: collision with root package name */
    public int f20311b = 0;

    public final synchronized boolean a(String str) {
        for (String str2 : this.f20310a) {
            if (str.equals(str2)) {
                return false;
            }
        }
        StringBuilder sb = new StringBuilder("Recording new base apk path: ");
        sb.append(str);
        sb.append(StringUtils.LF);
        b(sb);
        Log.w("SoLoader", sb.toString());
        String[] strArr = this.f20310a;
        int i2 = this.f20311b;
        strArr[i2 % strArr.length] = str;
        this.f20311b = i2 + 1;
        return true;
    }

    public final synchronized void b(StringBuilder sb) {
        try {
            sb.append("Previously recorded ");
            sb.append(this.f20311b);
            sb.append(" base apk paths.");
            if (this.f20311b > 0) {
                sb.append(" Most recent ones:");
            }
            int i2 = 0;
            while (true) {
                String[] strArr = this.f20310a;
                if (i2 < strArr.length) {
                    int i3 = (this.f20311b - i2) - 1;
                    if (i3 >= 0) {
                        String str = strArr[i3 % strArr.length];
                        sb.append(StringUtils.LF);
                        sb.append(str);
                        sb.append(" (");
                        sb.append(new File(str).exists() ? "exists" : "does not exist");
                        sb.append(")");
                    }
                    i2++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
