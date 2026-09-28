package com.brentvatne.common.toolbox;

import android.util.Log;
import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DebugLog {

    /* renamed from: a, reason: collision with root package name */
    public static int f15509a = 5;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f15510b = true;

    public static final void a(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (f15509a <= 3) {
            Log.d("RNV".concat(tag), c(msg));
        }
    }

    public static final void b(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (f15509a <= 6) {
            Log.e("RNV".concat(tag), c(msg));
        }
    }

    public static final String c(String str) {
        return f15510b ? e.p("[", Thread.currentThread().getName(), "] ", str) : str;
    }

    public static final void d(int i2, boolean z) {
        f15509a = i2;
        f15510b = z;
    }

    public static final void e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (f15509a <= 5) {
            Log.w("RNV".concat(tag), c(msg));
        }
    }
}
