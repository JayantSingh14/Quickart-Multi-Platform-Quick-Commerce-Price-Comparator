package io.ktor.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public interface StringValues {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f50504c = Companion.f50505a;

    @Metadata
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f50505a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final StringValuesImpl f50506b = new StringValuesImpl(0);
    }

    @Metadata
    @SourceDebugExtension
    public static final class DefaultImpls {
        public static void a(StringValues stringValues, Function2 body) {
            Intrinsics.checkNotNullParameter(body, "body");
            for (Map.Entry entry : stringValues.d()) {
                body.invoke((String) entry.getKey(), (List) entry.getValue());
            }
        }
    }

    List a(String str);

    String b(String str);

    void c(Function2 function2);

    Set d();

    boolean e();

    boolean isEmpty();
}
