package io.ktor.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class NonceKt {

    /* renamed from: a, reason: collision with root package name */
    public static final List f50488a = kotlin.collections.CollectionsKt.I("NativePRNGNonBlocking", "WINDOWS-PRNG", "DRBG");

    /* renamed from: b, reason: collision with root package name */
    public static final BufferedChannel f50489b = ChannelKt.a(1024, null, 6);

    /* renamed from: c, reason: collision with root package name */
    public static final Job f50490c;

    static {
        CoroutineName coroutineName = new CoroutineName("nonce-generator");
        GlobalScope globalScope = GlobalScope.f54113a;
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        f50490c = BuildersKt.b(globalScope, DefaultIoScheduler.f55150b.plus(NonCancellable.f54154a).plus(coroutineName), CoroutineStart.f54079b, new NonceKt$nonceGeneratorJob$1(2, null));
    }

    public static final SecureRandom a(String str) {
        try {
            return str != null ? SecureRandom.getInstance(str) : new SecureRandom();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
