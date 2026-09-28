package org.shadow.apache.commons.lang3.builder;

/* loaded from: classes5.dex */
public class ToStringBuilder implements Builder<String> {

    /* renamed from: d, reason: collision with root package name */
    public static volatile ToStringStyle f57731d = ToStringStyle.r;

    /* renamed from: a, reason: collision with root package name */
    public final StringBuffer f57732a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f57733b;

    /* renamed from: c, reason: collision with root package name */
    public final ToStringStyle f57734c;

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        toStringStyle = toStringStyle == null ? f57731d : toStringStyle;
        StringBuffer stringBuffer = new StringBuffer(512);
        this.f57732a = stringBuffer;
        this.f57734c = toStringStyle;
        this.f57733b = obj;
        if (obj == null) {
            toStringStyle.getClass();
            return;
        }
        toStringStyle.b(stringBuffer, obj);
        if (toStringStyle.s()) {
            ToStringStyle.u(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
        stringBuffer.append(toStringStyle.f57739e);
        if (toStringStyle.f57742h) {
            stringBuffer.append(toStringStyle.f57743i);
        }
    }

    public final void a(Object obj, String str) {
        this.f57734c.a(this.f57732a, str, obj);
    }

    public String toString() {
        ToStringStyle toStringStyle = this.f57734c;
        StringBuffer stringBuffer = this.f57732a;
        Object obj = this.f57733b;
        if (obj == null) {
            stringBuffer.append(toStringStyle.q());
        } else {
            toStringStyle.getClass();
            int length = stringBuffer.length();
            int length2 = toStringStyle.f57743i.length();
            if (length > 0 && length2 > 0 && length >= length2) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        stringBuffer.setLength(length - length2);
                        break;
                    }
                    if (stringBuffer.charAt((length - 1) - i2) != toStringStyle.f57743i.charAt((length2 - 1) - i2)) {
                        break;
                    }
                    i2++;
                }
            }
            stringBuffer.append(toStringStyle.f57740f);
            ToStringStyle.v(obj);
        }
        return stringBuffer.toString();
    }
}
