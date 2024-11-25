package com.unla.grupo21.sci.dtos;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetailsDto {
	private LocalDateTime date;
	private String details;
}
