package com.example.AzentBACK.Provider;

import com.example.AzentBACK.DTO.UsuarioDTO;
import com.example.AzentBACK.Utils.MessageResponseDto;

public interface UsuarioProvider {

    MessageResponseDto<String> addUsuario(UsuarioDTO userDto);
}
