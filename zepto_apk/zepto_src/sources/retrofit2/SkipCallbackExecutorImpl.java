package retrofit2;

import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {

    /* renamed from: b, reason: collision with root package name */
    public static final SkipCallbackExecutor f58240b = new SkipCallbackExecutorImpl();

    public static Annotation[] a(Annotation[] annotationArr) {
        if (Utils.h(annotationArr, SkipCallbackExecutor.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = f58240b;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@" + SkipCallbackExecutor.class.getName() + "()";
    }
}
