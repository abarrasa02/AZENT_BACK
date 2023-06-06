package com.example.AzentBACK.ProviderImpl;

import com.example.AzentBACK.Provider.CarritoProvider;
import com.example.AzentBACK.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoProviderImpl implements CarritoProvider {

    @Autowired
    CarritoRepository carritoRepository;
}
