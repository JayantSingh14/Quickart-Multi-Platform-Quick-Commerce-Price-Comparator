package retrofit2;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class HttpException extends RuntimeException {
    public HttpException(Response response) {
        StringBuilder sb = new StringBuilder("HTTP ");
        okhttp3.Response response2 = response.f58224a;
        sb.append(response2.f56353d);
        sb.append(StringUtils.SPACE);
        sb.append(response2.f56352c);
        super(sb.toString());
    }
}
