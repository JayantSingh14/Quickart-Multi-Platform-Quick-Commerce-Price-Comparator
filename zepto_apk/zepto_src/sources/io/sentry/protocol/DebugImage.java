package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class DebugImage implements JsonUnknown, JsonSerializable {
    public static final String JVM = "jvm";
    public static final String PROGUARD = "proguard";

    @Nullable
    private String arch;

    @Nullable
    private String codeFile;

    @Nullable
    private String codeId;

    @Nullable
    private String debugFile;

    @Nullable
    private String debugId;

    @Nullable
    private String imageAddr;

    @Nullable
    private Long imageSize;

    @Nullable
    private String type;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String uuid;

    public static final class Deserializer implements JsonDeserializer<DebugImage> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            DebugImage debugImage = new DebugImage();
            objectReader.k();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "debug_file":
                        debugImage.debugFile = objectReader.a1();
                        break;
                    case "image_addr":
                        debugImage.imageAddr = objectReader.a1();
                        break;
                    case "image_size":
                        debugImage.imageSize = objectReader.R0();
                        break;
                    case "code_file":
                        debugImage.codeFile = objectReader.a1();
                        break;
                    case "arch":
                        debugImage.arch = objectReader.a1();
                        break;
                    case "type":
                        debugImage.type = objectReader.a1();
                        break;
                    case "uuid":
                        debugImage.uuid = objectReader.a1();
                        break;
                    case "debug_id":
                        debugImage.debugId = objectReader.a1();
                        break;
                    case "code_id":
                        debugImage.codeId = objectReader.a1();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            objectReader.t();
            debugImage.setUnknown(map);
            return debugImage;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Nullable
    public String getArch() {
        return this.arch;
    }

    @Nullable
    public String getCodeFile() {
        return this.codeFile;
    }

    @Nullable
    public String getCodeId() {
        return this.codeId;
    }

    @Nullable
    public String getDebugFile() {
        return this.debugFile;
    }

    @Nullable
    public String getDebugId() {
        return this.debugId;
    }

    @Nullable
    public String getImageAddr() {
        return this.imageAddr;
    }

    @Nullable
    public Long getImageSize() {
        return this.imageSize;
    }

    @Nullable
    public String getType() {
        return this.type;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getUuid() {
        return this.uuid;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.k();
        if (this.uuid != null) {
            objectWriter.d("uuid").e(this.uuid);
        }
        if (this.type != null) {
            objectWriter.d("type").e(this.type);
        }
        if (this.debugId != null) {
            objectWriter.d("debug_id").e(this.debugId);
        }
        if (this.debugFile != null) {
            objectWriter.d("debug_file").e(this.debugFile);
        }
        if (this.codeId != null) {
            objectWriter.d("code_id").e(this.codeId);
        }
        if (this.codeFile != null) {
            objectWriter.d("code_file").e(this.codeFile);
        }
        if (this.imageAddr != null) {
            objectWriter.d("image_addr").e(this.imageAddr);
        }
        if (this.imageSize != null) {
            objectWriter.d("image_size").f(this.imageSize);
        }
        if (this.arch != null) {
            objectWriter.d("arch").e(this.arch);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.t();
    }

    public void setArch(@Nullable String str) {
        this.arch = str;
    }

    public void setCodeFile(@Nullable String str) {
        this.codeFile = str;
    }

    public void setCodeId(@Nullable String str) {
        this.codeId = str;
    }

    public void setDebugFile(@Nullable String str) {
        this.debugFile = str;
    }

    public void setDebugId(@Nullable String str) {
        this.debugId = str;
    }

    public void setImageAddr(@Nullable String str) {
        this.imageAddr = str;
    }

    public void setImageSize(@Nullable Long l2) {
        this.imageSize = l2;
    }

    public void setType(@Nullable String str) {
        this.type = str;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUuid(@Nullable String str) {
        this.uuid = str;
    }

    public void setImageSize(long j2) {
        this.imageSize = Long.valueOf(j2);
    }
}
