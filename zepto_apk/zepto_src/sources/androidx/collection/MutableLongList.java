package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MutableLongList extends LongList {
    public MutableLongList(int i2) {
        this.f1463a = i2 == 0 ? LongSetKt.f1475a : new long[i2];
    }

    public MutableLongList() {
        this(16);
    }
}
