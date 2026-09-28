package com.facebook.react.internal;

import com.facebook.react.modules.core.d;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ChoreographerProvider {

    @Metadata
    public interface Choreographer {
        void a(d dVar);

        void b(d dVar);
    }

    Choreographer a();
}
