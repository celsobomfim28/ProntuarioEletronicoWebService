package com.br.wilton.prontuarioeletronico.Models.DTO;

import com.br.wilton.prontuarioeletronico.Models.Enum.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
