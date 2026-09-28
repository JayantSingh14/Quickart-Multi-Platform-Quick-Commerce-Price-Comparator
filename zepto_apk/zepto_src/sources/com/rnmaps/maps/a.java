package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import java.util.List;
import java.util.function.Function;
import org.xbill.DNS.Message;
import org.xbill.DNS.Record;
import org.xbill.DNS.SetResponse;
import org.xbill.DNS.lookup.LookupSession;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46673a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f46674b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f46675c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f46676d;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i2) {
        this.f46673a = i2;
        this.f46674b = obj;
        this.f46675c = obj2;
        this.f46676d = obj3;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f46673a) {
            case 0:
                return MapModule.lambda$getAddressFromCoordinates$2((ReadableMap) this.f46674b, (Promise) this.f46675c, (ReactApplicationContext) this.f46676d, (MapView) obj);
            case 1:
                return ((LookupSession) this.f46674b).lambda$lookupWithResolver$7((Message) this.f46675c, (Record) this.f46676d, (Message) obj);
            default:
                return ((LookupSession) this.f46674b).lambda$lookupWithCache$5((Record) this.f46675c, (List) this.f46676d, (SetResponse) obj);
        }
    }
}
