package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: classes3.dex */
public final class MemorySizeCalculator {

    /* renamed from: a, reason: collision with root package name */
    public final int f16100a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16101b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16102c;

    public static final class Builder {

        /* renamed from: e, reason: collision with root package name */
        public static final int f16103e;

        /* renamed from: a, reason: collision with root package name */
        public final Context f16104a;

        /* renamed from: b, reason: collision with root package name */
        public final ActivityManager f16105b;

        /* renamed from: c, reason: collision with root package name */
        public final DisplayMetricsScreenDimensions f16106c;

        /* renamed from: d, reason: collision with root package name */
        public final float f16107d;

        static {
            f16103e = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Builder(Context context) {
            this.f16107d = f16103e;
            this.f16104a = context;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            this.f16105b = activityManager;
            this.f16106c = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !activityManager.isLowRamDevice()) {
                return;
            }
            this.f16107d = 0.0f;
        }
    }

    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {

        /* renamed from: a, reason: collision with root package name */
        public final DisplayMetrics f16108a;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.f16108a = displayMetrics;
        }
    }

    public interface ScreenDimensions {
    }

    public MemorySizeCalculator(Builder builder) {
        Context context = builder.f16104a;
        ActivityManager activityManager = builder.f16105b;
        int i2 = activityManager.isLowRamDevice() ? 2097152 : 4194304;
        this.f16102c = i2;
        int iRound = Math.round(activityManager.getMemoryClass() * 1048576 * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = builder.f16106c.f16108a;
        float f2 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        float f3 = builder.f16107d;
        int iRound2 = Math.round(f2 * f3);
        int iRound3 = Math.round(f2 * 2.0f);
        int i3 = iRound - i2;
        int i4 = iRound3 + iRound2;
        if (i4 <= i3) {
            this.f16101b = iRound3;
            this.f16100a = iRound2;
        } else {
            float f4 = i3 / (f3 + 2.0f);
            this.f16101b = Math.round(2.0f * f4);
            this.f16100a = Math.round(f4 * f3);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            sb.append(Formatter.formatFileSize(context, this.f16101b));
            sb.append(", pool size: ");
            sb.append(Formatter.formatFileSize(context, this.f16100a));
            sb.append(", byte array size: ");
            sb.append(Formatter.formatFileSize(context, i2));
            sb.append(", memory class limited? ");
            sb.append(i4 > iRound);
            sb.append(", max size: ");
            sb.append(Formatter.formatFileSize(context, iRound));
            sb.append(", memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(activityManager.isLowRamDevice());
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }
}
