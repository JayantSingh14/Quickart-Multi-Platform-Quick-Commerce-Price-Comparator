package io.ktor.client.engine;

import java.net.Proxy;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ProxyConfigJvmKt {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.SOCKS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
