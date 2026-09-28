package kotlinx.serialization;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface StringFormat extends SerialFormat {
    Object b(String str, KSerializer kSerializer);

    String d(KSerializer kSerializer, Object obj);
}
