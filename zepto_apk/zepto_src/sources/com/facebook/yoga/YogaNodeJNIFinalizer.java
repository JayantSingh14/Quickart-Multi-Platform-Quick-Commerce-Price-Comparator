package com.facebook.yoga;

/* loaded from: classes.dex */
public class YogaNodeJNIFinalizer extends YogaNodeJNIBase {
    public final void finalize() throws Throwable {
        try {
            long j2 = this.f20400f;
            if (j2 != 0) {
                this.f20400f = 0L;
                YogaNative.jni_YGNodeFinalizeJNI(j2);
            }
        } finally {
            super.finalize();
        }
    }
}
