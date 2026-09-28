package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class LoadPathCache {

    /* renamed from: c, reason: collision with root package name */
    public static final LoadPath f16428c = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new UnitTranscoder(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayMap f16429a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f16430b = new AtomicReference();
}
