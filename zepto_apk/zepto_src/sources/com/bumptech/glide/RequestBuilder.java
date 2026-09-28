package com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    public final Context r;
    public final RequestManager s;
    public final Class t;
    public final GlideContext u;
    public TransitionOptions v;
    public Object w;
    public final ArrayList x;
    public boolean y;

    /* renamed from: com.bumptech.glide.RequestBuilder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15698a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15699b;

        static {
            int[] iArr = new int[Priority.values().length];
            f15699b = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15699b[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15699b[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15699b[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f15698a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15698a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15698a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15698a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15698a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15698a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15698a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15698a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
    }

    public RequestBuilder(Glide glide, RequestManager requestManager, Class cls, Context context) {
        RequestOptions requestOptions;
        this.s = requestManager;
        this.t = cls;
        this.r = context;
        ArrayMap arrayMap = requestManager.f15701a.f15650c.f15675e;
        TransitionOptions transitionOptions = (TransitionOptions) arrayMap.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry entry : arrayMap.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) entry.getValue();
                }
            }
        }
        this.v = transitionOptions == null ? GlideContext.f15670i : transitionOptions;
        this.u = glide.f15650c;
        Iterator it = requestManager.f15710j.iterator();
        while (it.hasNext()) {
            RequestListener requestListener = (RequestListener) it.next();
            if (requestListener != null) {
                if (this.x == null) {
                    this.x = new ArrayList();
                }
                this.x.add(requestListener);
            }
        }
        synchronized (requestManager) {
            requestOptions = requestManager.f15711k;
        }
        a(requestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: b */
    public final BaseRequestOptions clone() {
        RequestBuilder requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.v = requestBuilder.v.clone();
        return requestBuilder;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final Object clone() {
        RequestBuilder requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.v = requestBuilder.v.clone();
        return requestBuilder;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final RequestBuilder a(BaseRequestOptions baseRequestOptions) {
        Preconditions.b(baseRequestOptions);
        return (RequestBuilder) super.a(baseRequestOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(com.bumptech.glide.request.target.Target r19) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.t(com.bumptech.glide.request.target.Target):void");
    }
}
