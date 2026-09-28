package com.chuckerteam.chucker.internal.data.repository;

import android.support.v4.media.b;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16723a;

    public /* synthetic */ a(int i2) {
        this.f16723a = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f16723a) {
            case 0:
                HttpTransaction httpTransaction = (HttpTransaction) obj;
                HttpTransaction httpTransaction2 = (HttpTransaction) obj2;
                boolean z = false;
                if (httpTransaction != null && !httpTransaction.hasTheSameContent(httpTransaction2)) {
                    z = true;
                }
                return Boolean.valueOf(!z);
            case 1:
                return new Pair(obj, obj2);
            case 2:
                HttpTransaction httpTransaction3 = (HttpTransaction) obj;
                return httpTransaction3 != null ? b.l(httpTransaction3.getMethod(), StringUtils.SPACE, httpTransaction3.getFormattedPath(((Boolean) obj2).booleanValue())) : "";
            case 3:
                return Boolean.valueOf((((Boolean) obj).booleanValue() && ((Boolean) obj2).booleanValue()) ? false : true);
            default:
                String acc = (String) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
        }
    }
}
