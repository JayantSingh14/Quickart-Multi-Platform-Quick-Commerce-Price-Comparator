package retrofit2;

import java.util.concurrent.Executor;
import retrofit2.BuiltInFactories;
import retrofit2.Reflection;

/* loaded from: classes.dex */
final class Platform {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f58181a;

    /* renamed from: b, reason: collision with root package name */
    public static final Reflection f58182b;

    /* renamed from: c, reason: collision with root package name */
    public static final BuiltInFactories f58183c;

    static {
        String property = System.getProperty("java.vm.name");
        property.getClass();
        if (property.equals("RoboVM")) {
            f58181a = null;
            f58182b = new Reflection();
            f58183c = new BuiltInFactories();
        } else if (property.equals("Dalvik")) {
            f58181a = new AndroidMainExecutor();
            f58182b = new Reflection.Android24();
            f58183c = new BuiltInFactories.Java8();
        } else {
            f58181a = null;
            f58182b = new Reflection.Java8();
            f58183c = new BuiltInFactories.Java8();
        }
    }
}
