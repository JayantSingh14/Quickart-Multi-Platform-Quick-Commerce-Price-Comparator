package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public class Compressor extends ContextAwareBase {

    /* renamed from: ch.qos.logback.core.rolling.helper.Compressor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13723a;

        static {
            int[] iArr = new int[CompressionMode.values().length];
            f13723a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13723a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13723a[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class CompressionRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public final String toString() {
        return getClass().getName();
    }
}
