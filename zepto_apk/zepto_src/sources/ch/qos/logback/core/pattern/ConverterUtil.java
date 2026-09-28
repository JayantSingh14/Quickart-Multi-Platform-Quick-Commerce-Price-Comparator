package ch.qos.logback.core.pattern;

/* loaded from: classes3.dex */
public class ConverterUtil {
    public static void a(Converter converter) {
        while (converter != null) {
            if (converter instanceof CompositeConverter) {
                CompositeConverter compositeConverter = (CompositeConverter) converter;
                a(compositeConverter.f13647f);
                compositeConverter.start();
            } else if (converter instanceof DynamicConverter) {
                ((DynamicConverter) converter).start();
            }
            converter = converter.f13648a;
        }
    }
}
