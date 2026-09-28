package io.ktor.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public interface Attributes {

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Object a(AttributeKey attributeKey);

    void b(AttributeKey attributeKey, Object obj);

    List c();

    void d(AttributeKey attributeKey);

    boolean e(AttributeKey attributeKey);

    Object f(AttributeKey attributeKey);

    Object g(AttributeKey attributeKey, Function0 function0);
}
