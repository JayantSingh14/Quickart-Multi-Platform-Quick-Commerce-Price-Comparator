package com.brentvatne.common.react;

import com.brentvatne.exoplayer.ReactExoplayerView;
import com.brentvatne.react.VideoManagerModule;
import com.chuckerteam.chucker.internal.data.entity.HttpHeader;
import com.facebook.react.bridge.WritableMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15474a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f15475b;

    public /* synthetic */ h(boolean z, int i2) {
        this.f15474a = i2;
        this.f15475b = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f15474a) {
            case 0:
                WritableMap dispatch = (WritableMap) obj;
                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                dispatch.putBoolean("hasAudioFocus", this.f15475b);
                return Unit.f53572a;
            case 1:
                WritableMap dispatch2 = (WritableMap) obj;
                Intrinsics.checkNotNullParameter(dispatch2, "$this$dispatch");
                dispatch2.putBoolean("isActive", this.f15475b);
                return Unit.f53572a;
            case 2:
                WritableMap dispatch3 = (WritableMap) obj;
                Intrinsics.checkNotNullParameter(dispatch3, "$this$dispatch");
                dispatch3.putBoolean("isVisible", this.f15475b);
                return Unit.f53572a;
            case 3:
                WritableMap dispatch4 = (WritableMap) obj;
                Intrinsics.checkNotNullParameter(dispatch4, "$this$dispatch");
                dispatch4.putBoolean("isBuffering", this.f15475b);
                return Unit.f53572a;
            case 4:
                return VideoManagerModule.setFullScreenCmd$lambda$4(this.f15475b, (ReactExoplayerView) obj);
            default:
                HttpHeader header = (HttpHeader) obj;
                Intrinsics.checkNotNullParameter(header, "header");
                return this.f15475b ? android.support.v4.media.b.m("<b> ", header.a(), ": </b>", header.b(), " <br />") : androidx.fragment.app.e.D(header.a(), ": ", header.b(), StringUtils.LF);
        }
    }
}
