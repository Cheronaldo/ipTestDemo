package com.cherry.service.impl;

import com.cherry.form.SiteDeviceForm;
import com.cherry.util.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.image.Kernel;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 设备service层测试
 * Created by Administrator on 2017/11/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceImplTest {

    @Autowired
    private DeviceServiceImpl service;

    @Test
    public void checkSiteDeviceIsOnHand() throws Exception {
        Map<String,Object> map = service.checkSiteDeviceIsOnHand("1510312407397859686","34fr6t","abc1234");

        int code = Integer.parseInt(String.valueOf(map.get("code")));
        String msg = (String)map.get("msg");
        Object data = map.get("data");

        Assert.assertNotNull(msg);
    }

    @Test
    public void siteUserSaveDeviceInfo() throws Exception {

        Map<String,Object> map = new HashMap<String,Object>();

        SiteDeviceForm siteDeviceForm = new SiteDeviceForm();
        siteDeviceForm.setSnCode("1510376873026663728");
        siteDeviceForm.setUserName("abc1234");
        siteDeviceForm.setDeviceAddress("武汉大学");
        siteDeviceForm.setDeviceLongitude("114.368107");
        siteDeviceForm.setDeviceLatitude("30.543083");
        siteDeviceForm.setSiteType("饲料生产");
        siteDeviceForm.setSiteName("车间搅拌线");
        siteDeviceForm.setSiteIcon("/12345");

        map = service.siteUserSaveDeviceInfo(siteDeviceForm);
        int code = Integer.parseInt(String.valueOf(map.get("code")));
        String msg = (String)map.get("msg");


        Assert.assertNotNull(msg);

    }

    @Test
    public void userDeviceRelationshipHandle() throws Exception {

        Map<String,Object> map = new HashMap<String,Object>();

        map = service.userDeviceRelationshipHandle(KeyUtil.genUniqueKey(),"abc1234");

        int code = Integer.parseInt(String.valueOf(map.get("code")));
        String msg = (String)map.get("msg");


        Assert.assertNotNull(msg);

    }

    @Test
    public void userDeviceUnbind() throws Exception {

        Map<String,Object> map = new HashMap<String,Object>();

        map = service.userDeviceUnbind("1510368792904640171","abc1234");

        int code = Integer.parseInt(String.valueOf(map.get("code")));
        String msg = (String)map.get("msg");


        Assert.assertNotNull(msg);


    }

    @Test
    public void findOneBySnCode() throws Exception {
    }

    @Test
    public void findListByUser() throws Exception {

        Map<String,Object> map = new HashMap<String,Object>();

        map = service.findListByUser("abc1234567");

        int code = Integer.parseInt(String.valueOf(map.get("code")));
        String msg = (String)map.get("msg");
        Object data = map.get("data");


        Assert.assertNotNull(msg);

    }

    @Test
    public void findStatusBySnCode() throws Exception {

        int result = service.findStatusBySnCode("1510312472692722083");

        Assert.assertEquals(1,result);

    }

}