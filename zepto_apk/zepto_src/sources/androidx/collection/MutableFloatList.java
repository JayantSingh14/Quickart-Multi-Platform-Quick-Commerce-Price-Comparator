package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableFloatList extends FloatList {
    public MutableFloatList(int i2) {
        this.f1418a = i2 == 0 ? FloatSetKt.f1430a : new float[i2];
    }

    public MutableFloatList() {
        this(16);
    }
}
