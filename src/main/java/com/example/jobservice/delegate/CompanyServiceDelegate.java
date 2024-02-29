package com.example.jobservice.delegate;

import com.example.jobservice.client.CompanyServiceClient;
import com.example.jobservice.exception.DownstreamServiceException;
import com.example.jobservice.exception.ResourceNotFoundException;
import com.example.jobservice.model.Company;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceDelegate {
    private final CompanyServiceClient companyServiceClient;
    public Company getCompanyById(Long companyId){
        ResponseEntity<Company> response;
        try{
            response = companyServiceClient.getCompanyById(companyId);
            return response.getBody();
        }catch (FeignException.NotFound feignNotFoundException){
            throw new ResourceNotFoundException("Company","Company ID", companyId);
        }
        catch (FeignException feignException){
            throw new DownstreamServiceException("Company",feignException.status(),feignException.getMessage());
        }
    }

}
