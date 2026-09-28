package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import android.util.Log;
import java.io.File;

/* loaded from: classes3.dex */
public final class HardwareConfigState {

    /* renamed from: f, reason: collision with root package name */
    public static final File f16291f = new File("/proc/self/fd");

    /* renamed from: g, reason: collision with root package name */
    public static volatile HardwareConfigState f16292g;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f16293a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16294b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16295c;

    /* renamed from: d, reason: collision with root package name */
    public int f16296d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16297e = true;

    public HardwareConfigState() {
        boolean z = true;
        String str = Build.MODEL;
        if (str != null && str.length() >= 7) {
            String strSubstring = str.substring(0, 7);
            strSubstring.getClass();
            switch (strSubstring) {
                case "SM-A520":
                case "SM-G930":
                case "SM-G935":
                case "SM-G960":
                case "SM-G965":
                case "SM-J720":
                case "SM-N935":
                    if (Build.VERSION.SDK_INT == 26) {
                        z = false;
                        break;
                    }
                    break;
            }
        }
        this.f16293a = z;
        if (Build.VERSION.SDK_INT >= 28) {
            this.f16294b = 20000;
            this.f16295c = 0;
        } else {
            this.f16294b = 700;
            this.f16295c = 128;
        }
    }

    public static HardwareConfigState a() {
        if (f16292g == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (f16292g == null) {
                        f16292g = new HardwareConfigState();
                    }
                } finally {
                }
            }
        }
        return f16292g;
    }

    public final boolean b(int i2, int i3, boolean z, boolean z2) {
        int i4;
        boolean z3;
        if (z && this.f16293a && Build.VERSION.SDK_INT >= 26 && !z2 && i2 >= (i4 = this.f16295c) && i3 >= i4) {
            synchronized (this) {
                try {
                    int i5 = this.f16296d + 1;
                    this.f16296d = i5;
                    if (i5 >= 50) {
                        this.f16296d = 0;
                        int length = f16291f.list().length;
                        boolean z4 = length < this.f16294b;
                        this.f16297e = z4;
                        if (!z4 && Log.isLoggable("Downsampler", 5)) {
                            Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f16294b);
                        }
                    }
                    z3 = this.f16297e;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z3) {
                return true;
            }
        }
        return false;
    }
}
