package io.ktor.websocket.serialization;

import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", l = {WKSRecord.Service.SUPDUP, 104}, m = "receiveDeserializedBase")
/* loaded from: classes3.dex */
final class WebsocketChannelSerializationKt$receiveDeserializedBase$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public TypeInfo f51540a;

    /* renamed from: b, reason: collision with root package name */
    public Object f51541b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51542c;

    /* renamed from: d, reason: collision with root package name */
    public int f51543d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws WebsocketDeserializeException {
        this.f51542c = obj;
        int i2 = (this.f51543d | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51543d = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 == 1) {
            WebsocketContentConverter websocketContentConverter = (WebsocketContentConverter) this.f51541b;
            TypeInfo typeInfo = this.f51540a;
            ResultKt.b(obj);
            Frame frame = (Frame) obj;
            if (!websocketContentConverter.a(frame)) {
                throw new WebsocketDeserializeException("Converter doesn't support frame type " + frame.f51441b.name(), frame);
            }
            this.f51540a = typeInfo;
            this.f51541b = frame;
            this.f51543d = 2;
            websocketContentConverter.b(frame);
            throw null;
        }
        if (i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Frame frame2 = (Frame) this.f51541b;
        TypeInfo typeInfo2 = this.f51540a;
        ResultKt.b(obj);
        if (typeInfo2.f50602a.h(obj)) {
            return obj;
        }
        if (obj == null) {
            TypeReference typeReference = typeInfo2.f50604c;
            if (typeReference == null || !typeReference.a()) {
                throw new WebsocketDeserializeException("Frame has null content", frame2);
            }
            return null;
        }
        throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo2.f50602a.i() + ", got " + Reflection.a(obj.getClass()).i(), frame2);
    }
}
