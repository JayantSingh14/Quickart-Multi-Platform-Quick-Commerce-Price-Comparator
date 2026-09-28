package ch.qos.logback.core.sift;

import ch.qos.logback.core.joran.GenericConfigurator;
import ch.qos.logback.core.joran.action.DefinePropertyAction;
import ch.qos.logback.core.joran.action.NestedBasicPropertyIA;
import ch.qos.logback.core.joran.action.NestedComplexPropertyIA;
import ch.qos.logback.core.joran.action.PropertyAction;
import ch.qos.logback.core.joran.action.TimestampAction;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;

/* loaded from: classes3.dex */
public abstract class SiftingJoranConfiguratorBase<E> extends GenericConfigurator {
    @Override // ch.qos.logback.core.joran.GenericConfigurator
    public final void U1(Interpreter interpreter) {
        NestedComplexPropertyIA nestedComplexPropertyIA = new NestedComplexPropertyIA(a2());
        nestedComplexPropertyIA.V(this.f13733b);
        interpreter.f13571c.add(nestedComplexPropertyIA);
        NestedBasicPropertyIA nestedBasicPropertyIA = new NestedBasicPropertyIA(a2());
        nestedBasicPropertyIA.V(this.f13733b);
        interpreter.f13571c.add(nestedBasicPropertyIA);
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    public void V1(SimpleRuleStore simpleRuleStore) {
        simpleRuleStore.T1(new ElementSelector("configuration/property"), new PropertyAction());
        simpleRuleStore.T1(new ElementSelector("configuration/timestamp"), new TimestampAction());
        simpleRuleStore.T1(new ElementSelector("configuration/define"), new DefinePropertyAction());
    }

    public final String toString() {
        return getClass().getName().concat("{null=null}");
    }
}
