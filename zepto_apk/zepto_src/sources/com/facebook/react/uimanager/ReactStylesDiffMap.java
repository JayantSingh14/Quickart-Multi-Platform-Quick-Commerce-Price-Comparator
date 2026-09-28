package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReadableMap;

@Nullsafe
/* loaded from: classes.dex */
public class ReactStylesDiffMap {

    /* renamed from: a, reason: collision with root package name */
    public final ReadableMap f19469a;

    public ReactStylesDiffMap(ReadableMap readableMap) {
        this.f19469a = readableMap;
    }

    public final String toString() {
        return "{ " + getClass().getSimpleName() + ": " + this.f19469a.toString() + " }";
    }
}
