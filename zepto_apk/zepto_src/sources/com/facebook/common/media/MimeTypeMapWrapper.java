package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe
/* loaded from: classes3.dex */
public class MimeTypeMapWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static final MimeTypeMap f17089a = MimeTypeMap.getSingleton();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f17090b = ImmutableMap.b("image/heif", "heif", "image/heic", "heic");

    /* renamed from: c, reason: collision with root package name */
    public static final Map f17091c = ImmutableMap.b("heif", "image/heif", "heic", "image/heic");
}
