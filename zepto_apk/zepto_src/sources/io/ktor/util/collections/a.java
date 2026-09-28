package io.ktor.util.collections;

import java.util.function.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.Cache;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.lookup.LookupSession;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f50530a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f50531b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f50530a = i2;
        this.f50531b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f50530a) {
            case 0:
                Function1 tmp0 = (Function1) this.f50531b;
                Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                return tmp0.invoke(obj);
            case 1:
                return LookupSession.safeConcat((Name) this.f50531b, (Name) obj);
            default:
                return LookupSession.lambda$lookupWithCache$4((Record) this.f50531b, (Cache) obj);
        }
    }
}
