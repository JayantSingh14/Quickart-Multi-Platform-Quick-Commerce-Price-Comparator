package ch.qos.logback.core.pattern;

import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class ReplacingCompositeConverter<E> extends CompositeConverter<E> {

    /* renamed from: g, reason: collision with root package name */
    public Pattern f13662g;

    /* renamed from: h, reason: collision with root package name */
    public String f13663h;

    @Override // ch.qos.logback.core.pattern.CompositeConverter
    public final String g(Object obj, String str) {
        return !this.f13651e ? str : this.f13662g.matcher(str).replaceAll(this.f13663h);
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        List list = this.f13650d;
        if (list == null) {
            d("at least two options are expected whereas you have declared none");
            return;
        }
        int size = list.size();
        if (size >= 2) {
            this.f13662g = Pattern.compile((String) list.get(0));
            this.f13663h = (String) list.get(1);
            this.f13651e = true;
        } else {
            d("at least two options are expected whereas you have declared only " + size + "as [" + list + "]");
        }
    }
}
