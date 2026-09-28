package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;

@Metadata
@InternalSerializationApi
/* loaded from: classes.dex */
public interface GeneratedSerializer<T> extends KSerializer<T> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    KSerializer[] d();
}
