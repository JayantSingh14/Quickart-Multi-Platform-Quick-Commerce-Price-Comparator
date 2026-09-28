package ch.qos.logback.core.pattern;

/* loaded from: classes3.dex */
public abstract class CompositeConverter<E> extends DynamicConverter<E> {

    /* renamed from: f, reason: collision with root package name */
    public Converter f13647f;

    @Override // ch.qos.logback.core.pattern.Converter
    public String b(Object obj) {
        StringBuilder sb = new StringBuilder();
        for (Converter converter = this.f13647f; converter != null; converter = converter.f13648a) {
            converter.c(sb, obj);
        }
        return g(obj, sb.toString());
    }

    public abstract String g(Object obj, String str);

    public final String toString() {
        StringBuilder sb = new StringBuilder("CompositeConverter<");
        FormatInfo formatInfo = this.f13656b;
        if (formatInfo != null) {
            sb.append(formatInfo);
        }
        if (this.f13647f != null) {
            sb.append(", children: ");
            sb.append(this.f13647f);
        }
        sb.append(">");
        return sb.toString();
    }
}
