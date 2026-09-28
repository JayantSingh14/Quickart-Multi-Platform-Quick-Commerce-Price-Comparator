package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class StatelessHmacNonceManager implements NonceManager {

    @Metadata
    /* renamed from: io.ktor.util.StatelessHmacNonceManager$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function0<String> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CryptoKt.a();
        }
    }

    @Metadata
    /* renamed from: io.ktor.util.StatelessHmacNonceManager$2, reason: invalid class name */
    final class AnonymousClass2 extends Lambda implements Function0<String> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CryptoKt.a();
        }
    }
}
