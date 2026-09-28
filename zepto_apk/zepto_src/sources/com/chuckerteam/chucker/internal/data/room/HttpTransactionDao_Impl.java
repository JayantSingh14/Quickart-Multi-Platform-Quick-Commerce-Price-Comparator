package com.chuckerteam.chucker.internal.data.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RoomTrackingLiveData;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.entity.HttpTransactionTuple;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final class HttpTransactionDao_Impl implements HttpTransactionDao {

    /* renamed from: a, reason: collision with root package name */
    public final ChuckerDatabase_Impl f16726a;

    /* renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter f16727b;

    /* renamed from: c, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter f16728c;

    /* renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f16729d;

    /* renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f16730e;

    /* renamed from: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<HttpTransaction> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "INSERT OR ABORT INTO `transactions` (`id`,`requestDate`,`responseDate`,`tookMs`,`protocol`,`method`,`url`,`host`,`path`,`scheme`,`responseTlsVersion`,`responseCipherSuite`,`requestPayloadSize`,`requestContentType`,`requestHeaders`,`requestHeadersSize`,`requestBody`,`isRequestBodyEncoded`,`responseCode`,`responseMessage`,`error`,`responsePayloadSize`,`responseContentType`,`responseHeaders`,`responseHeadersSize`,`responseBody`,`isResponseBodyEncoded`,`responseImageData`,`graphQlDetected`,`graphQlOperationName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            HttpTransaction httpTransaction = (HttpTransaction) obj;
            supportSQLiteStatement.e1(1, httpTransaction.getId());
            if (httpTransaction.getRequestDate() == null) {
                supportSQLiteStatement.y1(2);
            } else {
                supportSQLiteStatement.e1(2, httpTransaction.getRequestDate().longValue());
            }
            if (httpTransaction.getResponseDate() == null) {
                supportSQLiteStatement.y1(3);
            } else {
                supportSQLiteStatement.e1(3, httpTransaction.getResponseDate().longValue());
            }
            if (httpTransaction.getTookMs() == null) {
                supportSQLiteStatement.y1(4);
            } else {
                supportSQLiteStatement.e1(4, httpTransaction.getTookMs().longValue());
            }
            if (httpTransaction.getProtocol() == null) {
                supportSQLiteStatement.y1(5);
            } else {
                supportSQLiteStatement.m(5, httpTransaction.getProtocol());
            }
            if (httpTransaction.getMethod() == null) {
                supportSQLiteStatement.y1(6);
            } else {
                supportSQLiteStatement.m(6, httpTransaction.getMethod());
            }
            if (httpTransaction.getUrl() == null) {
                supportSQLiteStatement.y1(7);
            } else {
                supportSQLiteStatement.m(7, httpTransaction.getUrl());
            }
            if (httpTransaction.getHost() == null) {
                supportSQLiteStatement.y1(8);
            } else {
                supportSQLiteStatement.m(8, httpTransaction.getHost());
            }
            if (httpTransaction.getPath() == null) {
                supportSQLiteStatement.y1(9);
            } else {
                supportSQLiteStatement.m(9, httpTransaction.getPath());
            }
            if (httpTransaction.getScheme() == null) {
                supportSQLiteStatement.y1(10);
            } else {
                supportSQLiteStatement.m(10, httpTransaction.getScheme());
            }
            if (httpTransaction.getResponseTlsVersion() == null) {
                supportSQLiteStatement.y1(11);
            } else {
                supportSQLiteStatement.m(11, httpTransaction.getResponseTlsVersion());
            }
            if (httpTransaction.getResponseCipherSuite() == null) {
                supportSQLiteStatement.y1(12);
            } else {
                supportSQLiteStatement.m(12, httpTransaction.getResponseCipherSuite());
            }
            if (httpTransaction.getRequestPayloadSize() == null) {
                supportSQLiteStatement.y1(13);
            } else {
                supportSQLiteStatement.e1(13, httpTransaction.getRequestPayloadSize().longValue());
            }
            if (httpTransaction.getRequestContentType() == null) {
                supportSQLiteStatement.y1(14);
            } else {
                supportSQLiteStatement.m(14, httpTransaction.getRequestContentType());
            }
            if (httpTransaction.getRequestHeaders() == null) {
                supportSQLiteStatement.y1(15);
            } else {
                supportSQLiteStatement.m(15, httpTransaction.getRequestHeaders());
            }
            if (httpTransaction.getRequestHeadersSize() == null) {
                supportSQLiteStatement.y1(16);
            } else {
                supportSQLiteStatement.e1(16, httpTransaction.getRequestHeadersSize().longValue());
            }
            if (httpTransaction.getRequestBody() == null) {
                supportSQLiteStatement.y1(17);
            } else {
                supportSQLiteStatement.m(17, httpTransaction.getRequestBody());
            }
            supportSQLiteStatement.e1(18, httpTransaction.isRequestBodyEncoded() ? 1L : 0L);
            if (httpTransaction.getResponseCode() == null) {
                supportSQLiteStatement.y1(19);
            } else {
                supportSQLiteStatement.e1(19, httpTransaction.getResponseCode().intValue());
            }
            if (httpTransaction.getResponseMessage() == null) {
                supportSQLiteStatement.y1(20);
            } else {
                supportSQLiteStatement.m(20, httpTransaction.getResponseMessage());
            }
            if (httpTransaction.getError() == null) {
                supportSQLiteStatement.y1(21);
            } else {
                supportSQLiteStatement.m(21, httpTransaction.getError());
            }
            if (httpTransaction.getResponsePayloadSize() == null) {
                supportSQLiteStatement.y1(22);
            } else {
                supportSQLiteStatement.e1(22, httpTransaction.getResponsePayloadSize().longValue());
            }
            if (httpTransaction.getResponseContentType() == null) {
                supportSQLiteStatement.y1(23);
            } else {
                supportSQLiteStatement.m(23, httpTransaction.getResponseContentType());
            }
            if (httpTransaction.getResponseHeaders() == null) {
                supportSQLiteStatement.y1(24);
            } else {
                supportSQLiteStatement.m(24, httpTransaction.getResponseHeaders());
            }
            if (httpTransaction.getResponseHeadersSize() == null) {
                supportSQLiteStatement.y1(25);
            } else {
                supportSQLiteStatement.e1(25, httpTransaction.getResponseHeadersSize().longValue());
            }
            if (httpTransaction.getResponseBody() == null) {
                supportSQLiteStatement.y1(26);
            } else {
                supportSQLiteStatement.m(26, httpTransaction.getResponseBody());
            }
            supportSQLiteStatement.e1(27, httpTransaction.isResponseBodyEncoded() ? 1L : 0L);
            if (httpTransaction.getResponseImageData() == null) {
                supportSQLiteStatement.y1(28);
            } else {
                supportSQLiteStatement.i1(28, httpTransaction.getResponseImageData());
            }
            supportSQLiteStatement.e1(29, httpTransaction.getGraphQlDetected() ? 1L : 0L);
            if (httpTransaction.getGraphQlOperationName() == null) {
                supportSQLiteStatement.y1(30);
            } else {
                supportSQLiteStatement.m(30, httpTransaction.getGraphQlOperationName());
            }
        }
    }

    /* renamed from: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<HttpTransaction> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE OR REPLACE `transactions` SET `id` = ?,`requestDate` = ?,`responseDate` = ?,`tookMs` = ?,`protocol` = ?,`method` = ?,`url` = ?,`host` = ?,`path` = ?,`scheme` = ?,`responseTlsVersion` = ?,`responseCipherSuite` = ?,`requestPayloadSize` = ?,`requestContentType` = ?,`requestHeaders` = ?,`requestHeadersSize` = ?,`requestBody` = ?,`isRequestBodyEncoded` = ?,`responseCode` = ?,`responseMessage` = ?,`error` = ?,`responsePayloadSize` = ?,`responseContentType` = ?,`responseHeaders` = ?,`responseHeadersSize` = ?,`responseBody` = ?,`isResponseBodyEncoded` = ?,`responseImageData` = ?,`graphQlDetected` = ?,`graphQlOperationName` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            HttpTransaction httpTransaction = (HttpTransaction) obj;
            supportSQLiteStatement.e1(1, httpTransaction.getId());
            if (httpTransaction.getRequestDate() == null) {
                supportSQLiteStatement.y1(2);
            } else {
                supportSQLiteStatement.e1(2, httpTransaction.getRequestDate().longValue());
            }
            if (httpTransaction.getResponseDate() == null) {
                supportSQLiteStatement.y1(3);
            } else {
                supportSQLiteStatement.e1(3, httpTransaction.getResponseDate().longValue());
            }
            if (httpTransaction.getTookMs() == null) {
                supportSQLiteStatement.y1(4);
            } else {
                supportSQLiteStatement.e1(4, httpTransaction.getTookMs().longValue());
            }
            if (httpTransaction.getProtocol() == null) {
                supportSQLiteStatement.y1(5);
            } else {
                supportSQLiteStatement.m(5, httpTransaction.getProtocol());
            }
            if (httpTransaction.getMethod() == null) {
                supportSQLiteStatement.y1(6);
            } else {
                supportSQLiteStatement.m(6, httpTransaction.getMethod());
            }
            if (httpTransaction.getUrl() == null) {
                supportSQLiteStatement.y1(7);
            } else {
                supportSQLiteStatement.m(7, httpTransaction.getUrl());
            }
            if (httpTransaction.getHost() == null) {
                supportSQLiteStatement.y1(8);
            } else {
                supportSQLiteStatement.m(8, httpTransaction.getHost());
            }
            if (httpTransaction.getPath() == null) {
                supportSQLiteStatement.y1(9);
            } else {
                supportSQLiteStatement.m(9, httpTransaction.getPath());
            }
            if (httpTransaction.getScheme() == null) {
                supportSQLiteStatement.y1(10);
            } else {
                supportSQLiteStatement.m(10, httpTransaction.getScheme());
            }
            if (httpTransaction.getResponseTlsVersion() == null) {
                supportSQLiteStatement.y1(11);
            } else {
                supportSQLiteStatement.m(11, httpTransaction.getResponseTlsVersion());
            }
            if (httpTransaction.getResponseCipherSuite() == null) {
                supportSQLiteStatement.y1(12);
            } else {
                supportSQLiteStatement.m(12, httpTransaction.getResponseCipherSuite());
            }
            if (httpTransaction.getRequestPayloadSize() == null) {
                supportSQLiteStatement.y1(13);
            } else {
                supportSQLiteStatement.e1(13, httpTransaction.getRequestPayloadSize().longValue());
            }
            if (httpTransaction.getRequestContentType() == null) {
                supportSQLiteStatement.y1(14);
            } else {
                supportSQLiteStatement.m(14, httpTransaction.getRequestContentType());
            }
            if (httpTransaction.getRequestHeaders() == null) {
                supportSQLiteStatement.y1(15);
            } else {
                supportSQLiteStatement.m(15, httpTransaction.getRequestHeaders());
            }
            if (httpTransaction.getRequestHeadersSize() == null) {
                supportSQLiteStatement.y1(16);
            } else {
                supportSQLiteStatement.e1(16, httpTransaction.getRequestHeadersSize().longValue());
            }
            if (httpTransaction.getRequestBody() == null) {
                supportSQLiteStatement.y1(17);
            } else {
                supportSQLiteStatement.m(17, httpTransaction.getRequestBody());
            }
            supportSQLiteStatement.e1(18, httpTransaction.isRequestBodyEncoded() ? 1L : 0L);
            if (httpTransaction.getResponseCode() == null) {
                supportSQLiteStatement.y1(19);
            } else {
                supportSQLiteStatement.e1(19, httpTransaction.getResponseCode().intValue());
            }
            if (httpTransaction.getResponseMessage() == null) {
                supportSQLiteStatement.y1(20);
            } else {
                supportSQLiteStatement.m(20, httpTransaction.getResponseMessage());
            }
            if (httpTransaction.getError() == null) {
                supportSQLiteStatement.y1(21);
            } else {
                supportSQLiteStatement.m(21, httpTransaction.getError());
            }
            if (httpTransaction.getResponsePayloadSize() == null) {
                supportSQLiteStatement.y1(22);
            } else {
                supportSQLiteStatement.e1(22, httpTransaction.getResponsePayloadSize().longValue());
            }
            if (httpTransaction.getResponseContentType() == null) {
                supportSQLiteStatement.y1(23);
            } else {
                supportSQLiteStatement.m(23, httpTransaction.getResponseContentType());
            }
            if (httpTransaction.getResponseHeaders() == null) {
                supportSQLiteStatement.y1(24);
            } else {
                supportSQLiteStatement.m(24, httpTransaction.getResponseHeaders());
            }
            if (httpTransaction.getResponseHeadersSize() == null) {
                supportSQLiteStatement.y1(25);
            } else {
                supportSQLiteStatement.e1(25, httpTransaction.getResponseHeadersSize().longValue());
            }
            if (httpTransaction.getResponseBody() == null) {
                supportSQLiteStatement.y1(26);
            } else {
                supportSQLiteStatement.m(26, httpTransaction.getResponseBody());
            }
            supportSQLiteStatement.e1(27, httpTransaction.isResponseBodyEncoded() ? 1L : 0L);
            if (httpTransaction.getResponseImageData() == null) {
                supportSQLiteStatement.y1(28);
            } else {
                supportSQLiteStatement.i1(28, httpTransaction.getResponseImageData());
            }
            supportSQLiteStatement.e1(29, httpTransaction.getGraphQlDetected() ? 1L : 0L);
            if (httpTransaction.getGraphQlOperationName() == null) {
                supportSQLiteStatement.y1(30);
            } else {
                supportSQLiteStatement.m(30, httpTransaction.getGraphQlOperationName());
            }
            supportSQLiteStatement.e1(31, httpTransaction.getId());
        }
    }

    /* renamed from: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE FROM transactions";
        }
    }

    /* renamed from: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl$4, reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE FROM transactions WHERE requestDate <= ?";
        }
    }

    public HttpTransactionDao_Impl(ChuckerDatabase_Impl database) {
        this.f16726a = database;
        Intrinsics.checkNotNullParameter(database, "database");
        this.f16727b = new AnonymousClass1(database);
        Intrinsics.checkNotNullParameter(database, "database");
        this.f16728c = new AnonymousClass2(database);
        this.f16729d = new AnonymousClass3(database);
        this.f16730e = new AnonymousClass4(database);
    }

    @Override // com.chuckerteam.chucker.internal.data.room.HttpTransactionDao
    public final RoomTrackingLiveData a(String str, String str2, String str3) {
        final RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(3, "SELECT id, requestDate, tookMs, protocol, method, host, path, scheme, responseCode, requestPayloadSize, responsePayloadSize, error, graphQLDetected, graphQlOperationName FROM transactions WHERE responseCode LIKE ? AND (path LIKE ? OR graphQlOperationName LIKE ?) ORDER BY requestDate DESC");
        roomSQLiteQueryA.m(1, str);
        roomSQLiteQueryA.m(2, str2);
        roomSQLiteQueryA.m(3, str3);
        ChuckerDatabase_Impl chuckerDatabase_Impl = this.f16726a;
        Callable<List<HttpTransactionTuple>> callable = new Callable<List<HttpTransactionTuple>>() { // from class: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl.10
            @Override // java.util.concurrent.Callable
            public final List<HttpTransactionTuple> call() {
                int i2 = 0;
                Cursor cursorB = DBUtil.b(HttpTransactionDao_Impl.this.f16726a, roomSQLiteQueryA, false);
                try {
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        arrayList.add(new HttpTransactionTuple(cursorB.getLong(i2), cursorB.isNull(1) ? null : Long.valueOf(cursorB.getLong(1)), cursorB.isNull(2) ? null : Long.valueOf(cursorB.getLong(2)), cursorB.isNull(3) ? null : cursorB.getString(3), cursorB.isNull(4) ? null : cursorB.getString(4), cursorB.isNull(5) ? null : cursorB.getString(5), cursorB.isNull(6) ? null : cursorB.getString(6), cursorB.isNull(7) ? null : cursorB.getString(7), cursorB.isNull(8) ? null : Integer.valueOf(cursorB.getInt(8)), cursorB.isNull(9) ? null : Long.valueOf(cursorB.getLong(9)), cursorB.isNull(10) ? null : Long.valueOf(cursorB.getLong(10)), cursorB.isNull(11) ? null : cursorB.getString(11), cursorB.getInt(12) != 0, cursorB.isNull(13) ? null : cursorB.getString(13)));
                        i2 = 0;
                    }
                    return arrayList;
                } finally {
                    cursorB.close();
                }
            }

            public final void finalize() {
                roomSQLiteQueryA.release();
            }
        };
        return chuckerDatabase_Impl.f11801e.a(new String[]{"transactions"}, callable);
    }

    @Override // com.chuckerteam.chucker.internal.data.room.HttpTransactionDao
    public final Object b(final HttpTransaction httpTransaction, Continuation continuation) {
        return CoroutinesRoom.b(this.f16726a, new Callable<Long>() { // from class: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl.5
            @Override // java.util.concurrent.Callable
            public final Long call() {
                HttpTransactionDao_Impl httpTransactionDao_Impl = HttpTransactionDao_Impl.this;
                ChuckerDatabase_Impl chuckerDatabase_Impl = httpTransactionDao_Impl.f16726a;
                chuckerDatabase_Impl.c();
                try {
                    EntityInsertionAdapter entityInsertionAdapter = httpTransactionDao_Impl.f16727b;
                    HttpTransaction httpTransaction2 = httpTransaction;
                    SupportSQLiteStatement supportSQLiteStatementA = entityInsertionAdapter.a();
                    try {
                        entityInsertionAdapter.e(supportSQLiteStatementA, httpTransaction2);
                        long jF0 = supportSQLiteStatementA.F0();
                        entityInsertionAdapter.d(supportSQLiteStatementA);
                        Long lValueOf = Long.valueOf(jF0);
                        chuckerDatabase_Impl.o();
                        return lValueOf;
                    } catch (Throwable th) {
                        entityInsertionAdapter.d(supportSQLiteStatementA);
                        throw th;
                    }
                } finally {
                    chuckerDatabase_Impl.j();
                }
            }
        }, (ContinuationImpl) continuation);
    }

    @Override // com.chuckerteam.chucker.internal.data.room.HttpTransactionDao
    public final RoomTrackingLiveData c(long j2) {
        final RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT * FROM transactions WHERE id = ?");
        roomSQLiteQueryA.e1(1, j2);
        ChuckerDatabase_Impl chuckerDatabase_Impl = this.f16726a;
        Callable<HttpTransaction> callable = new Callable<HttpTransaction>() { // from class: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl.11
            @Override // java.util.concurrent.Callable
            public final HttpTransaction call() {
                Cursor cursorB = DBUtil.b(HttpTransactionDao_Impl.this.f16726a, roomSQLiteQueryA, false);
                try {
                    int iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
                    int iB2 = CursorUtil.b(cursorB, "requestDate");
                    int iB3 = CursorUtil.b(cursorB, "responseDate");
                    int iB4 = CursorUtil.b(cursorB, "tookMs");
                    int iB5 = CursorUtil.b(cursorB, "protocol");
                    int iB6 = CursorUtil.b(cursorB, "method");
                    int iB7 = CursorUtil.b(cursorB, "url");
                    int iB8 = CursorUtil.b(cursorB, "host");
                    int iB9 = CursorUtil.b(cursorB, "path");
                    int iB10 = CursorUtil.b(cursorB, "scheme");
                    int iB11 = CursorUtil.b(cursorB, "responseTlsVersion");
                    int iB12 = CursorUtil.b(cursorB, "responseCipherSuite");
                    int iB13 = CursorUtil.b(cursorB, "requestPayloadSize");
                    int iB14 = CursorUtil.b(cursorB, "requestContentType");
                    int iB15 = CursorUtil.b(cursorB, "requestHeaders");
                    int iB16 = CursorUtil.b(cursorB, "requestHeadersSize");
                    int iB17 = CursorUtil.b(cursorB, "requestBody");
                    int iB18 = CursorUtil.b(cursorB, "isRequestBodyEncoded");
                    int iB19 = CursorUtil.b(cursorB, APayConstants.RESPONSE_CODE);
                    int iB20 = CursorUtil.b(cursorB, "responseMessage");
                    int iB21 = CursorUtil.b(cursorB, "error");
                    int iB22 = CursorUtil.b(cursorB, "responsePayloadSize");
                    int iB23 = CursorUtil.b(cursorB, "responseContentType");
                    int iB24 = CursorUtil.b(cursorB, "responseHeaders");
                    int iB25 = CursorUtil.b(cursorB, "responseHeadersSize");
                    int iB26 = CursorUtil.b(cursorB, "responseBody");
                    int iB27 = CursorUtil.b(cursorB, "isResponseBodyEncoded");
                    int iB28 = CursorUtil.b(cursorB, "responseImageData");
                    int iB29 = CursorUtil.b(cursorB, "graphQlDetected");
                    int iB30 = CursorUtil.b(cursorB, "graphQlOperationName");
                    HttpTransaction httpTransaction = null;
                    if (cursorB.moveToFirst()) {
                        httpTransaction = new HttpTransaction(cursorB.getLong(iB), cursorB.isNull(iB2) ? null : Long.valueOf(cursorB.getLong(iB2)), cursorB.isNull(iB3) ? null : Long.valueOf(cursorB.getLong(iB3)), cursorB.isNull(iB4) ? null : Long.valueOf(cursorB.getLong(iB4)), cursorB.isNull(iB5) ? null : cursorB.getString(iB5), cursorB.isNull(iB6) ? null : cursorB.getString(iB6), cursorB.isNull(iB7) ? null : cursorB.getString(iB7), cursorB.isNull(iB8) ? null : cursorB.getString(iB8), cursorB.isNull(iB9) ? null : cursorB.getString(iB9), cursorB.isNull(iB10) ? null : cursorB.getString(iB10), cursorB.isNull(iB11) ? null : cursorB.getString(iB11), cursorB.isNull(iB12) ? null : cursorB.getString(iB12), cursorB.isNull(iB13) ? null : Long.valueOf(cursorB.getLong(iB13)), cursorB.isNull(iB14) ? null : cursorB.getString(iB14), cursorB.isNull(iB15) ? null : cursorB.getString(iB15), cursorB.isNull(iB16) ? null : Long.valueOf(cursorB.getLong(iB16)), cursorB.isNull(iB17) ? null : cursorB.getString(iB17), cursorB.getInt(iB18) != 0, cursorB.isNull(iB19) ? null : Integer.valueOf(cursorB.getInt(iB19)), cursorB.isNull(iB20) ? null : cursorB.getString(iB20), cursorB.isNull(iB21) ? null : cursorB.getString(iB21), cursorB.isNull(iB22) ? null : Long.valueOf(cursorB.getLong(iB22)), cursorB.isNull(iB23) ? null : cursorB.getString(iB23), cursorB.isNull(iB24) ? null : cursorB.getString(iB24), cursorB.isNull(iB25) ? null : Long.valueOf(cursorB.getLong(iB25)), cursorB.isNull(iB26) ? null : cursorB.getString(iB26), cursorB.getInt(iB27) != 0, cursorB.isNull(iB28) ? null : cursorB.getBlob(iB28), cursorB.getInt(iB29) != 0, cursorB.isNull(iB30) ? null : cursorB.getString(iB30));
                    }
                    return httpTransaction;
                } finally {
                    cursorB.close();
                }
            }

            public final void finalize() {
                roomSQLiteQueryA.release();
            }
        };
        return chuckerDatabase_Impl.f11801e.a(new String[]{"transactions"}, callable);
    }

    @Override // com.chuckerteam.chucker.internal.data.room.HttpTransactionDao
    public final RoomTrackingLiveData d() {
        final RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(0, "SELECT id, requestDate, tookMs, protocol, method, host, path, scheme, responseCode, requestPayloadSize, responsePayloadSize, error, graphQLDetected, graphQlOperationName FROM transactions ORDER BY requestDate DESC");
        ChuckerDatabase_Impl chuckerDatabase_Impl = this.f16726a;
        Callable<List<HttpTransactionTuple>> callable = new Callable<List<HttpTransactionTuple>>() { // from class: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl.9
            @Override // java.util.concurrent.Callable
            public final List<HttpTransactionTuple> call() {
                int i2 = 0;
                Cursor cursorB = DBUtil.b(HttpTransactionDao_Impl.this.f16726a, roomSQLiteQueryA, false);
                try {
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        arrayList.add(new HttpTransactionTuple(cursorB.getLong(i2), cursorB.isNull(1) ? null : Long.valueOf(cursorB.getLong(1)), cursorB.isNull(2) ? null : Long.valueOf(cursorB.getLong(2)), cursorB.isNull(3) ? null : cursorB.getString(3), cursorB.isNull(4) ? null : cursorB.getString(4), cursorB.isNull(5) ? null : cursorB.getString(5), cursorB.isNull(6) ? null : cursorB.getString(6), cursorB.isNull(7) ? null : cursorB.getString(7), cursorB.isNull(8) ? null : Integer.valueOf(cursorB.getInt(8)), cursorB.isNull(9) ? null : Long.valueOf(cursorB.getLong(9)), cursorB.isNull(10) ? null : Long.valueOf(cursorB.getLong(10)), cursorB.isNull(11) ? null : cursorB.getString(11), cursorB.getInt(12) != 0, cursorB.isNull(13) ? null : cursorB.getString(13)));
                        i2 = 0;
                    }
                    return arrayList;
                } finally {
                    cursorB.close();
                }
            }

            public final void finalize() {
                roomSQLiteQueryA.release();
            }
        };
        return chuckerDatabase_Impl.f11801e.a(new String[]{"transactions"}, callable);
    }

    @Override // com.chuckerteam.chucker.internal.data.room.HttpTransactionDao
    public final Object e(ContinuationImpl continuationImpl) {
        final RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(0, "SELECT * FROM transactions");
        return CoroutinesRoom.a(this.f16726a, new CancellationSignal(), new Callable<List<HttpTransaction>>() { // from class: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl.12
            @Override // java.util.concurrent.Callable
            public final List<HttpTransaction> call() throws Throwable {
                RoomSQLiteQuery roomSQLiteQuery;
                int iB;
                int iB2;
                int iB3;
                int iB4;
                int iB5;
                int iB6;
                int iB7;
                int iB8;
                int iB9;
                int iB10;
                int iB11;
                int iB12;
                int iB13;
                int iB14;
                int i2;
                int i3;
                String string;
                int i4;
                int i5;
                String str;
                int i6;
                int i7;
                Long l2;
                int i8;
                int i9;
                String str2;
                int i10;
                int i11;
                boolean z;
                Integer numValueOf;
                int i12;
                int i13;
                String string2;
                int i14;
                int i15;
                String string3;
                int i16;
                int i17;
                Long lValueOf;
                int i18;
                int i19;
                String string4;
                int i20;
                int i21;
                String string5;
                int i22;
                int i23;
                Long lValueOf2;
                int i24;
                int i25;
                String string6;
                int i26;
                int i27;
                ChuckerDatabase_Impl chuckerDatabase_Impl = HttpTransactionDao_Impl.this.f16726a;
                RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQueryA;
                Cursor cursorB = DBUtil.b(chuckerDatabase_Impl, roomSQLiteQuery2, false);
                try {
                    iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
                    iB2 = CursorUtil.b(cursorB, "requestDate");
                    iB3 = CursorUtil.b(cursorB, "responseDate");
                    iB4 = CursorUtil.b(cursorB, "tookMs");
                    iB5 = CursorUtil.b(cursorB, "protocol");
                    iB6 = CursorUtil.b(cursorB, "method");
                    iB7 = CursorUtil.b(cursorB, "url");
                    iB8 = CursorUtil.b(cursorB, "host");
                    iB9 = CursorUtil.b(cursorB, "path");
                    iB10 = CursorUtil.b(cursorB, "scheme");
                    iB11 = CursorUtil.b(cursorB, "responseTlsVersion");
                    iB12 = CursorUtil.b(cursorB, "responseCipherSuite");
                    iB13 = CursorUtil.b(cursorB, "requestPayloadSize");
                    iB14 = CursorUtil.b(cursorB, "requestContentType");
                    roomSQLiteQuery = roomSQLiteQuery2;
                } catch (Throwable th) {
                    th = th;
                    roomSQLiteQuery = roomSQLiteQuery2;
                }
                try {
                    int iB15 = CursorUtil.b(cursorB, "requestHeaders");
                    int iB16 = CursorUtil.b(cursorB, "requestHeadersSize");
                    int iB17 = CursorUtil.b(cursorB, "requestBody");
                    int iB18 = CursorUtil.b(cursorB, "isRequestBodyEncoded");
                    int iB19 = CursorUtil.b(cursorB, APayConstants.RESPONSE_CODE);
                    int iB20 = CursorUtil.b(cursorB, "responseMessage");
                    int iB21 = CursorUtil.b(cursorB, "error");
                    int iB22 = CursorUtil.b(cursorB, "responsePayloadSize");
                    int iB23 = CursorUtil.b(cursorB, "responseContentType");
                    int iB24 = CursorUtil.b(cursorB, "responseHeaders");
                    int iB25 = CursorUtil.b(cursorB, "responseHeadersSize");
                    int iB26 = CursorUtil.b(cursorB, "responseBody");
                    int iB27 = CursorUtil.b(cursorB, "isResponseBodyEncoded");
                    int iB28 = CursorUtil.b(cursorB, "responseImageData");
                    int iB29 = CursorUtil.b(cursorB, "graphQlDetected");
                    int iB30 = CursorUtil.b(cursorB, "graphQlOperationName");
                    int i28 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        long j2 = cursorB.getLong(iB);
                        Long lValueOf3 = cursorB.isNull(iB2) ? null : Long.valueOf(cursorB.getLong(iB2));
                        Long lValueOf4 = cursorB.isNull(iB3) ? null : Long.valueOf(cursorB.getLong(iB3));
                        Long lValueOf5 = cursorB.isNull(iB4) ? null : Long.valueOf(cursorB.getLong(iB4));
                        String string7 = cursorB.isNull(iB5) ? null : cursorB.getString(iB5);
                        String string8 = cursorB.isNull(iB6) ? null : cursorB.getString(iB6);
                        String string9 = cursorB.isNull(iB7) ? null : cursorB.getString(iB7);
                        String string10 = cursorB.isNull(iB8) ? null : cursorB.getString(iB8);
                        String string11 = cursorB.isNull(iB9) ? null : cursorB.getString(iB9);
                        String string12 = cursorB.isNull(iB10) ? null : cursorB.getString(iB10);
                        String string13 = cursorB.isNull(iB11) ? null : cursorB.getString(iB11);
                        String string14 = cursorB.isNull(iB12) ? null : cursorB.getString(iB12);
                        Long lValueOf6 = cursorB.isNull(iB13) ? null : Long.valueOf(cursorB.getLong(iB13));
                        int i29 = i28;
                        if (cursorB.isNull(i29)) {
                            int i30 = iB15;
                            i2 = iB;
                            i3 = i30;
                            string = null;
                        } else {
                            int i31 = iB15;
                            i2 = iB;
                            i3 = i31;
                            string = cursorB.getString(i29);
                        }
                        if (cursorB.isNull(i3)) {
                            int i32 = iB16;
                            i4 = i3;
                            i5 = i32;
                            str = null;
                        } else {
                            String string15 = cursorB.getString(i3);
                            int i33 = iB16;
                            i4 = i3;
                            i5 = i33;
                            str = string15;
                        }
                        if (cursorB.isNull(i5)) {
                            int i34 = iB17;
                            i6 = i5;
                            i7 = i34;
                            l2 = null;
                        } else {
                            Long lValueOf7 = Long.valueOf(cursorB.getLong(i5));
                            int i35 = iB17;
                            i6 = i5;
                            i7 = i35;
                            l2 = lValueOf7;
                        }
                        if (cursorB.isNull(i7)) {
                            int i36 = iB18;
                            i8 = i7;
                            i9 = i36;
                            str2 = null;
                        } else {
                            String string16 = cursorB.getString(i7);
                            int i37 = iB18;
                            i8 = i7;
                            i9 = i37;
                            str2 = string16;
                        }
                        boolean z2 = true;
                        if (cursorB.getInt(i9) != 0) {
                            i10 = i9;
                            i11 = iB19;
                            z = true;
                        } else {
                            i10 = i9;
                            i11 = iB19;
                            z = true;
                            z2 = false;
                        }
                        if (cursorB.isNull(i11)) {
                            int i38 = iB20;
                            i12 = i11;
                            i13 = i38;
                            numValueOf = null;
                        } else {
                            numValueOf = Integer.valueOf(cursorB.getInt(i11));
                            int i39 = iB20;
                            i12 = i11;
                            i13 = i39;
                        }
                        if (cursorB.isNull(i13)) {
                            int i40 = iB21;
                            i14 = i13;
                            i15 = i40;
                            string2 = null;
                        } else {
                            string2 = cursorB.getString(i13);
                            int i41 = iB21;
                            i14 = i13;
                            i15 = i41;
                        }
                        if (cursorB.isNull(i15)) {
                            int i42 = iB22;
                            i16 = i15;
                            i17 = i42;
                            string3 = null;
                        } else {
                            string3 = cursorB.getString(i15);
                            int i43 = iB22;
                            i16 = i15;
                            i17 = i43;
                        }
                        if (cursorB.isNull(i17)) {
                            int i44 = iB23;
                            i18 = i17;
                            i19 = i44;
                            lValueOf = null;
                        } else {
                            lValueOf = Long.valueOf(cursorB.getLong(i17));
                            int i45 = iB23;
                            i18 = i17;
                            i19 = i45;
                        }
                        if (cursorB.isNull(i19)) {
                            int i46 = iB24;
                            i20 = i19;
                            i21 = i46;
                            string4 = null;
                        } else {
                            string4 = cursorB.getString(i19);
                            int i47 = iB24;
                            i20 = i19;
                            i21 = i47;
                        }
                        if (cursorB.isNull(i21)) {
                            int i48 = iB25;
                            i22 = i21;
                            i23 = i48;
                            string5 = null;
                        } else {
                            string5 = cursorB.getString(i21);
                            int i49 = iB25;
                            i22 = i21;
                            i23 = i49;
                        }
                        if (cursorB.isNull(i23)) {
                            int i50 = iB26;
                            i24 = i23;
                            i25 = i50;
                            lValueOf2 = null;
                        } else {
                            lValueOf2 = Long.valueOf(cursorB.getLong(i23));
                            int i51 = iB26;
                            i24 = i23;
                            i25 = i51;
                        }
                        if (cursorB.isNull(i25)) {
                            int i52 = iB27;
                            i26 = i25;
                            i27 = i52;
                            string6 = null;
                        } else {
                            string6 = cursorB.getString(i25);
                            int i53 = iB27;
                            i26 = i25;
                            i27 = i53;
                        }
                        boolean z3 = cursorB.getInt(i27) != 0 ? z : false;
                        int i54 = i27;
                        int i55 = iB28;
                        byte[] blob = cursorB.isNull(i55) ? null : cursorB.getBlob(i55);
                        iB28 = i55;
                        int i56 = iB29;
                        boolean z4 = cursorB.getInt(i56) != 0 ? z : false;
                        iB29 = i56;
                        int i57 = iB30;
                        iB30 = i57;
                        arrayList.add(new HttpTransaction(j2, lValueOf3, lValueOf4, lValueOf5, string7, string8, string9, string10, string11, string12, string13, string14, lValueOf6, string, str, l2, str2, z2, numValueOf, string2, string3, lValueOf, string4, string5, lValueOf2, string6, z3, blob, z4, cursorB.isNull(i57) ? null : cursorB.getString(i57)));
                        iB = i2;
                        iB15 = i4;
                        iB16 = i6;
                        iB17 = i8;
                        iB19 = i12;
                        iB20 = i14;
                        iB21 = i16;
                        iB22 = i18;
                        iB23 = i20;
                        iB24 = i22;
                        iB25 = i24;
                        iB26 = i26;
                        iB18 = i10;
                        iB27 = i54;
                        i28 = i29;
                    }
                    cursorB.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cursorB.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            }
        }, continuationImpl);
    }

    @Override // com.chuckerteam.chucker.internal.data.room.HttpTransactionDao
    public final Object f(final HttpTransaction httpTransaction, Continuation continuation) {
        return CoroutinesRoom.b(this.f16726a, new Callable<Integer>() { // from class: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl.6
            @Override // java.util.concurrent.Callable
            public final Integer call() {
                HttpTransactionDao_Impl httpTransactionDao_Impl = HttpTransactionDao_Impl.this;
                ChuckerDatabase_Impl chuckerDatabase_Impl = httpTransactionDao_Impl.f16726a;
                chuckerDatabase_Impl.c();
                try {
                    EntityDeletionOrUpdateAdapter entityDeletionOrUpdateAdapter = httpTransactionDao_Impl.f16728c;
                    HttpTransaction httpTransaction2 = httpTransaction;
                    SupportSQLiteStatement supportSQLiteStatementA = entityDeletionOrUpdateAdapter.a();
                    try {
                        entityDeletionOrUpdateAdapter.e(supportSQLiteStatementA, httpTransaction2);
                        int iH = supportSQLiteStatementA.H();
                        entityDeletionOrUpdateAdapter.d(supportSQLiteStatementA);
                        chuckerDatabase_Impl.o();
                        return Integer.valueOf(iH);
                    } catch (Throwable th) {
                        entityDeletionOrUpdateAdapter.d(supportSQLiteStatementA);
                        throw th;
                    }
                } finally {
                    chuckerDatabase_Impl.j();
                }
            }
        }, (ContinuationImpl) continuation);
    }

    @Override // com.chuckerteam.chucker.internal.data.room.HttpTransactionDao
    public final Object g(SuspendLambda suspendLambda) {
        return CoroutinesRoom.b(this.f16726a, new Callable<Integer>() { // from class: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl.7
            @Override // java.util.concurrent.Callable
            public final Integer call() {
                HttpTransactionDao_Impl httpTransactionDao_Impl = HttpTransactionDao_Impl.this;
                SharedSQLiteStatement sharedSQLiteStatement = httpTransactionDao_Impl.f16729d;
                ChuckerDatabase_Impl chuckerDatabase_Impl = httpTransactionDao_Impl.f16726a;
                SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
                try {
                    chuckerDatabase_Impl.c();
                    try {
                        Integer numValueOf = Integer.valueOf(supportSQLiteStatementA.H());
                        chuckerDatabase_Impl.o();
                        return numValueOf;
                    } finally {
                        chuckerDatabase_Impl.j();
                    }
                } finally {
                    sharedSQLiteStatement.d(supportSQLiteStatementA);
                }
            }
        }, suspendLambda);
    }

    @Override // com.chuckerteam.chucker.internal.data.room.HttpTransactionDao
    public final Object h(final long j2, Continuation continuation) {
        return CoroutinesRoom.b(this.f16726a, new Callable<Integer>() { // from class: com.chuckerteam.chucker.internal.data.room.HttpTransactionDao_Impl.8
            @Override // java.util.concurrent.Callable
            public final Integer call() {
                HttpTransactionDao_Impl httpTransactionDao_Impl = HttpTransactionDao_Impl.this;
                SharedSQLiteStatement sharedSQLiteStatement = httpTransactionDao_Impl.f16730e;
                ChuckerDatabase_Impl chuckerDatabase_Impl = httpTransactionDao_Impl.f16726a;
                SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
                supportSQLiteStatementA.e1(1, j2);
                try {
                    chuckerDatabase_Impl.c();
                    try {
                        Integer numValueOf = Integer.valueOf(supportSQLiteStatementA.H());
                        chuckerDatabase_Impl.o();
                        return numValueOf;
                    } finally {
                        chuckerDatabase_Impl.j();
                    }
                } finally {
                    sharedSQLiteStatement.d(supportSQLiteStatementA);
                }
            }
        }, (ContinuationImpl) continuation);
    }
}
