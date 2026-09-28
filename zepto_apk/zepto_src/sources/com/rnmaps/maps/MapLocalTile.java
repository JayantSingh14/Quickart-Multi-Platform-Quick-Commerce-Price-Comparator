package com.rnmaps.maps;

import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;

/* loaded from: classes.dex */
public class MapLocalTile extends MapFeature {

    /* renamed from: a, reason: collision with root package name */
    public TileOverlayOptions f46518a;

    /* renamed from: b, reason: collision with root package name */
    public TileOverlay f46519b;

    /* renamed from: c, reason: collision with root package name */
    public AIRMapLocalTileProvider f46520c;

    /* renamed from: d, reason: collision with root package name */
    public String f46521d;

    /* renamed from: e, reason: collision with root package name */
    public float f46522e;

    /* renamed from: f, reason: collision with root package name */
    public float f46523f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f46524g;

    /* loaded from: classes4.dex */
    public class AIRMapLocalTileProvider implements TileProvider {

        /* renamed from: b, reason: collision with root package name */
        public int f46525b;

        /* renamed from: c, reason: collision with root package name */
        public String f46526c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f46527d;

        public AIRMapLocalTileProvider(int i2, String str, boolean z) {
            this.f46525b = i2;
            this.f46526c = str;
            this.f46527d = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x008c A[Catch: Exception -> 0x008f, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x008f, blocks: (B:28:0x0070, B:40:0x008c), top: B:60:0x0021 }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
        @Override // com.google.android.gms.maps.model.TileProvider
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.google.android.gms.maps.model.Tile a(int r7, int r8, int r9) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.String r0 = r6.f46526c
                java.lang.String r1 = "{x}"
                java.lang.String r7 = java.lang.Integer.toString(r7)
                java.lang.String r7 = r0.replace(r1, r7)
                java.lang.String r0 = "{y}"
                java.lang.String r8 = java.lang.Integer.toString(r8)
                java.lang.String r7 = r7.replace(r0, r8)
                java.lang.String r8 = "{z}"
                java.lang.String r9 = java.lang.Integer.toString(r9)
                java.lang.String r7 = r7.replace(r8, r9)
                r8 = 0
                boolean r9 = r6.f46527d     // Catch: java.lang.Throwable -> L34 java.lang.OutOfMemoryError -> L38 java.io.IOException -> L3c
                if (r9 == 0) goto L3e
                com.rnmaps.maps.MapLocalTile r9 = com.rnmaps.maps.MapLocalTile.this     // Catch: java.lang.Throwable -> L34 java.lang.OutOfMemoryError -> L38 java.io.IOException -> L3c
                android.content.Context r9 = r9.getContext()     // Catch: java.lang.Throwable -> L34 java.lang.OutOfMemoryError -> L38 java.io.IOException -> L3c
                android.content.res.AssetManager r9 = r9.getAssets()     // Catch: java.lang.Throwable -> L34 java.lang.OutOfMemoryError -> L38 java.io.IOException -> L3c
                java.io.InputStream r7 = r9.open(r7)     // Catch: java.lang.Throwable -> L34 java.lang.OutOfMemoryError -> L38 java.io.IOException -> L3c
                goto L44
            L34:
                r7 = move-exception
                r9 = r8
                goto L9f
            L38:
                r7 = move-exception
            L39:
                r9 = r8
                r0 = r9
                goto L82
            L3c:
                r7 = move-exception
                goto L39
            L3e:
                java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L34 java.lang.OutOfMemoryError -> L38 java.io.IOException -> L3c
                r9.<init>(r7)     // Catch: java.lang.Throwable -> L34 java.lang.OutOfMemoryError -> L38 java.io.IOException -> L3c
                r7 = r9
            L44:
                java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L74 java.lang.OutOfMemoryError -> L7a java.io.IOException -> L80
                r9.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.OutOfMemoryError -> L7a java.io.IOException -> L80
                r0 = 16384(0x4000, float:2.2959E-41)
                byte[] r1 = new byte[r0]     // Catch: java.lang.Throwable -> L59 java.lang.OutOfMemoryError -> L5e java.io.IOException -> L64
            L4d:
                r2 = 0
                int r3 = r7.read(r1, r2, r0)     // Catch: java.lang.Throwable -> L59 java.lang.OutOfMemoryError -> L5e java.io.IOException -> L64
                r4 = -1
                if (r3 == r4) goto L66
                r9.write(r1, r2, r3)     // Catch: java.lang.Throwable -> L59 java.lang.OutOfMemoryError -> L5e java.io.IOException -> L64
                goto L4d
            L59:
                r8 = move-exception
                r5 = r8
                r8 = r7
                r7 = r5
                goto L9f
            L5e:
                r0 = move-exception
            L5f:
                r5 = r9
                r9 = r7
                r7 = r0
                r0 = r5
                goto L82
            L64:
                r0 = move-exception
                goto L5f
            L66:
                r9.flush()     // Catch: java.lang.Throwable -> L59 java.lang.OutOfMemoryError -> L5e java.io.IOException -> L64
                byte[] r8 = r9.toByteArray()     // Catch: java.lang.Throwable -> L59 java.lang.OutOfMemoryError -> L5e java.io.IOException -> L64
                r7.close()     // Catch: java.lang.Exception -> L70
            L70:
                r9.close()     // Catch: java.lang.Exception -> L8f
                goto L8f
            L74:
                r9 = move-exception
                r5 = r8
                r8 = r7
                r7 = r9
                r9 = r5
                goto L9f
            L7a:
                r9 = move-exception
            L7b:
                r0 = r9
                r9 = r7
                r7 = r0
                r0 = r8
                goto L82
            L80:
                r9 = move-exception
                goto L7b
            L82:
                r7.printStackTrace()     // Catch: java.lang.Throwable -> L9c
                if (r9 == 0) goto L8a
                r9.close()     // Catch: java.lang.Exception -> L8a
            L8a:
                if (r0 == 0) goto L8f
                r0.close()     // Catch: java.lang.Exception -> L8f
            L8f:
                if (r8 != 0) goto L94
                com.google.android.gms.maps.model.Tile r7 = com.google.android.gms.maps.model.TileProvider.f38570a
                goto L9b
            L94:
                com.google.android.gms.maps.model.Tile r7 = new com.google.android.gms.maps.model.Tile
                int r9 = r6.f46525b
                r7.<init>(r9, r8, r9)
            L9b:
                return r7
            L9c:
                r7 = move-exception
                r8 = r9
                r9 = r0
            L9f:
                if (r8 == 0) goto La4
                r8.close()     // Catch: java.lang.Exception -> La4
            La4:
                if (r9 == 0) goto La9
                r9.close()     // Catch: java.lang.Exception -> La9
            La9:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapLocalTile.AIRMapLocalTileProvider.a(int, int, int):com.google.android.gms.maps.model.Tile");
        }

