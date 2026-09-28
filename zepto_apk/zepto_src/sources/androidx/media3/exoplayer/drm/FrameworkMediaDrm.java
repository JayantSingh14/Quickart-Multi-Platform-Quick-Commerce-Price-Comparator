package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.exoplayer.analytics.s;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import com.google.common.base.Charsets;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.codec.language.Soundex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class FrameworkMediaDrm implements ExoMediaDrm {

    /* renamed from: d, reason: collision with root package name */
    public static final p f6938d = new p(4);

    /* renamed from: a, reason: collision with root package name */
    public final UUID f6939a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaDrm f6940b;

    /* renamed from: c, reason: collision with root package name */
    public int f6941c;

    @RequiresApi
    public static class Api31 {
        @DoNotInline
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        @DoNotInline
        public static void b(MediaDrm mediaDrm, byte[] bArr, PlayerId playerId) {
            LogSessionId logSessionIdA = playerId.a();
            LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            MediaDrm.PlaybackComponent playbackComponent = mediaDrm.getPlaybackComponent(bArr);
            playbackComponent.getClass();
            s.e(playbackComponent).setLogSessionId(logSessionIdA);
        }
    }

    public FrameworkMediaDrm(UUID uuid) {
        uuid.getClass();
        UUID uuid2 = C.f5165b;
        Assertions.b(!uuid2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f6939a = uuid;
        MediaDrm mediaDrm = new MediaDrm((Util.f5744a >= 27 || !C.f5166c.equals(uuid)) ? uuid : uuid2);
        this.f6940b = mediaDrm;
        this.f6941c = 1;
        if (C.f5167d.equals(uuid) && "ASUS_Z00AD".equals(Util.f5747d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final Map a(byte[] bArr) {
        return this.f6940b.queryKeyStatus(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final ExoMediaDrm.ProvisionRequest b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f6940b.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getDefaultUrl(), provisionRequest.getData());
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final byte[] c() {
        return this.f6940b.openSession();
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void d(byte[] bArr, byte[] bArr2) {
        this.f6940b.restoreKeys(bArr, bArr2);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void e(byte[] bArr) throws DeniedByServerException {
        this.f6940b.provideProvisionResponse(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final int f() {
        return 2;
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final CryptoConfig g(byte[] bArr) {
        n();
        int i2 = Util.f5744a;
        UUID uuid = this.f6939a;
        if (i2 < 27 && C.f5166c.equals(uuid)) {
            uuid = C.f5165b;
        }
        return new FrameworkCryptoConfig(uuid, bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void h(byte[] bArr) {
        this.f6940b.closeSession(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final byte[] i(byte[] bArr, byte[] bArr2) throws JSONException {
        if (C.f5166c.equals(this.f6939a) && Util.f5744a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(Util.p(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (i2 != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace(Soundex.SILENT_MARKER, '+').replace('_', '/'));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace(Soundex.SILENT_MARKER, '+').replace('_', '/'));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = sb.toString().getBytes(Charsets.f42260c);
            } catch (JSONException e2) {
                Log.e("ClearKeyUtil", "Failed to adjust response data: ".concat(Util.p(bArr2)), e2);
            }
        }
        return this.f6940b.provideKeyResponse(bArr, bArr2);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void j(final ExoMediaDrm.OnEventListener onEventListener) {
        this.f6940b.setOnEventListener(new MediaDrm.OnEventListener() { // from class: androidx.media3.exoplayer.drm.c
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
                this.f6954a.getClass();
                DefaultDrmSessionManager.MediaDrmHandler mediaDrmHandler = DefaultDrmSessionManager.this.x;
                mediaDrmHandler.getClass();
                mediaDrmHandler.obtainMessage(i2, bArr).sendToTarget();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c4  */
    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.exoplayer.drm.ExoMediaDrm.KeyRequest k(byte[] r17, java.util.List r18, int r19, java.util.HashMap r20) throws android.media.NotProvisionedException {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.FrameworkMediaDrm.k(byte[], java.util.List, int, java.util.HashMap):androidx.media3.exoplayer.drm.ExoMediaDrm$KeyRequest");
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void l(byte[] bArr, PlayerId playerId) {
        if (Util.f5744a >= 31) {
            try {
                Api31.b(this.f6940b, bArr, playerId);
            } catch (UnsupportedOperationException unused) {
                Log.h("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(java.lang.String r7, byte[] r8) throws java.lang.Throwable {
        /*
            r6 = this;
            int r0 = androidx.media3.common.util.Util.f5744a
            r1 = 31
            r2 = 0
            java.util.UUID r3 = r6.f6939a
            r4 = 1
            if (r0 < r1) goto L4b
            java.util.UUID r0 = androidx.media3.common.C.f5167d
            boolean r0 = r3.equals(r0)
            android.media.MediaDrm r1 = r6.f6940b
            if (r0 == 0) goto L3e
            java.lang.String r0 = "version"
            java.lang.String r0 = r1.getPropertyString(r0)
            java.lang.String r5 = "v5."
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L3c
            java.lang.String r5 = "14."
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L3c
            java.lang.String r5 = "15."
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L3c
            java.lang.String r5 = "16.0"
            boolean r0 = r0.startsWith(r5)
            if (r0 != 0) goto L3c
            r0 = r4
            goto L44
        L3c:
            r0 = r2
            goto L44
        L3e:
            java.util.UUID r0 = androidx.media3.common.C.f5166c
            boolean r0 = r3.equals(r0)
        L44:
            if (r0 == 0) goto L4b
            boolean r7 = androidx.media3.exoplayer.drm.FrameworkMediaDrm.Api31.a(r1, r7)
            goto L6b
        L4b:
            r0 = 0
            android.media.MediaCrypto r1 = new android.media.MediaCrypto     // Catch: java.lang.Throwable -> L5e android.media.MediaCryptoException -> L65
            r1.<init>(r3, r8)     // Catch: java.lang.Throwable -> L5e android.media.MediaCryptoException -> L65
            boolean r7 = r1.requiresSecureDecoderComponent(r7)     // Catch: java.lang.Throwable -> L59 android.media.MediaCryptoException -> L5c
            r1.release()
            goto L6b
        L59:
            r7 = move-exception
            r0 = r1
            goto L5f
        L5c:
            r0 = r1
            goto L65
        L5e:
            r7 = move-exception
        L5f:
            if (r0 == 0) goto L64
            r0.release()
        L64:
            throw r7
        L65:
            if (r0 == 0) goto L6a
            r0.release()
        L6a:
            r7 = r4
        L6b:
            if (r7 == 0) goto L74
            boolean r7 = r6.n()
            if (r7 != 0) goto L74
            r2 = r4
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.FrameworkMediaDrm.m(java.lang.String, byte[]):boolean");
    }

    public final boolean n() {
        return Util.f5744a < 21 && C.f5167d.equals(this.f6939a) && "L3".equals(this.f6940b.getPropertyString("securityLevel"));
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final synchronized void release() {
        int i2 = this.f6941c - 1;
        this.f6941c = i2;
        if (i2 == 0) {
            this.f6940b.release();
        }
    }
}
