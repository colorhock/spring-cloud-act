package com.itmuch.service;

import com.itmuch.pojo.UserPo;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user",
             fallbackFactory = UserFeignClient.FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
    public UserPo findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
    public UserPo getUserByPost(@RequestBody UserPo userPo);



    @Component
    class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
        private  static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);


        @Override
        public UserFeignClient create(Throwable throwable) {
            return new UserFeignClient() {
                @Override
                public UserPo findById(Long id) {
                    FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                    return null;
                }

                @Override
                public UserPo getUserByPost(UserPo userPo) {
                    FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                    return null;
                }
            };
        }
    }
}
