package ed.coder.after2.service;

import ed.coder.after2.model.*;

import ed.coder.after2.repository.ClienteRepository;
import ed.coder.after2.repository.ProductoRepository;
import ed.coder.after2.repository.VentaProductoRepository;
import ed.coder.after2.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VentaProductoRepository ventaProductoRepository;

    public Venta realizarVenta(Long clienteId, Long productoId, int cantidad) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Venta venta = new Venta();
        venta.setFechaVenta(LocalDate.now());
        venta.setCliente(cliente);
        venta =ventaRepository.save(venta);

        VentaProducto ventaProducto = new VentaProducto();
        ventaProducto.setVenta(venta);
        ventaProducto.setProducto(producto);
        ventaProducto.setCantidad(cantidad);
        ventaProductoRepository.save(ventaProducto);

        List<VentaProducto> ventaProductos = new ArrayList<>();
        ventaProductos.add(ventaProducto);
        venta.setVentaProductos(ventaProductos);

        return ventaRepository.save(venta);
    }

}
