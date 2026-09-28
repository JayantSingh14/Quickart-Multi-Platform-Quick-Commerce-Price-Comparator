package io.invertase.firebase.common;

import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.interfaces.NativeEvent;

/* loaded from: classes4.dex */
public class ReactNativeFirebaseEvent implements NativeEvent {

    /* renamed from: a, reason: collision with root package name */
    public final String f49228a;

    /* renamed from: b, reason: collision with root package name */
    public final WritableMap f49229b;

    public ReactNativeFirebaseEvent(String str, WritableMap writableMap) {
        this.f49228a = str;
        this.f49229b = writableMap;
    }

    @Override // io.invertase.firebase.interfaces.NativeEvent
    public final WritableMap a() {
        return this.f49229b;
    }

    @Override // io.invertase.firebase.interfaces.NativeEvent
    public final String b() {
        return this.f49228a;
    }
}
