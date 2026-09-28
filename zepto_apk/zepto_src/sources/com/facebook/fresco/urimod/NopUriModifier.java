package com.facebook.fresco.urimod;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NopUriModifier implements UriModifierInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final NopUriModifier f17491a = new NopUriModifier();

    public final Uri a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return uri;
    }
}
