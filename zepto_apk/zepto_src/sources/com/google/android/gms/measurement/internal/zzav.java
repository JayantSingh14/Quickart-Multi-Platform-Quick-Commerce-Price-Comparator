package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.media.b;
import android.text.TextUtils;
import androidx.fragment.app.e;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.pal.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
final class zzav extends zzor {

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f38723f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f38724g = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f38725h = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f38726i = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f38727j = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f38728k = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f38729l = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f38730m = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] n = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public static final String[] o = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    public static final String[] p = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* renamed from: d, reason: collision with root package name */
    public final zzau f38731d;

    /* renamed from: e, reason: collision with root package name */
    public final zzof f38732e;

    public zzav(zzpf zzpfVar) {
        super(zzpfVar);
        this.f38732e = new zzof(this.f39180a.f39094k);
        this.f39180a.getClass();
        this.f38731d = new zzau(this, this.f39180a.f39084a);
    }

    public static final String L(ArrayList arrayList) {
        return arrayList.isEmpty() ? "" : b.D(" AND (upload_type IN (", TextUtils.join(", ", arrayList), "))");
    }

    public static final void T(ContentValues contentValues, Object obj) {
        Preconditions.checkNotEmpty(CLConstants.FIELD_PAY_INFO_VALUE);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(CLConstants.FIELD_PAY_INFO_VALUE, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(CLConstants.FIELD_PAY_INFO_VALUE, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(CLConstants.FIELD_PAY_INFO_VALUE, (Double) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x029d A[Catch: SQLiteException -> 0x02b7, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x02b7, blocks: (B:94:0x0282, B:96:0x029d), top: B:109:0x0282 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(java.lang.String r26, java.lang.Long r27, java.lang.String r28, android.os.Bundle r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.A(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzjk B(java.lang.String r5) {
        /*
            r4 = this;
            com.google.android.gms.measurement.internal.zzib r0 = r4.f39180a
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            r4.g()
            r4.h()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r1 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.X()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            android.database.Cursor r5 = r3.rawQuery(r1, r5)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            boolean r1 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzgt r1 = r0.f39089f     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            com.google.android.gms.measurement.internal.zzib.l(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            com.google.android.gms.measurement.internal.zzgr r1 = r1.n     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            java.lang.String r3 = "No data found"
            r1.a(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
        L2c:
            r5.close()
            goto L5a
        L30:
            r0 = move-exception
            goto L43
        L32:
            r1 = move-exception
            goto L4b
        L34:
            r1 = 0
            java.lang.String r1 = r5.getString(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            r3 = 1
            int r3 = r5.getInt(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            com.google.android.gms.measurement.internal.zzjk r2 = com.google.android.gms.measurement.internal.zzjk.c(r3, r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            goto L2c
        L43:
            r2 = r5
            goto L60
        L45:
            r5 = move-exception
            r0 = r5
            goto L60
        L48:
            r5 = move-exception
            r1 = r5
            r5 = r2
        L4b:
            com.google.android.gms.measurement.internal.zzgt r0 = r0.f39089f     // Catch: java.lang.Throwable -> L30
            com.google.android.gms.measurement.internal.zzib.l(r0)     // Catch: java.lang.Throwable -> L30
            com.google.android.gms.measurement.internal.zzgr r0 = r0.f38958f     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Error querying database."
            r0.b(r1, r3)     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L5a
            goto L2c
        L5a:
            if (r2 != 0) goto L5f
            com.google.android.gms.measurement.internal.zzjk r5 = com.google.android.gms.measurement.internal.zzjk.f39198c
            return r5
        L5f:
            return r2
        L60:
            if (r2 == 0) goto L65
            r2.close()
        L65:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.B(java.lang.String):com.google.android.gms.measurement.internal.zzjk");
    }

    public final long C(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = X().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e2) {
                zzgt zzgtVar = this.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long D(long j2, String str, String[] strArr) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = X().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j2 = cursorRawQuery.getLong(0);
                }
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e2) {
                zzgt zzgtVar = this.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final String E(String str, String[] strArr) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = X().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return "";
                }
                String string = cursorRawQuery.getString(0);
                cursorRawQuery.close();
                return string;
            } catch (SQLiteException e2) {
                zzgt zzgtVar = this.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final void F(ContentValues contentValues) {
        zzib zzibVar = this.f39180a;
        try {
            SQLiteDatabase sQLiteDatabaseX = X();
            if (contentValues.getAsString("app_id") == null) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38960h.b(zzgt.o("app_id"), "Value of the primary key is not set.");
                return;
            }
            new StringBuilder(10).append("app_id = ?");
            if (sQLiteDatabaseX.update("consent_settings", contentValues, r6.toString(), new String[]{r5}) == 0 && sQLiteDatabaseX.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.c("Failed to insert/update table (got -1). key", zzgt.o("consent_settings"), zzgt.o("app_id"));
            }
        } catch (SQLiteException e2) {
            zzgt zzgtVar3 = zzibVar.f39089f;
            zzib.l(zzgtVar3);
            zzgtVar3.f38958f.d("Error storing into table. key", zzgt.o("consent_settings"), zzgt.o("app_id"), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzbc G(java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.G(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbc");
    }

    public final void H(String str, zzbc zzbcVar) {
        zzib zzibVar = this.f39180a;
        Preconditions.checkNotNull(zzbcVar);
        g();
        h();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbcVar.f38756a;
        contentValues.put("app_id", str2);
        contentValues.put(CLConstants.FIELD_PAY_INFO_NAME, zzbcVar.f38757b);
        contentValues.put("lifetime_count", Long.valueOf(zzbcVar.f38758c));
        contentValues.put("current_bundle_count", Long.valueOf(zzbcVar.f38759d));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbcVar.f38761f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbcVar.f38762g));
        contentValues.put("last_bundled_day", zzbcVar.f38763h);
        contentValues.put("last_sampled_complex_event_id", zzbcVar.f38764i);
        contentValues.put("last_sampling_rate", zzbcVar.f38765j);
        contentValues.put("current_session_count", Long.valueOf(zzbcVar.f38760e));
        Boolean bool = zzbcVar.f38766k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (X().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.b(zzgt.o(str2), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Error storing event aggregates. appId", zzgt.o(zzbcVar.f38756a), e2);
        }
    }

    public final void I(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        g();
        h();
        try {
            X().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("Error deleting snapshot. appId", zzgt.o(str2), e2);
        }
    }

    public final zzpi J(String str, long j2, byte[] bArr, String str2, String str3, int i2, int i3, long j3, long j4, long j5) {
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        zzib zzibVar = this.f39180a;
        if (zIsEmpty) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38965m.a("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpj.O(com.google.android.gms.internal.measurement.zzib.z(), bArr);
            zzlr zzlrVarA = zzlr.a(i2);
            if (zzlrVarA != zzlr.GOOGLE_SIGNAL && zzlrVarA != zzlr.GOOGLE_SIGNAL_PENDING && i3 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhzVar.o().iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) it.next()).m();
                    zzicVar.i();
                    ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).X0(i3);
                    arrayList.add((com.google.android.gms.internal.measurement.zzid) zzicVar.l());
                }
                zzhzVar.v();
                zzhzVar.u(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split("\r\n");
                int length = strArrSplit.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    String str4 = strArrSplit[i4];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split("=", 2);
                    if (strArrSplit2.length != 2) {
                        zzgt zzgtVar2 = zzibVar.f39089f;
                        zzib.l(zzgtVar2);
                        zzgtVar2.f38958f.b(str4, "Invalid upload header: ");
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i4++;
                }
            }
            zzph zzphVar = new zzph();
            zzphVar.b(j2);
            zzphVar.c((com.google.android.gms.internal.measurement.zzib) zzhzVar.l());
            zzphVar.d(str2);
            zzphVar.e(map);
            zzphVar.f(zzlrVarA);
            zzphVar.g(j3);
            zzphVar.h(j4);
            zzphVar.i(j5);
            zzphVar.j(i3);
            return zzphVar.a();
        } catch (IOException e2) {
            zzgt zzgtVar3 = zzibVar.f39089f;
            zzib.l(zzgtVar3);
            zzgtVar3.f38958f.c("Failed to queued MeasurementBatch from upload_queue. appId", str, e2);
            return null;
        }
    }

    public final String K() {
        long jCurrentTimeMillis = this.f39180a.f39094k.currentTimeMillis();
        Locale locale = Locale.US;
        zzlr zzlrVar = zzlr.GOOGLE_SIGNAL;
        int iZza = zzlrVar.zza();
        Long l2 = (Long) zzfx.S.a(null);
        l2.getClass();
        String str = "(upload_type = " + iZza + " AND ABS(creation_timestamp - " + jCurrentTimeMillis + ") > " + l2 + ")";
        String str2 = "(upload_type != " + zzlrVar.zza() + " AND ABS(creation_timestamp - " + jCurrentTimeMillis + ") > " + ((Long) zzfx.R.a(null)).longValue() + ")";
        StringBuilder sb = new StringBuilder(b.b(str.length(), 5, str2.length(), 1));
        b.B(sb, "(", str, " OR ", str2);
        sb.append(")");
        return sb.toString();
    }

    public final void M(String str, zzog zzogVar) {
        g();
        h();
        Preconditions.checkNotNull(zzogVar);
        Preconditions.checkNotEmpty(str);
        zzib zzibVar = this.f39180a;
        long jCurrentTimeMillis = zzibVar.f39094k.currentTimeMillis();
        zzfw zzfwVar = zzfx.v0;
        long jLongValue = jCurrentTimeMillis - ((Long) zzfwVar.a(null)).longValue();
        long j2 = zzogVar.f39545b;
        zzgt zzgtVar = zzibVar.f39089f;
        if (j2 < jLongValue || j2 > ((Long) zzfwVar.a(null)).longValue() + jCurrentTimeMillis) {
            zzib.l(zzgtVar);
            zzgtVar.f38961i.d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgt.o(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j2));
        }
        zzib.l(zzgtVar);
        zzgtVar.n.a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzogVar.f39544a);
        contentValues.put("source", Integer.valueOf(zzogVar.f39546c));
        contentValues.put("timestamp_millis", Long.valueOf(j2));
        try {
            if (X().insert("trigger_uris", null, contentValues) == -1) {
                zzib.l(zzgtVar);
                zzgtVar.f38958f.b(zzgt.o(str), "Failed to insert trigger URI (got -1). appId");
            }
        } catch (SQLiteException e2) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("Error storing trigger URI. appId", zzgt.o(str), e2);
        }
    }

    public final void N(String str, zzjk zzjkVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjkVar);
        g();
        h();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjkVar.g());
        contentValues.put("consent_source", Integer.valueOf(zzjkVar.f39200b));
        F(contentValues);
    }

    public final void O(String str, zzjk zzjkVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjkVar);
        g();
        h();
        N(str, B(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjkVar.g());
        F(contentValues);
    }

    public final zzjk P(String str) {
        Preconditions.checkNotNull(str);
        g();
        h();
        return zzjk.c(100, E("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}));
    }

    public final zzbc Q(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar, String str2) {
        zzbc zzbcVarG = G("events", str, zzhsVar.v());
        if (zzbcVarG != null) {
            long j2 = zzbcVarG.f38760e + 1;
            long j3 = zzbcVarG.f38759d + 1;
            return new zzbc(zzbcVarG.f38756a, zzbcVarG.f38757b, zzbcVarG.f38758c + 1, j3, j2, zzbcVarG.f38761f, zzbcVarG.f38762g, zzbcVarG.f38763h, zzbcVarG.f38764i, zzbcVarG.f38765j, zzbcVarG.f38766k);
        }
        zzib zzibVar = this.f39180a;
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38961i.c("Event aggregate wasn't created during raw event logging. appId, event", zzgt.o(str), zzibVar.f39093j.a(str2));
        return new zzbc(str, zzhsVar.v(), 1L, 1L, 1L, zzhsVar.x(), 0L, null, null, null, null);
    }

    public final boolean R() {
        return this.f39180a.f39084a.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee A[Catch: all -> 0x007a, SQLiteException -> 0x007d, TryCatch #4 {all -> 0x007a, blocks: (B:3:0x0018, B:8:0x002c, B:14:0x004a, B:15:0x0066, B:18:0x006e, B:19:0x0072, B:40:0x00ca, B:42:0x00ee, B:43:0x0100, B:44:0x0104, B:45:0x0114, B:47:0x011a, B:48:0x012a, B:50:0x0136, B:53:0x014a, B:55:0x0168, B:56:0x0171, B:57:0x017b, B:62:0x01b6, B:61:0x01a6, B:65:0x01bd, B:52:0x0143, B:67:0x01cf, B:71:0x01e2, B:11:0x003e, B:29:0x0089, B:31:0x008f, B:35:0x009e, B:38:0x00c2, B:32:0x0094), top: B:78:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100 A[Catch: all -> 0x007a, SQLiteException -> 0x007d, TRY_LEAVE, TryCatch #4 {all -> 0x007a, blocks: (B:3:0x0018, B:8:0x002c, B:14:0x004a, B:15:0x0066, B:18:0x006e, B:19:0x0072, B:40:0x00ca, B:42:0x00ee, B:43:0x0100, B:44:0x0104, B:45:0x0114, B:47:0x011a, B:48:0x012a, B:50:0x0136, B:53:0x014a, B:55:0x0168, B:56:0x0171, B:57:0x017b, B:62:0x01b6, B:61:0x01a6, B:65:0x01bd, B:52:0x0143, B:67:0x01cf, B:71:0x01e2, B:11:0x003e, B:29:0x0089, B:31:0x008f, B:35:0x009e, B:38:0x00c2, B:32:0x0094), top: B:78:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f4 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S(java.lang.String r21, long r22, long r24, com.google.android.gms.measurement.internal.zzpb r26) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.S(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzpb):void");
    }

    public final void U() {
        h();
        X().beginTransaction();
    }

    public final void V() {
        h();
        X().setTransactionSuccessful();
    }

    public final void W() {
        h();
        X().endTransaction();
    }

    public final SQLiteDatabase X() {
        g();
        try {
            return this.f38731d.getWritableDatabase();
        } catch (SQLiteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error opening database");
            throw e2;
        }
    }

    public final void Y(String str) {
        zzbc zzbcVarG;
        I("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = X().query("events", (String[]) Collections.singletonList(CLConstants.FIELD_PAY_INFO_NAME).toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (zzbcVarG = G("events", str, string)) != null) {
                            H("events_snapshot", zzbcVarG);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e2) {
                zzgt zzgtVar = this.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.c("Error creating snapshot. appId", zzgt.o(str), e2);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.Z(java.lang.String):void");
    }

    public final void a0(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        g();
        h();
        try {
            X().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            zzib zzibVar = this.f39180a;
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.d("Error deleting user property. appId", zzgt.o(str), zzibVar.f39093j.c(str2), e2);
        }
    }

    public final boolean b0(zzpm zzpmVar) {
        Preconditions.checkNotNull(zzpmVar);
        g();
        h();
        String str = zzpmVar.f39633a;
        String str2 = zzpmVar.f39635c;
        zzpm zzpmVarC0 = c0(str, str2);
        zzib zzibVar = this.f39180a;
        String str3 = zzpmVar.f39634b;
        if (zzpmVarC0 == null) {
            if (zzpo.d0(str2)) {
                if (C("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= Math.max(Math.min(zzibVar.f39087d.o(str, zzfx.V), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jC = C("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, str3});
                zzibVar.getClass();
                if (jC >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", str3);
        contentValues.put(CLConstants.FIELD_PAY_INFO_NAME, str2);
        contentValues.put("set_timestamp", Long.valueOf(zzpmVar.f39636d));
        T(contentValues, zzpmVar.f39637e);
        try {
            if (X().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(zzgt.o(str), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Error storing user property. appId", zzgt.o(str), e2);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzpm c0(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzib r1 = r11.f39180a
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r11.g()
            r11.h()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.X()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            java.lang.String r4 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r5 = new java.lang.String[]{r0, r5, r6}     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            java.lang.String r6 = "app_id=? and name=?"
            java.lang.String[] r7 = new java.lang.String[]{r12, r13}     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            if (r0 != 0) goto L34
            goto L92
        L34:
            r0 = 0
            long r8 = r3.getLong(r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            r0 = 1
            java.lang.Object r10 = r11.t(r3, r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            if (r10 != 0) goto L41
            goto L92
        L41:
            r0 = 2
            java.lang.String r6 = r3.getString(r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            com.google.android.gms.measurement.internal.zzpm r4 = new com.google.android.gms.measurement.internal.zzpm     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            r5 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            boolean r12 = r3.moveToNext()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            if (r12 == 0) goto L6a
            com.google.android.gms.measurement.internal.zzgt r12 = r1.f39089f     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            com.google.android.gms.measurement.internal.zzib.l(r12)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            com.google.android.gms.measurement.internal.zzgr r12 = r12.f38958f     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            java.lang.String r13 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzgt.o(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            r12.b(r0, r13)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            goto L6a
        L64:
            r0 = move-exception
            r12 = r0
            goto L72
        L67:
            r0 = move-exception
        L68:
            r12 = r0
            goto L7c
        L6a:
            r3.close()
            return r4
        L6e:
            r0 = move-exception
            r5 = r12
            r7 = r13
            goto L68
        L72:
            r2 = r3
            goto L98
        L74:
            r0 = move-exception
            r12 = r0
            goto L98
        L77:
            r0 = move-exception
            r5 = r12
            r7 = r13
            r12 = r0
            r3 = r2
        L7c:
            com.google.android.gms.measurement.internal.zzgt r13 = r1.f39089f     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.measurement.internal.zzib.l(r13)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.measurement.internal.zzgr r13 = r13.f38958f     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.o(r5)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.measurement.internal.zzgm r1 = r1.f39093j     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = r1.c(r7)     // Catch: java.lang.Throwable -> L64
            r13.d(r0, r4, r1, r12)     // Catch: java.lang.Throwable -> L64
        L92:
            if (r3 == 0) goto L97
            r3.close()
        L97:
            return r2
        L98:
            if (r2 == 0) goto L9d
            r2.close()
        L9d:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.c0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzpm");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List d0(java.lang.String r13) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.zzib r1 = r12.f39180a
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r12.g()
            r12.h()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r10 = "1000"
            r11 = 0
            android.database.sqlite.SQLiteDatabase r2 = r12.X()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r9 = "rowid"
            r1.getClass()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            boolean r2 = r11.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r2 == 0) goto L99
        L3c:
            r2 = 0
            java.lang.String r6 = r11.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2 = 1
            java.lang.String r2 = r11.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r2 != 0) goto L4a
            java.lang.String r2 = ""
        L4a:
            r5 = r2
            goto L4f
        L4c:
            r0 = move-exception
            r4 = r13
            goto L87
        L4f:
            r2 = 2
            long r7 = r11.getLong(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2 = 3
            java.lang.Object r9 = r12.t(r11, r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r9 != 0) goto L70
            com.google.android.gms.measurement.internal.zzgt r2 = r1.f39089f     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            com.google.android.gms.measurement.internal.zzib.l(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            com.google.android.gms.measurement.internal.zzgr r2 = r2.f38958f     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            java.lang.String r3 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.o(r13)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2.b(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r4 = r13
            goto L79
        L6d:
            r0 = move-exception
            r13 = r0
            goto L9f
        L70:
            com.google.android.gms.measurement.internal.zzpm r3 = new com.google.android.gms.measurement.internal.zzpm     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
            r0.add(r3)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
        L79:
            boolean r13 = r11.moveToNext()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
            if (r13 != 0) goto L80
            goto L99
        L80:
            r13 = r4
            goto L3c
        L82:
            r0 = move-exception
            goto L87
        L84:
            r0 = move-exception
            r4 = r13
            r13 = r0
        L87:
            com.google.android.gms.measurement.internal.zzgt r13 = r1.f39089f     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.measurement.internal.zzib.l(r13)     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.measurement.internal.zzgr r13 = r13.f38958f     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = "Error querying user properties. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgt.o(r4)     // Catch: java.lang.Throwable -> L6d
            r13.c(r1, r2, r0)     // Catch: java.lang.Throwable -> L6d
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> L6d
        L99:
            if (r11 == 0) goto L9e
            r11.close()
        L9e:
            return r0
        L9f:
            if (r11 == 0) goto La4
            r11.close()
        La4:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.d0(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00af, code lost:
    
        com.google.android.gms.measurement.internal.zzib.l(r8);
        r8.f38958f.b(1000, "Read more than the max allowed user properties, ignoring excess");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0132  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List e0(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.e0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean f0(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        g();
        h();
        String str = zzahVar.f38676a;
        Preconditions.checkNotNull(str);
        zzpm zzpmVarC0 = c0(str, zzahVar.f38678c.f39627b);
        zzib zzibVar = this.f39180a;
        if (zzpmVarC0 == null) {
            long jC = C("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            zzibVar.getClass();
            if (jC >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzahVar.f38677b);
        contentValues.put(CLConstants.FIELD_PAY_INFO_NAME, zzahVar.f38678c.f39627b);
        T(contentValues, Preconditions.checkNotNull(zzahVar.f38678c.b()));
        contentValues.put(AppStateModule.APP_STATE_ACTIVE, Boolean.valueOf(zzahVar.f38680e));
        contentValues.put("trigger_event_name", zzahVar.f38681f);
        contentValues.put("trigger_timeout", Long.valueOf(zzahVar.f38683h));
        zzpo zzpoVar = zzibVar.f39092i;
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.j(zzpoVar);
        contentValues.put("timed_out_event", zzpo.J(zzahVar.f38682g));
        contentValues.put("creation_timestamp", Long.valueOf(zzahVar.f38679d));
        zzib.j(zzibVar.f39092i);
        contentValues.put("triggered_event", zzpo.J(zzahVar.f38684i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzahVar.f38678c.f39628c));
        contentValues.put("time_to_live", Long.valueOf(zzahVar.f38685j));
        contentValues.put("expired_event", zzpo.J(zzahVar.f38686k));
        try {
            if (X().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(zzgt.o(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e2) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("Error storing conditional user property", zzgt.o(str), e2);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzah g0(java.lang.String r27, java.lang.String r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.g0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzah");
    }

    public final void h0(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        g();
        h();
        try {
            X().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            zzib zzibVar = this.f39180a;
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.d("Error deleting conditional property", zzgt.o(str), zzibVar.f39093j.c(str2), e2);
        }
    }

    public final List i0(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        g();
        h();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return j0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0053, code lost:
    
        r3 = r2.f39089f;
        com.google.android.gms.measurement.internal.zzib.l(r3);
        r3.f38958f.b(1000, "Read more than the max allowed conditional properties, ignoring extra");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List j0(java.lang.String r29, java.lang.String[] r30) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.j0(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final long k(String str, com.google.android.gms.internal.measurement.zzib zzibVar, String str2, Map map, zzlr zzlrVar, Long l2) {
        int iDelete;
        g();
        h();
        Preconditions.checkNotNull(zzibVar);
        Preconditions.checkNotEmpty(str);
        g();
        h();
        boolean zR = R();
        zzib zzibVar2 = this.f39180a;
        if (zR) {
            zzpf zzpfVar = this.f39551b;
            long jA = zzpfVar.f39602i.f39497f.a();
            long jElapsedRealtime = zzibVar2.f39094k.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) zzfx.M.a(null)).longValue()) {
                zzpfVar.f39602i.f39497f.b(jElapsedRealtime);
                g();
                h();
                boolean zR2 = R();
                zzgt zzgtVar = zzibVar2.f39089f;
                if (zR2 && (iDelete = X().delete("upload_queue", K(), new String[0])) > 0) {
                    zzib.l(zzgtVar);
                    zzgtVar.n.b(Integer.valueOf(iDelete), "Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted");
                }
                Preconditions.checkNotEmpty(str);
                g();
                h();
                try {
                    int iO = zzibVar2.f39087d.o(str, zzfx.A);
                    if (iO > 0) {
                        X().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iO)});
                    }
                } catch (SQLiteException e2) {
                    zzib.l(zzgtVar);
                    zzgtVar.f38958f.c("Error deleting over the limit queued batches. appId", zzgt.o(str), e2);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(e.g(1, str3) + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] bArrF = zzibVar.f();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrF);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", a.f(arrayList));
        contentValues.put("upload_type", Integer.valueOf(zzlrVar.zza()));
        Clock clock = zzibVar2.f39094k;
        zzgt zzgtVar2 = zzibVar2.f39089f;
        contentValues.put("creation_timestamp", Long.valueOf(clock.currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l2 != null) {
            contentValues.put("associated_row_id", l2);
        }
        try {
            long jInsert = X().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(str, "Failed to insert MeasurementBatch (got -1) to upload_queue. appId");
            return -1L;
        } catch (SQLiteException e3) {
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Error storing MeasurementBatch to upload_queue. appId", str, e3);
            return -1L;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x03cf: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:976), block:B:116:0x03cf */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzh k0(java.lang.String r53) {
        /*
            Method dump skipped, instructions count: 1009
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.k0(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List l(java.lang.String r19, com.google.android.gms.measurement.internal.zzon r20, int r21) throws java.lang.Throwable {
        /*
            r18 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            r18.g()
            r18.h()
            java.lang.String r0 = " AND NOT "
            java.lang.String r1 = "app_id=?"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r18.X()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r4 = "upload_queue"
            java.lang.String r5 = "rowId"
            java.lang.String r6 = "app_id"
            java.lang.String r7 = "measurement_batch"
            java.lang.String r8 = "upload_uri"
            java.lang.String r9 = "upload_headers"
            java.lang.String r10 = "upload_type"
            java.lang.String r11 = "retry_count"
            java.lang.String r12 = "creation_timestamp"
            java.lang.String r13 = "associated_row_id"
            java.lang.String r14 = "last_upload_timestamp"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14}     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r6 = r20
            java.util.ArrayList r6 = r6.f39559a     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r6 = L(r6)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r7 = r18.K()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r6.length()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r8 + 17
            int r9 = r7.length()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r6)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r7)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r6 = r9.toString()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String[] r7 = new java.lang.String[]{r19}     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r10 = "creation_timestamp ASC"
            if (r21 <= 0) goto L66
            java.lang.String r0 = java.lang.String.valueOf(r21)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r11 = r0
            goto L67
        L66:
            r11 = r2
        L67:
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r0.<init>()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
        L72:
            boolean r1 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            if (r1 == 0) goto Lb9
            r1 = 0
            long r5 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 2
            byte[] r7 = r2.getBlob(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 3
            java.lang.String r8 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 4
            java.lang.String r9 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 5
            int r10 = r2.getInt(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 6
            int r11 = r2.getInt(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 7
            long r12 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 8
            long r14 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 9
            long r16 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r3 = r18
            r4 = r19
            com.google.android.gms.measurement.internal.zzpi r1 = r3.J(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            if (r1 == 0) goto L72
            r0.add(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            goto L72
        Lb5:
            r0 = move-exception
            goto Lbc
        Lb7:
            r0 = move-exception
            goto Lbf
        Lb9:
            r3 = r18
            goto Ld3
        Lbc:
            r3 = r18
            goto Lda
        Lbf:
            r3 = r18
            com.google.android.gms.measurement.internal.zzib r1 = r3.f39180a     // Catch: java.lang.Throwable -> Ld9
            com.google.android.gms.measurement.internal.zzgt r1 = r1.f39089f     // Catch: java.lang.Throwable -> Ld9
            com.google.android.gms.measurement.internal.zzib.l(r1)     // Catch: java.lang.Throwable -> Ld9
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38958f     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. appId"
            r5 = r19
            r1.c(r4, r5, r0)     // Catch: java.lang.Throwable -> Ld9
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> Ld9
        Ld3:
            if (r2 == 0) goto Ld8
            r2.close()
        Ld8:
            return r0
        Ld9:
            r0 = move-exception
        Lda:
            if (r2 == 0) goto Ldf
            r2.close()
        Ldf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.l(java.lang.String, com.google.android.gms.measurement.internal.zzon, int):java.util.List");
    }

    public final void l0(zzh zzhVar, boolean z) {
        Preconditions.checkNotNull(zzhVar);
        g();
        h();
        String strD = zzhVar.D();
        Preconditions.checkNotNull(strD);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strD);
        zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
        zzpf zzpfVar = this.f39551b;
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (zzpfVar.a(strD).i(zzjjVar)) {
            contentValues.put("app_instance_id", zzhVar.E());
        }
        contentValues.put("gmp_app_id", zzhVar.G());
        boolean zI = zzpfVar.a(strD).i(zzjj.AD_STORAGE);
        zzib zzibVar = zzhVar.f38983a;
        if (zI) {
            zzhy zzhyVar = zzibVar.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.g();
            contentValues.put("resettable_device_id_hash", zzhVar.f38987e);
        }
        zzhy zzhyVar2 = zzibVar.f39090g;
        zzib.l(zzhyVar2);
        zzhyVar2.g();
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.f38989g));
        zzhy zzhyVar3 = zzibVar.f39090g;
        zzib.l(zzhyVar3);
        zzhyVar3.g();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.f38990h));
        zzhy zzhyVar4 = zzibVar.f39090g;
        zzib.l(zzhyVar4);
        zzhyVar4.g();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.f38991i));
        contentValues.put("app_version", zzhVar.N());
        zzhy zzhyVar5 = zzibVar.f39090g;
        zzib.l(zzhyVar5);
        zzhyVar5.g();
        contentValues.put("app_store", zzhVar.f38994l);
        zzhy zzhyVar6 = zzibVar.f39090g;
        zzib.l(zzhyVar6);
        zzhyVar6.g();
        contentValues.put("gmp_version", Long.valueOf(zzhVar.f38995m));
        zzhy zzhyVar7 = zzibVar.f39090g;
        zzib.l(zzhyVar7);
        zzhyVar7.g();
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.n));
        zzhy zzhyVar8 = zzibVar.f39090g;
        zzib.l(zzhyVar8);
        zzhyVar8.g();
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.o));
        zzhy zzhyVar9 = zzibVar.f39090g;
        zzib.l(zzhyVar9);
        zzhyVar9.g();
        contentValues.put("day", Long.valueOf(zzhVar.J));
        zzhy zzhyVar10 = zzibVar.f39090g;
        zzib.l(zzhyVar10);
        zzhyVar10.g();
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.K));
        zzib.l(zzhyVar10);
        zzhyVar10.g();
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.L));
        zzib.l(zzhyVar10);
        zzhyVar10.g();
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.M));
        zzhy zzhyVar11 = zzibVar.f39090g;
        zzib.l(zzhyVar11);
        zzhyVar11.g();
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.R));
        zzhy zzhyVar12 = zzibVar.f39090g;
        zzib.l(zzhyVar12);
        zzhyVar12.g();
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.S));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.P()));
        contentValues.put("firebase_instance_id", zzhVar.J());
        zzib.l(zzhyVar10);
        zzhyVar10.g();
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.N));
        zzib.l(zzhyVar10);
        zzhyVar10.g();
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.O));
        zzib.l(zzhyVar10);
        zzhyVar10.g();
        contentValues.put("health_monitor_sample", zzhVar.P);
        contentValues.put("android_id", (Long) 0L);
        zzhy zzhyVar13 = zzibVar.f39090g;
        zzib.l(zzhyVar13);
        zzhyVar13.g();
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.p));
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.b()));
        if (zzpfVar.a(strD).i(zzjjVar)) {
            zzhy zzhyVar14 = zzibVar.f39090g;
            zzib.l(zzhyVar14);
            zzhyVar14.g();
            contentValues.put("session_stitching_token", zzhVar.t);
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.y()));
        zzhy zzhyVar15 = zzibVar.f39090g;
        zzib.l(zzhyVar15);
        zzhyVar15.g();
        contentValues.put("target_os_version", Long.valueOf(zzhVar.v));
        zzhy zzhyVar16 = zzibVar.f39090g;
        zzib.l(zzhyVar16);
        zzhyVar16.g();
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.w));
        zzql.a();
        zzib zzibVar2 = this.f39180a;
        if (zzibVar2.f39087d.q(strD, zzfx.P0)) {
            zzhy zzhyVar17 = zzibVar.f39090g;
            zzib.l(zzhyVar17);
            zzhyVar17.g();
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.x));
            zzhy zzhyVar18 = zzibVar.f39090g;
            zzib.l(zzhyVar18);
            zzhyVar18.g();
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.B));
        }
        zzhy zzhyVar19 = zzibVar.f39090g;
        zzib.l(zzhyVar19);
        zzhyVar19.g();
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.y));
        contentValues.put("npa_metadata_value", zzhVar.w());
        zzhy zzhyVar20 = zzibVar.f39090g;
        zzib.l(zzhyVar20);
        zzhyVar20.g();
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.F));
        contentValues.put("sgtm_preview_key", zzhVar.C());
        zzib.l(zzhyVar10);
        zzhyVar10.g();
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.D));
        zzib.l(zzhyVar10);
        zzhyVar10.g();
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.E));
        contentValues.put("serialized_npa_metadata", zzhVar.s());
        contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.t()));
        zzhy zzhyVar21 = zzibVar.f39090g;
        zzib.l(zzhyVar21);
        zzhyVar21.g();
        ArrayList arrayList = zzhVar.s;
        zzgt zzgtVar = zzibVar2.f39089f;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                zzib.l(zzgtVar);
                zzgtVar.f38961i.b(strD, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        ((com.google.android.gms.internal.measurement.zzpo) com.google.android.gms.internal.measurement.zzpn.f37249b.f37250a.get()).getClass();
        if (zzibVar2.f39087d.q(null, zzfx.K0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        zzhy zzhyVar22 = zzibVar.f39090g;
        zzib.l(zzhyVar22);
        zzhyVar22.g();
        contentValues.put("unmatched_pfo", zzhVar.z);
        zzhy zzhyVar23 = zzibVar.f39090g;
        zzib.l(zzhyVar23);
        zzhyVar23.g();
        contentValues.put("unmatched_uwa", zzhVar.A);
        zzhy zzhyVar24 = zzibVar.f39090g;
        zzib.l(zzhyVar24);
        zzhyVar24.g();
        contentValues.put("ad_campaign_info", zzhVar.H);
        try {
            SQLiteDatabase sQLiteDatabaseX = X();
            if (sQLiteDatabaseX.update("apps", contentValues, "app_id = ?", new String[]{strD}) == 0 && sQLiteDatabaseX.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzib.l(zzgtVar);
                zzgtVar.f38958f.b(zzgt.o(strD), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e2) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("Error storing app. appId", zzgt.o(strD), e2);
        }
    }

    public final boolean m(String str) {
        zzlr[] zzlrVarArr = {zzlr.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlrVarArr[0].zza()));
        String strL = L(arrayList);
        String strK = K();
        return C(android.support.v4.media.a.n(new StringBuilder((strL.length() + 61) + strK.length()), "SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?", strL, " AND NOT ", strK), new String[]{str}) != 0;
    }

    public final zzar m0(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        return n0(j2, str, 1L, false, false, z, false, z2, z3, z4);
    }

    public final void n(Long l2) {
        zzib zzibVar = this.f39180a;
        g();
        h();
        Preconditions.checkNotNull(l2);
        try {
            if (X().delete("upload_queue", "rowid=?", new String[]{l2.toString()}) != 1) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.a("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to delete a MeasurementBatch in a upload_queue table");
            throw e2;
        }
    }

    public final zzar n0(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        zzib zzibVar = this.f39180a;
        Preconditions.checkNotEmpty(str);
        g();
        h();
        String[] strArr = {str};
        zzar zzarVar = new zzar();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseX = X();
                cursorQuery = sQLiteDatabaseX.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j2) {
                        zzarVar.f38709b = cursorQuery.getLong(1);
                        zzarVar.f38708a = cursorQuery.getLong(2);
                        zzarVar.f38710c = cursorQuery.getLong(3);
                        zzarVar.f38711d = cursorQuery.getLong(4);
                        zzarVar.f38712e = cursorQuery.getLong(5);
                        zzarVar.f38713f = cursorQuery.getLong(6);
                        zzarVar.f38714g = cursorQuery.getLong(7);
                    }
                    if (z) {
                        zzarVar.f38709b += j3;
                    }
                    if (z2) {
                        zzarVar.f38708a += j3;
                    }
                    if (z3) {
                        zzarVar.f38710c += j3;
                    }
                    if (z4) {
                        zzarVar.f38711d += j3;
                    }
                    if (z5) {
                        zzarVar.f38712e += j3;
                    }
                    if (z6) {
                        zzarVar.f38713f += j3;
                    }
                    if (z7) {
                        zzarVar.f38714g += j3;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j2));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzarVar.f38708a));
                    contentValues.put("daily_events_count", Long.valueOf(zzarVar.f38709b));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzarVar.f38710c));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzarVar.f38711d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzarVar.f38712e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzarVar.f38713f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(zzarVar.f38714g));
                    sQLiteDatabaseX.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    zzgt zzgtVar = zzibVar.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.f38961i.b(zzgt.o(str), "Not updating daily counts, app is not known. appId");
                }
            } catch (SQLiteException e2) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.c("Error updating daily counts. appId", zzgt.o(str), e2);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return zzarVar;
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String o() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.X()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L24
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L35
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L1e
        L1c:
            r2 = move-exception
            goto L27
        L1e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3b
        L22:
            r0 = move-exception
            goto L3b
        L24:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L27:
            com.google.android.gms.measurement.internal.zzib r3 = r6.f39180a     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.zzgt r3 = r3.f39089f     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.zzib.l(r3)     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.zzgr r3 = r3.f38958f     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r2, r4)     // Catch: java.lang.Throwable -> L1a
        L35:
            if (r0 == 0) goto L3a
            r0.close()
        L3a:
            return r1
        L3b:
            if (r1 == 0) goto L40
            r1.close()
        L40:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.o():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzaq o0(java.lang.String r12) throws java.lang.Throwable {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzib r1 = r11.f39180a
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.g()
            r11.h()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.X()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            java.lang.String r4 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r5 = "config_last_modified_time"
            java.lang.String r6 = "e_tag"
            java.lang.String[] r5 = new java.lang.String[]{r0, r5, r6}     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            r10 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            if (r0 != 0) goto L30
            goto L7e
        L30:
            r0 = 0
            byte[] r0 = r3.getBlob(r0)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r4 = 1
            java.lang.String r4 = r3.getString(r4)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r5 = 2
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            boolean r6 = r3.moveToNext()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            if (r6 == 0) goto L5b
            com.google.android.gms.measurement.internal.zzgt r6 = r1.f39089f     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            com.google.android.gms.measurement.internal.zzib.l(r6)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            com.google.android.gms.measurement.internal.zzgr r6 = r6.f38958f     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.o(r12)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r6.b(r8, r7)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            goto L5b
        L56:
            r0 = move-exception
            r12 = r0
            goto L67
        L59:
            r0 = move-exception
            goto L6e
        L5b:
            if (r0 != 0) goto L5e
            goto L7e
        L5e:
            com.google.android.gms.measurement.internal.zzaq r6 = new com.google.android.gms.measurement.internal.zzaq     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r6.<init>(r4, r5, r0)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r3.close()
            return r6
        L67:
            r2 = r3
            goto L84
        L69:
            r0 = move-exception
            r12 = r0
            goto L84
        L6c:
            r0 = move-exception
            r3 = r2
        L6e:
            com.google.android.gms.measurement.internal.zzgt r1 = r1.f39089f     // Catch: java.lang.Throwable -> L56
            com.google.android.gms.measurement.internal.zzib.l(r1)     // Catch: java.lang.Throwable -> L56
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38958f     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgt.o(r12)     // Catch: java.lang.Throwable -> L56
            r1.c(r4, r12, r0)     // Catch: java.lang.Throwable -> L56
        L7e:
            if (r3 == 0) goto L83
            r3.close()
        L83:
            return r2
        L84:
            if (r2 == 0) goto L89
            r2.close()
        L89:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.o0(java.lang.String):com.google.android.gms.measurement.internal.zzaq");
    }

    public final void p(long j2) {
        g();
        h();
        try {
            if (X().delete("queue", "rowid=?", new String[]{String.valueOf(j2)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(e2, "Failed to delete a bundle in a queue table");
            throw e2;
        }
    }

    public final void p0(com.google.android.gms.internal.measurement.zzid zzidVar, boolean z) {
        g();
        h();
        Preconditions.checkNotNull(zzidVar);
        Preconditions.checkNotEmpty(zzidVar.s());
        Preconditions.checkState(zzidVar.f2());
        q();
        zzib zzibVar = this.f39180a;
        long jCurrentTimeMillis = zzibVar.f39094k.currentTimeMillis();
        long jG2 = zzidVar.g2();
        zzfw zzfwVar = zzfx.R;
        long jLongValue = jCurrentTimeMillis - ((Long) zzfwVar.a(null)).longValue();
        zzgt zzgtVar = zzibVar.f39089f;
        if (jG2 < jLongValue || zzidVar.g2() > ((Long) zzfwVar.a(null)).longValue() + jCurrentTimeMillis) {
            zzib.l(zzgtVar);
            zzgtVar.f38961i.d("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgt.o(zzidVar.s()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzidVar.g2()));
        }
        byte[] bArrF = zzidVar.f();
        try {
            zzpj zzpjVar = this.f39551b.f39600g;
            zzpf.S(zzpjVar);
            byte[] bArrN = zzpjVar.N(bArrF);
            zzib.l(zzgtVar);
            zzgtVar.n.b(Integer.valueOf(bArrN.length), "Saving bundle, size");
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzidVar.s());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzidVar.g2()));
            contentValues.put("data", bArrN);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzidVar.s0()) {
                contentValues.put("retry_count", Integer.valueOf(zzidVar.t0()));
            }
            try {
                if (X().insert("queue", null, contentValues) == -1) {
                    zzib.l(zzgtVar);
                    zzgtVar.f38958f.b(zzgt.o(zzidVar.s()), "Failed to insert bundle (got -1). appId");
                }
            } catch (SQLiteException e2) {
                zzib.l(zzgtVar);
                zzgtVar.f38958f.c("Error storing bundle. appId", zzgt.o(zzidVar.s()), e2);
            }
        } catch (IOException e3) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("Data loss. Failed to serialize bundle. appId", zzgt.o(zzidVar.s()), e3);
        }
    }

    public final void q() {
        int iDelete;
        g();
        h();
        if (R()) {
            zzpf zzpfVar = this.f39551b;
            long jA = zzpfVar.f39602i.f39496e.a();
            zzib zzibVar = this.f39180a;
            long jElapsedRealtime = zzibVar.f39094k.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) zzfx.M.a(null)).longValue()) {
                zzpfVar.f39602i.f39496e.b(jElapsedRealtime);
                g();
                h();
                if (!R() || (iDelete = X().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzibVar.f39094k.currentTimeMillis()), String.valueOf(((Long) zzfx.R.a(null)).longValue())})) <= 0) {
                    return;
                }
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.n.b(Integer.valueOf(iDelete), "Deleted stale rows. rowsDeleted");
            }
        }
    }

    public final void r(List list) throws SQLException {
        g();
        h();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (R()) {
            String strJoin = TextUtils.join(",", list);
            String strS = b.s(new StringBuilder(String.valueOf(strJoin).length() + 2), "(", strJoin, ")");
            long jC = C(b.s(new StringBuilder(strS.length() + 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", strS, " AND retry_count =  2147483647 LIMIT 1"), null);
            zzib zzibVar = this.f39180a;
            if (jC > 0) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseX = X();
                StringBuilder sb = new StringBuilder(strS.length() + WKSRecord.Service.LOCUS_CON);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(strS);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseX.execSQL(sb.toString());
            } catch (SQLiteException e2) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.b(e2, "Error incrementing retry count. error");
            }
        }
    }

    public final void s(Long l2) throws SQLException {
        g();
        h();
        Preconditions.checkNotNull(l2);
        if (R()) {
            StringBuilder sb = new StringBuilder(l2.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l2);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            long jC = C(sb.toString(), null);
            zzib zzibVar = this.f39180a;
            if (jC > 0) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseX = X();
                long jCurrentTimeMillis = zzibVar.f39094k.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(jCurrentTimeMillis);
                String string = sb2.toString();
                StringBuilder sb3 = new StringBuilder(string.length() + 34 + l2.toString().length() + 29);
                sb3.append("UPDATE upload_queue");
                sb3.append(string);
                sb3.append(" WHERE rowid = ");
                sb3.append(l2);
                sb3.append(" AND retry_count < 2147483647");
                sQLiteDatabaseX.execSQL(sb3.toString());
            } catch (SQLiteException e2) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.b(e2, "Error incrementing retry count. error");
            }
        }
    }

    public final Object t(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        zzib zzibVar = this.f39180a;
        if (type == 0) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type == 4) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.a("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzgt zzgtVar3 = zzibVar.f39089f;
        zzib.l(zzgtVar3);
        zzgtVar3.f38958f.b(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0091 A[Catch: all -> 0x006b, SQLiteException -> 0x00a2, TryCatch #0 {SQLiteException -> 0x00a2, blocks: (B:15:0x0070, B:17:0x0091, B:20:0x00a4), top: B:30:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4 A[Catch: all -> 0x006b, SQLiteException -> 0x00a2, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00a2, blocks: (B:15:0x0070, B:17:0x0091, B:20:0x00a4), top: B:30:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long u(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.measurement.internal.zzib r0 = r13.f39180a
            java.lang.String r1 = "select first_open_count from app2 where app_id=?"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            java.lang.String r2 = "first_open_count"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)
            r13.g()
            r13.h()
            android.database.sqlite.SQLiteDatabase r3 = r13.X()
            r3.beginTransaction()
            r4 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r7 = 48
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r6.append(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String[] r6 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r7 = -1
            long r9 = r13.D(r7, r1, r6)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            java.lang.String r6 = "app2"
            java.lang.String r11 = "app_id"
            if (r1 != 0) goto L70
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.<init>()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.put(r11, r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.put(r2, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r10 = "previous_install_count"
            r1.put(r10, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            r10 = 5
            long r9 = r3.insertWithOnConflict(r6, r9, r1, r10)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 != 0) goto L6f
            com.google.android.gms.measurement.internal.zzgt r1 = r0.f39089f     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            com.google.android.gms.measurement.internal.zzib.l(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38958f     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r6 = "Failed to insert column (got -1). appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgt.o(r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.c(r6, r9, r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            goto Lbb
        L6b:
            r14 = move-exception
            goto Lbf
        L6d:
            r1 = move-exception
            goto Laa
        L6f:
            r9 = r4
        L70:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.<init>()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.put(r11, r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r11 = 1
            long r11 = r11 + r9
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.put(r2, r11)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            java.lang.String r11 = "app_id = ?"
            java.lang.String[] r12 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            int r1 = r3.update(r6, r1, r11, r12)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            long r11 = (long) r1     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            int r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r1 != 0) goto La4
            com.google.android.gms.measurement.internal.zzgt r1 = r0.f39089f     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            com.google.android.gms.measurement.internal.zzib.l(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38958f     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            java.lang.String r4 = "Failed to update column (got 0). appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.o(r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.c(r4, r5, r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            goto Lbb
        La2:
            r1 = move-exception
            goto La9
        La4:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r7 = r9
            goto Lbb
        La9:
            r4 = r9
        Laa:
            com.google.android.gms.measurement.internal.zzgt r0 = r0.f39089f     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.zzib.l(r0)     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.zzgr r0 = r0.f38958f     // Catch: java.lang.Throwable -> L6b
            java.lang.String r6 = "Error inserting column. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzgt.o(r14)     // Catch: java.lang.Throwable -> L6b
            r0.d(r6, r14, r2, r1)     // Catch: java.lang.Throwable -> L6b
            r7 = r4
        Lbb:
            r3.endTransaction()
            return r7
        Lbf:
            r3.endTransaction()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.u(java.lang.String):long");
    }

    public final boolean v(String str, String str2) {
        return C("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final void w(ArrayList arrayList) {
        Preconditions.checkNotNull(arrayList);
        g();
        h();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(((Long) arrayList.get(i2)).longValue());
        }
        sb.append(")");
        int iDelete = X().delete("raw_events", sb.toString(), null);
        if (iDelete != arrayList.size()) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(arrayList.size()));
        }
    }

    public final void x(String str) throws SQLException {
        try {
            X().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("Failed to remove unused event metadata. appId", zzgt.o(str), e2);
        }
    }

    public final long y(String str) {
        Preconditions.checkNotEmpty(str);
        return D(0L, "select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str});
    }

    public final void z(String str, Long l2, long j2, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        g();
        h();
        Preconditions.checkNotNull(zzhsVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l2);
        byte[] bArrF = zzhsVar.f();
        zzib zzibVar = this.f39180a;
        zzgt zzgtVar = zzibVar.f39089f;
        zzgt zzgtVar2 = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.n.c("Saving complex main event, appId, data size", zzibVar.f39093j.a(str), Integer.valueOf(bArrF.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", bArrF);
        try {
            if (X().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.b(zzgt.o(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e2) {
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Error storing complex main event. appId", zzgt.o(str), e2);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void j() {
    }
}
