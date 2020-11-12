package openfeign.demo.io_github_openfeign;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

import java.lang.reflect.Type;

public class AbstractFormEncoder implements Encoder {

    private final Encoder delegate;

    public AbstractFormEncoder(Encoder delegate) {
        this.delegate = delegate;
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        delegate.encode(object, bodyType, template);
    }
}