        public final void b(String str) {
            this.f46526c = str;
        }

        public final void c(int i2) {
            this.f46525b = i2;
        }
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46519b;
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.f46518a == null) {
            TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
            tileOverlayOptions.s(this.f46523f);
            AIRMapLocalTileProvider aIRMapLocalTileProvider = new AIRMapLocalTileProvider((int) this.f46522e, this.f46521d, this.f46524g);
            this.f46520c = aIRMapLocalTileProvider;
            tileOverlayOptions.b(aIRMapLocalTileProvider);
            this.f46518a = tileOverlayOptions;
        }
        return this.f46518a;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        this.f46519b.b();
    }

    public void setPathTemplate(String str) {
        this.f46521d = str;
        AIRMapLocalTileProvider aIRMapLocalTileProvider = this.f46520c;
        if (aIRMapLocalTileProvider != null) {
            aIRMapLocalTileProvider.b(str);
        }
        TileOverlay tileOverlay = this.f46519b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setTileSize(float f2) {
        this.f46522e = f2;
        AIRMapLocalTileProvider aIRMapLocalTileProvider = this.f46520c;
        if (aIRMapLocalTileProvider != null) {
            aIRMapLocalTileProvider.c((int) f2);
        }
    }

    public void setUseAssets(boolean z) {
        this.f46524g = z;
    }

    public void setZIndex(float f2) {
        this.f46523f = f2;
        TileOverlay tileOverlay = this.f46519b;
        if (tileOverlay != null) {
            tileOverlay.d(f2);
        }
    }
}
