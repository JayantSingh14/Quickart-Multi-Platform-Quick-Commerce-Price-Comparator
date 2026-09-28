package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this(0);
    }

    public final Object a(CreationExtras.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f4962a.get(key);
    }

    public final void b(CreationExtras.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f4962a.put(key, obj);
    }

    public /* synthetic */ MutableCreationExtras(int i2) {
        this(CreationExtras.Empty.f4963b);
    }

    public MutableCreationExtras(CreationExtras initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        this.f4962a.putAll(initialExtras.f4962a);
    }
}
