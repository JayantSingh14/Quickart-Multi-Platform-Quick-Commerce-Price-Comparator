package io.ktor.websocket;

import com.facebook.react.uimanager.style.BorderStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RawWebSocketJvm$special$$inlined$observable$1 extends ObservableProperty<Long> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.properties.ObservableProperty
    public final void b(KProperty property, BorderStyle borderStyle, BorderStyle borderStyle2) {
        Intrinsics.checkNotNullParameter(property, "property");
        ((Number) borderStyle2).longValue();
        ((Number) borderStyle).longValue();
        throw null;
    }
}
