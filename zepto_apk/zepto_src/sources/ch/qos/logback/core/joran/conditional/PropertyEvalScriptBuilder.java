package ch.qos.logback.core.joran.conditional;

import android.support.v4.media.b;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.PropertyContainer;
import java.util.HashMap;
import org.codehaus.janino.ClassBodyEvaluator;

/* loaded from: classes3.dex */
public class PropertyEvalScriptBuilder extends ContextAwareBase {

    /* renamed from: d, reason: collision with root package name */
    public final InterpretationContext f13535d;

    public PropertyEvalScriptBuilder(InterpretationContext interpretationContext) {
        new HashMap();
        this.f13535d = interpretationContext;
    }

    public final Condition T1(String str) {
        ClassBodyEvaluator classBodyEvaluator = new ClassBodyEvaluator();
        classBodyEvaluator.setImplementedInterfaces(new Class[]{Condition.class});
        classBodyEvaluator.setExtendedClass(PropertyWrapperForScripts.class);
        classBodyEvaluator.setParentClassLoader(ClassBodyEvaluator.class.getClassLoader());
        classBodyEvaluator.cook(b.D("public boolean evaluate() { return ", str, "; }"));
        Class clazz = classBodyEvaluator.getClazz();
        Condition condition = (Condition) clazz.newInstance();
        clazz.getMethod("setPropertyContainers", PropertyContainer.class, PropertyContainer.class).invoke(condition, this.f13535d, this.f13733b);
        return condition;
    }
}
