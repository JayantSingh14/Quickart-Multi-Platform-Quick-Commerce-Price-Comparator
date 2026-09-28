package ch.qos.logback.core.pattern;

/* loaded from: classes3.dex */
public final class LiteralConverter<E> extends Converter<E> {

    /* renamed from: b, reason: collision with root package name */
    public final String f13657b;

    public LiteralConverter(String str) {
        this.f13657b = str;
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        return this.f13657b;
    }
}
