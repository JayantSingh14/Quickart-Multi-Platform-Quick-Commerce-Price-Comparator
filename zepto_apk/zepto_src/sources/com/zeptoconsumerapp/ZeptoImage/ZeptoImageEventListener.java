package com.zeptoconsumerapp.ZeptoImage;

import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.SuccessResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ZeptoImageEventListener implements ImageRequest.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final ReactContext f47575a;

    /* renamed from: b, reason: collision with root package name */
    public final ZeptoImageView f47576b;

    public ZeptoImageEventListener(ReactContext reactContext, ZeptoImageView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        this.f47575a = reactContext;
        this.f47576b = view;
    }

    public final void a(String str, WritableMap writableMap) {
        ZeptoImageView zeptoImageView = this.f47576b;
        int id = zeptoImageView.getId();
        ReactContext reactContext = this.f47575a;
        EventDispatcher eventDispatcherA = UIManagerHelper.a(reactContext, id);
        if (eventDispatcherA != null) {
            eventDispatcherA.g(new ImageEvent(UIManagerHelper.d(reactContext), zeptoImageView.getId(), str, writableMap));
        }
    }

    @Override // coil3.request.ImageRequest.Listener
    public final void onCancel(ImageRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        super.onCancel(request);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("source", request.getData().toString());
        a("onLoadEnd", writableMapCreateMap);
    }

    @Override // coil3.request.ImageRequest.Listener
    public final void onError(ImageRequest request, ErrorResult result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        super.onError(request, result);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("source", request.getData().toString());
        writableMapCreateMap.putString("error", result.toString());
        a("onError", writableMapCreateMap);
        a("onLoadEnd", null);
    }

    @Override // coil3.request.ImageRequest.Listener
    public final void onStart(ImageRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        super.onStart(request);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("source", request.getData().toString());
        a("onLoadStart", writableMapCreateMap);
    }

    @Override // coil3.request.ImageRequest.Listener
    public final void onSuccess(ImageRequest request, SuccessResult result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("source", request.getData().toString());
        writableMapCreateMap.putLong("size", result.getImage().getSize());
        writableMapCreateMap.putString("dataSource", result.getDataSource().toString());
        a("onLoad", writableMapCreateMap);
        a("onLoadEnd", null);
    }
}
