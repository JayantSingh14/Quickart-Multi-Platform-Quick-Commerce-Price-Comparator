package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public interface CallAdapter<R, T> {

    public static abstract class Factory {
        public abstract CallAdapter a(Type type, Annotation[] annotationArr);
    }

    Type a();

    Object b(Call call);
}
