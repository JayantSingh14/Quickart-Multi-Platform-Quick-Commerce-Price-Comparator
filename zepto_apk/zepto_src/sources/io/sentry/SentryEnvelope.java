package io.sentry;

import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryEnvelope {

    /* renamed from: a, reason: collision with root package name */
    public final SentryEnvelopeHeader f51812a;

    /* renamed from: b, reason: collision with root package name */
    public final Collection f51813b;

    public SentryEnvelope(SentryEnvelopeHeader sentryEnvelopeHeader, Collection collection) {
        Objects.b(sentryEnvelopeHeader, "SentryEnvelopeHeader is required.");
        this.f51812a = sentryEnvelopeHeader;
        Objects.b(collection, "SentryEnvelope items are required.");
        this.f51813b = collection;
    }

    public SentryEnvelope(SentryId sentryId, SdkVersion sdkVersion, SentryEnvelopeItem sentryEnvelopeItem) {
        this.f51812a = new SentryEnvelopeHeader(sentryId, sdkVersion, null);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(sentryEnvelopeItem);
        this.f51813b = arrayList;
    }
}
