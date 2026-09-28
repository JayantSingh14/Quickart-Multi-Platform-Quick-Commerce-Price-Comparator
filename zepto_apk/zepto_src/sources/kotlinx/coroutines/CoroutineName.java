package kotlinx.coroutines;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CoroutineName extends AbstractCoroutineContextElement {

    /* renamed from: b, reason: collision with root package name */
    public static final Key f54076b = new Key();

    /* renamed from: a, reason: collision with root package name */
    public final String f54077a;

    @Metadata
    public static final class Key implements CoroutineContext.Key<CoroutineName> {
    }

    public CoroutineName(String str) {
        super(f54076b);
        this.f54077a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineName) && Intrinsics.b(this.f54077a, ((CoroutineName) obj).f54077a);
    }

    public final int hashCode() {
        return this.f54077a.hashCode();
    }

    public final String toString() {
        return e.t(new StringBuilder("CoroutineName("), this.f54077a, ')');
    }
}
