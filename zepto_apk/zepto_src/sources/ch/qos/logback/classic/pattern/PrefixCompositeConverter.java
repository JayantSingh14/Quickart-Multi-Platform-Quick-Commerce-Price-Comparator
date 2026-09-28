package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.CompositeConverter;
import ch.qos.logback.core.pattern.Converter;

/* loaded from: classes3.dex */
public class PrefixCompositeConverter extends CompositeConverter<ILoggingEvent> {
    @Override // ch.qos.logback.core.pattern.CompositeConverter, ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        StringBuilder sb = new StringBuilder();
        for (Converter converter = this.f13647f; converter != null; converter = converter.f13648a) {
            if (converter instanceof MDCConverter) {
                String str = ((MDCConverter) converter).f13316f;
                if (str != null) {
                    sb.append(str);
                    sb.append("=");
                }
            } else if (converter instanceof PropertyConverter) {
                String str2 = ((PropertyConverter) converter).f13319f;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append("=");
                }
            } else {
                String str3 = (String) PatternLayout.f13254j.get(converter.getClass().getName());
                if (str3 != null) {
                    sb.append(str3);
                    sb.append("=");
                }
            }
            sb.append(converter.b(iLoggingEvent));
        }
        return sb.toString();
    }

    @Override // ch.qos.logback.core.pattern.CompositeConverter
    public final String g(Object obj, String str) {
        throw new UnsupportedOperationException();
    }
}
