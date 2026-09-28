package kotlinx.coroutines.internal;

import androidx.fragment.app.e;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class Symbol {

    /* renamed from: a, reason: collision with root package name */
    public final String f55107a;

    public Symbol(String str) {
        this.f55107a = str;
    }

    public final String toString() {
        return e.t(new StringBuilder("<"), this.f55107a, '>');
    }
}
