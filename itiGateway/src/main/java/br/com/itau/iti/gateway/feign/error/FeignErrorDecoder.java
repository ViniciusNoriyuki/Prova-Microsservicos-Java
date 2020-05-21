package br.com.itau.iti.gateway.feign.error;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        System.out.println(methodKey);
        System.out.println(response);

        return new Exception();
    }

}