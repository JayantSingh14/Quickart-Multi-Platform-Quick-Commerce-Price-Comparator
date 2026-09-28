package com.google.firebase.components;

import android.content.Context;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class ComponentDiscovery<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f43570a;

    public static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {
    }

    @VisibleForTesting
    public interface RegistrarNameRetriever<T> {
    }

    public ComponentDiscovery(Context context, MetadataRegistrarNameRetriever metadataRegistrarNameRetriever) {
        this.f43570a = context;
    }

    public static ComponentDiscovery a(Context context) {
        return new ComponentDiscovery(context, new MetadataRegistrarNameRetriever());
    }
}
