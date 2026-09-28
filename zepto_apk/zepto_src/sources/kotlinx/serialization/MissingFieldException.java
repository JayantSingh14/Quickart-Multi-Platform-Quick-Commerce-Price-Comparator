package kotlinx.serialization;

import android.support.v4.media.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public final class MissingFieldException extends SerializationException {

    /* renamed from: a, reason: collision with root package name */
    public final List f55693a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingFieldException(List missingFields, String str, MissingFieldException missingFieldException) {
        super(str, missingFieldException);
        Intrinsics.checkNotNullParameter(missingFields, "missingFields");
        this.f55693a = missingFields;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MissingFieldException(String missingField, String serialName) {
        this(CollectionsKt.H(missingField), b.m("Field '", missingField, "' is required for type with serial name '", serialName, "', but it was missing"), null);
        Intrinsics.checkNotNullParameter(missingField, "missingField");
        Intrinsics.checkNotNullParameter(serialName, "serialName");
    }
}
