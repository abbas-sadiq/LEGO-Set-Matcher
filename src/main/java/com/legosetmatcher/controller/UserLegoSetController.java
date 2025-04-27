
package com.legosetmatcher.controller;

import com.legosetmatcher.dto.request.AddSetRequest;
import com.legosetmatcher.exception.ApiResponse;
import com.legosetmatcher.model.User;
import com.legosetmatcher.model.UserLegoSet;
import com.legosetmatcher.service.UserLegoSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-sets")
@RequiredArgsConstructor
public class UserLegoSetController {

    private final UserLegoSetService userLegoSetService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserLegoSet>> addSetToUser(
            @RequestBody AddSetRequest request,
            @AuthenticationPrincipal User user) {
        UserLegoSet userLegoSet = userLegoSetService.addSetToUser(user, request.getSetNumber());
        return ResponseEntity.ok(new ApiResponse<>(true, userLegoSet , null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserLegoSet>>> getUserSets(
            @AuthenticationPrincipal User user) {
        List<UserLegoSet> sets = userLegoSetService.getUserSets(user);
        return ResponseEntity.ok(new ApiResponse<>(true, sets, null));
    }
}