package io.ktor.client.request.forms;

import io.ktor.utils.io.ByteWriteChannel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.request.forms.MultiPartFormDataContent", f = "FormDataContent.kt", l = {116, WKSRecord.Service.UUCP_PATH, 118, WKSRecord.Service.NTP, WKSRecord.Service.LOCUS_CON, WKSRecord.Service.CISCO_TNA, WKSRecord.Service.INGRES_NET}, m = "writeTo")
/* loaded from: classes3.dex */
final class MultiPartFormDataContent$writeTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f50043a;

    /* renamed from: b, reason: collision with root package name */
    public ByteWriteChannel f50044b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f50045c;

    /* renamed from: d, reason: collision with root package name */
    public Object f50046d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f50047e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ MultiPartFormDataContent f50048f;

    /* renamed from: g, reason: collision with root package name */
    public int f50049g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPartFormDataContent$writeTo$1(MultiPartFormDataContent multiPartFormDataContent, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50048f = multiPartFormDataContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50047e = obj;
        this.f50049g |= Integer.MIN_VALUE;
        return this.f50048f.d(null, this);
    }
}
