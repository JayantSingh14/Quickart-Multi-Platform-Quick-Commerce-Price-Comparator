package com.reactnativecommunity.webview;

import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata
/* loaded from: classes4.dex */
public final class RNCWebViewManagerImplKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Regex f46281a = new Regex("[\\\\/%\"]");

    public static final Regex a() {
        return f46281a;
    }
}
