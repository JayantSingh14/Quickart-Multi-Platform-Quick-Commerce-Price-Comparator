package ch.qos.logback.core.joran.action;

import android.support.v4.media.b;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.NoAutoStart;
import ch.qos.logback.core.joran.util.PropertySetter;
import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.util.AggregationType;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.OptionHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class NestedComplexPropertyIA extends ImplicitAction {

    /* renamed from: d, reason: collision with root package name */
    public final Stack f13520d = new Stack();

    /* renamed from: e, reason: collision with root package name */
    public final BeanDescriptionCache f13521e;

    /* renamed from: ch.qos.logback.core.joran.action.NestedComplexPropertyIA$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13522a;

        static {
            int[] iArr = new int[AggregationType.values().length];
            f13522a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13522a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13522a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13522a[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13522a[2] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public NestedComplexPropertyIA(BeanDescriptionCache beanDescriptionCache) {
        this.f13521e = beanDescriptionCache;
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) throws IllegalAccessException, InstantiationException {
        IADataForComplexProperty iADataForComplexProperty = (IADataForComplexProperty) this.f13520d.peek();
        String strX1 = interpretationContext.X1(attributesImpl.getValue("class"));
        try {
            Class<?> clsLoadClass = !OptionHelper.b(strX1) ? Loader.a(this.f13733b).loadClass(strX1) : iADataForComplexProperty.f13510a.X1(iADataForComplexProperty.f13512c, iADataForComplexProperty.f13511b, interpretationContext.f13567i);
            if (clsLoadClass == null) {
                iADataForComplexProperty.f13514e = true;
                l1("Could not find an appropriate class for property [" + str + "]");
                return;
            }
            if (OptionHelper.b(strX1)) {
                s1("Assuming default type [" + clsLoadClass.getName() + "] for [" + str + "] property");
            }
            Object objNewInstance = clsLoadClass.newInstance();
            iADataForComplexProperty.f13513d = objNewInstance;
            if (objNewInstance instanceof ContextAware) {
                ((ContextAware) objNewInstance).V(this.f13733b);
            }
            interpretationContext.W1(iADataForComplexProperty.f13513d);
        } catch (Exception e2) {
            iADataForComplexProperty.f13514e = true;
            o1(b.m("Could not create component [", str, "] of type [", strX1, "]"), e2);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IADataForComplexProperty iADataForComplexProperty = (IADataForComplexProperty) this.f13520d.pop();
        if (iADataForComplexProperty.f13514e) {
            return;
        }
        PropertySetter propertySetter = new PropertySetter(this.f13521e, iADataForComplexProperty.f13513d);
        propertySetter.V(this.f13733b);
        AggregationType aggregationTypeT1 = propertySetter.T1("parent");
        AggregationType aggregationType = AggregationType.f13792c;
        PropertySetter propertySetter2 = iADataForComplexProperty.f13510a;
        if (aggregationTypeT1 == aggregationType) {
            propertySetter.a2(propertySetter2.f13580d, "parent");
        }
        Object obj = iADataForComplexProperty.f13513d;
        if ((obj instanceof LifeCycle) && obj != null && ((NoAutoStart) obj.getClass().getAnnotation(NoAutoStart.class)) == null) {
            ((LifeCycle) obj).start();
        }
        if (interpretationContext.f13562d.peek() != iADataForComplexProperty.f13513d) {
            l1("The object on the top the of the stack is not the component pushed earlier.");
            return;
        }
        interpretationContext.V1();
        AggregationType aggregationType2 = iADataForComplexProperty.f13511b;
        int iOrdinal = aggregationType2.ordinal();
        if (iOrdinal == 2) {
            propertySetter2.a2(iADataForComplexProperty.f13513d, str);
            return;
        }
        if (iOrdinal != 4) {
            l1("Unexpected aggregationType " + aggregationType2);
            return;
        }
        Object obj2 = iADataForComplexProperty.f13513d;
        Method methodV1 = propertySetter2.V1(str);
        if (methodV1 != null) {
            if (propertySetter2.Z1(str, methodV1.getParameterTypes(), obj2)) {
                propertySetter2.Y1(methodV1, obj2);
            }
        } else {
            StringBuilder sbY = b.y("Could not find method [add", str, "] in class [");
            sbY.append(propertySetter2.f13581e.getName());
            sbY.append("].");
            propertySetter2.l1(sbY.toString());
        }
    }

    @Override // ch.qos.logback.core.joran.action.ImplicitAction
    public final boolean Y1(ElementPath elementPath, InterpretationContext interpretationContext) {
        String strB = elementPath.b();
        if (!interpretationContext.f13562d.isEmpty()) {
            PropertySetter propertySetter = new PropertySetter(this.f13521e, interpretationContext.f13562d.peek());
            propertySetter.V(this.f13733b);
            AggregationType aggregationTypeT1 = propertySetter.T1(strB);
            int iOrdinal = aggregationTypeT1.ordinal();
            if (iOrdinal != 0 && iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal != 4) {
                            l1("PropertySetter.computeAggregationType returned " + aggregationTypeT1);
                            return false;
                        }
                    }
                }
                this.f13520d.push(new IADataForComplexProperty(propertySetter, aggregationTypeT1, strB));
                return true;
            }
        }
        return false;
    }
}
