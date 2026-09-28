package ch.qos.logback.core.pattern.color;

/* loaded from: classes3.dex */
public class BoldYellowCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    public final String h(Object obj) {
        return "1;33";
    }
}
