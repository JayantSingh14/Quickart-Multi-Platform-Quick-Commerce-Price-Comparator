package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: classes.dex */
public final class MutexKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Symbol f55235a = new Symbol("NO_OWNER");

    /* renamed from: b, reason: collision with root package name */
    public static final Symbol f55236b = new Symbol("ALREADY_LOCKED_BY_OWNER");

    public static MutexImpl a() {
        return new MutexImpl(false);
    }
}
