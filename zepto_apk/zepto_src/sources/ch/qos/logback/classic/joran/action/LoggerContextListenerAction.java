package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class LoggerContextListenerAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13284d = false;

    /* renamed from: e, reason: collision with root package name */
    public LoggerContextListener f13285e;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        this.f13284d = false;
        String value = attributesImpl.getValue("class");
        if (OptionHelper.b(value)) {
            l1("Mandatory \"class\" attribute not set for <loggerContextListener> element");
            this.f13284d = true;
            return;
        }
        try {
            LoggerContextListener loggerContextListener = (LoggerContextListener) OptionHelper.a(value, LoggerContextListener.class, this.f13733b);
            this.f13285e = loggerContextListener;
            if (loggerContextListener instanceof ContextAware) {
                ((ContextAware) loggerContextListener).V(this.f13733b);
            }
            interpretationContext.W1(this.f13285e);
            s1("Adding LoggerContextListener of type [" + value + "] to the object stack");
        } catch (Exception e2) {
            this.f13284d = true;
            o1("Could not create LoggerContextListener of type " + value + "].", e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (this.f13284d) {
            return;
        }
        Object objPeek = interpretationContext.f13562d.peek();
        LoggerContextListener loggerContextListener = this.f13285e;
        if (objPeek != loggerContextListener) {
            J1("The object on the top the of the stack is not the LoggerContextListener pushed earlier.");
            return;
        }
        if (loggerContextListener instanceof LifeCycle) {
            ((LifeCycle) loggerContextListener).start();
            s1("Starting LoggerContextListener");
        }
        LoggerContext loggerContext = (LoggerContext) this.f13733b;
        loggerContext.f13252m.add(this.f13285e);
        interpretationContext.V1();
    }
}
