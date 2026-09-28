package ch.qos.logback.core.pattern.color;

import ch.qos.logback.core.pattern.CompositeConverter;

/* loaded from: classes3.dex */
public abstract class ForegroundCompositeConverterBase<E> extends CompositeConverter<E> {
    @Override // ch.qos.logback.core.pattern.CompositeConverter
    public final String g(Object obj, String str) {
        return "\u001b[" + h(obj) + "m" + str + "\u001b[0;39m";
    }

    public abstract String h(Object obj);
}
