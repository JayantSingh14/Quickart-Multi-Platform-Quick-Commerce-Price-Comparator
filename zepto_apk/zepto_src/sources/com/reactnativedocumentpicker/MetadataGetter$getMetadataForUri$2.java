package com.reactnativedocumentpicker;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.reactnativedocumentpicker.MetadataGetter$getMetadataForUri$2", f = "MetadataGetter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class MetadataGetter$getMetadataForUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DocumentMetadataBuilder>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f46356a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f46357b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PickOptions f46358c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MetadataGetter f46359d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataGetter$getMetadataForUri$2(ReactApplicationContext reactApplicationContext, Uri uri, PickOptions pickOptions, MetadataGetter metadataGetter, Continuation continuation) {
        super(2, continuation);
        this.f46356a = reactApplicationContext;
        this.f46357b = uri;
        this.f46358c = pickOptions;
        this.f46359d = metadataGetter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MetadataGetter$getMetadataForUri$2(this.f46356a, this.f46357b, this.f46358c, this.f46359d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MetadataGetter$getMetadataForUri$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        ReactApplicationContext reactApplicationContext = this.f46356a;
        ContentResolver contentResolver = reactApplicationContext.getContentResolver();
        Uri bookmark = this.f46357b;
        DocumentMetadataBuilder documentMetadataBuilder = new DocumentMetadataBuilder(bookmark);
        documentMetadataBuilder.f46334d = contentResolver.getType(bookmark);
        PickOptions pickOptions = this.f46358c;
        if (pickOptions.f46377g) {
            documentMetadataBuilder.f46336f = contentResolver.getStreamTypes(bookmark, "*/*");
        }
        if (pickOptions.f46376f) {
            try {
                reactApplicationContext.getContentResolver().takePersistableUriPermission(bookmark, 3);
                Intrinsics.checkNotNullParameter(bookmark, "bookmark");
                documentMetadataBuilder.f46337g = bookmark.toString();
            } catch (Exception e2) {
                String localizedMessage = e2.getLocalizedMessage();
                if (localizedMessage == null && (localizedMessage = e2.getMessage()) == null) {
                    localizedMessage = "Unknown error with takePersistableUriPermission";
                }
                documentMetadataBuilder.f46338h = localizedMessage;
            }
        }
        boolean z = pickOptions.f46377g && DocumentsContract.isDocumentUri(reactApplicationContext, bookmark);
        this.f46359d.getClass();
        MetadataGetter.c(contentResolver, documentMetadataBuilder, z);
        return documentMetadataBuilder;
    }
}
