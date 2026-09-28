package kotlinx.serialization;

import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

@Metadata
/* loaded from: classes.dex */
public interface SerializationStrategy<T> {
    SerialDescriptor a();

    void c(Encoder encoder, Object obj);
}
