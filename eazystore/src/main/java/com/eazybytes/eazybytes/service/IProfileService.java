package com.eazybytes.eazybytes.service;

import com.eazybytes.eazybytes.dto.ProfileRequestDto;
import com.eazybytes.eazybytes.dto.ProfileResponseDto;

public interface IProfileService {

    ProfileResponseDto getProfile();
    ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto);
}
