package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

/* loaded from: classes3.dex */
public interface DiskCache {

    public interface Factory {
    }

    public interface Writer {
        boolean a(File file);
    }

    void a(Key key, Writer writer);

    File b(Key key);
}
