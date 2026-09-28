package io.sentry;

import io.sentry.util.Objects;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class RequestDetails {

    /* renamed from: a, reason: collision with root package name */
    public final URL f51756a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f51757b;

    public RequestDetails(String str, HashMap map) {
        Objects.b(str, "url is required");
        try {
            this.f51756a = URI.create(str).toURL();
            this.f51757b = map;
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", e2);
        }
    }
}
