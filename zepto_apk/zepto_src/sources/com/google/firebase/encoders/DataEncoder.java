package com.google.firebase.encoders;

import java.io.Writer;

/* loaded from: classes.dex */
public interface DataEncoder {
    void a(Writer writer, Object obj);

    String encode(Object obj);
}
