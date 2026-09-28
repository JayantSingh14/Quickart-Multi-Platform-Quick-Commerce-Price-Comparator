package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class ReflectionFactory {
    public static String a(FunctionBase functionBase) {
        String string = functionBase.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
