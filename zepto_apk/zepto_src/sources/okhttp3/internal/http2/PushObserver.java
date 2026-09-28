package okhttp3.internal.http2;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface PushObserver {

    /* renamed from: a, reason: collision with root package name */
    public static final PushObserver f56763a = new Companion.PushObserverCancel();

    @Metadata
    public static final class Companion {

        @Metadata
        public static final class PushObserverCancel implements PushObserver {
        }
    }
}
