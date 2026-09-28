package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(String str, String str2, Class cls) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, 0);
    }

    public void g(Object obj, Object obj2) {
        c().call(obj, obj2);
    }

    public Object get(Object obj) {
        return b().call(obj);
    }
}
