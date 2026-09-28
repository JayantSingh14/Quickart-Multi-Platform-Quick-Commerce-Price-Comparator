package ch.qos.logback.classic.gaffer;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import groovy.lang.GroovyObject;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class NestingType implements GroovyObject {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NestingType[] f13271a = {(NestingType) ShortTypeHandling.castToEnum(b()[13].callStatic(NestingType.class, RegionUtil.REGION_STRING_NA, 0), NestingType.class), (NestingType) ShortTypeHandling.castToEnum(b()[14].callStatic(NestingType.class, "SINGLE", 1), NestingType.class), (NestingType) ShortTypeHandling.castToEnum(b()[15].callStatic(NestingType.class, "SINGLE_WITH_VALUE_OF_CONVENTION", 2), NestingType.class), (NestingType) ShortTypeHandling.castToEnum(b()[16].callStatic(NestingType.class, "AS_COLLECTION", 3), NestingType.class)};

    /* renamed from: b, reason: collision with root package name */
    public static /* synthetic */ SoftReference f13272b;

    public static /* synthetic */ CallSiteArray a() {
        return new CallSiteArray(NestingType.class, new String[]{"<$constructor$>", "checkPropNames", "<$constructor$>", "next", "ordinal", "size", "getAt", "previous", "ordinal", "minus", "size", "getAt", "valueOf", "$INIT", "$INIT", "$INIT", "$INIT"});
    }

    public static /* synthetic */ CallSite[] b() {
        CallSiteArray callSiteArrayA;
        SoftReference softReference = f13272b;
        if (softReference == null || (callSiteArrayA = (CallSiteArray) softReference.get()) == null) {
            callSiteArrayA = a();
            f13272b = new SoftReference(callSiteArrayA);
        }
        return callSiteArrayA.array;
    }

    public static NestingType valueOf(String str) {
        return (NestingType) ShortTypeHandling.castToEnum(b()[12].callStatic(NestingType.class, NestingType.class, str), NestingType.class);
    }

    public static final NestingType[] values() {
        b();
        return (NestingType[]) ScriptBytecodeAdapter.castToType(f13271a.clone(), NestingType[].class);
    }
}
