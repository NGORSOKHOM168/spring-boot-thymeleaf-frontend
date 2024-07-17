package com.learning.dto;

import lombok.Builder;

@Builder
public record UserDto(
		String uuid,
		String username,
		String password,
		String displayName,
		String thumnail
		) {

}
