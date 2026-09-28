package com.chuckerteam.chucker.api;

import kotlin.Metadata;
import okhttp3.Request;
import okhttp3.Response;
import okio.ByteString;

@Metadata
/* loaded from: classes3.dex */
public interface BodyDecoder {
    String a(Request request, ByteString byteString);

    String b(Response response, ByteString byteString);
}
