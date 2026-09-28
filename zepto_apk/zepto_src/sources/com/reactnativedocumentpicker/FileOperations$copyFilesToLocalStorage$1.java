package com.reactnativedocumentpicker;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.reactnativedocumentpicker.FileOperations", f = "FileOperations.kt", l = {30}, m = "copyFilesToLocalStorage")
/* loaded from: classes4.dex */
final class FileOperations$copyFilesToLocalStorage$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f46341a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileOperations f46342b;

    /* renamed from: c, reason: collision with root package name */
    public int f46343c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileOperations$copyFilesToLocalStorage$1(FileOperations fileOperations, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f46342b = fileOperations;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46341a = obj;
        this.f46343c |= Integer.MIN_VALUE;
        return this.f46342b.b(null, null, null, this);
    }
}
