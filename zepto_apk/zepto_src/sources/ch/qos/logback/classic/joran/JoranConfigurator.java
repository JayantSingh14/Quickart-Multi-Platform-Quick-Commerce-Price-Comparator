package ch.qos.logback.classic.joran;

import ch.qos.logback.classic.joran.action.ConfigurationAction;
import ch.qos.logback.classic.joran.action.ConsolePluginAction;
import ch.qos.logback.classic.joran.action.ContextNameAction;
import ch.qos.logback.classic.joran.action.EvaluatorAction;
import ch.qos.logback.classic.joran.action.InsertFromJNDIAction;
import ch.qos.logback.classic.joran.action.JMXConfiguratorAction;
import ch.qos.logback.classic.joran.action.LevelAction;
import ch.qos.logback.classic.joran.action.LoggerAction;
import ch.qos.logback.classic.joran.action.LoggerContextListenerAction;
import ch.qos.logback.classic.joran.action.ReceiverAction;
import ch.qos.logback.classic.joran.action.RootLoggerAction;
import ch.qos.logback.classic.sift.SiftAction;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.PlatformInfo;
import ch.qos.logback.classic.util.DefaultNestedComponentRules;
import ch.qos.logback.core.joran.JoranConfiguratorBase;
import ch.qos.logback.core.joran.action.AppenderRefAction;
import ch.qos.logback.core.joran.action.IncludeAction;
import ch.qos.logback.core.joran.action.NOPAction;
import ch.qos.logback.core.joran.conditional.ElseAction;
import ch.qos.logback.core.joran.conditional.IfAction;
import ch.qos.logback.core.joran.conditional.ThenAction;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class JoranConfigurator extends JoranConfiguratorBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.joran.GenericConfigurator
    public final void T1(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        DefaultNestedComponentRules.a(defaultNestedComponentRegistry);
    }

    @Override // ch.qos.logback.core.joran.JoranConfiguratorBase, ch.qos.logback.core.joran.GenericConfigurator
    public final void V1(SimpleRuleStore simpleRuleStore) {
        super.V1(simpleRuleStore);
        simpleRuleStore.T1(new ElementSelector(CLConstants.INPUT_CONFIGURATION), new ConfigurationAction());
        simpleRuleStore.T1(new ElementSelector("configuration/contextName"), new ContextNameAction());
        simpleRuleStore.T1(new ElementSelector("configuration/contextListener"), new LoggerContextListenerAction());
        simpleRuleStore.T1(new ElementSelector("configuration/insertFromJNDI"), new InsertFromJNDIAction());
        simpleRuleStore.T1(new ElementSelector("configuration/evaluator"), new EvaluatorAction());
        simpleRuleStore.T1(new ElementSelector("configuration/appender/sift"), new SiftAction());
        simpleRuleStore.T1(new ElementSelector("configuration/appender/sift/*"), new NOPAction());
        simpleRuleStore.T1(new ElementSelector("configuration/logger"), new LoggerAction());
        simpleRuleStore.T1(new ElementSelector("configuration/logger/level"), new LevelAction());
        simpleRuleStore.T1(new ElementSelector("configuration/root"), new RootLoggerAction());
        simpleRuleStore.T1(new ElementSelector("configuration/root/level"), new LevelAction());
        simpleRuleStore.T1(new ElementSelector("configuration/logger/appender-ref"), new AppenderRefAction());
        simpleRuleStore.T1(new ElementSelector("configuration/root/appender-ref"), new AppenderRefAction());
        simpleRuleStore.T1(new ElementSelector("*/if"), new IfAction());
        simpleRuleStore.T1(new ElementSelector("*/if/then"), new ThenAction());
        simpleRuleStore.T1(new ElementSelector("*/if/then/*"), new NOPAction());
        simpleRuleStore.T1(new ElementSelector("*/if/else"), new ElseAction());
        simpleRuleStore.T1(new ElementSelector("*/if/else/*"), new NOPAction());
        if (PlatformInfo.f13374a == -1) {
            try {
                Class.forName("javax.management.ObjectName");
                PlatformInfo.f13374a = 1;
            } catch (Throwable unused) {
                PlatformInfo.f13374a = 0;
            }
        }
        if (PlatformInfo.f13374a == 1) {
            simpleRuleStore.T1(new ElementSelector("configuration/jmxConfigurator"), new JMXConfiguratorAction());
        }
        simpleRuleStore.T1(new ElementSelector("configuration/include"), new IncludeAction());
        simpleRuleStore.T1(new ElementSelector("configuration/consolePlugin"), new ConsolePluginAction());
        simpleRuleStore.T1(new ElementSelector("configuration/receiver"), new ReceiverAction());
    }
}
