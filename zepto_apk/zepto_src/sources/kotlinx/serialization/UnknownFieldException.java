package kotlinx.serialization;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class UnknownFieldException extends SerializationException {
    public UnknownFieldException(int i2) {
        super(b.f(i2, "An unknown field for index "));
    }
}
