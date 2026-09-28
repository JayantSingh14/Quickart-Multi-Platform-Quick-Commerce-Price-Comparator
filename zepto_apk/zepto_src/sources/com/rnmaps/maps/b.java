package com.rnmaps.maps;

import android.graphics.Point;
import com.facebook.react.bridge.Promise;
import java.util.List;
import java.util.function.Function;
import org.xbill.DNS.Message;
import org.xbill.DNS.Record;
import org.xbill.DNS.lookup.LookupResult;
import org.xbill.DNS.lookup.LookupSession;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46677a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f46678b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f46679c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f46677a = i2;
        this.f46678b = obj;
        this.f46679c = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f46677a) {
            case 0:
                return MapModule.lambda$coordinateForPoint$4((Point) this.f46678b, (Promise) this.f46679c, (MapView) obj);
            case 1:
                return ((LookupSession) this.f46678b).lambda$lookupUntilSuccess$2((Record) this.f46679c, (LookupResult) obj);
            default:
                return LookupSession.lambda$lookupWithResolver$8((List) this.f46678b, (Record) this.f46679c, (Message) obj);
        }
    }
}
