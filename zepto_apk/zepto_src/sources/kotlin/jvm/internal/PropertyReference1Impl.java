package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(String str, String str2, Class cls) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, 0);
    }

    public Object get(Object obj) {
        return b().call(obj);
    }
}
