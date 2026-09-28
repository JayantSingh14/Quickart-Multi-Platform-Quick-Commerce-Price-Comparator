package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface KCallable<R> extends KAnnotatedElement {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Object call(Object... objArr);

    Object callBy(Map map);

    String getName();

    List getParameters();

    KType getReturnType();

    List getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();
}
