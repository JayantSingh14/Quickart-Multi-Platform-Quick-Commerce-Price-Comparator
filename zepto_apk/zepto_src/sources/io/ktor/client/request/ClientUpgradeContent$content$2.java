package io.ktor.client.request;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.internal.ObjectPoolKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class ClientUpgradeContent$content$2 extends Lambda implements Function0<ByteChannel> {

    /* renamed from: c, reason: collision with root package name */
    public static final ClientUpgradeContent$content$2 f49996c = new ClientUpgradeContent$content$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new ByteBufferChannel(false, ObjectPoolKt.f51248c, 8);
    }
}
