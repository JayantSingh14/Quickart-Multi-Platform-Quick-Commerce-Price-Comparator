package io.ktor.http.content;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", l = {WKSRecord.Service.NETBIOS_DGM, 143}, m = "readAllParts")
/* loaded from: classes3.dex */
final class MultipartKt$readAllParts$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public MultiPartData f50291a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f50292b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50293c;

    /* renamed from: d, reason: collision with root package name */
    public int f50294d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MultiPartData multiPartData;
        ArrayList arrayList;
        MultipartKt$readAllParts$1 multipartKt$readAllParts$1;
        this.f50293c = obj;
        int i2 = (this.f50294d | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f50294d = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f50291a = null;
            this.f50294d = 1;
            throw null;
        }
        if (i2 == 1) {
            MultiPartData multiPartData2 = this.f50291a;
            ResultKt.b(obj);
            PartData partData = (PartData) obj;
            if (partData == null) {
                return EmptyList.f53609a;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(partData);
            this.f50291a = multiPartData2;
            this.f50292b = arrayList2;
            this.f50294d = 2;
            multiPartData2.getClass();
            multiPartData = multiPartData2;
            arrayList = arrayList2;
            multipartKt$readAllParts$1 = this;
            obj = null;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ArrayList arrayList3 = this.f50292b;
            MultiPartData multiPartData3 = this.f50291a;
            ResultKt.b(obj);
            multiPartData = multiPartData3;
            arrayList = arrayList3;
            multipartKt$readAllParts$1 = this;
        }
        while (true) {
            PartData partData2 = (PartData) obj;
            if (partData2 == null) {
                return arrayList;
            }
            arrayList.add(partData2);
            MultipartKt$readAllParts$1 multipartKt$readAllParts$12 = multipartKt$readAllParts$1;
            ArrayList arrayList4 = arrayList;
            MultiPartData multiPartData4 = multiPartData;
            multipartKt$readAllParts$12.f50291a = multiPartData4;
            multipartKt$readAllParts$12.f50292b = arrayList4;
            multipartKt$readAllParts$12.f50294d = 2;
            multiPartData4.getClass();
            multiPartData = multiPartData4;
            arrayList = arrayList4;
            multipartKt$readAllParts$1 = multipartKt$readAllParts$12;
            obj = null;
        }
    }
}
