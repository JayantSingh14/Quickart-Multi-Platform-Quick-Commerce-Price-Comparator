package io.ktor.websocket;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WebSocketExtensionHeader {

    /* renamed from: a, reason: collision with root package name */
    public final String f51514a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f51515b;

    public WebSocketExtensionHeader(String name, ArrayList parameters) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.f51514a = name;
        this.f51515b = parameters;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f51514a);
        sb.append(' ');
        ArrayList arrayList = this.f51515b;
        if (arrayList.isEmpty()) {
            str = "";
        } else {
            str = ", " + CollectionsKt.E(arrayList, ",", null, null, null, 62);
        }
        sb.append(str);
        return sb.toString();
    }
}
