package com.tanson.tesecase.controller;

import com.tanson.tesecase.domain.TermInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TermInfoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/termInfo/findone", method = RequestMethod.POST)
    public TermInfo findTermInfo(){
        TermInfo termInfo = new TermInfo();
        Map<String, Object> termInfoMap = jdbcTemplate.queryForMap("select * from fc_term_info where c_term_no='7074'");
        String termNo = (String)termInfoMap.get("C_TERM_NO");
        String address = (String)termInfoMap.get("C_ADDRESS");
        Integer replenishMode = Integer.parseInt(String.valueOf(termInfoMap.get("N_REPLENISH_MODE")));
        termInfo.setTermNo(termNo);
        termInfo.setAddress(address);
        termInfo.setReplenishMode(replenishMode);
        return termInfo;
    }

    @RequestMapping(value = "/termInfo/findonebytermno", method = RequestMethod.POST)
    public TermInfo findTermInfoByTermNo(@RequestBody HashMap<String, Object> params){
        TermInfo termInfo = new TermInfo();
        String termNo = params.get("termNo") == null ? "" : params.get("termNo").toString();
        String district3 = params.get("district3") == null ? "" : params.get("district3").toString();
        Map<String, Object> termInfoMap = jdbcTemplate.queryForMap("select * from fc_term_info where c_term_no='" + termNo + "'");
        termInfo.setTermNo((String)termInfoMap.get("C_TERM_NO"));
        termInfo.setAddress((String)termInfoMap.get("C_ADDRESS"));
        termInfo.setReplenishMode(Integer.parseInt(String.valueOf(termInfoMap.get("N_REPLENISH_MODE"))));
        return termInfo;
    }

    @RequestMapping(value = "/termInfo/findsimple", method = RequestMethod.POST)
    public TermInfo findTermSimple(){
        TermInfo termInfo = new TermInfo();
        termInfo.setTermNo("0001");
        termInfo.setAddress("惠州");
        termInfo.setReplenishMode(2);
        return termInfo;
    }
}
