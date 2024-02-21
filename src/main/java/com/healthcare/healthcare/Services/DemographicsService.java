package com.healthcare.healthcare.Services;

import com.healthcare.healthcare.Payloads.ResponseDemographics;

public interface DemographicsService {
    public ResponseDemographics getDemographic(int id);
    public ResponseDemographics updateDemographics(ResponseDemographics responseDemographics);
}
