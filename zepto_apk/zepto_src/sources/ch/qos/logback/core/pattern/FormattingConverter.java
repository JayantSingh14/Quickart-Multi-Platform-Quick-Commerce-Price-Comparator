package ch.qos.logback.core.pattern;

/* loaded from: classes.dex */
public abstract class FormattingConverter<E> extends Converter<E> {

    /* renamed from: b, reason: collision with root package name */
    public FormatInfo f13656b;

    @Override // ch.qos.logback.core.pattern.Converter
    public final void c(StringBuilder sb, Object obj) {
        String strB = b(obj);
        FormatInfo formatInfo = this.f13656b;
        if (formatInfo == null) {
            sb.append(strB);
            return;
        }
        int iB = formatInfo.b();
        int iA = this.f13656b.a();
        if (strB == null) {
            if (iB > 0) {
                SpacePadder.c(iB, sb);
                return;
            }
            return;
        }
        int length = strB.length();
        if (length > iA) {
            if (this.f13656b.d()) {
                sb.append(strB.substring(length - iA));
                return;
            } else {
                sb.append(strB.substring(0, iA));
                return;
            }
        }
        if (length >= iB) {
            sb.append(strB);
        } else if (this.f13656b.c()) {
            SpacePadder.a(sb, iB, strB);
        } else {
            SpacePadder.b(sb, iB, strB);
        }
    }
}
