package com.chuckerteam.chucker.internal.data.room;

import androidx.room.Dao;
import androidx.room.RoomTrackingLiveData;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Dao
@Metadata
/* loaded from: classes3.dex */
public interface HttpTransactionDao {

    @Metadata
    public static final class DefaultImpls {
    }

    RoomTrackingLiveData a(String str, String str2, String str3);

    Object b(HttpTransaction httpTransaction, Continuation continuation);

    RoomTrackingLiveData c(long j2);

    RoomTrackingLiveData d();

    Object e(ContinuationImpl continuationImpl);

    Object f(HttpTransaction httpTransaction, Continuation continuation);

    Object g(SuspendLambda suspendLambda);

    Object h(long j2, Continuation continuation);
}
