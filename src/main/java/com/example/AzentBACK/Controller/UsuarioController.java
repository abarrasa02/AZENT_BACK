package com.example.AzentBACK.Controller;

import com.example.AzentBACK.DTO.UsuarioDTO;
import com.example.AzentBACK.Provider.UsuarioProvider;
import com.example.AzentBACK.Utils.MessageResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    UsuarioProvider usuarioProvider;

    @PostMapping("/addUsuario")
    public MessageResponseDto<String> addUsuario(@RequestBody UsuarioDTO userDTO){
        try {
            return usuarioProvider.addUsuario(userDTO);
        }catch (Exception e){
            return  MessageResponseDto.fail("Error al guardar el usuario");
        }
    }
}

