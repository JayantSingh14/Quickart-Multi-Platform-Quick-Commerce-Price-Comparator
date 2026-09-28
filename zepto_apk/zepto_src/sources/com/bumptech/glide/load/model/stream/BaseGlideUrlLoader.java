package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {
    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        new GlideUrl(strC, Headers.f16153a);
        List list = Collections.EMPTY_LIST;
        throw null;
    }

    public abstract String c();
}
