package com.test.demo.service;

import com.test.demo.dao.DemoDao;
import com.test.demo.util.CommonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CommonUtils.class})
public class DemoServiceImplTest {

    // 给dao层接口打桩
    @Mock
    private DemoDao demoDao;

    private DemoServiceImpl demoService = PowerMockito.spy(new DemoServiceImpl());

    @Before
    public void setUp() {
        PowerMockito.mockStatic(CommonUtils.class);
        PowerMockito.when(CommonUtils.isEmpty(anyObject())).thenReturn(true);
    }


    @Test
    public void testServiceOne() throws IllegalAccessException {
        MemberModifier.field(DemoServiceImpl.class, "demoDao").set(demoService, demoDao);
        PowerMockito.doNothing().when(demoDao).make();
        PowerMockito.doReturn("i am hello").when(demoDao).sayHello();
        assertEquals("serviceOne", demoService.serviceOne()) ;
    }
}
