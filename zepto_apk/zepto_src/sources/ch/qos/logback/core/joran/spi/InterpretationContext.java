package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.event.InPlayListener;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.PropertyContainer;
import ch.qos.logback.core.util.OptionHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes3.dex */
public class InterpretationContext extends ContextAwareBase implements PropertyContainer {

    /* renamed from: d, reason: collision with root package name */
    public final Stack f13562d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f13563e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f13564f;

    /* renamed from: g, reason: collision with root package name */
    public final Interpreter f13565g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f13566h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final DefaultNestedComponentRegistry f13567i = new DefaultNestedComponentRegistry();

    public InterpretationContext(Context context, Interpreter interpreter) {
        this.f13733b = context;
        this.f13565g = interpreter;
        this.f13562d = new Stack();
        this.f13563e = new HashMap(5);
        this.f13564f = new HashMap(5);
    }

    public final void T1(InPlayListener inPlayListener) {
        ArrayList arrayList = this.f13566h;
        if (!arrayList.contains(inPlayListener)) {
            arrayList.add(inPlayListener);
            return;
        }
        J1("InPlayListener " + inPlayListener + " has been already registered");
    }

    public final void U1(SaxEvent saxEvent) {
        Iterator it = this.f13566h.iterator();
        while (it.hasNext()) {
            ((InPlayListener) it.next()).x(saxEvent);
        }
    }

    public final void V1() {
        this.f13562d.pop();
    }

    public final void W1(Object obj) {
        this.f13562d.push(obj);
    }

    public final String X1(String str) {
        if (str == null) {
            return null;
        }
        return OptionHelper.c(str, this, this.f13733b);
    }

    @Override // ch.qos.logback.core.spi.PropertyContainer
    public final String b(String str) {
        String str2 = (String) this.f13564f.get(str);
        return str2 != null ? str2 : this.f13733b.b(str);
    }
}
