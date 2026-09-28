package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableIntList extends IntList {
    public MutableIntList(int i2) {
        this.f1442a = i2 == 0 ? IntSetKt.f1454a : new int[i2];
    }

    public MutableIntList() {
        this(16);
    }
}
