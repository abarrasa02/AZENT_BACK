package com.example.AzentBACK.Entity;


import javax.persistence.*;
import javax.persistence.Table;

import java.util.Date;

@Entity

@Table(name = "azento_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IDUsuario", referencedColumnName = "idUsuario", foreignKey = @ForeignKey(name = "FK_Pedidos_Usuarios"))
    private Usuario usuario;

    @Column(name = "Total", precision = 10, scale = 2, nullable = false)
    private Float total;

    @Column(name = "FechaPedido", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaPedido;
}
