package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        Object obj;
        LottieValueCallback lottieValueCallback = this.f14333e;
        Object obj2 = keyframe.f14816b;
        if (lottieValueCallback == null) {
            return (f2 != 1.0f || (obj = keyframe.f14817c) == null) ? (DocumentData) obj2 : (DocumentData) obj;
        }
        Float f3 = keyframe.f14822h;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        DocumentData documentData = (DocumentData) obj2;
        Object obj3 = keyframe.f14817c;
        return (DocumentData) lottieValueCallback.b(keyframe.f14821g, fFloatValue, documentData, obj3 == null ? documentData : (DocumentData) obj3, f2, d(), this.f14332d);
    }

    public final void l(final LottieValueCallback lottieValueCallback) {
        final LottieFrameInfo lottieFrameInfo = new LottieFrameInfo();
        final DocumentData documentData = new DocumentData();
        k(new LottieValueCallback<DocumentData>() { // from class: com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation.1
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public final Object a(LottieFrameInfo lottieFrameInfo2) {
                float f2 = lottieFrameInfo2.f14828a;
                float f3 = lottieFrameInfo2.f14829b;
                String str = ((DocumentData) lottieFrameInfo2.f14830c).f14442a;
                String str2 = ((DocumentData) lottieFrameInfo2.f14831d).f14442a;
                float f4 = lottieFrameInfo2.f14832e;
                float f5 = lottieFrameInfo2.f14833f;
                float f6 = lottieFrameInfo2.f14834g;
                LottieFrameInfo lottieFrameInfo3 = lottieFrameInfo;
                lottieFrameInfo3.f14828a = f2;
                lottieFrameInfo3.f14829b = f3;
                lottieFrameInfo3.f14830c = str;
                lottieFrameInfo3.f14831d = str2;
                lottieFrameInfo3.f14832e = f4;
                lottieFrameInfo3.f14833f = f5;
                lottieFrameInfo3.f14834g = f6;
                String str3 = (String) lottieValueCallback.f14837b;
                DocumentData documentData2 = (DocumentData) (lottieFrameInfo2.f14833f == 1.0f ? lottieFrameInfo2.f14831d : lottieFrameInfo2.f14830c);
                String str4 = documentData2.f14443b;
                float f7 = documentData2.f14444c;
                DocumentData.Justification justification = documentData2.f14445d;
                int i2 = documentData2.f14446e;
                float f8 = documentData2.f14447f;
                float f9 = documentData2.f14448g;
                int i3 = documentData2.f14449h;
                int i4 = documentData2.f14450i;
                float f10 = documentData2.f14451j;
                boolean z = documentData2.f14452k;
                PointF pointF = documentData2.f14453l;
                PointF pointF2 = documentData2.f14454m;
                DocumentData documentData3 = documentData;
                documentData3.f14442a = str3;
                documentData3.f14443b = str4;
                documentData3.f14444c = f7;
                documentData3.f14445d = justification;
                documentData3.f14446e = i2;
                documentData3.f14447f = f8;
                documentData3.f14448g = f9;
                documentData3.f14449h = i3;
                documentData3.f14450i = i4;
                documentData3.f14451j = f10;
                documentData3.f14452k = z;
                documentData3.f14453l = pointF;
                documentData3.f14454m = pointF2;
                return documentData3;
            }
        });
    }
}
