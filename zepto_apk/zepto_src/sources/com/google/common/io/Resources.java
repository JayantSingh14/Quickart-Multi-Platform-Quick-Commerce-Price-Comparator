package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.List;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
public final class Resources {

    /* renamed from: com.google.common.io.Resources$1, reason: invalid class name */
    class AnonymousClass1 implements LineProcessor<List<String>> {
    }

    public static final class UrlByteSource extends ByteSource {
        public final String toString() {
            return "Resources.asByteSource(null)";
        }
    }
}
