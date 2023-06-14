package com.example.AzentBACK.Entity;

import javax.persistence.*;
import javax.persistence.Table;
@Entity
@Table(name = "azento_detallePedidos")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IDPedido", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_DetallesPedidos_Pedidos"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "IDProducto", referencedColumnName = "idProducto", foreignKey = @ForeignKey(name = "FK_DetallesPedidos_Productos"))
    private Producto producto;

    @Column(name = "Cantidad", nullable = false)
    private Integer cantidad;

}
