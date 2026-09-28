package ch.qos.logback.core.joran;

import ch.qos.logback.core.joran.action.AppenderAction;
import ch.qos.logback.core.joran.action.AppenderRefAction;
import ch.qos.logback.core.joran.action.ContextPropertyAction;
import ch.qos.logback.core.joran.action.ConversionRuleAction;
import ch.qos.logback.core.joran.action.DefinePropertyAction;
import ch.qos.logback.core.joran.action.NestedBasicPropertyIA;
import ch.qos.logback.core.joran.action.NestedComplexPropertyIA;
import ch.qos.logback.core.joran.action.NewRuleAction;
import ch.qos.logback.core.joran.action.ParamAction;
import ch.qos.logback.core.joran.action.PropertyAction;
import ch.qos.logback.core.joran.action.ShutdownHookAction;
import ch.qos.logback.core.joran.action.StatusListenerAction;
import ch.qos.logback.core.joran.action.TimestampAction;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class JoranConfiguratorBase<E> extends GenericConfigurator {
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
        simpleRuleStore.T1(new ElementSelector("configuration/variable"), new PropertyAction());
        simpleRuleStore.T1(new ElementSelector("configuration/property"), new PropertyAction());
        simpleRuleStore.T1(new ElementSelector("configuration/substitutionProperty"), new PropertyAction());
        simpleRuleStore.T1(new ElementSelector("configuration/timestamp"), new TimestampAction());
        simpleRuleStore.T1(new ElementSelector("configuration/shutdownHook"), new ShutdownHookAction());
        simpleRuleStore.T1(new ElementSelector("configuration/define"), new DefinePropertyAction());
        simpleRuleStore.T1(new ElementSelector("configuration/contextProperty"), new ContextPropertyAction());
        simpleRuleStore.T1(new ElementSelector("configuration/conversionRule"), new ConversionRuleAction());
        simpleRuleStore.T1(new ElementSelector("configuration/statusListener"), new StatusListenerAction());
        simpleRuleStore.T1(new ElementSelector("configuration/appender"), new AppenderAction());
        simpleRuleStore.T1(new ElementSelector("configuration/appender/appender-ref"), new AppenderRefAction());
        simpleRuleStore.T1(new ElementSelector("configuration/newRule"), new NewRuleAction());
        simpleRuleStore.T1(new ElementSelector("*/param"), new ParamAction(a2()));
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    public final void W1() {
        super.W1();
        this.f13494e.f13570b.f13563e.put("APPENDER_BAG", new HashMap());
    }
}
