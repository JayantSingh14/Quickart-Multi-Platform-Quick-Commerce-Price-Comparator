package io.ktor.websocket;

import io.ktor.util.AttributeKey;
import io.ktor.websocket.Frame;
import io.ktor.websocket.internals.DeflaterUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.TransformingSequence;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WebSocketDeflateExtension implements WebSocketExtension<Config> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f51506d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f51507a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f51508b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f51509c;

    @Metadata
    public static final class Companion implements WebSocketExtensionFactory<Config, WebSocketDeflateExtension> {
    }

    @Metadata
    public static final class Config {

        /* renamed from: a, reason: collision with root package name */
        public final Function1 f51510a = WebSocketDeflateExtension$Config$manualConfig$1.f51513c;

        /* renamed from: b, reason: collision with root package name */
        public final Function1 f51511b = WebSocketDeflateExtension$Config$compressCondition$1.f51512c;
    }

    static {
        new AttributeKey("WebsocketDeflateExtension");
        f51506d = true;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public final Frame a(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if ((frame instanceof Frame.Text) || (frame instanceof Frame.Binary)) {
            WebSocketDeflateExtension$Config$compressCondition$1.f51512c.invoke(frame);
            if (Boolean.TRUE.booleanValue()) {
                byte[] data = frame.f51442c;
                Intrinsics.checkNotNullParameter(null, "<this>");
                Intrinsics.checkNotNullParameter(data, "data");
                throw null;
            }
        }
        return frame;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public final Frame b(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if ((!frame.f51444e || (!(frame instanceof Frame.Text) && !(frame instanceof Frame.Binary))) && !this.f51509c) {
            return frame;
        }
        this.f51509c = true;
        Intrinsics.checkNotNullParameter(null, "<this>");
        byte[] data = frame.f51442c;
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] elements = DeflaterUtilsKt.f51539b;
        Intrinsics.checkNotNullParameter(data, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = data.length;
        byte[] bArrCopyOf = Arrays.copyOf(data, length + 4);
        System.arraycopy(elements, 0, bArrCopyOf, length, 4);
        Intrinsics.c(bArrCopyOf);
        throw null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.ktor.websocket.WebSocketExtension
    public final boolean c(List negotiatedProtocols) {
        Object next;
        Intrinsics.checkNotNullParameter(negotiatedProtocols, "negotiatedProtocols");
        Iterator it = negotiatedProtocols.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.b(((WebSocketExtensionHeader) next).f51514a, "permessage-deflate")) {
                break;
            }
        }
        WebSocketExtensionHeader webSocketExtensionHeader = (WebSocketExtensionHeader) next;
        if (webSocketExtensionHeader == null) {
            return false;
        }
        this.f51508b = false;
        this.f51507a = false;
        TransformingSequence.AnonymousClass1 anonymousClass1 = new TransformingSequence.AnonymousClass1();
        while (anonymousClass1.f53946a.hasNext()) {
            Pair pair = (Pair) anonymousClass1.next();
            String str = (String) pair.f53533a;
            String str2 = (String) pair.f53534b;
            switch (str.hashCode()) {
                case -708713803:
                    if (!str.equals("client_no_context_takeover")) {
                        continue;
                    } else {
                        if (!StringsKt.z(str2)) {
                            throw new IllegalStateException("WebSocket permessage-deflate extension parameter client_no_context_takeover shouldn't have a value. Current: ".concat(str2).toString());
                        }
                        this.f51507a = true;
                        break;
                    }
                case 646404390:
                    if (str.equals("client_max_window_bits") && !StringsKt.z(str2) && Integer.parseInt(str2) != 15) {
                        throw new IllegalStateException("Only 15 window size is supported.");
                    }
                    break;
                case 1266201133:
                    if (!str.equals("server_no_context_takeover")) {
                        continue;
                    } else {
                        if (!StringsKt.z(str2)) {
                            throw new IllegalStateException("WebSocket permessage-deflate extension parameter server_no_context_takeover shouldn't have a value. Current: ".concat(str2).toString());
                        }
                        this.f51508b = true;
                        break;
                    }
                case 2034279582:
                    str.equals("server_max_window_bits");
                    break;
            }
        }
        return true;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public final ArrayList d() {
        return null;
    }
}
