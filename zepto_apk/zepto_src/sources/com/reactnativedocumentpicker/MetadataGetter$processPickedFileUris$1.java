package com.reactnativedocumentpicker;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.reactnativedocumentpicker.MetadataGetter", f = "MetadataGetter.kt", l = {24}, m = "processPickedFileUris")
/* loaded from: classes4.dex */
final class MetadataGetter$processPickedFileUris$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f46360a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MetadataGetter f46361b;

    /* renamed from: c, reason: collision with root package name */
    public int f46362c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataGetter$processPickedFileUris$1(MetadataGetter metadataGetter, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f46361b = metadataGetter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46360a = obj;
        this.f46362c |= Integer.MIN_VALUE;
        return this.f46361b.b(null, null, null, this);
    }
}
