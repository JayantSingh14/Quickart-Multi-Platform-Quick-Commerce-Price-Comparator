package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.pattern.DynamicConverter;
import ch.qos.logback.core.pattern.FormatInfo;

/* loaded from: classes3.dex */
public class IntegerTokenConverter extends DynamicConverter<Object> implements MonoTypedConverter {
    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null argument forbidden");
        }
        if (!(obj instanceof Integer)) {
            throw new IllegalArgumentException("Cannot convert " + obj + " of type" + obj.getClass().getName());
        }
        String string = Integer.toString(((Integer) obj).intValue());
        FormatInfo formatInfo = this.f13656b;
        if (formatInfo == null) {
            return string;
        }
        int i2 = formatInfo.f13652a;
        StringBuilder sb = new StringBuilder();
        for (int length = string.length(); length < i2; length++) {
            sb.append('0');
        }
        sb.append(string);
        return sb.toString();
    }
}
