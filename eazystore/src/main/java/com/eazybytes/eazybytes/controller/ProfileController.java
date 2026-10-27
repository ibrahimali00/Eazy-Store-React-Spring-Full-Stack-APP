package com.eazybytes.eazybytes.controller;

import com.eazybytes.eazybytes.dto.ProfileRequestDto;
import com.eazybytes.eazybytes.dto.ProfileResponseDto;
import com.eazybytes.eazybytes.service.IProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final IProfileService profileService;

    @GetMapping
    public ResponseEntity<ProfileResponseDto> getProfile() {
        ProfileResponseDto responseDto = profileService.getProfile();
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<ProfileResponseDto> updateProfile(@Valid @RequestBody ProfileRequestDto profileRequestDto) {

        ProfileResponseDto responseDto =  profileService.updateProfile(profileRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
