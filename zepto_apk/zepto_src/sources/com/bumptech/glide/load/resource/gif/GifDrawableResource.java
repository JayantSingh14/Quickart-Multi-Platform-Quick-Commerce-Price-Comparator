package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;

/* loaded from: classes3.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    @Override // com.bumptech.glide.load.engine.Resource
    public final Class a() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        GifFrameLoader gifFrameLoader = ((GifDrawable) this.f16339a).f16351a.f16361a;
        StandardGifDecoder standardGifDecoder = gifFrameLoader.f16363a;
        return (standardGifDecoder.f15784j.length * 4) + standardGifDecoder.f15778d.limit() + standardGifDecoder.f15783i.length + gifFrameLoader.o;
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public final void initialize() {
        ((GifDrawable) this.f16339a).c().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
        GifDrawable gifDrawable = (GifDrawable) this.f16339a;
        gifDrawable.stop();
        gifDrawable.f16354d = true;
        GifFrameLoader gifFrameLoader = gifDrawable.f16351a.f16361a;
        gifFrameLoader.f16365c.clear();
        Bitmap bitmap = gifFrameLoader.f16374l;
        if (bitmap != null) {
            gifFrameLoader.f16367e.b(bitmap);
            gifFrameLoader.f16374l = null;
        }
        gifFrameLoader.f16368f = false;
        GifFrameLoader.DelayTarget delayTarget = gifFrameLoader.f16371i;
        RequestManager requestManager = gifFrameLoader.f16366d;
        if (delayTarget != null) {
            requestManager.b(delayTarget);
            gifFrameLoader.f16371i = null;
        }
        GifFrameLoader.DelayTarget delayTarget2 = gifFrameLoader.f16373k;
        if (delayTarget2 != null) {
            requestManager.b(delayTarget2);
            gifFrameLoader.f16373k = null;
        }
        GifFrameLoader.DelayTarget delayTarget3 = gifFrameLoader.n;
        if (delayTarget3 != null) {
            requestManager.b(delayTarget3);
            gifFrameLoader.n = null;
        }
        StandardGifDecoder standardGifDecoder = gifFrameLoader.f16363a;
        standardGifDecoder.f15786l = null;
        byte[] bArr = standardGifDecoder.f15783i;
        GifDecoder.BitmapProvider bitmapProvider = standardGifDecoder.f15777c;
        if (bArr != null) {
            bitmapProvider.e(bArr);
        }
        int[] iArr = standardGifDecoder.f15784j;
        if (iArr != null) {
            bitmapProvider.f(iArr);
        }
        Bitmap bitmap2 = standardGifDecoder.f15787m;
        if (bitmap2 != null) {
            bitmapProvider.a(bitmap2);
        }
        standardGifDecoder.f15787m = null;
        standardGifDecoder.f15778d = null;
        standardGifDecoder.s = null;
        byte[] bArr2 = standardGifDecoder.f15779e;
        if (bArr2 != null) {
            bitmapProvider.e(bArr2);
        }
        gifFrameLoader.f16372j = true;
    }
}
