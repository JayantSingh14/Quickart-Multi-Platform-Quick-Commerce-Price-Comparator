package ch.qos.logback.core.pattern;

/* loaded from: classes.dex */
public abstract class Converter<E> {

    /* renamed from: a, reason: collision with root package name */
    public Converter f13648a;

    public abstract String b(Object obj);

    public void c(StringBuilder sb, Object obj) {
        sb.append(b(obj));
    }
}
