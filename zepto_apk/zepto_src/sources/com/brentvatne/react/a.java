package com.brentvatne.react;

import android.app.Activity;
import android.app.PendingIntent;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.chuckerteam.chucker.api.BodyDecoder;
import com.chuckerteam.chucker.internal.support.Logger;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenFragmentWrapper;
import com.swmansion.rnscreens.ScreenStack;
import com.zeptoconsumerapp.PhoneNumberHint.PhoneNumberHintModule;
import java.io.IOException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1;
import okhttp3.Request;
import okhttp3.Response;
import okio.ByteString;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15634a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15635b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15636c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f15634a = i2;
        this.f15635b = obj;
        this.f15636c = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Logger.Companion companion = Logger.Companion.f16778a;
        Object obj2 = this.f15636c;
        Object obj3 = this.f15635b;
        switch (this.f15634a) {
            case 0:
                return VideoManagerModule.setSourceCmd$lambda$7((ReadableMap) obj3, (VideoManagerModule) obj2, (ReactExoplayerView) obj);
            case 1:
                Request request = (Request) obj3;
                ByteString byteString = (ByteString) obj2;
                BodyDecoder decoder = (BodyDecoder) obj;
                Intrinsics.checkNotNullParameter(decoder, "decoder");
                try {
                    Logger.DefaultImpls.a("Decoding with: " + decoder);
                    return decoder.a(request, byteString);
                } catch (IOException e2) {
                    companion.b("Decoder " + decoder + " failed to process request payload", e2);
                    return null;
                }
            case 2:
                Response response = (Response) obj3;
                ByteString byteString2 = (ByteString) obj2;
                BodyDecoder decoder2 = (BodyDecoder) obj;
                Intrinsics.checkNotNullParameter(decoder2, "decoder");
                try {
                    return decoder2.b(response, byteString2);
                } catch (IOException e3) {
                    companion.b("Decoder " + decoder2 + " failed to process response payload", e3);
                    return null;
                }
            case 3:
                ScreenFragmentWrapper it = (ScreenFragmentWrapper) obj;
                int i2 = ScreenStack.r;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!(it == ((Ref.ObjectRef) obj3).f53801a || CollectionsKt.s(((ScreenStack) obj2).f47016j, it)) || it.k().getActivityState() == Screen.ActivityState.f46949a);
            case 4:
                return PhoneNumberHintModule.requestHint$lambda$0((Activity) obj3, (PhoneNumberHintModule) obj2, (PendingIntent) obj);
            default:
                ((HandlerContext) obj3).f54176b.removeCallbacks((HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1) obj2);
                return Unit.f53572a;
        }
    }
}
