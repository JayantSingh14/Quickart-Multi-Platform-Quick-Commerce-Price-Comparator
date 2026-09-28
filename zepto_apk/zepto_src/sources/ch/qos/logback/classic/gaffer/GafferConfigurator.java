package ch.qos.logback.classic.gaffer;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import java.lang.ref.SoftReference;
import java.net.URL;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class GafferConfigurator implements GroovyObject {

    /* renamed from: b, reason: collision with root package name */
    public static /* synthetic */ ClassInfo f13268b;

    /* renamed from: c, reason: collision with root package name */
    public static /* synthetic */ SoftReference f13269c;

    /* renamed from: a, reason: collision with root package name */
    public final LoggerContext f13270a;

    class _run_closure1 extends Closure implements GeneratedClosure {
    }

    public GafferConfigurator(LoggerContext loggerContext) {
        b();
        c();
        this.f13270a = (LoggerContext) ScriptBytecodeAdapter.castToType(loggerContext, LoggerContext.class);
    }

    public static /* synthetic */ CallSiteArray a() {
        return new CallSiteArray(GafferConfigurator.class, new String[]{"setMainWatchURL", "informContextOfURLUsedForConfiguration", "run", "text", "informContextOfURLUsedForConfiguration", "toURL", "toURI", "run", "text", "<$constructor$>", "setProperty", "localHostName", "<$constructor$>", "addCompilationCustomizers", "importCustomizer", "addCompilationCustomizers", "getProperty", "isEmpty", "equalsIgnoreCase", "equalsIgnoreCase", "addNewInstanceToContext", "addGroovyPackages", "<$constructor$>", "getFrameworkPackages", "parse", "<$constructor$>", "mixin", "metaClass", "setContext", "metaClass", "run", "<$constructor$>", "addStarImports", "addImports", CLConstants.FIELD_PAY_INFO_NAME, "addStaticStars", CLConstants.FIELD_PAY_INFO_NAME, "addStaticImport", CLConstants.FIELD_PAY_INFO_NAME, "addStaticImport", CLConstants.FIELD_PAY_INFO_NAME, "addStaticImport", CLConstants.FIELD_PAY_INFO_NAME, "addStaticImport", CLConstants.FIELD_PAY_INFO_NAME, "addStaticImport", CLConstants.FIELD_PAY_INFO_NAME, "addStaticImport", CLConstants.FIELD_PAY_INFO_NAME, "addStaticImport", CLConstants.FIELD_PAY_INFO_NAME});
    }

    public static /* synthetic */ CallSite[] b() {
        CallSiteArray callSiteArrayA;
        SoftReference softReference = f13269c;
        if (softReference == null || (callSiteArrayA = (CallSiteArray) softReference.get()) == null) {
            callSiteArrayA = a();
            f13269c = new SoftReference(callSiteArrayA);
        }
        return callSiteArrayA.array;
    }

    public final /* synthetic */ void c() {
        if (getClass() != GafferConfigurator.class) {
            ScriptBytecodeAdapter.initMetaClass(this);
            return;
        }
        ClassInfo classInfo = f13268b;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            f13268b = classInfo;
        }
        classInfo.getMetaClass();
    }

    public final void d(URL url) {
        b()[0].call(ConfigurationWatchListUtil.class, this.f13270a, url);
    }

    public final void e(URL url) {
        CallSite[] callSiteArrB = b();
        if (BytecodeInterface8.disabledStandardMetaClass()) {
            callSiteArrB[1].callCurrent(this, url);
        } else {
            d(url);
        }
        callSiteArrB[2].callCurrent(this, callSiteArrB[3].callGetProperty(url));
    }
}
