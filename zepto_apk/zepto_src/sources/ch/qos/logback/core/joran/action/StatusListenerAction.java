package ch.qos.logback.core.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class StatusListenerAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13526d = false;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f13527e = null;

    /* renamed from: f, reason: collision with root package name */
    public StatusListener f13528f = null;

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) throws ActionException {
        this.f13526d = false;
        this.f13527e = null;
        String value = attributesImpl.getValue("class");
        if (OptionHelper.b(value)) {
            StringBuilder sbY = b.y("Missing class name for statusListener. Near [", str, "] line ");
            sbY.append(Action.X1(interpretationContext));
            l1(sbY.toString());
            this.f13526d = true;
            return;
        }
        try {
            this.f13528f = (StatusListener) OptionHelper.a(value, StatusListener.class, this.f13733b);
            this.f13527e = Boolean.valueOf(interpretationContext.f13733b.D().c(this.f13528f));
            StatusListener statusListener = this.f13528f;
            if (statusListener instanceof ContextAware) {
                ((ContextAware) statusListener).V(this.f13733b);
            }
            s1("Added status listener of type [" + value + "]");
            interpretationContext.W1(this.f13528f);
        } catch (Exception e2) {
            this.f13526d = true;
            o1("Could not create an StatusListener of type [" + value + "].", e2);
            throw new ActionException(e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        if (this.f13526d) {
            return;
        }
        Boolean bool = this.f13527e;
        if (bool == null ? false : bool.booleanValue()) {
            StatusListener statusListener = this.f13528f;
            if (statusListener instanceof LifeCycle) {
                ((LifeCycle) statusListener).start();
            }
        }
        if (interpretationContext.f13562d.peek() != this.f13528f) {
            J1("The object at the of the stack is not the statusListener pushed earlier.");
        } else {
            interpretationContext.V1();
        }
    }
}
