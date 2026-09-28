package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.Context;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import org.xml.sax.helpers.LocatorImpl;

/* loaded from: classes3.dex */
public class Interpreter {

    /* renamed from: j, reason: collision with root package name */
    public static final Vector f13568j = new Vector(0);

    /* renamed from: a, reason: collision with root package name */
    public final SimpleRuleStore f13569a;

    /* renamed from: b, reason: collision with root package name */
    public final InterpretationContext f13570b;

    /* renamed from: d, reason: collision with root package name */
    public final CAI_WithLocatorSupport f13572d;

    /* renamed from: e, reason: collision with root package name */
    public final ElementPath f13573e;

    /* renamed from: f, reason: collision with root package name */
    public LocatorImpl f13574f;

    /* renamed from: i, reason: collision with root package name */
    public ElementPath f13577i = null;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13571c = new ArrayList(3);

    /* renamed from: h, reason: collision with root package name */
    public final Stack f13576h = new Stack();

    /* renamed from: g, reason: collision with root package name */
    public final EventPlayer f13575g = new EventPlayer(this);

    public Interpreter(Context context, SimpleRuleStore simpleRuleStore, ElementPath elementPath) {
        this.f13572d = new CAI_WithLocatorSupport(context, this);
        this.f13569a = simpleRuleStore;
        this.f13570b = new InterpretationContext(context, this);
        this.f13573e = elementPath;
    }
}
