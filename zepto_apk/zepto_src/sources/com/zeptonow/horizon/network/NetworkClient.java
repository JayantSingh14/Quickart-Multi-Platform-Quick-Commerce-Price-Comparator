package com.zeptonow.horizon.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.serialization.json.JsonObject;

@Metadata
/* loaded from: classes.dex */
public interface NetworkClient {
    void a(JsonObject jsonObject);

    Object b(List list, ContinuationImpl continuationImpl);
}
