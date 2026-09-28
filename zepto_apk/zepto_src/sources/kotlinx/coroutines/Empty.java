package kotlinx.coroutines;

import androidx.fragment.app.e;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
final class Empty implements Incomplete {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f54096a;

    public Empty(boolean z) {
        this.f54096a = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean a() {
        return this.f54096a;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList c() {
        return null;
    }

    public final String toString() {
        return e.t(new StringBuilder("Empty{"), this.f54096a ? "Active" : "New", '}');
    }
}
