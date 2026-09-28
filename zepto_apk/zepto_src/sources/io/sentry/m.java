package io.sentry;

import io.sentry.SentryEnvelopeItem;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52777a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SentryEnvelopeItem.CachedItem f52778b;

    public /* synthetic */ m(SentryEnvelopeItem.CachedItem cachedItem, int i2) {
        this.f52777a = i2;
        this.f52778b = cachedItem;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        SentryEnvelopeItem.CachedItem cachedItem = this.f52778b;
        switch (this.f52777a) {
            case 0:
                Charset charset = SentryEnvelopeItem.f51819d;
                return Integer.valueOf(cachedItem.a().length);
            case 1:
                Charset charset2 = SentryEnvelopeItem.f51819d;
                return cachedItem.a();
            case 2:
                Charset charset3 = SentryEnvelopeItem.f51819d;
                return Integer.valueOf(cachedItem.a().length);
            case 3:
                Charset charset4 = SentryEnvelopeItem.f51819d;
                return cachedItem.a();
            case 4:
                Charset charset5 = SentryEnvelopeItem.f51819d;
                return Integer.valueOf(cachedItem.a().length);
            case 5:
                Charset charset6 = SentryEnvelopeItem.f51819d;
                return cachedItem.a();
            case 6:
                Charset charset7 = SentryEnvelopeItem.f51819d;
                return Integer.valueOf(cachedItem.a().length);
            case 7:
                Charset charset8 = SentryEnvelopeItem.f51819d;
                return Integer.valueOf(cachedItem.a().length);
            case 8:
                Charset charset9 = SentryEnvelopeItem.f51819d;
                return cachedItem.a();
            case 9:
                Charset charset10 = SentryEnvelopeItem.f51819d;
                return cachedItem.a();
            case 10:
                Charset charset11 = SentryEnvelopeItem.f51819d;
                return Integer.valueOf(cachedItem.a().length);
            default:
                Charset charset12 = SentryEnvelopeItem.f51819d;
                return cachedItem.a();
        }
    }
}
