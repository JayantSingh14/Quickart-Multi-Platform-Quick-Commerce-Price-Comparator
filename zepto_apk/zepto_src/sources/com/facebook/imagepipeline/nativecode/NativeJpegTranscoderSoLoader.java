package com.facebook.imagepipeline.nativecode;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.nativeloader.NativeLoader;

@Nullsafe
/* loaded from: classes3.dex */
public class NativeJpegTranscoderSoLoader {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f18071a;

    public static synchronized void a() {
        if (!f18071a) {
            NativeLoader.b("native-imagetranscoder");
            f18071a = true;
        }
    }
}
