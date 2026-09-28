package ch.qos.logback.classic.gaffer;

import ch.qos.logback.core.spi.ContextAwareBase;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import in.juspay.hyper.constants.LogCategory;
import java.lang.ref.SoftReference;
import java.util.List;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class ConfigurationDelegate extends ContextAwareBase implements GroovyObject {

    /* renamed from: e, reason: collision with root package name */
    public static /* synthetic */ ClassInfo f13265e;

    /* renamed from: f, reason: collision with root package name */
    public static /* synthetic */ SoftReference f13266f;

    /* renamed from: d, reason: collision with root package name */
    public final List f13267d;

    class _copyContributions_closure2 extends Closure implements GeneratedClosure {
    }

    class _logger_closure1 extends Closure implements GeneratedClosure {
    }

    public ConfigurationDelegate() {
        U1();
        this.f13267d = ScriptBytecodeAdapter.createList(new Object[0]);
        V1();
    }

    public static /* synthetic */ CallSiteArray T1() {
        return new CallSiteArray(ConfigurationDelegate.class, new String[]{"<$constructor$>", "setContext", LogCategory.CONTEXT, "putObject", LogCategory.CONTEXT, "RECONFIGURE_ON_CHANGE_TASK", "valueOf", "getScheduledExecutorService", LogCategory.CONTEXT, "scheduleAtFixedRate", "getMilliseconds", "getMilliseconds", "MILLISECONDS", "addScheduledFuture", LogCategory.CONTEXT, "addInfo", "plus", "addError", "plus", "plus", "newInstance", "add", "statusManager", LogCategory.CONTEXT, "setContext", LogCategory.CONTEXT, "start", "addInfo", "canonicalName", "getName", "getObject", LogCategory.CONTEXT, "PATTERN_RULE_REGISTRY", "<$constructor$>", "putObject", LogCategory.CONTEXT, "PATTERN_RULE_REGISTRY", "addInfo", "plus", "plus", "plus", "plus", "put", "addError", "logger", "ROOT_LOGGER_NAME", "getLogger", LogCategory.CONTEXT, "addInfo", "plus", "iterator", "find", "addInfo", "plus", "addAppender", "addError", "addInfo", "addInfo", "plus", "plus", CLConstants.FIELD_PAY_INFO_NAME, "newInstance", "addInfo", "plus", "plus", LogCategory.CONTEXT, "add", "<$constructor$>", "copyContributions", LogCategory.CONTEXT, "DELEGATE_FIRST", "call", "start", "addError", "plus", "plus", "addInfo", "plus", "plus", CLConstants.FIELD_PAY_INFO_NAME, "clazz", "newInstance", LogCategory.CONTEXT, "<$constructor$>", LogCategory.CONTEXT, "DELEGATE_FIRST", "call", "start", "addError", "plus", "plus", "getName", "each", "getMappings", "addInfo", "plus", "plus", CLConstants.FIELD_PAY_INFO_NAME, "newInstance", LogCategory.CONTEXT, "<$constructor$>", LogCategory.CONTEXT, "DELEGATE_FIRST", "call", "start", "addInfo", "addTurboFilter", LogCategory.CONTEXT, "addInfo", "currentTimeMillis", "addInfo", "plus", "plus", "<$constructor$>", "format", CLConstants.FIELD_PAY_INFO_NAME, LogCategory.CONTEXT, "<$constructor$>", "getObjectNameFor", "string2ObjectName", LogCategory.CONTEXT, "addError", "platformMBeanServer", "isRegistered", "<$constructor$>", LogCategory.CONTEXT, "registerMBean", "addError"});
    }

    public static /* synthetic */ void U1() {
        CallSiteArray callSiteArrayT1;
        SoftReference softReference = f13266f;
        if (softReference == null || (callSiteArrayT1 = (CallSiteArray) softReference.get()) == null) {
            callSiteArrayT1 = T1();
            f13266f = new SoftReference(callSiteArrayT1);
        }
        CallSite[] callSiteArr = callSiteArrayT1.array;
    }

    @Override // ch.qos.logback.core.spi.ContextAwareBase
    public final Object S1() {
        U1();
        return this;
    }

    public final /* synthetic */ void V1() {
        if (getClass() != ConfigurationDelegate.class) {
            ScriptBytecodeAdapter.initMetaClass(this);
            return;
        }
        ClassInfo classInfo = f13265e;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            f13265e = classInfo;
        }
        classInfo.getMetaClass();
    }
}
