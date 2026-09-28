package com.facebook.imagepipeline.nativecode;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.nativeloader.NativeLoader;

@Nullsafe
/* loaded from: classes3.dex */
public class StaticWebpNativeLoader {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f18072a;

    public static synchronized void a() {
        if (!f18072a) {
            NativeLoader.b("static-webp");
            f18072a = true;
        }
    }
}
