package kotlinx.serialization;

import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;

@Metadata
/* loaded from: classes.dex */
public interface DeserializationStrategy<T> {
    SerialDescriptor a();

    Object b(Decoder decoder);
}
