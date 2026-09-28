package io.sentry.internal.debugmeta;

import java.util.List;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class NoOpDebugMetaLoader implements IDebugMetaLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpDebugMetaLoader f52750a = new NoOpDebugMetaLoader();

    @Override // io.sentry.internal.debugmeta.IDebugMetaLoader
    public final List a() {
        return null;
    }
}
