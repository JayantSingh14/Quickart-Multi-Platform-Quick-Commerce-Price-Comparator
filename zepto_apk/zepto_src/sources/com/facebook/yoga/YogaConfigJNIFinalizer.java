package com.facebook.yoga;

/* loaded from: classes.dex */
public class YogaConfigJNIFinalizer extends YogaConfigJNIBase {
    public YogaConfigJNIFinalizer() {
        long jJni_YGConfigNewJNI = YogaNative.jni_YGConfigNewJNI();
        if (jJni_YGConfigNewJNI == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.f20341a = jJni_YGConfigNewJNI;
    }

    public final void finalize() throws Throwable {
        try {
            long j2 = this.f20341a;
            if (j2 != 0) {
                this.f20341a = 0L;
                YogaNative.jni_YGConfigFreeJNI(j2);
            }
        } finally {
            super.finalize();
        }
    }
}
