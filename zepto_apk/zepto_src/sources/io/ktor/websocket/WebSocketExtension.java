package io.ktor.websocket;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface WebSocketExtension<ConfigType> {
    Frame a(Frame frame);

    Frame b(Frame frame);

    boolean c(List list);

    ArrayList d();
}
