package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f15931a;

    /* renamed from: b, reason: collision with root package name */
    public final List f15932b;

    /* renamed from: c, reason: collision with root package name */
    public final ResourceTranscoder f15933c;

    /* renamed from: d, reason: collision with root package name */
    public final Pools.Pool f15934d;

    /* renamed from: e, reason: collision with root package name */
    public final String f15935e;

    public interface DecodeCallback<ResourceType> {
    }

    public DecodePath(Class cls, Class cls2, Class cls3, List list, ResourceTranscoder resourceTranscoder, Pools.Pool pool) {
        this.f15931a = cls;
        this.f15932b = list;
        this.f15933c = resourceTranscoder;
        this.f15934d = pool;
        this.f15935e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final Resource a(DataRewinder dataRewinder, int i2, int i3, Options options, List list) throws GlideException {
        List list2 = this.f15932b;
        int size = list2.size();
        Resource resourceB = null;
        for (int i4 = 0; i4 < size; i4++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) list2.get(i4);
            try {
                if (resourceDecoder.a(dataRewinder.a(), options)) {
                    resourceB = resourceDecoder.b(dataRewinder.a(), i2, i3, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e2);
                }
                list.add(e2);
            }
            if (resourceB != null) {
                break;
            }
        }
        if (resourceB != null) {
            return resourceB;
        }
        throw new GlideException(this.f15935e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f15931a + ", decoders=" + this.f15932b + ", transcoder=" + this.f15933c + '}';
    }
}
