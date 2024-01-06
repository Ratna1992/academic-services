package com.academics.service;

import com.academics.beans.AcademicsResponse;
import com.academics.beans.Error;
import com.academics.utilities.ErrorCodes;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AcademicsServiceImpl implements  AcademicsService{
    @Override
    public AcademicsResponse getStatus() {
        AcademicsResponse academicsResponse = new AcademicsResponse();
        try{
            academicsResponse.setStatus("200");
            Map<String,String> data = new HashMap<>();
            data.put("institute","Swarnandhara");
            academicsResponse.setData(data);
        }
        catch (Exception e){
            Error error = new Error();
            academicsResponse.setStatus("400");
            error.setMessage(e.getMessage());
            error.setReasonCode(ErrorCodes.ACDERR00001);
            academicsResponse.setError(error);
        }
        return academicsResponse;
    }
}
