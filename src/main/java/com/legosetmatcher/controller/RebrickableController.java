package com.legosetmatcher.controller;

import com.legosetmatcher.dto.LegoSetDto;
import com.legosetmatcher.exception.ApiResponse;
import com.legosetmatcher.exception.ErrorInfo;
import com.legosetmatcher.exception.ApiException;
import com.legosetmatcher.service.RebrickableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RebrickableController {

    private final RebrickableService rebrickableService;

    @Autowired
    public RebrickableController(RebrickableService rebrickableService) {
        this.rebrickableService = rebrickableService;
    }

    @GetMapping("/api/rebrickable/sets/{setNumber}")
    public ResponseEntity<ApiResponse<LegoSetDto>> getSetDetails(@PathVariable String setNumber) {
        try {
            LegoSetDto legoSet = rebrickableService.getSetDetails(setNumber);
            ApiResponse<LegoSetDto> response = new ApiResponse<>(true, legoSet, null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApiException ex) {
            ErrorInfo errorInfo = new ErrorInfo(ex.getErrorInfo().getErrorCode(), ex.getErrorInfo().getErrorMessage());
            ApiResponse<LegoSetDto> response = new ApiResponse<>(false, null, errorInfo);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorInfo errorInfo = new ErrorInfo(500, "Unexpected error occurred: " + ex.getMessage());
            ApiResponse<LegoSetDto> response = new ApiResponse<>(false, null, errorInfo);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
