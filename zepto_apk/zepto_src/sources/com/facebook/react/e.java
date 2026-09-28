package com.facebook.react;

import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.PermissionListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReactActivityDelegate f18953a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18954b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String[] f18955c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int[] f18956d;

    public /* synthetic */ e(ReactActivityDelegate reactActivityDelegate, int i2, String[] strArr, int[] iArr) {
        this.f18953a = reactActivityDelegate;
        this.f18954b = i2;
        this.f18955c = strArr;
        this.f18956d = iArr;
    }

    @Override // com.facebook.react.bridge.Callback
    public final void invoke(Object[] objArr) {
        ReactActivityDelegate reactActivityDelegate = this.f18953a;
        PermissionListener permissionListener = reactActivityDelegate.f18438c;
        if (permissionListener == null || !permissionListener.onRequestPermissionsResult(this.f18954b, this.f18955c, this.f18956d)) {
            return;
        }
        reactActivityDelegate.f18438c = null;
    }
}
