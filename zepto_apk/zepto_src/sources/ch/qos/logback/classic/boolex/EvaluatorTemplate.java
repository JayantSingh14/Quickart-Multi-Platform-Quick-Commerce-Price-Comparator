package ch.qos.logback.classic.boolex;

import groovy.lang.GroovyObject;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

/* loaded from: classes3.dex */
public class EvaluatorTemplate implements IEvaluator, GroovyObject {

    /* renamed from: a, reason: collision with root package name */
    public static /* synthetic */ ClassInfo f13255a;

    /* renamed from: b, reason: collision with root package name */
    public static /* synthetic */ SoftReference f13256b;

    public EvaluatorTemplate() {
        b();
        c();
    }

    public static /* synthetic */ CallSiteArray a() {
        return new CallSiteArray(EvaluatorTemplate.class, new String[0]);
    }

    public static /* synthetic */ void b() {
        CallSiteArray callSiteArrayA;
        SoftReference softReference = f13256b;
        if (softReference == null || (callSiteArrayA = (CallSiteArray) softReference.get()) == null) {
            callSiteArrayA = a();
            f13256b = new SoftReference(callSiteArrayA);
        }
        CallSite[] callSiteArr = callSiteArrayA.array;
    }

    public final /* synthetic */ void c() {
        if (getClass() != EvaluatorTemplate.class) {
            ScriptBytecodeAdapter.initMetaClass(this);
            return;
        }
        ClassInfo classInfo = f13255a;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            f13255a = classInfo;
        }
        classInfo.getMetaClass();
    }
}
