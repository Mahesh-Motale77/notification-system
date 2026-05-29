package com.mahesh.managementapi.service;

import com.mahesh.managementapi.dto.request.PreferenceRequest;
import com.mahesh.managementapi.dto.response.PreferencesListResponse;
import com.mahesh.managementapi.dto.response.PreferencesResponse;

import java.util.List;

public interface PreferencesService {

    PreferencesResponse addPreferences(PreferenceRequest preferenceRequest);

    PreferencesListResponse getPreferences(String userId);
}
