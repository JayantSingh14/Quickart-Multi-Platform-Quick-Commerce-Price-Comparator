package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class GifFrameLoader {

    /* renamed from: a, reason: collision with root package name */
    public final StandardGifDecoder f16363a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f16364b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f16365c;

    /* renamed from: d, reason: collision with root package name */
    public final RequestManager f16366d;

    /* renamed from: e, reason: collision with root package name */
    public final BitmapPool f16367e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16368f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16369g;

    /* renamed from: h, reason: collision with root package name */
    public RequestBuilder f16370h;

    /* renamed from: i, reason: collision with root package name */
    public DelayTarget f16371i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16372j;

    /* renamed from: k, reason: collision with root package name */
    public DelayTarget f16373k;

    /* renamed from: l, reason: collision with root package name */
    public Bitmap f16374l;

    /* renamed from: m, reason: collision with root package name */
    public Transformation f16375m;
    public DelayTarget n;
    public int o;
    public int p;
    public int q;

    @VisibleForTesting
    public static class DelayTarget extends CustomTarget<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        public final Handler f16376d;

        /* renamed from: e, reason: collision with root package name */
        public final int f16377e;

        /* renamed from: f, reason: collision with root package name */
        public final long f16378f;

        /* renamed from: g, reason: collision with root package name */
        public Bitmap f16379g;

        public DelayTarget(Handler handler, int i2, long j2) {
            this.f16376d = handler;
            this.f16377e = i2;
            this.f16378f = j2;
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void f(Drawable drawable) {
            this.f16379g = null;
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void g(Object obj, Transition transition) {
            this.f16379g = (Bitmap) obj;
            Handler handler = this.f16376d;
            handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f16378f);
        }
    }

    public interface FrameCallback {
        void a();
    }

    public class FrameLoaderCallback implements Handler.Callback {
        public FrameLoaderCallback() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            GifFrameLoader gifFrameLoader = GifFrameLoader.this;
            if (i2 == 1) {
                gifFrameLoader.b((DelayTarget) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            gifFrameLoader.f16366d.b((DelayTarget) message.obj);
            return false;
        }
    }

    @VisibleForTesting
    public interface OnEveryFrameListener {
    }

    public GifFrameLoader(Glide glide, StandardGifDecoder standardGifDecoder, int i2, int i3, Bitmap bitmap) {
        UnitTransformation unitTransformation = UnitTransformation.f16246b;
        BitmapPool bitmapPool = glide.f15648a;
        GlideContext glideContext = glide.f15650c;
        Context baseContext = glideContext.getBaseContext();
        Preconditions.c(baseContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        RequestManager requestManagerB = Glide.b(baseContext).f15653f.b(baseContext);
        Context baseContext2 = glideContext.getBaseContext();
        Preconditions.c(baseContext2, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        RequestManager requestManagerB2 = Glide.b(baseContext2).f15653f.b(baseContext2);
        requestManagerB2.getClass();
        RequestBuilder requestBuilderQ = new RequestBuilder(requestManagerB2.f15701a, requestManagerB2, Bitmap.class, requestManagerB2.f15702b).a(RequestManager.f15700l).a(((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().d(DiskCacheStrategy.f15936a)).p()).l()).f(i2, i3));
        this.f16365c = new ArrayList();
        this.f16366d = requestManagerB;
        Handler handler = new Handler(Looper.getMainLooper(), new FrameLoaderCallback());
        this.f16367e = bitmapPool;
        this.f16364b = handler;
        this.f16370h = requestBuilderQ;
        this.f16363a = standardGifDecoder;
        c(unitTransformation, bitmap);
    }

    public final void a() {
        if (!this.f16368f || this.f16369g) {
            return;
        }
        StandardGifDecoder standardGifDecoder = this.f16363a;
        DelayTarget delayTarget = this.n;
        if (delayTarget != null) {
            this.n = null;
            b(delayTarget);
            return;
        }
        this.f16369g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + standardGifDecoder.d();
        standardGifDecoder.b();
        this.f16373k = new DelayTarget(this.f16364b, standardGifDecoder.f15785k, jUptimeMillis);
        RequestBuilder requestBuilderQ = this.f16370h.a((RequestOptions) new RequestOptions().k(new ObjectKey(Double.valueOf(Math.random()))));
        requestBuilderQ.w = standardGifDecoder;
        requestBuilderQ.y = true;
        requestBuilderQ.t(this.f16373k);
    }

    public final void b(DelayTarget delayTarget) {
        this.f16369g = false;
        boolean z = this.f16372j;
        Handler handler = this.f16364b;
        if (z) {
            handler.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        if (!this.f16368f) {
            this.n = delayTarget;
            return;
        }
        if (delayTarget.f16379g != null) {
            Bitmap bitmap = this.f16374l;
            if (bitmap != null) {
                this.f16367e.b(bitmap);
                this.f16374l = null;
            }
            DelayTarget delayTarget2 = this.f16371i;
            this.f16371i = delayTarget;
            ArrayList arrayList = this.f16365c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((FrameCallback) arrayList.get(size)).a();
            }
            if (delayTarget2 != null) {
                handler.obtainMessage(2, delayTarget2).sendToTarget();
            }
        }
        a();
    }

    public final void c(Transformation transformation, Bitmap bitmap) {
        Preconditions.c(transformation, "Argument must not be null");
        this.f16375m = transformation;
        Preconditions.c(bitmap, "Argument must not be null");
        this.f16374l = bitmap;
        this.f16370h = this.f16370h.a(new RequestOptions().m(transformation, true));
        this.o = Util.c(bitmap);
        this.p = bitmap.getWidth();
        this.q = bitmap.getHeight();
    }
}
