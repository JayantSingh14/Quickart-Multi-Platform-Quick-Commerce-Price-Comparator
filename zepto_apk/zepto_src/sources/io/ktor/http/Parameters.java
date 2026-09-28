package io.ktor.http;

import io.ktor.util.StringValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface Parameters extends StringValues {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f50235b = Companion.f50236a;

    @Metadata
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f50236a = new Companion();
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void a(EmptyParameters emptyParameters, Function2 body) {
            Intrinsics.checkNotNullParameter(body, "body");
            StringValues.DefaultImpls.a(emptyParameters, body);
        }
    }
}
