package ch.qos.logback.core.pattern;

import android.support.v4.media.b;
import ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.pattern.parser.Node;
import ch.qos.logback.core.pattern.parser.Parser;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.ScanException;
import ch.qos.logback.core.status.ErrorStatus;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class PatternLayoutBase<E> extends LayoutBase<E> {

    /* renamed from: e, reason: collision with root package name */
    public Converter f13658e;

    /* renamed from: f, reason: collision with root package name */
    public String f13659f;

    /* renamed from: g, reason: collision with root package name */
    public EnsureExceptionHandling f13660g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f13661h = new HashMap();

    public abstract HashMap T1();

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public final String Z() {
        return null;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() throws NumberFormatException {
        Map map;
        String str = this.f13659f;
        if (str == null || str.length() == 0) {
            l1("Empty or null pattern.");
            return;
        }
        try {
            Parser parser = new Parser(this.f13659f);
            Context context = this.f13733b;
            if (context != null) {
                parser.V(context);
            }
            Node nodeU1 = parser.U1();
            HashMap map2 = new HashMap();
            HashMap mapT1 = T1();
            if (mapT1 != null) {
                map2.putAll(mapT1);
            }
            Context context2 = this.f13733b;
            if (context2 != null && (map = (Map) context2.n0("PATTERN_RULE_REGISTRY")) != null) {
                map2.putAll(map);
            }
            map2.putAll(this.f13661h);
            Converter converterW1 = parser.W1(nodeU1, map2);
            this.f13658e = converterW1;
            EnsureExceptionHandling ensureExceptionHandling = this.f13660g;
            if (ensureExceptionHandling != null) {
                ensureExceptionHandling.a(this.f13733b, converterW1);
            }
            Context context3 = this.f13733b;
            for (Converter converter = this.f13658e; converter != null; converter = converter.f13648a) {
                if (converter instanceof ContextAware) {
                    ((ContextAware) converter).V(context3);
                }
            }
            ConverterUtil.a(this.f13658e);
            this.f13445d = true;
        } catch (ScanException e2) {
            this.f13733b.D().a(new ErrorStatus(2, b.r(new StringBuilder("Failed to parse pattern \""), this.f13659f, "\"."), this, e2));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("(\"");
        return b.r(sb, this.f13659f, "\")");
    }
}
