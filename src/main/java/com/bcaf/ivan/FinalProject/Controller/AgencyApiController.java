package com.bcaf.ivan.FinalProject.Controller;

import com.bcaf.ivan.FinalProject.Entity.Agency;
import com.bcaf.ivan.FinalProject.Entity.Bus;
import com.bcaf.ivan.FinalProject.Util.AgencyDao;
import com.bcaf.ivan.FinalProject.Util.BusDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgencyApiController {

    @Autowired
    private AgencyDao agencyDao;


    @PostMapping("/getAgency")
    public String getAgency(HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession(true);
        String agencyId = (String) session.getAttribute("agencyId");
        Agency agency = agencyDao.findById(agencyId).get();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(agency);
        return rs;
    }
    @PostMapping("/updateAgency")
    public String updateAgency(@RequestBody Agency agency, HttpServletRequest request) throws JsonProcessingException {
        agency.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        agencyDao.save(agency);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(agency);
        return rs;
    }
}