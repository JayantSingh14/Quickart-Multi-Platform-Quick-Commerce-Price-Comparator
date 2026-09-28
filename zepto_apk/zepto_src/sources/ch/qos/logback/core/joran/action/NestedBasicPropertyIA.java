package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.util.PropertySetter;
import ch.qos.logback.core.joran.util.StringToObjectConverter;
import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import ch.qos.logback.core.util.AggregationType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class NestedBasicPropertyIA extends ImplicitAction {

    /* renamed from: d, reason: collision with root package name */
    public final Stack f13517d = new Stack();

    /* renamed from: e, reason: collision with root package name */
    public final BeanDescriptionCache f13518e;

    /* renamed from: ch.qos.logback.core.joran.action.NestedBasicPropertyIA$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13519a;

        static {
            int[] iArr = new int[AggregationType.values().length];
            f13519a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13519a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13519a[4] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13519a[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13519a[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public NestedBasicPropertyIA(BeanDescriptionCache beanDescriptionCache) {
        this.f13518e = beanDescriptionCache;
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void U1(InterpretationContext interpretationContext, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String strX1 = interpretationContext.X1(str);
        IADataForBasicProperty iADataForBasicProperty = (IADataForBasicProperty) this.f13517d.peek();
        int iOrdinal = iADataForBasicProperty.f13508b.ordinal();
        String str2 = iADataForBasicProperty.f13509c;
        PropertySetter propertySetter = iADataForBasicProperty.f13507a;
        if (iOrdinal == 1) {
            propertySetter.b2(str2, strX1);
            return;
        }
        if (iOrdinal != 3) {
            l1("Unexpected aggregationType " + iADataForBasicProperty.f13508b);
            return;
        }
        if (strX1 == null) {
            return;
        }
        String str3 = str2.substring(0, 1).toUpperCase() + str2.substring(1);
        Method methodV1 = propertySetter.V1(str3);
        if (methodV1 == null) {
            propertySetter.l1("No adder for property [" + str3 + "].");
            return;
        }
        Class<?>[] parameterTypes = methodV1.getParameterTypes();
        propertySetter.Z1(str3, parameterTypes, strX1);
        try {
            if (StringToObjectConverter.a(propertySetter, strX1, parameterTypes[0]) != null) {
                propertySetter.Y1(methodV1, strX1);
            }
        } catch (Throwable th) {
            propertySetter.o1("Conversion to type [" + parameterTypes[0] + "] failed. ", th);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        this.f13517d.pop();
    }

    @Override // ch.qos.logback.core.joran.action.ImplicitAction
    public final boolean Y1(ElementPath elementPath, InterpretationContext interpretationContext) {
        String strB = elementPath.b();
        if (!interpretationContext.f13562d.isEmpty()) {
            PropertySetter propertySetter = new PropertySetter(this.f13518e, interpretationContext.f13562d.peek());
            propertySetter.V(this.f13733b);
            AggregationType aggregationTypeT1 = propertySetter.T1(strB);
            int iOrdinal = aggregationTypeT1.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        if (iOrdinal != 3) {
                            if (iOrdinal != 4) {
                                l1("PropertySetter.canContainComponent returned " + aggregationTypeT1);
                                return false;
                            }
                        }
                    }
                }
                this.f13517d.push(new IADataForBasicProperty(propertySetter, aggregationTypeT1, strB));
                return true;
            }
        }
        return false;
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
    }
}
