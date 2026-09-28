package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public interface Converter<F, T> {

    public static abstract class Factory {
        public Converter a(Type type) {
            return null;
        }

        public Converter b(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    Object a(Object obj);
}
