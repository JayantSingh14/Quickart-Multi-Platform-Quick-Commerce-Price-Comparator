package ch.qos.logback.classic.gaffer;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

/* loaded from: classes3.dex */
public class PropertyUtil implements GroovyObject {

    /* renamed from: a, reason: collision with root package name */
    public static /* synthetic */ ClassInfo f13273a;

    /* renamed from: b, reason: collision with root package name */
    public static /* synthetic */ SoftReference f13274b;

    class _upperCaseFirstLetter_closure1 extends Closure implements GeneratedClosure {
    }

    public PropertyUtil() {
        b();
        c();
    }

    public static /* synthetic */ CallSiteArray a() {
        return new CallSiteArray(PropertyUtil.class, new String[]{"upperCaseFirstLetter", "respondsTo", "metaClass", "toLowerCamelCase", "hasProperty", "followsTheValueOfConvention", "getType", "SINGLE_WITH_VALUE_OF_CONVENTION", "SINGLE", "hasAdderMethod", "AS_COLLECTION", RegionUtil.REGION_STRING_NA, "toLowerCamelCase", "hasProperty", "getValueOfMethod", "getType", "invoke", "SINGLE_WITH_VALUE_OF_CONVENTION", "toLowerCamelCase", "convertByValueMethod", "SINGLE", "toLowerCamelCase", "AS_COLLECTION", "upperCaseFirstLetter", "length", "length", "<$constructor$>", "getAt", "call", "length", "plus", "substring", "transformFirstLetter"});
    }

    public static /* synthetic */ void b() {
        CallSiteArray callSiteArrayA;
        SoftReference softReference = f13274b;
        if (softReference == null || (callSiteArrayA = (CallSiteArray) softReference.get()) == null) {
            callSiteArrayA = a();
            f13274b = new SoftReference(callSiteArrayA);
        }
        CallSite[] callSiteArr = callSiteArrayA.array;
    }

    public final /* synthetic */ void c() {
        if (getClass() != PropertyUtil.class) {
            ScriptBytecodeAdapter.initMetaClass(this);
            return;
        }
        ClassInfo classInfo = f13273a;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            f13273a = classInfo;
        }
        classInfo.getMetaClass();
    }
}
