package kotlinx.datetime.internal.format;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public abstract class AbstractFieldSpec<Target, Type> implements FieldSpec<Target, Type> {
    public final String toString() {
        return "The field " + getName() + " (default value is " + c() + ')';
    }
}
